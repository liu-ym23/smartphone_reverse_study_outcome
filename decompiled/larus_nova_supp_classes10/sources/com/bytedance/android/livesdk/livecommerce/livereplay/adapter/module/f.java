package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cf.j;
import cf.l;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter.ECProductCardPresenter;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends QUIModule {
    public com.bytedance.android.livesdk.livecommerce.promotion.card.b l;
    public final List<j> m;
    public final ni2.b n;

    public final QIPresenter h() {
        ECProductCardPresenter r0 = new ECProductCardPresenter(this, this.n);
        ((ArrayList) this.m).add(r0);
        return r0;
    }

    public f(ni2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super(0);
        this.n = r2;
        this.m = new ArrayList();
    }

    public final int j(QModel r3) {
        if (r3 != null) goto L6;
        return 8;
    L6:
        if ((r3 instanceof ni2.a) == true) goto L8;
        r3 = null;
    L8:
        ni2.a r4 = (ni2.a) r3;
        if (r4 != null) goto L12;
        return 8;
    L12:
        if (r4.m == false) goto L15;
        return 8;
    L15:
        if (r4.a == false) goto L18;
        return 0;
    L18:
        return 8;
    }

    public final View f(Context r20, ViewGroup r21) {
        Intrinsics.checkNotNullParameter(r20, "context");
        if (r21 != null) goto L6;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("[ECProductCardUIModule onCreateView] parent is null", null);
        return new FrameLayout(r20);
    L6:
        String r5 = this.n.d.f(null);
        String r6 = this.n.d.d(null);
        this.n.d.g();
        String r8 = this.n.d.e(null);
        this.n.d.c();
        this.n.d.i();
        this.n.d.j();
        this.n.d.h();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r18 = new com.bytedance.android.livesdk.livecommerce.promotion.card.g.a(r5, r6, "", r8, "", "", "", "", this.n.d.a(null), this.n.d.b(null), null, true, 7168);
        d r7 = new d(this);
        e r9 = new e(this);
        int r4 = ECSdk.a;
        l r10 = (l) ECSdk.a(l.class);
        if (r10 == null) goto L15;
        int r11 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.n.h) == false) goto L11;
        c r12 = new c(this);
    L12:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r2 = r10.Da(r21, new com.bytedance.android.livesdk.livecommerce.promotion.card.g(r18, r7, r9, r12, this.n.c), false);
        if (r2 == null) goto L15;
        int r13 = b.a;
        final String r14 = this.n.h;
        Intrinsics.checkNotNullParameter(r2, "promotionCard");
        Intrinsics.checkNotNullParameter(r14, "enterFrom");
        r2.w2(new com.bytedance.android.livesdk.livecommerce.promotion.card.j(((k) IPromotionUIConfig.a.getValue()).a).a(PromotionCardModuleName.Title, ECProductCardUIConfig$updateUI$1.INSTANCE).a(PromotionCardModuleName.ImageAreaModule, ECProductCardUIConfig$updateUI$2.INSTANCE).a(PromotionCardModuleName.ImageAreaIndex, ECProductCardUIConfig$updateUI$3.INSTANCE).a(PromotionCardModuleName.BottomModule, ECProductCardUIConfig$updateUI$4.INSTANCE).a(PromotionCardModuleName.InfoAreaModule, new ECProductCardUIConfig$updateUI$5(r14)).a(PromotionCardModuleName.Parent, ECProductCardUIConfig$updateUI$6.INSTANCE).a);
        this.l = r2;
        goto L15
    L11:
        r12 = null;
    L15:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r3 = this.l;
        if (r3 != null) goto L20;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("[ECProductCardUIModule onCreateView] createNewPromotionListItem error", null);
        return new FrameLayout(r20);
    L20:
        return com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r3);
    }
}
