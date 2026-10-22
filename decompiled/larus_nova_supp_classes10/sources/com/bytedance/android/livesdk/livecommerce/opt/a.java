package com.bytedance.android.livesdk.livecommerce.opt;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Choreographer.FrameCallback {
    public final /* synthetic */ Function0 a;

    public a(Function0 r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        this.a.invoke();
    }
}
