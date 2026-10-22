package com.bytedance.bdlocation.network;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface ICustomNetworkApi {
    SsResponse<String> doPost(String r100, String r101, Map<String, String> r102, Map<String, String> r103, List<Header> r104, boolean r105);

    String doPostJson(String r100, String r101, Map<String, String> r102, TypedOutput r103, List<Header> r104, boolean r105);
}
