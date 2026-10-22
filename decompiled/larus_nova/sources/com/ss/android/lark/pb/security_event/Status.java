package com.ss.android.lark.pb.security_event;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum Status extends Enum<Status> implements WireEnum {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final ProtoAdapter<Status> ADAPTER = null;
    public static final Status Fail = null;
    public static final Status Success = null;
    private final int value;

    static {
        Status r100 = new Status("Success", 0, 0);
        Success = r100;
        Status r101 = new Status(CheckStatus.FAIL, 1, 1);
        Fail = r101;
        $VALUES = new Status[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Status fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return Fail;
    L10:
        return Success;
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    private Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
