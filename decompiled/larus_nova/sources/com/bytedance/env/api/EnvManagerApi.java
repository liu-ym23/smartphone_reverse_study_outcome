package com.bytedance.env.api;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\rH&J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0004H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020\u001eH&J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H&¨\u0006%"}, d2 = {"Lcom/bytedance/env/api/EnvManagerApi;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "init", "", "enable", "setEnvWindowEnable", "visible", "setFloatingWindowVisible", "isFloatingWindowVisible", "setFloatingWindowRemovable", "Lcom/bytedance/env/api/b;", "config", "initEnvConfig", "setEnvConfig", "", "envType", "", "lane", "getEnvConfig", "getEnvType", "getEnvLane", "Lcom/bytedance/env/api/e;", "listener", "addOnEnvConfigChangeListener", "removeOnEnvConfigChangeListener", "setAutoRebootEnable", "reboot", "Lcom/bytedance/env/api/d;", "initGeckoConfig", "setGeckoConfig", "getGeckoConfig", "Landroid/app/Activity;", "activity", "openDialog", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public interface EnvManagerApi {
    void addOnEnvConfigChangeListener(e r100);

    b getEnvConfig();

    String getEnvLane();

    int getEnvType();

    d getGeckoConfig();

    void init(Context r100);

    void initEnvConfig(b r100);

    void initGeckoConfig(d r100);

    boolean isFloatingWindowVisible();

    void openDialog(Activity r100);

    void reboot();

    void removeOnEnvConfigChangeListener(e r100);

    void setAutoRebootEnable(boolean r100);

    void setEnvConfig(int r100, String r101);

    void setEnvConfig(b r100);

    void setEnvWindowEnable(boolean r100);

    void setFloatingWindowRemovable(boolean r100);

    void setFloatingWindowVisible(boolean r100);

    void setGeckoConfig(d r100);
}
