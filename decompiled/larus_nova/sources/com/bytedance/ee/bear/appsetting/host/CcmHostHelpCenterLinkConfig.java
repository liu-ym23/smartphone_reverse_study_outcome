package com.bytedance.ee.bear.appsetting.host;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/appsetting/host/CcmHostHelpCenterLinkConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "zhUrl", "", "getZhUrl", "()Ljava/lang/String;", "setZhUrl", "(Ljava/lang/String;)V", "enUrl", "getEnUrl", "setEnUrl", "url", "getUrl", "setUrl", "base-app-setting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmHostHelpCenterLinkConfig implements NonProguard {

    @SerializedName("en_url")
    private String enUrl;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("url")
    private String url;

    @SerializedName("zh_url")
    private String zhUrl;

    public CcmHostHelpCenterLinkConfig() {
        this.enabled = true;
        this.zhUrl = "";
        this.enUrl = "";
        this.url = "";
    }

    public final String getEnUrl() {
        return this.enUrl;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getZhUrl() {
        return this.zhUrl;
    }

    public final void setEnUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enUrl = r100;
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public final void setZhUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.zhUrl = r100;
    }
}
