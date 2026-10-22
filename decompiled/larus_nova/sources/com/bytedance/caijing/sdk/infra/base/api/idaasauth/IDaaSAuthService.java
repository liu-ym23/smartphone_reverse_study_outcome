package com.bytedance.caijing.sdk.infra.base.api.idaasauth;

import android.content.Context;
import android.util.Pair;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cJM\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u007f\u0010\u0017\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/idaasauth/IDaaSAuthService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", "ctx", "", "cmccParams", "Lyd4/a;", "callback", "", "overTime", Constants.OperatorKey.KEY_CARRIER, "", Constants.OperatorKey.KEY_NETWORK_STATUS, "", "transmitRequest", "(Landroid/content/Context;Ljava/lang/String;Lyd4/a;JLjava/lang/String;Ljava/lang/Integer;)V", "fetchInfo", "uid", "appId", "merchantId", "source", "cmccAppId", "cmccAppKey", ErrorType.PREFETCH, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lyd4/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "", "localNeedPrefetch", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IDaaSAuthService extends ICJService {
    public static final a Companion = null;
    public static final Pair<Integer, String> IDAAS_AUTH_DATA_EMPTY = null;
    public static final Pair<Integer, String> IDAAS_AUTH_EXCEPTION = null;
    public static final Pair<String, String> IDAAS_AUTH_IS_PRE_CACHE_EXPIRES_TIMESTAMP_KEY = null;
    public static final Pair<String, String> IDAAS_AUTH_IS_PRE_CACHE_KEY = null;
    public static final Pair<Integer, String> IDAAS_AUTH_NOT_IMP = null;
    public static final Pair<Integer, String> IDAAS_AUTH_PARAMS_ERROR = null;
    public static final Pair<Integer, String> IDAAS_AUTH_SUCCESS = null;
    public static final Pair<String, String> IDAAS_AUTH_UAID_TOKEN_EXPIRES_TIMESTAMP_KEY = null;
    public static final Pair<String, String> IDAAS_AUTH_UAID_TOKEN_KEY = null;

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f202229a = null;

        static {
            f202229a = new a();
        }

        public a() {
        }
    }

    void fetchInfo(Context r100, yd4.a r101);

    boolean localNeedPrefetch(Context r100);

    void prefetch(Context r100, String r101, String r102, String r103, yd4.a r104, String r105, String r106, Integer r107, String r108, String r110);

    void transmitRequest(Context r100, String r101, yd4.a r102, long r103, String r104, Integer r105);

    static {
        Companion = a.f202229a;
        IDAAS_AUTH_SUCCESS = new Pair(0, "调用成功");
        IDAAS_AUTH_PARAMS_ERROR = new Pair(-1, "入参异常");
        IDAAS_AUTH_DATA_EMPTY = new Pair(-2, "出参异常");
        IDAAS_AUTH_EXCEPTION = new Pair(-3, "调用异常");
        IDAAS_AUTH_NOT_IMP = new Pair(-4, "功能未实现");
        IDAAS_AUTH_UAID_TOKEN_KEY = new Pair("idaas_auth_uaid_token_key", "cmccUAidToken");
        IDAAS_AUTH_IS_PRE_CACHE_KEY = new Pair("idaas_auth_is_pre_cache_key", "isCmccPreCache");
        IDAAS_AUTH_UAID_TOKEN_EXPIRES_TIMESTAMP_KEY = new Pair("idaas_auth_uaid_token_expires_timestamp_key", "cmccUAidTokenExpiresTimestamp");
        IDAAS_AUTH_IS_PRE_CACHE_EXPIRES_TIMESTAMP_KEY = new Pair("idaas_auth_is_pre_cache_expires_timestamp_key", "isCmccPreCacheExpiresTimestamp");
    }
}
