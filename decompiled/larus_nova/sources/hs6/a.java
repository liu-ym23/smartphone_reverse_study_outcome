package hs6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lhs6/a;", "", "", "cacheTime", "J", "getCacheTime", "()J", "setCacheTime", "(J)V", "", "cityCode", "Ljava/lang/String;", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "account", "getAccount", "setAccount", "", "permission", "Z", "getPermission", "()Z", "setPermission", "(Z)V", "<init>", "()V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public class a {

    @SerializedName("account")
    private String account;

    @SerializedName("cache_time")
    private long cacheTime;

    @SerializedName("city_code")
    private String cityCode;

    @SerializedName("location_permission")
    private boolean permission;

    public a() {
    }

    public final String getAccount() {
        return this.account;
    }

    public final long getCacheTime() {
        return this.cacheTime;
    }

    public final String getCityCode() {
        return this.cityCode;
    }

    public final boolean getPermission() {
        return this.permission;
    }

    public final void setAccount(String r100) {
        this.account = r100;
    }

    public final void setCacheTime(long r100) {
        this.cacheTime = r100;
    }

    public final void setCityCode(String r100) {
        this.cityCode = r100;
    }

    public final void setPermission(boolean r100) {
        this.permission = r100;
    }
}
