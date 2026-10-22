package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ r a;

    public t(r r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r6 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r5;
        r r0 = this.a;
        if (r0.k == true) goto L25;
        boolean r1 = false;
        if (r6 != null) goto L8;
    L10:
        boolean r7 = false;
    L12:
        if (r0.i == r7) goto L26;
        r0.i = r7;
        r0.c();
        this.a.a();
        StringBuilder r2 = new StringBuilder("thumbnailOverlay fullscreen hidden=");
        r2.append(r7);
        r2.append(" shown=");
        r r8 = this.a;
        if (r8.h == true) goto L17;
    L23:
        r2.append(r1);
        tt5.a.h("DriveThumbnailOverlay", r2.toString());
        return;
    L17:
        if (r8.g == null) goto L23;
        if (r8.i == true) goto L23;
        if (r8.j.isEmpty() == false) goto L23;
        r1 = true;
        goto L23
    L26:
        return;
    L8:
        if (r6.a != true) goto L10;
        r7 = true;
        goto L12
    }
}
