package com.bytedance.android.shopping.store.router.hybridpage.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.router.hybridpage.slice.HybridPageSlcTemplateManager;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.vo.HybridPageGeneralCardVO;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceGeneralCardHolder;", "Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceBaseProductCardHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridPageSliceGeneralCardHolder extends HybridPageSliceBaseProductCardHolder {
    public static final a s = null;
    public final QUIManager o;
    public final ViewGroup p;
    public final c q;
    public final HybridPageViewModel r;

    public static final class a {
        public a() {
        }
    }

    static {
        s = new a();
    }

    public final void o() {
        this.o.r(zj3.a.class);
        super.o();
    }

    public final void onRelease() {
        this.o.r(zj3.a.class);
        super.onRelease();
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceBaseProductCardHolder
    public final void q4(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        HybridPageGeneralCardVO.a r5 = HybridPageGeneralCardVO.i;
        if ((r3 instanceof HybridPageGeneralCardVO) == false) goto L6;
    L12:
        HybridPageGeneralCardVO r6 = (HybridPageGeneralCardVO) r3;
        if (r6 != null) goto L16;
        return;
    L16:
        if (((LayoutTypes) this.r.getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L18;
        r4(r6, 2);
    L19:
        int r7 = getAdapterPosition();
        if (r7 < 0) goto L27;
        int r0 = 0;
    L22:
        ECHybridListAdapter r1 = ((BaseViewHolder) this).g;
        if (r1 == null) goto L25;
        r1.getItemViewType(r0);
        ECHybridListItemType.SHOP_SEARCH_RESULT_GENERAL_CARD.getType();
    L25:
        if (r0 == r7) goto L27;
        r0 = r0 + 1;
    L27:
        this.o.c(zj3.a.class, r6);
        return;
    L18:
        r4(r6, 1);
        goto L19
    L6:
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        String r8 = (String) r3;
        if (r8 != null) goto L11;
        r3 = null;
        goto L12
    L11:
        r5.getClass();
        r3 = HybridPageGeneralCardVO.a.a(r8, null);
        goto L12
    }

    public final void r4(HybridPageGeneralCardVO r8, int r9) {
        String r0 = r8.e;
        if (r0 == null) goto L42;
        com.bytedance.android.shopping.store.router.hybridpage.slice.b r3 = this.r.getSlcCardFactory();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "itemType");
        SliceTemplate r10 = HybridPageSlcTemplateManager.a(r0, r9);
        boolean r1 = false;
        if (r10 == null) goto L10;
        String r4 = r10.getContent();
        if (r4 == null) goto L10;
        r r5 = r3.i(r4, r10);
        if (r5 == null) goto L10;
    L37:
        if (r5 != null) goto L43;
        dm.a.b r11 = dm.a.a("HybridPageSlcProductCardFactory");
        StringBuilder r6 = new StringBuilder("createDoubleCard, viewInfo is null, context is null = ");
        if (r3.a != null) goto L41;
        r1 = true;
    L41:
        r6.append(r1);
        r11.b(r6.toString(), null);
    L43:
        if (r5 == null) goto L53;
        View r12 = r5.c;
        if (r12 == null) goto L53;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        c r7 = this.q;
        if (r7.a != null) goto L49;
    L52:
        this.p.addView(r12, r2);
        goto L53
    L49:
        if ((true ^ Intrinsics.areEqual(r7.b, r8.e)) == false) goto L51;
        this.p.removeAllViews();
        goto L52
    L51:
        return;
    L53:
        if (r5 != null) goto L55;
        dm.a.a("HybridPageSliceGeneralCardHolder").b("bind:viewInfo is null", null);
    L55:
        c r13 = this.q;
        r13.a = r5;
        r13.b = r8.e;
        return;
    L10:
        if (r10 == null) goto L12;
        String r14 = r10.getUrl();
    L13:
        if (r10 == null) goto L15;
        String r15 = r10.getName();
    L16:
        if (r10 == null) goto L18;
        String r16 = r10.getVersion();
    L19:
        if (r16 != null) goto L21;
        r16 = "";
    L21:
        if (r14 != null) goto L23;
    L26:
        boolean r17 = true;
    L27:
        if (r17 == true) goto L36;
        if (r15 != null) goto L30;
    L33:
        boolean r18 = true;
    L34:
        if (r18 == true) goto L36;
        r5 = r3.h(r14, r15, r16);
        goto L37
    L30:
        if (r15.length() == 0) goto L33;
        r18 = false;
    L36:
        r5 = null;
        goto L37
    L23:
        if (r14.length() == 0) goto L26;
        r17 = false;
        goto L27
    L18:
        r16 = null;
        goto L19
    L15:
        r15 = null;
        goto L16
    L12:
        r14 = null;
        goto L13
    L42:
        r5 = null;
        goto L43
    }

    public HybridPageSliceGeneralCardHolder(QUIManager r2, ViewGroup r3, c r4, HybridPageViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemViewContainer");
        Intrinsics.checkNotNullParameter(r4, "viewInfoProxy");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        super(r3);
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
    }
}
