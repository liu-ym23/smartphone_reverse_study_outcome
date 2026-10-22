package com.ss.android.lark.contact.base.contact_search;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418814a;

    public n(s r100) {
        this.f418814a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L6;
        this.f418814a.f418832y.performClick();
        return true;
    L6:
        return false;
    }
}
