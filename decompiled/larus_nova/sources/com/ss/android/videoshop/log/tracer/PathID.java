package com.ss.android.videoshop.log.tracer;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PathID extends Enum<PathID> {
    public static final PathID ENTER_FULLSCREEN = null;
    public static final PathID EXIT_FULLSCREEN = null;
    public static final PathID KEEP_SCREEN = null;
    public static final PathID PLAY = null;
    public static final PathID SEEK = null;
    public static final PathID TEXTURE_SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PathID[] f455984a = null;

    static {
        PathID r100 = new PathID(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0);
        PLAY = r100;
        PathID r101 = new PathID("SEEK", 1);
        SEEK = r101;
        PathID r102 = new PathID("ENTER_FULLSCREEN", 2);
        ENTER_FULLSCREEN = r102;
        PathID r103 = new PathID("EXIT_FULLSCREEN", 3);
        EXIT_FULLSCREEN = r103;
        PathID r104 = new PathID("TEXTURE_SIZE", 4);
        TEXTURE_SIZE = r104;
        PathID r105 = new PathID("KEEP_SCREEN", 5);
        KEEP_SCREEN = r105;
        f455984a = new PathID[]{r100, r101, r102, r103, r104, r105};
    }

    public static PathID[] values() {
        return (PathID[]) f455984a.clone();
    }

    public static PathID valueOf(String r100) {
        return (PathID) a.a(PathID.class, r100);
    }

    public PathID(String r100, int r101) {
        super(r100, r101);
    }
}
