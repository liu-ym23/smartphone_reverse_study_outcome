package com.huawei.hms.security;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.api.HuaweiServicesNotAvailableException;
import com.huawei.hms.api.HuaweiServicesRepairableException;

/* JADX INFO: loaded from: classes23.dex */
public class SecComponentInstallWizard {
    public static final String PROVIDER_NAME = "HmsCore_OpenSSL";

    public interface SecComponentInstallWizardListener {
        void onFailed(int r100, Intent r101);

        void onSuccess();
    }

    public SecComponentInstallWizard() {
    }

    public static void install(Context r100) throws HuaweiServicesNotAvailableException, HuaweiServicesRepairableException {
    }
}
