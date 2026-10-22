package com.larus.common_ui.widget;

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
import android.text.style.StyleSpan;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\"#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/common_ui/widget/UrlSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "mOnClickListener", "Lcom/larus/common_ui/widget/UrlSpanTextView$OnClickListener;", "linkColor", "Landroid/content/res/ColorStateList;", "linkUnderLine", "", "linkText", "", "linkFakeBold", "setLinkFakeBold", "", "enabled", "setUrlText", "text", "setUrlTextColor", "setUrlSpannedText", "spannedText", "", "wrapText", "charSequence", "setOnClickListener", "listener", "OnClickListener", "UrlClickSpan", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlSpanTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttributeSet f328547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f328548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f328549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f328550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f328551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f328552f;

    public interface a {
        void a(String r100);
    }

    public final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f328553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f328554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UrlSpanTextView f328555c;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            a r101 = this.f328555c.f328548b;
            if (r101 == null) goto L6;
            r101.a(this.f328553a);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(this.f328554b);
            r100.setColor(r100.linkColor);
            r100.setFakeBoldText(this.f328555c.f328552f);
        }

        public b(UrlSpanTextView r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f328555c = r100;
            this.f328553a = r101;
            this.f328554b = r102;
        }
    }

    public UrlSpanTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UrlSpanTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.f328547a;
    }

    public final void setLinkFakeBold(boolean r100) {
        this.f328552f = r100;
        setText(x(this.f328551e));
    }

    public final void setOnClickListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f328548b = r100;
    }

    public final void setUrlSpannedText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spannedText");
        Spanned r101 = HtmlCompat.fromHtml(StringsKt.replace$default(r100, "\n", "<br/>", false, 4, null), 0);
        if ((r101 instanceof SpannableStringBuilder) == false) goto L5;
        SpannableStringBuilder r102 = (SpannableStringBuilder) r101;
    L6:
        SpannedString r103 = SpannedString.valueOf(r102);
        Intrinsics.checkNotNull(r103);
        this.f328551e = r103;
        setText(x(r103));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setUrlText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f328551e = r100;
        setText(x(r100));
    }

    public final void setUrlTextColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "linkColor");
        this.f328549c = r100;
        setLinkTextColor(r100);
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
        b r105 = new b(this, r102.getURL(), this.f328550d);
        StyleSpan r106 = new StyleSpan(1);
        r100.setSpan(r105, r103, r104, 33);
        r100.setSpan(r106, r103, r104, 33);
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

    public UrlSpanTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328547a = r101;
        this.f328550d = true;
        CharSequence r103 = "";
        this.f328551e = "";
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_linkColor, R.attr.larus_linkFakeBold, R.attr.larus_linkText, R.attr.larus_linkUnderLine});
        this.f328549c = r104.getColorStateList(0);     // Catch: Throwable -> L13
        this.f328550d = r104.getBoolean(3, true);     // Catch: Throwable -> L13
        CharSequence r105 = r104.getText(2);     // Catch: Throwable -> L13
        if (r105 == null) goto L7;
        r103 = r105;
    L7:
        this.f328551e = r103;     // Catch: Throwable -> L13
        this.f328552f = r104.getBoolean(1, false);     // Catch: Throwable -> L13
        ColorStateList r106 = this.f328549c;     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        setLinkTextColor(r106);     // Catch: Throwable -> L13
    L10:
        setUrlText(this.f328551e);     // Catch: Throwable -> L13
        r104.recycle();
        return;
    L13:
        th = move-exception;
        r104.recycle();
        throw th;
    }

    public /* synthetic */ UrlSpanTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
