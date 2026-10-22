package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.strategy.liveio.LiveIOEngine;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class CharacterFetchStrategy extends BaseSmartStrategy {
    private static final String TAG = "CharacterFetchStrategy";
    private static volatile CharacterFetchStrategy sInstance;

    public static CharacterFetchStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CharacterFetchStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CharacterFetchStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CharacterFetchStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CharacterFetchStrategy() {
        this.mStrategyName = "live_stream_strategy_character_fetch";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_character_fetch";
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        Objects.toString(r100);
        LiveIOEngine r101 = LiveStrategyManager.mLiveIOEngine;
        if (r101 == null) goto L6;
        if (r100 == null) goto L6;
        r101.notifyCharacterChange(r100.toString());
    L6:
        return r100;
    }
}
