package com.bytedance.falconx.statistic;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes19.dex */
public class InterceptorModel {

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_AC)
    public String f243226ac;

    @SerializedName("access_key")
    public String accessKey;

    @SerializedName("channel")
    public String channel;

    @SerializedName("err_code")
    public String errCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    public String errMsg;
    public boolean isCombo;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("mime_type")
    public String mimeType;

    @SerializedName("offline_duration")
    public Long offlineDuration;

    @SerializedName("offline_rule")
    public String offlineRule;

    @SerializedName("offline_status")
    public Integer offlineStatus;

    @SerializedName("online_duration")
    public Long onlineDuration;

    @SerializedName("page_url")
    public String pageUrl;

    @SerializedName("pkg_version")
    public Long pkgVersion;

    @SerializedName("res_root_dir")
    public String resRootDir;
    public long startTime;

    @SerializedName("resource_url")
    public String url;

    public long getVersion() {
        Long r100 = this.pkgVersion;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.longValue();
    }

    public InterceptorModel() {
        this.startTime = SystemClock.uptimeMillis();
    }

    public void loadFinish(boolean r100) {
        if (r100 == false) goto L4;
        this.offlineDuration = Long.valueOf(SystemClock.uptimeMillis() - this.startTime);
        this.offlineStatus = 1;
        return;
    L4:
        this.offlineStatus = 0;
    }

    public void setErrorCode(String r100) {
        this.errCode = r100;
    }

    public void setErrorMsg(String r100) {
        this.errMsg = r100;
    }
}
