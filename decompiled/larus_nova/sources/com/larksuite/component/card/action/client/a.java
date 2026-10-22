package com.larksuite.component.card.action.client;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f283191a;

    public a(c r100, JSONObject r101) {
        this.f283191a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f283191a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
