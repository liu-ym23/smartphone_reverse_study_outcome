package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingTopBarView f436662a;

    public d(MmRecordingTopBarView r100) {
        this.f436662a = r100;
    }

    public final void a() {
        int r100 = bwb.b.f21271a;
        MmUiLogScene r101 = MmUiLogScene.TOOLBAR;
        StringBuilder r102 = new StringBuilder("end, visibility=");
        h r103 = this.f436662a.f436651a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L5:
        r102.append(r103.f516082c.getVisibility());
        r102.append(", alpha=");
        h r104 = this.f436662a.f436651a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r102.append(r104.f516082c.getAlpha());
        r102.append(", title=");
        h r105 = this.f436662a.f436651a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L11:
        r102.append(r105.f516082c.getText());
        bwb.b.b(r101, "showTitleInBar", r102.toString(), null, 8);
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
