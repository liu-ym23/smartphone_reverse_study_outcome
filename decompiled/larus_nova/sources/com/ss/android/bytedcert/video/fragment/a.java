package com.ss.android.bytedcert.video.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoRecordFragment.e f407704a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f407704a.f407703a.f407684i.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(VideoRecordFragment.e r100) {
        this.f407704a = r100;
    }
}
