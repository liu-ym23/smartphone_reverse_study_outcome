package com.bytedance.bpea.entry.api.device.info;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/telephony/CellInfo;", "kotlin.jvm.PlatformType", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$getAllCellInfoUnsafe$1 extends Lambda implements Function0<List<CellInfo>> {
    final /* synthetic */ TelephonyManager $this_getAllCellInfoUnsafe;

    public TelephonyManagerEntry$Companion$getAllCellInfoUnsafe$1(TelephonyManager r100) {
        this.$this_getAllCellInfoUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<CellInfo> invoke2() {
        return this.$this_getAllCellInfoUnsafe.getAllCellInfo();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<CellInfo> invoke() {
        return invoke2();
    }
}
