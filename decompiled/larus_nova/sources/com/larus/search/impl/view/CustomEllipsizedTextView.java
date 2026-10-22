package com.larus.search.impl.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/search/impl/view/CustomEllipsizedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipsis", "", "getEllipsis", "()Ljava/lang/String;", "setEllipsis", "(Ljava/lang/String;)V", "ellipsisColor", "getEllipsisColor", "()I", "setEllipsisColor", "(I)V", "ellipsisSpannable", "Landroid/text/SpannableString;", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "getDefaultEllipsis", "", "getDefaultEllipsisColor", "resetEllipsize", "", "onPreDraw", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomEllipsizedTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f367819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f367820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SpannableString f367821c;

    public static final class a {
    }

    static {
    }

    public CustomEllipsizedTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomEllipsizedTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final char getDefaultEllipsis() {
        return 8230;
    }

    private final int getDefaultEllipsisColor() {
        int r100 = j0.f375426a;
        return j0.a(R.color.larus_primary_50);
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (getLayout() == null) goto L25;
        if (getLayout().getText() == null) goto L25;
        if (getText() == null) goto L25;
        if (Intrinsics.areEqual(getLayout().getText(), getText()) == true) goto L12;
        FLogger r100 = FLogger.f375446a;
        r100.i("CustomEllipsizedTextVie", "onPreDraw:layout.text: " + getLayout().getText());
        int r101 = getLayout().getEllipsisStart(0);
        if (r101 <= 0) goto L17;
        r100.w("CustomEllipsizedTextVie", "onPreDraw:ellipsisIndex: " + r101);
    L20:
        if (r101 <= 0) goto L23;
        r100.e("CustomEllipsizedTextVie", "onPreDraw:Span.Replace");
        setText(new SpannableStringBuilder(getLayout().getText()).replace(r101, r101 + 1, this.f367821c));
        getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L23:
        return super.onPreDraw();
    L17:
        if (StringsKt.last(getLayout().getText()) != getDefaultEllipsis()) goto L19;
        r101 = getLayout().getText().length() - 1;
        r100.w("CustomEllipsizedTextVie", "onPreDraw:layout.last: " + r101);
        goto L20
    L19:
        r101 = -1;
        goto L20
    L12:
        return super.onPreDraw();
    L25:
        return super.onPreDraw();
    }

    public final String getEllipsis() {
        return this.f367819a;
    }

    public final int getEllipsisColor() {
        return this.f367820b;
    }

    public final void setEllipsis(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f367819a = r100;
    }

    public final void setEllipsisColor(int r100) {
        this.f367820b = r100;
    }

    public CustomEllipsizedTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f367819a = String.valueOf(getDefaultEllipsis());
        this.f367820b = getDefaultEllipsisColor();
        SpannableString r103 = new SpannableString(this.f367819a);
        this.f367821c = r103;
        new SpannableStringBuilder();
        r103.setSpan(new ForegroundColorSpan(this.f367820b), 0, this.f367819a.length(), 33);
    }

    public /* synthetic */ CustomEllipsizedTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
