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
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0014J0\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0014J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/CardRatingBar;", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nullStrokeWidth", "", "nullStrokeLength", "nullString", "", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "hiddenCount", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardRatingBar extends BTRatingBar {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f216164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f216165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f216166t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f216167u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f216168v;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), r100.getHeight() / 2);
        }
    }

    private final Paint getPaint() {
        return (Paint) this.f216167u.getValue();
    }

    public CardRatingBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        String r101 = this.f216168v;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.f216166t, r101) == false) goto L7;
        int r102 = com.bytedance.ee.util.ui.n.d(10) + getChildAt(0).getMeasuredWidth();
        float r103 = getMeasuredHeight() / 2;
        float r104 = r102;
        r100.drawLine(r104, r103, r104 + this.f216165s, r103, getPaint());
        return;
    L7:
        Rect r105 = new Rect();
        getPaint().getTextBounds(r101, 0, r101.length(), r105);
        r100.drawText(r101, com.bytedance.ee.util.ui.n.d(10) + getChildAt(0).getMeasuredWidth(), getMeasuredHeight() - ((getMeasuredHeight() - r105.height()) / 2), getPaint());
    }

    public CardRatingBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        this.f216168v = null;
        setOutlineProvider(null);
        setClipToOutline(false);
        setBackgroundColor(ResourcesCompat.getColor(getContext().getResources(), R.color.transparent, getContext().getTheme()));
        if (getChildCount() <= 0) goto L12;
        View r100 = getChildAt(0);
        if ((r100 instanceof sr4.b) == false) goto L12;
        sr4.b r101 = (sr4.b) r100;
        if (getMMinRating() > getMInitRating()) goto L9;
        boolean r102 = true;
    L10:
        r101.b(r102);
        goto L12
    L9:
        r102 = false;
    L12:
        if (getChildCount() <= 1) goto L33;
        int r103 = (View.MeasureSpec.getSize(r110) - getPaddingLeft()) - getPaddingRight();
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
    L14:
        if (r105 >= r104) goto L16;
        View r112 = getChildAt(r105);
        measureChildWithMargins(r112, r110, 0, r111, 0);
        r106 = r106 + r112.getMeasuredWidth();
        r105 = r105 + 1;
        goto L14
    L16:
        if (r106 <= r103) goto L32;
        int r113 = getChildCount();
        int r114 = 1;
    L18:
        if (r114 >= r113) goto L20;
        measureChildWithMargins(getChildAt(r114), View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r114 = r114 + 1;
        goto L18
    L20:
        this.f216168v = String.valueOf(getMInitRating());
        float r115 = getPaint().measureText(this.f216168v);
        if (getMInitRating() >= getMMinRating()) goto L23;
        this.f216168v = this.f216166t;
        r115 = this.f216165s;
    L23:
        View r116 = getChildAt(0);
        setMeasuredDimension((r116.getMeasuredWidth() + com.bytedance.ee.util.ui.n.d(18)) + ((int) r115), r116.getMeasuredHeight());
        if ((r116 instanceof sr4.b) == false) goto L31;
        sr4.b r117 = (sr4.b) r116;
        if (r117.f543209b == false) goto L30;
        ImageView r118 = r117.f543220m;
        if (r118 == null) goto L31;
        r118.setImageResource(R.drawable.ud_icon_rating_nps_colorful);
        goto L31
    L30:
        r117.b(true);
    L31:
        setBackgroundColor(ResourcesCompat.getColor(getContext().getResources(), R.color.bg_body_overlay, getContext().getTheme()));
        setOutlineProvider(new a());
        setClipToOutline(true);
        return;
    L32:
        super.onMeasure(r110, r111);
        return;
    L33:
        super.onMeasure(r110, r111);
    }

    public CardRatingBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f216164r = com.bytedance.ee.util.ui.n.d(1);
        this.f216165s = com.bytedance.ee.util.ui.n.d(6);
        this.f216166t = "——";
        this.f216167u = LazyKt.lazy(new CardRatingBar$paint$2(this));
        setWillNotDraw(false);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.f216168v == null) goto L11;
        int r105 = getChildCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L16;
        View r107 = getChildAt(r106);
        if (r106 != 0) goto L9;
        int r108 = com.bytedance.ee.util.ui.n.d(6);
        r107.layout(r108, 0, r107.getMeasuredWidth() + r108, r107.getMeasuredHeight());
    L10:
        r106 = r106 + 1;
        goto L5
    L9:
        r107.layout(0, 0, 0, 0);
        goto L10
    L16:
        return;
    L11:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
