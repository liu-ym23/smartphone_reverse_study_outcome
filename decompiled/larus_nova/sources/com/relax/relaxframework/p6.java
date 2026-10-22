package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CSSModifierProperty f405214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6 f405215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RxModifierType f405216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o1 f405217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c2 f405218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BuiltinModifierState f405219f;

    public int c() {
        return -1;
    }

    public final void a() {
        if (this.f405217d == null) goto L6;
        int r100 = com.bytedance.rts.foundation.y.f267598a;
        StringBuilder r101 = new StringBuilder("Applier not nil ");
        o1 r102 = this.f405217d;
        Intrinsics.checkNotNull(r102);
        r101.append(r102.type());
        com.bytedance.rts.foundation.y.a.b(new Object[]{r101.toString()});
        o1 r103 = this.f405217d;
        Intrinsics.checkNotNull(r103);
        r103.a(this);
        return;
    L6:
        int r104 = com.bytedance.rts.foundation.y.f267598a;
        com.bytedance.rts.foundation.y.a.b(new Object[]{"Applier is nil"});
    }

    public final RxModifierType b() {
        RxModifierType r100 = this.f405216c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("_type");
        return null;
    }

    public RxModifierType getType() {
        return b();
    }

    public final void d(BuiltinModifierState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405219f = r100;
    }

    public p6(CSSModifierProperty r100, p6 r101, RxModifierType r102, c2 r103, o1 r104) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405216c = r102;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405214a = r100;
        this.f405215b = r101;
        this.f405218e = r103;
        this.f405217d = r104;
        d(BuiltinModifierState.Init);
    }
}
