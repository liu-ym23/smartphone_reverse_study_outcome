package com.bytedance.bdp.bdpbase.core;

import com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadEntity;
import com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadListener;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpApp extends IBdpApp {
    int[] getBdpAppTechTypes();

    void open(String r100, BdpStartUpParam r101, BdpAppStatusListener r102);

    void preload(BdpAppPreloadEntity r100, Map<String, String> r101, BdpAppPreloadListener r102);
}
