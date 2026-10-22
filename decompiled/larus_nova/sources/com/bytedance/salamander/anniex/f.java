package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnieXSLEngineType f268052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f268053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f268054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f268055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Object> f268056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t0 f268057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g0 f268058h;

    public final t0 a() {
        t0 r100 = this.f268057g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("platformContext");
        return null;
    }

    public f(String r100, String r101, String r102, String r103, Map<String, Object> r104, t0 r105, g0 r106) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "containerId");
        Intrinsics.checkNotNullParameter(r103, "bid");
        Intrinsics.checkNotNullParameter(r104, "globalProps");
        Intrinsics.checkNotNullParameter(r105, "platformContext");
        Intrinsics.checkNotNullParameter(r106, "lynxProps");
        this.f268051a = "default_bid";
        this.f268052b = AnnieXSLEngineType.unknow;
        this.f268053c = "";
        this.f268054d = "";
        this.f268055e = "";
        this.f268053c = r100;
        this.f268055e = r102;
        this.f268051a = r103;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f268056f = r104;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f268057g = r105;
        this.f268052b = b2.f267974c.a(r100);
        this.f268054d = b2.b(r100, "url");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f268058h = r106;
    }
}
