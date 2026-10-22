package wrc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.VariableType;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.y;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VariableType f560919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f560921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Object, Object, Object> f560922e;

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
    L3:
        Object r103 = this.f560921d.a(r100, r101, r102);
        Object r104 = r101.d(this.f560918a);
        if (this.f560922e == null) goto L8;
        if (r104 != null) goto L8;
        boolean r105 = false;
    L9:
        if (r105 == false) goto L38;
        if (r104 == null) goto L11;
        Object r106 = this.f560920c.a(r100, r101, r102);
        if ((r106 instanceof Number) == false) goto L15;
        Number r107 = (Number) r106;
    L16:
        if (r107 == null) goto L36;
        int r108 = r107.intValue();
        if (TypeIntrinsics.isMutableList(r104) == true) goto L19;
        if ((r104 instanceof List) == false) goto L34;
        r101.c(this.f560918a, CollectionsKt.toMutableList((Collection) r104), this.f560919b);
        goto L3
    L34:
        throw new IllegalStateException(("Can't assign '" + r104 + "' by index (" + r108 + ')').toString());
    L19:
        TypeIntrinsics.asMutableList(r104);
    L20:
        List r109 = (List) r104;
        if (CollectionsKt.getLastIndex(r109) >= r108) goto L23;
        r109.add(y.f491000a);
        goto L20
    L23:
        Object r110 = ListProtector.get(r109, r108);
        if ((ListProtector.get(r109, r108) instanceof y) == true) goto L28;
        Function2<Object, Object, Object> r111 = this.f560922e;
        if (r111 == null) goto L28;
        r103 = r111.invoke(r110, r103);
    L28:
        ListProtector.set(r109, r108, r103);
        return y.f491000a;
    L36:
        throw new IllegalStateException(("Unexpected index: " + r106).toString());
    L15:
        r107 = null;
        goto L16
    L11:
        r101.c(this.f560918a, new ArrayList(), this.f560919b);
        goto L3
    L38:
        throw new IllegalStateException(("Cant modify " + this.f560918a + " as it is undefined").toString());
    L8:
        r105 = true;
        goto L9
    }

    public b(String r100, VariableType r101, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103, Function2<Object, Object, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "variableName");
        Intrinsics.checkNotNullParameter(r102, "index");
        Intrinsics.checkNotNullParameter(r103, "assignableValue");
        this.f560918a = r100;
        this.f560919b = r101;
        this.f560920c = r102;
        this.f560921d = r103;
        this.f560922e = r104;
    }
}
