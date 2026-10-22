package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
class PreviewTextView extends CommentTextView {
    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView
    public final void setRawString(String r100) {
        CharSequence r101 = "";
        if (r100 == null) goto L12;
        int r102 = yu5.b.f569227a;
        CharSequence r103 = StringsKt.trim(r100, new char[]{'\n'});
        if (r103 == null) goto L12;
        CharSequence r104 = r103.toString();
        if (r104 == null) goto L12;
        r101 = r104;
    L12:
        if (getParser() == null) goto L14;
        r101 = getParser().a(r101);
    L14:
        SpannableStringBuilder r105 = new SpannableStringBuilder();
        r105.append(tb2.c.DEFAULT_TEXT);
        r105.append(r101);
        Drawable r106 = getContext().getDrawable(R.drawable.ud_icon_meeting_ai_outlined).mutate();
        r106.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.text_caption), PorterDuff.Mode.SRC_IN));
        r106.setBounds(0, 0, com.bytedance.ee.util.ui.n.d(13), com.bytedance.ee.util.ui.n.d(13));
        r105.setSpan(new n0(r106), 0, 1, 33);
        setText(r105);
    }

    public PreviewTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public PreviewTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
