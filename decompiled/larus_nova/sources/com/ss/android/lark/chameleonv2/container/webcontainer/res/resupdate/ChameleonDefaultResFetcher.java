package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.h;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import swb.m;

/* JADX INFO: loaded from: classes35.dex */
public final class ChameleonDefaultResFetcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f411272b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, VFSPath> f411273a;

    public static final class a {
    }

    static {
    }

    public ChameleonDefaultResFetcher() {
        this.f411273a = new ConcurrentHashMap();
    }

    public final VFSPath a(ChameleonConfig r110, Context r111, String r112) {
        String r100 = null;
        if (r110 == null) goto L5;
        String r101 = r110.getBizName();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        ConcurrentHashMap<String, VFSPath> r102 = this.f411273a;
        if (r110 == null) goto L11;
        String r103 = r110.getBizName();
    L12:
        VFSPath r104 = r102.get(r103);
        if (r104 == null) goto L18;
        StringBuilder r113 = new StringBuilder("getResource from memory cache, ChameleonId is ");
        if (r110 == null) goto L17;
        r100 = r110.getBizName();
    L17:
        r113.append(r100);
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, r113.toString());
        return r104;
    L18:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChameleonDefaultResFetcher$asyncGetResource$1(this, r110, r111, r112, null), 2, null);
        return null;
    L11:
        r103 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final VFSPath b(ChameleonConfig r210, Context r211, String r212) {
        StringBuilder r100 = new StringBuilder("getResourceInternal ChameleonId is ");
        if (r210 == null) goto L5;
        String r101 = r210.getBizName();
    L6:
        r100.append(r101);
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, r100.toString());
        if (r211 != null) goto L9;
        return null;
    L9:
        if (r210 == null) goto L12;
        String r102 = r210.getBizName();
        if (r102 == null) goto L12;
    L14:
        monitor-enter(ChameleonDefaultResFetcher.class);
        if (r210 != null) goto L107;
    L20:
        String r103 = "";
    L21:
        VFSFile r104 = c.i(r210, r102);     // Catch: Throwable -> L95
        VFSFiles.f444819b.getClass();     // Catch: Throwable -> L95
        boolean r105 = true;
        VFSFile r106 = VFSFiles.b(true).D(r104, r103);     // Catch: Throwable -> L95
        h r110 = VFSFiles.b(true);     // Catch: Throwable -> L95
        if (r210 == null) goto L31;
        ResConfig r111 = r210.getResConfig();     // Catch: Throwable -> L95
        if (r111 == null) goto L31;
        String r112 = r111.getOfflineZipName();     // Catch: Throwable -> L95
        if (r112 == null) goto L31;
        List r113 = StringsKt.split$default(r112, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L95
        if (r113 == null) goto L31;
        String r114 = (String) r113.get(0);     // Catch: Throwable -> L95
        if (r114 == null) goto L31;
    L32:
        VFSPath r115 = r110.H(r106, r114);     // Catch: Throwable -> L95
        String r116 = c.e(r115);     // Catch: Throwable -> L95
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): path " + r115.getRealPath() + "  localVersion: " + r116 + "  assetVersion: " + r103);     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r103) == false) goto L35;
    L39:
        VFSFile r107 = c.c(r210);     // Catch: Throwable -> L95
        if (r107.isDirectory() == false) goto L45;
        VFSFile[] r108 = r107.listFiles();     // Catch: Throwable -> L95
        int r117 = r108.length;     // Catch: Throwable -> L95
        int r118 = 0;
    L42:
        if (r118 >= r117) goto L45;
        swb.j.g(r108[r118].getVfsPath());     // Catch: Throwable -> L95
        r118 = r118 + 1;     // Catch: Throwable -> L95
    L45:
        if (r104.isDirectory() == false) goto L49;
        VFSFile[] r109 = r104.listFiles();     // Catch: Throwable -> L95
        int r119 = r109.length;     // Catch: Throwable -> L95
        int r120 = 0;
    L47:
        if (r120 >= r119) goto L49;
        swb.j.g(r109[r120].getVfsPath());     // Catch: Throwable -> L95
        r120 = r120 + 1;     // Catch: Throwable -> L95
    L49:
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.f411274a.getClass();     // Catch: Throwable -> L95
        b r121 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.b(r210, r211);     // Catch: Throwable -> L95
        if (r121 != null) goto L52;
    L59:
        boolean r122 = false;
    L60:
        if (r122 == false) goto L65;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResourceInternal resInfo is null, return");     // Catch: Throwable -> L95
        monitor-exit(ChameleonDefaultResFetcher.class);
    L99:
        return null;
    L65:
        if (r106.exists() == true) goto L83;
        u1b.a.C7822a r123 = u1b.a.a(r212);     // Catch: Throwable -> L95
        if (r123 == null) goto L69;
        u1b.a.C7822a.e(r123, ChameleonOpenTracker.Stage.UNZIP);     // Catch: Throwable -> L95
    L69:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResourceInternal clearOldResource");     // Catch: Throwable -> L95
        VFSFile r124 = VFSFiles.b(true).D(r104, r103 + '_' + System.currentTimeMillis() + "__temp");     // Catch: Throwable -> L95
        r124.mkdir();     // Catch: Throwable -> L95
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L95
        Intrinsics.checkNotNullParameter(r124, "destFile");     // Catch: Throwable -> L95
        j.e(ChameleonAssertResManager.TAG, "extractSimAssetToLocal: begin extract local assets");     // Catch: Throwable -> L95
        if (m.a(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.a(r210, r211).getAbsolutePath(), r124.getAbsolutePath()) == 0) goto L73;
        r105 = false;
    L73:
        if (r105 == true) goto L77;
        monitor-exit(ChameleonDefaultResFetcher.class);
        goto L99
    L77:
        if (r106.exists() == false) goto L79;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): destParentFile exists() after unzip delete temp file");     // Catch: Throwable -> L95
        swb.j.g(r124.getVfsPath());     // Catch: Throwable -> L95
    L80:
        u1b.a.C7822a r125 = u1b.a.a(r212);     // Catch: Throwable -> L95
        if (r125 == null) goto L84;
        r125.c(ChameleonOpenTracker.Stage.UNZIP, System.currentTimeMillis());     // Catch: Throwable -> L95
    L84:
        if (r210 == null) goto L93;
        String r126 = r210.getBizName();     // Catch: Throwable -> L95
        if (r126 == null) goto L93;
        VFSPath r127 = this.f411273a.put(r126, r115);     // Catch: Throwable -> L90
    L90:
        th = th;
    L105:
        j.c(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "Chameleon getResourceInternal(): failed ", th);     // Catch: Throwable -> L100
        monitor-exit(ChameleonDefaultResFetcher.class);
    L100:
        th = move-exception;
        throw th;
    L93:
        monitor-exit(ChameleonDefaultResFetcher.class);
        return r115;
    L79:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): rename result = " + r124.renameTo(r106));     // Catch: Throwable -> L95
        goto L80
    L83:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): destParentFile exists()");     // Catch: Throwable -> L95
        goto L84
    L52:
        if (TextUtils.isEmpty(r121.f411276a) == true) goto L54;
    L56:
        boolean r128 = false;
    L57:
        if (r128 != true) goto L59;
        r122 = true;
        goto L60
    L54:
        if (TextUtils.isEmpty(r121.f411277b) == false) goto L56;
        r128 = true;
        goto L57
    L35:
        if (TextUtils.isEmpty(r116) == true) goto L39;
        if (TextUtils.equals(r103, r116) == false) goto L39;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): assetVersion == localVersion");     // Catch: Throwable -> L95
    L31:
        r114 = "";
        goto L32
    L107:
        ResConfig r129 = r210.getResConfig();     // Catch: Throwable -> L95
        if (r129 == null) goto L20;
        r103 = r129.getResVersion();     // Catch: Throwable -> L95
        if (r103 != null) goto L21;
    L95:
        th = th;
    L12:
        r102 = ChameleonChannel.DEFAULT_CHANNEL.getValue();
        goto L14
    L5:
        r101 = null;
        goto L6
    }
}
