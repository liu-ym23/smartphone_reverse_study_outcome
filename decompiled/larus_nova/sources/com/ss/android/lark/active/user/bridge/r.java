package com.ss.android.lark.active.user.bridge;

/* JADX INFO: loaded from: classes34.dex */
public final class r<Param, Resp> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f408585c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f408586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<? extends e<Param, Resp>> f408587b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return "userid=" + this.f408586a + ", clazz=" + this.f408587b.getName() + ", makeUserOnline=false";
    }

    public r(String r100, Class r101) {
        this.f408586a = r100;
        this.f408587b = r101;
    }
}
