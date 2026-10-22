package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetChatByIdParam f444185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callback f444186b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f444187a;

        public a(Callback r100) {
            this.f444187a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f444187a.success(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(GetChatByIdParam r100, Callback r101) {
        this.f444185a = r100;
        this.f444186b = r101;
    }

    public final void a() {
        TodoDependencyHolder.a().chatModuleDependency().getChatById(this.f444185a.getChatId());
        com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new a(this.f444186b));
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
