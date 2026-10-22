package com.ss.android.lark.widget.richtext;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichTextView f448325a;

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f448325a.f448225k.a();
        return true;
    }

    public l(RichTextView r100, String r101, TextView r102) {
        this.f448325a = r100;
    }
}
