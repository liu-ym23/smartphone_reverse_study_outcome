package com.bytedance.bpea.entry.api.device.info;

import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelecomManagerEntry$Companion$getLine1NumberUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PhoneAccountHandle $accountHandle;
    final /* synthetic */ TelecomManager $this_getLine1NumberUnsafe;

    public TelecomManagerEntry$Companion$getLine1NumberUnsafe$1(TelecomManager r100, PhoneAccountHandle r101) {
        this.$this_getLine1NumberUnsafe = r100;
        this.$accountHandle = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.$this_getLine1NumberUnsafe.getLine1Number(this.$accountHandle);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
