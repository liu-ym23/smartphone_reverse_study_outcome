package com.bytedance.ies.argus.aspect;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f245810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f245811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f245812c;

    public static final class a<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f245813a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super String, Unit> r100) {
            this.f245813a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            Function1<String, Unit> r102 = this.f245813a;
            if (r102 == null) goto L6;
            r102.invoke(r101);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(WebView r100, String r101, Function1<? super String, Unit> r102) {
        this.f245810a = r100;
        this.f245811b = r101;
        this.f245812c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f245810a.evaluateJavascript(this.f245811b, new a(this.f245812c));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
