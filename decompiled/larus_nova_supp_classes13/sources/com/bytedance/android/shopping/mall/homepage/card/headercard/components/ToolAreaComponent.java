package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.FixedLinearLayoutManager;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RCHItemDecoration;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator$bindRecyclerView$1;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ToolAreaComponent extends ef3.e<HeaderCardData> implements ef3.d {
    public final RecyclerView d;
    public final RVIndicator e;
    public final ToolListAdapter f;
    public final ToolAreaComponent$refreshSubscriber$1 g;
    public f h;
    public final a i;

    public static final class a implements com.bytedance.android.ec.hybrid.card.event.e {
        public final /* synthetic */ ToolAreaComponent a;

        public a(ToolAreaComponent r1) {
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

    public static final class b implements Runnable {
        public final /* synthetic */ ToolAreaComponent a;

        public b(ToolAreaComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            HeaderCardData r0 = (HeaderCardData) this.a.b;     // Catch: Throwable -> L20 Exception -> L22
            if (r0 == null) goto L7;
            HeaderCardData.ToolList r1 = r0.getToolList();     // Catch: Throwable -> L20 Exception -> L22
            if (r1 == null) goto L7;
            List<ToolVO> r2 = r1.getData();     // Catch: Throwable -> L20 Exception -> L22
        L8:
            List<ToolVO> r3 = r2;     // Catch: Throwable -> L20 Exception -> L22
            if (r3 != null) goto L11;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == true) goto L27;
            ToolAreaComponent r5 = this.a;     // Catch: Throwable -> L20 Exception -> L22
            if (r5.c.e == true) goto L31;
            r5.f.notifyDataSetChanged();     // Catch: Throwable -> L20 Exception -> L22
        L33:
            return;
        L31:
            return;
        L27:
            return;
        L11:
            if (r3.isEmpty() == true) goto L14;
            r4 = false;
        L7:
            r2 = null;
        L20:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L32;
            throw th;
        L32:
            return;
        L22:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L20
        }
    }

    @Override // ef3.c
    public final String getName() {
        return "TOOL_AREA";
    }

    @Override // ef3.e
    public final void c() {
        ECEventCenter.f("ecom_mall_resource_scope_refresh", this.g);
        f r0 = this.h;
        if (r0 == null) goto L5;
        ECEventCenter.f("ec.mallActionOpenOrderDetailSwitchHighlight", r0);
    L5:
        ECEventCenter.f("ecom_mall_mask_tool_highlight", this.i);
    }

    @Override // ef3.e
    public final void d() {
        RecyclerView r0 = this.d;
        if (r0 == null) goto L6;
        r0.post(new b(this));
        return;
    }

    @Override // ef3.c
    public final void onCreate() {
        String r0 = this.c.i;
        ECEventCenter.e("ecom_mall_resource_scope_refresh", this.g, r0);
        if (Intrinsics.areEqual(this.c.h.A1.getGlobalProps().get("order_guide_highlight"), "1") == false) goto L5;
        f r1 = new f(this);
        this.h = r1;
        ECEventCenter.e("ec.mallActionOpenOrderDetailSwitchHighlight", r1, r0);
    L5:
        ECEventCenter.e("ecom_mall_mask_tool_highlight", this.i, r0);
        RVIndicator r2 = this.e;
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r3.width = com.bytedance.android.ec.hybrid.list.util.c.c(25, getContext(), true);
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
        RecyclerView r8 = this.d;
        if (r8 == null) goto L20;
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r8.addItemDecoration(new RCHItemDecoration(com.bytedance.android.ec.hybrid.list.util.c.c(1, getContext(), true)));
        RVIndicator r10 = this.e;
        if (r10 == null) goto L18;
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        r8.addOnScrollListener(new RVIndicator$bindRecyclerView$1(r10));
    L18:
        ToolListAdapter r11 = this.f;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        r11.d = r8;
        r8.addOnScrollListener(r11.g);
        r8.setAdapter(this.f);
        r8.setLayoutManager(new FixedLinearLayoutManager(r8.getContext()));
        return;
    }

    public ToolAreaComponent(View r10, com.bytedance.android.shopping.mall.homepage.card.headercard.a r11) {
        Intrinsics.checkNotNullParameter(r10, "cardView");
        Intrinsics.checkNotNullParameter(r11, "mallContext");
        super(r10, r11);
        RecyclerView r0 = r10.findViewById(2131383727);
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L16;
        BackgroundDrawable r8 = new BackgroundDrawable(r0.getContext(), null, false, 4, null);
        if (Intrinsics.areEqual(r11.a, "order_homepage") == false) goto L7;
        int r2 = ContextCompat.getColor(r0.getContext(), 2131106102);
    L8:
        r8.setBgColor(r2);
        int r3 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r8.setCornerRadius(com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true));
        r8.invalidate();
        Unit r4 = Unit.INSTANCE;
        r0.setBackground(r8);
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if ((r5 instanceof FrameLayout.LayoutParams) == false) goto L12;
        r1 = r5;
    L12:
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r1;
        if (r6 == null) goto L15;
        r6.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(8, getContext(), true);
    L15:
        r0.setTag("header_tool");
    L17:
        this.d = r0;
        this.e = (RVIndicator) r10.findViewById(2131372870);
        this.f = new ToolListAdapter(r11);
        this.g = new ToolAreaComponent$refreshSubscriber$1(this);
        this.i = new a(this);
        return;
    L7:
        r2 = ContextCompat.getColor(r0.getContext(), 2131106130);
        goto L8
    L16:
        r0 = null;
        goto L17
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
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // ef3.d
    public final void b(final String r2, final Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentID");
        Intrinsics.checkNotNullParameter(r3, "callback");
        ECHybridExtensionsKt.f(new ToolAreaComponent$drawToolItemToCenter$1(this, r2, r3));
    }
}
