package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.view.LiveBroadcastHintStrand;
import com.bytedance.android.shopping.anchorv3.view.z;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandMeta;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.LiveEntryMeta;
import com.bytedance.android.shopping.anchorv4.components.topbanner.LiveEntryVO;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HalfStrandComponent extends m {
    public final Lazy m;
    public boolean n;
    public boolean o;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ HalfStrandComponent a;

        public a(HalfStrandComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r10) {
            com.bytedance.android.shopping.prepurchase.arch.container.state.m r11 = (com.bytedance.android.shopping.prepurchase.arch.container.state.m) r10;
            Intrinsics.checkNotNullParameter(r11, "pair");
            TopBannerVO r0 = (TopBannerVO) r11.b;
            HalfStrandVO r12 = (HalfStrandVO) r11.c;
            if (r0 != null) goto L41;
            HalfStrandComponent r1 = this.a;
            if (r12 != null) goto L9;
            r1.getClass();
            return;
        L9:
            if (r1.o == true) goto L42;
            r1.o = true;
            View r4 = null;
            if (r12.isShowLiveEntry() == false) goto L32;
            LiveEntryVO r2 = r12.getLiveEntry();
            Intrinsics.checkNotNull(r2);
            HalfStrandMeta r13 = r12.getHalfStrandMeta();
            if (r13 == null) goto L16;
            LiveEntryMeta r14 = r13.getLiveEntry();
        L17:
            if (r14 == null) goto L31;
            View r5 = r1.e2();
            if (r5 == null) goto L29;
            FrameLayout r6 = (FrameLayout) r5;
            r1.n = true;
            String r3 = r14.getLogExtras();
            ImageModel r7 = r2.getAuthorAvatar();
            if (r7 == null) goto L23;
            ECUrlModel r8 = r7.getRemote();
        L24:
            String r9 = r2.getAuthorName();
            String r15 = r2.getLivingSchema();
            if (r15 != null) goto L27;
            r15 = r14.getSchema();
        L27:
            z r16 = new z(r8, r15, r9);
            String r17 = new BtmItemBuilder("a1.b8094.c96654.d093142", null, 2, null).withView(r6).obtainEventBtmParams();
            int r18 = com.bytedance.android.shopping.anchorv3.track.b.a;
            com.bytedance.android.shopping.anchorv3.track.b.d(r14.getItemId(), r3, r6.getContext(), r17);
            int r19 = LiveBroadcastHintStrand.d;
            Context r110 = r6.getContext();
            Intrinsics.checkNotNullParameter(r110, "context");
            View r20 = new LiveBroadcastHintStrand(r110, null, 6, 0);
            r20.b(r16);
            r4 = r20;
            goto L32
        L23:
            r8 = null;
            goto L24
        L29:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        L31:
            throw new IllegalStateException("Required value was null.".toString());
        L16:
            r14 = null;
        L32:
            if (r4 == null) goto L43;
            r1.e2().setVisibility(0);
            View r111 = r1.e2();
            if (r111 == null) goto L39;
            ((ViewGroup) r111).addView(r4, -1, -1);
            r1.h2(0.0f);
            return;
        L39:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L43:
            return;
        L42:
            return;
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ HalfStrandComponent a;

        public b(HalfStrandComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            float r3 = ((Number) r2).floatValue();
            this.a.h2(r3);
        }
    }

    public HalfStrandComponent() {
        this.m = LazyKt.lazy(new HalfStrandComponent$statusBarHeight$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(O1().d().getData().f(), this, new a(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new b(this));
    }

    public final void h2(float r5) {
        e2().setAlpha(1.0f - RangesKt.coerceAtLeast(0.0f, r5));
        int r0 = com.bytedance.android.shopping.extensions.b.b(8);
        if (this.n == false) goto L5;
        int r1 = j.a(2131165669);
    L6:
        int r2 = r0 + r1;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r3 = O1().getContainerAbility().i7();
        int r4 = (((r3.b - r3.c) - ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.b) - r2) + ((Number) this.m.getValue()).intValue();
        View r6 = e2();
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r7 = null;
    L9:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 != null) goto L12;
    L16:
        e2().requestLayout();
        return;
    L12:
        if (r5 < 0) goto L14;
        int r9 = (int) (r4 * (1 - r5));
    L15:
        r8.topMargin = r9;
        r6.setLayoutParams(r8);
        goto L16
    L14:
        r9 = r4 - ((int) (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.b * r5));
        goto L15
    L5:
        r1 = j.a(2131165688);
        goto L6
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        FrameLayout r4 = new FrameLayout(r2.getContext());
        r4.setId(2131389228);
        r4.setVisibility(8);
        return r4;
    }
}
