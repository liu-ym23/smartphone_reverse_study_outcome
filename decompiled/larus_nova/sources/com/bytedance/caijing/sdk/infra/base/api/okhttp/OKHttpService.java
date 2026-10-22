package com.bytedance.caijing.sdk.infra.base.api.okhttp;

import ae4.a;
import com.android.ttcjpaysdk.base.network.ICJPayInterceptor;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JB\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&JB\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&JR\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J8\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/okhttp/OKHttpService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "baseUrl", "", "headerMap", ContainerPosition.BODY, "Lae4/a;", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "postJsonOKHttp", "Lorg/json/JSONObject;", "bodyJson", "fieldMap", "postFormOKHttp", "getOKHttp", "url", "", "downloadFileOKHttp", "key", "Lcom/android/ttcjpaysdk/base/network/ICJPayInterceptor;", "interceptor", "addInterceptor", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface OKHttpService extends ICJService {
    void addInterceptor(String r100, ICJPayInterceptor r101);

    void downloadFileOKHttp(String r100, a r101);

    ICJPayRequest getOKHttp(String r100, Map<String, String> r101, a r102);

    ICJPayRequest postFormOKHttp(String r100, Map<String, String> r101, Map<String, String> r102, a r103);

    ICJPayRequest postJsonOKHttp(String r100, Map<String, String> r101, String r102, a r103);

    ICJPayRequest postJsonOKHttp(String r100, Map<String, String> r101, JSONObject r102, a r103);
}
