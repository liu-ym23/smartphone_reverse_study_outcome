package com.ss.android.lark.widget.richtext;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements View.OnGenericMotionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichTextView f448339a;

    @Override // android.view.View.OnGenericMotionListener
    public final boolean onGenericMotion(View r100, MotionEvent r101) {
        if (r101.getButtonState() != 2) goto L8;
        RichTextView r102 = this.f448339a;
        Boolean r103 = RichTextView.f448210x1;
        r102.getClass();
        return false;
    L8:
        return false;
    }

    public p(RichTextView r100, Image r101, ImageView r102) {
        this.f448339a = r100;
    }
}
