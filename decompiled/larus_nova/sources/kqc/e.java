package kqc;

import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static void b(PolarisFileWrapper r110, HashSet r111, d r112) throws Throwable {
        RandomAccessFile r100 = new RandomAccessFile(r110, "rw");     // Catch: Throwable -> L62
        FileChannel r101 = r100.getChannel();     // Catch: Throwable -> L60
        long r102 = r101.size();     // Catch: Throwable -> L60
        MappedByteBuffer r113 = r101.map(FileChannel.MapMode.READ_WRITE, 0, r102);     // Catch: Throwable -> L60
        byte[] r103 = new byte[4194304];     // Catch: Throwable -> L60
        long r104 = 4194304;
        long r105 = r102 / r104;     // Catch: Throwable -> L60
        int r106 = (int) (r102 % r104);     // Catch: Throwable -> L60
        int r107 = 0;
    L5:
        if (r107 >= r105) goto L7;
        r113.get(r103);     // Catch: Throwable -> L60
        r107 = r107 + 1;     // Catch: Throwable -> L60
        goto L5
    L7:
        if (r106 <= 0) goto L9;
        r113.get(new byte[r106]);     // Catch: Throwable -> L60
    L9:
        r113.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L60
        r100.close();
        int r108 = r113.capacity();
        if (r108 < 22) goto L21;
        int r109 = r108 - 22;
        int r114 = Math.min(r109, 65535);
        int r115 = 0;
    L14:
        if (r115 >= r114) goto L21;
        int r116 = r109 - r115;
        if (r113.getInt(r116) != 101010256) goto L20;
        if (r113.getShort(r116 + 20) != r115) goto L20;
    L22:
        if (r116 == (-1)) goto L59;
        int r117 = r113.getInt(r116 + 12);
        int r118 = r113.getInt(r116 + 16);
        int r119 = r117 + r118;
    L24:
        if (r118 >= r119) goto L57;
        if (r113.getInt(r118) != 33639248) goto L56;
        int r120 = r113.getShort(r118 + 28);
        short r121 = r113.getShort(r118 + 30);
        byte[] r122 = new byte[r120];
        int r123 = 0;
    L28:
        if (r123 >= r120) goto L30;
        r122[r123] = r113.get((r118 + 46) + r123);
        r123 = r123 + 1;
        goto L28
    L30:
        String r124 = new String(r122);
        int r125 = r113.getInt(r118 + 20);
        int r126 = r113.getInt(r118 + 24);
        if (r111.contains(r124) == false) goto L54;
        if (r125 != r126) goto L53;
        int r127 = r113.getInt(r118 + 42);
        if (r113.getInt(r127) != 67324752) goto L51;
        int r128 = r113.getInt(r127 + 18);
        int r129 = r113.getInt(r127 + 22);
        if (r128 != r129) goto L49;
        byte[] r130 = new byte[r129];
        short r131 = r113.getShort(r127 + 26);
        int r132 = ((r127 + 30) + r131) + r113.getShort(r127 + 28);
        int r133 = 0;
    L38:
        if (r133 >= r129) goto L40;
        r130[r133] = r113.get(r132 + r133);
        r133 = r133 + 1;
        goto L38
    L40:
        Integer r134 = Integer.valueOf(r132);
        m.d(r124, r130, r112);     // Catch: Throwable -> L45
        int r135 = 0;
    L43:
        if (r135 >= r129) goto L54;
        r113.put(r134.intValue() + r135, r130[r135]);
        r135 = r135 + 1;
    L45:
        th = move-exception;
        throw new RuntimeException(th);
    L49:
        throw new RuntimeException(r124 + " is compressed. compressSize:" + r128 + " size:" + r129);
    L51:
        throw new RuntimeException("Expected: 0x04034b50, got: " + r113.getInt(r127) + " FileName:" + r124);
    L53:
        throw new Throwable(r124.concat(" is compressed."));
    L54:
        r118 = r118 + ((r120 + 46) + r121);
        goto L24
    L56:
        throw new RuntimeException("Expected: 0x02014b50, got: " + r113.getInt(r118));
    L57:
        return;
    L59:
        throw new Throwable("endOfCentralPosition == -1");
    L20:
        r115 = r115 + 1;
    L21:
        r116 = -1;
    L60:
        th = th;
    L64:
        if (r100 == null) goto L66;
        r100.close();
    L66:
        throw th;
    L62:
        th = th;
        r100 = null;
        goto L64
    }

    public static int a(PolarisFileWrapper r110, boolean r210, StringBuilder r211, Function0 r212) {
        PolarisZipFileWrapper r100 = new PolarisZipFileWrapper(r110);     // Catch: Throwable -> L57
        ZipEntry r111 = r100.getEntry("assets/ZeusResMapping");     // Catch: Throwable -> L55
        if (r111 != null) goto L9;
        mqc.i.b(r100);
        return 200;
    L9:
        if (r210 == false) goto L16;
        PolarisFileWrapper r112 = new PolarisFileWrapper(r110.getParentFile(), "resMappingBak");     // Catch: Throwable -> L55
        if (r112.exists() == false) goto L13;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r112);     // Catch: Throwable -> L55
        FileChannel r113 = r101.getChannel();     // Catch: Throwable -> L55
        String r114 = Charset.defaultCharset().newDecoder().decode(r113.map(FileChannel.MapMode.READ_ONLY, 0, r113.size()).asReadOnlyBuffer()).toString();     // Catch: Throwable -> L55
        r113.close();     // Catch: Throwable -> L55
        r101.close();     // Catch: Throwable -> L55
    L29:
        if (TextUtils.isEmpty(r114) == false) goto L33;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:" + r210);     // Catch: Throwable -> L55
        r211.append("zeusResMappingContent isEmpty. useBakFile:");     // Catch: Throwable -> L55
        r211.append(r210);     // Catch: Throwable -> L55
        mqc.i.b(r100);
        return 300;
    L33:
        JSONObject r102 = new JSONObject(r114);     // Catch: Throwable -> L55
        JSONObject r103 = new JSONObject(r114);     // Catch: Throwable -> L55
        JSONArray r115 = (JSONArray) r102.get("fileNames");     // Catch: Throwable -> L55
        HashSet r116 = new HashSet();     // Catch: Throwable -> L55
        boolean r117 = false;
        int r118 = 0;
    L35:
        if (r118 >= r115.length()) goto L37;
        r116.add((String) r115.get(r118));     // Catch: Throwable -> L55
        r118 = r118 + 1;     // Catch: Throwable -> L55
        goto L35
    L37:
        JSONObject r119 = (JSONObject) r102.get("resMapping");     // Catch: Throwable -> L55
        JSONObject r104 = (JSONObject) r103.get("resMapping");     // Catch: Throwable -> L55
        int[] r120 = {0};     // Catch: Throwable -> L55
        Resources r121 = (Resources) r212.invoke();     // Catch: Throwable -> L55
        if (r110.canWrite() == false) goto L40;
    L44:
        b(r110, r116, new d(r119, r121, r104, r120, r116));     // Catch: Throwable -> L55
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + r120[0]);     // Catch: Throwable -> L55
        String r105 = r103.toString();     // Catch: Throwable -> L55
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r110.getParentFile(), "resMappingBak"));     // Catch: IOException -> L47 Throwable -> L55
        FileChannel r107 = r106.getChannel();     // Catch: IOException -> L47 Throwable -> L55
        r107.write(ByteBuffer.wrap(r105.getBytes()));     // Catch: IOException -> L47 Throwable -> L55
        r107.close();     // Catch: IOException -> L47 Throwable -> L55
        r106.close();     // Catch: IOException -> L47 Throwable -> L55
        r117 = true;
    L49:
        if (r117 == false) goto L52;
        mqc.i.b(r100);
        return 100;
    L52:
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + r211.toString());     // Catch: Throwable -> L55
        r211.append("writeText failed.");     // Catch: Throwable -> L55
        mqc.i.b(r100);
        return 300;
    L47:
        e = move-exception;
        r211.append(e.getMessage());     // Catch: Throwable -> L55
        goto L49
    L40:
        if (r110.setWritable(true, true) == true) goto L44;
        r211.append("apkFile setWritable failed. ");     // Catch: Throwable -> L55
        r211.append(r110.getAbsolutePath());     // Catch: Throwable -> L55
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "apkFile setWritable failed. apkPath:" + r110);     // Catch: Throwable -> L55
        mqc.i.b(r100);
        return 300;
    L13:
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + r112.getAbsolutePath());     // Catch: Throwable -> L55
        r211.append("resMappingBakFile is not exists. ");     // Catch: Throwable -> L55
        r211.append(r112.getAbsolutePath());     // Catch: Throwable -> L55
        mqc.i.b(r100);
        return 300;
    L16:
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L55
        InputStream r122 = r100.getInputStream(r111);     // Catch: Throwable -> L55
        if (r122 == null) goto L27;
        ReadableByteChannel r123 = Channels.newChannel(r122);     // Catch: Throwable -> L55
        WritableByteChannel r124 = Channels.newChannel(r108);     // Catch: Throwable -> L55
        ByteBuffer r125 = ByteBuffer.allocateDirect(4096);     // Catch: Throwable -> L55
    L20:
        if (r123.read(r125) == (-1)) goto L26;
        r125.flip();     // Catch: Throwable -> L55
    L23:
        if (r125.hasRemaining() == false) goto L25;
        r124.write(r125);     // Catch: Throwable -> L55
        goto L23
    L25:
        r125.clear();     // Catch: Throwable -> L55
        goto L20
    L26:
        r123.close();     // Catch: Throwable -> L55
        r124.close();     // Catch: Throwable -> L55
    L27:
        r114 = r108.toString();     // Catch: Throwable -> L55
    L55:
        th = th;
    L72:
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage());     // Catch: Throwable -> L63
        r211.append("modifyRes failed. catch: ");     // Catch: Throwable -> L63
        r211.append(th.getMessage());     // Catch: Throwable -> L63
        if (r100 == null) goto L62;
        mqc.i.b(r100);
    L62:
        return 300;
    L63:
        th = move-exception;
        if (r100 == null) goto L66;
        mqc.i.b(r100);
    L66:
        throw th;
    L57:
        th = th;
        r100 = null;
        goto L72
    }
}
