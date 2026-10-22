package com.larus.avatar.impl.scan.utils;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f291147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f291148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f291149c;

    public /* synthetic */ i(String r100, String r101, long r102) {
        this.f291147a = r100;
        this.f291148b = r101;
        this.f291149c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f291147a;
        String r101 = this.f291148b;
        long r102 = this.f291149c;
        k.f291151a.getClass();
        if (Intrinsics.areEqual(k.f291157g, r100) == true) goto L5;
        FLogger.f375446a.i("DigitalAvatarUploadX", "ignore stale upload fail on ui thread: " + r100);
        return;
    L5:
        k.f291160j = r101;
        k.f291158h.setValue(UploadState.FAIL);
        if (Intrinsics.areEqual(k.f291157g, r100) == false) goto L9;
        k.f291157g = null;
        k.f291156f = null;
    L9:
        a.b(false, (int) (System.currentTimeMillis() - r102), null, mr9.i.a(r101), 4);
    }
}
