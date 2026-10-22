package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.h;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import jj2.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final ECHotAtmosphereView a;
    public final View b;
    public final Function2<c, ECHotAtmosphere, Unit> c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a$a, reason: collision with other inner class name */
    public static final class C0089a extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;
        public final /* synthetic */ c b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            if (ViewCompat.isAttachedToWindow(this.a.a) == false) goto L9;
            this.b.a.setHasShown(true);
            c r5 = this.b;
            if (r5.j == true) goto L7;
            this.a.c.invoke(r5, null);
        L7:
            this.a.a.l(true);
            return;
        }

        public C0089a(a r1, c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements h {
        public final /* synthetic */ a a;
        public final /* synthetic */ c b;
        public final /* synthetic */ View c;

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
            c r0 = this.b;
            if (r0.j == true) goto L6;
            this.a.c.invoke(r0, r3);
            return;
        }

        public b(a r1, c r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final void a(c r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "model");
        View r0 = this.b;
        Integer r2 = null;
        if (r10.j == false) goto L10;
        z0 r1 = r10.c;
        ECPromotionAuctionInfo r3 = r10.k;
        if (r3 == null) goto L7;
        ECHotAtmosphere r4 = r3.getHotAtmosphere();
    L8:
        r1.l(r4);
        goto L10
    L7:
        r4 = null;
    L10:
        if (Intrinsics.areEqual(r10.c.i(), Boolean.TRUE) == true) goto L12;
    L64:
        r0.setAlpha(1.0f);
        r10.a.reset();
        this.a.setCallback(null);
        this.a.setTag(null);
        this.a.setVisibility(4);
        this.a.i();
        return;
    L12:
        if (r10.c.f() == null) goto L64;
        String r5 = r10.f;
        Object r6 = this.a.getTag();
        if ((r6 instanceof c) == true) goto L16;
        r6 = null;
    L16:
        c r7 = (c) r6;
        if (r7 == null) goto L19;
        String r8 = r7.f;
    L20:
        boolean r9 = Intrinsics.areEqual(r5, r8);
        boolean r12 = true;
        if ((!r9) == false) goto L23;
        this.a.i();
    L23:
        this.a.setVisibility(0);
        this.a.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(116.0f)));
        ECHotAtmosphereView.g(this.a, false, r10.j, null, 4);
        if (r10.a.getHasShown() == false) goto L26;
        this.a.setTag(r10);
        this.a.l(false);
        r0.animate().cancel();
        r0.setAlpha(0.0f);
        this.a.setAlpha(1.0f);
    L29:
        ECHotAtmosphere r13 = r10.c.f();
        if (r13 == null) goto L32;
        Integer r14 = Integer.valueOf(r13.getNumInt());
    L33:
        ECHotAtmosphere r15 = r10.c.f();
        if (r15 == null) goto L37;
        r2 = Integer.valueOf(r15.type);
    L37:
        if (r10.a.getLastNum() > 0) goto L39;
    L54:
        if (r14 == null) goto L56;
        r10.a.setLastNum(r14.intValue());
    L56:
        if (r2 == null) goto L58;
        r2.intValue();
        r10.a.setLastType(r2.intValue());
    L58:
        if (r12 == false) goto L60;
        r10.a.setFold(false);
    L60:
        ECHotAtmosphere r16 = r10.c.f();
        if (r16 == null) goto L63;
        this.a.j(r16, r12, r10.a.isFold());
    L63:
        this.a.setCallback(new b(this, r10, r0));
        return;
    L39:
        if (r10.a.getLastType() <= 0) goto L54;
        if (r10.a.getHasShown() == false) goto L54;
        if (r11 == true) goto L54;
        int r17 = r10.a.getLastNum();
        if (r14 == null) goto L54;
        if (r17 != r14.intValue()) goto L54;
        int r18 = r10.a.getLastType();
        if (r2 == null) goto L54;
        if (r18 != r2.intValue()) goto L54;
        r12 = false;
        goto L54
    L32:
        r14 = null;
        goto L33
    L26:
        if (this.a.getTag() != null) goto L29;
        this.a.setTag(r10);
        r0.animate().alpha(0.0f).setDuration(120).start();
        this.a.setAlpha(0.0f);
        this.a.animate().alpha(1.0f).setDuration(160).setStartDelay(80).setListener(new C0089a(this, r10)).start();
        goto L29
    L19:
        r8 = null;
        goto L20
    }

    public a(ECHotAtmosphereView r2, ECPromotionTopTagLinearlayout r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, "hotAtmosphereView");
        Intrinsics.checkNotNullParameter(r3, "topLeftContainer");
        Intrinsics.checkNotNullParameter(r4, "onShowHotAtmosphere");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
