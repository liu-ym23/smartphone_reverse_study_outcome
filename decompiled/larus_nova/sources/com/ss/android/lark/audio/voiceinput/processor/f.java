package com.ss.android.lark.audio.voiceinput.processor;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f409354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UploadProcessor f409355b;

    public f(boolean r100, UploadProcessor r101) {
        this.f409354a = r100;
        this.f409355b = r101;
    }

    public final void a() {
        if (this.f409354a == false) goto L5;
        this.f409355b.f409337a.getClass();
        Log.i("VoiceInputService", "[UploadProcessor]onUpload session ended " + this.f409355b.hashCode());
        return;
    L5:
        this.f409355b.f409337a.getClass();
        Log.i("VoiceInputService", "[UploadProcessor]onUpload session begin " + this.f409355b.hashCode());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
