package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0014J0\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0014J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/CardRatingBar;", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nullStrokeWidth", "", "nullStrokeLength", "nullString", "", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "hiddenCount", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardRatingBar extends BTRatingBar {
    public final float r;
    public final float s;
    public final String t;
    public final Lazy u;
    public String v;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), r8.getHeight() / 2);
        }
    }

    private final Paint getPaint() {
        return (Paint) this.u.getValue();
    }

    public CardRatingBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super/*android.widget.LinearLayout*/.onDraw(r9);
        String r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.t, r0) == false) goto L7;
        int r1 = com.bytedance.ee.util.ui.n.d(10) + getChildAt(0).getMeasuredWidth();
        float r6 = getMeasuredHeight() / 2;
        float r3 = r1;
        r9.drawLine(r3, r6, r3 + this.s, r6, getPaint());
        return;
    L7:
        Rect r2 = new Rect();
        getPaint().getTextBounds(r0, 0, r0.length(), r2);
        r9.drawText(r0, com.bytedance.ee.util.ui.n.d(10) + getChildAt(0).getMeasuredWidth(), getMeasuredHeight() - ((getMeasuredHeight() - r2.height()) / 2), getPaint());
    }

    public CardRatingBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r14, int r16) {
        this.v = null;
        setOutlineProvider(null);
        setClipToOutline(false);
        setBackgroundColor(ResourcesCompat.getColor(getContext().getResources(), 2131106784, getContext().getTheme()));
        if (getChildCount() <= 0) goto L12;
        sr4.b r1 = getChildAt(0);
        if ((r1 instanceof sr4.b) == false) goto L12;
        sr4.b r2 = r1;
        if (getMMinRating() > getMInitRating()) goto L9;
        boolean r3 = true;
    L10:
        r2.b(r3);
        goto L12
    L9:
        r3 = false;
    L12:
        if (getChildCount() <= 1) goto L33;
        int r4 = (View.MeasureSpec.getSize(r14) - getPaddingLeft()) - getPaddingRight();
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
    L14:
        if (r6 >= r5) goto L16;
        View r12 = getChildAt(r6);
        measureChildWithMargins(r12, r14, 0, r16, 0);
        r7 = r7 + r12.getMeasuredWidth();
        r6 = r6 + 1;
        goto L14
    L16:
        if (r7 <= r4) goto L32;
        int r17 = getChildCount();
        int r18 = 1;
    L18:
        if (r18 >= r17) goto L20;
        measureChildWithMargins(getChildAt(r18), View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r18 = r18 + 1;
        goto L18
    L20:
        this.v = String.valueOf(getMInitRating());
        float r19 = getPaint().measureText(this.v);
        if (getMInitRating() >= getMMinRating()) goto L23;
        this.v = this.t;
        r19 = this.s;
    L23:
        sr4.b r110 = getChildAt(0);
        setMeasuredDimension((r110.getMeasuredWidth() + com.bytedance.ee.util.ui.n.d(18)) + ((int) r19), r110.getMeasuredHeight());
        if ((r110 instanceof sr4.b) == false) goto L31;
        sr4.b r111 = r110;
        if (r111.b == false) goto L30;
        ImageView r112 = r111.m;
        if (r112 == null) goto L31;
        r112.setImageResource(2131255505);
        goto L31
    L30:
        r111.b(true);
    L31:
        setBackgroundColor(ResourcesCompat.getColor(getContext().getResources(), 2131100549, getContext().getTheme()));
        setOutlineProvider(new a());
        setClipToOutline(true);
        return;
    L32:
        super/*android.widget.LinearLayout*/.onMeasure(r14, r16);
        return;
    L33:
        super/*android.widget.LinearLayout*/.onMeasure(r14, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardRatingBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.r = com.bytedance.ee.util.ui.n.d(1);
        this.s = com.bytedance.ee.util.ui.n.d(6);
        this.t = "——";
        this.u = LazyKt.lazy(new CardRatingBar$paint$2(this));
        setWillNotDraw(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        if (this.v == null) goto L11;
        int r8 = getChildCount();
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L16;
        View r10 = getChildAt(r9);
        if (r9 != 0) goto L9;
        int r11 = com.bytedance.ee.util.ui.n.d(6);
        r10.layout(r11, 0, r10.getMeasuredWidth() + r11, r10.getMeasuredHeight());
    L10:
        r9 = r9 + 1;
        goto L5
    L9:
        r10.layout(0, 0, 0, 0);
        goto L10
    L16:
        return;
    L11:
        super.onLayout(r3, r4, r5, r6, r7);
    }
}
