package com.bytedance.bdp.appbase.netapi.base;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.setting.BdpHostSettingService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
public final class AbsNetRequester$quicHost$2 extends Lambda implements Function0<String> {
    public static final AbsNetRequester$quicHost$2 INSTANCE = null;

    static {
        INSTANCE = new AbsNetRequester$quicHost$2();
    }

    public AbsNetRequester$quicHost$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        JSONObject r100 = ((BdpHostSettingService) BdpManager.getInst().getService(BdpHostSettingService.class)).getSettingJson("bdp_network_quic_ab");
        if (r100 == null) goto L9;
        String r101 = r100.optString("host", "https://ma.zijieapi.com");
        if (r101 != null) goto L8;
        return "https://ma.zijieapi.com";
    L8:
        return r101;
    L9:
        return "https://ma.zijieapi.com";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
