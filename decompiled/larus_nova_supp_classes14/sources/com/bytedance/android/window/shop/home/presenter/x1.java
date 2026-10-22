package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x1 implements Choreographer.FrameCallback {
    public final /* synthetic */ Function0 a;

    public x1(Function0 r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        this.a.invoke();
    }
}
