package com.bytedance.mira.modifyres;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FileUtils;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class ApkModifyUtils {
    public static final int RESULT_FAILED = 300;
    public static final int RESULT_SKIP = 200;
    public static final int RESULT_SUCCESS = 100;

    public ApkModifyUtils() {
    }

    private int findEndOfCentralPosition(ByteBuffer r100) {
        int r101 = r100.capacity();
        if (r101 >= 22) goto L5;
        return -1;
    L5:
        int r102 = r101 - 22;
        int r103 = Math.min(r102, 65535);
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L13;
        int r105 = r102 - r104;
        if (r100.getInt(r105) != 101010256) goto L12;
        if (r100.getShort(r105 + 20) != r104) goto L12;
        return r105;
    L12:
        r104 = r104 + 1;
        goto L6
    L13:
        return -1;
    }

    public MappedByteBuffer mappedByteBuffer(File r110) throws IOException {
        RandomAccessFile r100 = null;
        RandomAccessFile r101 = new RandomAccessFile(r110, "rw");     // Catch: Throwable -> L15
        FileChannel r102 = r101.getChannel();     // Catch: Throwable -> L13
        long r103 = r102.size();     // Catch: Throwable -> L13
        MappedByteBuffer r111 = r102.map(FileChannel.MapMode.READ_WRITE, 0, r103);     // Catch: Throwable -> L13
        byte[] r104 = new byte[4194304];     // Catch: Throwable -> L13
        long r105 = 4194304;
        long r106 = r103 / r105;     // Catch: Throwable -> L13
        int r107 = (int) (r103 % r105);     // Catch: Throwable -> L13
        int r108 = 0;
    L6:
        if (r108 >= r106) goto L8;
        r111.get(r104);     // Catch: Throwable -> L13
        r108 = r108 + 1;     // Catch: Throwable -> L13
        goto L6
    L8:
        if (r107 <= 0) goto L10;
        r111.get(new byte[r107]);     // Catch: Throwable -> L13
    L10:
        r111.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L13
        r101.close();
        return r111;
    L13:
        th = th;
        r100 = r101;
    L16:
        if (r100 == null) goto L18;
        r100.close();
    L18:
        throw th;
    L15:
        th = th;
        goto L16
    }

    private static Duo<Integer, byte[]> getUnCompressFileContentBytes(MappedByteBuffer r100, int r101, String r102) {
        if (r100.getInt(r101) != 67324752) goto L14;
        int r103 = r100.getInt(r101 + 18);
        int r104 = r100.getInt(r101 + 22);
        if (r103 != r104) goto L12;
        byte[] r105 = new byte[r104];
        short r106 = r100.getShort(r101 + 26);
        int r107 = ((r101 + 30) + r106) + r100.getShort(r101 + 28);
        int r108 = 0;
    L7:
        if (r108 >= r104) goto L10;
        r105[r108] = r100.get(r107 + r108);
        r108 = r108 + 1;
        goto L7
    L10:
        return new Duo(Integer.valueOf(r107), r105);
    L12:
        throw new RuntimeException(r102 + " is compressed. compressSize:" + r103 + " size:" + r104);
    L14:
        throw new RuntimeException("Expected: 0x04034b50, got: " + r100.getInt(r101) + " FileName:" + r102);
    }

    private void realModifyRes(File r110, HashSet<String> r111, IResIdMapper r112) throws Throwable {
        MappedByteBuffer r113 = mappedByteBuffer(r110);
        int r100 = findEndOfCentralPosition(r113);
        if (r100 == (-1)) goto L29;
        int r101 = r113.getInt(r100 + 12);
        int r102 = r113.getInt(r100 + 16);
        int r103 = r101 + r102;
    L5:
        if (r102 >= r103) goto L27;
        if (r113.getInt(r102) != 33639248) goto L26;
        int r104 = r113.getShort(r102 + 28);
        short r105 = r113.getShort(r102 + 30);
        byte[] r106 = new byte[r104];
        int r107 = 0;
        int r108 = 0;
    L9:
        if (r108 >= r104) goto L11;
        r106[r108] = r113.get((r102 + 46) + r108);
        r108 = r108 + 1;
        goto L9
    L11:
        String r109 = new String(r106);
        int r114 = r113.getInt(r102 + 20);
        int r115 = r113.getInt(r102 + 24);
        if (r111.contains(r109) == false) goto L24;
        if (r114 != r115) goto L23;
        Duo<Integer, byte[]> r116 = getUnCompressFileContentBytes(r113, r113.getInt(r102 + 42), r109);
        ResReplaceUtils.replaceResId(r109, r116.second, r112);     // Catch: Throwable -> L19
    L17:
        if (r107 >= r116.second.length) goto L24;
        r113.put(r116.first.intValue() + r107, r116.second[r107]);
        r107 = r107 + 1;
    L19:
        th = move-exception;
        throw new RuntimeException(th);
    L23:
        throw new Throwable(r109.concat(" is compressed."));
    L24:
        r102 = r102 + ((r104 + 46) + r105);
        goto L5
    L26:
        throw new RuntimeException("Expected: 0x02014b50, got: " + r113.getInt(r102));
    L27:
        return;
    L29:
        throw new Throwable("endOfCentralPosition == -1");
    }

    public int modifyRes(File r110, boolean r210, StringBuilder r211) {
        r211.append("apkFile is exists:");
        r211.append(r110.exists());
        r211.append("\n");
        r211.append("canRead:");
        r211.append(r110.canRead());
        r211.append("\n");
        r211.append("canWrite:");
        r211.append(r110.canWrite());
        r211.append("\n");
        PolarisZipFileWrapper r100 = null;
        boolean r101 = true;
    L83:
        th = th;
    L120:
        r211.append("modifyRes failed. catch: ");     // Catch: Throwable -> L95
        r211.append(Log.getStackTraceString(th));     // Catch: Throwable -> L95
        if (r101 == false) goto L88;
    L92:
        if (r100 != null) goto L118;
    L94:
        return 300;
    L118:
        r100.close();     // Catch: IOException -> L109
        goto L94
    L88:
        if (r110.exists() == false) goto L92;
        if (r110.canWrite() == false) goto L92;
        r110.setWritable(false, false);
    L95:
        th = move-exception;
        if (r101 == false) goto L98;
    L102:
        if (r100 != null) goto L122;
    L104:
        throw th;
    L122:
        r100.close();     // Catch: IOException -> L110
        goto L104
    L98:
        if (r110.exists() == false) goto L102;
        if (r110.canWrite() == false) goto L102;
        r110.setWritable(false, false);
        goto L102
    L4:
        if (r110.exists() == false) goto L11;
        if (r110.canWrite() == true) goto L11;
        r110.setWritable(true, false);     // Catch: Throwable -> L9
        r211.append("modifyWrite:");     // Catch: Throwable -> L9
        r211.append(r110.canWrite());     // Catch: Throwable -> L9
        r211.append("\n");     // Catch: Throwable -> L9
        boolean r102 = false;
    L112:
        PolarisZipFileWrapper r103 = new PolarisZipFileWrapper(r110);     // Catch: Throwable -> L81
        ZipEntry r104 = r103.getEntry("assets/MiraResMapping");     // Catch: Throwable -> L78
        if (r104 != null) goto L25;
        if (r102 == false) goto L17;
    L124:
        r103.close();     // Catch: IOException -> L105
        return 200;
    L138:
        return 200;
    L17:
        if (r110.exists() == false) goto L124;
        if (r110.canWrite() == false) goto L124;
        r110.setWritable(false, false);
        goto L124
    L25:
        if (r210 == false) goto L38;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r110.getParentFile(), "resMappingBak");     // Catch: Throwable -> L78
        if (r105.exists() == false) goto L29;
        String r106 = FileUtils.readText(r105);     // Catch: Throwable -> L78
    L40:
        if (TextUtils.isEmpty(r106) == false) goto L50;
        r211.append("resMappingContent isEmpty. useBakFile:");     // Catch: Throwable -> L78
        r211.append(r210);     // Catch: Throwable -> L78
        if (r102 == false) goto L44;
    L116:
        r103.close();     // Catch: IOException -> L106
    L49:
        return 300;
    L44:
        if (r110.exists() == false) goto L116;
        if (r110.canWrite() == false) goto L116;
        r110.setWritable(false, false);
        goto L116
    L50:
        JSONObject r107 = new JSONObject(r106);     // Catch: Throwable -> L78
        JSONObject r111 = new JSONObject(r106);     // Catch: Throwable -> L78
        JSONArray r108 = (JSONArray) r107.get("fileNames");     // Catch: Throwable -> L78
        final HashSet<String> r112 = new HashSet();     // Catch: Throwable -> L78
        int r113 = 0;
    L52:
        if (r113 >= r108.length()) goto L54;
        r112.add((String) r108.get(r113));     // Catch: Throwable -> L78
        r113 = r113 + 1;     // Catch: Throwable -> L78
        goto L52
    L54:
        final JSONObject r114 = (JSONObject) r107.get("resMapping");     // Catch: Throwable -> L78
        final JSONObject r109 = (JSONObject) r111.get("resMapping");     // Catch: Throwable -> L78
        final int[] r115 = {0};     // Catch: Throwable -> L78
        realModifyRes(r110, r112, new AnonymousClass1(this, r114, r109, r115, r112));     // Catch: Throwable -> L76
        MiraLogger.d(MiraLogger.TAG_INSTALL, "modifyRes count = " + r115[0]);     // Catch: Throwable -> L76
        if (FileUtils.writeText(r111.toString(), new PolarisFileWrapper(r110.getParentFile(), "resMappingBak"), r211) == false) goto L67;
        if (r102 == false) goto L60;
    L132:
        r103.close();     // Catch: IOException -> L107
        return 100;
    L139:
        return 100;
    L60:
        if (r110.exists() == false) goto L132;
        if (r110.canWrite() == false) goto L132;
        r110.setWritable(false, false);
        goto L132
    L67:
        r211.append("writeText failed.");     // Catch: Throwable -> L76
        if (r102 == false) goto L70;
    L134:
        r103.close();     // Catch: IOException -> L108
    L75:
        return 300;
    L70:
        if (r110.exists() == false) goto L134;
        if (r110.canWrite() == false) goto L134;
        r110.setWritable(false, false);
    L76:
        th = th;
    L80:
        r101 = r102;
        r100 = r103;
        goto L120
    L29:
        r211.append("resMappingBakFile is not exists. ");     // Catch: Throwable -> L78
        r211.append(r105.getAbsolutePath());     // Catch: Throwable -> L78
        if (r102 == false) goto L32;
    L126:
        r103.close();     // Catch: IOException -> L111
    L37:
        return 300;
    L32:
        if (r110.exists() == false) goto L126;
        if (r110.canWrite() == false) goto L126;
        r110.setWritable(false, false);
        goto L126
    L38:
        ByteArrayOutputStream r116 = new ByteArrayOutputStream();     // Catch: Throwable -> L78
        IOUtils.copyStream(r103.getInputStream(r104), r116);     // Catch: Throwable -> L78
        r106 = r116.toString();     // Catch: Throwable -> L78
    L78:
        th = th;
    L81:
        th = th;
        r101 = r102;
    L9:
        th = th;
        r101 = false;
    L11:
        r102 = true;
        goto L112
    }
}
