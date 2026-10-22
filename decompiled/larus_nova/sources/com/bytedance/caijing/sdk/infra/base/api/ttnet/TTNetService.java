package com.bytedance.caijing.sdk.infra.base.api.ttnet;

import com.android.ttcjpaysdk.base.network.ICJNetCall;
import com.android.ttcjpaysdk.base.network.ICJPayInterceptor;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import te4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001Jd\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&Jd\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&Jv\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J@\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&JZ\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0018\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&JJ\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&JJ\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&JZ\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0018\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J@\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\"\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010 H&J\u001c\u0010\"\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010#H&J\b\u0010%\u001a\u00020\u0016H&J\u001a\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H&J\u001a\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H&J \u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H&JL\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120,2\u0006\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H&J\u0012\u0010.\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H&J\b\u0010/\u001a\u00020\bH&¨\u00060"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/ttnet/TTNetService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "baseUrl", "", "queryMap", "headerMap", ContainerPosition.BODY, "", "maxLength", "Lte4/a;", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "postJsonTTNet", "postJsonTTNetHighPriority", "", "", "dataList", "Lorg/json/JSONObject;", "extBody", "postMultipartImageTTNet", "url", "", "downloadFileTTNet", "fieldMap", "postFormTTNet", "data", "postPbTTNet", "postPbTTNetHighPriority", "postFormTTNetHighPriority", "getTTNet", "key", "Lcom/android/ttcjpaysdk/base/network/ICJPayInterceptor;", "interceptor", "addInterceptor", "", "ttnetInterceptor", "addInterceptorWhenPluginRequest", "defaultCode", "", "t", "getTTNetErrorCode", "getTTNetInternalErrorCode", "getTTNetRequestHeader", "Lcom/android/ttcjpaysdk/base/network/ICJNetCall;", "postFormTTNetSync", "preconnectUrl", "getEffectiveConnectionType", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface TTNetService extends ICJService {
    void addInterceptor(String r100, ICJPayInterceptor r101);

    void addInterceptor(String r100, Object r101);

    void addInterceptorWhenPluginRequest();

    void downloadFileTTNet(String r100, String r101, Map<String, String> r102, a r103);

    int getEffectiveConnectionType();

    ICJPayRequest getTTNet(String r100, Map<String, String> r101, int r102, a r103);

    int getTTNetErrorCode(int r100, Throwable r101);

    int getTTNetInternalErrorCode(int r100, Throwable r101);

    Map<String, String> getTTNetRequestHeader(Throwable r100);

    ICJPayRequest postFormTTNet(String r100, Map<String, String> r101, Map<String, String> r102, int r103, a r104);

    ICJPayRequest postFormTTNetHighPriority(String r100, Map<String, String> r101, Map<String, String> r102, int r103, a r104);

    ICJNetCall<JSONObject> postFormTTNetSync(String r100, Map<String, String> r101, int r102, Map<String, String> r103);

    ICJPayRequest postJsonTTNet(String r100, Map<String, String> r101, Map<String, String> r102, String r103, int r104, a r105);

    ICJPayRequest postJsonTTNetHighPriority(String r100, Map<String, String> r101, Map<String, String> r102, String r103, int r104, a r105);

    ICJPayRequest postMultipartImageTTNet(String r100, Map<String, String> r101, Map<String, String> r102, List<byte[]> r103, JSONObject r104, int r105, a r106);

    ICJPayRequest postPbTTNet(String r100, byte[] r101, Map<String, String> r102, int r103, a r104);

    ICJPayRequest postPbTTNetHighPriority(String r100, byte[] r101, Map<String, String> r102, int r103, a r104);

    void preconnectUrl(String r100);
}
