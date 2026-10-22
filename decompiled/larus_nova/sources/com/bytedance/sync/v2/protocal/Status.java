package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes22.dex */
public final enum Status extends Enum<Status> implements WireEnum {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final ProtoAdapter<Status> ADAPTER = null;
    public static final Status InValid = null;
    public static final Status Valid = null;
    private final int value;

    static {
        Status r100 = new Status("InValid", 0, 0);
        InValid = r100;
        Status r101 = new Status("Valid", 1, 1);
        Valid = r101;
        $VALUES = new Status[]{r100, r101};
        ADAPTER = new ProtoAdapter_Status();
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static Status fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return Valid;
    L10:
        return InValid;
    }

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    private Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
