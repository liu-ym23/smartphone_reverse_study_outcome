package urc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.y;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f551414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.github.alexzhirkevich.compottie.internal.animation.expressions.f f551415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.github.alexzhirkevich.compottie.internal.animation.expressions.f f551416c;

    public k() {
        this(null, 7);
    }

    public k(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = wrc.i.a(Boolean.TRUE);
    L5:
        Intrinsics.checkNotNullParameter(r100, "condition");
        this.f551414a = r100;
        this.f551415b = null;
        this.f551416c = null;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f551414a.a(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) r103).booleanValue() == false) goto L5;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104 = this.f551415b;
    L6:
        if (r104 == null) goto L9;
        r104.a(r100, r101, r102);
    L9:
        return y.f491000a;
    L5:
        r104 = this.f551416c;
        goto L6
    }
}
