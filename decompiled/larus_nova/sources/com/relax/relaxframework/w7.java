package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class w7 extends c2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y3 f405342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y3 f405343c;

    public final y3 d() {
        y3 r100 = this.f405342b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return null;
    }

    @Override // com.relax.relaxframework.c2
    public void a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        r100.c(b(), d());
    }

    @Override // com.relax.relaxframework.c2
    public void c(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        CSSModifierProperty r101 = b();
        y3 r102 = this.f405343c;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultValue");
        r102 = null;
    L6:
        r100.d(r101, r102);
    }

    public w7(CSSModifierProperty r100, y3 r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        super(r100);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405342b = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405343c = r102;
    }
}
