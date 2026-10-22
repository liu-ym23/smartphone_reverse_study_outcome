package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()[Ljava/lang/String;"}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$getForbiddenPlmnsUnsafe$1 extends Lambda implements Function0<String[]> {
    final /* synthetic */ TelephonyManager $this_getForbiddenPlmnsUnsafe;

    public TelephonyManagerEntry$Companion$getForbiddenPlmnsUnsafe$1(TelephonyManager r100) {
        this.$this_getForbiddenPlmnsUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String[] invoke2() {
        return this.$this_getForbiddenPlmnsUnsafe.getForbiddenPlmns();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String[] invoke() {
        return invoke2();
    }
}
