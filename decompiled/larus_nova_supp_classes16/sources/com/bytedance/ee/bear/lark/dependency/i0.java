package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface i0 {
    void a(PolicyModel r1);

    ValidateResult b(PolicyModel r1, AuthEntity r2, ValidateConfig r3);

    long c();

    void d(PolicyModel r1, AuthEntity r2, ValidateConfig r3, fi5.a.c r4);

    void e(Context r1, String r2, String r3);

    boolean getSwitchStatusFromCurrentApp();
}
