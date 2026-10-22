package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum TopicStatus extends Enum<TopicStatus> implements WireEnum {
    private static final /* synthetic */ TopicStatus[] $VALUES = null;
    public static final ProtoAdapter<TopicStatus> ADAPTER = null;
    public static final TopicStatus Active = null;
    public static final TopicStatus Closed = null;
    public static final TopicStatus NotExist = null;
    private final int value;

    static {
        TopicStatus r100 = new TopicStatus("NotExist", 0, 0);
        NotExist = r100;
        TopicStatus r101 = new TopicStatus("Active", 1, 1);
        Active = r101;
        TopicStatus r102 = new TopicStatus("Closed", 2, 2);
        Closed = r102;
        $VALUES = new TopicStatus[]{r100, r101, r102};
        ADAPTER = new ProtoAdapter_TopicStatus();
    }

    public static TopicStatus[] values() {
        return (TopicStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static TopicStatus fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return Closed;
    L12:
        return Active;
    L14:
        return NotExist;
    }

    public static TopicStatus valueOf(String r100) {
        return (TopicStatus) r27.a.a(TopicStatus.class, r100);
    }

    private TopicStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
