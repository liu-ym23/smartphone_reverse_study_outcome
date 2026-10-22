package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.p;
import nz3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements f {
    public final /* synthetic */ PhotoFeedViewHolder a;

    @Override // nz3.f
    public final void a() {
    }

    @Override // nz3.f
    public final void g() {
    }

    @Override // nz3.f
    public final void h() {
    }

    public c(PhotoFeedViewHolder r1) {
        this.a = r1;
    }

    @Override // nz3.f
    public final void b(int r2) {
        MutableLiveData<Integer> r0 = this.a.e.c.getSlidesPlayCompletedPosition();
        if (r0 == null) goto L7;
        r0.setValue(Integer.valueOf(r2));
        return;
    }

    @Override // nz3.f
    public final void c(int r9, float r10, boolean r11) {
        MutableLiveData<Integer> r0 = this.a.e.c.getSlidesProgressPosition();
        if (r0 == null) goto L6;
        r0.setValue(Integer.valueOf(r9));
    L6:
        MutableLiveData<p> r1 = this.a.e.c.getSlidesProgressInfo();
        if (r1 == null) goto L11;
        r1.setValue(new p(r9, r10, this.a.h.b.getPhotoPlayDuration(), r11));
        return;
    }
}
