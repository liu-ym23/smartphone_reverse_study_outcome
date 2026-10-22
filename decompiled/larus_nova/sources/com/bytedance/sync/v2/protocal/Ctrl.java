package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum Ctrl extends Enum<Ctrl> implements WireEnum {
    private static final /* synthetic */ Ctrl[] $VALUES = null;
    public static final ProtoAdapter<Ctrl> ADAPTER = null;
    public static final Ctrl Default = null;
    public static final Ctrl HeartbeatPong = null;
    public static final Ctrl HttpPoll = null;
    private final int value;

    static {
        Ctrl r100 = new Ctrl("Default", 0, 0);
        Default = r100;
        Ctrl r101 = new Ctrl("HttpPoll", 1, 1);
        HttpPoll = r101;
        Ctrl r102 = new Ctrl("HeartbeatPong", 2, 2);
        HeartbeatPong = r102;
        $VALUES = new Ctrl[]{r100, r101, r102};
        ADAPTER = new ProtoAdapter_Ctrl();
    }

    public static Ctrl[] values() {
        return (Ctrl[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static Ctrl fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return HeartbeatPong;
    L12:
        return HttpPoll;
    L14:
        return Default;
    }

    public static Ctrl valueOf(String r100) {
        return (Ctrl) r27.a.a(Ctrl.class, r100);
    }

    private Ctrl(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
