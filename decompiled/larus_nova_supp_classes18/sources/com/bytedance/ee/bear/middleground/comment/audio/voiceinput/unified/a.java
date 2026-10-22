package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.ViewParent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public ViewParent a;

    public final void a() {
        ViewParent r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        this.a = null;
        r0.requestDisallowInterceptTouchEvent(false);
    }

    public a(ViewParent r2) {
        this.a = r2;
        if (r2 == null) goto L6;
        r2.requestDisallowInterceptTouchEvent(true);
        return;
    }
}
