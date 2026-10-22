package com.bytedance.push.pull;

import com.bytedance.android.service.manager.push.PushExternalService;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum PullScene extends Enum<PullScene> {
    public static final PullScene SCENE_COLD_LAUNCH = null;
    public static final PullScene SCENE_SWITCH_TO_BACKGROUND = null;
    public static final PullScene SCENE_SWITCH_TO_FOREGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PullScene[] f267008a = null;
    public String sceneStr;

    static {
        PullScene r100 = new PullScene("SCENE_COLD_LAUNCH", 0, PushExternalService.SIGNAL_SCENE_APP_LAUNCH);
        SCENE_COLD_LAUNCH = r100;
        PullScene r101 = new PullScene("SCENE_SWITCH_TO_BACKGROUND", 1, "switch_to_background");
        SCENE_SWITCH_TO_BACKGROUND = r101;
        PullScene r102 = new PullScene("SCENE_SWITCH_TO_FOREGROUND", 2, "switch_to_foreground");
        SCENE_SWITCH_TO_FOREGROUND = r102;
        f267008a = new PullScene[]{r100, r101, r102};
    }

    public static PullScene[] values() {
        return (PullScene[]) f267008a.clone();
    }

    public static PullScene valueOf(String r100) {
        return (PullScene) a.a(PullScene.class, r100);
    }

    public PullScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.sceneStr = r102;
    }
}
