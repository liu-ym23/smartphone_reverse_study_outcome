package com.ss.android.lark.widget.light.viewstub;

import android.os.Build;
import android.text.InputFilter;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f446334a;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.light.viewstub.a$a, reason: collision with other inner class name */
    public static final class C5398a {
    }

    static {
    }

    public a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f446334a = r100;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r110, int r111) {
        if (Intrinsics.areEqual(r100, this.f446334a.getEditableText()) == false) goto L5;
        return null;
    L5:
        boolean r104 = r100 instanceof Spanned;
        if (r104 == false) goto L35;
        int r112 = 0;
        if (r104 == true) goto L10;
        boolean r105 = false;
    L15:
        if (r105 == false) goto L35;
        if (Build.VERSION.SDK_INT >= 28) goto L19;
    L21:
        Spannable r106 = new SpannableStringBuilder(r100.toString());
    L22:
        Log.d("SpanViewInputFilter", "new spannable string build");
        Spanned r107 = (Spanned) r100;
        Object[] r113 = r107.getSpans(0, r107.length(), Object.class);
        int r108 = r113.length;
    L23:
        if (r112 >= r108) goto L34;
        Object r109 = r113[r112];
        if ((r109 instanceof ViewHolderSpan) == true) goto L33;
        int r114 = r107.getSpanStart(r109);
        int r115 = r107.getSpanEnd(r109);
        int r116 = r107.getSpanFlags(r109);
        if (r114 >= r101) goto L30;
        r114 = r101;
    L30:
        if (r115 <= r102) goto L32;
        r115 = r102;
    L32:
        r106.setSpan(r109, r114 - r101, r115 - r101, r116);
    L33:
        r112 = r112 + 1;
        goto L23
    L34:
        return r106;
    L19:
        if ((r100 instanceof PrecomputedText) == false) goto L21;
        PrecomputedText r117 = (PrecomputedText) r100;
        r106 = PrecomputedText.create(r117.toString(), r117.getParams());
        Intrinsics.checkNotNull(r106);
        goto L22
    L10:
        Spanned r118 = (Spanned) r100;
        if (r118.getSpans(0, r118.length(), ViewHolderSpan.class).length != 0) goto L13;
        boolean r119 = true;
    L14:
        r105 = !r119;
        goto L15
    L13:
        r119 = false;
    L35:
        return null;
    }
}
