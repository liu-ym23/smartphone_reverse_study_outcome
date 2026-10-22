package com.bytedance.locallife.groupon.struct.undertake;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUndertakeState;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NEARBY_CLOSE", "NEARBY_IN", "NEARBY_RESPONSE_GET", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum NearbyUndertakeState extends Enum<NearbyUndertakeState> {
    private static final /* synthetic */ NearbyUndertakeState[] $VALUES = null;
    public static final NearbyUndertakeState NEARBY_CLOSE = null;
    public static final NearbyUndertakeState NEARBY_IN = null;
    public static final NearbyUndertakeState NEARBY_RESPONSE_GET = null;
    private final int value;

    private static final /* synthetic */ NearbyUndertakeState[] $values() {
        return new NearbyUndertakeState[]{NEARBY_CLOSE, NEARBY_IN, NEARBY_RESPONSE_GET};
    }

    public static NearbyUndertakeState valueOf(String r100) {
        return (NearbyUndertakeState) a.a(NearbyUndertakeState.class, r100);
    }

    public static NearbyUndertakeState[] values() {
        return (NearbyUndertakeState[]) $VALUES.clone();
    }

    static {
        NEARBY_CLOSE = new NearbyUndertakeState("NEARBY_CLOSE", 0, 0);
        NEARBY_IN = new NearbyUndertakeState("NEARBY_IN", 1, 1);
        NEARBY_RESPONSE_GET = new NearbyUndertakeState("NEARBY_RESPONSE_GET", 2, 2);
        $VALUES = $values();
    }

    public final int getValue() {
        return this.value;
    }

    private NearbyUndertakeState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
