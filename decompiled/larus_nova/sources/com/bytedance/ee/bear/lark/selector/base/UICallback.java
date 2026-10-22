package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public class UICallback<Data> implements IGetDataCallback<Data> {
    private IGetDataCallback callback;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f227506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UICallback f227507b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (UICallback.access$000(this.f227507b) == null) goto L9;
            UICallback.access$000(this.f227507b).onSuccess(this.f227506a);     // Catch: Throwable -> L6
            return;
        }

        public a(UICallback r100, Object r101) {
            this.f227507b = r100;
            this.f227506a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f227508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UICallback f227509b;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (UICallback.access$000(this.f227509b) == null) goto L9;
            UICallback.access$000(this.f227509b).onError(this.f227508a);     // Catch: Throwable -> L6
            return;
        }

        public b(UICallback r100, ErrorResult r101) {
            this.f227509b = r100;
            this.f227508a = r101;
        }
    }

    public UICallback(IGetDataCallback<Data> r100) {
        this.callback = r100;
    }

    public static /* synthetic */ IGetDataCallback access$000(UICallback r100) {
        return r100.callback;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public final void onError(ErrorResult r100) {
        UICallbackExecutor.execute(new b(this, r100));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public final void onSuccess(Data r100) {
        UICallbackExecutor.execute(new a(this, r100));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }
}
