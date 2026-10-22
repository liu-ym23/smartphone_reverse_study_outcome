package com.larus.dora.impl.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.HtmlCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/view/DoraUrlSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "mOnClickListener", "Lcom/larus/dora/impl/view/DoraUrlSpanTextView$OnClickListener;", "linkColor", "Landroid/content/res/ColorStateList;", "linkUnderLine", "", "linkText", "", "setUrlText", "", "text", "setUrlSpannedText", "spannedText", "", "wrapText", "charSequence", "setOnClickListener", "listener", "OnClickListener", "UrlClickSpan", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraUrlSpanTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f338229d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttributeSet f338230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f338231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f338232c;

    public interface a {
    }

    public final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f338233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraUrlSpanTextView f338234b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            DoraUrlSpanTextView r101 = this.f338234b;
            int r102 = DoraUrlSpanTextView.f338229d;
            r101.getClass();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(this.f338233a);
            r100.setColor(r100.linkColor);
        }

        public b(DoraUrlSpanTextView r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f338234b = r100;
            this.f338233a = r102;
        }
    }

    public DoraUrlSpanTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraUrlSpanTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnClickListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final AttributeSet getAttrs() {
        return this.f338230a;
    }

    public final void setUrlSpannedText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spannedText");
        Spanned r101 = HtmlCompat.fromHtml(StringsKt.replace$default(r100, "\n", "<br/>", false, 4, null), 0);
        if ((r101 instanceof SpannableStringBuilder) == false) goto L5;
        SpannableStringBuilder r102 = (SpannableStringBuilder) r101;
    L6:
        SpannedString r103 = SpannedString.valueOf(r102);
        Intrinsics.checkNotNull(r103);
        this.f338232c = r103;
        setText(x(r103));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setUrlText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f338232c = r100;
        setText(x(r100));
    }

    public final CharSequence x(CharSequence r110) {
        if ((r110 instanceof SpannedString) == false) goto L10;
        SpannableString r100 = SpannableString.valueOf(r110);
        SpannedString r111 = (SpannedString) r110;
        Iterator r101 = ArrayIteratorKt.iterator((URLSpan[]) r111.getSpans(0, r100.length() - 1, URLSpan.class));
    L6:
        if (r101.hasNext() == false) goto L8;
        URLSpan r102 = (URLSpan) r101.next();
        int r103 = r111.getSpanStart(r102);
        int r104 = r111.getSpanEnd(r102);
        r100.removeSpan(r102);
        r100.setSpan(new b(this, r102.getURL(), this.f338231b), r103, r104, 33);
        goto L6
    L8:
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
        setAutoLinkMask(1);
        Intrinsics.checkNotNull(r100);
        return r100;
    L10:
        return r110;
    }

    public DoraUrlSpanTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f338230a = r101;
        this.f338231b = true;
        CharSequence r103 = "";
        this.f338232c = "";
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_linkColor, R.attr.larus_linkFakeBold, R.attr.larus_linkText, R.attr.larus_linkUnderLine});
        ColorStateList r105 = r104.getColorStateList(0);     // Catch: Throwable -> L13
        this.f338231b = r104.getBoolean(3, true);     // Catch: Throwable -> L13
        CharSequence r106 = r104.getText(2);     // Catch: Throwable -> L13
        if (r106 == null) goto L7;
        r103 = r106;
    L7:
        this.f338232c = r103;     // Catch: Throwable -> L13
        if (r105 == null) goto L10;
        setLinkTextColor(r105);     // Catch: Throwable -> L13
    L10:
        setUrlText(this.f338232c);     // Catch: Throwable -> L13
        r104.recycle();
        return;
    L13:
        th = move-exception;
        r104.recycle();
        throw th;
    }

    public /* synthetic */ DoraUrlSpanTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
