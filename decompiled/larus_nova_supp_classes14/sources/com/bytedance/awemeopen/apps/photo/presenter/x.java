package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements com.bytedance.awemeopen.apps.framework.utils.g.a {
    public final /* synthetic */ GuesturePresenter a;

    public x(GuesturePresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.g.a
    public final void onTouch(MotionEvent r2) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        if (r2 == null) goto L7;
        boolean r0 = true;
        if (r2.getAction() != 1) goto L7;
    L8:
        if (r0 == false) goto L11;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        return;
    L11:
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.g.a
    public final void a(MotionEvent r2, MotionEvent r3, MotionEvent r4) {
        Function3<? super MotionEvent, ? super MotionEvent, ? super MotionEvent, Boolean> r0 = this.a.n.a;
        if (r0 == null) goto L6;
        Boolean r5 = (Boolean) r0.invoke(r2, r3, r4);
        return;
    }
}
