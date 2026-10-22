package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmSubtitleAdapter f436501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f436502b;

    public f(MmSubtitleAdapter r100, long r101) {
        this.f436501a = r100;
        this.f436502b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Long r100 = this.f436501a.f436406l;     // Catch: Throwable -> L10
        long r101 = this.f436502b;     // Catch: Throwable -> L10
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.longValue() != r101) goto L17;
        MmSubtitleAdapter r102 = this.f436501a;     // Catch: Throwable -> L10
        r102.f436406l = null;     // Catch: Throwable -> L10
        r102.z2(Long.valueOf(this.f436502b));     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
