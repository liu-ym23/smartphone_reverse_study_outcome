package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements com.bytedance.awemeopen.apps.framework.utils.g.a {
    public final /* synthetic */ VideoFeedGesturePresenter a;

    public n(VideoFeedGesturePresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.g.a
    public final void onTouch(MotionEvent r5) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L12:
        if (r5 != null) goto L14;
    L16:
        r0 = false;
    L17:
        if (r0 == false) goto L20;
        this.a.q = false;
        return;
    L20:
        return;
    L14:
        if (r5.getAction() != 0) goto L16;
    L10:
        if (Intrinsics.areEqual(this.a.e.c.getEnterPinchMode().getValue(), Boolean.TRUE) == true) goto L12;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        goto L12
    L5:
        if (r5.getAction() != 1) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.g.a
    public final void a(MotionEvent r3, MotionEvent r4, MotionEvent r5) {
        if (Intrinsics.areEqual(this.a.e.c.getEnterPinchMode().getValue(), Boolean.TRUE) == true) goto L8;
        Function3<? super MotionEvent, ? super MotionEvent, ? super MotionEvent, Boolean> r0 = this.a.g.c;
        if (r0 == null) goto L9;
        Boolean r6 = (Boolean) r0.invoke(r3, r4, r5);
        return;
    L9:
        return;
    }
}
