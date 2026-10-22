package com.bytedance.bpea.entry.api.device.info;

import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/telephony/SubscriptionInfo;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class SubscriptionManagerEntry$Companion$getActiveSubscriptionInfoForSimSlotIndexUnsafe$1 extends Lambda implements Function0<SubscriptionInfo> {
    final /* synthetic */ int $slot;
    final /* synthetic */ SubscriptionManager $this_getActiveSubscriptionInfoForSimSlotIndexUnsafe;

    public SubscriptionManagerEntry$Companion$getActiveSubscriptionInfoForSimSlotIndexUnsafe$1(SubscriptionManager r100, int r101) {
        this.$this_getActiveSubscriptionInfoForSimSlotIndexUnsafe = r100;
        this.$slot = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SubscriptionInfo invoke() {
        SubscriptionManager r100 = this.$this_getActiveSubscriptionInfoForSimSlotIndexUnsafe;
        int r110 = this.$slot;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {Integer.valueOf(r110)};
        f06.b r113 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102007);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r114 = r105;
        int r115 = r104;
        f06.a[] r210 = r103;
        f06.d r107 = r106.preInvoke(102007, "android/telephony/SubscriptionManager", "getActiveSubscriptionInfoForSimSlotIndex", r100, r112, "android.telephony.SubscriptionInfo", r113);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r111.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return (SubscriptionInfo) r107.f474983b;
    L20:
        return r100.getActiveSubscriptionInfoForSimSlotIndex(r110);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        r103 = r210;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SubscriptionInfo invoke() {
        return invoke();
    }
}
