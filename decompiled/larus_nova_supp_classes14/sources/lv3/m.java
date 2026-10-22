package lv3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements uq9.l {
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> a;
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> b;

    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        Function0 r0 = (Function0) this.b.element;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void onInitSuccess() {
        Function0 r0 = (Function0) this.a.element;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public m(Ref.ObjectRef<Function0<Unit>> r1, Ref.ObjectRef<Function0<Unit>> r2) {
        this.a = r1;
        this.b = r2;
    }
}
