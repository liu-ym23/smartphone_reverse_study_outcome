package com.bytedance.android.shopping.inflow.view;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.model.feedbackboard.FeedbackBoardDataUtils;
import com.bytedance.android.shopping.feed.repository.api.FeedbackPanelApi;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.searchsimilar.SearchSimilarView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements ce3.c {
    public final /* synthetic */ com.bytedance.android.shopping.feed.model.feedbackboard.e a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ SearchSimilarView e;
    public final /* synthetic */ rd3.a f;
    public final /* synthetic */ MainCardImageBannerHolder g;
    public final /* synthetic */ ECUrlModel h;
    public final /* synthetic */ rd3.a i;

    @Override // ce3.c
    public final void d() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        rd3.a r2 = this.f;
        ECUrlModel r3 = this.h;
        Map<String, String> r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getFirstUrl();
    L6:
        com.bytedance.android.shopping.feed.model.feedbackboard.b r6 = this.a.a();
        if (r6 == null) goto L9;
        r4 = r6.a();
    L9:
        r0.getClass();
        FeedProductEventTracker.x("inflow_price_feedback_panel_show", r2, r5, "c398849.d0", r4, null);
        com.bytedance.android.shopping.feed.utils.f.b.a(((RecyclerView.ViewHolder) this.g).itemView);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // ce3.c
    public final void onResume() {
        com.bytedance.android.shopping.feed.utils.f.b.a(((RecyclerView.ViewHolder) this.g).itemView);
    }

    @Override // ce3.c
    public final void a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "uniqueKey");
        com.bytedance.android.shopping.feed.model.feedbackboard.e r1 = FeedbackBoardDataUtils.a;
        com.bytedance.android.shopping.feed.model.feedbackboard.e r2 = this.a;
        Intrinsics.checkNotNullParameter(r13, "uniqueKey");
        Intrinsics.checkNotNullParameter(r2, "panelData");
        com.bytedance.android.shopping.feed.model.feedbackboard.b r3 = r2.a();
        String r4 = null;
        if (r3 == null) goto L17;
        List<com.bytedance.android.shopping.feed.model.feedbackboard.f> r5 = r3.b();
        if (r5 == null) goto L17;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L17;
        List<com.bytedance.android.shopping.feed.model.feedbackboard.a> r7 = ((com.bytedance.android.shopping.feed.model.feedbackboard.f) r6.next()).b();
        if (r7 == null) goto L8;
        Iterator<T> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L8;
        com.bytedance.android.shopping.feed.model.feedbackboard.a r9 = (com.bytedance.android.shopping.feed.model.feedbackboard.a) r8.next();
        if (Intrinsics.areEqual(r9.a(), r13) == false) goto L13;
    L18:
        com.bytedance.android.shopping.feed.model.feedbackboard.e r10 = FeedbackBoardDataUtils.a;
        if (r9 == null) goto L21;
        Map<String, String> r11 = r9.d();
    L22:
        com.bytedance.android.shopping.feed.model.feedbackboard.b r12 = this.a.a();
        if (r12 == null) goto L25;
        Map<String, String> r14 = r12.a();
    L26:
        LinkedHashMap r15 = new LinkedHashMap();
        if (r11 == null) goto L29;
        r15.putAll(r11);
    L29:
        if (r14 == null) goto L31;
        r15.putAll(r14);
    L31:
        FeedProductEventTracker r16 = FeedProductEventTracker.a;
        rd3.a r17 = this.f;
        ECUrlModel r18 = this.h;
        if (r18 == null) goto L34;
        String r19 = r18.getFirstUrl();
    L35:
        String r20 = "";
        if (r9 == null) goto L39;
        String r21 = r9.a();
        if (r21 == null) goto L39;
    L40:
        if (r9 == null) goto L42;
        String r110 = r9.b();
    L43:
        r16.getClass();
        FeedProductEventTracker.x("inflow_price_feedback_panel_click", r17, r19, r21, r15, r110);
        com.bytedance.android.shopping.feed.model.feedbackboard.e r22 = this.a;
        Intrinsics.checkNotNullParameter(r13, "uniqueKey");
        Intrinsics.checkNotNullParameter(r22, "panelData");
        com.bytedance.android.shopping.feed.model.feedbackboard.b r0 = r22.a();
        if (r0 == null) goto L58;
        List<com.bytedance.android.shopping.feed.model.feedbackboard.f> r23 = r0.b();
        if (r23 == null) goto L58;
        Iterator<T> r24 = r23.iterator();
    L49:
        if (r24.hasNext() == false) goto L58;
        com.bytedance.android.shopping.feed.model.feedbackboard.f r25 = (com.bytedance.android.shopping.feed.model.feedbackboard.f) r24.next();
        List<com.bytedance.android.shopping.feed.model.feedbackboard.a> r26 = r25.b();
        if (r26 == null) goto L49;
        Iterator<T> r27 = r26.iterator();
    L54:
        if (r27.hasNext() == false) goto L49;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.feed.model.feedbackboard.a) r27.next()).a(), r13) == false) goto L54;
        String r111 = r25.a();
    L59:
        boolean r28 = false;
        if (r111 != null) goto L62;
    L65:
        boolean r29 = true;
    L67:
        if ((!r29) == true) goto L70;
        r111 = null;
    L70:
        if (r111 == null) goto L72;
        int r30 = ae3.a.a;
        ae3.a.a(((RecyclerView.ViewHolder) this.g).itemView.getContext(), r111, 0);
    L72:
        if (r9 == null) goto L74;
        r4 = r9.f();
    L74:
        if (r4 != null) goto L76;
    L77:
        r28 = true;
    L78:
        if (r28 == true) goto L106;
        com.bytedance.android.shopping.feed.model.feedbackboard.e r112 = FeedbackBoardDataUtils.a;
        Promotion r113 = this.i.f();
        if (r113 == null) goto L87;
        PromotionProductStruct r114 = r113.getPromotionInfo();
        if (r114 == null) goto L87;
        PromotionProductBaseStruct r115 = r114.getBaseInfo();
        if (r115 == null) goto L87;
        String r116 = r115.getProductId();
        if (r116 == null) goto L87;
    L88:
        Intrinsics.checkNotNullParameter(r116, "pid");
        if (r9 == null) goto L106;
        FeedbackPanelApi r31 = (FeedbackPanelApi) FeedbackBoardDataUtils.c.getValue();
        if (r31 == null) goto L106;
        String r32 = r9.f();
        if (r32 != null) goto L95;
        r32 = "";
    L95:
        String r33 = r9.e();
        if (r33 == null) goto L99;
        r20 = r33;
    L99:
        Observable<Unit> r117 = r31.postGovernanceFeedback(r32, r20, r116, "短视频商品内流");
        if (r117 == null) goto L106;
        Observable r118 = r117.subscribeOn(Schedulers.io());
        if (r118 == null) goto L106;
        Observable r119 = r118.observeOn(AndroidSchedulers.mainThread());
        if (r119 == null) goto L106;
        r119.subscribe(com.bytedance.android.shopping.feed.model.feedbackboard.c.a, com.bytedance.android.shopping.feed.model.feedbackboard.d.a);
    L87:
        r116 = "";
    L106:
        ce3.b r120 = (ce3.b) this.b.element;
        if (r120 == null) goto L124;
        r120.qa();
        return;
    L124:
        return;
    L76:
        if (r4.length() != 0) goto L78;
    L62:
        if (r111.length() == 0) goto L65;
        r29 = false;
    L58:
        r111 = null;
        goto L59
    L42:
        r110 = null;
    L39:
        r21 = "";
        goto L40
    L34:
        r19 = null;
        goto L35
    L25:
        r14 = null;
        goto L26
    L21:
        r11 = null;
    L17:
        r9 = null;
        goto L18
    }

    @Override // ce3.c
    public final void b(FrameLayout r2) {
        r2.addView(this.e);
    }

    @Override // ce3.c
    public final void c(ConstraintLayout r2) {
        if (r2 == null) goto L4;
        r2.setBackgroundResource(2131100008);
    L4:
        if (r2 == null) goto L6;
        r2.setAlpha(0.0f);
    L6:
        this.d.element = r2;
    }

    @Override // ce3.c
    public final void e(boolean r2) {
        if (this.c == true) goto L5;
    L14:
        this.d.element = null;
        this.b.element = null;
        return;
    L5:
        if (ld3.f.a() == false) goto L12;
        if (r2 == true) goto L14;
        ProductFeedViewModel r3 = this.i.c;
        if (r3 == null) goto L14;
        if (r3.isInflowResume() != true) goto L14;
        com.bytedance.android.shopping.feed.utils.f r4 = com.bytedance.android.shopping.feed.utils.f.b;
        r4.h();
        r4.c();
        goto L14
    L12:
        if (r2 == false) goto L14;
        com.bytedance.android.shopping.feed.utils.f r5 = com.bytedance.android.shopping.feed.utils.f.b;
        r5.h();
        r5.c();
        goto L14
    }

    @Override // ce3.c
    public final void f(float r2) {
        this.e.setAlpha(r2);
        ConstraintLayout r0 = (ConstraintLayout) this.d.element;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    public e(com.bytedance.android.shopping.feed.model.feedbackboard.e r1, Ref.ObjectRef r2, boolean r3, Ref.ObjectRef r4, SearchSimilarView r5, rd3.a r6, MainCardImageBannerHolder r7, ECUrlModel r8, rd3.a r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
