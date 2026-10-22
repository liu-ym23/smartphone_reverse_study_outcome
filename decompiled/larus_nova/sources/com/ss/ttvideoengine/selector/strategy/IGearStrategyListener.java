package com.ss.ttvideoengine.selector.strategy;

import com.ss.ttvideoengine.model.IVideoModel;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface IGearStrategyListener {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.selector.strategy.IGearStrategyListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAfterSelect(IGearStrategyListener r100, IVideoModel r101, Map r102, int r103, Object r104) {
        }

        public static void $default$onBeforeSelect(IGearStrategyListener r100, IVideoModel r101, Map r102, int r103, Object r104) {
        }

        public static Map $default$selectBitrate(IGearStrategyListener r100, IVideoModel r101, Map r102, int r103) {
            return null;
        }
    }

    void onAfterSelect(IVideoModel r100, Map<String, String> r101, int r102, Object r103);

    void onBeforeSelect(IVideoModel r100, Map<String, String> r101, int r102, Object r103);

    Map<String, Integer> selectBitrate(IVideoModel r100, Map<String, String> r101, int r102);
}
