package wrc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.VariableType;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VariableType f560914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Object, Object, Object> f560917d;

    public final VariableType getType() {
        return this.f560914a;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f560916c.a(r100, r101, r102);
        Object r104 = r101.d(this.f560915b);
        Function2<Object, Object, Object> r105 = this.f560917d;
        if (r105 == null) goto L7;
        if (r104 != null) goto L7;
        boolean r106 = false;
    L8:
        if (r106 == false) goto L15;
        if (r104 == null) goto L12;
        if (r105 == null) goto L12;
        r103 = r105.invoke(r104, r103);
    L12:
        r101.c(this.f560915b, r103, this.f560914a);
        return r103;
    L15:
        throw new IllegalStateException(("Cant modify " + this.f560915b + " as it is undefined").toString());
    L7:
        r106 = true;
        goto L8
    }

    public a(VariableType r100, String r101, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102, Function2<Object, Object, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "variableName");
        Intrinsics.checkNotNullParameter(r102, "assignableValue");
        this.f560914a = r100;
        this.f560915b = r101;
        this.f560916c = r102;
        this.f560917d = r103;
    }
}
