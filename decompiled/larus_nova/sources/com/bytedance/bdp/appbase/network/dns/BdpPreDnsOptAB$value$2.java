package com.bytedance.bdp.appbase.network.dns;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.setting.BdpHostSettingService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class BdpPreDnsOptAB$value$2 extends Lambda implements Function0<Integer> {
    public static final BdpPreDnsOptAB$value$2 INSTANCE = null;

    static {
        INSTANCE = new BdpPreDnsOptAB$value$2();
    }

    public BdpPreDnsOptAB$value$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        JSONObject r100 = ((BdpHostSettingService) BdpManager.getInst().getService(BdpHostSettingService.class)).getSettingJson("bdp_pre_dns_opt");
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.optInt("value", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
