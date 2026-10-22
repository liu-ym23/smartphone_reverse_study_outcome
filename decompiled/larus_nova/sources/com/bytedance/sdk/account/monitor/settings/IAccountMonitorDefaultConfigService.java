package com.bytedance.sdk.account.monitor.settings;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/account/monitor/settings/IAccountMonitorDefaultConfigService;", "Lcom/bytedance/news/common/service/manager/IService;", "", "getDefaultSeed", "()I", "defaultSeed", "Lcom/bytedance/sdk/account/monitor/settings/b;", "getDefaultMonitorConfig", "()Lcom/bytedance/sdk/account/monitor/settings/b;", "defaultMonitorConfig", "account-sdk-monitor_release"}, k = 1, mv = {1, 4, 0})
public interface IAccountMonitorDefaultConfigService extends IService {
    b getDefaultMonitorConfig();

    int getDefaultSeed();
}
