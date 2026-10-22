package com.bytedance.badger.collect.impl.network.interfaces;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.model.TTResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface INetWorkService {
    TTResponse fetchMobilePseudoCodeSign(String r100, Map<String, String> r101, NetworkMethodEnum r102, Map<String, String> r103) throws Exception;

    TTResponse fetchMobilePseudoCodeToken(Network r100, String r101, Map<String, String> r102, NetworkMethodEnum r103, Map<String, String> r104) throws Exception;
}
