package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo;

import android.os.CountDownTimer;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends CountDownTimer {
    public final /* synthetic */ PhotoFeedPagerPresenter.d a;
    public final /* synthetic */ PhotoFeedPagerPresenter b;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        PhotoFeedPagerPresenter r0 = this.b;
        if (r0.J == true) goto L8;
        r0.J = true;
        AosEventReporter r1 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3 = r0.e;
        jz3.a r2 = r0.s;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mData");
        r2 = null;
    L7:
        r1.getClass();
        AosEventReporter.S(r3, r2);
    L8:
        this.b.h.c++;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r2) {
        this.a.a = r2;
    }

    public j(PhotoFeedPagerPresenter.d r1, PhotoFeedPagerPresenter r2, long r3) {
        this.a = r1;
        this.b = r2;
        super(r3, 100);
    }
}
