package com.bytedance.ee.bear.doc.follow.impl;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r implements py4.d {
    public final List<py4.d> a;
    public py4.d b;
    public final Set<String> c;

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
    public final void setPresenter(boolean r1) {
    }

    public r() {
        this.a = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArraySet();
    }

    @Override // py4.d
    public final void setAudioMute(boolean r3) {
        py4.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.setAudioMute(r3);
    L5:
        Iterator r1 = ((CopyOnWriteArrayList) this.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((py4.d) r1.next()).setAudioMute(r3);
        goto L7
    }

    @Override // py4.b
    public final void onCallVCFollow(String r2, NonProguard r3) {
        py4.d r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.d("CCMFollow_FollowApiV2Delegate", "onCallVCFollow fail with impl is null");
        return;
    L6:
        r0.getFollowBridge().onCallVCFollow(r2, r3);
    }

    public final NonProguard k(py4.d r3, RNFollowEvent r4, NonProguard r5) {
        ry4.a r0 = r3.getFollowBridge().d(r4);
        py4.k<? extends NonProguard> r1 = r3.getFollowBridge().h(r4);
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        if (r5 != null) goto L7;
        r5 = r1.a(this.c, r4);
    L7:
        r1.b(r5);
    L9:
        return r5;
    L8:
        r3.getFollowBridge().onEvent(r4);
        goto L9
    }

    @Override // py4.b
    public final void onCallVCFollow(String r2, NonProguard r3, ry4.a r4) {
        py4.d r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.d("CCMFollow_FollowApiV2Delegate", "onCallVCFollow fail with impl is null");
        return;
    L6:
        r0.getFollowBridge().onCallVCFollow(r2, r3, r4);
    }
}
