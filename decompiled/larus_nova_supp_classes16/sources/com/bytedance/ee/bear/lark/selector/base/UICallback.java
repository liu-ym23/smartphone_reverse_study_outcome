package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UICallback<Data> implements IGetDataCallback<Data> {
    private IGetDataCallback callback;

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ UICallback b;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (UICallback.access$000(this.b) == null) goto L9;
            UICallback.access$000(this.b).onSuccess(this.a);     // Catch: Throwable -> L6
            return;
        }

        public a(UICallback r1, Object r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ErrorResult a;
        public final /* synthetic */ UICallback b;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (UICallback.access$000(this.b) == null) goto L9;
            UICallback.access$000(this.b).onError(this.a);     // Catch: Throwable -> L6
            return;
        }

        public b(UICallback r1, ErrorResult r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public UICallback(IGetDataCallback<Data> r1) {
        this.callback = r1;
    }

    public static /* synthetic */ IGetDataCallback access$000(UICallback r0) {
        return r0.callback;
    }

    public final void onError(ErrorResult r2) {
        UICallbackExecutor.execute(new b(this, r2));
    }

    public final void onSuccess(Data r2) {
        UICallbackExecutor.execute(new a(this, r2));
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }
}
