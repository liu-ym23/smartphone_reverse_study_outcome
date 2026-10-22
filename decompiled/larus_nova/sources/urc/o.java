package urc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f551421a;

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        return this.f551421a.a(r100, r101, r102);
    }

    public o(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f551421a = r100;
    }
}
