package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SubscribeStatusCode extends Enum<SubscribeStatusCode> implements WireEnum {
    private static final /* synthetic */ SubscribeStatusCode[] $VALUES = null;
    public static final ProtoAdapter<SubscribeStatusCode> ADAPTER = null;
    public static final SubscribeStatusCode AUTH_FAIL = null;
    public static final SubscribeStatusCode SERVER_ERROR = null;
    public static final SubscribeStatusCode SUCCESS = null;
    private final int value;

    static {
        SubscribeStatusCode r100 = new SubscribeStatusCode("SUCCESS", 0, 0);
        SUCCESS = r100;
        SubscribeStatusCode r101 = new SubscribeStatusCode("AUTH_FAIL", 1, 1);
        AUTH_FAIL = r101;
        SubscribeStatusCode r102 = new SubscribeStatusCode("SERVER_ERROR", 2, 2);
        SERVER_ERROR = r102;
        $VALUES = new SubscribeStatusCode[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SubscribeStatusCode.class);
    }

    public static SubscribeStatusCode[] values() {
        return (SubscribeStatusCode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SubscribeStatusCode fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return SERVER_ERROR;
    L12:
        return AUTH_FAIL;
    L14:
        return SUCCESS;
    }

    public static SubscribeStatusCode valueOf(String r100) {
        return (SubscribeStatusCode) a.a(SubscribeStatusCode.class, r100);
    }

    private SubscribeStatusCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
