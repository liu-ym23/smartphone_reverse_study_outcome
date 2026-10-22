package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.smartreply;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 J2\u00020\u0001:\u0002JKB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\fJ\u0010\u0010.\u001a\u00020,2\b\b\u0001\u0010/\u001a\u00020\fJ\b\u00100\u001a\u00020,H\u0002J \u00101\u001a\u00020,2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0014J8\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0002J.\u00107\u001a\u0004\u0018\u00010\u000e2\b\u00108\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010:\u001a\u00020\"H\u0002J\u0012\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u000eH\u0002J8\u0010=\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fH\u0002J\u000e\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0015J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u00020\"H\u0016J\u0012\u0010G\u001a\u00020\"2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/block/smartreply/EllipsizeAddSuffixView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "content", "", "suffix", "maxLineCount", "", "originLayout", "Landroid/text/Layout;", "displayLayout", "lastMeasureWidth", "lastMeasureHeight", "textSize", "textColor", "lineSpacing", "", "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint$delegate", "Lkotlin/Lazy;", "ellipsizeWidth", "getEllipsizeWidth", "()F", "ellipsizeWidth$delegate", "noEllipsizeWidth", "ellipsisV2", "", "getEllipsisV2", "()Z", "setEllipsisV2", "(Z)V", "clickableRect", "Landroid/graphics/Rect;", "clickableSpan", "Landroid/text/style/ClickableSpan;", "setTextSize", "", "size", "setTextColor", "color", "requestLayoutIfNeed", "setInfo", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "makeCombineLayoutIfNeed", "wantWidth", "makeNewLayout", "text", "width", "ellipsize", "getTextExcludeLastLine", "layout", "createDisplayLayout", "totalWidth", "setLineSpacing", "spacing", "onDraw", "canvas", "Landroid/graphics/Canvas;", "performClick", "lastTouchDownEventPosition", "Landroid/graphics/Point;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "SuffixSpan", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EllipsizeAddSuffixView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f412159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f412160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f412161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f412162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f412163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f412164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f412165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f412166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Point f412167i;

    public static final class a {
    }

    static {
    }

    public final void setLineSpacing(float r100) {
    }

    private final float getEllipsizeWidth() {
        return ((Number) this.f412164f.getValue()).floatValue();
    }

    private final TextPaint getTextPaint() {
        return (TextPaint) this.f412163e.getValue();
    }

    @Override // android.view.View
    public final boolean performClick() {
        Rect r100 = this.f412166h;
        Point r101 = this.f412167i;
        r100.contains(r101.x, r101.y);
        return super.performClick();
    }

    public final boolean getEllipsisV2() {
        return this.f412165g;
    }

    public EllipsizeAddSuffixView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ TextPaint a(EllipsizeAddSuffixView r100) {
        return r100.getTextPaint();
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L7;
        if (r100.getActionMasked() != 0) goto L7;
        this.f412167i.set((int) r100.getX(), (int) r100.getY());
    L7:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getPaddingLeft();
        float r102 = getPaddingTop();
        int r103 = r100.save();
        r100.translate(r101, r102);
        r100.restoreToCount(r103);
    }

    public final void setEllipsisV2(boolean r100) {
        this.f412165g = r100;
    }

    public final void setTextColor(int r100) {
        if (this.f412162d == r100) goto L6;
        this.f412162d = r100;
        return;
    }

    public final void setTextSize(int r100) {
        if (this.f412161c == r100) goto L6;
        this.f412161c = r100;
        return;
    }

    public EllipsizeAddSuffixView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f412161c = UIUtils.dp2px(r100, 14.0f);
        this.f412162d = UIUtils.getColor(r100, R.color.text_caption);
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.f412163e = LazyKt.lazy(r102, new EllipsizeAddSuffixView$textPaint$2(this));
        this.f412164f = LazyKt.lazy(r102, new EllipsizeAddSuffixView$ellipsizeWidth$2(this));
        this.f412166h = new Rect();
        this.f412167i = new Point();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r102 != this.f412159a) goto L5;
        int r104 = this.f412160b;
    L5:
        getPaddingLeft();
        getPaddingRight();
        View.MeasureSpec.getMode(r100);
        View.MeasureSpec.getMode(r101);
        setMeasuredDimension(r102, r103);
        this.f412159a = r102;
        this.f412160b = r103;
    }
}
