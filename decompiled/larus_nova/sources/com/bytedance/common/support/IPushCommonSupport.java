package com.bytedance.common.support;

import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.service.IPushCommonParamService;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.common.support.service.ISecurityService;
import z67.b;

/* JADX INFO: loaded from: classes3.dex */
public interface IPushCommonSupport {
    b getICommonPushSdkMonitorService();

    IPushCommonConfiguration getIPushCommonConfiguration();

    IPushCommonParamService getPushCommonParamService();

    IPushConfigurationService getPushConfigurationService();

    ISecurityService getSecurityService();
}
