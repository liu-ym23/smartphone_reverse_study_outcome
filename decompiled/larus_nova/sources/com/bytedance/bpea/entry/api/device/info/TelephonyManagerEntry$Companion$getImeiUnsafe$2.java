package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$getImeiUnsafe$2 extends Lambda implements Function0<String> {
    final /* synthetic */ int $slot;
    final /* synthetic */ TelephonyManager $this_getImeiUnsafe;

    public TelephonyManagerEntry$Companion$getImeiUnsafe$2(TelephonyManager r100, int r101) {
        this.$this_getImeiUnsafe = r100;
        this.$slot = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        TelephonyManager r100 = this.$this_getImeiUnsafe;
        int r101 = this.$slot;
        f06.c r110 = new f06.c();
        Object[] r111 = {Integer.valueOf(r101)};
        f06.b r112 = new f06.b();
        f06.d r113 = r110.b(101601, "android/telephony/TelephonyManager", "getImei", r100, r111, "java.lang.String", r112);
        if (r113.f474982a == false) goto L5;
        r110.a(101601, "android/telephony/TelephonyManager", "getImei", r100, r111, null, r112, false);
        return (String) r113.f474983b;
    L5:
        String r102 = r100.getImei(r101);
        r110.a(101601, "android/telephony/TelephonyManager", "getImei", r100, r111, r102, r112, true);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
