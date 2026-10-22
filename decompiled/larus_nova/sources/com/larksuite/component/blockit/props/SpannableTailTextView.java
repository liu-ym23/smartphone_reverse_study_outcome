package com.larksuite.component.blockit.props;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u001c\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larksuite/component/blockit/props/SpannableTailTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidthMeasureSpec", "mHeightMeasureSpec", "mTailContent", "", "mEllipsizeFinal", "", "getMEllipsizeFinal", "()Z", "setMEllipsizeFinal", "(Z)V", "setTailContent", "", "tailContent", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "doMeasure", "Companion", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SpannableTailTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f283106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f283107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f283108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f283109d;

    public static final class a {
    }

    static {
    }

    public final boolean getMEllipsizeFinal() {
        return this.f283109d;
    }

    public SpannableTailTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f283108c = "…";
    }

    public final void setMEllipsizeFinal(boolean r100) {
        this.f283109d = r100;
    }

    public final void setTailContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tailContent");
        this.f283108c = r100;
        this.f283109d = false;
    }

    public SpannableTailTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f283108c = "…";
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f283106a == r100) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (this.f283109d == false) goto L12;
        if (r102 == false) goto L12;
        return;
    L12:
        this.f283106a = r100;
        this.f283107b = r101;
        int r103 = getLineCount();
        Layout r104 = getLayout();
        int r105 = getMaxLines();
        if (r105 == 0) goto L23;
        if (r103 >= r105) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(getText()) == true) goto L26;
        int r106 = r104.getLineEnd(r105 - 1);
        if (r106 >= getText().length()) goto L27;
        setText(new SpannableStringBuilder(getText().subSequence(0, r106 - 1)).append(this.f283108c));
        this.f283109d = true;
        measure(r100, r101);
        return;
    L27:
        return;
    L26:
        return;
    L23:
        return;
    L5:
        if (this.f283107b != r101) goto L7;
        r102 = true;
        goto L9
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f283109d = false;
        super.setText(r100, r101);
    }

    public SpannableTailTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f283108c = "…";
    }
}
