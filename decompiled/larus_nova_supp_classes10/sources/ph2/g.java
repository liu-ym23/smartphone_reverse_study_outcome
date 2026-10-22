package ph2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.presenter.IntroCardPresenter;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardAtmosphereComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardButtonComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardImageComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardInfoComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardPriceComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardTitleComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.facebook.common.util.UriUtil;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends oh2.b {
    public View n;
    public final IntroCardPresenter o;
    public final IntroCardViewModel p;
    public final oh2.e q;
    public final oh2.c r;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            this.a.p.setEventBtmPageId(BtmSDK.INSTANCE.getPageId(PageFinder.via(r3)));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            r2.removeOnAttachStateChangeListener(this);
        }
    }

    static {
    }

    public final String b() {
        return "INTRO_CARD";
    }

    public final int j(QModel r1) {
        return 4;
    }

    public final QIPresenter h() {
        IntroCardPresenter r0 = this.o;
        k(r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.view.View] */
    public final List<QUIModule> i() {
        IntroCardButtonComponent r1 = null;
        if (getContext() == null) goto L43;
        QUIModule[] r0 = new QUIModule[6];
        ph2.a r2 = new ph2.a();
        k(r2.n);
        View r3 = this.n;
        if (r3 == null) goto L9;
        IntroCardAtmosphereComponent r4 = (IntroCardAtmosphereComponent) r3.findViewById(2131393188);
        if (r4 == null) goto L9;
        r4.setArgument(this.q);
        r4.setContainerAbility(this.r);
        Unit r5 = Unit.INSTANCE;
        ?? r6 = r4;
    L10:
        r2.l = r6;
        Unit r7 = Unit.INSTANCE;
        r0[0] = r2;
        d r8 = new d();
        k(r8.n);
        View r9 = this.n;
        if (r9 == null) goto L15;
        IntroCardImageComponent r10 = (IntroCardImageComponent) r9.findViewById(2131376516);
        if (r10 == null) goto L15;
        r10.setArgument(this.q);
        r10.setContainerAbility(this.r);
        ?? r11 = r10;
    L16:
        r8.l = r11;
        r0[1] = r8;
        f r12 = new f();
        k(r12.n);
        View r13 = this.n;
        if (r13 == null) goto L21;
        IntroCardTitleComponent r14 = (IntroCardTitleComponent) r13.findViewById(2131391606);
        if (r14 == null) goto L21;
        r14.setArgument(this.q);
        r14.setContainerAbility(this.r);
        ?? r15 = r14;
    L22:
        r12.l = r15;
        r0[2] = r12;
        c r16 = new c();
        k(r16.n);
        View r17 = this.n;
        if (r17 == null) goto L29;
        ConstraintLayout r18 = r17.findViewById(2131363225);
        if (r18 == null) goto L29;
        IntroCardInfoComponent r19 = (IntroCardInfoComponent) r18.findViewById(2131393195);
        if (r19 == null) goto L30;
        r19.setArgument(this.q);
        r19.setContainerAbility(this.r);
    L30:
        r16.l = r18;
        r0[3] = r16;
        e r20 = new e();
        k(r20.n);
        View r21 = this.n;
        if (r21 == null) goto L35;
        IntroCardPriceComponent r22 = (IntroCardPriceComponent) r21.findViewById(2131393201);
        if (r22 == null) goto L35;
        r22.setArgument(this.q);
        r22.setContainerAbility(this.r);
    L36:
        r20.l = r22;
        r0[4] = r20;
        ph2.b r23 = new ph2.b();
        k(r23.n);
        View r24 = this.n;
        if (r24 == null) goto L41;
        IntroCardButtonComponent r25 = (IntroCardButtonComponent) r24.findViewById(2131393189);
        if (r25 == null) goto L41;
        r25.setArgument(this.q);
        r25.setContainerAbility(this.r);
        r1 = r25;
    L41:
        r23.l = r1;
        r0[5] = r23;
        return CollectionsKt.listOf(r0);
    L35:
        r22 = null;
    L29:
        r18 = null;
    L21:
        r15 = 0;
    L15:
        r11 = 0;
    L9:
        r6 = 0;
        goto L10
    L43:
        return null;
    }

    public final QUIAction c(ArrayList r2) {
        Intrinsics.checkNotNullParameter(r2, "conflictModule");
        return QUIAction.REPLACE;
    }

    @Override // oh2.b
    public final void e(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r12, "context");
        this.m = r12;
        ConstraintLayout r0 = new ConstraintLayout(r12);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r1 = Unit.INSTANCE;
        View r13 = th.a.c(r12, 2131560748, r0, false);
        this.n = r13;
        if (r13 == null) goto L5;
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-1, -2);
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r2.startToStart = 0;
        r2.endToEnd = 0;
        r13.setLayoutParams(r2);
    L5:
        View r14 = this.n;
        if (r14 == null) goto L8;
        r14.setId(View.generateViewId());
    L8:
        View r15 = this.n;
        if (r15 == null) goto L24;
        ECStrokedWaveDraweeView r5 = (ECStrokedWaveDraweeView) r15.findViewById(2131376045);
        if (r5 == null) goto L24;
        r5.setCornerRadius(UtilityKotlinExtentionsKt.c(16));
        ECLiveABUtils r3 = ECLiveABUtils.INSTANCE;
        if (r3.getEC_LIVE_INTRO_CARD_SUPPORT_NEW_STROKE() == false) goto L15;
        ECStrokedWaveDraweeView.k(r5, UtilityKotlinExtentionsKt.c(Double.valueOf(0.75d)), null, null, 6);
    L16:
        int r16 = r3.getEC_LIVE_INTRO_CARD_BACKGROUND_CHANGE_TYPE();
        if (r16 != 1) goto L19;
        int r17 = 2131234599;
    L23:
        String r6 = UriUtil.getUriForResourceId(r17).toString();
        int r18 = r.h;
        h0.e(r5, r6, r.a.b("ec_live_intro_card_background_image"), null, null, 120);
        goto L24
    L19:
        if (r16 == 2) goto L21;
        r17 = 2131234598;
        goto L23
    L21:
        r17 = 2131234600;
        goto L23
    L15:
        oh2.g.a(r5, UtilityKotlinExtentionsKt.c(16), UtilityKotlinExtentionsKt.c(Double.valueOf(0.75d)), new int[0], new float[0]);
    L24:
        View r19 = this.n;
        if (r19 == null) goto L27;
        r0.addView(r19);
    L27:
        this.l = r0;
        r0.addOnAttachStateChangeListener(new b(this));
    }

    public final QIPresenter k(QIPresenter r3) {
        if ((r3 instanceof oh2.a) == true) goto L5;
        QIPresenter r0 = null;
    L6:
        oh2.a r1 = (oh2.a) r0;
        if (r1 == null) goto L9;
        r1.f = this.q;
        r1.g = this.r;
    L9:
        return r3;
    L5:
        r0 = r3;
        goto L6
    }

    public g(IntroCardViewModel r2, oh2.e r3, oh2.c r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "argument");
        Intrinsics.checkNotNullParameter(r4, "containerAbility");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.o = new IntroCardPresenter();
    }
}
