package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import com.bytedance.ee.bear.dto.DocAppUserConfig;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;

/* JADX INFO: loaded from: classes16.dex */
public interface k {
    String a(String r100);

    DocAppUserConfig b();

    DocAppUserConfig c();

    boolean d();

    Context getContext();

    String getMainDomain();

    String getPolicyUrl(PolicyAgreement r100);

    boolean isUsPackage();
}
