package com.ss.android.lark.framework.larkwidget;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.component.ChatInitErrorComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Widget f425762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f425763b;

    public a(ChatInitErrorComponent r100, Function0 r101) {
        this.f425762a = r100;
        this.f425763b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f425762a.f425738c == false) goto L9;
        this.f425763b.invoke();     // Catch: Throwable -> L6
        return;
    }
}
