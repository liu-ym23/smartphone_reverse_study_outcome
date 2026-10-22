package com.ss.android.lark.officesdk.di.core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/officesdk/di/core/DependencyContainer$ContextDependencyBuilder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DependencyContainer$injectDependency$1 extends Lambda implements Function1<DependencyContainer.a, Unit> {
    final /* synthetic */ Class<? extends c<b>> $providerClass;
    final /* synthetic */ Class<b> $type;

    public DependencyContainer$injectDependency$1(Class<b> r100, Class<? extends c<b>> r101) {
        this.$type = r100;
        this.$providerClass = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DependencyContainer.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$injectDependency");
        r100.a(this.$type, this.$providerClass);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DependencyContainer.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
