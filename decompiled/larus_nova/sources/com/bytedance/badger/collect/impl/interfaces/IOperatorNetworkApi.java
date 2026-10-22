package com.bytedance.badger.collect.impl.interfaces;

import android.net.Network;
import com.bytedance.badger.collect.impl.model.TTResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IOperatorNetworkApi {
    TTResponse get(Network r100, String r101, Map<String, String> r102) throws Exception;

    TTResponse post(Network r100, String r101, Map<String, String> r102, byte[] r103) throws Exception;
}
