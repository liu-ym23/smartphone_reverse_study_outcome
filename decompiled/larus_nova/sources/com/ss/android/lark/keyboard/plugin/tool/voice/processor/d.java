package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioRecordDataProcessor f430806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.audio.voiceinput.c f430807b;

    public d(AudioRecordDataProcessor r100, com.ss.android.lark.audio.voiceinput.c r101) {
        this.f430806a = r100;
        this.f430807b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.audio.voiceinput.e r100 = this.f430806a.f430736m;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.e(this.f430807b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
