package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001<B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010*\u001a\u00020'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0015\u0010+\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0007H\u0002J0\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020;H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/MutilCellLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cellLabelStyleProvider", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/MutilCellLayout$IMutilAddLabelStyleProvider;", "itemSpaceSize", "labelHorizontalPadding", "labelHeight", "isFixMeasureWidth", "", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "labelText", "", "labelTextStartX", "idealChildCount", "Ljava/lang/Integer;", "setFixMeasureWidth", "", "setItemSpace", "size", "setLabelSize", "height", "horizontalPadding", "getDp", "dp", "", "getLabelTextSp", "setMutilCellLabelStyleProvider", "getLabelTextWidth", "setIdealChildCount", "(Ljava/lang/Integer;)V", "getHiddenBaseChildCount", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "checkLayoutPosition", "right", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "draw", "canvas", "Landroid/graphics/Canvas;", "IMutilAddLabelStyleProvider", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MutilCellLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f216147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f216148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f216149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f216150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f216151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f216152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f216153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f216154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f216155i;

    public interface a {
        Drawable a();

        boolean b();

        int getTextColor();

        float getTextSize();
    }

    private final int getHiddenBaseChildCount() {
        Integer r100 = this.f216155i;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        int r102 = r101 - getChildCount();
        if (r102 > 0) goto L9;
        return 0;
    L9:
        return r102;
    L5:
        r101 = 0;
        goto L6
    }

    private final float getLabelTextSp() {
        int r100 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r101 = Resources.getSystem();
        a r102 = this.f216147a;
        if (r102 == null) goto L5;
        float r103 = r102.getTextSize();
    L7:
        return TypedValue.applyDimension(2, r103, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    L5:
        r103 = 14.0f;
        goto L7
    }

    private final Paint getPaint() {
        return (Paint) this.f216152f.getValue();
    }

    public MutilCellLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final float a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0.0f;
    L6:
        getPaint().setTextSize(getLabelTextSp());
        Paint r101 = getPaint();
        a r102 = this.f216147a;
        if (r102 == null) goto L9;
        boolean r103 = r102.b();
    L10:
        r101.setFakeBoldText(r103);
        return getPaint().measureText(r100) + (this.f216149c * 2);
    L9:
        r103 = false;
        goto L10
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
        String r101 = this.f216153g;
        if (r101 == null) goto L15;
        a r102 = this.f216147a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (getChildCount() <= 1) goto L9;
    L10:
        getPaint().setTextSize(getLabelTextSp());
        getPaint().setColor(r102.getTextColor());
        getPaint().setFakeBoldText(r102.b());
        Rect r103 = new Rect();
        getPaint().getTextBounds(r101, 0, r101.length(), r103);
        Drawable r104 = r102.a();
        if (r104 == null) goto L13;
        int r105 = this.f216150d;
        int r106 = (getMeasuredHeight() - r105) / 2;
        int r107 = this.f216154h;
        r104.setBounds(r107, r106, (r103.width() + r107) + (this.f216149c * 2), r105 + r106);
        r104.draw(r100);
    L13:
        r100.drawText(r101, this.f216154h + this.f216149c, getMeasuredHeight() - ((getMeasuredHeight() - r103.height()) / 2), getPaint());
        return;
    L9:
        if (getHiddenBaseChildCount() > 0) goto L10;
        return;
    }

    public final void setFixMeasureWidth(boolean r100) {
        this.f216151e = r100;
    }

    public final void setIdealChildCount(Integer r100) {
        this.f216155i = r100;
    }

    public final void setItemSpace(int r100) {
        this.f216148b = r100;
    }

    public final void setMutilCellLabelStyleProvider(a r100) {
        Intrinsics.checkNotNullParameter(r100, "cellLabelStyleProvider");
        this.f216147a = r100;
    }

    public MutilCellLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = getHiddenBaseChildCount();
        if (this.f216147a != null) goto L5;
    L60:
        super.onMeasure(r210, r211);
        return;
    L5:
        if (getChildCount() < 1) goto L60;
        if (getChildCount() != 1) goto L10;
        if (r100 == 0) goto L60;
    L10:
        int r110 = 0;
        if (this.f216151e == false) goto L39;
        this.f216153g = null;
        int r111 = (View.MeasureSpec.getSize(r210) - getPaddingLeft()) - getPaddingRight();
        ArrayList r112 = new ArrayList();
        int r113 = getChildCount();
        int r101 = 0;
        int r114 = 0;
    L13:
        if (r114 >= r113) goto L18;
        View r115 = getChildAt(r114);
        int r116 = Math.max(r101, r115.getMeasuredHeight());
        measureChildWithMargins(r115, r210, 0, r211, 0);
        r112.add(Integer.valueOf(r115.getMeasuredWidth()));
        if ((CollectionsKt.sumOfInt(r112) + (this.f216148b * r114)) > r111) goto L16;
        r114 = r114 + 1;
        r101 = r116;
        goto L13
    L16:
        boolean r102 = true;
    L19:
        if (r102 == true) goto L21;
    L37:
        setMeasuredDimension(r110 + (CollectionsKt.sumOfInt(r112) + (this.f216148b * (r112.size() - 1))), (r116 + getPaddingTop()) + getPaddingBottom());
        return;
    L21:
        if (r112.size() <= 0) goto L32;
        int r103 = r112.size() - 1;
        int r104 = CollectionsKt.sumOfInt(r112) + (this.f216148b * r103);
        int r105 = ((getChildCount() - r103) - 1) + r100;
        if (r105 != 0) goto L25;
        int r117 = 0;
    L27:
        if ((r104 + r117) <= r111) goto L28;
        if (r103 == 0) goto L30;
        ((Number) ListProtector.remove(r112, r103)).intValue();
        goto L21
    L30:
        this.f216153g = Marker.ANY_NON_NULL_MARKER + r105;
        View r106 = getChildAt(r103);
        measureChildWithMargins(r106, r210, r117, r211, 0);
        ListProtector.set(r112, 0, Integer.valueOf(r106.getMeasuredWidth()));
    L33:
        int r107 = r112.size();
        int r108 = getChildCount();
        int r118 = r107;
    L34:
        if (r118 >= r108) goto L36;
        measureChildWithMargins(getChildAt(r118), View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r118 = r118 + 1;
        goto L34
    L36:
        r110 = r117;
        goto L37
    L28:
        this.f216153g = Marker.ANY_NON_NULL_MARKER + r105;
        goto L33
    L25:
        r117 = ((int) a(Marker.ANY_NON_NULL_MARKER + r105)) + this.f216148b;
        goto L27
    L32:
        r117 = 0;
        goto L33
    L18:
        r116 = r101;
        r102 = false;
        goto L19
    L39:
        this.f216153g = null;
        int r119 = (View.MeasureSpec.getSize(r210) - getPaddingLeft()) - getPaddingRight();
        int r120 = getChildCount();
        int r121 = 0;
        int r122 = 0;
        int r123 = 0;
    L40:
        if (r121 >= r120) goto L58;
        View r124 = getChildAt(r121);
        measureChildWithMargins(r124, r210, 0, r211, 0);
        r122 = Math.max(r122, r124.getMeasuredHeight());
        int r109 = ((getChildCount() - r121) - 1) + r100;
        if (r109 != 0) goto L44;
        int r125 = 0;
    L45:
        int r126 = r124.getMeasuredWidth();
        if (r121 != 0) goto L48;
        int r127 = 0;
    L49:
        int r128 = r123 + (r126 + r127);
        if ((r128 + r125) > r119) goto L51;
        r121 = r121 + 1;
        r123 = r128;
        goto L40
    L51:
        if (r121 != 0) goto L53;
        measureChildWithMargins(r124, r210, r125, r211, 0);
        this.f216153g = Marker.ANY_NON_NULL_MARKER + r109;
        int r129 = r124.getMeasuredWidth() + r125;
    L54:
        r123 = r123 + r129;
        int r130 = r121 + 1;
        int r131 = getChildCount();
    L55:
        if (r130 >= r131) goto L58;
        measureChildWithMargins(getChildAt(r130), View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r130 = r130 + 1;
        goto L55
    L53:
        this.f216153g = Marker.ANY_NON_NULL_MARKER + (r109 + 1);
        measureChildWithMargins(r124, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r129 = ((int) a(this.f216153g)) + this.f216148b;
        goto L54
    L48:
        r127 = this.f216148b;
        goto L49
    L44:
        r125 = ((int) a(Marker.ANY_NON_NULL_MARKER + r109)) + this.f216148b;
    L58:
        setMeasuredDimension(r123, (r122 + getPaddingTop()) + getPaddingBottom());
    }

    public MutilCellLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f216148b = com.bytedance.ee.util.ui.n.c(6.0f);
        this.f216149c = com.bytedance.ee.util.ui.n.c(6.0f);
        this.f216150d = com.bytedance.ee.util.ui.n.c(24.0f);
        this.f216152f = LazyKt.lazy(MutilCellLayout$paint$2.INSTANCE);
        setWillNotDraw(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        if (this.f216147a != null) goto L5;
    L28:
        super.onLayout(r100, r101, r110, r111, r112);
        return;
    L5:
        if (getChildCount() < 1) goto L28;
        if (getChildCount() == 1) goto L9;
    L11:
        int r102 = getPaddingLeft();
        int r103 = getChildCount();
        int r113 = 0;
    L12:
        if (r113 >= r103) goto L26;
        View r114 = getChildAt(r113);
        if (r114.getMeasuredWidth() <= 0) goto L24;
        int r104 = (getMeasuredHeight() - r114.getMeasuredHeight()) / 2;
        int r105 = r114.getMeasuredWidth() + r102;
        int r106 = r114.getMeasuredHeight() + r104;
        if (TextUtils.isEmpty(this.f216153g) == false) goto L18;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
        r114.layout(r102, r104, r105, r106);
        r102 = r105 + this.f216148b;
    L25:
        r113 = r113 + 1;
        goto L12
    L23:
        r114.layout(0, 0, 0, 0);
        goto L25
    L18:
        if (r105 <= (((getMeasuredWidth() - a(this.f216153g)) - getPaddingRight()) - this.f216148b)) goto L20;
        r107 = false;
        goto L21
    L24:
        r114.layout(0, 0, 0, 0);
        goto L25
    L26:
        this.f216154h = r102;
        return;
    L9:
        if (getHiddenBaseChildCount() != 0) goto L11;
        goto L11
    }
}
