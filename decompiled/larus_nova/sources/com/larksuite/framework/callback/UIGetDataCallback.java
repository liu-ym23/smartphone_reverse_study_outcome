package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public class UIGetDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f285560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIGetDataCallback f285561b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f285561b.isCanceled() == true) goto L13;
            UIGetDataCallback r100 = this.f285561b;     // Catch: Throwable -> L10
            T r101 = r100.callback;     // Catch: Throwable -> L10
            if (r101 == 0) goto L7;
            ((IGetDataCallback) r101).onSuccess(this.f285560a);     // Catch: Throwable -> L10
        L8:
            this.f285561b.cancel();     // Catch: Throwable -> L10
            return;
        L7:
            r100.onSuccessed(this.f285560a);     // Catch: Throwable -> L10
            goto L8
        }

        public a(UIGetDataCallback r100, Object r101) {
            this.f285561b = r100;
            this.f285560a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f285562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIGetDataCallback f285563b;

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f285563b.isCanceled() == true) goto L13;
            UIGetDataCallback r100 = this.f285563b;     // Catch: Throwable -> L10
            T r101 = r100.callback;     // Catch: Throwable -> L10
            if (r101 == 0) goto L7;
            ((IGetDataCallback) r101).onError(this.f285562a);     // Catch: Throwable -> L10
        L8:
            this.f285563b.cancel();     // Catch: Throwable -> L10
            return;
        L7:
            r100.onErrored(this.f285562a);     // Catch: Throwable -> L10
            goto L8
        }

        public b(UIGetDataCallback r100, ErrorResult r101) {
            this.f285563b = r100;
            this.f285562a = r101;
        }
    }

    public void onErrored(ErrorResult r100) {
    }

    public void onSuccessed(Data r100) {
    }

    public UIGetDataCallback() {
    }

    public UIGetDataCallback(IGetDataCallback<Data> r100) {
        super(r100);
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
