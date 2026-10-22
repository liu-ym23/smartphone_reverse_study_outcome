package com.bytedance.badger.collect.impl.interfaces;

import com.bytedance.badger.collect.impl.model.TTResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface INetworkApi {
    TTResponse get(String r100, Map<String, String> r101) throws Exception;

    TTResponse post(String r100, Map<String, String> r101, Map<String, String> r102) throws Exception;
}
