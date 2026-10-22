package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes6.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = null;

    static {
        INSTANCE = new DefaultCallAdapterFactory();
    }

    public DefaultCallAdapterFactory() {
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        if (CallAdapter.Factory.getRawType(r100) == Call.class) goto L6;
        return null;
    L6:
        final Type r103 = Utils.getCallResponseType(r100);
        return new AnonymousClass1(this, r103);
    }
}
