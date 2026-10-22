package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class PreviewTextView extends CommentTextView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView
    public final void setRawString(String r7) {
        CharSequence r2 = "";
        if (r7 == null) goto L12;
        int r3 = yu5.b.a;
        CharSequence r8 = StringsKt.trim(r7, new char[]{'\n'});
        if (r8 == null) goto L12;
        String r9 = r8.toString();
        if (r9 == null) goto L12;
        r2 = r9;
    L12:
        if (getParser() == null) goto L14;
        r2 = getParser().a(r2);
    L14:
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        r10.append("  ");
        r10.append(r2);
        Drawable r4 = getContext().getDrawable(2131255092).mutate();
        r4.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), 2131106607), PorterDuff.Mode.SRC_IN));
        r4.setBounds(0, 0, com.bytedance.ee.util.ui.n.d(13), com.bytedance.ee.util.ui.n.d(13));
        r10.setSpan(new n0(r4), 0, 1, 33);
        setText(r10);
    }

    public PreviewTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public PreviewTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
