package urc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.y;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<io.github.alexzhirkevich.compottie.internal.animation.expressions.f> f551396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551397b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "expressions");
        this.f551396a = r100;
        this.f551397b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(final k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, final prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        if (this.f551397b == false) goto L6;
        Function1<? super io.github.alexzhirkevich.compottie.internal.animation.expressions.e, ? extends Object> r103 = new b(this, r100, r102);
        return r101.b(MapsKt.emptyMap(), r103);
    L6:
        return c(r100, r101, r102);
    }

    public final Object c(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        if (this.f551396a.isEmpty() == false) goto L7;
        return y.f491000a;
    L7:
        if (this.f551396a.size() <= 1) goto L15;
        int r103 = this.f551396a.size() - 1;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) ListProtector.get(this.f551396a, r104);
        Object r106 = r105.a(r100, r101, r102);
        if ((r105 instanceof o) == true) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return r106;
    L15:
        return ((io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.last(this.f551396a)).a(r100, r101, r102);
    }
}
