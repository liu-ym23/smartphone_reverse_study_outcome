package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z extends f04.a<Unit> {
    public final a14.a d;
    public final qz3.d e;
    public final qz3.c f;
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m g;

    @Override // f04.a
    public final void k() {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r0 = this.g;
        if (r0 == null) goto L5;
        r0.r = false;
    L5:
        if (r0 == null) goto L8;
        r0.u();
        return;
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        a14.a r4 = this.d;
        sz3.c r0 = new sz3.c();
        r0.f = r4.a;
        r0.h = this.f;
        r0.i = this.e;
        r0.j = new HorizonPinchPresenter$bindPinch$pinchParams$1$1(this);
        r0.o = Boolean.TRUE;
        r0.a = r4.getActivity();
        r0.e = r4.c.sceneId();
        r0.b = r4.d;
        r0.n = Boolean.FALSE;
        r0.k = (ViewGroup) this.d.getActivity().findViewById(2131382295);
        if (this.g != null) goto L8;
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r5 = new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m();
        String r1 = this.d.c.sceneId();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r5.C = r1;
        this.g = r5;
    L8:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r6 = this.g;
        if (r6 == null) goto L11;
        r6.n(r0);
    L11:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r7 = this.g;
        if (r7 == null) goto L15;
        r7.k = true;
    L15:
        if (r7 == null) goto L18;
        r7.r = true;
        return;
    }

    public z(a14.a r2, qz3.d r3, qz3.c r4) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
