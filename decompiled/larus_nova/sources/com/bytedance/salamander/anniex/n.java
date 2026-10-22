package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f268246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f268247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Object> f268248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t0 f268249e;

    public final t0 a() {
        t0 r100 = this.f268249e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("platformContext");
        return null;
    }

    public n(String r100, Map<String, Object> r101, t0 r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "globalProps");
        Intrinsics.checkNotNullParameter(r102, "platformContext");
        this.f268245a = "default";
        this.f268246b = "";
        this.f268247c = "";
        this.f268247c = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f268248d = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f268249e = r102;
    }
}
