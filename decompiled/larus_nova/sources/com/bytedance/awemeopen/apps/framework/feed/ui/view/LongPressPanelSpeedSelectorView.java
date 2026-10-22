package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/LongPressPanelSpeedSelectorView;", "Landroid/view/View;", "Landroid/graphics/Paint;", ce.f26395j, "Lkotlin/Lazy;", "getBackgroundPaint", "()Landroid/graphics/Paint;", "backgroundPaint", ce.f26396k, "getSelectionPaint", "selectionPaint", "l", "getTextPaint", "textPaint", "m", "getSelectedTextPaint", "selectedTextPaint", "", "value", "o", "I", "setSelectedIndex", "(I)V", "selectedIndex", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LongPressPanelSpeedSelectorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f196787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f196788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f196789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f196790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f196791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f196792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f196793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f196794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f196795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f196796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f196797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f196798l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f196799m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f196800n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f196801o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Integer, Unit> f196802p;

    public LongPressPanelSpeedSelectorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LongPressPanelSpeedSelectorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Paint getBackgroundPaint() {
        return (Paint) this.f196796j.getValue();
    }

    private final Paint getSelectedTextPaint() {
        return (Paint) this.f196799m.getValue();
    }

    private final Paint getSelectionPaint() {
        return (Paint) this.f196797k.getValue();
    }

    private final Paint getTextPaint() {
        return (Paint) this.f196798l.getValue();
    }

    private final void setSelectedIndex(int r100) {
        if (this.f196801o == r100) goto L8;
        this.f196801o = r100;
        Function1<? super Integer, Unit> r101 = this.f196802p;
        if (r101 == null) goto L9;
        r101.invoke(Integer.valueOf(r100));
        return;
    L9:
        return;
    }

    public final void a(Function1<? super Paint, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.invoke(getTextPaint());
        r100.invoke(getSelectedTextPaint());
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getAction() != 0) goto L9;
        return true;
    L9:
        if (r100.getAction() != 1) goto L32;
        float r102 = getMeasuredWidth();
        float r103 = r100.getX();
        if (0.0f <= r103) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L32;
        float r105 = getMeasuredHeight();
        float r106 = r100.getY();
        if (0.0f <= r106) goto L20;
    L22:
        boolean r107 = false;
    L23:
        if (r107 == false) goto L32;
        int r108 = (int) ((r100.getX() - this.f196793g) / ((getWidth() - (this.f196793g * 2)) / ((ArrayList) this.f196800n).size()));
        if (r108 >= 0) goto L27;
    L29:
        if (r101 == false) goto L31;
        setSelectedIndex(r108);
        invalidate();
    L31:
        return true;
    L27:
        if (r108 >= ((ArrayList) this.f196800n).size()) goto L29;
        r101 = true;
        goto L29
    L20:
        if (r106 > r105) goto L22;
        r107 = true;
        goto L23
    L13:
        if (r103 > r102) goto L15;
        r104 = true;
    L32:
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (r110 != null) goto L5;
        return;
    L5:
        float r100 = this.f196794h + 0.0f;
        float r101 = getWidth();
        float r102 = getHeight() - this.f196794h;
        float r103 = this.f196791e;
        Paint r104 = getBackgroundPaint();
        RectF r105 = this.f196795i;
        r105.left = 0.0f;
        r105.top = r100;
        r105.right = r101;
        r105.bottom = r102;
        r110.drawRoundRect(r105, r103, r103, r104);
        int r106 = ((ArrayList) this.f196800n).size();
        int r107 = this.f196801o;
        int r108 = 0;
        if (r107 < 0) goto L9;
        if (r107 >= r106) goto L9;
        boolean r109 = true;
    L11:
        if (r109 == false) goto L13;
        float r111 = (getWidth() - (this.f196793g * 2)) / ((ArrayList) this.f196800n).size();
        float r112 = this.f196801o * r111;
        float r113 = this.f196793g;
        float r114 = r112 + r113;
        float r115 = r113 + this.f196794h;
        float r116 = (getHeight() - this.f196793g) - this.f196794h;
        float r117 = this.f196791e;
        Paint r118 = getSelectionPaint();
        RectF r119 = this.f196795i;
        r119.left = r114;
        r119.top = r115;
        r119.right = r111 + r114;
        r119.bottom = r116;
        r110.drawRoundRect(r119, r117, r117, r118);
    L13:
        Paint.FontMetrics r120 = getTextPaint().getFontMetrics();
        float r121 = r120.bottom;
        float r122 = 2;
        float r123 = (getHeight() / 2) + (((r121 - r120.top) / r122) - r121);
        Iterator r124 = ((ArrayList) this.f196800n).iterator();
    L15:
        if (r124.hasNext() == false) goto L24;
        Object r125 = r124.next();
        int r126 = r108 + 1;
        if (r108 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        String r127 = (String) r125;
        float r128 = (getWidth() - (this.f196793g * r122)) / ((ArrayList) this.f196800n).size();
        float r129 = ((r108 * r128) + this.f196793g) + (r128 / r122);
        if (r108 != this.f196801o) goto L22;
        Paint r130 = getSelectedTextPaint();
    L23:
        r110.drawText(r127, r129, r123, r130);
        r108 = r126;
        goto L15
    L22:
        r130 = getTextPaint();
        goto L23
    L24:
        return;
    L9:
        r109 = false;
        goto L11
    }

    public LongPressPanelSpeedSelectorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        Intrinsics.checkNotNullParameter("#0A161823", "<this>");
        this.f196787a = ColorProtector.parseColor("#0A161823");
        this.f196788b = -1;
        this.f196789c = ContextCompat.getColor(r100, R.color.TextReverse3);
        this.f196790d = ContextCompat.getColor(r100, R.color.TextPrimary_Light);
        Resources r103 = Resources.getSystem();
        this.f196791e = TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        float r104 = 12;
        Resources r105 = Resources.getSystem();
        this.f196792f = TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        Resources r106 = Resources.getSystem();
        this.f196793g = TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()));
        Resources r107 = Resources.getSystem();
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        this.f196794h = r108;
        this.f196795i = new RectF();
        setPadding(0, r108, 0, r108);
        this.f196796j = LazyKt.lazy(new LongPressPanelSpeedSelectorView$backgroundPaint$2(this));
        this.f196797k = LazyKt.lazy(new LongPressPanelSpeedSelectorView$selectionPaint$2(this));
        this.f196798l = LazyKt.lazy(new LongPressPanelSpeedSelectorView$textPaint$2(this));
        this.f196799m = LazyKt.lazy(new LongPressPanelSpeedSelectorView$selectedTextPaint$2(this));
        this.f196800n = new ArrayList();
    }

    public final void b(List<String> r100, int r101, Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        List<String> r103 = r100;
        if ((!r103.isEmpty()) == false) goto L7;
        ((ArrayList) this.f196800n).clear();
        ((ArrayList) this.f196800n).addAll(r103);
        setSelectedIndex(r101);
        this.f196802p = r102;
        invalidate();
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public /* synthetic */ LongPressPanelSpeedSelectorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
