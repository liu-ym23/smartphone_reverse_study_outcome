package com.ss.android.ugc.aweme.framework.services.dyext;

import com.bytedance.android.ec.core.event.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\t\u001a\u00020\u00002!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bJ\u001f\u0010\u0011\u001a\u00020\u00002\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0002\b\u0013R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFeature;", "", "()V", "scope", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;", "getScope", "()Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;", "scope$delegate", "Lkotlin/Lazy;", "onFailure", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", a.KEY_EXCEPTION, "", "then", "block", "Lkotlin/ExtensionFunctionType;", "dy-ext-spi-dummy_release"}, k = 1, mv = {1, 1, 15})
public final class LoadPluginFeature {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy scope$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LoadPluginFeature.class), "scope", "getScope()Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;"))};
    }

    private final LoadPluginScope getScope() {
        Lazy r100 = this.scope$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (LoadPluginScope) r100.getValue();
    }

    public final LoadPluginFeature onFailure(Function1<? super Throwable, Unit> r100) {
        return this;
    }

    public LoadPluginFeature() {
        this.scope$delegate = LazyKt.lazy(LoadPluginFeature$scope$2.INSTANCE);
    }

    public final LoadPluginFeature then(Function1<? super LoadPluginScope, Unit> r100) {
        r100.invoke(getScope());
        return this;
    }
}
