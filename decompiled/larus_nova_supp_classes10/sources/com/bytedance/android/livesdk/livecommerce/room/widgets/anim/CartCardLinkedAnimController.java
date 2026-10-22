package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.view.View;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CartCardLinkedAnimController {
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public boolean a;
    public boolean b;
    public g c;
    public yk2.c d;
    public final b e;
    public final boolean f;
    public final int g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CartCardLinkedAnimController a;

        @Override // java.lang.Runnable
        public final void run() {
            g r0 = this.a.c;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.onCanceled();     // Catch: Throwable -> L7
        L5:
            this.a.c = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(CartCardLinkedAnimController r1) {
            this.a = r1;
        }
    }

    static {
        h = LazyKt.lazy(CartCardLinkedAnimController$Companion$CartEffectGuide$2.INSTANCE);
        i = LazyKt.lazy(CartCardLinkedAnimController$Companion$CartEffectLinkCardOut$2.INSTANCE);
        j = LazyKt.lazy(CartCardLinkedAnimController$Companion$CartEffectLinkCardIn$2.INSTANCE);
    }

    public final boolean d() {
        yk2.c r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    public static com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.e c(boolean r2) {
        if (r2 == false) goto L5;
        List r3 = CollectionsKt.listOf(new String[]{"https://lf3-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_small_card_anim_show_v2.1.webp", "https://lf9-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_small_card_anim_show_v2.1.webp"});
    L7:
        return new com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.e(r3);
    L5:
        r3 = CollectionsKt.listOf(new String[]{"https://lf3-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_small_card_anim_hide_v2.2.webp", "https://lf9-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_small_card_anim_hide_v2.2.webp"});
        goto L7
    }

    public final boolean a(View r7) {
        int[] r1 = new int[2];
        yk2.c r2 = this.d;
        if (r2 == null) goto L22;
        View r3 = r2.getView();
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r7.getWidth() > 0) goto L9;
        return false;
    L9:
        if (r3.getWidth() > 0) goto L12;
        return false;
    L12:
        if (this.a == false) goto L14;
    L13:
        return true;
    L14:
        r3.getLocationOnScreen(r1);
        int r4 = r1[0] + (r3.getWidth() / 2);
        r7.getLocationOnScreen(r1);
        if (r1[0] > 0) goto L17;
        r1[0] = (int) (UIUtils.getScreenWidth(r7.getContext()) - UtilityKotlinExtentionsKt.c(125));
    L17:
        float r8 = r1[0];
        float r5 = r4;
        if ((r8 - UtilityKotlinExtentionsKt.c(70)) <= r5) goto L20;
        return false;
    L20:
        if (r5 <= (r8 + UtilityKotlinExtentionsKt.c(14))) goto L13;
        return false;
    L22:
        return false;
    }

    public final com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.e b(boolean r3) {
        int r0 = ECContextContainer.b;
        ECContext r1 = ECContextContainer.a.a(this.f, Integer.valueOf(this.g));
        if (r1 == null) goto L9;
        n<com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a> r2 = r1.getCartConfig();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a r4 = (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a) r2.getValue();
        if (r4 == null) goto L9;
        de.a r5 = r4.a;
    L10:
        if (r3 == false) goto L20;
        if (r5 == null) goto L17;
        String r6 = r5.animatedCommonIconUrl;
        if (r6 == null) goto L17;
        List r7 = CollectionsKt.listOf(r6);
        if (r7 == null) goto L17;
    L30:
        return new com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.e(r7);
    L17:
        if (EComABUtils.isToolbarIconOpt() == false) goto L19;
        r7 = (List) j.getValue();
        goto L30
    L19:
        r7 = CollectionsKt.listOf(new String[]{"https://lf3-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_no_flower_v2.4.webp", "https://lf9-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_no_flower_v2.4.webp"});
        goto L30
    L20:
        if (r5 == null) goto L26;
        String r8 = r5.animatedIconUrl;
        if (r8 == null) goto L26;
        r7 = CollectionsKt.listOf(r8);
        if (r7 != null) goto L30;
    L26:
        if (EComABUtils.isToolbarIconOpt() == false) goto L28;
        r7 = (List) i.getValue();
        goto L30
    L28:
        r7 = CollectionsKt.listOf(new String[]{"https://lf3-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_has_flower_v2.4.webp", "https://lf9-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_has_flower_v2.4.webp"});
    L9:
        r5 = null;
        goto L10
    }

    public final void f(View r4) {
        Intrinsics.checkNotNullParameter(r4, "cardView");
        if (d() == true) goto L5;
        return;
    L5:
        if (this.b == false) goto L7;
        return;
    L7:
        if (a(r4) == true) goto L9;
        return;
    L9:
        if (this.d == null) goto L32;
        int r5 = ECContextContainer.b;
        ECContext r6 = ECContextContainer.a.a(this.f, Integer.valueOf(this.g));
        if (r6 == null) goto L17;
        m<Boolean> r7 = r6.isPromotionListShow();
        if (r7 == null) goto L17;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L17;
        return;
    L17:
        yk2.c r8 = this.d;
        if (r8 == null) goto L21;
        r8.a(false, b(false));
    L21:
        if (this.c != null) goto L23;
    L27:
        this.c = null;
        UtilityKotlinExtentionsKt.b.postDelayed(this.e, 1000);
        return;
    L23:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L27;
        g r9 = this.c;
        if (r9 == null) goto L27;
        r9.onCanceled();
        goto L27
    }

    public CartCardLinkedAnimController(boolean r2, int r3) {
        this.f = r2;
        this.g = r3;
        this.e = new b(this);
        UtilityKotlinExtentionsKt.f(Fresco.getImagePipeline(), ECAppInfoService.e.getApplicationContext(), new CartCardLinkedAnimController$prefetchWebp$1(this));
    }

    public final void e(int r1, boolean r2, boolean r3) {
        if (r2 == false) goto L10;
        if (r3 == false) goto L10;
        if (r1 < 6) goto L10;
        g r4 = this.c;
        if (r4 == null) goto L9;
        r4.a();
    L9:
        this.c = null;
    L10:
        g r5 = this.c;
        if (r5 == null) goto L13;
        r5.b();
    L13:
        g r6 = this.c;
        if (r6 == null) goto L17;
        r6.c(r1);
        return;
    }
}
