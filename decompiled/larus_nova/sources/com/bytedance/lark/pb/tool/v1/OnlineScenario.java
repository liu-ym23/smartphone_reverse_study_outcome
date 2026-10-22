package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum OnlineScenario extends Enum<OnlineScenario> implements WireEnum {
    private static final /* synthetic */ OnlineScenario[] $VALUES = null;
    public static final ProtoAdapter<OnlineScenario> ADAPTER = null;
    public static final OnlineScenario FIRST_TIME_LOGIN = null;
    public static final OnlineScenario NORMAL = null;
    public static final OnlineScenario VERSION_CHANGED = null;
    private final int value;

    static {
        OnlineScenario r100 = new OnlineScenario(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        OnlineScenario r101 = new OnlineScenario("VERSION_CHANGED", 1, 1);
        VERSION_CHANGED = r101;
        OnlineScenario r102 = new OnlineScenario("FIRST_TIME_LOGIN", 2, 2);
        FIRST_TIME_LOGIN = r102;
        $VALUES = new OnlineScenario[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(OnlineScenario.class);
    }

    public static OnlineScenario[] values() {
        return (OnlineScenario[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static OnlineScenario fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return FIRST_TIME_LOGIN;
    L12:
        return VERSION_CHANGED;
    L14:
        return NORMAL;
    }

    public static OnlineScenario valueOf(String r100) {
        return (OnlineScenario) a.a(OnlineScenario.class, r100);
    }

    private OnlineScenario(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
