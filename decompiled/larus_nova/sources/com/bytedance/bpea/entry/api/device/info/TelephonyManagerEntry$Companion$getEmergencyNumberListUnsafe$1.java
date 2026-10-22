package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import android.telephony.emergency.EmergencyNumber;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\u0010\u0000\u001ax\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00060\u0004 \u0003*:\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00060\u00040\u00070\u0001H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "Landroid/telephony/emergency/EmergencyNumber;", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$getEmergencyNumberListUnsafe$1 extends Lambda implements Function0<Map<Integer, List<EmergencyNumber>>> {
    final /* synthetic */ TelephonyManager $this_getEmergencyNumberListUnsafe;

    public TelephonyManagerEntry$Companion$getEmergencyNumberListUnsafe$1(TelephonyManager r100) {
        this.$this_getEmergencyNumberListUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Integer, List<EmergencyNumber>> invoke2() {
        return this.$this_getEmergencyNumberListUnsafe.getEmergencyNumberList();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Integer, List<EmergencyNumber>> invoke() {
        return invoke2();
    }
}
