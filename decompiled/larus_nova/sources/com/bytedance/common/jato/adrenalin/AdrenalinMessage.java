package com.bytedance.common.jato.adrenalin;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum AdrenalinMessage extends Enum<AdrenalinMessage> {
    private static final /* synthetic */ AdrenalinMessage[] $VALUES = null;
    public static final AdrenalinMessage FORCE_STOP = null;
    public static final AdrenalinMessage START = null;
    public static final AdrenalinMessage STOP = null;
    int value;

    static {
        AdrenalinMessage r100 = new AdrenalinMessage(GXAnimation.STATE_START, 0, 100);
        START = r100;
        AdrenalinMessage r101 = new AdrenalinMessage("STOP", 1, 101);
        STOP = r101;
        AdrenalinMessage r102 = new AdrenalinMessage("FORCE_STOP", 2, 102);
        FORCE_STOP = r102;
        $VALUES = new AdrenalinMessage[]{r100, r101, r102};
    }

    public static AdrenalinMessage[] values() {
        return (AdrenalinMessage[]) $VALUES.clone();
    }

    public static AdrenalinMessage valueOf(String r100) {
        return (AdrenalinMessage) a.a(AdrenalinMessage.class, r100);
    }

    private AdrenalinMessage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
