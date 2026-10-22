package com.ss.android.lark.applink;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import ova.k;

/* JADX INFO: loaded from: classes34.dex */
@AppConfig(key = "open_app_link_config_v3")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nRB\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fj\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u0001`\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/applink/AppLinkConfigV3;", "", "<init>", "()V", "hosts", "", "", "getHosts", "()Ljava/util/List;", "setHosts", "(Ljava/util/List;)V", "paths", "getPaths", "setPaths", "converters", "Ljava/util/HashMap;", "Lcom/ss/android/lark/applink/ApplinkConverter;", "Lkotlin/collections/HashMap;", "getConverters", "()Ljava/util/HashMap;", "setConverters", "(Ljava/util/HashMap;)V", "v3Paths", "getV3Paths", "setV3Paths", "applink_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLinkConfigV3 {

    @SerializedName("converters")
    private HashMap<String, k> converters;

    @SerializedName("hosts")
    private List<String> hosts;

    @SerializedName("paths")
    private List<String> paths;

    @SerializedName("v3Paths")
    private List<String> v3Paths;

    public AppLinkConfigV3() {
    }

    public final HashMap<String, k> a() {
        return this.converters;
    }

    public final List<String> b() {
        return this.hosts;
    }

    public final List<String> c() {
        return this.paths;
    }

    public final List<String> d() {
        return this.v3Paths;
    }
}
