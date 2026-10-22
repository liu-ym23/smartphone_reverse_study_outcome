package lv3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements uq9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f510917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f510918b;

    @Override // uq9.l
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        Function0<Unit> r100 = this.f510918b.element;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    @Override // uq9.l
    public final void onInitSuccess() {
        Function0<Unit> r100 = this.f510917a.element;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public m(Ref.ObjectRef<Function0<Unit>> r100, Ref.ObjectRef<Function0<Unit>> r101) {
        this.f510917a = r100;
        this.f510918b = r101;
    }
}
