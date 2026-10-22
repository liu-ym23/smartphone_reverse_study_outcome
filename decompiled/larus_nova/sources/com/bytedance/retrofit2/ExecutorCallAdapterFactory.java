package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T>, IMetricsCollect {
        final Executor callbackExecutor;
        final Call<T> delegate;

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // com.bytedance.retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        @Override // com.bytedance.retrofit2.IMetricsCollect
        public void doCollect() {
            Call<T> r100 = this.delegate;
            if ((r100 instanceof IMetricsCollect) == false) goto L6;
            ((IMetricsCollect) r100).doCollect();
            return;
        }

        @Override // com.bytedance.retrofit2.Call
        public SsResponse execute() throws Exception {
            return this.delegate.execute();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // com.bytedance.retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8521clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(@Nullable final Callback<T> r100) {
            Utils.checkNotNull(r100, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(this, r100));
        }

        public boolean setThrottleNetSpeed(long r100) {
            Call<T> r101 = this.delegate;
            if ((r101 instanceof SsHttpCall) == true) goto L5;
            return false;
        L5:
            return ((SsHttpCall) r101).setThrottleNetSpeed(r100);
        }

        public ExecutorCallbackCall(Executor r100, Call<T> r101) {
            this.callbackExecutor = r100;
            this.delegate = r101;
        }
    }

    public ExecutorCallAdapterFactory(Executor r100) {
        this.callbackExecutor = r100;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        final Executor r103 = null;
        if (CallAdapter.Factory.getRawType(r100) == Call.class) goto L6;
        return null;
    L6:
        if ((r100 instanceof ParameterizedType) == false) goto L14;
        final Type r104 = Utils.getCallResponseType(r100);
        if (Utils.isAnnotationPresent(r101, SkipCallbackExecutor.class) == true) goto L12;
        r103 = this.callbackExecutor;
    L12:
        return new AnonymousClass1(this, r104, r103);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
