package com.bytedance.lynx.webview.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f265285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f265286b;

    @Override // java.lang.Runnable
    public final void run() {
        EventStatistics.f265114b.put(this.f265285a, this.f265286b);     // Catch: Throwable -> L4 JSONException -> L6
    L14:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    L18:
        return;
    L6:
        e = move-exception;
        l17.k.b(new String[]{"addEventExtentionInfo error: " + e.toString()});     // Catch: Throwable -> L4
        goto L14
    }

    public d(String r100, String r101) {
        this.f265285a = r100;
        this.f265286b = r101;
    }
}
