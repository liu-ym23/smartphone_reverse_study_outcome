package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingTopBarView f436661a;

    public c(MmRecordingTopBarView r100) {
        this.f436661a = r100;
    }

    public final void a() {
        h r100 = this.f436661a.f436651a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        r100.f516082c.setVisibility(8);
        int r101 = bwb.b.f21271a;
        MmUiLogScene r102 = MmUiLogScene.TOOLBAR;
        StringBuilder r103 = new StringBuilder("end, visibility=");
        h r104 = this.f436661a.f436651a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r103.append(r104.f516082c.getVisibility());
        r103.append(", alpha=");
        h r105 = this.f436661a.f436651a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L11:
        r103.append(r105.f516082c.getAlpha());
        r103.append(", title=");
        h r106 = this.f436661a.f436651a;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L14:
        r103.append(r106.f516082c.getText());
        bwb.b.b(r102, "hideTitleInBar", r103.toString(), null, 8);
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
