package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyFmpScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NONE_SHOW", "ONLY_DIAMOND", "ONLY_FEED", "BOTH_SHOW", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyFmpScene extends Enum<NearbyFmpScene> {
    public static final NearbyFmpScene BOTH_SHOW = null;
    public static final NearbyFmpScene NONE_SHOW = null;
    public static final NearbyFmpScene ONLY_DIAMOND = null;
    public static final NearbyFmpScene ONLY_FEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyFmpScene[] f258828a = null;
    private final String value;

    public static NearbyFmpScene valueOf(String r100) {
        return (NearbyFmpScene) r27.a.a(NearbyFmpScene.class, r100);
    }

    public static NearbyFmpScene[] values() {
        return (NearbyFmpScene[]) f258828a.clone();
    }

    static {
        NearbyFmpScene r100 = new NearbyFmpScene("NONE_SHOW", 0, "1");
        NONE_SHOW = r100;
        NearbyFmpScene r101 = new NearbyFmpScene("ONLY_DIAMOND", 1, "2");
        ONLY_DIAMOND = r101;
        NearbyFmpScene r102 = new NearbyFmpScene("ONLY_FEED", 2, "3");
        ONLY_FEED = r102;
        NearbyFmpScene r103 = new NearbyFmpScene("BOTH_SHOW", 3, "4");
        BOTH_SHOW = r103;
        f258828a = new NearbyFmpScene[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public NearbyFmpScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
