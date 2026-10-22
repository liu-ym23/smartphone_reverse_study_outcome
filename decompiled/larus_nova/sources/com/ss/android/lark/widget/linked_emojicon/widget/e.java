package com.ss.android.lark.widget.linked_emojicon.widget;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.span.g0;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f446452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f446453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f446454c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f446455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f446456b;

        @Override // java.lang.Runnable
        public final void run() {
            IGetDataCallback r100 = this.f446456b.f446454c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSuccess(this.f446455a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(e r100, List r101) {
            this.f446456b = r100;
            this.f446455a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pattern r100 = g0.f448681d;     // Catch: Throwable -> L4
        UICallbackExecutor.execute(new a(this, g0.a.f448687a.f(this.f446452a, this.f446453b)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(String r100, List r101, IGetDataCallback r102) {
        this.f446452a = r100;
        this.f446453b = r101;
        this.f446454c = r102;
    }
}
