package com.ss.android.lark.widget.codeblock.entity;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Span;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String b() {
        return UIHelper.getString(R.string.Lark_IM_CodeBlockQuote_Text);
    }

    @JvmStatic
    public static final String a(List<LineContent> r100) {
        List<LineContent> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        StringBuilder r103 = new StringBuilder();
        Iterator<T> r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L23;
        List<LineContent.Content> r105 = ((LineContent) r104.next()).getContents();
        if (r105 == null) goto L21;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        r103.append(((LineContent.Content) r106.next()).getDisplayText());
    L21:
        r103.append("\n");
        goto L14
    L23:
        return r103.toString();
    L11:
        return b();
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @JvmStatic
    public static final CharSequence c(CharSequence r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L29:
        if (r100 != null) goto L33;
        return "";
    L33:
        return r100;
    L11:
        if ((r100 instanceof Spanned) == false) goto L29;
        Spanned r103 = (Spanned) r100;
        CodeBlockV2Span[] r104 = (CodeBlockV2Span[]) r103.getSpans(0, r103.length(), CodeBlockV2Span.class);
        if (r104 != null) goto L16;
    L22:
        if (r101 == false) goto L24;
        return r100;
    L24:
        SpannableStringBuilder r105 = new SpannableStringBuilder(r100);
        Iterator r106 = ArrayIteratorKt.iterator(r104);
    L26:
        if (r106.hasNext() == false) goto L28;
        CodeBlockV2Span r107 = (CodeBlockV2Span) r106.next();
        r105.replace(r105.getSpanStart(r107), r105.getSpanEnd(r107), (String) r107.f445689i.getValue());
        goto L26
    L28:
        return r105;
    L16:
        if (r104.length != 0) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == true) goto L22;
        r101 = false;
        goto L22
    L18:
        r108 = false;
        goto L19
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
