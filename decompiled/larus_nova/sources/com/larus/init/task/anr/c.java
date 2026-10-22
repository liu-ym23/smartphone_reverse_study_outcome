package com.larus.init.task.anr;

import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements cu8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InitAnrTrackTask f351173a;

    public c(InitAnrTrackTask r100) {
        this.f351173a = r100;
    }

    @Override // cu8.a
    public final void a(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "mainStack");
        FLogger r102 = FLogger.f375446a;
        String r103 = this.f351173a.f351164a;
        StringBuilder r104 = new StringBuilder("onAnrComing, stuckBeginTime: ");
        InitAnrTrackTask r105 = this.f351173a;
        r105.getClass();
        String r106 = r105.f351165b.format(new Date(r100));     // Catch: Throwable -> L5
    L6:
        r104.append(r106);
        r104.append(", mainStack: \n");
        r104.append(r101);
        r102.e(r103, r104.toString());
        g.f365738a.ensureNotReachHere(new Exception("Dump the main thread stack on ANR:\n" + r101 + "\n\n"), "onAnrComing");
        return;
    L5:
        r106 = String.valueOf(r100);
        goto L6
    }
}
