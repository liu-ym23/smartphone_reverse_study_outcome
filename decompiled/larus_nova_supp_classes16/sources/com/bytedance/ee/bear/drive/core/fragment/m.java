package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r4 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r3;
        if (r4 == null) goto L7;
        boolean r0 = true;
        if (r4.a != true) goto L7;
    L8:
        k r5 = this.a;
        if (r5.q == r0) goto L13;
        r5.q = r0;
        r5.c();
        k.a(this.a);
        this.a.j();
        this.a.f.invoke(Boolean.valueOf(r0));
        tt5.a.h("DriveSdk", "observeOverlayTemporaryState hidden=" + r0);
        return;
    L13:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
