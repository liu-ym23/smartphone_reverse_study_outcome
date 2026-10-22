package com.bytedance.ee.bear.onboarding.synchronization;

import android.text.TextUtils;
import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final OnBoardingPrefData a() {
        OnBoardingPrefData r0 = (OnBoardingPrefData) LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "on_boarding", true).getJSONObject("ccm_onboarding_config", OnBoardingPrefData.class);
        if (r0 != null) goto L6;
        tt5.a.b("OnBoardingPrefDataManager", "sp onBoardingData = null");
        return new OnBoardingPrefData();
    L6:
        return r0;
    }

    public b() {
    }

    public final void b(OnBoardingPrefData r4) {
        LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "on_boarding", true).putJSONObject("ccm_onboarding_config", r4);
    }

    public final boolean c(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        OnBoardingPrefData r0 = a();
        boolean r1 = r0.update(r5);
        tt5.a.h("OnBoardingPrefDataManager", "updateMission to preference: " + r5 + ", status: " + r1);
        b(r0);
        return r1;
    }
}
