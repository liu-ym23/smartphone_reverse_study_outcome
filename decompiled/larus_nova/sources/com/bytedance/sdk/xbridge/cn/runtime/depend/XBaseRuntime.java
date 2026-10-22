package com.bytedance.sdk.xbridge.cn.runtime.depend;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
public final class XBaseRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final XBaseRuntime f270095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IHostLogDepend f270096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IHostMediaDepend f270097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IHostMediaDependV2 f270098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IHostOpenDepend f270099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static IHostContextDepend f270100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static IHostStyleUIDepend f270101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static IHostRouterDepend f270102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static IHostUserDepend f270103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IHostNetworkDepend f270104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static f f270105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static IHostPureNetworkDepend f270106l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static IHostPermissionDepend f270107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static IHostLocationPermissionDepend f270108n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static IHostThreadPoolExecutorDepend f270109o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static IHostExternalStorageDepend f270110p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static g f270111q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static IHostHeadSetDepend f270112r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static IHostALogDepend f270113s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static IHostMemoryWaringDepend f270114t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static d f270115u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static e f270116v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static IHostCalendarDepend f270117w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static IHostLogDependV2 f270118x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f270119y = null;

    public XBaseRuntime() {
    }

    static {
        f270095a = new XBaseRuntime();
        f270119y = LazyKt.lazy(XBaseRuntime$defaultScreenCaptureDepend$2.INSTANCE);
    }

    public static qe7.e a() {
        return (qe7.e) f270119y.getValue();
    }
}
