package wrc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.y;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class n implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560938b;

    public n(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        Intrinsics.checkNotNullParameter(r100, "variable");
        Intrinsics.checkNotNullParameter(r101, "index");
        this.f560937a = r100;
        this.f560938b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f560937a.a(r100, r101, r102);
        Object r104 = this.f560938b.a(r100, r101, r102);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        Object r105 = qrc.e.b(r103, ((Number) r104).intValue());
        if (r105 == null) goto L5;
        return r105;
    L5:
        return y.f491000a;
    }
}
