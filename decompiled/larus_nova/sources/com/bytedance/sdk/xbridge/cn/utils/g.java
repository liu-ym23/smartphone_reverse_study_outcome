package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270260a = 0;

    static {
    }

    public static ExecutorService a() {
        XBaseRuntime.f270095a.getClass();
        IHostThreadPoolExecutorDepend r100 = XBaseRuntime.f270109o;
        if (r100 != null) goto L5;
        r100 = new qe7.d();
    L5:
        ExecutorService r101 = r100.getNormalThreadExecutor();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return TTExecutors.getNormalExecutor();
    }

    public static IHostExternalStorageDepend b() {
        XBaseRuntime.f270095a.getClass();
        return XBaseRuntime.f270110p;
    }

    public static IHostNetworkDepend d() {
        XBaseRuntime.f270095a.getClass();
        IHostNetworkDepend r100 = XBaseRuntime.f270104j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new te7.g();
    }

    public static com.bytedance.sdk.xbridge.cn.runtime.depend.f e() {
        XBaseRuntime.f270095a.getClass();
        return XBaseRuntime.f270105k;
    }

    public static IHostNetworkDepend g() {
        XBaseRuntime.f270095a.getClass();
        IHostPureNetworkDepend r100 = XBaseRuntime.f270106l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new te7.g();
    }

    public static IHostLogDepend c(IBDXBridgeContext r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostLogDependV2 r101 = XBaseRuntime.f270118x;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return XBaseRuntime.f270096b;
    }

    public static IHostPermissionDepend f(IBDXBridgeContext r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        return XBaseRuntime.f270107m;
    }

    public static IHostStyleUIDepend h(IBDXBridgeContext r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        return XBaseRuntime.f270101g;
    }
}
