package com.ss.android.ugc.aweme.framework.services.dyext.impl;

import com.ss.android.ugc.aweme.framework.services.dyext.LoadPluginFuture;
import com.ss.android.ugc.aweme.framework.services.dyext.LoadPluginScope;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/impl/ImmediateLoadPluginFutureImpl;", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFuture;", "()V", "scope", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;", "getScope", "()Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;", "scope$delegate", "Lkotlin/Lazy;", "then", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class ImmediateLoadPluginFutureImpl extends LoadPluginFuture {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy scope$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImmediateLoadPluginFutureImpl.class), "scope", "getScope()Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;"))};
    }

    private final LoadPluginScope getScope() {
        Lazy r100 = this.scope$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (LoadPluginScope) r100.getValue();
    }

    public ImmediateLoadPluginFutureImpl() {
        this.scope$delegate = LazyKt.lazy(ImmediateLoadPluginFutureImpl$scope$2.INSTANCE);
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.LoadPluginFuture
    public LoadPluginFuture then(Function1<? super LoadPluginScope, Unit> r100) {
        r100.invoke(getScope());
        return this;
    }
}
