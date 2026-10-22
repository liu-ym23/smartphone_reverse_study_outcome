package com.bytedance.badger.collect.impl.network;

import com.bytedance.badger.collect.impl.interfaces.INetworkApi;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.utils.CommonUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class DefaultNetworkImpl implements INetworkApi {
    public DefaultNetworkImpl() {
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.INetworkApi
    public TTResponse get(String r100, Map<String, String> r101) throws Exception {
        return CommonUtils.http(null, "GET", r100, (HashMap) r101, null);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.INetworkApi
    public TTResponse post(String r100, Map<String, String> r101, Map<String, String> r102) throws Exception {
        return CommonUtils.http(null, "POST", r100, (HashMap) r101, CommonUtils.map2QueryString(r102).getBytes());
    }
}
