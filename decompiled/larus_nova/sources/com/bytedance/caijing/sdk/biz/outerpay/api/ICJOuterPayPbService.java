package com.bytedance.caijing.sdk.biz.outerpay.api;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.InputStream;
import kotlin.Metadata;
import org.json.JSONObject;
import te4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH&J0\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0010H&J$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¨\u0006 "}, d2 = {"Lcom/bytedance/caijing/sdk/biz/outerpay/api/ICJOuterPayPbService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "isOuterPreTradeInfoQueryUsePb", "abExperimentValueIsJson", "abExperimentValueIsPb", "", "triggerGlobalPbDowngrade", "Lorg/json/JSONObject;", "bizContentParams", "", "getOutPreTradeInfoQueryRequestDataArray", "Ljava/io/InputStream;", "data", "", "parseOutPreTradeInfoQueryResponseDataByPB", "", "mode", "isSuccess", "", "parseDeltaTime", "reqToParseDuration", "errorMsg", "reportPbUnmarshalEvent", "url", "Lte4/b;", "response", "", "t", "logServerApiStatus", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cjpay-outer-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJOuterPayPbService extends ICJService {
    public static final a Companion = null;
    public static final String ERROR_CODE_PB_156 = "CD000156";
    public static final String ERROR_CODE_PB_157 = "CD000157";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f202202a = null;

        static {
            f202202a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f202202a;
    }

    boolean abExperimentValueIsJson();

    boolean abExperimentValueIsPb();

    byte[] getOutPreTradeInfoQueryRequestDataArray(JSONObject r100);

    boolean isOuterPreTradeInfoQueryUsePb();

    void logServerApiStatus(String r100, b r101, Throwable r102);

    Object parseOutPreTradeInfoQueryResponseDataByPB(InputStream r100);

    void reportPbUnmarshalEvent(String r100, boolean r101, long r102, long r103, String r104);

    void triggerGlobalPbDowngrade();
}
