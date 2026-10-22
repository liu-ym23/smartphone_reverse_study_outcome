package com.bytedance.ies.argus.aspect;

import android.app.AlertDialog;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f245884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f245885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f245886c;

    public f(WebView r100, String r101) {
        this.f245884a = r100;
        this.f245885b = "命中安全拦截";
        this.f245886c = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new AlertDialog.Builder(this.f245884a.getContext()).setTitle(this.f245885b).setMessage(this.f245886c).setPositiveButton("确认", null).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
