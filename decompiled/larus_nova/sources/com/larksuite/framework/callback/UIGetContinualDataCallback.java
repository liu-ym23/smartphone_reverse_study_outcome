package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class UIGetContinualDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f285556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIGetContinualDataCallback f285557b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            T r100 = this.f285557b.callback;     // Catch: Throwable -> L6
            if (r100 == 0) goto L9;
            ((IGetDataCallback) r100).onSuccess(this.f285556a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(UIGetContinualDataCallback r100, Object r101) {
            this.f285557b = r100;
            this.f285556a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f285558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIGetContinualDataCallback f285559b;

        @Override // java.lang.Runnable
        public final void run() {
            T r100 = this.f285559b.callback;     // Catch: Throwable -> L6
            if (r100 == 0) goto L9;
            ((IGetDataCallback) r100).onError(this.f285558a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(UIGetContinualDataCallback r100, ErrorResult r101) {
            this.f285559b = r100;
            this.f285558a = r101;
        }
    }

    public UIGetContinualDataCallback(IGetDataCallback<Data> r100) {
        super(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        UICallbackExecutor.execute(new b(this, r100));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r100) {
        UICallbackExecutor.execute(new a(this, r100));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }
}
