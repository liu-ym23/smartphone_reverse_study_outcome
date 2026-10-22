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
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends BubblePopupWindow {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public rd3.a b;
    public String c;
    public final b d;
    public final View e;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            c r2 = this.a;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
            return;
        }
    }

    static {
    }

    public final void dismiss() {
        if (this.a == true) goto L5;
        return;
    L5:
        this.a = false;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        rd3.a r0 = this.b;
        if (r0 == null) goto L13;
        ProductFeedViewModel r1 = r0.c;
        if (r1 == null) goto L14;
        MutableLiveData<Boolean> r2 = r1.getPopupViewLiveData();
        if (r2 == null) goto L15;
        r2.removeObserver(this.d);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        rd3.a r0 = this.b;
        if (r0 == null) goto L10;
        ProductFeedViewModel r1 = r0.c;
        if (r1 == null) goto L11;
        MutableLiveData<Boolean> r2 = r1.getPopupViewLiveData();
        if (r2 == null) goto L12;
        r2.removeObserver(this.d);
        return;
    L12:
        return;
    L11:
        return;
    }

    public c(View r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        super(ExtKt.getActivity(r4), false, true);
        this.e = r4;
        this.d = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(rd3.a r18) {
        Intrinsics.checkNotNullParameter(r18, "anchorInflowFeedItem");
        Promotion r0 = r18.f();
        if (r0 == null) goto L9;
        PromotionProductStruct r1 = r0.getPromotionInfo();
        if (r1 == null) goto L9;
        PromotionProductExtraStruct r2 = r1.getExtraInfo();
        if (r2 == null) goto L9;
        String r3 = r2.getTitleSearchSchema();
    L10:
        boolean r4 = false;
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        return;
    L19:
        this.b = r18;
        Promotion r6 = r18.f();
        final String r7 = "";
        if (r6 == null) goto L27;
        PromotionProductStruct r8 = r6.getPromotionInfo();
        if (r8 == null) goto L27;
        PromotionProductBaseStruct r9 = r8.getBaseInfo();
        if (r9 == null) goto L27;
        String r10 = r9.getProductId();
        if (r10 == null) goto L27;
    L28:
        this.c = r10;
        Context r11 = this.e.getContext();
        if ((r11 instanceof LifecycleOwner) == true) goto L31;
        r11 = null;
    L31:
        LifecycleOwner r12 = (LifecycleOwner) r11;
        if (r12 == null) goto L38;
        ProductFeedViewModel r13 = r18.c;
        if (r13 == null) goto L38;
        MutableLiveData<Boolean> r14 = r13.getPopupViewLiveData();
        if (r14 == null) goto L38;
        r14.observe(r12, this.d);
    L38:
        rd3.a r15 = this.b;
        if (r15 == null) goto L50;
        Promotion r16 = r15.f();
        if (r16 == null) goto L50;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L50;
        PromotionProductBaseStruct r19 = r17.getBaseInfo();
        if (r19 == null) goto L50;
        String r20 = r19.getTitle();
        if (r20 == null) goto L50;
        r7 = r20;
    L50:
        rd3.a r21 = this.b;
        if (r21 == null) goto L59;
        Promotion r22 = r21.f();
        if (r22 == null) goto L59;
        PromotionProductStruct r23 = r22.getPromotionInfo();
        if (r23 == null) goto L59;
        PromotionProductExtraStruct r24 = r23.getExtraInfo();
        if (r24 == null) goto L59;
        final String r25 = r24.getTitleSearchSchema();
    L60:
        LinearLayout r26 = new LinearLayout(this.e.getContext());
        r26.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r26.setGravity(16);
        final TextView r27 = new TextView(r26.getContext());
        b(r27, r27.getContext().getString(2131896507));
        r27.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(11), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(11));
        f.c(r27, null, null, new InflowTitleSearchPopupView$initView$$inlined$apply$lambda$1(r27, this, r7, r25), 3);
        Unit r28 = Unit.INSTANCE;
        r26.addView(r27);
        View r29 = new View(r26.getContext());
        r29.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), com.bytedance.android.shopping.extensions.b.b(12)));
        r29.setBackground(ContextCompat.getDrawable(r29.getContext(), 2131234595));
        r26.addView(r29);
        final LinearLayout r30 = new LinearLayout(r26.getContext());
        r30.setGravity(16);
        r30.setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(11), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(11));
        TextView r31 = new TextView(r30.getContext());
        b(r31, r31.getContext().getString(2131896516));
        r30.addView(r31);
        ImageView r32 = new ImageView(r30.getContext());
        r32.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(11), com.bytedance.android.shopping.extensions.b.b(11)));
        r32.setBackground(ContextCompat.getDrawable(r32.getContext(), 2131234590));
        r30.addView(r32);
        f.c(r30, null, null, new InflowTitleSearchPopupView$initView$$inlined$apply$lambda$2(r30, this, r7, r25), 3);
        r26.addView(r30);
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L63
        setBubbleView(r26, Boolean.TRUE);     // Catch: Throwable -> L63
        Object r34 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L65:
        Throwable r35 = Result.exceptionOrNull-impl(r34);
        if (r35 == null) goto L68;
        ECExceptionMonitor.e(r35);
    L68:
        setBgColor(-1);
        setNeedPath(false);
        setAutoDismissDelayMillis(3000);
        setOutsideTouchable(true);
        setFocusable(false);
        setInAnimTime(100);
        setOutAnimTime(0);
        setOutsideTouchable(true);
        setShadowLayerYOffset(8);
        setArrowVerticalSize(7);
        setArrowLongSize(20);
        setHorizontalPadding(0);
        int[] r36 = new int[2];
        this.e.getLocationOnScreen(r36);
        Integer r37 = ArraysKt.getOrNull(r36, 1);
        if (r37 == null) goto L71;
        int r38 = r37.intValue();
    L73:
        if ((r38 - getHeightWithArrow()) > 0) goto L75;
        r4 = true;
    L75:
        if (r4 == false) goto L77;
        int r39 = 80;
    L78:
        show(this.e, r39, true);
        FeedProductEventTracker r40 = FeedProductEventTracker.a;
        String r41 = k.d(CollectionsKt.emptyList());
        String r42 = LocationType.INFLOW_MAIN_CARD_TITLE.getType();
        String r43 = this.c;
        String r44 = r18.d;
        r40.getClass();
        FeedProductEventTracker.w("inflow_low_price_entrance_show", r18, r41, r42, "c12364.d636043", r43, r44);
        this.a = true;
        return;
    L77:
        r39 = 48;
        goto L78
    L71:
        r38 = 0;
    L63:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L59:
        r25 = null;
    L27:
        r10 = "";
        goto L28
    L13:
        if (r3.length() == 0) goto L16;
        r5 = false;
    L9:
        r3 = null;
        goto L10
    }

    public final void b(TextView r3, String r4) {
        r3.setIncludeFontPadding(false);
        r3.setGravity(16);
        r3.setText(r4);
        r3.setTextColor(ContextCompat.getColor(r3.getContext(), 2131101749));
        r3.setTextSize(13.0f);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Typeface r5 = Typeface.create(null, 500, false);
    L6:
        r3.setTypeface(r5);
        return;
    L5:
        r5 = Typeface.DEFAULT_BOLD;
        goto L6
    }
}
