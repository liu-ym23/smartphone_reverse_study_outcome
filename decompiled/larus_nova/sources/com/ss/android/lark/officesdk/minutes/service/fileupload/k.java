package com.ss.android.lark.officesdk.minutes.service.fileupload;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements yub.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmMinutesFileUploadSessionManager f433770a;

    public k(MmMinutesFileUploadSessionManager r100) {
        this.f433770a = r100;
    }

    @Override // yub.a.c
    public final void a(yub.a.C8392a r100, yub.a.C8392a r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        lvb.a.e(this.f433770a.f433696d, "onAppLifecycleChanged: oldIsAppFront=" + r100.f569257c + ", newIsAppFront=" + r101.f569257c);
        if (r100.f569257c == false) goto L5;
        return;
    L5:
        if (r101.f569257c == false) goto L23;
        MmMinutesFileUploadSessionManager r102 = this.f433770a;
        if (r102.f433705m == false) goto L9;
        lvb.a.e(r102.f433696d, "scheduleForegroundRecovery: skip after release");
        return;
    L9:
        Job r103 = r102.f433704l;
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L20;
        lvb.a.e(r102.f433696d, "scheduleForegroundRecovery: cancel pending recovery");
        Job r105 = r102.f433704l;
        if (r105 == null) goto L20;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L20:
        lvb.a.e(r102.f433696d, "scheduleForegroundRecovery: delayMs=1000");
        r102.f433704l = r102.r("foregroundRecovery", new MmMinutesFileUploadSessionManager$scheduleForegroundRecovery$1(r102, null));
        return;
    L12:
        if (r103.isActive() != true) goto L14;
        r104 = true;
        goto L16
    }
}
