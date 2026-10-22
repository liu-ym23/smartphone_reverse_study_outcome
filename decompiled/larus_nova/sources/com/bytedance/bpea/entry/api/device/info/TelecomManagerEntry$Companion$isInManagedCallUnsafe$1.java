package com.bytedance.bpea.entry.api.device.info;

import android.telecom.TelecomManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelecomManagerEntry$Companion$isInManagedCallUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TelecomManager $this_isInManagedCallUnsafe;

    public TelecomManagerEntry$Companion$isInManagedCallUnsafe$1(TelecomManager r100) {
        this.$this_isInManagedCallUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.$this_isInManagedCallUnsafe.isInManagedCall();
    }
}
