package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv4.ai.PdpAIComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.VirtualCommentComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements ul.c {
    public final List<Component<?, ?>> a;
    public Component<?, ?> b;
    public VirtualCommentComponent c;
    public m d;
    public PdpAIComponent e;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> g;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j h;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.g<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> i;
    public final PdpRootComponent.a j;
    public final n83.m k;
    public final com.bytedance.android.shopping.anchorv4.helper.u l;

    public static final class a {
    }

    static {
    }

    public final void a(boolean r3) {
        if (r3 == false) goto L7;
        Iterator<T> r4 = this.a.iterator();
    L5:
        if (r4.hasNext() == false) goto L11;
        ((Component) r4.next()).e2().setVisibility(0);
        goto L5
    L11:
        return;
    L7:
        Iterator<T> r5 = this.a.iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        ((Component) r5.next()).e2().setVisibility(8);
        goto L9
    }

    public final void c(ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r8, "container");
        if (this.c != null) goto L6;
        VirtualCommentComponent r0 = new VirtualCommentComponent();
        b(this, r8, r0, null, 0, 12);
        Unit r9 = Unit.INSTANCE;
        this.c = r0;
        return;
    }

    public static void b(n r1, ViewGroup r2, Component r3, ViewGroup.LayoutParams r4, int r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = -1;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "parentView");
        Intrinsics.checkNotNullParameter(r3, "component");
        r1.i.a(r2, r3, r4, r5);
    }

    public n(PdpRootComponent r2, com.bytedance.android.shopping.prepurchase.arch.container.c r3, com.bytedance.android.shopping.prepurchase.arch.container.component.j r4, com.bytedance.android.shopping.prepurchase.arch.container.component.g r5, PdpRootComponent.a r6, n83.m r7, com.bytedance.android.shopping.anchorv4.helper.u r8) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r5, "componentLoader");
        Intrinsics.checkNotNullParameter(r6, "provider");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        this.a = new ArrayList();
    }
}
