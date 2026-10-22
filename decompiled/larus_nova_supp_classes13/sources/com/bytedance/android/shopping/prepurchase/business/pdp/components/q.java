package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.widget.FrameLayout;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.BottomNavigationComponentV1;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ n a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ FrameLayout c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;

    public q(n r1, Ref.BooleanRef r2, FrameLayout r3, Ref.ObjectRef r4, Ref.ObjectRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r8) {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.k r9 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) r8;
        Intrinsics.checkNotNullParameter(r9, "it");
        if ((r9 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) == false) goto L16;
        Ref.BooleanRef r10 = this.b;
        if (r10.element == true) goto L17;
        r10.element = true;
        if (((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.a.g.d().getData().e.getValue()).a() != null) goto L12;
        this.a.g.w7().i("PdpComponentsLoader", "切换回老顶导");
        int r11 = this.c.indexOfChild(((m) this.d.element).e2());
        this.a.i.e((m) this.d.element);
        Ref.ObjectRef r3 = this.d;
        r3.element = new TopNavigationComponentV1();
        n r4 = this.a;
        m r5 = (m) this.d.element;
        r4.d = r5;
        r4.i.a(this.c, r5, new FrameLayout.LayoutParams(-1, -2), r11);
    L12:
        if (((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.a.g.d().getData().k.getValue()).a() != null) goto L15;
        this.a.g.w7().i("PdpComponentsLoader", "切换回老底导");
        int r12 = this.c.indexOfChild(((Component) this.e.element).e2());
        this.a.i.e((Component) this.e.element);
        Ref.ObjectRef r2 = this.e;
        r2.element = new BottomNavigationComponentV1();
        com.bytedance.android.shopping.prepurchase.arch.container.component.g<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r6 = this.a.i;
        FrameLayout r7 = this.c;
        Component<STATE, PdpDataStore> r13 = (Component) this.e.element;
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -2);
        r14.gravity = 80;
        Unit r0 = Unit.INSTANCE;
        r6.a(r7, r13, r14, r12);
        return;
    L15:
        return;
    L17:
        return;
    }
}
