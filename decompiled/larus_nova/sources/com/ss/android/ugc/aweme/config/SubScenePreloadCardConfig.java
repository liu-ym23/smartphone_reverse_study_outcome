package com.ss.android.ugc.aweme.config;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/config/SubScenePreloadCardConfig;", "Ljava/io/Serializable;", "()V", "preloadCardConfigs", "", "Lcom/ss/android/ugc/aweme/config/PreloadCardConfig;", "getPreloadCardConfigs", "()Ljava/util/Set;", "subScene", "", "getSubScene", "()Ljava/lang/String;", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SubScenePreloadCardConfig implements Serializable {

    @SerializedName("preload_cards")
    private final Set<PreloadCardConfig> preloadCardConfigs;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    private final String subScene;

    public SubScenePreloadCardConfig() {
    }

    public final Set<PreloadCardConfig> getPreloadCardConfigs() {
        return this.preloadCardConfigs;
    }

    public final String getSubScene() {
        return this.subScene;
    }
}
