package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hwb.c f436871a;

    public h(hwb.c r100) {
        this.f436871a = r100;
    }

    public final void a() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "autoHide", "collapse float, recordingId=" + this.f436871a.f487443a, null, 8);
        tfb.a.b r101 = tfb.a.f545789a;
        String r102 = this.f436871a.f487443a;
        Intrinsics.checkNotNullParameter(r102, "tag");
        AppFloatManager r103 = com.ss.android.lark.floating.widget.appfloat.c.a(r102);
        if (r103 == null) goto L6;
        r103.c(false);
        return;
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
