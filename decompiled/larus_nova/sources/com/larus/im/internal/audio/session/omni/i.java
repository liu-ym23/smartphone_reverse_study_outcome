package com.larus.im.internal.audio.session.omni;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.im.internal.jni.media.OmniAudioEngineDelegate;
import java.util.Iterator;

/* JADX INFO: loaded from: classes29.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidOmniAudioEngine f347302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f347303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f347304c;

    public i(AndroidOmniAudioEngine r100, long r101, long r102) {
        this.f347302a = r100;
        this.f347303b = r101;
        this.f347304c = r102;
    }

    public final void a() {
        AndroidOmniAudioEngine r100 = this.f347302a;
        long r101 = this.f347303b;
        long r102 = this.f347304c;
        Iterator<OmniAudioEngineDelegate> r103 = r100.f347206e.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        OmniAudioEngineDelegate r104 = r103.next();
    L10:
        e = move-exception;
        fe9.c.f476624a.b(r100.f347205d, "Error in listener callback: " + e.getMessage());
        goto L4
    L7:
        if ((r104 instanceof kd9.a1) == false) goto L4;
        ((kd9.a1) r104).p(r101, r102);     // Catch: Exception -> L10
        goto L4
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
