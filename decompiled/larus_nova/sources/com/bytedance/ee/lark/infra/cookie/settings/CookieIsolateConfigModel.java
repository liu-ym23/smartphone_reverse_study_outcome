package com.bytedance.ee.lark.infra.cookie.settings;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0006H\u0016R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR,\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/lark/infra/cookie/settings/CookieIsolateConfigModel;", "Ljava/io/Serializable;", "<init>", "()V", "tenants", "", "", "Lcom/bytedance/ee/lark/infra/cookie/settings/CookieIsolateConfigModel$TenantModel;", "getTenants", "()Ljava/util/Map;", "setTenants", "(Ljava/util/Map;)V", "apps", "", "getApps", "setApps", "applyAll", "", "getApplyAll", "()Z", "setApplyAll", "(Z)V", "toString", "TenantModel", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CookieIsolateConfigModel implements Serializable {

    @SerializedName("apply_all")
    private boolean applyAll;

    @SerializedName("apps")
    private Map<String, Object> apps;

    @SerializedName("tenants")
    private Map<String, TenantModel> tenants;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0006H\u0016R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/lark/infra/cookie/settings/CookieIsolateConfigModel$TenantModel;", "Ljava/io/Serializable;", "<init>", "()V", "whiteList", "", "", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "blackList", "getBlackList", "setBlackList", "toString", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TenantModel implements Serializable {

        @SerializedName("black_list")
        private List<String> blackList;

        @SerializedName("white_list")
        private List<String> whiteList;

        public TenantModel() {
        }

        public String toString() {
            return "TenantModel: { white_list: " + this.whiteList + ", black_list: " + this.blackList + " }";
        }

        public final List<String> getBlackList() {
            return this.blackList;
        }

        public final List<String> getWhiteList() {
            return this.whiteList;
        }

        public final void setBlackList(List<String> r100) {
            this.blackList = r100;
        }

        public final void setWhiteList(List<String> r100) {
            this.whiteList = r100;
        }
    }

    public CookieIsolateConfigModel() {
    }

    public String toString() {
        return "gadgetWebViewCookieIsolationConfig: { tenants: " + this.tenants + ", apps: " + this.apps + ", apply_all: " + this.applyAll + " }";
    }

    public final boolean getApplyAll() {
        return this.applyAll;
    }

    public final Map<String, Object> getApps() {
        return this.apps;
    }

    public final Map<String, TenantModel> getTenants() {
        return this.tenants;
    }

    public final void setApplyAll(boolean r100) {
        this.applyAll = r100;
    }

    public final void setApps(Map<String, Object> r100) {
        this.apps = r100;
    }

    public final void setTenants(Map<String, TenantModel> r100) {
        this.tenants = r100;
    }
}
