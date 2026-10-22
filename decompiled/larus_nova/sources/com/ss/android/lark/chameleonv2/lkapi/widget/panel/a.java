package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f411502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f411503b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Integer, Unit> r100, View r101) {
        this.f411502a = r100;
        this.f411503b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f411502a.invoke(Integer.valueOf(this.f411503b.getWidth()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
