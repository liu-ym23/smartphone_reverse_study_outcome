package com.bytedance.tiktok.proxy;

import androidx.lifecycle.LiveData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\u0004\b\u0002\u0010\u0005\"\u0014\b\u0003\u0010\u0006*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u0002H\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "K", "R", "Lcom/bytedance/tiktok/proxy/IVMReceiver;", "ITEM", "P", "Lcom/bytedance/tiktok/proxy/IVMProxy;", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V", "com/bytedance/tiktok/proxy/IVMProxyHolder$observe$1$1"}, k = 3, mv = {1, 1, 16})
final class IVMProxyHolder$observe$$inlined$let$lambda$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ IVMProxy $owner;
    final /* synthetic */ Function2 $subscriber$inlined;
    final /* synthetic */ LiveData $this_observe$inlined;

    public IVMProxyHolder$observe$$inlined$let$lambda$1(IVMProxy r100, LiveData r101, Function2 r102) {
        this.$owner = r100;
        this.$this_observe$inlined = r101;
        this.$subscriber$inlined = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        R r101 = this.$owner.oq();
        if (r101 == 0) goto L6;
        Unit r102 = (Unit) this.$subscriber$inlined.invoke(r101, r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
