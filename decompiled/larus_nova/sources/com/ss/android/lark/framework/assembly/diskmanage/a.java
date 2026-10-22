package com.ss.android.lark.framework.assembly.diskmanage;

import android.app.Application;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.utils.statistics.PerfLog;
import ebb.f;
import ebb.g;
import ebb.h;
import ebb.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Set<f>> f425629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f425630b;

    /* JADX INFO: renamed from: com.ss.android.lark.framework.assembly.diskmanage.a$a, reason: collision with other inner class name */
    public static final class C5030a {
    }

    static {
    }

    @Override // ebb.g
    public final void b() {
    }

    @Override // ebb.g
    public final Biz getBiz() {
        return Biz.DEFAULT;
    }

    public static cbb.a c(ArrayList r100) {
        Iterator r101 = r100.iterator();
        long r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L7;
        File r103 = (File) r101.next();
        r102 = r102 + r103.length();
        FileUtils.g(r103.getPath());
        goto L4
    L7:
        return new cbb.a(true, r102, 4);
    }

    @Override // ebb.g
    public final cbb.a a(cbb.d r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteConfig");
        Application r101 = LarkContext.getApplication();
        new j().b(r101, j.c(r100.f23127b));     // Catch: Exception -> L5
    L8:
        if (this.f425630b.a() == false) goto L15;
        Log.w("DefaultCleanTask", "disk space is low, use manual clean");
        Application r102 = LarkContext.getApplication();
        HashSet r103 = new HashSet();
        Object r104 = ebb.e.f471981a;
        int r105 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNull(r102);
        r103.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.i(r102), 1));
        r103.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.m(r102), 1));
        r103.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.d(r102), 0));
        r103.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.r(r102), 0));
        r103.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.b(r102), 0));
        r103.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.n(r102), 3));
        r103.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.o(r102), 3));
        r103.addAll(ebb.e.d(a0.f(r102), 3));
        Iterator<T> r106 = this.f425629a.get().iterator();
    L11:
        if (r106.hasNext() == false) goto L14;
        r103.addAll(((f) r106.next()).b(r102));
        goto L11
    L14:
        return c(new ArrayList(r103));
    L15:
        Application r107 = LarkContext.getApplication();
        ArrayList r108 = new ArrayList();
        eac.a r109 = eac.a.a();
        float r110 = 1.0f;
        if (r109.getBoolean("small_disk_on", false) == false) goto L18;
        r110 = r109.getFloat("disk_timeout_factor", 1.0f);
    L18:
        int r111 = (int) (2 * r110);
        Object r112 = ebb.e.f471981a;
        int r113 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNull(r107);
        r108.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.r(r107), r111));
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r114 = com.ss.android.lark.diskmanage.storage.d.i(r107) + "/zip/";
        FileUtils.t(r114);
        r108.addAll(ebb.e.d(r114, r111));
        int r115 = (int) (7 * r110);
        r108.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.n(r107), r115));
        r108.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.o(r107), r115));
        int r116 = (int) (6 * r110);
        r108.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.i(r107), r116));
        r108.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.m(r107), r116));
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r117 = new StringBuilder();
        r117.append(l.b(r107));
        String r118 = File.separator;
        r117.append(r118);
        r117.append("camera");
        r117.append(r118);
        String r119 = r117.toString();
        FileUtils.t(r119);
        r108.addAll(ebb.e.d(r119, r116));
        r108.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.e(r107), r116));
        r108.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.a(r107), r116));
        r108.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.d(r107), r116));
        r108.addAll(ebb.e.d(a0.f(r107), r116));
        Iterator<T> r120 = this.f425629a.get().iterator();
    L20:
        if (r120.hasNext() == false) goto L22;
        r108.addAll(((f) r120.next()).a(r107));
        goto L20
    L22:
        int r121 = ebb.b.f471973c;
        ebb.b r122 = ebb.b.C5764b.f471976a;
        monitor-enter(r122);
        ArrayList r123 = new ArrayList();     // Catch: Throwable -> L38
        Iterator<g> r124 = r122.f471974a.values().iterator();     // Catch: Throwable -> L38
    L26:
        if (r124.hasNext() == false) goto L31;
        g r125 = r124.next();     // Catch: Throwable -> L38
        if (r125.getBiz() == Biz.DEFAULT) goto L26;
        r125.b();     // Catch: Throwable -> L38
        goto L26
    L31:
        monitor-exit(r122);
        Iterator r126 = r123.iterator();
    L34:
        if (r126.hasNext() == false) goto L37;
        cbb.b r127 = (cbb.b) r126.next();
        Object r128 = ebb.e.f471981a;
        r108.addAll(ebb.e.d(r127.f23118a, (int) (r127.f23119b * r110)));
        goto L34
    L37:
        return c(r108);
    L38:
        th = move-exception;
        throw th;
    L5:
        e = move-exception;
        Log.i("RemoteDeleteHandler", "handleRemoteDelete error");
        e.printStackTrace();
        goto L8
    }

    @Inject
    public a(Provider<Set<f>> r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "cleanFileProvider");
        Intrinsics.checkNotNullParameter(r101, "manuDiskCleanTrigger");
        this.f425629a = r100;
        this.f425630b = r101;
    }
}
