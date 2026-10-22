package com.bytedance.ee.bear.sheet.filter;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterConditionAdapter f237848a;

    public f(FilterConditionAdapter r100) {
        this.f237848a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L9;
        FilterConditionAdapter.b r103 = this.f237848a.f237674d;
        if (r103 == null) goto L10;
        r103.c60();
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
