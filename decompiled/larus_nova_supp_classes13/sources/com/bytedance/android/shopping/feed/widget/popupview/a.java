package com.bytedance.android.shopping.feed.widget.popupview;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.inflow.view.f;
import com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends BubblePopupWindow {
    public static final /* synthetic */ int h = 0;
    public boolean a;
    public rd3.a b;
    public String c;
    public String d;
    public final com.bytedance.android.shopping.feed.widget.popupview.b e;
    public final View f;
    public final InterfaceC0071a g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.popupview.a$a, reason: collision with other inner class name */
    public interface InterfaceC0071a {
        void a();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ rd3.a b;

        public b(a r1, rd3.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            a r0 = this.a;
            r0.show(r0.f, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(-1.5d)), 0, com.bytedance.android.shopping.extensions.b.b(2), 80);
            FeedProductEventTracker r1 = FeedProductEventTracker.a;
            rd3.a r2 = this.b;
            String r3 = k.d(CollectionsKt.emptyList());
            String r4 = LocationType.INFLOW_MAIN_CARD_IMAGE.getType();
            String r6 = this.a.c;
            String r7 = this.b.d;
            r1.getClass();
            FeedProductEventTracker.w("inflow_low_price_entrance_show", r2, r3, r4, "c12364.d801587", r6, r7);
            this.a.a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void dismiss() {
        if (this.a == true) goto L5;
        return;
    L5:
        this.a = false;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        this.g.a();
        rd3.a r0 = this.b;
        if (r0 == null) goto L13;
        ProductFeedViewModel r1 = r0.c;
        if (r1 == null) goto L14;
        MutableLiveData<Boolean> r2 = r1.getPopupViewLiveData();
        if (r2 == null) goto L15;
        r2.removeObserver(this.e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.g.a();
        rd3.a r0 = this.b;
        if (r0 == null) goto L10;
        ProductFeedViewModel r1 = r0.c;
        if (r1 == null) goto L11;
        MutableLiveData<Boolean> r2 = r1.getPopupViewLiveData();
        if (r2 == null) goto L12;
        r2.removeObserver(this.e);
        return;
    L12:
        return;
    L11:
        return;
    }

    public a(View r4, f r5) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        Intrinsics.checkNotNullParameter(r5, "iinflowHeadImageSearchPopupView");
        super(ExtKt.getActivity(r4), false, true);
        this.f = r4;
        this.g = r5;
        this.e = new com.bytedance.android.shopping.feed.widget.popupview.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(rd3.a r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        Promotion r0 = r11.f();
        if (r0 == null) goto L9;
        PromotionProductStruct r1 = r0.getPromotionInfo();
        if (r1 == null) goto L9;
        PromotionProductExtraStruct r2 = r1.getExtraInfo();
        if (r2 == null) goto L9;
        String r3 = r2.getImgSearchSchema();
    L11:
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        return;
    L19:
        this.b = r11;
        Promotion r5 = r11.f();
        if (r5 == null) goto L27;
        PromotionProductStruct r6 = r5.getPromotionInfo();
        if (r6 == null) goto L27;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L27;
        String r8 = r7.getProductId();
        if (r8 == null) goto L27;
    L28:
        this.c = r8;
        this.d = r12;
        Context r13 = this.f.getContext();
        if ((r13 instanceof LifecycleOwner) == true) goto L31;
        r13 = null;
    L31:
        LifecycleOwner r14 = (LifecycleOwner) r13;
        if (r14 == null) goto L38;
        ProductFeedViewModel r9 = r11.c;
        if (r9 == null) goto L38;
        MutableLiveData<Boolean> r10 = r9.getPopupViewLiveData();
        if (r10 == null) goto L38;
        r10.observe(r14, this.e);
    L38:
        rd3.a r15 = this.b;
        if (r15 == null) goto L47;
        Promotion r16 = r15.f();
        if (r16 == null) goto L47;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L47;
        PromotionProductExtraStruct r18 = r17.getExtraInfo();
        if (r18 == null) goto L47;
        final String r19 = r18.getImgSearchSchema();
    L48:
        final LinearLayout r20 = new LinearLayout(this.f.getContext());
        r20.setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(40)));
        r20.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(11), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(11));
        r20.setGravity(16);
        ImageView r21 = new ImageView(r20.getContext());
        r20.setGravity(16);
        r21.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16)));
        int r22 = Build.VERSION.SDK_INT;
        r21.setBackground(ContextCompat.getDrawable(r21.getContext(), 2131234432));
        Unit r23 = Unit.INSTANCE;
        r20.addView(r21);
        TextView r24 = new TextView(r20.getContext());
        r24.setGravity(16);
        r24.setPadding(com.bytedance.android.shopping.extensions.b.b(4), 0, com.bytedance.android.shopping.extensions.b.b(2), 0);
        String r25 = r24.getContext().getString(2131896517);
        r24.setIncludeFontPadding(false);
        r24.setGravity(16);
        r24.setText(r25);
        r24.setTextColor(ContextCompat.getColor(r24.getContext(), 2131101749));
        r24.setTextSize(13.0f);
        if (r22 < 28) goto L51;
        Typeface r26 = Typeface.create(null, 500, false);
    L52:
        r24.setTypeface(r26);
        r20.addView(r24);
        ImageView r27 = new ImageView(r20.getContext());
        r20.setGravity(16);
        r27.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12)));
        r27.setBackground(ContextCompat.getDrawable(r27.getContext(), 2131234590));
        r20.addView(r27);
        com.bytedance.android.ec.core.widget.f.c(r20, null, null, new InflowHeadImageSearchPopupView$initView$$inlined$apply$lambda$1(r20, this, r19), 3);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L55
        setBubbleView(r20, Boolean.TRUE);     // Catch: Throwable -> L55
        Object r111 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Throwable r112 = Result.exceptionOrNull-impl(r111);
        if (r112 == null) goto L60;
        ECExceptionMonitor.e(r112);
    L60:
        setBgColor(-1);
        setNeedPath(false);
        setAutoDismissDelayMillis(3000);
        setShadowLayerYOffset(0);
        setOutsideTouchable(true);
        setFocusable(false);
        setInAnimTime(100);
        setOutAnimTime(0);
        setOutsideTouchable(true);
        setArrowVerticalSize(7);
        setArrowLongSize(19);
        setHorizontalPadding(0);
        this.f.post(new b(this, r11));
        return;
    L55:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L51:
        r26 = Typeface.DEFAULT_BOLD;
    L47:
        r19 = null;
    L27:
        r8 = "";
        goto L28
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L9:
        r3 = null;
        goto L11
    }
}
