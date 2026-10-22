package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyboardWrapper f412129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f412130b;

    public d(KeyboardWrapper r100, Function0<Unit> r101, int r102) {
        this.f412129a = r100;
        this.f412130b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<T> r100 = this.f412129a.a().iterator();     // Catch: Throwable -> L10
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IKeyboardWrapper.a) r100.next()).b(0);     // Catch: Throwable -> L10
        goto L4
    L6:
        Function0<Unit> r101 = this.f412130b;     // Catch: Throwable -> L10
        if (r101 == null) goto L13;
        r101.invoke();     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
