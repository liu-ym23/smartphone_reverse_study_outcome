package com.ss.android.medialib;

import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes38.dex */
public class FileUtils {
    private static final String DEFAULT_FOLDER_NAME = "BDMedia";
    protected static String msFolderPath;

    public FileUtils() {
    }

    public static boolean isSdcardWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    L4:
        return false;
    }

    public static boolean checkFileExists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r100).exists();
    }

    public static File createFile(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L15;
        if (r101 == true) goto L18;
        r102.mkdirs();
        goto L15
    L18:
        File r103 = r102.getParentFile();     // Catch: IOException -> L13
        if (r103.exists() == true) goto L11;
        r103.mkdirs();     // Catch: IOException -> L13
    L11:
        r102.createNewFile();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        return r102;
    L16:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r11v22, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static boolean fileChannelCopy(String r110, String r111) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        PolarisFileInputStreamWrapper r100 = null;
        FileChannel r101 = null;
        r101 = null;
        r101 = null;
        r100 = null;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L50 IOException -> L53 FileNotFoundException -> L78
        r110 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L41 IOException -> L44 FileNotFoundException -> L47
    L163:
        r111 = r104.getChannel();     // Catch: Throwable -> L35 IOException -> L37 FileNotFoundException -> L39
        r101 = r110.getChannel();     // Catch: Throwable -> L29 IOException -> L31 FileNotFoundException -> L33
        r111.transferTo(0, r111.size(), r101);     // Catch: Throwable -> L29 IOException -> L31 FileNotFoundException -> L33
        r104.close();     // Catch: IOException -> L12
    L131:
        r111.close();     // Catch: IOException -> L16
    L125:
        r110.close();     // Catch: IOException -> L20
    L22:
        if (r101 == null) goto L167;
        r101.close();     // Catch: IOException -> L25
        return true;
    L25:
        e = move-exception;
        e.printStackTrace();
        return true;
    L167:
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L131
    L33:
        e = e;
        FileChannel r105 = r101;
        r102 = r104;
        ?? r112 = r110;
        ?? r113 = r111;
    L81:
        e.printStackTrace();     // Catch: Throwable -> L103
        if (r102 != null) goto L127;
    L87:
        if (r113 != 0) goto L139;
    L92:
        if (r112 != 0) goto L133;
    L97:
        if (r105 != null) goto L145;
    L102:
        return false;
    L145:
        r105.close();     // Catch: IOException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L102
    L133:
        r112.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
        goto L97
    L139:
        r113.close();     // Catch: IOException -> L90
    L90:
        e = move-exception;
        e.printStackTrace();
        goto L92
    L127:
        r102.close();     // Catch: IOException -> L85
    L85:
        e = move-exception;
        e.printStackTrace();
    L31:
        e = e;
        FileChannel r106 = r101;
        r103 = r104;
        ?? r114 = r110;
        ?? r115 = r111;
    L56:
        e.printStackTrace();     // Catch: Throwable -> L103
        if (r103 != null) goto L135;
    L62:
        if (r115 != 0) goto L147;
    L67:
        if (r114 != 0) goto L143;
    L72:
        if (r106 != null) goto L153;
    L77:
        return false;
    L153:
        r106.close();     // Catch: IOException -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L143:
        r114.close();     // Catch: IOException -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
        goto L72
    L147:
        r115.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L67
    L135:
        r103.close();     // Catch: IOException -> L60
    L60:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = th;
        ?? r107 = r101;
        r100 = r104;
    L104:
        if (r100 != null) goto L156;
    L109:
        if (r111 != 0) goto L149;
    L114:
        if (r110 != 0) goto L129;
    L119:
        if (r107 == 0) goto L165;
        r107.close();     // Catch: IOException -> L122
        throw th;
    L122:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L165:
        throw th;
    L129:
        r110.close();     // Catch: IOException -> L117
    L117:
        e = move-exception;
        e.printStackTrace();
        goto L119
    L149:
        r111.close();     // Catch: IOException -> L112
    L112:
        e = move-exception;
        e.printStackTrace();
        goto L114
    L156:
        r100.close();     // Catch: IOException -> L107
    L107:
        e = move-exception;
        e.printStackTrace();
        goto L109
    L39:
        e = e;
        FileChannel r116 = null;
        ?? r117 = r110;
    L49:
        r102 = r104;
        ?? r118 = r117;
        FileChannel r119 = r116;
    L80:
        r105 = r119;
        r112 = r118;
        r113 = r119;
    L37:
        e = e;
        FileChannel r120 = null;
        ?? r121 = r110;
    L46:
        r103 = r104;
        ?? r122 = r121;
        FileChannel r123 = r120;
    L55:
        r106 = r123;
        r114 = r122;
        r115 = r123;
    L35:
        th = th;
        Object r124 = null;
        ?? r125 = r110;
    L43:
        r100 = r104;
        r110 = r125;
        r111 = r124;
    L52:
        r107 = r111;
    L47:
        e = e;
        r117 = 0;
        r116 = null;
    L44:
        e = e;
        r121 = 0;
        r120 = null;
    L41:
        th = th;
        r125 = 0;
        r124 = null;
        goto L43
    L103:
        th = th;
    L78:
        e = e;
        r118 = 0;
        r119 = null;
    L53:
        e = e;
        r122 = 0;
        r123 = null;
    L50:
        th = th;
        r110 = 0;
        r111 = 0;
        goto L52
    }
}
