package com.bytedance.ee.bear.appsetting.host;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/appsetting/host/CcmHostConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "export", "Lcom/bytedance/ee/bear/appsetting/host/CcmHostExportConfig;", "getExport", "()Lcom/bytedance/ee/bear/appsetting/host/CcmHostExportConfig;", "setExport", "(Lcom/bytedance/ee/bear/appsetting/host/CcmHostExportConfig;)V", "helpCenter", "", "", "Lcom/bytedance/ee/bear/appsetting/host/CcmHostHelpCenterLinkConfig;", "getHelpCenter", "()Ljava/util/Map;", "setHelpCenter", "(Ljava/util/Map;)V", "base-app-setting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmHostConfig implements NonProguard {

    @SerializedName("export")
    private CcmHostExportConfig export;

    @SerializedName("help_center")
    private Map<String, CcmHostHelpCenterLinkConfig> helpCenter;

    public CcmHostConfig() {
    }

    public final CcmHostExportConfig getExport() {
        return this.export;
    }

    public final Map<String, CcmHostHelpCenterLinkConfig> getHelpCenter() {
        return this.helpCenter;
    }

    public final void setExport(CcmHostExportConfig r100) {
        this.export = r100;
    }

    public final void setHelpCenter(Map<String, CcmHostHelpCenterLinkConfig> r100) {
        this.helpCenter = r100;
    }
}
