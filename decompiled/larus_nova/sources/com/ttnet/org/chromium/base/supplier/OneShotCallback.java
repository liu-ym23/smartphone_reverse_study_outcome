package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.Callback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes41.dex */
public class OneShotCallback<E> {
    private final Callback<E> mCallback;
    private final Callback<E> mCallbackWrapper;
    private final WeakReference<ObservableSupplier<E>> mWeakSupplier;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.OneShotCallback$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CallbackWrapper implements Callback<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ OneShotCallback this$0;

        @Override // com.ttnet.org.chromium.base.Callback
        public final /* synthetic */ Runnable bind(Object r100) {
            return Callback.CC.$default$bind(this, r100);
        }

        static {
        }

        private CallbackWrapper(OneShotCallback r100) {
            this.this$0 = r100;
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(E r100) {
            OneShotCallback.access$100(this.this$0).onResult(r100);
            ((ObservableSupplier) OneShotCallback.access$200(this.this$0).get()).removeObserver(OneShotCallback.access$300(this.this$0));
        }

        public /* synthetic */ CallbackWrapper(OneShotCallback r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static /* synthetic */ Callback access$100(OneShotCallback r100) {
        return r100.mCallback;
    }

    public static /* synthetic */ WeakReference access$200(OneShotCallback r100) {
        return r100.mWeakSupplier;
    }

    public static /* synthetic */ Callback access$300(OneShotCallback r100) {
        return r100.mCallbackWrapper;
    }

    public OneShotCallback(ObservableSupplier<E> r100, Callback<E> r101) {
        CallbackWrapper r102 = new CallbackWrapper(this, null);
        this.mCallbackWrapper = r102;
        this.mWeakSupplier = new WeakReference(r100);
        this.mCallback = r101;
        r100.addObserver(r102);
    }
}
