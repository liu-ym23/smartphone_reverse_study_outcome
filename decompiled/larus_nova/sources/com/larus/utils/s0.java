package com.larus.utils;

import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s0 {
    public static final void b(TextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r100.setVisibility(8);
        return;
    L11:
        r100.setVisibility(0);
        r100.setText(r101);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final void a(TextView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r103 = r100.getPaint().measureText(r100.getText().toString());
        float r104 = r102;
        if (r103 <= r104) goto L14;
        Paint r105 = new Paint();
    L6:
        if (r103 <= r104) goto L9;
        if (r101 <= 0) goto L9;
        r101 = r101 - 1;
        r105.setTextSize(r101);
        r103 = r105.measureText(r100.getText().toString());
    L9:
        if (r101 <= 0) goto L15;
        r100.setTextSize(0, r101);
        return;
    L15:
        return;
    }

    public static final SpannableString c(SpannableString r100, int r101, int r110, float r111) {
        SpannableString r102 = new SpannableString(r100);
        Object[] r103 = r102.getSpans(r101, r110, AbsoluteSizeSpan.class);
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        AbsoluteSizeSpan r106 = (AbsoluteSizeSpan) r103[r105];
        int r107 = r102.getSpanStart(r106);
        int r108 = r102.getSpanEnd(r106);
        int r109 = r102.getSpanFlags(r106);
        r102.removeSpan(r106);
        if (r107 >= r101) goto L7;
        r102.setSpan(r106, r107, r101, r109);
    L7:
        if (r108 <= r110) goto L9;
        r102.setSpan(new AbsoluteSizeSpan(r106.getSize(), r106.getDip()), r110, r108, r109);
    L9:
        r105 = r105 + 1;
        goto L3
    L10:
        r102.setSpan(new AbsoluteSizeSpan((int) r111), r101, r110, 33);
        return r102;
    }
}
