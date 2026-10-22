package com.bytedance.caijing.sdk.infra.base.api.plugin;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J&\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInCloudUnionPayService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "currentSession", "", "isInstalled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "notifyResult", "", "paySession", "result", "", "reportEvent", "eventName", "eventParams", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PlugInCloudUnionPayService extends ICJService {
    Object currentSession();

    boolean isInstalled(Context r100);

    void notifyResult(Object r100, String r101);

    void reportEvent(Object r100, String r101, String r102);
}
