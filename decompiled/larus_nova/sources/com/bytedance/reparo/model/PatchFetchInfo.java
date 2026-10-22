package com.bytedance.reparo.model;

import android.text.TextUtils;
import c97.h;
import com.alipay.sdk.m.u.i;
import com.bytedance.reparo.core.p;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class PatchFetchInfo {

    @SerializedName("update_version_code")
    private String hostAppVersion;

    @SerializedName("async_load")
    private boolean isAsyncLoad;

    @SerializedName("support_sub_process")
    private boolean isSupportSubProcess;

    @SerializedName("hotfix_id")
    private String issueId;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f267461md5;
    private String name;
    private boolean offline;

    @SerializedName("patch_id")
    private int patchId;

    @SerializedName("patch_name")
    private String patchName;
    private String url;

    @SerializedName("versioncode")
    private int versionCode;
    private boolean wifiOnly;

    public String getMd5() {
        String r100 = this.f267461md5;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toLowerCase();
    }

    public String toString() {
        return "{patchName = " + this.patchName + ", patchId = " + this.patchId + ", issueId = " + this.issueId + ", md5 = " + this.f267461md5 + ", hostAppVersion = " + this.hostAppVersion + ", isAsyncLoad = " + this.isAsyncLoad + ", isSupportSubProcess = " + this.isSupportSubProcess + i.f25855d;
    }

    public PatchFetchInfo() {
        this.isAsyncLoad = true;
    }

    public int hashCode() {
        return TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + getMd5().hashCode();
    }

    public String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public String getName() {
        return this.name;
    }

    public int getPatchId() {
        return this.patchId;
    }

    public String getPatchName() {
        return this.patchName;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public boolean isAsyncLoad() {
        return this.isAsyncLoad;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public boolean isSupportSubProcess() {
        return this.isSupportSubProcess;
    }

    public boolean isWifiOnly() {
        return this.wifiOnly;
    }

    public p convertToUpdateRequest(File r100) {
        String r101 = getMd5();
        String r102 = String.valueOf(this.versionCode);
        String r103 = String.valueOf(this.patchId);
        String r104 = this.issueId;
        String r105 = this.hostAppVersion;
        boolean r106 = this.isAsyncLoad;
        boolean r107 = isSupportSubProcess();
        if (r100 == null) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (TextUtils.isEmpty(r105) == true) goto L11;
        p r108 = new p();
        r108.f267416a = r100;
        r108.f267417b = r101;
        r108.f267418c = r102;
        r108.f267419d = r103;
        r108.f267420e = r104;
        r108.f267421f = r105;
        r108.f267422g = r106;
        r108.f267423h = r107;
        return r108;
    L11:
        throw new IllegalArgumentException("host app version is empty");
    L13:
        throw new IllegalArgumentException("patch md5 is empty");
    L15:
        throw new IllegalArgumentException("patch file is null");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L29:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L29;
        PatchFetchInfo r101 = (PatchFetchInfo) r100;
        if (TextUtils.equals(this.f267461md5, r101.f267461md5) == true) goto L13;
    L27:
        return false;
    L13:
        if (TextUtils.equals(this.issueId, r101.issueId) == false) goto L27;
        if (TextUtils.equals(this.hostAppVersion, r101.hostAppVersion) == false) goto L27;
        if (TextUtils.equals(this.url, r101.url) == false) goto L27;
        if (this.versionCode != r101.versionCode) goto L27;
        if (this.patchId != r101.patchId) goto L27;
        if (this.isAsyncLoad != r101.isAsyncLoad) goto L27;
        if (this.isSupportSubProcess != r101.isSupportSubProcess) goto L27;
        return true;
    }

    public void setAsyncLoad(boolean r100) {
        this.isAsyncLoad = r100;
    }

    public void setHostAppVersion(String r100) {
        this.hostAppVersion = r100;
    }

    public void setIssueId(String r100) {
        this.issueId = r100;
    }

    public void setMd5(String r100) {
        this.f267461md5 = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setOffline(boolean r100) {
        this.offline = r100;
    }

    public void setPatchId(int r100) {
        this.patchId = r100;
    }

    public void setPatchName(String r100) {
        this.patchName = r100;
    }

    public void setSupportSubProcess(boolean r100) {
        this.isSupportSubProcess = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setVersionCode(int r100) {
        this.versionCode = r100;
    }

    public void setWifiOnly(boolean r100) {
        this.wifiOnly = r100;
    }

    public boolean equals(h r100) {
        return TextUtils.equals(String.valueOf(this.patchId), r100.f22890j);
    }
}
