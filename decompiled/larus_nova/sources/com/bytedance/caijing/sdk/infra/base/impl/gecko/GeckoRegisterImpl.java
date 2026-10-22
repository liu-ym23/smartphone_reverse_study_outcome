package com.bytedance.caijing.sdk.infra.base.impl.gecko;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PluginService;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@GeckoRegister(boeAccessKey = CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_BOE, prodAccessKey = CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_ONLINE, testAccessKey = CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_BOE)
public class GeckoRegisterImpl implements IGeckoRegister {

    /* JADX INFO: loaded from: classes15.dex */
    public class a implements OptionCheckUpdateParams.CustomValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GeckoRegisterImpl f202574a;

        @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
        public final Object getValue() {
            ve4.a.f554342a.getClass();
            CJHostService r100 = (CJHostService) ve4.a.d(CJHostService.class);
            PluginService r101 = GeckoRegisterImpl.access$000(this.f202574a);
            if (r101 != null) goto L5;
            return "8.1.7";
        L5:
            return r101.getRealVersion();
        }

        public a(GeckoRegisterImpl r100) {
            this.f202574a = r100;
        }
    }

    public GeckoRegisterImpl() {
    }

    private PluginService getPlugInService() {
        ve4.a.f554342a.getClass();
        return (PluginService) ve4.a.a(PluginService.class);
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        HashMap r100 = new HashMap();
        r100.put("business_version", new a(this));
        return r100;
    }

    public static /* synthetic */ PluginService access$000(GeckoRegisterImpl r100) {
        return r100.getPlugInService();
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getApplicationContext().getFilesDir().getAbsolutePath() + "/offlineX";
    }
}
