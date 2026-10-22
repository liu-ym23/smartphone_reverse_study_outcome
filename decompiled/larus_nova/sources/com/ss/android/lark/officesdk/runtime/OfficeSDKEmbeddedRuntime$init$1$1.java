package com.ss.android.lark.officesdk.runtime;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeSDKEmbeddedRuntime$init$1$1 extends Lambda implements Function1<IOfficeSDKRuntime, Unit> {
    final /* synthetic */ OfficeSDKInitConfig $initConfig;
    final /* synthetic */ OfficeSDKCoreRuntime $runtime;

    public OfficeSDKEmbeddedRuntime$init$1$1(OfficeSDKInitConfig r100, OfficeSDKCoreRuntime r101) {
        this.$initConfig = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IOfficeSDKRuntime r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        OfficeSDKProvider r101 = OfficeSDKProvider.INSTANCE;
        r101.getInstance().a(this.$initConfig);
        a.f437170a.set(true);
        r101.getInstance().b(null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IOfficeSDKRuntime r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
