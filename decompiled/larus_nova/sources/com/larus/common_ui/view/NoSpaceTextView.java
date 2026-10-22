package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0018\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/larus/common_ui/view/NoSpaceTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "refreshMeasure", "", "value", "isRemoveExtraSpaceEnabled", "()Z", "setRemoveExtraSpaceEnabled", "(Z)V", "originalPaddingRecorded", "originalPaddingLeft", "originalPaddingTop", "originalPaddingRight", "originalPaddingBottom", "setText", "", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recordOriginalPaddingIfNeeded", "restoreOriginalPadding", "removeSpace", "widthSpc", "heightSpc", "linesText", "", "", "getLinesText", "()[Ljava/lang/String;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoSpaceTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f328247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f328248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f328249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f328250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f328251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f328252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f328253g;

    public static final class a {
    }

    static {
    }

    private final String[] getLinesText() {
        String[] r100 = new String[getLineCount()];
        String r101 = getText().toString();
        Layout r102 = getLayout();
        int r103 = getLineCount();
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L5;
        int r106 = r102.getLineEnd(r104);
        r100[r104] = r101.substring(r105, r106);
        r104 = r104 + 1;
        r105 = r106;
        goto L3
    L5:
        return r100;
    }

    public NoSpaceTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328248b = true;
    }

    public final void setRemoveExtraSpaceEnabled(boolean r100) {
        if (this.f328248b != r100) goto L5;
        return;
    L5:
        this.f328248b = r100;
        this.f328247a = r100;
        if (r100 == false) goto L8;
    L11:
        requestLayout();
        return;
    L8:
        if (this.f328249c == false) goto L11;
        setPadding(this.f328250d, this.f328251e, this.f328252f, this.f328253g);
        goto L11
    }

    public NoSpaceTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328248b = true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        if (this.f328248b == false) goto L29;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        if (this.f328249c == true) goto L8;
        this.f328249c = true;     // Catch: Throwable -> L19
        this.f328250d = getPaddingLeft();     // Catch: Throwable -> L19
        this.f328251e = getPaddingTop();     // Catch: Throwable -> L19
        this.f328252f = getPaddingRight();     // Catch: Throwable -> L19
        this.f328253g = getPaddingBottom();     // Catch: Throwable -> L19
    L8:
        String[] r101 = getLinesText();     // Catch: Throwable -> L19
        TextPaint r102 = getPaint();     // Catch: Throwable -> L19
        Rect r103 = new Rect();     // Catch: Throwable -> L19
        String r104 = r101[0];     // Catch: Throwable -> L19
        if (r104 == null) goto L30;
        r102.getTextBounds(r104, 0, r104.length(), r103);     // Catch: Throwable -> L19
        Paint.FontMetricsInt r105 = new Paint.FontMetricsInt();     // Catch: Throwable -> L19
        r102.getFontMetricsInt(r105);     // Catch: Throwable -> L19
        setPadding(getLeftPaddingOffset(), (r105.top - r103.top) + getTopPaddingOffset(), getRightPaddingOffset(), getBottomPaddingOffset());     // Catch: Throwable -> L19
        String r106 = r101[r101.length - 1];     // Catch: Throwable -> L19
        if (r106 == null) goto L31;
        r102.getTextBounds(r106, 0, r106.length(), r103);     // Catch: Throwable -> L19
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - (r105.bottom - r103.bottom));     // Catch: Throwable -> L19
        if (this.f328247a == false) goto L17;
        this.f328247a = false;     // Catch: Throwable -> L19
        measure(r110, r111);     // Catch: Throwable -> L19
    L17:
        Object r112 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L19
    L21:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L25;
        FLogger.f375446a.e("NoSpaceTextView", "removeSpace failed:" + r113);
        r112 = Boolean.FALSE;
    L25:
        ((Boolean) r112).booleanValue();
        return;
    L31:
        return;
    L30:
        return;
    L19:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "type");
        super.setText(r100, r101);
        this.f328247a = this.f328248b;
    }

    public NoSpaceTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328248b = true;
    }
}
