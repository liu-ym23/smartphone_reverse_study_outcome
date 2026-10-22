package com.bytedance.locallife.live.msgcenter.interfaces;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/live/msgcenter/interfaces/ReleaseScene;", "", "EXIT_ROOM", "DEFAULT", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum ReleaseScene extends Enum<ReleaseScene> {
    public static final ReleaseScene DEFAULT = null;
    public static final ReleaseScene EXIT_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReleaseScene[] f260631a = null;

    public static ReleaseScene valueOf(String r100) {
        return (ReleaseScene) a.a(ReleaseScene.class, r100);
    }

    public static ReleaseScene[] values() {
        return (ReleaseScene[]) f260631a.clone();
    }

    static {
        ReleaseScene r100 = new ReleaseScene("EXIT_ROOM", 0);
        EXIT_ROOM = r100;
        ReleaseScene r101 = new ReleaseScene("DEFAULT", 1);
        DEFAULT = r101;
        f260631a = new ReleaseScene[]{r100, r101};
    }

    public ReleaseScene(String r100, int r101) {
        super(r100, r101);
    }
}
