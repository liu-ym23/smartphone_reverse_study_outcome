package wrc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.VariableType;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VariableType f560936b;

    public m(String r100, VariableType r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f560935a = r100;
        this.f560936b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        if (this.f560936b == null) goto L5;
        r101.c(this.f560935a, Float.valueOf(0.0f), this.f560936b);
        return Unit.INSTANCE;
    L5:
        Object r103 = r101.d(this.f560935a);
        if (r103 == null) goto L9;
        return r103;
    L9:
        throw new IllegalStateException(("Undefined variable: " + this.f560935a).toString());
    }
}
