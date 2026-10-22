package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageDynamicOpenRegion;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$8 extends FunctionReferenceImpl implements Function1<LivePromotionPageDynamicOpenRegion, Unit> {
    public LivePromotionListGroupPresenter$observeData$8(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "initListOpenArea", "initListOpenArea(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;)V", 0);
    }

    public final void invoke(LivePromotionPageDynamicOpenRegion r17) {
        LivePromotionListGroupPresenter r1 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r2 = LivePromotionListGroupPresenter.D;
        r1.getClass();
        if (r17 == null) goto L92;
        LivePromotionListGroupPresenter$initListOpenArea$1 r8 = new LivePromotionListGroupPresenter$initListOpenArea$1(r1);
        LivePromotionListGroupPresenter$initListOpenArea$2 r9 = new LivePromotionListGroupPresenter$initListOpenArea$2(r1);
        FrameLayout r10 = r1.s;
        if (r10 == null) goto L30;
        ll.a r14 = r17.getListOpenSidebar();
        if (r14 != null) goto L10;
    L17:
        r8.invoke(0);
        Integer r3 = Integer.valueOf(((ViewGroup) r1.Z().b(2131378074).f()).getVisibility());
        if (r3.intValue() == 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        r3 = null;
    L24:
        if (r3 == null) goto L26;
        r3.intValue();
        r9.m996invoke();
    L26:
        LigoViewManager r5 = r1.A;
        if (r5 == null) goto L29;
        r5.d(r10);
        Unit r6 = Unit.INSTANCE;
    L29:
        r1.B.add(r10);
        goto L30
    L20:
        r4 = false;
        goto L21
    L10:
        if (r1.C == true) goto L12;
        r8.invoke(EComABUtils.getListLeftMarginInInstantFusion());
    L12:
        LigoViewManager r15 = r1.A;
        if (r15 == null) goto L15;
        ll.b r7 = r15.a(r10, r14, true, new h(r14, r10, r1, r8, r9));
    L16:
        if (r7 != null) goto L29;
    L15:
        r7 = null;
    L30:
        FrameLayout r11 = r1.p;
        if (r11 == null) goto L53;
        ll.a r12 = r17.getListOpenFloatBottom();
        if (r12 == null) goto L42;
        LigoViewManager r13 = r1.A;
        if (r13 != null) goto L90;
        ll.b r16 = null;
    L41:
        if (r16 == null) goto L42;
    L52:
        r1.B.add(r11);
        goto L53
    L90:
        if (r1.u == false) goto L39;
        r1.u = false;     // Catch: Throwable -> L89
        int r18 = ak2.n.a;     // Catch: Throwable -> L89
    L39:
        r16 = w83.i.a.a(r13, r11, r12, false, 12);
    L42:
        LigoViewManager r19 = r1.A;
        if (r19 == null) goto L45;
        r19.d(r11);
    L45:
        com.bytedance.android.shopping.ligo.context.b<?> r20 = r1.z;
        if (r20 == null) goto L48;
        r20.f("cart_icon_loc");
    L48:
        com.bytedance.android.shopping.ligo.context.b<?> r21 = r1.z;
        if (r21 == null) goto L51;
        r21.f("live_list_perf_data");
    L51:
        com.bytedance.android.ec.core.arch.event.c.e(r1.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.c(0));
        Unit r22 = Unit.INSTANCE;
    L53:
        FrameLayout r23 = (FrameLayout) r1.Z().b(2131372800).f();
        ll.a r24 = r17.getListOpenTab();
        if (r24 == null) goto L58;
        LigoViewManager r25 = r1.A;
        if (r25 == null) goto L61;
        w83.i.a.a(r25, r23, r24, false, 12);
    L61:
        r1.B.add(r23);
        if (((QFragmentPresenter) r1).e.isDetached() == true) goto L85;
        if (((QFragmentPresenter) r1).e.isResumed() == false) goto L85;
        View r26 = ((QFragmentPresenter) r1).e.getView();
        if (r26 == null) goto L68;
        View r27 = r26.findViewById(2131387424);
    L70:
        if ((r27 instanceof ViewGroup) == true) goto L72;
        View r110 = null;
    L73:
        ViewGroup r111 = (ViewGroup) r110;
        if (r111 == null) goto L85;
        ll.a r28 = r17.getListOpenCover();
        if (r28 == null) goto L80;
        LigoViewManager r29 = r1.A;
        if (r29 == null) goto L83;
        w83.i.a.a(r29, r111, r28, false, 12);
    L83:
        r1.B.add(r111);
        goto L85
    L80:
        LigoViewManager r30 = r1.A;
        if (r30 == null) goto L83;
        r30.d(r111);
        Unit r31 = Unit.INSTANCE;
        goto L83
    L72:
        r110 = r27;
        goto L73
    L68:
        r27 = null;
    L85:
        if (r1.d0().isInSplitScreen() == false) goto L87;
        r1.k0();
    L87:
        r1.C = true;
        return;
    L58:
        LigoViewManager r32 = r1.A;
        if (r32 == null) goto L61;
        r32.d(r23);
        Unit r33 = Unit.INSTANCE;
        goto L61
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LivePromotionPageDynamicOpenRegion) r1);
        return Unit.INSTANCE;
    }
}
