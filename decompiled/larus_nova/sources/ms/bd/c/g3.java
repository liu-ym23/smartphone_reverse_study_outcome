package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g3 {
    public static void a(Context r110, String r111) {
        Os.setenv("28d7fdd567361198183fa7b8e", "a7", true);     // Catch: Exception -> L5
    L6:
        i3 r100 = new i3();
        if (r110 == null) goto L138;
        if (r111 == null) goto L136;
        if (r111.length() == 0) goto L136;
        Locale r101 = Locale.US;
        if (r100.f515164a.contains(r111) == true) goto L175;
        r100.f515165b.getClass();     // Catch: UnsatisfiedLinkError -> L16
        i3.a(r111);     // Catch: UnsatisfiedLinkError -> L16
        r100.f515164a.add(r111);     // Catch: UnsatisfiedLinkError -> L16
        return;
    L16:
        e = move-exception;
        Log.getStackTraceString(e);
        Locale r102 = Locale.US;
        r100.f515165b.getClass();
        if (r111.startsWith("lib") == true) goto L20;
    L22:
        String r103 = System.mapLibraryName(r111);
    L23:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r110.getDir("lib", 0), r103);
        if (r104.exists() == true) goto L118;
        File r105 = r110.getDir("lib", 0);
        r100.f515165b.getClass();
        if (r111.startsWith("lib") == true) goto L29;
    L31:
        String r106 = System.mapLibraryName(r111);
    L32:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r110.getDir("lib", 0), r106);
        r100.f515165b.getClass();
        if (r111.startsWith("lib") == true) goto L35;
    L37:
        String r108 = System.mapLibraryName(r111);
    L38:
        File[] r109 = r105.listFiles(new h3(r108));
        if (r109 == null) goto L47;
        int r112 = r109.length;
        int r113 = 0;
    L42:
        if (r113 >= r112) goto L47;
        File r114 = r109[r113];
        if (r114.getAbsolutePath().equals(r107.getAbsolutePath()) == true) goto L46;
        r114.delete();
    L46:
        r113 = r113 + 1;
    L47:
        h r115 = r100.f515166c;
        r100.f515165b.getClass();
        String[] r116 = Build.SUPPORTED_ABIS;
        if (r116.length > 0) goto L57;
        String r117 = Build.CPU_ABI2;
        if (r117 != null) goto L53;
    L56:
        r116 = new String[]{Build.CPU_ABI};
        goto L57
    L53:
        if (r117.length() == 0) goto L56;
        r116 = new String[]{Build.CPU_ABI, r117};
    L57:
        r100.f515165b.getClass();
        if (r111.startsWith("lib") == true) goto L60;
    L62:
        String r118 = System.mapLibraryName(r111);
    L63:
        r115.getClass();
        g r119 = null;
        PolarisFileOutputStreamWrapper r120 = null;
        InputStream r121 = null;
        g r122 = h.a(r110, r116, r118, r100);     // Catch: Throwable -> L129
        if (r122 == null) goto L151;
        int r123 = 0;
    L67:
        int r124 = r123 + 1;
        if (r123 >= 5) goto L115;
        Locale r125 = Locale.US;     // Catch: Throwable -> L122
        if (r104.exists() == true) goto L163;
        if (r104.createNewFile() == false) goto L114;
    L163:
        InputStream r126 = r122.f515141a.getInputStream(r122.f515142b);     // Catch: Throwable -> L104 Throwable -> L108
        PolarisFileOutputStreamWrapper r127 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L102 Throwable -> L140
    L100:
        Throwable th10 = th;
        r120 = r127;
    L103:
        PolarisFileOutputStreamWrapper r128 = r120;
        r121 = r126;
        PolarisFileOutputStreamWrapper r129 = r128;
    L106:
        h.b(r121);     // Catch: Throwable -> L122
        h.b(r129);     // Catch: Throwable -> L122
        throw th10;     // Catch: Throwable -> L122
    L78:
        if (r104.getPath().contains("../") == false) goto L86;
        System.currentTimeMillis();     // Catch: Throwable -> L100 Throwable -> L139
        goto L110
    L80:
        h.b(r126);     // Catch: Throwable -> L122
        h.b(r127);     // Catch: Throwable -> L122
        ZipFile r130 = r122.f515141a;     // Catch: IOException -> L142
        if (r130 == null) goto L158;
        r130.close();     // Catch: IOException -> L142
    L158:
        goto L118
    L86:
        byte[] r131 = new byte[4096];     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        long r132 = 0;
    L87:
        int r133 = r126.read(r131);     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        if (r133 == (-1)) goto L89;
        r127.write(r131, 0, r133);     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        r132 = r132 + ((long) r133);
        goto L87
    L89:
        r127.flush();     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        r127.getFD().sync();     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        if (r132 == r104.length()) goto L93;
        h.b(r126);     // Catch: Throwable -> L122
    L111:
        h.b(r127);     // Catch: Throwable -> L122
        goto L114
    L93:
        h.b(r126);     // Catch: Throwable -> L122
        h.b(r127);     // Catch: Throwable -> L122
        r104.setReadable(true, false);     // Catch: Throwable -> L122
        r104.setExecutable(true, false);     // Catch: Throwable -> L122
        r104.setWritable(true);     // Catch: Throwable -> L122
        ZipFile r134 = r122.f515141a;     // Catch: IOException -> L142
        if (r134 == null) goto L158;
        r134.close();     // Catch: IOException -> L142
    L110:
        h.b(r126);     // Catch: Throwable -> L122
        goto L111
    L102:
        th10 = th;
    L109:
        r127 = null;
        goto L110
    L108:
        r126 = null;
    L104:
        th = move-exception;
        th10 = th;
        r129 = null;
    L114:
        r123 = r124;
        goto L67
    L115:
        ZipFile r135 = r122.f515141a;     // Catch: IOException -> L142
        if (r135 == null) goto L158;
        r135.close();     // Catch: IOException -> L142
        goto L158
    L151:
        String[] r136 = h.c(r110, r118);     // Catch: Throwable -> L122 Exception -> L124
    L127:
        throw new r2(r118, r116, r136);     // Catch: Throwable -> L122
    L124:
        e = move-exception;
        r136 = new String[]{e.toString()};     // Catch: Throwable -> L122
    L122:
        th = th;
        r119 = r122;
    L130:
        if (r119 != null) goto L149;
    L134:
        throw th;
    L149:
        ZipFile r137 = r119.f515141a;     // Catch: IOException -> L141
        if (r137 == null) goto L134;
        r137.close();     // Catch: IOException -> L141
    L129:
        th = th;
        goto L130
    L60:
        if (r111.endsWith(".so") == false) goto L62;
        r118 = r111;
        goto L63
    L35:
        if (r111.endsWith(".so") == false) goto L37;
        r108 = r111;
        goto L38
    L29:
        if (r111.endsWith(".so") == false) goto L31;
        r106 = r111;
    L118:
        c4 r138 = r100.f515165b;
        String r139 = r104.getAbsolutePath();
        r138.getClass();
        System.load(r139);
        r100.f515164a.add(r111);
        Locale r140 = Locale.US;
        return;
    L20:
        if (r111.endsWith(".so") == false) goto L22;
        r103 = r111;
        goto L23
    L175:
        return;
    L136:
        throw new IllegalArgumentException("Given library is either null or empty");
    L138:
        throw new IllegalArgumentException("Given context is null");
    }
}
