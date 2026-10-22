package com.bytedance.vcloud.abrmodule;

import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface IBitrateSelector {
    ABRResult predictBitrate(IPlayStateSupplier r100);

    ABRResult predictStartupBitrate(IPlayStateSupplier r100);

    void release();

    void setMediaInfo(Map<String, IVideoStream> r100, Map<String, IAudioStream> r101);
}
