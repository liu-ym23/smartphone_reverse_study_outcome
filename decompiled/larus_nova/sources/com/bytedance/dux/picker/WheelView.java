package com.bytedance.dux.picker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB#\b\u0007\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J!\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bR*\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR*\u0010&\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR*\u0010+\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u00100R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u00108R\u001b\u0010<\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010.\u001a\u0004\b;\u00108R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010.\u001a\u0004\b?\u0010@R*\u0010F\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0017\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR*\u0010I\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000f\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013R\"\u0010N\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000f\u001a\u0004\bL\u0010\u0011\"\u0004\bM\u0010\u0013R\"\u0010R\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u000f\u001a\u0004\bP\u0010\u0011\"\u0004\bQ\u0010\u0013R\"\u0010V\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010\u000f\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\"\u0010Z\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010\u000f\u001a\u0004\bX\u0010\u0011\"\u0004\bY\u0010\u0013R$\u0010a\u001a\u00020[2\u0006\u0010\\\u001a\u00020[8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010e\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\u0019\"\u0004\bd\u0010\u001bR$\u0010h\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010\u0019\"\u0004\bg\u0010\u001bR$\u0010k\u001a\u00020[2\u0006\u0010\\\u001a\u00020[8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010^\"\u0004\bj\u0010`R$\u0010n\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010\u0019\"\u0004\bm\u0010\u001bR\u0011\u0010p\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bo\u0010\u0019R\u0013\u0010s\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bq\u0010rR$\u0010v\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010\u0019\"\u0004\bu\u0010\u001bR(\u0010x\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010w8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b}\u0010\u0019R\u0015\u0010\u0080\u0001\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010\u0019¨\u0006\u0087\u0001"}, d2 = {"Lcom/bytedance/dux/picker/WheelView;", "Landroid/view/View;", "", "getClipMiddleRectTop", "getClipMiddleRectBottom", "", "", "entries", "", "setEntries", "([Ljava/lang/String;)V", "", "", "isShow", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showDivider", "index", "b", "I", "getStartIndex", "()I", "setStartIndex", "(I)V", "startIndex", "count", "c", "getItemCount", "setItemCount", "itemCount", "width", "d", "getItemWidthPx", "setItemWidthPx", "itemWidthPx", "height", "e", "getItemHeightPx", "setItemHeightPx", "itemHeightPx", "Landroid/text/TextPaint;", RXScreenCaptureService.KEY_INDEX, "Lkotlin/Lazy;", "getMTextPaint", "()Landroid/text/TextPaint;", "mTextPaint", ce.f26395j, "getMSelectedTextPaint", "mSelectedTextPaint", "Landroid/graphics/Paint;", ce.f26396k, "getMDividerPaint", "()Landroid/graphics/Paint;", "mDividerPaint", "l", "getMHighlightPaint", "mHighlightPaint", "Lcom/bytedance/dux/picker/b;", "m", "getMScroller", "()Lcom/bytedance/dux/picker/b;", "mScroller", "radius", "o", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "highlightConorRadiusPx", "cyclic", "p", "isCyclic", "setCyclic", "q", "getShowTopLeftCorner", "setShowTopLeftCorner", "showTopLeftCorner", "r", "getShowTopRightCorner", "setShowTopRightCorner", "showTopRightCorner", "s", "getShowBottomLeftCorner", "setShowBottomLeftCorner", "showBottomLeftCorner", "t", "getShowBottomRightCorner", "setShowBottomRightCorner", "showBottomRightCorner", "", "size", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textSizePx", "color", "getTextColor", "setTextColor", "textColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextColor", "getSelectedTextSizePx", "setSelectedTextSizePx", "selectedTextSizePx", "getHighlightColor", "setHighlightColor", "highlightColor", "getItemSize", "itemSize", "getCurrentItem", "()Ljava/lang/String;", "currentItem", "getCurrentIndex", "setCurrentIndex", "currentIndex", "Lcom/bytedance/dux/picker/a;", "onWheelChangedListener", "getOnWheelChangedListener", "()Lcom/bytedance/dux/picker/a;", "setOnWheelChangedListener", "(Lcom/bytedance/dux/picker/a;)V", "getWheelWidth", "wheelWidth", "getWheelHeight", "wheelHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class WheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f205407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f205409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f205410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f205411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f205412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f205413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f205414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f205415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f205416m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f205417n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f205418o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f205419p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f205420q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f205421r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f205422s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f205423t;

    public static final class a {
    }

    static {
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.f205414k.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.f205415l.getValue();
    }

    private final b getMScroller() {
        return (b) this.f205416m.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.f205413j.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.f205412i.getValue();
    }

    public final int getClipMiddleRectBottom() {
        Rect r100 = this.f205410g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r100 = this.f205410g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.top;
    }

    public final int getItemSize() {
        return ((ArrayList) this.f205417n).size();
    }

    private final int getWheelHeight() {
        return ((getPaddingTop() + getPaddingBottom()) + (this.f205408e * this.f205406c)) - MathKt.roundToInt(TypedValue.applyDimension(1, 30, a(Resources.getSystem())));
    }

    private final int getWheelWidth() {
        return (getPaddingLeft() + getPaddingRight()) + this.f205407d;
    }

    @Override // android.view.View
    public final void computeScroll() {
        b r100 = getMScroller();
        if (r100.f205427d == false) goto L9;
        r100.f205427d = r100.computeScrollOffset();
        r100.a(r100.getCurrY() - r100.f205425b);
        if (r100.f205427d == false) goto L7;
        r100.f205424a.postInvalidate();
        return;
    L7:
        r100.c();
        return;
    }

    public final int getCurrentIndex() {
        return getMScroller().b();
    }

    public final String getCurrentItem() {
        int r100 = getCurrentIndex();
        if (r100 >= 0) goto L8;
        if (r100 < ((ArrayList) this.f205417n).size()) goto L8;
        return null;
    L8:
        return (String) ListProtector.get(this.f205417n, r100);
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final com.bytedance.dux.picker.a getOnWheelChangedListener() {
        return getMScroller().f205429f;
    }

    public final int getSelectedTextColor() {
        return getMSelectedTextPaint().getColor();
    }

    public final float getSelectedTextSizePx() {
        return getMSelectedTextPaint().getTextSize();
    }

    public final int getTextColor() {
        return getMTextPaint().getColor();
    }

    public final float getTextSizePx() {
        return getMTextPaint().getTextSize();
    }

    public final int getHighlightConorRadiusPx() {
        return this.f205418o;
    }

    public final int getItemCount() {
        return this.f205406c;
    }

    public final int getItemHeightPx() {
        return this.f205408e;
    }

    public final int getItemWidthPx() {
        return this.f205407d;
    }

    public final boolean getShowBottomLeftCorner() {
        return this.f205422s;
    }

    public final boolean getShowBottomRightCorner() {
        return this.f205423t;
    }

    public final boolean getShowDivider() {
        return this.f205404a;
    }

    public final boolean getShowTopLeftCorner() {
        return this.f205420q;
    }

    public final boolean getShowTopRightCorner() {
        return this.f205421r;
    }

    public final int getStartIndex() {
        return this.f205405b;
    }

    public WheelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Rect r100 = this.f205410g;
        if (r100 == null) goto L33;
        RectF r101 = new RectF(r100);
        float r102 = r101.left - getPaddingLeft();
        float r103 = r101.top;
        float r104 = r101.right + getPaddingRight();
        float r105 = r101.bottom;
        float r106 = this.f205418o;
        boolean r107 = this.f205420q;
        boolean r108 = this.f205421r;
        boolean r109 = this.f205423t;
        boolean r110 = this.f205422s;
        Path r111 = new Path();
        if (r106 >= 0.0f) goto L7;
        float r112 = 0.0f;
    L8:
        if (r106 >= 0.0f) goto L10;
        r106 = 0.0f;
    L10:
        float r113 = r104 - r102;
        float r114 = r105 - r103;
        float r115 = r113 / 2.0f;
        if (r112 <= r115) goto L13;
        r112 = r115;
    L13:
        float r116 = r114 / 2.0f;
        if (r106 <= r116) goto L16;
        r106 = r116;
    L16:
        float r117 = r113 - (r112 * 2.0f);
        float r118 = r114 - (2.0f * r106);
        r111.moveTo(r104, r103 + r106);
        if (r108 == false) goto L19;
        float r119 = -r106;
        r111.rQuadTo(0.0f, r119, -r112, r119);
    L20:
        r111.rLineTo(-r117, 0.0f);
        if (r107 == false) goto L23;
        float r120 = -r112;
        r111.rQuadTo(r120, 0.0f, r120, r106);
    L24:
        r111.rLineTo(0.0f, r118);
        if (r110 == false) goto L27;
        r111.rQuadTo(0.0f, r106, r112, r106);
    L28:
        r111.rLineTo(r117, 0.0f);
        if (r109 == false) goto L31;
        r111.rQuadTo(r112, 0.0f, r112, -r106);
    L32:
        r111.rLineTo(0.0f, -r118);
        r111.close();
        r210.drawPath(r111, getMHighlightPaint());
        goto L33
    L31:
        r111.rLineTo(r112, 0.0f);
        r111.rLineTo(0.0f, -r106);
        goto L32
    L27:
        r111.rLineTo(0.0f, r106);
        r111.rLineTo(r112, 0.0f);
        goto L28
    L23:
        r111.rLineTo(-r112, 0.0f);
        r111.rLineTo(0.0f, r106);
        goto L24
    L19:
        r111.rLineTo(0.0f, -r106);
        r111.rLineTo(-r112, 0.0f);
        goto L20
    L7:
        r112 = r106;
    L33:
        b r121 = getMScroller();
        if (r121.f205424a.getItemHeightPx() != 0) goto L36;
        int r122 = 0;
    L37:
        b r123 = getMScroller();
        if (r123.f205424a.getItemHeightPx() != 0) goto L40;
        int r124 = 0;
    L41:
        int r125 = (this.f205406c + 1) / 2;
        int r126 = r122 - r125;
        if (r124 >= 0) goto L44;
        r126 = r126 - 1;
    L46:
        int r127 = r122 + r125;
    L47:
        int r128 = r127;
        int r129 = r126;
    L48:
        if (r129 >= r128) goto L93;
        int r130 = ((ArrayList) this.f205417n).size();
        if (r130 != 0) goto L53;
    L64:
        String r131 = null;
    L65:
        String r132 = r131;
        if (r132 == null) goto L91;
        Rect r133 = this.f205410g;
        Intrinsics.checkNotNull(r133);
        int r134 = r133.centerX();
        Rect r135 = this.f205410g;
        Intrinsics.checkNotNull(r135);
        int r136 = r135.centerY();
        b r137 = getMScroller();
        if (r137.f205424a.getItemHeightPx() != 0) goto L71;
        int r138 = 0;
    L72:
        int r139 = ((r129 - r138) * this.f205408e) - r124;
        Paint.FontMetrics r140 = getMTextPaint().getFontMetrics();
        int r141 = (int) ((r140.top + r140.bottom) / 2);
        if (1 <= r139) goto L75;
    L77:
        boolean r142 = false;
    L78:
        if (r142 == false) goto L80;
        r210.save();
        Rect r143 = this.f205410g;
        Intrinsics.checkNotNull(r143);
        r210.clipRect(r143);
        float r144 = r134;
        float r145 = (r136 + r139) - r141;
        r210.drawText(r132, 0, r132.length(), r144, r145, getMSelectedTextPaint());
        r210.restore();
        r210.save();
        Rect r146 = this.f205411h;
        Intrinsics.checkNotNull(r146);
        r210.clipRect(r146);
        r210.drawText(r132, 0, r132.length(), r144, r145, getMTextPaint());
        r210.restore();
        goto L91
    L80:
        int r147 = this.f205408e;
        if (r139 < r147) goto L83;
        r210.save();
        Rect r148 = this.f205411h;
        Intrinsics.checkNotNull(r148);
        r210.clipRect(r148);
        r210.drawText(r132, 0, r132.length(), r134, (r136 + r139) - r141, getMTextPaint());
        r210.restore();
        goto L91
    L83:
        if (r139 >= 0) goto L88;
        if (r139 <= (-r147)) goto L88;
        r210.save();
        Rect r149 = this.f205410g;
        Intrinsics.checkNotNull(r149);
        r210.clipRect(r149);
        float r150 = r134;
        float r151 = (r136 + r139) - r141;
        r210.drawText(r132, 0, r132.length(), r150, r151, getMSelectedTextPaint());
        r210.restore();
        r210.save();
        Rect r152 = this.f205409f;
        Intrinsics.checkNotNull(r152);
        r210.clipRect(r152);
        r210.drawText(r132, 0, r132.length(), r150, r151, getMTextPaint());
        r210.restore();
    L88:
        if (r139 > (-r147)) goto L90;
        r210.save();
        Rect r153 = this.f205409f;
        Intrinsics.checkNotNull(r153);
        r210.clipRect(r153);
        r210.drawText(r132, 0, r132.length(), r134, (r136 + r139) - r141, getMTextPaint());
        r210.restore();
        goto L91
    L90:
        r210.save();
        Rect r154 = this.f205410g;
        Intrinsics.checkNotNull(r154);
        r210.clipRect(r154);
        r210.drawText(r132, 0, r132.length(), r134, (r136 + r139) - r141, getMSelectedTextPaint());
        r210.restore();
        goto L91
    L75:
        if (r139 >= this.f205408e) goto L77;
        r142 = true;
        goto L78
    L71:
        r138 = r137.f205425b / r137.f205424a.getItemHeightPx();
    L91:
        r129 = r129 + 1;
        goto L48
    L53:
        if (this.f205419p == false) goto L58;
        int r155 = r129 % r130;
        if (r155 >= 0) goto L57;
        r155 = r155 + r130;
    L57:
        r131 = (String) ListProtector.get(this.f205417n, r155);
        goto L65
    L58:
        if (r129 < 0) goto L61;
        if (r129 >= r130) goto L61;
        boolean r156 = true;
    L62:
        if (r156 == false) goto L64;
        r131 = (String) ListProtector.get(this.f205417n, r129);
    L61:
        r156 = false;
        goto L62
    L93:
        if (this.f205404a == false) goto L107;
        Rect r157 = this.f205410g;
        if (r157 == null) goto L106;
        float r158 = r157.left;
        float r159 = r157.top;
        r210.drawLine(r158, r159, r157.right, r159, getMDividerPaint());
        float r160 = r157.left;
        float r161 = r157.bottom;
        r210.drawLine(r160, r161, r157.right, r161, getMDividerPaint());
        return;
    L106:
        return;
    L107:
        return;
    L44:
        if (r124 <= 0) goto L46;
        r127 = (r122 + r125) + 1;
        goto L47
    L40:
        r124 = r123.f205425b % r123.f205424a.getItemHeightPx();
        goto L41
    L36:
        r122 = r121.f205425b / r121.f205424a.getItemHeightPx();
        goto L37
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        b r111 = getMScroller();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r111.f205428e != null) goto L5;
        r111.f205428e = VelocityTracker.obtain();
    L5:
        VelocityTracker r100 = r111.f205428e;
        if (r100 == null) goto L8;
        r100.addMovement(r110);
    L8:
        int r101 = r110.getAction();
        if (r101 != 0) goto L11;
        r111.f205426c = r110.getY();
        r111.forceFinished(true);
    L44:
        return true;
    L11:
        if (r101 == 1) goto L24;
        if (r101 != 2) goto L14;
        float r102 = r110.getY();
        int r103 = (int) (r102 - r111.f205426c);
        if (r103 == 0) goto L23;
        r111.a(-r103);
        r111.f205424a.invalidate();
    L23:
        r111.f205426c = r102;
        goto L44
    L14:
        if (r101 != 3) goto L44;
        VelocityTracker r104 = r111.f205428e;
        if (r104 == null) goto L19;
        r104.recycle();
    L19:
        r111.f205428e = null;
        goto L44
    L24:
        VelocityTracker r105 = r111.f205428e;
        if (r105 == null) goto L27;
        r105.computeCurrentVelocity(1000);
    L27:
        VelocityTracker r106 = r111.f205428e;
        if (r106 == null) goto L30;
        float r107 = r106.getYVelocity();
    L32:
        if (Math.abs(r107) <= 0) goto L38;
        int r112 = (r111.f205424a.getItemSize() - 1) * r111.f205424a.getItemHeightPx();
        int r113 = (int) (((double) r111.f205424a.getItemHeightPx()) * 0.4d);
        r111.f205427d = true;
        if (r111.f205424a.f205419p == false) goto L36;
        r111.fling(0, r111.f205425b, 0, ((int) (-r107)) / 2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    L37:
        r111.f205424a.invalidate();
    L39:
        VelocityTracker r108 = r111.f205428e;
        if (r108 == null) goto L42;
        r108.recycle();
    L42:
        r111.f205428e = null;
        goto L44
    L36:
        r111.fling(0, r111.f205425b, 0, ((int) (-r107)) / 2, 0, 0, 0, r112, 0, r113);
        goto L37
    L38:
        r111.c();
        goto L39
    L30:
        r107 = 0.0f;
        goto L32
    }

    public final void setCurrentIndex(int r100) {
        getMScroller().d(r100, false);
    }

    public final void setCyclic(boolean r100) {
        this.f205419p = r100;
        b r101 = getMScroller();
        r101.f205427d = false;
        r101.f205425b = 0;
        r101.f205430g = -1;
        int r102 = r101.b();
        if ((-1) == r102) goto L7;
        r101.f205430g = r102;
        r101.f205424a.performHapticFeedback(1, 2);
        com.bytedance.dux.picker.a r103 = r101.f205429f;
        if (r103 == null) goto L7;
        r103.onChanged();
    L7:
        r101.forceFinished(true);
        invalidate();
    }

    public final void setEntries(List<String> r100) {
        ((ArrayList) this.f205417n).clear();
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        ((ArrayList) this.f205417n).addAll(r101);
    L11:
        b r103 = getMScroller();
        r103.f205427d = false;
        r103.f205425b = 0;
        r103.f205430g = -1;
        int r104 = r103.b();
        if ((-1) == r104) goto L16;
        r103.f205430g = r104;
        r103.f205424a.performHapticFeedback(1, 2);
        com.bytedance.dux.picker.a r105 = r103.f205429f;
        if (r105 == null) goto L16;
        r105.onChanged();
    L16:
        r103.forceFinished(true);
        int r106 = this.f205405b;
        getMScroller().d(r106, false);
        invalidate();
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void setHighlightColor(int r100) {
        getMHighlightPaint().setColor(r100);
        invalidate();
    }

    public final void setHighlightConorRadiusPx(int r100) {
        this.f205418o = r100;
        invalidate();
    }

    public final void setItemCount(int r100) {
        this.f205406c = r100;
        invalidate();
    }

    public final void setItemHeightPx(int r100) {
        this.f205408e = r100;
        invalidate();
    }

    public final void setItemWidthPx(int r100) {
        this.f205407d = r100;
        invalidate();
    }

    public final void setOnWheelChangedListener(com.bytedance.dux.picker.a r100) {
        getMScroller().f205429f = r100;
    }

    public final void setSelectedTextColor(int r100) {
        getMSelectedTextPaint().setColor(r100);
        invalidate();
    }

    public final void setSelectedTextSizePx(float r100) {
        getMSelectedTextPaint().setTextSize(r100);
        invalidate();
    }

    public final void setShowBottomLeftCorner(boolean r100) {
        this.f205422s = r100;
    }

    public final void setShowBottomRightCorner(boolean r100) {
        this.f205423t = r100;
    }

    public final void setShowDivider(boolean r100) {
        this.f205404a = r100;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r100) {
        this.f205420q = r100;
    }

    public final void setShowTopRightCorner(boolean r100) {
        this.f205421r = r100;
    }

    public final void setStartIndex(int r100) {
        this.f205405b = r100;
        getMScroller().d(r100, false);
    }

    public final void setTextColor(int r100) {
        getMTextPaint().setColor(r100);
        invalidate();
    }

    public final void setTextSizePx(float r100) {
        getMTextPaint().setTextSize(r100);
        invalidate();
    }

    public final void setEntries(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        ((ArrayList) this.f205417n).clear();
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        CollectionsKt.addAll(this.f205417n, r100);
    L8:
        b r102 = getMScroller();
        r102.f205427d = false;
        r102.f205425b = 0;
        r102.f205430g = -1;
        int r103 = r102.b();
        if ((-1) == r103) goto L13;
        r102.f205430g = r103;
        r102.f205424a.performHapticFeedback(1, 2);
        com.bytedance.dux.picker.a r104 = r102.f205429f;
        if (r104 == null) goto L13;
        r104.onChanged();
    L13:
        r102.forceFinished(true);
        int r105 = this.f205405b;
        getMScroller().d(r105, false);
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public WheelView(final Context r210, AttributeSet r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211);
        this.f205406c = 5;
        float r100 = 343;
        this.f205407d = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
        float r101 = 48;
        this.f205408e = MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem())));
        this.f205412i = LazyKt.lazy(WheelView$mTextPaint$2.INSTANCE);
        this.f205413j = LazyKt.lazy(WheelView$mSelectedTextPaint$2.INSTANCE);
        this.f205414k = LazyKt.lazy(WheelView$mDividerPaint$2.INSTANCE);
        this.f205415l = LazyKt.lazy(WheelView$mHighlightPaint$2.INSTANCE);
        this.f205416m = LazyKt.lazy(new WheelView$mScroller$2(r210, this));
        this.f205417n = new ArrayList();
        float r102 = 4;
        this.f205418o = MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem())));
        this.f205420q = true;
        this.f205421r = true;
        this.f205422s = true;
        this.f205423t = true;
        TypedArray r103 = r210.obtainStyledAttributes(r211, new int[]{R.attr.wheelCyclic, R.attr.wheelEntries, R.attr.wheelHighlightColor, R.attr.wheelHighlightConorRadius, R.attr.wheelItemCount, R.attr.wheelItemHeight, R.attr.wheelItemWidth, R.attr.wheelSelectedTextColor, R.attr.wheelSelectedTextSize, R.attr.wheelShowDivider, R.attr.wheelStartIndex, R.attr.wheelTextColor, R.attr.wheelTextSize, R.attr.wheelView_cyclic, R.attr.wheelView_dividerColor, R.attr.wheelView_gravity, R.attr.wheelView_lineSpacingMultiplier, R.attr.wheelView_resistance, R.attr.wheelView_textColorCenter, R.attr.wheelView_textColorOut, R.attr.wheelView_textScaleOut, R.attr.wheelView_textSizeCenter, R.attr.wheelView_textSizeOut});
        boolean r110 = r103.getBoolean(0, false);
        int r111 = r103.getInt(10, 0);
        boolean r112 = r103.getBoolean(9, false);
        int r104 = r103.getInt(4, 5);
        int r105 = r103.getDimensionPixelOffset(6, MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))));
        int r106 = r103.getDimensionPixelOffset(5, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))));
        int r107 = r103.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(2, 17, a(Resources.getSystem()))));
        int r113 = r103.getColor(11, ContextCompat.getColor(r210, R.color.TextReverse3));
        int r108 = r103.getColor(7, ContextCompat.getColor(r210, R.color.TextReverse));
        int r109 = r103.getDimensionPixelSize(8, MathKt.roundToInt(TypedValue.applyDimension(2, 20, a(Resources.getSystem()))));
        int r114 = r103.getColor(2, ContextCompat.getColor(r210, R.color.BGInputReverse));
        int r115 = r103.getDimensionPixelOffset(3, MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem()))));
        CharSequence[] r116 = r103.getTextArray(1);
        if (r116 == null) goto L7;
        ArrayList r117 = new ArrayList(r116.length);
        int r118 = r116.length;
        int r119 = 0;
    L5:
        if (r119 >= r118) goto L8;
        r117.add(r116[r119].toString());
        r119 = r119 + 1;
        r118 = r118;
    L8:
        r103.recycle();
        setCyclic(r110);
        setShowDivider(r112);
        setStartIndex(r111);
        setItemCount(r104);
        setItemWidthPx(r105);
        setItemHeightPx(r106);
        setHighlightConorRadiusPx(r115);
        TextPaint r120 = getMTextPaint();
        r120.setTextAlign(Paint.Align.CENTER);
        r120.setTextSize(r107);
        r120.setColor(r113);
        TextPaint r121 = getMSelectedTextPaint();
        r121.setTextAlign(Paint.Align.CENTER);
        r121.setTextSize(r109);
        r121.setColor(r108);
        r121.setTypeface(Typeface.DEFAULT_BOLD);
        Paint r122 = getMDividerPaint();
        r122.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, a(Resources.getSystem())));
        r122.setColor(ContextCompat.getColor(r210, R.color.LinePrimary));
        Paint r123 = getMHighlightPaint();
        r123.setStyle(Paint.Style.FILL);
        r123.setColor(r114);
        if (r117 != null) goto L11;
    L14:
        boolean r124 = true;
    L15:
        if (r124 == true) goto L19;
        ((ArrayList) this.f205417n).addAll(r117);
        getMScroller().d(r111, false);
        return;
    L19:
        return;
    L11:
        if (r117.isEmpty() == true) goto L14;
        r124 = false;
        goto L15
    L7:
        r117 = null;
        goto L8
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 != 1073741824) goto L6;
        if (r104 != 1073741824) goto L6;
        setMeasuredDimension(r103, r105);
    L11:
        int r106 = getPaddingLeft();
        int r107 = getMeasuredWidth() - getPaddingRight();
        int r108 = getPaddingTop();
        int r109 = getMeasuredHeight() - getPaddingBottom();
        int r110 = (r108 + r109) / 2;
        Rect r111 = new Rect();
        r111.left = r106;
        r111.right = r107;
        int r112 = this.f205408e / 2;
        r111.top = r110 - r112;
        r111.bottom = r112 + r110;
        this.f205410g = r111;
        Rect r113 = new Rect();
        r113.left = r106;
        r113.right = r107;
        r113.top = r108;
        r113.bottom = r110 - (this.f205408e / 2);
        this.f205409f = r113;
        Rect r114 = new Rect();
        r114.left = r106;
        r114.right = r107;
        r114.top = r110 + (this.f205408e / 2);
        r114.bottom = r109;
        this.f205411h = r114;
        return;
    L6:
        if (r102 != 1073741824) goto L8;
        setMeasuredDimension(r103, getWheelHeight());
        goto L11
    L8:
        if (r104 != 1073741824) goto L10;
        setMeasuredDimension(getWheelWidth(), r105);
        goto L11
    L10:
        setMeasuredDimension(getWheelWidth(), getWheelHeight());
        goto L11
    }
}
