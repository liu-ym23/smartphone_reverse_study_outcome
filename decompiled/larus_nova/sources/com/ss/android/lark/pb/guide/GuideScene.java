package com.ss.android.lark.pb.guide;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum GuideScene extends Enum<GuideScene> implements WireEnum {
    private static final /* synthetic */ GuideScene[] $VALUES = null;
    public static final ProtoAdapter<GuideScene> ADAPTER = null;
    public static final GuideScene GUIDE_SCENE_CCM = null;
    public static final GuideScene GUIDE_SCENE_UNKNOWN = null;
    private final int value;

    static {
        GuideScene r100 = new GuideScene("GUIDE_SCENE_UNKNOWN", 0, 0);
        GUIDE_SCENE_UNKNOWN = r100;
        GuideScene r101 = new GuideScene("GUIDE_SCENE_CCM", 1, 1);
        GUIDE_SCENE_CCM = r101;
        $VALUES = new GuideScene[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(GuideScene.class);
    }

    public static GuideScene[] values() {
        return (GuideScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static GuideScene fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return GUIDE_SCENE_CCM;
    L10:
        return GUIDE_SCENE_UNKNOWN;
    }

    public static GuideScene valueOf(String r100) {
        return (GuideScene) a.a(GuideScene.class, r100);
    }

    private GuideScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
