package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public final View a;
    public View b;
    public boolean c;
    public final int d;

    public j(View r2) {
        Intrinsics.checkNotNullParameter(r2, "indicator");
        this.a = r2;
        this.d = (int) r2.getResources().getDimension(2131166574);
    }

    public final void a(View r5) {
        this.b = r5;
        boolean r0 = true;
        if (r5 == null) goto L17;
        if (r5.getWidth() != 0) goto L12;
        if (this.c == true) goto L17;
        ViewTreeObserver r6 = r5.getViewTreeObserver();
        if (r6 == null) goto L17;
        r6.addOnGlobalLayoutListener(new i(this));
        this.c = true;
        goto L17
    L12:
        if (this.a.getWidth() <= 0) goto L14;
        int r1 = this.a.getWidth();
    L15:
        this.a.setX((r5.getX() + (r5.getWidth() / 2)) - (r1 / 2));
        goto L17
    L14:
        r1 = this.d;
    L17:
        if (this.a.getAlpha() == 1.0f) goto L20;
        r0 = false;
    L20:
        if (r0 == true) goto L23;
        this.a.animate().alpha(1.0f).start();
        return;
    }
}
