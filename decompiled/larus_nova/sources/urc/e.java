package urc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class e implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f551401a;

    public /* synthetic */ e(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        this.f551401a = r100;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f551401a;
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r104 = r103.a(r100, r101, r102);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        return Boolean.valueOf(!((Boolean) r104).booleanValue());
    }
}
