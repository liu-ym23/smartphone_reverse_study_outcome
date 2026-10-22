package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.p;
import nz3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoFeedViewHolder f195138a;

    @Override // nz3.f
    public final void a() {
    }

    @Override // nz3.f
    public final void g() {
    }

    @Override // nz3.f
    public final void h() {
    }

    public c(PhotoFeedViewHolder r100) {
        this.f195138a = r100;
    }

    @Override // nz3.f
    public final void b(int r100) {
        MutableLiveData<Integer> r101 = this.f195138a.f195108e.f195163c.getSlidesPlayCompletedPosition();
        if (r101 == null) goto L7;
        r101.setValue(Integer.valueOf(r100));
        return;
    }

    @Override // nz3.f
    public final void c(int r100, float r110, boolean r111) {
        MutableLiveData<Integer> r101 = this.f195138a.f195108e.f195163c.getSlidesProgressPosition();
        if (r101 == null) goto L6;
        r101.setValue(Integer.valueOf(r100));
    L6:
        MutableLiveData<p> r102 = this.f195138a.f195108e.f195163c.getSlidesProgressInfo();
        if (r102 == null) goto L11;
        r102.setValue(new p(r100, r110, this.f195138a.f195111h.f511362b.getPhotoPlayDuration(), r111));
        return;
    }
}
