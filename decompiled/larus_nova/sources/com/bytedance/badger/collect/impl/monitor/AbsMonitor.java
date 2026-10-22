package com.bytedance.badger.collect.impl.monitor;

import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.ICommonConfig;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.crash.general.AppInfo;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public abstract class AbsMonitor {
    protected final SecureRandom random;

    public abstract void clear();

    public abstract String getEventName();

    public abstract JSONObject getParams() throws Exception;

    public void report() {
        ICommonConfig r100 = BadgerCollectApi.commonConfig;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getSampleRate();
        if (r101 > 0) goto L8;
    L20:
        JSONObject r102 = getParams();     // Catch: Exception -> L19
        String r103 = getEventName();     // Catch: Exception -> L19
        if (r102 == null) goto L14;
        r102.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L19
        r102.putOpt("sdk_version_code", Integer.valueOf(BuildConfig.SDK_VERSION_CODE));     // Catch: Exception -> L19
        r102.putOpt(AppInfo.KEY_NPTH_VERSION_NAME, BuildConfig.SDK_VERSION_NAME);     // Catch: Exception -> L19
        r102.putOpt("device_id", r100.getDeviceId());     // Catch: Exception -> L19
        r102.putOpt("tag", "badger");     // Catch: Exception -> L19
    L14:
        r100.onEventDepend(r103, r102);     // Catch: Exception -> L19
        if (KLog.isDebug() == false) goto L17;
        KLog.d(Constants.TAGS.EVENT, "埋点数据: " + r103 + ", " + r102);     // Catch: Exception -> L19
    L17:
        clear();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L8:
        if (this.random.nextInt(r101) == 0) goto L20;
        KLog.w(Constants.TAGS.EVENT, getEventName() + " 被采样，不上报埋点");
    }

    public AbsMonitor() {
        this.random = new SecureRandom();
    }
}
