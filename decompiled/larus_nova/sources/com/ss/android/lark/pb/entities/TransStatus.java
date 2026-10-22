package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TransStatus extends Enum<TransStatus> implements WireEnum {
    private static final /* synthetic */ TransStatus[] $VALUES = null;
    public static final TransStatus ABORT_BY_RECEIVER = null;
    public static final TransStatus ABORT_BY_SENDER = null;
    public static final TransStatus ACCEPT = null;
    public static final ProtoAdapter<TransStatus> ADAPTER = null;
    public static final TransStatus CANCEL = null;
    public static final TransStatus CANCEL_BY_RECEIVER = null;
    public static final TransStatus OFFLINE_MODE = null;
    public static final TransStatus PENDING = null;
    public static final TransStatus REFUSE = null;
    public static final TransStatus TRANS_DONE = null;
    private final int value;

    static {
        TransStatus r100 = new TransStatus("PENDING", 0, 0);
        PENDING = r100;
        TransStatus r101 = new TransStatus("ACCEPT", 1, 1);
        ACCEPT = r101;
        TransStatus r102 = new TransStatus("REFUSE", 2, 2);
        REFUSE = r102;
        TransStatus r103 = new TransStatus("CANCEL", 3, 3);
        CANCEL = r103;
        TransStatus r104 = new TransStatus("CANCEL_BY_RECEIVER", 4, 8);
        CANCEL_BY_RECEIVER = r104;
        TransStatus r105 = new TransStatus("ABORT_BY_SENDER", 5, 4);
        ABORT_BY_SENDER = r105;
        TransStatus r110 = new TransStatus("ABORT_BY_RECEIVER", 6, 5);
        ABORT_BY_RECEIVER = r110;
        TransStatus r111 = new TransStatus("TRANS_DONE", 7, 6);
        TRANS_DONE = r111;
        TransStatus r112 = new TransStatus("OFFLINE_MODE", 8, 7);
        OFFLINE_MODE = r112;
        $VALUES = new TransStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        ADAPTER = ProtoAdapter.newEnumAdapter(TransStatus.class);
    }

    public static TransStatus[] values() {
        return (TransStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TransStatus fromValue(int r100) {
        switch(r100) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CANCEL_BY_RECEIVER;
    L8:
        return OFFLINE_MODE;
    L10:
        return TRANS_DONE;
    L12:
        return ABORT_BY_RECEIVER;
    L14:
        return ABORT_BY_SENDER;
    L16:
        return CANCEL;
    L18:
        return REFUSE;
    L20:
        return ACCEPT;
    L22:
        return PENDING;
    }

    public static TransStatus valueOf(String r100) {
        return (TransStatus) a.a(TransStatus.class, r100);
    }

    private TransStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
