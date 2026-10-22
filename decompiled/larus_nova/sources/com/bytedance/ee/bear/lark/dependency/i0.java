package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: classes16.dex */
public interface i0 {
    void a(PolicyModel r100);

    ValidateResult b(PolicyModel r100, AuthEntity r101, ValidateConfig r102);

    long c();

    void d(PolicyModel r100, AuthEntity r101, ValidateConfig r102, fi5.a.c r103);

    void e(Context r100, String r101, String r102);

    boolean getSwitchStatusFromCurrentApp();
}
