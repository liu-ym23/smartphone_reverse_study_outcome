package com.ss.android.lark.chat.preview.components.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimingView f416214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TimeProperty f416215b;

    public i(TimingView r100, TimeProperty r101) {
        this.f416214a = r100;
        this.f416215b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TimingView r100 = this.f416214a;     // Catch: Throwable -> L4
        TimeProperty r101 = this.f416215b;     // Catch: Throwable -> L4
        int r102 = TimingView.f416159b;     // Catch: Throwable -> L4
        r100.z(r101, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
