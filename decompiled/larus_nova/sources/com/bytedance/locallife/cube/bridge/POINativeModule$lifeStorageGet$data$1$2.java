package com.bytedance.locallife.cube.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class POINativeModule$lifeStorageGet$data$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.IntRef $code;
    final /* synthetic */ Ref.ObjectRef<String> $msg;

    public POINativeModule$lifeStorageGet$data$1$2(Ref.IntRef r100, Ref.ObjectRef<String> r101) {
        this.$code = r100;
        this.$msg = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$code.element = 0;
        this.$msg.element = "life data board get fail, spi error";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
