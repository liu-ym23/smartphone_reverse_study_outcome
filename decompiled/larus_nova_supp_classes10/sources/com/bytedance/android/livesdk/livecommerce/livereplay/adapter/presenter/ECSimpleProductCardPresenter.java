package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.event.c;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.facebook.common.util.UriUtil;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECSimpleProductCardPresenter extends QPresenter implements ViewTreeObserver.OnPreDrawListener {
    public ni2.a e;
    public final Rect f;
    public final String g;
    public final ViewModelProvider.Factory h;

    public final void C() {
        this.e = null;
        w().f().getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (w().f().getGlobalVisibleRect(this.f) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L15;
        ni2.a r1 = this.e;
        if (r1 == null) goto L15;
        int r3 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        AbsECScrollProductCardBaseVideModel r4 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(u(), this.g, this.h);
        if (r4 == null) goto L15;
        c.d(r4, new com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a.i(r1, y()));
    L15:
        if (mi2.a.b == false) goto L22;
        mi2.a.b = false;
        i r2 = i.a;
        d r5 = r2.get(mi2.a.a);
        if (r5 == null) goto L19;
        r5.a("render_end");
    L19:
        d r6 = r2.get(mi2.a.a);
        if (r6 == null) goto L22;
        r6.report();
    L22:
        return true;
    L5:
        if (w().f().isShown() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void A(QModel r9) {
        TextView r1 = null;
        if ((r9 instanceof ni2.a) == true) goto L5;
        QModel r0 = null;
    L6:
        this.e = (ni2.a) r0;
        if (r9 != null) goto L11;
        ECPromotionImageView r10 = w().b(2131382338).f();
        r10.setForceRadius(10);
        r10.setCallerContext(new r("ec_live", "ec_live_replay_simple_product_image"));
        ECUIPromotion r2 = new ECUIPromotion();
        UriUtil.getUriForResourceId(2131234620).toString();
        Unit r3 = Unit.INSTANCE;
        ECLiveImageUtils.h(r10, r2, 1, false, false);
        ECLiveImageUtils.g(r10, UriUtil.getUriForResourceId(2131234300).toString());
        return;
    L11:
        if ((r9 instanceof ni2.a) == true) goto L13;
        r9 = null;
    L13:
        final ni2.a r11 = (ni2.a) r9;
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.j != null) goto L19;
        return;
    L19:
        cl.d r6 = k.a();
        if (r6 == null) goto L22;
        r6.c(w().f());
    L22:
        ECPromotionImageView r5 = w().b(2131382338).f();
        r5.setForceRadius(10);
        r5.setCallerContext(new r("ec_live", "ec_live_replay_simple_product_image"));
        ECUIPromotion r4 = r11.j;
        ECLiveImageUtils.h(r5, r4, r4.getStatus(), false, false);
        ECLiveImageUtils.g(r5, r11.j.getBorderImageUrl());
        TextView r7 = w().b(2131390775);
        if (r11.h == false) goto L31;
        r7.g(0);
        r7.e(String.valueOf(r11.j.getIronIndex()));
        if ((r7 instanceof TextView) == false) goto L28;
        r1 = r7;
    L28:
        TextView r8 = r1;
        if (r8 == null) goto L32;
        c0.b(r8, MonitorLevel.FATAL);
    L32:
        int r12 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        final AbsECScrollProductCardBaseVideModel r13 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(u(), this.g, this.h);
        w().f().getViewTreeObserver().addOnPreDrawListener(this);
        f.a(w(), new ECSimpleProductCardPresenter$onBind$4(this, r13, r11));
        return;
    L31:
        r7.c();
        goto L32
    L5:
        r0 = r9;
        goto L6
    }

    public ECSimpleProductCardPresenter(String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.g = r2;
        this.h = r3;
        this.f = new Rect();
    }
}
