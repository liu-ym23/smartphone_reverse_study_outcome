package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/QuoteEllipsizeTextView;", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originalText", "", "hasQuote", "", "lastMaxWidth", "lastSource", "lastEllipsized", "setText", "", "text", "type", "Landroid/widget/TextView$BufferType;", "sb", "Landroid/text/SpannableStringBuilder;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuoteEllipsizeTextView extends ShimmerTextView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f304855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f304856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f304857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f304858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f304859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SpannableStringBuilder f304860n;

    public static final class a {
    }

    static {
    }

    public QuoteEllipsizeTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public QuoteEllipsizeTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f304856j == true) goto L5;
    L30:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (getMaxLines() != 1) goto L30;
        View.MeasureSpec.getMode(r100);
        int r102 = View.MeasureSpec.getSize(r100);
        CharSequence r103 = this.f304855i;
        if (r103 == null) goto L28;
        if (r102 <= 0) goto L28;
        if (r102 == this.f304857k) goto L13;
    L14:
        this.f304857k = r102;
        this.f304858l = r103;
        float r104 = (((r102 - getPaddingLeft()) - getPaddingRight()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        float r105 = getPaint().measureText(r103.toString());
        CharSequence r106 = r103;
        if (r105 <= r104) goto L22;
        CharSequence r107 = TextUtils.ellipsize(r103, getPaint(), r104 - getPaint().measureText("”"), TextUtils.TruncateAt.END);
        SpannableStringBuilder r108 = this.f304860n;
        r108.clear();
        r108.append(r107);
        Intrinsics.checkNotNull(r107);
        r106 = r108;
        if (StringsKt.contains$default(r107, "“", false, 2, null) == false) goto L22;
        r106 = r108;
        if (StringsKt.contains$default(r107, "”", false, 2, null) == true) goto L22;
        r108.append("”");
        r106 = r108;
    L22:
        this.f304859m = r106;
    L23:
        CharSequence r109 = this.f304859m;
        if (r109 == null) goto L28;
        if (Intrinsics.areEqual(String.valueOf(r109), getText().toString()) == true) goto L28;
        super.setText(this.f304859m, TextView.BufferType.SPANNABLE);
        goto L28
    L13:
        if (Intrinsics.areEqual(r103, this.f304858l) == true) goto L23;
    L28:
        super.onMeasure(r100, r101);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f304855i = r100;
        boolean r102 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L16;
        if (r100 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L16;
    L17:
        this.f304856j = r102;
        super.setText(r100, r101);
        return;
    L11:
        if (StringsKt.contains$default(r100, "“", false, 2, null) != true) goto L13;
        r104 = true;
    L16:
        r102 = false;
        goto L17
    L5:
        if (StringsKt.contains$default(r100, "”", false, 2, null) != true) goto L7;
        r103 = true;
        goto L8
    }

    public QuoteEllipsizeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304860n = new SpannableStringBuilder();
    }

    public /* synthetic */ QuoteEllipsizeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
