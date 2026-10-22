package com.bytedance.sdk.xbridge.cn.runtime.depend;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "", "createRetrofit", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XIRetrofit;", "baseUrl", "", "isUseOkHttp", "", "getAPIParams", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostNetworkDepend {
    @Deprecated(message = "与网络库之前的参数传递不够通用", replaceWith = @ReplaceWith(expression = "please use the method include networkConfig", imports = {}))
    XIRetrofit createRetrofit(String r100, boolean r101);

    Map<String, Object> getAPIParams();
}
