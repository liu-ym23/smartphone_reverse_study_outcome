package com.bytedance.ee.bear.tts.lynx.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.h("TtsLynxFloatView", "addToFloatView, onClick callback.");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
