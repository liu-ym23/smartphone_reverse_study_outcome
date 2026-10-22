package com.ss.android.lark.widget.textview;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u001c\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/ss/android/lark/widget/textview/TailTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidthMeasureSpec", "mHeightMeasureSpec", "mTailContent", "", "mEllipsizeFinal", "", "getMEllipsizeFinal", "()Z", "setMEllipsizeFinal", "(Z)V", "setTailContent", "", "tailContent", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "doMeasure", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TailTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f448936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f448937d;

    public static final class a {
    }

    static {
    }

    public final boolean getMEllipsizeFinal() {
        return this.f448937d;
    }

    public TailTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f448936c = "";
    }

    public final void setMEllipsizeFinal(boolean r100) {
        this.f448937d = r100;
    }

    public final void setTailContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tailContent");
        this.f448936c = r100;
        this.f448937d = false;
    }

    public TailTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f448936c = "";
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        if (this.f448934a == r110) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (TextUtils.isEmpty(this.f448936c) == false) goto L11;
        return;
    L11:
        if (this.f448937d == false) goto L14;
        if (r100 == false) goto L14;
        return;
    L14:
        this.f448934a = r110;
        this.f448935b = r111;
        int r101 = getLineCount();
        Layout r102 = getLayout();
        int r103 = getMaxLines();
        if (r103 == 0) goto L30;
        if (r101 >= r103) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(getText()) == true) goto L33;
        int r104 = r103 - 1;
        int r105 = r102.getLineEnd(r104);
        int r106 = r102.getLineStart(r104);
        if (r105 >= getText().length()) goto L34;
        CharSequence r107 = getText().subSequence(0, r106);
        String r108 = this.f448936c;
        float r109 = getPaint().measureText(r108);
        int r112 = r105 - 1;
        if (Intrinsics.areEqual("\n", String.valueOf(getText().charAt(r112))) == false) goto L26;
        CharSequence r113 = getText().subSequence(r106, r112);
    L27:
        CharSequence r114 = TextUtils.ellipsize(r113, getPaint(), getMeasuredWidth() - r109, TextUtils.TruncateAt.END);
        StringBuilder r115 = new StringBuilder(r107);
        r115.append(r114);
        r115.append(r108);
        setText(r115);
        this.f448937d = true;
        measure(r110, r111);
        return;
    L26:
        r113 = getText().subSequence(r106, r105);
        goto L27
    L34:
        return;
    L33:
        return;
    L30:
        return;
    L5:
        if (this.f448935b != r111) goto L7;
        r100 = true;
        goto L9
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f448937d = false;
        super.setText(r100, r101);
    }

    public TailTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f448936c = "";
    }
}
