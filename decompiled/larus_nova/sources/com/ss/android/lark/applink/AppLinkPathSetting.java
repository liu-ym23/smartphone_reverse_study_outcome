package com.ss.android.lark.applink;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@AppConfig(key = "key_open_app_link_config")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/applink/AppLinkPathSetting;", "", "<init>", "()V", "paths", "", "", "getPaths", "()Ljava/util/List;", "setPaths", "(Ljava/util/List;)V", "host", "Lcom/ss/android/lark/applink/Hosts;", "getHost", "()Lcom/ss/android/lark/applink/Hosts;", "setHost", "(Lcom/ss/android/lark/applink/Hosts;)V", "memPopePaths", "getMemPopePaths", "setMemPopePaths", "memPopeHost", "getMemPopeHost", "setMemPopeHost", "applink_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLinkPathSetting {

    @SerializedName("hosts")
    private Hosts host;

    @SerializedName("mempope_host")
    private Hosts memPopeHost;

    @SerializedName("mempope_paths")
    private List<String> memPopePaths;

    @SerializedName("paths")
    private List<String> paths;

    public AppLinkPathSetting() {
    }

    public final Hosts a() {
        return this.host;
    }

    public final Hosts b() {
        return this.memPopeHost;
    }

    public final List<String> c() {
        return this.memPopePaths;
    }

    public final List<String> d() {
        return this.paths;
    }
}
