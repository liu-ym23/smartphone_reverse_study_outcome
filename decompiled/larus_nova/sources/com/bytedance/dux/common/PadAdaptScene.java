package com.bytedance.dux.common;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/dux/common/PadAdaptScene;", "", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "BOTTOM_NOTICE", "DIALOG", "PANEL", "INFO_PANEL", "PICKER_PANEL", "ACTION_PANEL", "FILTER_PANEL", "BASIC_PANEL", "SELECTION_PANEL", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum PadAdaptScene extends Enum<PadAdaptScene> {
    public static final PadAdaptScene ACTION_PANEL = null;
    public static final PadAdaptScene BASIC_PANEL = null;
    public static final PadAdaptScene BOTTOM_NOTICE = null;
    public static final PadAdaptScene DIALOG = null;
    public static final PadAdaptScene FILTER_PANEL = null;
    public static final PadAdaptScene INFO_PANEL = null;
    public static final PadAdaptScene PANEL = null;
    public static final PadAdaptScene PICKER_PANEL = null;
    public static final PadAdaptScene PUSH = null;
    public static final PadAdaptScene SELECTION_PANEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PadAdaptScene[] f204901a = null;

    public static PadAdaptScene valueOf(String r100) {
        return (PadAdaptScene) a.a(PadAdaptScene.class, r100);
    }

    public static PadAdaptScene[] values() {
        return (PadAdaptScene[]) f204901a.clone();
    }

    static {
        PadAdaptScene r100 = new PadAdaptScene(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0);
        PUSH = r100;
        PadAdaptScene r101 = new PadAdaptScene("BOTTOM_NOTICE", 1);
        BOTTOM_NOTICE = r101;
        PadAdaptScene r102 = new PadAdaptScene("DIALOG", 2);
        DIALOG = r102;
        PadAdaptScene r103 = new PadAdaptScene("PANEL", 3);
        PANEL = r103;
        PadAdaptScene r104 = new PadAdaptScene("INFO_PANEL", 4);
        INFO_PANEL = r104;
        PadAdaptScene r105 = new PadAdaptScene("PICKER_PANEL", 5);
        PICKER_PANEL = r105;
        PadAdaptScene r110 = new PadAdaptScene("ACTION_PANEL", 6);
        ACTION_PANEL = r110;
        PadAdaptScene r111 = new PadAdaptScene("FILTER_PANEL", 7);
        FILTER_PANEL = r111;
        PadAdaptScene r112 = new PadAdaptScene("BASIC_PANEL", 8);
        BASIC_PANEL = r112;
        PadAdaptScene r113 = new PadAdaptScene("SELECTION_PANEL", 9);
        SELECTION_PANEL = r113;
        f204901a = new PadAdaptScene[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public PadAdaptScene(String r100, int r101) {
        super(r100, r101);
    }
}
