package com.larksuite.rucket.core.proxymethod;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.framework.callback.IGetDataCallback;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class BaseProxyMethod<T extends Annotation> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f286055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f286056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f286057c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/rucket/core/proxymethod/BaseProxyMethod$GenerateProxyMethodError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "<init>", "(Ljava/lang/String;)V", "rucket_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GenerateProxyMethodError extends Error {
        public GenerateProxyMethodError(String r100) {
            super(r100);
        }
    }

    public abstract Class<T> b();

    public final T c() {
        return (T) this.f286056b.getValue();
    }

    public final GenerateProxyMethodError d() {
        return new GenerateProxyMethodError("\nGenerating Proxy Method Failed: \nPlease recheck the origin method: \"" + this.f286055a.getName() + "()\"\n\n");
    }

    public final <U> Class<U> e() {
        Class<U> r100 = (Class) this.f286057c.getValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.Class<U of com.larksuite.rucket.core.proxymethod.BaseProxyMethod.getResponseClazz>");
        return r100;
    }

    public BaseProxyMethod(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f286055a = r100;
        this.f286056b = LazyKt.lazy(new BaseProxyMethod$annotationInfo$2(this));
        this.f286057c = LazyKt.lazy(new BaseProxyMethod$responseClass$2(this));
    }

    @Override // com.larksuite.rucket.core.proxymethod.a
    public final Object invoke(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        int r101 = r100.length;
        if (r101 < 1) goto L8;
        if ((r100[0] instanceof IGetDataCallback) == false) goto L8;
        Object[] r102 = ArraysKt.takeLast(r100, r101 - 1).toArray(new Object[0]);
        Object r103 = r100[0];
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.larksuite.framework.callback.IGetDataCallback<*>");
        a((IGetDataCallback) r103, Arrays.copyOf(r102, r102.length));
    L8:
        return Unit.INSTANCE;
    }
}
