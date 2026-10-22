package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class q7 extends c2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends y3> f405236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y3 f405237c;

    @Override // com.relax.relaxframework.c2
    public void a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        CSSModifierProperty r101 = b();
        Function0<? extends y3> r102 = this.f405236b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("value");
        r102 = null;
    L6:
        r100.c(r101, r102.invoke());
    }

    @Override // com.relax.relaxframework.c2
    public void c(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        CSSModifierProperty r101 = b();
        y3 r102 = this.f405237c;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultValue");
        r102 = null;
    L6:
        r100.d(r101, r102);
    }

    public q7(CSSModifierProperty r100, Function0<? extends y3> r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        super(r100);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405236b = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405237c = r102;
    }
}
