package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.facebook.drawee.generic.RoundingParams;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowSkuThumbnail;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "a", "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "getSpecDetail", "()Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "setSpecDetail", "(Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;)V", "specDetail", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "b", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getImageView", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "imageView", "Landroid/view/View;", "g", "Lkotlin/Lazy;", "getMaskView", "()Landroid/view/View;", "maskView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowSkuThumbnail extends FrameLayout {
    public SpecDetail a;
    public final ECDraweeView b;
    public final String c;
    public final String d;
    public final String e;
    public final Drawable f;
    public final Lazy g;

    public InflowSkuThumbnail(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowSkuThumbnail(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getMaskView() {
        return (View) this.g.getValue();
    }

    public final void a() {
        removeAllViews();
        View r0 = this.b;
        float r2 = 42;
        Resources r3 = Resources.getSystem();
        int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        Resources r5 = Resources.getSystem();
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(r4, MathKt.roundToInt(TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()))));
        r1.gravity = 17;
        Unit r6 = Unit.INSTANCE;
        addView(r0, r1);
        b(this.b, this.c, 1);
        View r7 = getMaskView();
        float r8 = 44;
        Resources r9 = Resources.getSystem();
        int r10 = MathKt.roundToInt(TypedValue.applyDimension(1, r8, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));
        Resources r11 = Resources.getSystem();
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(r10, MathKt.roundToInt(TypedValue.applyDimension(1, r8, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()))));
        r12.gravity = 17;
        addView(r7, r12);
        getMaskView().setVisibility(4);
    }

    public final ECDraweeView getImageView() {
        return this.b;
    }

    public final SpecDetail getSpecDetail() {
        return this.a;
    }

    public final void c(boolean r3) {
        if (r3 == false) goto L4;
        b(this.b, this.d, 2);
        ExtensionsKt.visible(getMaskView());
        return;
    L4:
        b(this.b, this.c, 1);
        getMaskView().setVisibility(4);
    }

    public final void setSpecDetail(SpecDetail r1) {
        this.a = r1;
    }

    public InflowSkuThumbnail(final Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        ECDraweeView r11 = new ECDraweeView(r8, null, 0, 6, null);
        r11.setCornerRadius(r11.getDp(8));
        Unit r12 = Unit.INSTANCE;
        this.b = r11;
        this.c = "#05161823";
        this.d = "#ffffff";
        this.e = "#161823";
        this.f = com.bytedance.commerce.base.drawable.a.a(new InflowSkuThumbnail$shapeDrawable$1(this));
        this.g = LazyKt.lazy(new InflowSkuThumbnail$maskView$2(this, r8));
    }

    public static void b(ECDraweeView r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$setRounding");
        RoundingParams r0 = new RoundingParams();
        r0.setCornersRadius(r2.getDp(8));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r3)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        Integer r6 = (Integer) r5;
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        r0.setBorder(r7, r2.getDp(Integer.valueOf(r4)));
        r2.getHierarchy().setRoundingParams(r0);
        return;
    L13:
        r7 = 0;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public /* synthetic */ InflowSkuThumbnail(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
