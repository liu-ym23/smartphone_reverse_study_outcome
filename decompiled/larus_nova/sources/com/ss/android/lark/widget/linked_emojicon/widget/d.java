package com.ss.android.lark.widget.linked_emojicon.widget;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.g0;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f446446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f446447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f446448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f446449d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecogniseSpansResult f446450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f446451b;

        @Override // java.lang.Runnable
        public final void run() {
            IGetDataCallback r100 = this.f446451b.f446449d;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSuccess(this.f446450a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(d r100, RecogniseSpansResult r101) {
            this.f446451b = r100;
            this.f446450a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pattern r100 = g0.f448681d;     // Catch: Throwable -> L4
        g0 r101 = g0.a.f448687a;     // Catch: Throwable -> L4
        String r102 = this.f446446a;     // Catch: Throwable -> L4
        boolean r103 = this.f446447b;     // Catch: Throwable -> L4
        String r104 = this.f446448c;     // Catch: Throwable -> L4
        r101.getClass();     // Catch: Throwable -> L4
        UICallbackExecutor.execute(new a(this, r101.g(r102, new ArrayList(), r103, r104)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(String r100, boolean r101, String r102, IGetDataCallback r103) {
        this.f446446a = r100;
        this.f446447b = r101;
        this.f446448c = r102;
        this.f446449d = r103;
    }
}
