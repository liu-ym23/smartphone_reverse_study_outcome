package com.bytedance.bpea.entry.api.device.info;

import android.telephony.SubscriptionManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class SubscriptionManagerEntry$Companion$getActiveSubscriptionInfoCountUnsafe$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ SubscriptionManager $this_getActiveSubscriptionInfoCountUnsafe;

    public SubscriptionManagerEntry$Companion$getActiveSubscriptionInfoCountUnsafe$1(SubscriptionManager r100) {
        this.$this_getActiveSubscriptionInfoCountUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.$this_getActiveSubscriptionInfoCountUnsafe.getActiveSubscriptionInfoCount();
    }
}
