package com.bytedance.caijing.sdk.infra.base.api.plugin;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PluginService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getFontScale", "", "getGeckoXPath", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getLanguageTypeStr", "getRealVersion", "getStatusBarHeight", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PluginService extends ICJService {
    float getFontScale();

    String getGeckoXPath(Context r100);

    String getLanguageTypeStr();

    String getRealVersion();

    int getStatusBarHeight(Context r100);
}
