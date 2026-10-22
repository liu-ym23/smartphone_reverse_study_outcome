package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class h<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE, VIEWMODEL extends ViewModel<STATE, STORE>> extends Component<STATE, STORE> {
    public VIEWMODEL m;

    public abstract VIEWMODEL f2();

    public final VIEWMODEL g2() {
        VIEWMODEL r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void K1() {
        VIEWMODEL r0 = (VIEWMODEL) f2();
        this.m = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r2 = O1();
        j r3 = R1();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(this, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "serviceRegistry");
        r0.c = r2;
        r0.b = this;
        r0.a = r3;
        T1();
        LifecycleRegistry r1 = P1();
        VIEWMODEL r4 = this.m;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r1.a(r4);
    }

    public h() {
    }
}
