package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryDisplay;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryIcon;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoComponent;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.i0;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BackToTopEntryComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements vg3.d {
    public ECDraweeView m;

    public static final class a {
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ BackToTopEntryComponent a;

        public b(BackToTopEntryComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r20) {
            BackToTopEntryVO r0 = (BackToTopEntryVO) r20;
            BackToTopEntryComponent r2 = this.a;
            r2.getClass();
            if (r0 == null) goto L19;
            BackToTopEntryDisplay r1 = r0.getDisplay();
            if (r1 == null) goto L20;
            BackToTopEntryIcon r3 = r1.getIcon();
            if (r3 == null) goto L21;
            ECUrlModel r4 = r3.getUrlModel();
            if (r4 == null) goto L22;
            ECDraweeView r5 = r2.m;
            if (r5 == null) goto L13;
            ViewGroup.LayoutParams r6 = r5.getLayoutParams();
            r6.width = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r4.getWidth()));
            r6.height = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r4.getHeight()));
            Unit r7 = Unit.INSTANCE;
            r5.setLayoutParams(r6);
        L13:
            String r8 = r4.getFirstUrl();
            if (r8 == null) goto L23;
            ECDraweeView r9 = r2.m;
            if (r9 == null) goto L24;
            ImageExtensionsKt.w(r9, r8, null, null, null, null, null, null, null, false, null, null, 4094);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BackToTopEntryComponent a;

        public c(BackToTopEntryComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            d0 r3 = (d0) this.a.N1(d0.class);
            if (r3 == null) goto L8;
            ProductDetailInfoComponent.b r4 = r3.b();
            if (r4 == null) goto L9;
            r4.O();
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{d0.class, i0.class, w.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, vg3.d.class, this, false, 12);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().r.getValue(), this, new b(this));
        Z1(i0.class, new BackToTopEntryComponent$onAttach$2(this, null));
        ECDraweeView r0 = this.m;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new c(this));
        return;
    }

    public BackToTopEntryComponent() {
    }

    @Override // vg3.d
    public final ECDraweeView X() {
        return this.m;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "container");
        ECDraweeView r10 = new ECDraweeView(r8.getContext(), null, 0, 6, null);
        r10.setId(2131363796);
        r10.setVisibility(8);
        r10.setBackgroundResource(2131233379);
        this.m = r10;
        return r10;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r3, ViewGroup.LayoutParams r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(40), com.bytedance.android.shopping.extensions.b.b(40));
        r6.gravity = 85;
        r6.rightMargin = com.bytedance.android.shopping.extensions.b.b(13);
        r6.bottomMargin = com.bytedance.android.shopping.extensions.b.b(127);
        Unit r0 = Unit.INSTANCE;
        super.b2(r3, r6, r5);
    }
}
