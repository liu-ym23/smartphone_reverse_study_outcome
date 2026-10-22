package wrc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.VariableType;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.y;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class s implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f, io.github.alexzhirkevich.compottie.internal.animation.expressions.l<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VariableType f560943a;

    public s(VariableType r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f560943a = r100;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.l
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(String r100, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r101) {
        if (r100 != null) goto L5;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.f.a.f490821a;
    L5:
        return new m(r100, this.f560943a);
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        return y.f491000a;
    }
}
