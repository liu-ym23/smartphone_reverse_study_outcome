package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class OpTemporalWiggle implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, Long> f490954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Object> f490955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, Object> f490956h;

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(final k2<? extends Object> r100, final io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f490953e;
        if (r103 == null) goto L7;
        Object r104 = r103.a(r100, r101, r102);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        return r102.e(((Number) r104).floatValue(), new f(this, r100, r101));
    L7:
        return c(r100, r101, r102);
    }

    public final Object c(k2<? extends Object> r110, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r111, prc.f r112) {
        int r100 = OpWiggle.f490957j;
        OpTemporalWiggle$wiggle$1 r101 = new OpTemporalWiggle$wiggle$1(vrc.c.f556947a);
        Object r102 = this.f490949a.a(r110, r111, r112);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Number");
        float r103 = ((Number) r102).floatValue();
        Object r104 = this.f490950b.a(r110, r111, r112);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        float r105 = ((Number) r104).floatValue();
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r106 = this.f490951c;
        if (r106 == null) goto L5;
        Object r107 = r106.a(r110, r111, r112);
    L6:
        Number r108 = (Number) r107;
        if (r108 == null) goto L9;
        Integer r109 = Integer.valueOf(r108.intValue());
    L10:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r113 = this.f490952d;
        if (r113 == null) goto L13;
        Object r114 = r113.a(r110, r111, r112);
    L14:
        Number r115 = (Number) r114;
        if (r115 == null) goto L17;
        Float r116 = Float.valueOf(r115.floatValue());
    L18:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r117 = this.f490953e;
        if (r117 == null) goto L21;
        Object r118 = r117.a(r110, r111, r112);
    L23:
        if ((r118 instanceof Number) == false) goto L25;
        Number r119 = (Number) r118;
    L26:
        if (r119 == null) goto L28;
        Float r120 = Float.valueOf(r119.floatValue());
    L30:
        return OpWiggle.a.a(r101, r103, r105, r109, r116, r120, r112, this.f490954f, this.f490955g, this.f490956h);
    L28:
        r120 = null;
        goto L30
    L25:
        r119 = null;
        goto L26
    L21:
        r118 = null;
        goto L23
    L17:
        r116 = null;
        goto L18
    L13:
        r114 = null;
        goto L14
    L9:
        r109 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    public OpTemporalWiggle(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104) {
        Intrinsics.checkNotNullParameter(r100, "freq");
        Intrinsics.checkNotNullParameter(r101, "amp");
        this.f490949a = r100;
        this.f490950b = r101;
        this.f490951c = r102;
        this.f490952d = r103;
        this.f490953e = r104;
        this.f490954f = new LinkedHashMap();
        this.f490955g = new LinkedHashMap();
        this.f490956h = new LinkedHashMap();
    }
}
