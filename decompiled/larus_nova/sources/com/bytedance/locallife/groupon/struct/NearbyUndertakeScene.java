package com.bytedance.locallife.groupon.struct;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyUndertakeScene;", "", AccountType.ALL, "FULL", "DUAL", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyUndertakeScene extends Enum<NearbyUndertakeScene> {
    public static final NearbyUndertakeScene ALL = null;
    public static final NearbyUndertakeScene DUAL = null;
    public static final NearbyUndertakeScene FULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyUndertakeScene[] f258835a = null;

    public static NearbyUndertakeScene valueOf(String r100) {
        return (NearbyUndertakeScene) r27.a.a(NearbyUndertakeScene.class, r100);
    }

    public static NearbyUndertakeScene[] values() {
        return (NearbyUndertakeScene[]) f258835a.clone();
    }

    static {
        NearbyUndertakeScene r100 = new NearbyUndertakeScene(AccountType.ALL, 0);
        ALL = r100;
        NearbyUndertakeScene r101 = new NearbyUndertakeScene("FULL", 1);
        FULL = r101;
        NearbyUndertakeScene r102 = new NearbyUndertakeScene("DUAL", 2);
        DUAL = r102;
        f258835a = new NearbyUndertakeScene[]{r100, r101, r102};
    }

    public NearbyUndertakeScene(String r100, int r101) {
        super(r100, r101);
    }
}
