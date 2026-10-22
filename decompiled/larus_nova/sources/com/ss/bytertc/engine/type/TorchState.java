package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum TorchState extends Enum<TorchState> {
    private static final /* synthetic */ TorchState[] $VALUES = null;
    public static final TorchState TORCH_STATE_OFF = null;
    public static final TorchState TORCH_STATE_ON = null;
    private int value;

    static {
        TorchState r100 = new TorchState("TORCH_STATE_OFF", 0, 0);
        TORCH_STATE_OFF = r100;
        TorchState r101 = new TorchState("TORCH_STATE_ON", 1, 1);
        TORCH_STATE_ON = r101;
        $VALUES = new TorchState[]{r100, r101};
    }

    public static TorchState[] values() {
        return (TorchState[]) $VALUES.clone();
    }

    public static TorchState valueOf(String r100) {
        return (TorchState) a.a(TorchState.class, r100);
    }

    private TorchState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
