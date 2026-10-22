package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;

/* JADX INFO: loaded from: classes41.dex */
public abstract class q {
    public static a[] a(TextView r100) {
        CharSequence r101 = r100.getText();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return null;
    L5:
        if ((r101 instanceof Spanned) == false) goto L7;
        return (a[]) ((Spanned) r101).getSpans(0, r101.length(), a.class);
    }
}
