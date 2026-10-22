package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import swb.n;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f411274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f411275b = null;

    public a() {
    }

    static {
        f411274a = new a();
        f411275b = new ConcurrentHashMap();
    }

    public static VFSFile a(ChameleonConfig r100, Context r101) {
        VFSFiles.f444819b.getClass();
        boolean r102 = true;
        h r103 = VFSFiles.b(true);
        String r104 = c.c(r100).getVfsPath().getRealPath();
        StringBuilder r105 = new StringBuilder(n.a(r101));
        r105.append("-");
        if (r100 == null) goto L8;
        ResConfig r106 = r100.getResConfig();
        if (r106 == null) goto L8;
        String r107 = r106.getOfflineZipName();
        if (r107 == null) goto L8;
    L9:
        r105.append(r107);
        VFSFile r108 = r103.v(r104, r105.toString());
        File r109 = r108.getParentFile();
        if (r109 != null) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == true) goto L19;
        File r110 = r108.getParentFile();
        if (r110 == null) goto L19;
        r110.mkdirs();
    L19:
        return r108;
    L12:
        if (r109.exists() != true) goto L14;
    L8:
        r107 = "";
        goto L9
    }

    public static b b(ChameleonConfig r110, Context r111) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r110 == null) goto L56;
        String r100 = r110.getBizName();
        if (r100 == null) goto L56;
        String r101 = ThreadMethodProxy.currentThread().getName();
        if (r110.getResConfig() != null) goto L10;
        j.e(ChameleonAssertResManager.TAG, "getResInfo, chameleonConfig resConfig is null, return");
        return new b(0);
    L10:
        f411274a.getClass();
        VFSFile r102 = a(r110, r111);
        String r103 = null;
        if (r102.exists() == false) goto L18;
        ConcurrentHashMap<String, b> r112 = f411275b;
        b r104 = r112.get(r100);
        if (r104 == null) goto L15;
        r103 = r104.f411277b;
    L15:
        if (r103 != null) goto L60;
        int r105 = c.f411278a;
        b r106 = c.h(r110, r102.getAbsolutePath());
        r112.put(r100, r106);
        return r106;
    L60:
        return r104;
    L18:
        j.e(ChameleonAssertResManager.TAG, "getResInfo: bizName is " + r100 + " local asset not exist,begin copy thread:" + r101);
        monitor-enter(a.class);
    L52:
        th = move-exception;
        throw th;
    L21:
        if (r102.exists() == false) goto L29;
        ConcurrentHashMap<String, b> r113 = f411275b;     // Catch: Throwable -> L52
        b r107 = r113.get(r100);     // Catch: Throwable -> L52
        if (r107 == null) goto L25;
        r103 = r107.f411277b;     // Catch: Throwable -> L52
    L25:
        if (r103 != null) goto L27;
        int r108 = c.f411278a;     // Catch: Throwable -> L52
        r107 = c.h(r110, r102.getAbsolutePath());     // Catch: Throwable -> L52
        r113.put(r100, r107);     // Catch: Throwable -> L52
    L27:
        monitor-exit(a.class);
        return r107;
    L29:
        VFSFiles.f444819b.getClass();     // Catch: Throwable -> L52
        h r109 = VFSFiles.b(true);     // Catch: Throwable -> L52
        String r114 = c.c(r110).getVfsPath().getRealPath();     // Catch: Throwable -> L52
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L52
        r115.append(System.currentTimeMillis());     // Catch: Throwable -> L52
        ResConfig r116 = r110.getResConfig();     // Catch: Throwable -> L52
        if (r116 == null) goto L32;
        r103 = r116.getOfflineZipName();     // Catch: Throwable -> L52
    L32:
        r115.append(r103);     // Catch: Throwable -> L52
        VFSFile r117 = r109.v(r114, r115.toString());     // Catch: Throwable -> L52
        j.e(ChameleonAssertResManager.TAG, "getResInfo: clean directory thread:" + r101);     // Catch: IOException -> L35 Throwable -> L52
        swb.j.b(r117.getVfsPath().getParent());     // Catch: IOException -> L35 Throwable -> L52
    L37:
        ResConfig r118 = r110.getResConfig();     // Catch: Throwable -> L52
        if (r118 == null) goto L41;
        String r119 = r118.getOfflineZipName();     // Catch: Throwable -> L52
        if (r119 == null) goto L41;
    L43:
        if (swb.j.d(r111, r119, r117.getAbsolutePath()) == true) goto L45;
    L49:
        r117.deleteOnExit();     // Catch: Throwable -> L52
        j.e(ChameleonAssertResManager.TAG, "getResInfo: asset copy to local fails thread:" + r101);     // Catch: Throwable -> L52
        b r120 = new b(0);     // Catch: Throwable -> L52
        monitor-exit(a.class);
        return r120;
    L45:
        if (r117.exists() == false) goto L49;
        r117.renameTo(r102);     // Catch: Throwable -> L52
        j.e(ChameleonAssertResManager.TAG, "getResInfo: rename to :" + r102.getAbsolutePath() + " thread:" + r101);     // Catch: Throwable -> L52
        int r121 = c.f411278a;     // Catch: Throwable -> L52
        b r122 = c.h(r110, r102.getAbsolutePath());     // Catch: Throwable -> L52
        f411275b.put(r100, r122);     // Catch: Throwable -> L52
        monitor-exit(a.class);
        return r122;
    L41:
        r119 = "";
        goto L43
    L35:
        e = move-exception;
        j.b(ChameleonAssertResManager.TAG, r101 + " => getResInfo: clean directory fails : " + e);     // Catch: Throwable -> L52
    L56:
        return new b(0);
    }
}
