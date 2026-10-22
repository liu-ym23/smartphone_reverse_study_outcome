package com.bytedance.ee.lark.nativecomponent.core.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f242822f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f242823g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f242824h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f242825i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f242826j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f242827k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f242828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f242829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f242830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f242831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f242832e;

    public static final class a {
    }

    static {
        f242822f = new c(1000000, 1000000, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        new c(2000201, 2000201, "can not find webview");
        f242823g = new c(2000202, 2000202, "can not find component manager");
        new c(2000203, 2000203, "init component error");
        f242824h = new c(2000204, 2000204, "can not find render");
        f242825i = new c(2000205, 2000205, "biz error, can not get component view");
        f242826j = new c(2000206, 2000206, "render error");
        f242827k = new c(2000207, 2000207, "can not find native component in webview");
        new c(2000501, 2000501, "permission denied");
        new c(2000502, 2000502, "permission error");
        new c(2000601, 2000601, "component business error");
    }

    public c(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.f242828a = r100;
        this.f242829b = r101;
        this.f242830c = r102;
        this.f242831d = null;
        this.f242832e = null;
    }
}
