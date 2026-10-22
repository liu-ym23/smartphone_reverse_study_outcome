package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiPlayerView f256241a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.getTarget() == this) goto L5;
        return;
    L5:
        if (this.f256241a.isAttachedToWindow() == false) goto L9;
        this.f256241a.A.handleMessage(r100);
        return;
    }

    public f(KtvMidiPlayerView r100, Looper r101) {
        this.f256241a = r100;
        super(r101);
    }
}
