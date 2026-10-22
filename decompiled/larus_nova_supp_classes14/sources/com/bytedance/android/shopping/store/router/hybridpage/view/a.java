package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.status.ECStoreSearchProductLoadingView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.ui.ec.widget.loading.ECSloganLoadingAnimationView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.b<FrameLayout> {
    public ECStoreSearchProductLoadingView H3;
    public View I3;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.router.hybridpage.view.a$a, reason: collision with other inner class name */
    public static final class C0015a {
    }

    static {
    }

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        Object r7 = r6.get("custom_offset");
        ViewGroup.LayoutParams r0 = null;
        if (r7 == null) goto L5;
        Integer r8 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r7);
    L7:
        if (Intrinsics.areEqual(((BaseSlcViewManager) this).a.g, ShopSliceUniqueId.CLASSIFICATION_SECOND_PAGE.getId()) == false) goto L21;
        if (r8 == null) goto L26;
        int r9 = r8.intValue();
        View r1 = this.I3;
        if (r1 == null) goto L27;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == false) goto L16;
        r0 = r3;
    L16:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0;
        if (r2 == null) goto L28;
        r2.topMargin = SlcDimensExtensionsKt.a(Integer.valueOf(RangesKt.coerceAtLeast(r9, 0)), ((BaseSlcViewManager) this).a.m());
        r1.setLayoutParams(r2);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L21:
        if (r8 == null) goto L29;
        int r10 = r8.intValue();
        ECStoreSearchProductLoadingView r4 = this.H3;
        if (r4 == null) goto L30;
        r4.setPadding(r4.getPaddingLeft(), RangesKt.coerceAtLeast(r10, 0), r4.getPaddingRight(), r4.getPaddingBottom());
        return;
    L30:
        return;
    L29:
        return;
    L5:
        r8 = null;
        goto L7
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FrameLayout r0 = new FrameLayout(r5);
        if (Intrinsics.areEqual(((BaseSlcViewManager) this).a.g, ShopSliceUniqueId.CLASSIFICATION_SECOND_PAGE.getId()) == false) goto L15;
        ShoppingAsyncInflater.e.getClass();
        View r6 = ShoppingAsyncInflater.a.a(r5).aU(2131564798, null, false);
        Lazy r1 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L10;
        ECSloganLoadingAnimationView r2 = (ECSloganLoadingAnimationView) r6.findViewById(2131386336);
        if (r2 == null) goto L14;
        r2.setVisibility(0);
    L14:
        this.I3 = r6;
        r0.addView(r6, new FrameLayout.LayoutParams(-2, -2, 49));
    L16:
        return r0;
    L10:
        if (we.a.a == false) goto L14;
        LinearLayout r3 = (LinearLayout) r6.findViewById(2131389439);
        if (r3 == null) goto L14;
        r3.setVisibility(0);
        goto L14
    L15:
        ECStoreSearchProductLoadingView r4 = new ECStoreSearchProductLoadingView(r5, null);
        this.H3 = r4;
        r0.addView(r4, new FrameLayout.LayoutParams(-1, -1));
        goto L16
    }
}
