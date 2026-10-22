package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ThreadState extends Enum<ThreadState> implements WireEnum {
    private static final /* synthetic */ ThreadState[] $VALUES = null;
    public static final ProtoAdapter<ThreadState> ADAPTER = null;
    public static final ThreadState CLOSED = null;
    public static final ThreadState OPEN = null;
    public static final ThreadState UNKNOWN_STATE = null;
    private final int value;

    static {
        ThreadState r100 = new ThreadState("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r100;
        ThreadState r101 = new ThreadState("OPEN", 1, 1);
        OPEN = r101;
        ThreadState r102 = new ThreadState(com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode.CLOSED, 2, 2);
        CLOSED = r102;
        $VALUES = new ThreadState[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ThreadState.class);
    }

    public static ThreadState[] values() {
        return (ThreadState[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ThreadState fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return CLOSED;
    L12:
        return OPEN;
    L14:
        return UNKNOWN_STATE;
    }

    public static ThreadState valueOf(String r100) {
        return (ThreadState) a.a(ThreadState.class, r100);
    }

    private ThreadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
