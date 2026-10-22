package com.bytedance.android.shopping.inflow.view;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.model.feedbackboard.FeedbackBoardDataUtils;
import com.bytedance.android.shopping.feed.repository.api.ReqFeedbackPanelDataViewType;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.searchsimilar.SearchSimilarView;
import com.bytedance.android.shopping.feedbackpanel.FeedbackPanelDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ MainCardImageBannerHolder a;
    public final /* synthetic */ rd3.a b;
    public final /* synthetic */ ECUrlModel c;

    public c(MainCardImageBannerHolder r1, rd3.a r2, ECUrlModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r24) {
        MainCardImageBannerHolder r9 = this.a;
        rd3.a r12 = this.b;
        ECUrlModel r10 = this.c;
        int r0 = MainCardImageBannerHolder.j;
        r9.getClass();
        if (r12 == null) goto L11;
        Promotion r1 = r12.f();
        if (r1 == null) goto L11;
        PromotionProductStruct r2 = r1.getPromotionInfo();
        if (r2 == null) goto L11;
        PromotionProductExtraStruct r3 = r2.getExtraInfo();
        if (r3 == null) goto L11;
        String r13 = r3.getImgSearchSchema();
    L12:
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        if (r12 == null) goto L84;
        if (r13 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L84;
        if (ld3.c.a() != 1) goto L79;
        com.bytedance.android.shopping.feed.model.feedbackboard.e r5 = FeedbackBoardDataUtils.a;
        FeedbackBoardDataUtils.a(ReqFeedbackPanelDataViewType.VIDEO_INNER_FLOW.getType());
        if (FeedbackBoardDataUtils.a != null) goto L107;
        com.bytedance.android.shopping.feed.model.feedbackboard.e r6 = null;
    L35:
        r14.element = r6;
        if (r6 == null) goto L77;
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = null;
        boolean r11 = com.bytedance.android.shopping.feed.utils.f.b.isPlaying();
        SearchSimilarView r15 = new SearchSimilarView(((RecyclerView.ViewHolder) r9).itemView.getContext(), null, 6, 0);
        if (r10 == null) goto L40;
        String r16 = r10.getFirstUrl();
    L41:
        r15.a(r12, r16, ((RecyclerView.ViewHolder) r9).itemView, new d(r8));
        int r17 = ce3.a.a;
        com.bytedance.android.shopping.feed.model.feedbackboard.b r18 = r6.a();
        String r19 = "";
        if (r18 == null) goto L45;
        String r20 = r18.c();
        if (r20 == null) goto L45;
    L46:
        int r110 = (int) (((double) k1.j(((RecyclerView.ViewHolder) r9).itemView.getContext())) * 0.51d);
        com.bytedance.android.shopping.feed.model.feedbackboard.e r111 = FeedbackBoardDataUtils.a;
        Intrinsics.checkNotNullParameter(r6, "panelData");
        ArrayList r112 = new ArrayList();
        com.bytedance.android.shopping.feed.model.feedbackboard.b r113 = r6.a();
        if (r113 == null) goto L49;
        List<com.bytedance.android.shopping.feed.model.feedbackboard.f> r114 = r113.b();
    L50:
        if (r114 == null) goto L69;
        Iterator r115 = r114.iterator();
    L53:
        if (r115.hasNext() == false) goto L69;
        List<com.bytedance.android.shopping.feed.model.feedbackboard.a> r116 = ((com.bytedance.android.shopping.feed.model.feedbackboard.f) r115.next()).b();
        ArrayList r117 = new ArrayList();
        if (r116 == null) goto L68;
        Iterator<T> r118 = r116.iterator();
    L58:
        if (r118.hasNext() == false) goto L68;
        com.bytedance.android.shopping.feed.model.feedbackboard.a r21 = (com.bytedance.android.shopping.feed.model.feedbackboard.a) r118.next();
        String r22 = r21.a();
        String r23 = r19;
        Iterator r25 = r115;
        if (r22 == null) goto L63;
        r19 = r22;
    L63:
        ECUrlModel r119 = r21.c();
        String r26 = r21.b();
        ECUrlModel r27 = r10;
        if (r26 != null) goto L66;
        String r120 = r23;
    L67:
        r117.add(new de3.c(r19, r119, r120));
        r115 = r25;
        r10 = r27;
        r19 = r23;
        goto L58
    L66:
        r120 = r26;
    L68:
        r112.add(new de3.b(r117));
        r115 = r115;
        r10 = r10;
        r19 = r19;
    L69:
        de3.a r28 = new de3.a(r20, r110, r112);
        int r121 = 1;
        e r29 = new e(r6, r8, r11, r7, r15, r12, r9, r10, r12);
        Intrinsics.checkNotNullParameter(r28, "data");
        FeedbackPanelDialog r30 = new FeedbackPanelDialog();
        Intrinsics.checkNotNullParameter(r28, "data");
        r30.d = r28;
        r30.e = r29;
        r30.l = r28.b;
        ProductFeedViewModel r31 = r12.c;
        if (r31 == null) goto L76;
        Fragment r32 = r31.getFlowFragment();
        if (r32 == null) goto L76;
        FragmentManager r33 = r32.getFragmentManager();
        if (r33 == null) goto L76;
        r30.U90(r33);
    L76:
        Unit r34 = Unit.INSTANCE;
        r8.element = r30;
    L86:
        if (ld3.c.a() != r121) goto L97;
        if (r13 != null) goto L89;
    L92:
        boolean r122 = true;
    L93:
        if (r122 == false) goto L95;
    L105:
        return false;
    L95:
        if (((com.bytedance.android.shopping.feed.model.feedbackboard.e) r14.element) == null) goto L105;
    L104:
        return true;
    L89:
        if (r13.length() == 0) goto L92;
        r122 = false;
        goto L93
    L97:
        if (r13 != null) goto L99;
    L102:
        boolean r123 = true;
    L103:
        if (r123 == true) goto L105;
    L99:
        if (r13.length() == 0) goto L102;
        r123 = false;
        goto L103
    L49:
        r114 = null;
    L45:
        r20 = "";
        goto L46
    L40:
        r16 = null;
        goto L41
    L77:
        r121 = 1;
        goto L86
    L107:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L28
        Object r36 = Result.constructor-impl((com.bytedance.android.shopping.feed.model.feedbackboard.e) u0.b(u0.d(FeedbackBoardDataUtils.a), com.bytedance.android.shopping.feed.model.feedbackboard.e.class));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r36) == false) goto L33;
        r36 = null;
    L33:
        r6 = (com.bytedance.android.shopping.feed.model.feedbackboard.e) r36;
    L28:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L79:
        r13 = r13;
        r14 = r14;
        r121 = 1;
        r9.h.setVisibility(0);
        com.bytedance.android.shopping.feed.widget.popupview.a r38 = new com.bytedance.android.shopping.feed.widget.popupview.a(r9.i, new f(r9));
        if (r10 == null) goto L82;
        String r39 = r10.getFirstUrl();
    L83:
        r38.b(r12, r39);
        goto L86
    L82:
        r39 = null;
        goto L83
    L16:
        if (r13.length() == 0) goto L19;
        r4 = false;
    L84:
        r13 = r13;
        r14 = r14;
        r121 = 1;
    L11:
        r13 = null;
        goto L12
    }
}
