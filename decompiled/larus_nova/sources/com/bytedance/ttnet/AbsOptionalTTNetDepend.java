package com.bytedance.ttnet;

import com.bytedance.retrofit2.AppLaunchTimeStampProvider;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsOptionalTTNetDepend implements AppLaunchTimeStampProvider {
    public AbsOptionalTTNetDepend() {
    }

    @Override // com.bytedance.retrofit2.AppLaunchTimeStampProvider
    public long getAppStartCPUTimeStamp() {
        return -1;
    }

    @Override // com.bytedance.retrofit2.AppLaunchTimeStampProvider
    public long getAppStartWallClockTimeStamp() {
        return -1;
    }

    public String[] getHttpDnsHardCodeIps() {
        return null;
    }

    public String[] getPreloadDomains() {
        return null;
    }

    public int getProcessFlag() {
        return 0;
    }

    public boolean getRefineAppDelayEnable() {
        return true;
    }

    public Map<String, String> getTNCExtraParam() {
        return null;
    }

    public boolean isPrivacyAccessEnabled() {
        return false;
    }
}
