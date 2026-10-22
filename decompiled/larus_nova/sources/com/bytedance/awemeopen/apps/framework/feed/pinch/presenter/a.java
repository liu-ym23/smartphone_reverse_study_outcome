package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class a extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<b> f195692h;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public void f() {
        Iterator<T> r100 = this.f195692h.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).f();
        goto L4
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f195692h = new ArrayList();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void b(sz3.c r100, com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r101) {
        super.b(r100, r101);
        Iterator<b> r102 = this.f195692h.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().b(r100, r101);
        goto L4
    }
}
