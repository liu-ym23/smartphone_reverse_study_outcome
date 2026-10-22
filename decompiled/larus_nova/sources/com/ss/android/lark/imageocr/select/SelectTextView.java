package com.ss.android.lark.imageocr.select;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\f\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0014J\u0012\u0010#\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/ss/android/lark/imageocr/select/SelectTextView;", "Landroid/widget/TextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectionColor", "Ljava/lang/Integer;", "start", "end", "highlightPath", "Landroid/graphics/Path;", "highlightPaint", "Landroid/graphics/Paint;", "doubleTapListener", "Lcom/ss/android/lark/imageocr/select/SelectTextView$OnDoubleTapListener;", "delayCancelHandler", "Landroid/os/Handler;", "getDelayCancelHandler", "()Landroid/os/Handler;", "delayCancelHandler$delegate", "Lkotlin/Lazy;", "setSelectionColor", "", "setSelection", "setOnDoubleTapListener", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateUpdatedHighlightPath", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isInDoubleTaping", "delayCancelDoubleTap", "cancelDoubleTap", "onDetachedFromWindow", "Companion", "OnDoubleTapListener", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f426483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f426484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f426485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f426486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f426487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f426488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f426489g;

    public static final class a {
    }

    public interface b {
        void c();
    }

    static {
    }

    private final Handler getDelayCancelHandler() {
        return (Handler) this.f426489g.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("SelectTextView", "cancelDoubleTap");
        getDelayCancelHandler().removeMessages(100);
    }

    public SelectTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        CharSequence r101 = getText();
        if ((r101 instanceof Spannable) == false) goto L35;
        int r102 = this.f426484b;
        if (r102 < 0) goto L24;
        Spannable r103 = (Spannable) r101;
        if (r102 >= r103.length()) goto L24;
        int r104 = this.f426485c;
        if (r104 <= 0) goto L24;
        if (r104 > r103.length()) goto L24;
        Path r105 = this.f426486d;
        if (r105 != null) goto L16;
        this.f426486d = new Path();
    L17:
        getLayout().getSelectionPath(this.f426484b, this.f426485c, this.f426486d);
        if (this.f426487e == null) goto L20;
    L25:
        Path r106 = this.f426486d;
        if (r106 == null) goto L32;
        Paint r107 = this.f426487e;
        if (r107 == null) goto L33;
        if (r100 == null) goto L34;
        r100.drawPath(r106, r107);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L20:
        if (this.f426483a == null) goto L25;
        Paint r108 = new Paint(1);
        this.f426487e = r108;
        Integer r109 = this.f426483a;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Int");
        r108.setColor(r109.intValue());
        Paint r110 = this.f426487e;
        if (r110 == null) goto L25;
        r110.setStyle(Paint.Style.FILL);
        goto L25
    L16:
        r105.reset();
    L24:
        this.f426486d = null;
        this.f426487e = null;
        goto L25
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.f426488f != null) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L21;
        if (getDelayCancelHandler().hasMessages(100) == false) goto L19;
        Log.i("SelectTextView", "onDoubleTap");
        Log.i("SelectTextView", "cancelDoubleTap");
        getDelayCancelHandler().removeMessages(100);
        b r102 = this.f426488f;
        if (r102 == null) goto L18;
        r102.c();
    L18:
        return true;
    L19:
        Log.i("SelectTextView", "delayCancelDoubleTap");
        Handler r103 = getDelayCancelHandler();
        Message r104 = Message.obtain();
        r104.what = 100;
        r103.sendMessageDelayed(r104, ViewConfiguration.getDoubleTapTimeout());
    L21:
        return super.onTouchEvent(r100);
    L9:
        if (r100.getAction() != 0) goto L11;
        r101 = true;
        goto L12
    }

    public final void setOnDoubleTapListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "doubleTapListener");
        this.f426488f = r100;
    }

    public final void setSelectionColor(int r100) {
        this.f426483a = Integer.valueOf(r100);
    }

    public SelectTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public SelectTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f426484b = -1;
        this.f426485c = -1;
        this.f426489g = LazyKt.lazy(SelectTextView$delayCancelHandler$2.INSTANCE);
    }
}
