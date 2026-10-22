package rk7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lrk7/x;", "", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "Ljava/lang/Integer;", "getExpireTime", "()Ljava/lang/Integer;", "setExpireTime", "(Ljava/lang/Integer;)V", "", "", "cleanCacheKeys", "Ljava/util/List;", "b", "()Ljava/util/List;", "setCleanCacheKeys", "(Ljava/util/List;)V", "cleanCacheContainKeys", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCleanCacheContainKeys", "<init>", "()V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, w> f538402a;

    @SerializedName("cache_clean_contain_keys")
    private List<String> cleanCacheContainKeys;

    @SerializedName("cache_clean_keys")
    private List<String> cleanCacheKeys;

    @SerializedName("expire_time")
    private Integer expireTime;

    public x() {
        this.expireTime = 0;
    }

    public final List<String> a() {
        return this.cleanCacheContainKeys;
    }

    public final List<String> b() {
        return this.cleanCacheKeys;
    }
}
