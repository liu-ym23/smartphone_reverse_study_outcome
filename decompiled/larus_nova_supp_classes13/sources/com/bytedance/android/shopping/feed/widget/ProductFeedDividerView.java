package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.b2;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductFeedDividerView;", "Landroid/widget/FrameLayout;", "", "isBlackStyle", "", "setStyle", "", "color", "setTextAndDividerColor", "", "copyWriting", "setCopyWriting", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "d", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "getAdapter", "()Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "setAdapter", "(Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;)V", "adapter", "h", "I", "getStartColor", "()I", "startColor", "i", "getEndColor", "endColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedDividerView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> a;
    public final View b;
    public boolean c;
    public ProductFeedAdapter d;
    public boolean e;
    public boolean f;
    public ProductFeedViewModel g;
    public final int h;
    public final int i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProductFeedDividerView a;
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.ProductFeedDividerView$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0068a implements DialogInterface.OnClickListener {
            public final /* synthetic */ ECAlertDialog a;

            public DialogInterfaceOnClickListenerC0068a(ECAlertDialog r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                this.a.cancel();
            }
        }

        public a(ProductFeedDividerView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            ProductFeedViewModel r7 = this.a.g;
            if (r7 == null) goto L9;
            MutableLiveData<AnchorV3Param> r8 = r7.getAnchorV3Param();
            if (r8 == null) goto L9;
            AnchorV3Param r9 = (AnchorV3Param) r8.getValue();
            if (r9 == null) goto L9;
            InnerFlowAdRawData r10 = r9.getAdInnerFlowLogExtra();
        L11:
            if (r10 != null) goto L24;
            int r11 = ld3.f.a;
            int r12 = com.bytedance.android.ec.core.opt.ab.p.a;
            Object r1 = "以下商品是平台根据您的偏好所做展示，并非平台收费推广商品，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。";
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
            jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L17
            Object r13 = jj4.a.a("inner_feed_product_attention", String.class, "以下商品是平台根据您的偏好所做展示，并非平台收费推广商品，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。", false);     // Catch: Throwable -> L17
            if (r13 != null) goto L23;
            Intrinsics.throwNpe();     // Catch: Throwable -> L17
        L23:
            String r14 = (String) r13;
        L36:
            ECAlertDialog r0 = new ECAlertDialog(this.b);
            if (ld3.d.e(ld3.d.b()) == false) goto L39;
            View r4 = new View(this.b);
            r4.setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(24)));
            r0.setTopCustomView(r4);
        L39:
            r0.setMessage(r14);
            r0.setPositiveButton(ag4.a.d(2131897346), new DialogInterfaceOnClickListenerC0068a(r0));
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L48;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L48:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
        L43:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            return;
        L17:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r15) == true) goto L22;
            r1 = r15;
        L22:
            r13 = r1;
            goto L23
        L24:
            int r16 = ld3.f.a;
            int r17 = com.bytedance.android.ec.core.opt.ab.p.a;
            Object r18 = "以下商品是平台根据您的偏好所做展示，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。";
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L29
            jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L29
            Object r21 = jj4.a.a("inner_feed_product_attention_ad", String.class, "以下商品是平台根据您的偏好所做展示，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。", false);     // Catch: Throwable -> L29
            if (r21 != null) goto L35;
            Intrinsics.throwNpe();     // Catch: Throwable -> L29
        L35:
            r14 = (String) r21;
        L29:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            Object r23 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r23) == true) goto L34;
            r18 = r23;
        L34:
            r21 = r18;
        L9:
            r10 = null;
            goto L11
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ProductFeedDividerView a;

        public b(ProductFeedDividerView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a(2131387877).setVisibility(8);
        }
    }

    public static final class c {
        public static String a(int r1) {
            if (r1 != 0) goto L4;
            return "big_card";
        L4:
            if (r1 != 1) goto L6;
            return "small_card";
        L6:
            if (r1 == 2) goto L8;
            return "";
        L8:
            return "biserial_card";
        }
    }

    static {
    }

    public ProductFeedDividerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFeedDividerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        ProductFeedAdapter r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        if (r0.y != 0) goto L10;
        TextView r1 = (TextView) a(2131378182);
        int r2 = g1.a;
        r1.setText(g1.a.c(getContext(), 2131913807, new Object[0]));
        ImageView r3 = (ImageView) a(2131378181);
        if (r3 == null) goto L22;
        r3.setImageResource(2131233547);
        return;
    L22:
        return;
    L10:
        ProductFeedAdapter r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L14:
        if (r4.y != 1) goto L18;
        TextView r5 = (TextView) a(2131378182);
        int r6 = g1.a;
        r5.setText(g1.a.c(getContext(), 2131914041, new Object[0]));
        ImageView r7 = (ImageView) a(2131378181);
        if (r7 == null) goto L24;
        r7.setImageResource(2131233549);
        return;
    L24:
        return;
    L18:
        TextView r8 = (TextView) a(2131378182);
        int r9 = g1.a;
        r8.setText(g1.a.c(getContext(), 2131914041, new Object[0]));
        ImageView r10 = (ImageView) a(2131378181);
        if (r10 == null) goto L26;
        r10.setImageResource(2131233548);
        return;
    }

    public final ProductFeedAdapter getAdapter() {
        ProductFeedAdapter r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ProductFeedAdapter r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        if (r0.w != 0) goto L8;
        return;
    L8:
        if (this.f == true) goto L40;
        b2 r1 = new b2();
        ProductFeedAdapter r2 = this.d;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L12:
        r1.e = c.a(r2.y);
        ProductFeedViewModel r3 = this.g;
        if (r3 == null) goto L17;
        AnchorV3Param r4 = r3.m907getAnchorV3Param();
        if (r4 == null) goto L17;
        ECLogExtraData r5 = r4.getLogExtraData();
    L18:
        if (r5 == null) goto L20;
        String r6 = r5.getEnterFrom();
    L21:
        r1.a = r6;
        if (r5 == null) goto L24;
        String r7 = r5.getEComEntranceForm();
    L25:
        r1.b = r7;
        ProductFeedViewModel r8 = this.g;
        if (r8 == null) goto L30;
        AnchorV3Param r9 = r8.m907getAnchorV3Param();
        if (r9 == null) goto L30;
        String r10 = r9.getAuthorId();
    L31:
        r1.c = r10;
        ProductFeedViewModel r11 = this.g;
        if (r11 == null) goto L36;
        AnchorV3Param r12 = r11.m907getAnchorV3Param();
        if (r12 == null) goto L36;
        String r13 = r12.getVideoId();
    L37:
        r1.d = r13;
        r1.post(null, null);
        this.f = true;
        return;
    L36:
        r13 = null;
    L30:
        r10 = null;
        goto L31
    L24:
        r7 = null;
        goto L25
    L20:
        r6 = null;
    L17:
        r5 = null;
        goto L18
    }

    public final int getEndColor() {
        return this.i;
    }

    public final int getStartColor() {
        return this.h;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setAdapter(ProductFeedAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setCopyWriting(String r2) {
        Intrinsics.checkNotNullParameter(r2, "copyWriting");
        ((TextView) a(2131383153)).setText(r2);
    }

    public final void setStyle(boolean r3) {
        if (this.c != r3) goto L5;
        boolean r0 = false;
    L6:
        if (r0 == false) goto L15;
        if (r3 == false) goto L9;
        int r1 = getContext().getResources().getColor(2131101227);
    L10:
        setTextAndDividerColor(r1);
        if (r3 == false) goto L13;
        ((ImageView) a(2131367277)).setImageResource(2131233452);
        return;
    L13:
        ((ImageView) a(2131367277)).setImageResource(2131233451);
        return;
    L9:
        r1 = getContext().getResources().getColor(2131105874);
        goto L10
    L15:
        return;
    L5:
        this.c = r3;
        r0 = true;
        goto L6
    }

    public final void setTextAndDividerColor(int r2) {
        ((TextView) a(2131383153)).setTextColor(r2);
        a(2131377759).setBackgroundColor(r2);
        a(2131384571).setBackgroundColor(r2);
    }

    public ProductFeedDividerView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new LinkedHashMap();
        boolean r6 = ld3.d.e(ld3.d.a());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (ld3.b.a() == false) goto L5;
        Map r7 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r3).aU(2131560647, this, true);
    L6:
        this.b = findViewById(2131379722);
        setStyle(r6);
        ((ImageView) a(2131367277)).setOnClickListener(new a(this, r3));
        LinearLayout r8 = (LinearLayout) a(2131378180);
        if (r8 == null) goto L9;
        r8.setOnClickListener(new t(this));
    L9:
        ((FrameLayout) a(2131387877)).setOnClickListener(new b(this));
        this.h = r3.getResources().getColor(2131101227);
        this.i = r3.getResources().getColor(2131105908);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560647, this, true);
        goto L6
    }

    public /* synthetic */ ProductFeedDividerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
