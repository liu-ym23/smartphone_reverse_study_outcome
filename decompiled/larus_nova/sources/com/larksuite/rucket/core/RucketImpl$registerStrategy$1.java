package com.larksuite.rucket.core;

import c38.b;
import com.larksuite.rucket.core.proxymethod.a;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class RucketImpl$registerStrategy$1 extends FunctionReferenceImpl implements Function1<Method, a> {
    public RucketImpl$registerStrategy$1(Object r100) {
        super(1, r100, b.class, "proxyMethod", "proxyMethod(Ljava/lang/reflect/Method;)Lcom/larksuite/rucket/core/proxymethod/AbstractProxyMethod;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2(Method r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((b) this.receiver).b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a invoke(Method r100) {
        return invoke2(r100);
    }
}
