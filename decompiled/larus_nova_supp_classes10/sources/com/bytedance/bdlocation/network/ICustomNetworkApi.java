package com.bytedance.bdlocation.network;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface ICustomNetworkApi {
    SsResponse<String> doPost(String r1, String r2, Map<String, String> r3, Map<String, String> r4, List<Header> r5, boolean r6);

    String doPostJson(String r1, String r2, Map<String, String> r3, TypedOutput r4, List<Header> r5, boolean r6);
}
