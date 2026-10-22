package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.c;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IronListHeaderEntryView extends FrameLayout {
    public final TextView a;
    public final ECDraweeView b;
    public final ECLottieAnimationView c;
    public Map<String, String> d;
    public c e;
    public Function0<? extends c> f;

    public final c getPopupWindow() {
        if (this.e != null) goto L10;
        Function0<? extends c> r0 = this.f;
        if (r0 == null) goto L7;
        c r1 = (c) r0.invoke();
    L8:
        this.e = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.e;
    }

    public final Function0<c> getGetBubblePopupWindow() {
        return this.f;
    }

    public final ECLottieAnimationView getLottieImageView() {
        return this.c;
    }

    public final c getMoreActionPop() {
        return this.e;
    }

    public IronListHeaderEntryView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        th.a.c(r3, 2131560759, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        this.a = (TextView) findViewById(2131371722);
        this.b = findViewById(2131371719);
        this.c = (ECLottieAnimationView) findViewById(2131371720);
    }

    private final void setEntryInfo(ECPromotionEntry r8) {
        if (r8 == null) goto L11;
        this.a.setText(r8.getTitle());
        int r0 = s.a;
        Integer r1 = s.b(r8.getColor());
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
        this.a.setTextColor(r2);
    L7:
        if (r8.getType() != 3) goto L9;
        ExtensionsKt.gone(this.b);
        ExtensionsKt.visible(this.c);
        return;
    L9:
        ExtensionsKt.visible(this.b);
        ExtensionsKt.gone(this.c);
        h0.e(this.b, r8.getIcon(), new r("ec_live", "promotion_list_promotion_list_top_image"), null, null, 120);
        return;
    }

    public final void setGetBubblePopupWindow(Function0<? extends c> r1) {
        this.f = r1;
    }

    public final void setMoreActionPop(c r1) {
        this.e = r1;
    }

    public final void setPopupWindow(Function0<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "getPopupWindow");
        this.f = r2;
    }

    public final void a(final ECPromotionEntry r10, final i r11, final Map<String, String> r12) {
        this.d = r12;
        if (r11 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.largemode.b r1 = r11.d;
    L6:
        if (r1 == null) goto L17;
        ComponentLargeModeConfig r2 = r1.b("List", "List.Header.Entry.Icon");
        if (r2 == null) goto L11;
        int r4 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r2, this.b);
    L11:
        ComponentLargeModeConfig r3 = r1.b("List", "List.Header.Entry.CartIcon");
        if (r3 == null) goto L14;
        int r5 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r3, this.c);
    L14:
        ComponentLargeModeConfig r6 = r1.b("List", "List.Header.Entry.Title");
        if (r6 == null) goto L17;
        int r7 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r6, this.a);
    L17:
        if (r10 == null) goto L31;
        setEntryInfo(r10);
        if (r10.getType() != 3) goto L26;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_ADD_CART_BAG() == false) goto L24;
        this.c.setAnimation("ec_live_add_bag_motion_vertical_opt.json");
        goto L26
    L24:
        this.c.setAnimation("ec_live_add_cart_motion_vertical_opt.json");
    L26:
        if (r10.getType() == 7) goto L28;
        String r8 = "bind_key_live_promotion_list";
    L29:
        f.c(this, null, r8, new IronListHeaderEntryView$bindData$$inlined$let$lambda$1(r10, this, r10, r11, r12), 1);
        return;
    L28:
        r8 = null;
        goto L29
    L31:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
