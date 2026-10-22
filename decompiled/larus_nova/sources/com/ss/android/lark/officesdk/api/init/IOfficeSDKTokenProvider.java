package com.ss.android.lark.officesdk.api.init;

import com.alipay.sdk.m.p.e;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J&\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "getAccessToken", "", "getAuthSchema", "isDoubaoBUser", "", "getAuthHeaders", "", "url", e.f25671s, "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKTokenProvider extends IOfficeSDKProtocol {
    String getAccessToken();

    Map<String, String> getAuthHeaders(String r100, String r101);

    String getAuthSchema();

    boolean isDoubaoBUser();
}
