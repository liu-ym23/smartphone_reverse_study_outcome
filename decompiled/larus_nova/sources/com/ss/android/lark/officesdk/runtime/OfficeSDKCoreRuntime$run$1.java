package com.ss.android.lark.officesdk.runtime;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeSDKCoreRuntime$run$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<IOfficeSDKRuntime, Unit> $block;
    final /* synthetic */ OfficeSDKCoreRuntime this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSDKCoreRuntime$run$1(Function1<? super IOfficeSDKRuntime, Unit> r100, OfficeSDKCoreRuntime r101) {
        this.$block = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$block.invoke(null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
