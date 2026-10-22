package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RCHItemDecoration;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator$bindRecyclerView$1;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.forest.utils.h;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LegouToolAreaComponent extends ef3.e<HeaderCardData> implements ef3.d {
    public final RecyclerView d;
    public final RVIndicator e;
    public final ToolListAdapter f;
    public final LegouToolAreaComponent$refreshSubscriber$1 g;
    public e h;
    public final a i;

    public static final class a implements com.bytedance.android.ec.hybrid.card.event.e {
        public final /* synthetic */ LegouToolAreaComponent a;

        public a(LegouToolAreaComponent r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.ec.hybrid.card.event.d r4) {
            Intrinsics.checkNotNullParameter(r4, "jsEvent");
            Map r5 = r4.b;
            Object r0 = null;
            if (r5 == null) goto L5;
            Object r6 = r5.get("show");
        L7:
            if ((r6 instanceof Boolean) == false) goto L10;
            r0 = r6;
        L10:
            Boolean r1 = (Boolean) r0;
            if (r1 == null) goto L16;
            ToolListAdapter r7 = this.a.f;
            boolean r2 = !r1.booleanValue();
            RecyclerView r3 = r7.d;
            if (r3 == null) goto L17;
            r3.post(new com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.c(r7, r2));
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r6 = null;
            goto L7
        }
    }

    @Override // ef3.c
    public final String getName() {
        return "TOOL_AREA";
    }

    @Override // ef3.e
    public final void c() {
        ECEventCenter.f("ecom_mall_resource_scope_refresh", this.g);
        e r0 = this.h;
        if (r0 == null) goto L5;
        ECEventCenter.f("ec.mallActionOpenOrderDetailSwitchHighlight", r0);
    L5:
        ECEventCenter.f("ecom_mall_mask_tool_highlight", this.i);
    }

    @Override // ef3.e
    public final void d() {
        ECHybridExtensionsKt.f(new LegouToolAreaComponent$themeChanged$1(this));
    }

    public final void e() {
        RecyclerView r0 = this.d;
        if (r0 == null) goto L34;
        ef3.a r1 = this.c;
        Object r3 = null;
        if ((r1 instanceof com.bytedance.android.shopping.mall.homepage.card.headercard.a) == true) goto L7;
        r1 = null;
    L7:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r2 = (com.bytedance.android.shopping.mall.homepage.card.headercard.a) r1;
        if (r2 == null) goto L35;
        SkinConfigStyle r4 = r2.b();
        if (r4 == null) goto L36;
        SkinConfigStyle.ToolListStyle r5 = r4.getToolListStyle();
        if (r5 == null) goto L37;
        String r6 = r5.getBg_color();
        if (r6 != null) goto L16;
        return;
    L16:
        if (h.a(r6) == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L39;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L22
        Object r8 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r6)));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r8) == true) goto L28;
        r3 = r8;
    L28:
        Integer r9 = (Integer) r3;
        if (r9 == null) goto L40;
        int r10 = r9.intValue();
        BackgroundDrawable r11 = new BackgroundDrawable(r0.getContext(), null, false, 4, null);
        r11.setBgColor(r10);
        int r12 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r11.setCornerRadius(com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true));
        r11.invalidate();
        Unit r13 = Unit.INSTANCE;
        r0.setBackground(r11);
        return;
    L40:
        return;
    L22:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // ef3.c
    public final void onCreate() {
        String r0 = this.c.i;
        ECEventCenter.e("ecom_mall_resource_scope_refresh", this.g, r0);
        if (Intrinsics.areEqual(this.c.h.A1.getGlobalProps().get("order_guide_highlight"), "1") == false) goto L5;
        e r1 = new e(this);
        this.h = r1;
        ECEventCenter.e("ec.mallActionOpenOrderDetailSwitchHighlight", r1, r0);
    L5:
        ECEventCenter.e("ecom_mall_mask_tool_highlight", this.i, r0);
        RVIndicator r2 = this.e;
        if (r2 == null) goto L14;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r3.width = com.bytedance.android.ec.hybrid.list.util.c.c(36, getContext(), true);
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        r5.height = com.bytedance.android.ec.hybrid.list.util.c.c(2, getContext(), true);
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        if ((r6 instanceof FrameLayout.LayoutParams) == true) goto L10;
        r6 = null;
    L10:
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        if (r7 == null) goto L13;
        r7.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(5, getContext(), true);
    L13:
        r2.setIndicatorColor(ColorProtector.parseColor("#FF3344"));
    L14:
        RecyclerView r8 = this.d;
        if (r8 == null) goto L21;
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r8.addItemDecoration(new RCHItemDecoration(com.bytedance.android.ec.hybrid.list.util.c.c(1, getContext(), true)));
        RVIndicator r10 = this.e;
        if (r10 == null) goto L19;
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        r8.addOnScrollListener(new RVIndicator$bindRecyclerView$1(r10));
    L19:
        ToolListAdapter r11 = this.f;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        r11.d = r8;
        r8.addOnScrollListener(r11.g);
        r8.setAdapter(this.f);
        LinearLayoutManager r12 = new LinearLayoutManager(r8.getContext());
        r12.setOrientation(0);
        r8.setLayoutManager(r12);
        return;
    }

    public LegouToolAreaComponent(View r6, com.bytedance.android.shopping.mall.homepage.card.headercard.a r7) {
        Intrinsics.checkNotNullParameter(r6, "cardView");
        Intrinsics.checkNotNullParameter(r7, "mallContext");
        super(r6, r7);
        RecyclerView r0 = r6.findViewById(2131383727);
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L8;
        r1 = r2;
    L8:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r1;
        if (r3 == null) goto L11;
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r3.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(8, getContext(), true);
    L11:
        r0.setTag("header_tool");
        Unit r5 = Unit.INSTANCE;
    L13:
        this.d = r0;
        this.e = (RVIndicator) r6.findViewById(2131372870);
        this.f = new ToolListAdapter(r7);
        this.g = new LegouToolAreaComponent$refreshSubscriber$1(this);
        this.i = new a(this);
        return;
    L12:
        r0 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ef3.c
    public final void a(HeaderCardData r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        this.b = r3;
        ToolListAdapter r5 = this.f;
        ToolVO r0 = null;
        if (r3 == 0) goto L7;
        HeaderCardData.ToolList r1 = r3.getToolList();
        if (r1 == null) goto L7;
        List<ToolVO> r2 = r1.getData();
    L8:
        if (r3 == 0) goto L10;
        r0 = r3.getSearchCart();
    L10:
        r5.C2(r2, r0);
        e();
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // ef3.d
    public final void b(final String r2, final Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentID");
        Intrinsics.checkNotNullParameter(r3, "callback");
        ECHybridExtensionsKt.f(new LegouToolAreaComponent$drawToolItemToCenter$1(this, r2, r3));
    }
}
