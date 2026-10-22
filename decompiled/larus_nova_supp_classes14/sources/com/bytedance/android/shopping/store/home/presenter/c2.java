package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcElementContainer;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c2 implements com.bytedance.android.ecom.arch.slice.render.context.a {
    public final /* synthetic */ ECShopSliceTopBarPresenter.b a;

    public c2(ECShopSliceTopBarPresenter.b r1) {
        this.a = r1;
    }

    public final void a(SlcTemplateContext r7, String r8, Throwable r9) {
        Intrinsics.checkNotNullParameter(r7, "templateContext");
        if (Intrinsics.areEqual(r8, ShopSliceUniqueId.SHOP_TOP_BAR.getId()) == false) goto L79;
        final ECShopSliceTopBarPresenter r10 = this.a.a;
        if (r10.F == true) goto L82;
        r10.F = true;
        com.bytedance.android.ecom.arch.slice.render.r r11 = r10.y;
        if (r11 == null) goto L80;
        View r12 = r11.c;
        if (r12 == null) goto L81;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        r0.gravity = 17;
        ViewGroup r1 = r10.u;
        if (r1 == null) goto L14;
        r1.addView(r12, r0);
    L14:
        com.bytedance.android.ecom.arch.slice.render.r r2 = r10.y;
        final com.bytedance.android.shopping.store.home.entity.j r3 = null;
        if (r2 == null) goto L21;
        SlcTemplateContext r4 = r2.b;
        if (r4 == null) goto L21;
        if (r4.w == null) goto L21;
        View r5 = SlcRenderContext.f(r12, ShopSliceKey.SHARE_BUTTON.getKey());
    L22:
        r10.v = r5;
        com.bytedance.android.ecom.arch.slice.render.r r6 = r10.y;
        if (r6 == null) goto L29;
        SlcTemplateContext r13 = r6.b;
        if (r13 == null) goto L29;
        if (r13.w == null) goto L29;
        View r14 = SlcRenderContext.f(r12, ShopSliceKey.SLICE_INFO.getKey());
    L30:
        r10.w = r14;
        com.bytedance.android.ecom.arch.slice.render.r r15 = r10.y;
        if (r15 == null) goto L37;
        SlcTemplateContext r16 = r15.b;
        if (r16 == null) goto L37;
        if (r16.w == null) goto L37;
        View r17 = SlcRenderContext.f(r12, ShopSliceKey.SHOP_SEARCH.getKey());
    L39:
        if ((r17 instanceof SlcElementContainer) == true) goto L41;
        r17 = null;
    L41:
        SlcElementContainer r18 = (SlcElementContainer) r17;
        if (r18 == null) goto L44;
        View r19 = r18.getContentView();
    L46:
        if ((r19 instanceof ECStoreCollapsibleTextView) == true) goto L48;
        r19 = null;
    L48:
        r10.x = (ECStoreCollapsibleTextView) r19;
        if (r10.U() == true) goto L58;
        final View r20 = r10.v;
        com.bytedance.android.shopping.store.home.entity.n r21 = (com.bytedance.android.shopping.store.home.entity.n) r10.T().getHeaderArea().getValue();
        if (r21 == null) goto L53;
        r3 = r21.i;
    L53:
        if (r20 == null) goto L58;
        if (r3 == null) goto L58;
        Lazy r22 = ECTaskManager.b;
        ECTaskManager.a.a().a(r10.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopSliceTopBarPresenter$tryShowShareGuideBubble$1(r10, r20, r3));
    L58:
        ECStoreCollapsibleTextView r23 = r10.x;
        if (r23 == null) goto L61;
        r23.setOnClickListener(new z1(r10));
    L61:
        ECStoreCollapsibleTextView r24 = r10.x;
        if (r24 == null) goto L64;
        r24.setSearchTextViewListener(new a2(r10));
    L64:
        ECStoreCollapsibleTextView r25 = r10.x;
        if (r25 == null) goto L67;
        r25.setSearchCameraClickListener(new b2(r10));
    L67:
        ECStoreCollapsibleTextView r26 = r10.x;
        if (r26 != null) goto L70;
    L76:
        r10.T().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_store")});
        return;
    L70:
        if (r26.e != true) goto L76;
        Map r27 = BtmSDK.INSTANCE.createReportParams("a1.b6269.c5887.d51683", PageFinder.via(r10.y()));
        ArrayList r28 = new ArrayList(r27.size());
        Iterator r29 = r27.entrySet().iterator();
    L73:
        if (r29.hasNext() == false) goto L75;
        Map.Entry r30 = (Map.Entry) r29.next();
        r28.add(TuplesKt.to(r30.getKey(), String.valueOf(r30.getValue())));
        goto L73
    L75:
        r10.T().doEventAction("photo_search_icon_show", MapsKt.toMap(r28), new Pair[]{TuplesKt.to("current_page", "shop_search_page")});
        goto L76
    L44:
        r19 = null;
    L37:
        r17 = null;
    L29:
        r14 = null;
    L21:
        r5 = null;
        goto L22
    L81:
        return;
    L80:
        return;
    L82:
        return;
    }
}
