package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a extends b {
    public final ArrayList<b> h;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public void f() {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).f();
        goto L4
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.h = new ArrayList();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void b(sz3.c r3, com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r4) {
        super.b(r3, r4);
        Iterator<b> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r3, r4);
        goto L4
    }
}
