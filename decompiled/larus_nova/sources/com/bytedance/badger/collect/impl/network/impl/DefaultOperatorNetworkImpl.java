package com.bytedance.badger.collect.impl.network.impl;

import android.net.Network;
import com.bytedance.badger.collect.impl.interfaces.IOperatorNetworkApi;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.utils.CommonUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultOperatorNetworkImpl implements IOperatorNetworkApi {
    private static final int LENGTH_MAX = 10240;

    public DefaultOperatorNetworkImpl() {
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.IOperatorNetworkApi
    public TTResponse get(Network r100, String r101, Map<String, String> r102) throws Exception {
        return CommonUtils.http(r100, "GET", r101, r102, null);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.IOperatorNetworkApi
    public TTResponse post(Network r100, String r101, Map<String, String> r102, byte[] r103) throws Exception {
        return CommonUtils.http(r100, "POST", r101, r102, r103);
    }
}
