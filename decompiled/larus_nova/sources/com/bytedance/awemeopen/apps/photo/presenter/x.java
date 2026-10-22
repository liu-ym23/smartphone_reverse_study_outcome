package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes14.dex */
public final class x implements com.bytedance.awemeopen.apps.framework.utils.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuesturePresenter f198029a;

    public x(GuesturePresenter r100) {
        this.f198029a = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.g.a
    public final void onTouch(MotionEvent r100) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.getAction() != 1) goto L7;
    L8:
        if (r101 == false) goto L11;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        return;
    L11:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.g.a
    public final void a(MotionEvent r100, MotionEvent r101, MotionEvent r102) {
        Function3<? super MotionEvent, ? super MotionEvent, ? super MotionEvent, Boolean> r103 = this.f198029a.f197859n.f1372a;
        if (r103 == null) goto L6;
        Boolean r104 = r103.invoke(r100, r101, r102);
        return;
    }
}
