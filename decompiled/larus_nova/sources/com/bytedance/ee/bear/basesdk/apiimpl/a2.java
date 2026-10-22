package com.bytedance.ee.bear.basesdk.apiimpl;

import android.os.Parcelable;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a2 implements pn4.j {
    public a2() {
    }

    @Override // pn4.j
    public final void setCCMConfig(String r110) {
        String r100 = r110;
        tt5.a.h("LeanModeImpl", "setCCMConfigLiveData()...");
        com.bytedance.ee.bear.leanmode.h r101 = com.bytedance.ee.bear.leanmode.h.a();
        Parcelable.Creator<CCMConfig> r102 = CCMConfig.CREATOR;
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L5
        boolean r104 = r103.optBoolean(CCMConfig.a("leanMode"));     // Catch: Exception -> L5
        long r105 = 1000 * r103.optLong("leanMode.sdkDataTimeLimit");     // Catch: Exception -> L5
        CCMConfig.SubConfig r111 = CCMConfig.e(r103, CCMConfig.a("ccm.folder"));     // Catch: Exception -> L5
        CCMConfig.SubConfig r112 = CCMConfig.e(r103, CCMConfig.a("ccm.star"));     // Catch: Exception -> L5
        CCMConfig.SubConfig r113 = CCMConfig.e(r103, CCMConfig.a("ccm.offline"));     // Catch: Exception -> L5
        CCMConfig.SubConfig r114 = CCMConfig.e(r103, CCMConfig.a("ccm.pin"));     // Catch: Exception -> L5
        CCMConfig.SubConfig r115 = CCMConfig.e(r103, CCMConfig.a("ccm.wiki"));     // Catch: Exception -> L5
        CCMConfig.SubConfig r116 = CCMConfig.e(r103, CCMConfig.a("ccm.digitalLoading"));     // Catch: Exception -> L5
        CCMConfig r106 = new CCMConfig(r104, r105, r111, r112, r113, r114, r115, CCMConfig.e(r103, CCMConfig.a("ccm.fetchFullData")), r116);     // Catch: Exception -> L5
        tt5.a.h("CCMConfig", r106.toString());     // Catch: Exception -> L5
    L10:
        r101.getClass();
        tt5.a.h("LeanModeHelper", "setCCMConfigLiveData()...");
        r101.f227598a.postValue(r106);
        return;
    L5:
        e = move-exception;
        if (r100 != null) goto L9;
        r100 = "null";
    L9:
        tt5.a.e("CCMConfig", "origin config json:".concat(r100), e, false);
        r106 = new CCMConfig();
        goto L10
    }

    @Override // pn4.j
    public final void timingCleanData(long r100) {
        tt5.a.h("LeanModeImpl", "timingCleanData()...cacheDataTimeInMills = " + r100);
        com.bytedance.ee.bear.leanmode.h.a().f227599b.postValue(Long.valueOf(r100 * 1000));
    }
}
