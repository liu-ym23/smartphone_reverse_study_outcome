package com.bytedance.live.livelink.kmp.api.base.config;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/config/Character;", "", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "GUEST", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Character extends Enum<Character> {
    public static final Character ANCHOR = null;
    public static final Character GUEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Character[] f255216a = null;

    static {
        Character r100 = new Character(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 0);
        ANCHOR = r100;
        Character r101 = new Character("GUEST", 1);
        GUEST = r101;
        f255216a = new Character[]{r100, r101};
    }

    public static Character valueOf(String r100) {
        return (Character) a.a(Character.class, r100);
    }

    public static Character[] values() {
        return (Character[]) f255216a.clone();
    }

    public Character(String r100, int r101) {
        super(r100, r101);
    }
}
