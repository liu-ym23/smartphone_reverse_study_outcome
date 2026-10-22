package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Pair<VariableType, Object>> f490816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f490817b;

    public b() {
        this.f490816a = new LinkedHashMap();
        this.f490817b = LazyKt.lazy(new a(this));
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public Object d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Pair r101 = (Pair) ((LinkedHashMap) this.f490816a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSecond();
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public final Object b(Map<String, ? extends Pair<? extends VariableType, ? extends Object>> r100, Function1<? super e, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "extraVariables");
        Intrinsics.checkNotNullParameter(r101, "block");
        ((LinkedHashMap) ((c) this.f490817b.getValue()).f490816a).clear();
        Iterator<Map.Entry<String, ? extends Pair<? extends VariableType, ? extends Object>>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, ? extends Pair<? extends VariableType, ? extends Object>> r103 = r102.next();
        String r104 = r103.getKey();
        Pair<? extends VariableType, ? extends Object> r105 = r103.getValue();
        ((c) this.f490817b.getValue()).c(r104, r105.getSecond(), r105.getFirst());
        goto L4
    L7:
        return r101.invoke((c) this.f490817b.getValue());
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public void c(String r100, Object r101, VariableType r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r102 == null) goto L5;
    L9:
        if (r102 != null) goto L11;
    L15:
        if (r102 != null) goto L25;
        Pair r103 = (Pair) ((LinkedHashMap) this.f490816a).get(r100);
        if (r103 == null) goto L19;
        VariableType r104 = (VariableType) r103.getFirst();
    L21:
        if (r104 != VariableType.Const) goto L25;
        throw new IllegalStateException(("TypeError: Assignment to constant variable ('" + r100 + "')").toString());
    L19:
        r104 = null;
    L25:
        Map<String, Pair<VariableType, Object>> r105 = this.f490816a;
        if (r102 != null) goto L31;
        Pair r106 = (Pair) ((LinkedHashMap) r105).get(r100);
        if (r106 == null) goto L30;
        r102 = (VariableType) r106.getFirst();
        goto L31
    L30:
        r102 = null;
    L31:
        Intrinsics.checkNotNull(r102);
        r105.put(r100, TuplesKt.to(r102, r101));
        return;
    L11:
        if (this.f490816a.containsKey(r100) == false) goto L15;
        throw new IllegalStateException(("Identifier '" + r100 + "' is already declared").toString());
    L5:
        if (this.f490816a.containsKey(r100) == true) goto L9;
        qrc.e.c(r100, null);
        throw null;
    }
}
