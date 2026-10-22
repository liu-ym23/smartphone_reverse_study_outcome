package com.bytedance.map.api.cache;

import com.bytedance.map.api.MapInitConfig;

/* JADX INFO: loaded from: classes21.dex */
public interface ReusableMapService {
    void destroyForReal();

    boolean isReusableReady();

    void prepareForReuse(MapInitConfig r100);

    void releaseForReuse();
}
