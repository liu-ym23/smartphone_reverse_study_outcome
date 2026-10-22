package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements IOfficeSDKConfigProvider {
    public c() {
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final String getAppId() {
        return OfficeSDKManager.getAppId();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final String getAppName() {
        return OfficeSDKManager.getAppName();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final Integer getEnv() {
        return OfficeSDKManager.getEnv();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final IOfficeSDKHostAppHeaderProvider getHostAppHeaderProvider() {
        return OfficeSDKManager.getHostAppHeaderProvider();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final String getHostAppVersion() {
        return OfficeSDKManager.getHostAppVersion();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final List<String> getJournalPaths() {
        return OfficeSDKManager.getJournalPaths();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final String getRequestTagBase() {
        return OfficeSDKManager.getRequestTagBase();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final String getTTEnv() {
        return OfficeSDKManager.getTTEnv();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final boolean isDebug() {
        return Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider
    public final Boolean isEnableNewTtnetLogReporter() {
        return OfficeSDKManager.isEnableNewTtnetLogReporter();
    }
}
