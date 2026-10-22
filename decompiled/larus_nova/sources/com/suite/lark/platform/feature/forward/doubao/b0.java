package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDoubaoActivity f461313a;

    public b0(ForwardDoubaoActivity r100) {
        this.f461313a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForwardDoubaoActivity r100 = this.f461313a;     // Catch: Throwable -> L7
        int r101 = ForwardDoubaoActivity.f461251p;     // Catch: Throwable -> L7
        r100.getClass();     // Catch: Throwable -> L7
        this.f461313a.B1();     // Catch: Throwable -> L7
        View r102 = this.f461313a.f461263l;     // Catch: Throwable -> L7
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");     // Catch: Throwable -> L7
        r102 = null;
    L5:
        r102.setTranslationY(this.f461313a.f461261j);     // Catch: Throwable -> L7
        ForwardDoubaoActivity.A1(this.f461313a, 0.0f, 1.0f, null, 12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
