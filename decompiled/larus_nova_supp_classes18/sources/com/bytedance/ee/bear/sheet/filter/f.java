package com.bytedance.ee.bear.sheet.filter;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements TextView.OnEditorActionListener {
    public final /* synthetic */ FilterConditionAdapter a;

    public f(FilterConditionAdapter r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 6) goto L9;
        FilterConditionAdapter.b r4 = this.a.d;
        if (r4 == null) goto L10;
        r4.c60();
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
