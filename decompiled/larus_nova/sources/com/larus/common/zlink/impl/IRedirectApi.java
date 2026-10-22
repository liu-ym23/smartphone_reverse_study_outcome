package com.larus.common.zlink.impl;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0001H'¨\u0006\u0007"}, d2 = {"Lcom/larus/common/zlink/impl/IRedirectApi;", "", "fetchSchema", "Lcom/bytedance/retrofit2/Call;", "", "url", "extraInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRedirectApi {
    @GET
    Call<String> fetchSchema(@Url String r100, @ExtraInfo Object r101);
}
