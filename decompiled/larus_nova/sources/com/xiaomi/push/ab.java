package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public class ab {
    public static boolean a(Context r100, String r101, long r102) {
        FileLock r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getFilesDir(), "/.vdevdir/");     // Catch: Throwable -> L17 IOException -> L19
        if (u.m9432a(r104) == true) goto L7;
        v.a(null);
        return true;
    L7:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, "lcfp.lock");     // Catch: Throwable -> L17 IOException -> L19
        v.m9433a(r105);     // Catch: Throwable -> L17 IOException -> L19
        RandomAccessFile r106 = new RandomAccessFile(r105, "rw");     // Catch: Throwable -> L17 IOException -> L19
        r103 = r106.getChannel().lock();     // Catch: IOException -> L15 Throwable -> L28
        boolean r107 = b(r100, r101, r102);     // Catch: IOException -> L15 Throwable -> L28
        if (r103 != null) goto L11;
    L13:
        v.a(r106);
        return r107;
    L11:
        if (r103.isValid() == false) goto L13;
        r103.release();     // Catch: IOException -> L35
    L15:
        e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L28
        if (r103 != null) goto L24;
    L26:
        v.a(r106);
        return true;
    L24:
        if (r103.isValid() == false) goto L26;
        r103.release();     // Catch: IOException -> L36
    L28:
        th = th;
    L29:
        if (r103 != null) goto L31;
    L33:
        v.a(r106);
        throw th;
    L31:
        if (r103.isValid() == false) goto L33;
        r103.release();     // Catch: IOException -> L37
        goto L33
    L19:
        e = e;
        r106 = null;
    L17:
        th = th;
        r106 = null;
        goto L29
    }

    private static boolean b(Context r110, String r111, long r112) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.getFilesDir(), "/.vdevdir/");
        if (u.m9432a(r100) == true) goto L5;
        return true;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "lcfp");
        ArrayList r102 = new ArrayList();
        long r103 = System.currentTimeMillis();
        String r104 = r111 + ":" + r110.getPackageName() + "," + r103;
        if (r101.exists() == false) goto L37;
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r101));     // Catch: Throwable -> L27 Exception -> L29
    L62:
        String r113 = r105.readLine();     // Catch: Exception -> L61 Throwable -> L32
        if (r113 == null) goto L31;
        String[] r114 = r113.split(":");     // Catch: Exception -> L61 Throwable -> L32
        if (r114.length != 2) goto L62;
        if (TextUtils.equals(r114[0], String.valueOf(r111)) == true) goto L15;
        r102.add(r113);     // Catch: Exception -> L61 Throwable -> L32
        goto L62
    L15:
        String[] r115 = r114[1].split(",");     // Catch: Exception -> L61 Throwable -> L32
        if (r115.length != 2) goto L62;
        long r116 = Long.parseLong(r115[1]);     // Catch: Exception -> L61 Throwable -> L32
        if (TextUtils.equals(r115[0], r110.getPackageName()) == true) goto L62;
        if (Math.abs(r103 - r116) >= ((1000 * r112) * 0.9f)) goto L62;
        v.a(r105);
        return false;
    L31:
        v.a(r105);
    L39:
        r102.add(r104);
        BufferedWriter r106 = new BufferedWriter(new PolarisFileWriterWrapper(r101));     // Catch: Throwable -> L51 IOException -> L53
    L71:
        Iterator r107 = r102.iterator();     // Catch: Throwable -> L47 IOException -> L49
    L43:
        if (r107.hasNext() == false) goto L46;
        r106.write((String) r107.next());     // Catch: Throwable -> L47 IOException -> L49
        r106.newLine();     // Catch: Throwable -> L47 IOException -> L49
        r106.flush();     // Catch: Throwable -> L47 IOException -> L49
    L46:
        v.a(r106);
    L57:
        return true;
    L49:
        e = e;
        BufferedWriter r117 = r106;
    L64:
        com.xiaomi.channel.commonutils.logger.b.d(e.toString());     // Catch: Throwable -> L58
        v.a(r117);
    L58:
        th = th;
    L59:
        v.a(r117);
        throw th;
    L47:
        th = th;
        r117 = r106;
    L53:
        e = e;
        r117 = null;
    L51:
        th = th;
        r117 = null;
    L32:
        th = th;
        BufferedReader r118 = r105;
    L34:
        v.a(r118);
        throw th;
    L30:
        r102.clear();     // Catch: Throwable -> L32
        goto L31
    L29:
        r105 = null;
    L27:
        th = th;
        r118 = null;
        goto L34
    L37:
        if (v.m9433a(r101) == true) goto L39;
        return true;
    }
}
