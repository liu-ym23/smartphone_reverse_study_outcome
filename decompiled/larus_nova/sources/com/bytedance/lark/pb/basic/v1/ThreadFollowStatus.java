package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ThreadFollowStatus extends Enum<ThreadFollowStatus> implements WireEnum {
    private static final /* synthetic */ ThreadFollowStatus[] $VALUES = null;
    public static final ProtoAdapter<ThreadFollowStatus> ADAPTER = null;
    public static final ThreadFollowStatus FOLLOWING = null;
    public static final ThreadFollowStatus LOADING = null;
    public static final ThreadFollowStatus NOT_FOLLOWING = null;
    public static final ThreadFollowStatus UNKNOWN_STATUS = null;
    private final int value;

    static {
        ThreadFollowStatus r100 = new ThreadFollowStatus("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r100;
        ThreadFollowStatus r101 = new ThreadFollowStatus("NOT_FOLLOWING", 1, 1);
        NOT_FOLLOWING = r101;
        ThreadFollowStatus r102 = new ThreadFollowStatus("FOLLOWING", 2, 2);
        FOLLOWING = r102;
        ThreadFollowStatus r103 = new ThreadFollowStatus("LOADING", 3, 3);
        LOADING = r103;
        $VALUES = new ThreadFollowStatus[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ThreadFollowStatus.class);
    }

    public static ThreadFollowStatus[] values() {
        return (ThreadFollowStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ThreadFollowStatus fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return LOADING;
    L14:
        return FOLLOWING;
    L16:
        return NOT_FOLLOWING;
    L18:
        return UNKNOWN_STATUS;
    }

    public static ThreadFollowStatus valueOf(String r100) {
        return (ThreadFollowStatus) a.a(ThreadFollowStatus.class, r100);
    }

    private ThreadFollowStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
