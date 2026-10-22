package com.larus.bmhome.taskskill.view;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f314652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f314653b;

    public /* synthetic */ t(v r100, FrameLayout r101) {
        this.f314652a = r100;
        this.f314653b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f314652a.b(this.f314653b, 0);
    }
}
