package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public class UIDelayGetDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {
    private int mDelayTime;
    private long mStartTime;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f285552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIDelayGetDataCallback f285553b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            T r100 = this.f285553b.callback;     // Catch: Throwable -> L6
            if (r100 == 0) goto L9;
            ((IGetDataCallback) r100).onSuccess(this.f285552a);     // Catch: Throwable -> L6
            this.f285553b.cancel();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(UIDelayGetDataCallback r100, Object r101) {
            this.f285553b = r100;
            this.f285552a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f285554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIDelayGetDataCallback f285555b;

        @Override // java.lang.Runnable
        public final void run() {
            T r100 = this.f285555b.callback;     // Catch: Throwable -> L6
            if (r100 == 0) goto L9;
            ((IGetDataCallback) r100).onError(this.f285554a);     // Catch: Throwable -> L6
            this.f285555b.cancel();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(UIDelayGetDataCallback r100, ErrorResult r101) {
            this.f285555b = r100;
            this.f285554a = r101;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        long r101 = System.currentTimeMillis() - this.mStartTime;
        long r102 = Math.max(((long) this.mDelayTime) - r101, 0);
        UICallbackExecutor.executeDelayed(new b(this, r100), r102);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r100) {
        long r101 = System.currentTimeMillis() - this.mStartTime;
        long r102 = Math.max(((long) this.mDelayTime) - r101, 0);
        UICallbackExecutor.executeDelayed(new a(this, r100), r102);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public UIDelayGetDataCallback(IGetDataCallback<Data> r100, int r101) {
        super(r100);
        this.mStartTime = System.currentTimeMillis();
        this.mDelayTime = r101;
    }
}
