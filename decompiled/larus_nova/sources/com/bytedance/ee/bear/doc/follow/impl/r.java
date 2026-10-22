package com.bytedance.ee.bear.doc.follow.impl;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes16.dex */
public final class r implements py4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<py4.d> f217954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public py4.d f217955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f217956c;

    @Override // py4.d
    public final py4.j getFollowBridge() {
        return null;
    }

    @Override // py4.d
    public final boolean isAudioMuted() {
        return false;
    }

    @Override // py4.d
    public final boolean isPresenter() {
        return false;
    }

    @Override // py4.d
    public final void setPresenter(boolean r100) {
    }

    public r() {
        this.f217954a = new CopyOnWriteArrayList();
        this.f217956c = new CopyOnWriteArraySet();
    }

    @Override // py4.d
    public final void setAudioMute(boolean r100) {
        py4.d r101 = this.f217955b;
        if (r101 == null) goto L5;
        r101.setAudioMute(r100);
    L5:
        Iterator r102 = ((CopyOnWriteArrayList) this.f217954a).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((py4.d) r102.next()).setAudioMute(r100);
        goto L7
    }

    @Override // py4.b
    public final void onCallVCFollow(String r100, NonProguard r101) {
        py4.d r102 = this.f217955b;
        if (r102 != null) goto L6;
        tt5.a.d("CCMFollow_FollowApiV2Delegate", "onCallVCFollow fail with impl is null");
        return;
    L6:
        r102.getFollowBridge().onCallVCFollow(r100, r101);
    }

    public final NonProguard k(py4.d r100, RNFollowEvent r101, NonProguard r102) {
        ry4.a r103 = r100.getFollowBridge().d(r101);
        py4.k<? extends NonProguard> r104 = r100.getFollowBridge().h(r101);
        if (r103 == null) goto L8;
        if (r104 == null) goto L8;
        if (r102 != null) goto L7;
        r102 = r104.a(this.f217956c, r101);
    L7:
        r104.b(r102);
    L9:
        return r102;
    L8:
        r100.getFollowBridge().onEvent(r101);
        goto L9
    }

    @Override // py4.b
    public final void onCallVCFollow(String r100, NonProguard r101, ry4.a r102) {
        py4.d r103 = this.f217955b;
        if (r103 != null) goto L6;
        tt5.a.d("CCMFollow_FollowApiV2Delegate", "onCallVCFollow fail with impl is null");
        return;
    L6:
        r103.getFollowBridge().onCallVCFollow(r100, r101, r102);
    }
}
