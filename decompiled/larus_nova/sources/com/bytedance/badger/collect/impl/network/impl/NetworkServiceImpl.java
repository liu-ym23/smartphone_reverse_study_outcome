package com.bytedance.badger.collect.impl.network.impl;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.network.interfaces.INetWorkService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class NetworkServiceImpl implements INetWorkService {
    private final List<IChainHandler> handlers;

    private Map<String, String> buildCommonHeader() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", "application/json; charset=utf-8");
        return r100;
    }

    public NetworkServiceImpl() {
        ArrayList r100 = new ArrayList();
        this.handlers = r100;
        r100.add(new RequestBuildHandler());
        r100.add(new RequestExecutorHandler());
    }

    private TTResponse execute(TTRequest r100) {
        return new ChainImpl(this.handlers, 0, r100).process(r100);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.INetWorkService
    public TTResponse fetchMobilePseudoCodeSign(String r100, Map<String, String> r110, NetworkMethodEnum r111, Map<String, String> r112) throws Exception {
        return execute(new TTRequest(true, r100, r111, buildCommonHeader(), r110, r112));
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.INetWorkService
    public TTResponse fetchMobilePseudoCodeToken(Network r110, String r111, Map<String, String> r112, NetworkMethodEnum r210, Map<String, String> r211) throws Exception {
        if (r110 == null) goto L4;
        TTRequest r100 = new TTRequest(r111, true, r110, r210, buildCommonHeader(), r112, r211);
    L6:
        return execute(r100);
    L4:
        r100 = new TTRequest(true, r111, r210, buildCommonHeader(), r112, r211);
        goto L6
    }
}
