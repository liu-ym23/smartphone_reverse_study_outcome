package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.ViewParent;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f230629a;

    public final void a() {
        ViewParent r100 = this.f230629a;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f230629a = null;
        r100.requestDisallowInterceptTouchEvent(false);
    }

    public a(ViewParent r100) {
        this.f230629a = r100;
        if (r100 == null) goto L6;
        r100.requestDisallowInterceptTouchEvent(true);
        return;
    }
}
