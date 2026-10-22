package com.bytedance.bpea.entry.api.device.info;

import android.os.PersistableBundle;
import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/os/PersistableBundle;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$getCarrierConfigUnsafe$1 extends Lambda implements Function0<PersistableBundle> {
    final /* synthetic */ TelephonyManager $this_getCarrierConfigUnsafe;

    public TelephonyManagerEntry$Companion$getCarrierConfigUnsafe$1(TelephonyManager r100) {
        this.$this_getCarrierConfigUnsafe = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PersistableBundle invoke() {
        return this.$this_getCarrierConfigUnsafe.getCarrierConfig();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PersistableBundle invoke() {
        return invoke();
    }
}
