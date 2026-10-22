package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardTitleComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.o0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroSkinHelper;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mh2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardTitlePresenter extends oh2.a {
    public boolean i;

    public static final class a<T> implements Observer {
        public final /* synthetic */ IntroCardTitlePresenter a;

        public a(IntroCardTitlePresenter r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.TextView, com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardTitleComponent] */
        public final void onChanged(Object r12) {
            IntroPromotionVO r13 = (IntroPromotionVO) r12;
            boolean r0 = false;
            if (r13 == null) goto L55;
            o0 r1 = r13.getTitle();
            if (r1 == null) goto L70;
            IntroCardTitlePresenter r2 = this.a;
            if (r2.i == true) goto L71;
            s0 r14 = r13.getControl();
            if (r14 == null) goto L11;
            int r15 = r14.d();
        L12:
            ?? r3 = (IntroCardTitleComponent) r2.w().f();
            Intrinsics.checkNotNullParameter(r1, "titleModel");
            r3.setVisibility(0);
            th2.b r16 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
            if (r16 == null) goto L18;
            ECLiveSkinViewUIConfig r17 = r16.u();
            if (r17 == null) goto L18;
            ECLiveSkinTextElement r18 = r17.getText();
            if (r18 == null) goto L18;
        L19:
            IntroSkinHelper.a(r3, r18);
            String r4 = r1.b();
            List<ECRitTag> r19 = r1.c();
            Integer r5 = Integer.valueOf((int) r1.a());
            if (r5.intValue() <= 0) goto L23;
            r0 = true;
        L23:
            if (r0 == true) goto L26;
            r5 = null;
        L26:
            if (r5 == null) goto L28;
            int r6 = r5.intValue();
        L29:
            if (r19 == null) goto L46;
            ArrayList r7 = new ArrayList();
            Iterator<T> r110 = r19.iterator();
        L32:
            if (r110.hasNext() == false) goto L37;
            ECUrlModel r8 = ((ECRitTag) r110.next()).getTextIcon();
            if (r8 == null) goto L32;
            r7.add(r8);
            goto L32
        L37:
            if ((!r7.isEmpty()) == true) goto L40;
            r7 = null;
        L40:
            if (r7 == null) goto L46;
            ECUrlModel r111 = (ECUrlModel) CollectionsKt.firstOrNull(r7);
            if (r111 == null) goto L44;
            float r9 = r111.getHeight();
        L45:
            r3.c = q.a(r7, r4, 2.0f, r9, r3, true, true);
        L47:
            r3.setMaxLines(r6);
            r3.setFocusable(true);
            List<ECRitTag> r112 = r1.c();
            if (r112 == null) goto L72;
            Iterator<T> r113 = r112.iterator();
        L51:
            if (r113.hasNext() == false) goto L73;
            RitTagTrack r10 = ((ECRitTag) r113.next()).getTagTrack();
            if (r10 == null) goto L51;
            r10.setVisibile(true);
            goto L51
        L73:
            return;
        L72:
            return;
        L44:
            r9 = 0.0f;
        L46:
            r3.setText(r4);
            Unit r114 = Unit.INSTANCE;
            goto L47
        L28:
            r6 = 1;
        L18:
            r18 = new ECLiveSkinTextElement(14, CollectionsKt.listOf("#FFFFFF"), MonitorLevel.FATAL);
            goto L19
        L11:
            r15 = 0;
            goto L12
        L71:
            return;
        L70:
            return;
        L55:
            IntroCardTitlePresenter r115 = this.a;
            Disposable r11 = ((IntroCardTitleComponent) r115.w().f()).c;
            if (r11 == null) goto L58;
            r11.dispose();
        L58:
            r115.i = false;
            Unit r116 = Unit.INSTANCE;
        }
    }

    public IntroCardTitlePresenter() {
        super(0);
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
        Disposable r0 = ((IntroCardTitleComponent) w().f()).c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.i = false;
    }

    @Override // oh2.a
    public final void D(oh2.h r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L7;
        bk2.e<IntroPromotionVO> r1 = r0.getCardState();
        if (r1 == null) goto L7;
        r1.b(r4.getLifecycleOwner(), new a(this));
    L7:
        IntroCardViewModel r2 = this.e;
        if (r2 == null) goto L13;
        bk2.e<bk2.a<Boolean>> r3 = r2.getSecondFrameHasTitleAction();
        if (r3 == null) goto L14;
        r3.b(r4.getLifecycleOwner(), new ActionObserver(new IntroCardTitlePresenter$bind$2(this)));
        return;
    L14:
        return;
    }
}
