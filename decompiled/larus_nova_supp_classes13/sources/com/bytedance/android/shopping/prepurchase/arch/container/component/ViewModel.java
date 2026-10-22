package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class ViewModel<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
    public j a;
    public com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e b;
    public com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> c;
    public final Lazy d;

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> getContext() {
        com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    public ViewModel() {
        this.d = LazyKt.lazy(new ViewModel$lifecycleScope$2(this));
    }

    public static com.bytedance.android.shopping.prepurchase.arch.container.ability.a a(ViewModel r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$getAbility");
        Intrinsics.checkNotNullParameter(r2, "service");
        j r3 = r1.a;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L6:
        return r3.getService(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = k.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        c();
        return;
    L5:
        if (r4 != 6) goto L7;
        d();
        return;
    L7:
        if (r4 != 3) goto L9;
        b();
        return;
    L9:
        if (r4 != 4) goto L19;
        e();
        return;
    }

    public static void f(ViewModel r7, Class r8, Function3 r9) {
        Intrinsics.checkNotNullParameter(r7, "$this$whenAbilityAvailable");
        Intrinsics.checkNotNullParameter(r8, "service");
        Intrinsics.checkNotNullParameter(r9, "block");
        BuildersKt.launch$default((CoroutineScope) r7.d.getValue(), null, null, new ViewModel$whenAbilityAvailable$1(r7, r9, r8, null), 3, null);
    }
}
