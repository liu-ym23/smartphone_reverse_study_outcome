package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CSSModifierProperty f405032a;

    public void a(a2 r100) {
        throw null;
    }

    public void c(a2 r100) {
        throw null;
    }

    public final CSSModifierProperty b() {
        CSSModifierProperty r100 = this.f405032a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return null;
    }

    public c2(CSSModifierProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405032a = r100;
    }
}
