package com.xiaomi.push;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f464138a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private RandomAccessFile f975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private FileLock f977a;

    static {
        f464138a = Collections.synchronizedSet(new HashSet());
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f977a);
        FileLock r100 = this.f977a;
        if (r100 != null) goto L5;
    L8:
        RandomAccessFile r101 = this.f975a;
        if (r101 == null) goto L11;
        v.a(r101);
    L11:
        f464138a.remove(this.f976a);
        return;
    L5:
        if (r100.isValid() == false) goto L8;
        this.f977a.release();     // Catch: IOException -> L13
    L7:
        this.f977a = null;
        goto L8
    }

    private s(Context r100) {
        this.f974a = r100;
    }

    public static s a(Context r100, File r101) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + r101.getAbsolutePath());
        String r102 = r101.getAbsolutePath() + ".LOCK";
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == true) goto L5;
        r103.getParentFile().mkdirs();
        r103.createNewFile();
    L5:
        Set<String> r104 = f464138a;
        if (r104.add(r102) == false) goto L25;
        s r105 = new s(r100);
        r105.f976a = r102;
        RandomAccessFile r106 = new RandomAccessFile(r103, "rw");     // Catch: Throwable -> L16
        r105.f975a = r106;     // Catch: Throwable -> L16
        r105.f977a = r106.getChannel().lock();     // Catch: Throwable -> L16
        com.xiaomi.channel.commonutils.logger.b.c("Locked: " + r102 + HTTP.HEADER_LINE_DELIM + r105.f977a);     // Catch: Throwable -> L16
        if (r105.f977a != null) goto L15;
        RandomAccessFile r107 = r105.f975a;
        if (r107 == null) goto L14;
        v.a(r107);
    L14:
        r104.remove(r105.f976a);
    L15:
        return r105;
    L16:
        th = move-exception;
        if (r105.f977a != null) goto L23;
        RandomAccessFile r108 = r105.f975a;
        if (r108 == null) goto L22;
        v.a(r108);
    L22:
        f464138a.remove(r105.f976a);
    L23:
        throw th;
    L25:
        throw new IOException("abtain lock failure");
    }
}
