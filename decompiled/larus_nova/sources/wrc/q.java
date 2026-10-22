package wrc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class q implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560942b;

    public q(io.github.alexzhirkevich.compottie.internal.animation.expressions.l r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f560941a = r100;
        this.f560942b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f560941a.a(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type io.github.alexzhirkevich.compottie.internal.animation.RawProperty<*>");
        final k2<? extends Object> r104 = (k2) r103;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105 = this.f560942b;
        if (r105 == null) goto L11;
        Object r106 = r105.a(r104, r101, r102);
        if ((r106 instanceof Number) == false) goto L10;
        return r102.e(((Number) r106).floatValue(), new p(r104));
    L10:
        throw new IllegalArgumentException(("Internal error. Unable to cast " + r106 + " to Number").toString());
    L11:
        return r.a(r104.d(r102));
    }
}
