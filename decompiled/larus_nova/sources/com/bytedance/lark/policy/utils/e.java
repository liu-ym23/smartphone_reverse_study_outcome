package com.bytedance.lark.policy.utils;

import com.bytedance.lark.policy.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f253887a = 0;

    static {
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        ke6.d.f503032a.getClass();
        p r102 = ke6.d.f503034c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r102 = null;
    L5:
        ne6.d r103 = r102.f253859d;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getJSONObject(r100, r101);
    }

    public static Object b(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        ke6.d.f503032a.getClass();
        p r102 = ke6.d.f503034c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r102 = null;
    L5:
        ne6.d r103 = r102.f253860e;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getJSONObject(r100, r101);
    }

    public static void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "any");
        ke6.d.f503032a.getClass();
        p r102 = ke6.d.f503034c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r102 = null;
    L5:
        ne6.d r103 = r102.f253859d;
        if (r103 == null) goto L9;
        r103.putJSONObject(r100, r101);
        return;
    }

    public static void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "any");
        ke6.d.f503032a.getClass();
        p r102 = ke6.d.f503034c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r102 = null;
    L5:
        ne6.d r103 = r102.f253860e;
        if (r103 == null) goto L9;
        r103.putJSONObject(r100, r101);
        return;
    }
}
