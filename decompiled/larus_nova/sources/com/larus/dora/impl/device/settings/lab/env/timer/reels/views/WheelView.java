package com.larus.dora.impl.device.settings.lab.env.timer.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import v49.f;
import v49.g;
import v49.h;
import v49.i;
import v49.j;
import v49.k;
import v49.l;
import v49.m;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009c\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u0010H\u0014J\b\u0010H\u001a\u00020EH\u0014J\b\u0010I\u001a\u00020EH\u0002J\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0014J\u0010\u0010Q\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010R\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J \u0010S\u001a\u00020E2\u0006\u0010O\u001a\u00020P2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010A2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010V\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010W\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020EH\u0016J\u0006\u0010\\\u001a\u00020\u0010J\u0006\u0010]\u001a\u00020\u0010J\u0010\u0010{\u001a\u0004\u0018\u00010A2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0081\u0001\u001a\u00020E2\u0006\u0010\u000f\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\tJ#\u0010\u0083\u0001\u001a\u00020E2\u0014\u0010\u0084\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020A0\u0085\u0001\"\u00020A¢\u0006\u0003\u0010\u0086\u0001J\u0019\u0010\u0083\u0001\u001a\u00020E2\u0010\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u0087\u0001J\u0010\u0010\u0088\u0001\u001a\u00020E2\u0007\u0010\u0089\u0001\u001a\u00020CR$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b-\u0010)R\u001b\u0010/\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b0\u0010)R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b8\u00105R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010+\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0013R\u0014\u0010L\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0013R$\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0013\"\u0004\ba\u0010\u0015R$\u0010c\u001a\u00020\t2\u0006\u0010b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\f\"\u0004\bd\u0010\u000eR$\u0010g\u001a\u00020f2\u0006\u0010e\u001a\u00020f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010m\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010\u0013\"\u0004\bo\u0010\u0015R$\u0010p\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010\u0013\"\u0004\br\u0010\u0015R$\u0010s\u001a\u00020f2\u0006\u0010e\u001a\u00020f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010i\"\u0004\bu\u0010kR$\u0010v\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010\u0013\"\u0004\bx\u0010\u0015R\u0011\u0010y\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bz\u0010\u0013R\u0013\u0010|\u001a\u0004\u0018\u00010A8F¢\u0006\u0006\u001a\u0004\b}\u0010~R&\u0010\u007f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010\u0013\"\u0005\b\u0081\u0001\u0010\u0015R0\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001d\u0010\u0090\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\f\"\u0005\b\u0092\u0001\u0010\u000eR\u001d\u0010\u0093\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\f\"\u0005\b\u0095\u0001\u0010\u000eR\u001d\u0010\u0096\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\f\"\u0005\b\u0098\u0001\u0010\u000eR\u001d\u0010\u0099\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\f\"\u0005\b\u009b\u0001\u0010\u000e¨\u0006\u009d\u0001"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShow", "", "showDivider", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "index", "", "startIndex", "getStartIndex", "()I", "setStartIndex", "(I)V", "count", "itemCount", "getItemCount", "setItemCount", "width", "itemWidthPx", "getItemWidthPx", "setItemWidthPx", "height", "itemHeightPx", "getItemHeightPx", "setItemHeightPx", "mClipRectTop", "Landroid/graphics/Rect;", "mClipRectMiddle", "mClipRectBottom", "mTextPaint", "Landroid/text/TextPaint;", "getMTextPaint", "()Landroid/text/TextPaint;", "mTextPaint$delegate", "Lkotlin/Lazy;", "mTagTextPaint", "getMTagTextPaint", "mTagTextPaint$delegate", "mSelectedTextPaint", "getMSelectedTextPaint", "mSelectedTextPaint$delegate", "mDividerPaint", "Landroid/graphics/Paint;", "getMDividerPaint", "()Landroid/graphics/Paint;", "mDividerPaint$delegate", "mHighlightPaint", "getMHighlightPaint", "mHighlightPaint$delegate", "mScroller", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelScroller;", "getMScroller", "()Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelScroller;", "mScroller$delegate", "mEntries", "", "", "mTag", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "updateClipRect", "wheelWidth", "getWheelWidth", "wheelHeight", "getWheelHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawTag", "drawItems", "drawItem", "offset", "getStringFromIndex", "drawHighlight", "drawDivider", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "computeScroll", "getClipMiddleRectTop", "getClipMiddleRectBottom", "radius", "highlightConorRadiusPx", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "cyclic", "isCyclic", "setCyclic", "size", "", "textSizePx", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "color", "textColor", "getTextColor", "setTextColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextSizePx", "getSelectedTextSizePx", "setSelectedTextSizePx", "highlightColor", "getHighlightColor", "setHighlightColor", "itemSize", "getItemSize", "getItem", "currentItem", "getCurrentItem", "()Ljava/lang/String;", "currentIndex", "getCurrentIndex", "setCurrentIndex", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "setEntries", "entries", "", "([Ljava/lang/String;)V", "", "setTagText", "tag", "onWheelChangedListener", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/OnWheelChangedListener;)V", "showTopLeftCorner", "getShowTopLeftCorner", "setShowTopLeftCorner", "showTopRightCorner", "getShowTopRightCorner", "setShowTopRightCorner", "showBottomLeftCorner", "getShowBottomLeftCorner", "setShowBottomLeftCorner", "showBottomRightCorner", "getShowBottomRightCorner", "setShowBottomRightCorner", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WheelView extends View {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f334671w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f334672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f334673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f334674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f334675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f334676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f334677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f334678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f334679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f334680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f334681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f334682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f334683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f334684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f334685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f334686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f334687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f334688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f334689r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f334690s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f334691t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f334692u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f334693v;

    public static final class a {
    }

    static {
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.f334683l.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.f334684m.getValue();
    }

    private final g getMScroller() {
        return (g) this.f334685n.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.f334682k.getValue();
    }

    private final TextPaint getMTagTextPaint() {
        return (TextPaint) this.f334681j.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.f334680i.getValue();
    }

    public final int getClipMiddleRectBottom() {
        Rect r100 = this.f334678g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r100 = this.f334678g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.top;
    }

    public final int getItemSize() {
        return ((ArrayList) this.f334686o).size();
    }

    private final int getWheelHeight() {
        return ((getPaddingTop() + getPaddingBottom()) + (this.f334676e * this.f334674c)) - MathKt.roundToInt(TypedValue.applyDimension(1, 30, a(Resources.getSystem())));
    }

    private final int getWheelWidth() {
        return (getPaddingLeft() + getPaddingRight()) + this.f334675d;
    }

    @Override // android.view.View
    public final void computeScroll() {
        g r100 = getMScroller();
        if (r100.f553143d == false) goto L9;
        r100.f553143d = r100.computeScrollOffset();
        r100.a(r100.getCurrY() - r100.f553141b, "computeScroll");
        if (r100.f553143d == false) goto L7;
        r100.f553140a.postInvalidate();
        return;
    L7:
        g.c(r100);
        return;
    }

    public final int getCurrentIndex() {
        return getMScroller().b();
    }

    public final String getCurrentItem() {
        int r100 = getCurrentIndex();
        if (r100 >= 0) goto L8;
        if (r100 < ((ArrayList) this.f334686o).size()) goto L8;
        return null;
    L8:
        return (String) ListProtector.get(this.f334686o, r100);
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final v49.a getOnWheelChangedListener() {
        return getMScroller().f553146g;
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

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        g r100 = getMScroller();
        Context r101 = getContext();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final int getHighlightConorRadiusPx() {
        return this.f334688q;
    }

    public final int getItemCount() {
        return this.f334674c;
    }

    public final int getItemHeightPx() {
        return this.f334676e;
    }

    public final int getItemWidthPx() {
        return this.f334675d;
    }

    public final boolean getShowBottomLeftCorner() {
        return this.f334692u;
    }

    public final boolean getShowBottomRightCorner() {
        return this.f334693v;
    }

    public final boolean getShowDivider() {
        return this.f334672a;
    }

    public final boolean getShowTopLeftCorner() {
        return this.f334690s;
    }

    public final boolean getShowTopRightCorner() {
        return this.f334691t;
    }

    public final int getStartIndex() {
        return this.f334673b;
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
        g r100 = getMScroller();
        if (r100.f553140a.getItemHeightPx() != 0) goto L5;
        int r101 = 0;
    L6:
        g r102 = getMScroller();
        if (r102.f553140a.getItemHeightPx() != 0) goto L9;
        int r110 = 0;
    L10:
        int r103 = (this.f334674c + 1) / 2;
        int r104 = r101 - r103;
        if (r110 >= 0) goto L13;
        r104 = r104 - 1;
    L15:
        int r105 = r101 + r103;
    L16:
        int r111 = r105;
        int r112 = r104;
    L17:
        if (r112 >= r111) goto L61;
        int r106 = ((ArrayList) this.f334686o).size();
        if (r106 != 0) goto L22;
    L33:
        String r107 = null;
    L34:
        String r113 = r107;
        if (r113 == null) goto L59;
        Rect r108 = this.f334678g;
        Intrinsics.checkNotNull(r108);
        int r109 = r108.centerX();
        Rect r114 = this.f334678g;
        Intrinsics.checkNotNull(r114);
        int r115 = r114.centerY();
        Paint.FontMetrics r116 = getMTextPaint().getFontMetrics();
        float r117 = r116.top + r116.bottom;
        float r118 = 2;
        int r119 = (int) (r117 / r118);
        Paint.FontMetrics r120 = getMSelectedTextPaint().getFontMetrics();
        int r121 = (int) ((r120.top + r120.bottom) / r118);
        g r122 = getMScroller();
        if (r122.f553140a.getItemHeightPx() != 0) goto L40;
        int r123 = 0;
    L41:
        int r124 = r112 - r123;
        int r125 = this.f334676e;
        int r126 = (r124 * r125) - r110;
        if (1 > r126) goto L45;
        if (r126 >= r125) goto L45;
        boolean r127 = true;
    L46:
        if (r127 == false) goto L49;
        r210.save();
        Rect r128 = this.f334678g;
        Intrinsics.checkNotNull(r128);
        r210.clipRect(r128);
        float r129 = r109;
        int r130 = r126 + r115;
        r210.drawText(r113, 0, r113.length(), r129, r130 - r121, getMSelectedTextPaint());
        r210.restore();
        r210.save();
        Rect r131 = this.f334679h;
        Intrinsics.checkNotNull(r131);
        r210.clipRect(r131);
        r210.drawText(r113, 0, r113.length(), r129, r130 - r119, getMTextPaint());
        r210.restore();
        goto L59
    L49:
        if (r126 < r125) goto L51;
        r210.save();
        Rect r132 = this.f334679h;
        Intrinsics.checkNotNull(r132);
        r210.clipRect(r132);
        r210.drawText(r113, 0, r113.length(), r109, (r115 + r126) - r119, getMTextPaint());
        r210.restore();
        goto L59
    L51:
        if (r126 >= 0) goto L56;
        if (r126 <= (-r125)) goto L56;
        r210.save();
        Rect r133 = this.f334678g;
        Intrinsics.checkNotNull(r133);
        r210.clipRect(r133);
        float r134 = r109;
        int r135 = r126 + r115;
        r210.drawText(r113, 0, r113.length(), r134, r135 - r121, getMSelectedTextPaint());
        r210.restore();
        r210.save();
        Rect r136 = this.f334677f;
        Intrinsics.checkNotNull(r136);
        r210.clipRect(r136);
        r210.drawText(r113, 0, r113.length(), r134, r135 - r119, getMTextPaint());
        r210.restore();
    L56:
        if (r126 > (-r125)) goto L58;
        r210.save();
        Rect r137 = this.f334677f;
        Intrinsics.checkNotNull(r137);
        r210.clipRect(r137);
        r210.drawText(r113, 0, r113.length(), r109, (r115 + r126) - r119, getMTextPaint());
        r210.restore();
        goto L59
    L58:
        r210.save();
        Rect r138 = this.f334678g;
        Intrinsics.checkNotNull(r138);
        r210.clipRect(r138);
        r210.drawText(r113, 0, r113.length(), r109, (r115 + r126) - r121, getMSelectedTextPaint());
        r210.restore();
    L45:
        r127 = false;
        goto L46
    L40:
        r123 = r122.f553141b / r122.f553140a.getItemHeightPx();
    L59:
        r112 = r112 + 1;
        goto L17
    L22:
        if (this.f334689r == false) goto L27;
        int r139 = r112 % r106;
        if (r139 >= 0) goto L26;
        r139 = r139 + r106;
    L26:
        r107 = (String) ListProtector.get(this.f334686o, r139);
        goto L34
    L27:
        if (r112 < 0) goto L30;
        if (r112 >= r106) goto L30;
        boolean r140 = true;
    L31:
        if (r140 == false) goto L33;
        r107 = (String) ListProtector.get(this.f334686o, r112);
    L30:
        r140 = false;
        goto L31
    L61:
        if (this.f334672a == false) goto L66;
        Rect r141 = this.f334678g;
        if (r141 == null) goto L66;
        float r142 = r141.left;
        float r143 = r141.top;
        r210.drawLine(r142, r143, r141.right, r143, getMDividerPaint());
        float r144 = r141.left;
        float r145 = r141.bottom;
        r210.drawLine(r144, r145, r141.right, r145, getMDividerPaint());
    L66:
        CharSequence r146 = this.f334687p;
        if (r146 == null) goto L78;
        Rect r147 = this.f334678g;
        Intrinsics.checkNotNull(r147);
        int r148 = r147.centerY();
        Rect r149 = this.f334678g;
        Intrinsics.checkNotNull(r149);
        int r150 = r149.centerX();
        Paint.FontMetrics r151 = getMTagTextPaint().getFontMetrics();
        int r152 = (int) ((r151.top + r151.bottom) / 2);
        r210.drawText(r146, 0, r146.length(), MathKt.roundToInt(TypedValue.applyDimension(1, 14, a(Resources.getSystem()))) + r150, r148 - r152, getMTagTextPaint());
        return;
    L78:
        return;
    L13:
        if (r110 <= 0) goto L15;
        r105 = (r101 + r103) + 1;
        goto L16
    L9:
        r110 = r102.f553141b % r102.f553140a.getItemHeightPx();
        goto L10
    L5:
        r101 = r100.f553141b / r100.f553140a.getItemHeightPx();
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        g r100 = getMScroller();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r100.f553144e != null) goto L5;
        r100.f553144e = VelocityTracker.obtain();
    L5:
        VelocityTracker r101 = r100.f553144e;
        if (r101 == null) goto L8;
        r101.addMovement(r110);
    L8:
        int r102 = r110.getAction();
        if (r102 != 0) goto L11;
        ViewParent r103 = r100.f553140a.getParent();
        if (r103 == null) goto L58;
        r103.requestDisallowInterceptTouchEvent(true);
    L58:
        r100.f553142c = r110.getY();
        r100.forceFinished(true);
        r100.f553145f = false;
        r100.f553143d = false;
    L59:
        return true;
    L11:
        if (r102 == 1) goto L29;
        if (r102 != 2) goto L14;
        float r111 = r110.getY();
        int r104 = (int) (r111 - r100.f553142c);
        if (r104 == 0) goto L28;
        r100.f553145f = true;
        r100.a(-r104, "touchEvent");
        r100.f553140a.invalidate();
    L28:
        r100.f553142c = r111;
        goto L59
    L14:
        if (r102 != 3) goto L59;
        if (r100.f553145f == false) goto L19;
        g.c(r100);
    L19:
        VelocityTracker r112 = r100.f553144e;
        if (r112 == null) goto L22;
        r112.recycle();
    L22:
        r100.f553144e = null;
        r100.f553145f = false;
        ViewParent r113 = r100.f553140a.getParent();
        if (r113 == null) goto L59;
        r113.requestDisallowInterceptTouchEvent(false);
        goto L59
    L29:
        VelocityTracker r105 = r100.f553144e;
        if (r105 == null) goto L32;
        r105.computeCurrentVelocity(1000);
    L32:
        VelocityTracker r106 = r100.f553144e;
        if (r106 == null) goto L35;
        float r107 = r106.getYVelocity();
    L37:
        if (Math.abs(r107) <= 0.0f) goto L44;
        int r108 = (r100.f553140a.getItemSize() - 1) * r100.f553140a.getItemHeightPx();
        int r109 = r100.f553140a.getItemHeightPx() * 0;
        r100.f553143d = true;
        WheelView r114 = r100.f553140a;
        if (r114.f334689r == false) goto L41;
        Class<?> r115 = f.f553136a;
        f.c(r100, r114.getItemHeightPx(), r100.f553141b, ((int) (-r107)) / 2, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    L42:
        r100.f553140a.invalidate();
    L49:
        VelocityTracker r116 = r100.f553144e;
        if (r116 == null) goto L52;
        r116.recycle();
    L52:
        r100.f553144e = null;
        ViewParent r117 = r100.f553140a.getParent();
        if (r117 == null) goto L59;
        r117.requestDisallowInterceptTouchEvent(false);
        goto L59
    L41:
        Class<?> r118 = f.f553136a;
        f.c(r100, r114.getItemHeightPx(), r100.f553141b, ((int) (-r107)) / 2, 0, r108, r109);
        goto L42
    L44:
        if (r100.f553145f == true) goto L48;
        float r119 = r110.getY() - (r100.f553140a.getHeight() / 2.0f);
        if (Math.abs(r119) <= 1.0f) goto L49;
        r100.f553143d = true;
        r100.g(r100.f553141b, (int) r119, 200, "ACTION_UP");
        r100.f553140a.invalidate();
        goto L49
    L48:
        g.c(r100);
        goto L49
    L35:
        r107 = 0.0f;
        goto L37
    }

    public final void setCurrentIndex(int r100) {
        b(r100, false);
    }

    public final void setCyclic(boolean r100) {
        this.f334689r = r100;
        getMScroller().e();
        invalidate();
    }

    public final void setEntries(List<String> r100) {
        ((ArrayList) this.f334686o).clear();
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        ((ArrayList) this.f334686o).addAll(r101);
    L11:
        getMScroller().e();
        b(this.f334673b, false);
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
        this.f334688q = r100;
        invalidate();
    }

    public final void setItemCount(int r100) {
        this.f334674c = r100;
        invalidate();
    }

    public final void setItemHeightPx(int r100) {
        this.f334676e = r100;
        invalidate();
    }

    public final void setItemWidthPx(int r100) {
        this.f334675d = r100;
        invalidate();
    }

    public final void setOnWheelChangedListener(v49.a r100) {
        getMScroller().f553146g = r100;
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
        this.f334692u = r100;
    }

    public final void setShowBottomRightCorner(boolean r100) {
        this.f334693v = r100;
    }

    public final void setShowDivider(boolean r100) {
        this.f334672a = r100;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r100) {
        this.f334690s = r100;
    }

    public final void setShowTopRightCorner(boolean r100) {
        this.f334691t = r100;
    }

    public final void setStartIndex(int r100) {
        this.f334673b = r100;
        getMScroller().f(r100, false);
    }

    public final void setTagText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        this.f334687p = r100;
        invalidate();
        return;
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
        ((ArrayList) this.f334686o).clear();
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        CollectionsKt.addAll(this.f334686o, r100);
    L8:
        getMScroller().e();
        b(this.f334673b, false);
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public WheelView(final Context r210, AttributeSet r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211);
        this.f334674c = 7;
        float r100 = 343;
        this.f334675d = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
        this.f334676e = MathKt.roundToInt(TypedValue.applyDimension(1, 48, a(Resources.getSystem())));
        this.f334680i = LazyKt.lazy(new h());
        this.f334681j = LazyKt.lazy(new i());
        this.f334682k = LazyKt.lazy(new j());
        this.f334683l = LazyKt.lazy(new k());
        this.f334684m = LazyKt.lazy(new l());
        this.f334685n = LazyKt.lazy(new m(r210, this));
        this.f334686o = new ArrayList();
        float r101 = 8;
        this.f334688q = MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem())));
        this.f334689r = true;
        TypedArray r102 = r210.obtainStyledAttributes(r211, new int[]{R.attr.oui_wheelCyclic, R.attr.oui_wheelEntries, R.attr.oui_wheelHighlightColor, R.attr.oui_wheelHighlightConorRadius, R.attr.oui_wheelItemCount, R.attr.oui_wheelItemHeight, R.attr.oui_wheelItemWidth, R.attr.oui_wheelSelectedTextColor, R.attr.oui_wheelSelectedTextSize, R.attr.oui_wheelShowDivider, R.attr.oui_wheelStartIndex, R.attr.oui_wheelTextColor, R.attr.oui_wheelTextSize});
        boolean r103 = r102.getBoolean(0, true);
        int r110 = r102.getInt(10, 0);
        boolean r111 = r102.getBoolean(9, false);
        int r112 = r102.getInt(4, 7);
        int r104 = r102.getDimensionPixelOffset(6, MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))));
        int r113 = r102.getDimensionPixelOffset(5, MathKt.roundToInt(TypedValue.applyDimension(1, 40, a(Resources.getSystem()))));
        int r114 = r102.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(2, 16, a(Resources.getSystem()))));
        int r105 = r102.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(2, 14, a(Resources.getSystem()))));
        int r106 = r102.getColor(11, ContextCompat.getColor(r210, R.color.larus_dora_env_observe_reel_unselect_text_color));
        int r107 = r102.getColor(7, ContextCompat.getColor(r210, R.color.larus_neutral_100));
        int r108 = r102.getDimensionPixelSize(8, MathKt.roundToInt(TypedValue.applyDimension(2, 20, a(Resources.getSystem()))));
        int r109 = r102.getColor(2, ContextCompat.getColor(r210, R.color.larus_press));
        int r115 = r102.getDimensionPixelOffset(3, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))));
        CharSequence[] r116 = r102.getTextArray(1);
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
        r102.recycle();
        setCyclic(r103);
        setShowDivider(r111);
        setStartIndex(r110);
        setItemCount(r112);
        setItemWidthPx(r104);
        setItemHeightPx(r113);
        setHighlightConorRadiusPx(r115);
        TextPaint r120 = getMTextPaint();
        r120.setTextAlign(Paint.Align.CENTER);
        r120.setTextSize(r114);
        r120.setColor(r106);
        r120.setTypeface(Typeface.create(null, 480, false));
        TextPaint r121 = getMTagTextPaint();
        r121.setTextAlign(Paint.Align.LEFT);
        r121.setTextSize(r105);
        r121.setColor(r106);
        r121.setTypeface(Typeface.create(null, 600, false));
        TextPaint r122 = getMSelectedTextPaint();
        r122.setTextAlign(Paint.Align.CENTER);
        r122.setTextSize(r108);
        r122.setColor(r107);
        r122.setTypeface(Typeface.create(null, 640, false));
        Paint r123 = getMDividerPaint();
        r123.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, a(Resources.getSystem())));
        r123.setColor(ContextCompat.getColor(r210, R.color.LinePrimary));
        Paint r124 = getMHighlightPaint();
        r124.setStyle(Paint.Style.FILL);
        r124.setColor(r109);
        ArrayList r125 = r117;
        if (r125 != null) goto L11;
    L14:
        boolean r126 = true;
    L15:
        if (r126 == true) goto L19;
        this.f334686o.addAll(r117);
        b(r110, false);
        return;
    L19:
        return;
    L11:
        if (r125.isEmpty() == true) goto L14;
        r126 = false;
        goto L15
    L7:
        r117 = null;
        goto L8
    }

    public final void b(int r100, boolean r101) {
        getMScroller().f(r100, r101);
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
        int r112 = this.f334676e / 2;
        r111.top = r110 - r112;
        r111.bottom = r112 + r110;
        this.f334678g = r111;
        Rect r113 = new Rect();
        r113.left = r106;
        r113.right = r107;
        r113.top = r108;
        r113.bottom = r110 - (this.f334676e / 2);
        this.f334677f = r113;
        Rect r114 = new Rect();
        r114.left = r106;
        r114.right = r107;
        r114.top = r110 + (this.f334676e / 2);
        r114.bottom = r109;
        this.f334679h = r114;
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
