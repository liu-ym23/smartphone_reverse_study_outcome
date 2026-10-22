package com.bytedance.ee.bear.onboarding.synchronization;

import android.text.TextUtils;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public final OnBoardingPrefData a() {
        OnBoardingPrefData r100 = (OnBoardingPrefData) LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "on_boarding", true).getJSONObject("ccm_onboarding_config", OnBoardingPrefData.class);
        if (r100 != null) goto L6;
        tt5.a.b("OnBoardingPrefDataManager", "sp onBoardingData = null");
        return new OnBoardingPrefData();
    L6:
        return r100;
    }

    public b() {
    }

    public final void b(OnBoardingPrefData r100) {
        LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "on_boarding", true).putJSONObject("ccm_onboarding_config", r100);
    }

    public final boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        OnBoardingPrefData r101 = a();
        boolean r102 = r101.update(r100);
        tt5.a.h("OnBoardingPrefDataManager", "updateMission to preference: " + r100 + ", status: " + r102);
        b(r101);
        return r102;
    }
}
