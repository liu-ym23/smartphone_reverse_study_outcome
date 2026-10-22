package com.ss.android.lark.applink;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@AppConfig(key = "biz_domain_config")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/applink/AppLinkHostSetting;", "", "<init>", "()V", "paths", "", "", "getPaths", "()Ljava/util/List;", "setPaths", "(Ljava/util/List;)V", "applink_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLinkHostSetting {

    @SerializedName("applink_peer")
    private List<String> paths;

    public AppLinkHostSetting() {
    }

    public final List<String> a() {
        return this.paths;
    }
}
