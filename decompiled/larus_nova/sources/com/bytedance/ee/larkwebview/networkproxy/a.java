package com.bytedance.ee.larkwebview.networkproxy;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Ref;
import st5.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f242896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f242897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f242898c;

    public a(c r100, Ref.ObjectRef<String> r101, WebView r102) {
        this.f242896a = r100;
        this.f242897b = r101;
        this.f242898c = r102;
    }

    public final void a() {
        Log.i("InjectHookJsInstance", this.f242896a.f543566d + " redirect, location is " + this.f242897b.element);
        this.f242898c.loadUrl(this.f242897b.element);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
