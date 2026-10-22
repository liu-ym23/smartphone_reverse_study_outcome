package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public final ECHotAtmosphereView a;
    public final View b;
    public final Function2<com.bytedance.android.ec.common.api.jump.model.e, ECHotAtmosphere, Unit> c;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ e a;
        public final /* synthetic */ ECUIPromotion b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.e c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            if (ViewCompat.isAttachedToWindow(this.a.a) == false) goto L9;
            ECUIPromotion r5 = this.b;
            r5.hotAtmosphereState.hasShown = true;
            if (r5.isAuction() == true) goto L7;
            this.a.c.invoke(this.c, null);
        L7:
            this.a.a.l(true);
            return;
        }

        public a(e r1, ECUIPromotion r2, com.bytedance.android.ec.common.api.jump.model.e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements com.bytedance.android.ec.core.widget.h {
        public final /* synthetic */ e a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.e b;
        public final /* synthetic */ View c;
        public final /* synthetic */ ECUIPromotion d;

        public final void c(ECHotAtmosphere r1) {
        }

        public final void b() {
            this.c.animate().alpha(1.0f).setDuration(120).start();
        }

        public final void onAttachedToWindow() {
            if (this.a.a.getTag() != null) goto L6;
            this.a.a(this.b, false);
            return;
        }

        public final void onDetachedFromWindow() {
            this.a.a.setTag(null);
            this.c.animate().cancel();
            this.a.a.a();
        }

        public final void a(ECHotAtmosphere r3) {
            if (this.d.isAuction() == true) goto L6;
            this.a.c.invoke(this.b, r3);
            return;
        }

        public b(e r1, com.bytedance.android.ec.common.api.jump.model.e r2, View r3, ECUIPromotion r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final void a(com.bytedance.android.ec.common.api.jump.model.e r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
        View r0 = this.b;
        ECUIPromotion r1 = r11.a;
        if (r1.isAuction() == false) goto L10;
        ECPromotionAuctionInfo r2 = r1.getAuctionInfo();
        if (r2 == null) goto L7;
        ECHotAtmosphere r3 = r2.getHotAtmosphere();
    L8:
        r1.setHotAtmosphere(r3);
        goto L10
    L7:
        r3 = null;
    L10:
        if (r1.canShowHotAtmosphere() == true) goto L12;
    L57:
        r0.setAlpha(1.0f);
        ECUIPromotion.HotAtmosphereState r13 = r1.hotAtmosphereState;
        if (r13 == null) goto L60;
        r13.reset();
    L60:
        this.a.setCallback(null);
        this.a.setTag(null);
        this.a.setVisibility(4);
        this.a.i();
        return;
    L12:
        if (r1.getHotAtmosphere() == null) goto L57;
        if (r1.hotAtmosphereState != null) goto L16;
        r1.hotAtmosphereState = new ECUIPromotion.HotAtmosphereState();
    L16:
        String r4 = r1.getPromotionId();
        Object r6 = this.a.getTag();
        if ((r6 instanceof ECUIPromotion) == true) goto L19;
        r6 = null;
    L19:
        ECUIPromotion r7 = (ECUIPromotion) r6;
        if (r7 == null) goto L22;
        String r8 = r7.getPromotionId();
    L23:
        boolean r5 = Intrinsics.areEqual(r4, r8);
        boolean r9 = true;
        if ((!r5) == false) goto L26;
        this.a.i();
    L26:
        this.a.setVisibility(0);
        this.a.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(116.0f)));
        ECHotAtmosphereView.g(this.a, false, r1.isAuction(), null, 4);
        if (r1.hotAtmosphereState.hasShown == false) goto L29;
        this.a.setTag(r1);
        this.a.l(false);
        r0.animate().cancel();
        r0.setAlpha(0.0f);
        this.a.setAlpha(1.0f);
    L32:
        ECHotAtmosphere r10 = r1.getHotAtmosphere();
        if (r10 == null) goto L35;
        int r14 = r10.getNumInt();
    L36:
        ECHotAtmosphere r15 = r1.getHotAtmosphere();
        if (r15 == null) goto L39;
        int r16 = r15.type;
    L40:
        ECUIPromotion.HotAtmosphereState r17 = r1.hotAtmosphereState;
        int r18 = r17.lastNum;
        if (r18 <= 0) goto L50;
        int r19 = r17.lastType;
        if (r19 <= 0) goto L50;
        if (r17.hasShown == false) goto L50;
        if (r12 == true) goto L50;
        if (r18 != r14) goto L50;
        if (r19 != r16) goto L50;
        r9 = false;
    L50:
        r17.lastNum = r14;
        r17.lastType = r16;
        if (r9 == false) goto L53;
        r17.isFold = false;
    L53:
        ECHotAtmosphere r110 = r1.getHotAtmosphere();
        if (r110 == null) goto L56;
        this.a.j(r110, r9, r1.hotAtmosphereState.isFold);
    L56:
        this.a.setCallback(new b(this, r11, r0, r1));
        return;
    L39:
        r16 = 0;
        goto L40
    L35:
        r14 = 0;
        goto L36
    L29:
        if (this.a.getTag() != null) goto L32;
        this.a.setTag(r1);
        r0.animate().alpha(0.0f).setDuration(120).start();
        this.a.setAlpha(0.0f);
        this.a.animate().alpha(1.0f).setDuration(160).setStartDelay(80).setListener(new a(this, r1, r11)).start();
        goto L32
    L22:
        r8 = null;
        goto L23
    }

    public e(ECHotAtmosphereView r2, ECPromotionTopTagLinearlayout r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, "hotAtmosphereView");
        Intrinsics.checkNotNullParameter(r3, "topLeftContainer");
        Intrinsics.checkNotNullParameter(r4, "onShowHotAtmosphere");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
