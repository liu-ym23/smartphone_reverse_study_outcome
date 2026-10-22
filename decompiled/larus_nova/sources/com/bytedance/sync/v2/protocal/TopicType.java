package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum TopicType extends Enum<TopicType> implements WireEnum {
    private static final /* synthetic */ TopicType[] $VALUES = null;
    public static final ProtoAdapter<TopicType> ADAPTER = null;
    public static final TopicType CustomTopic = null;
    public static final TopicType GlobalTopic = null;
    public static final TopicType SpecTopic = null;
    private final int value;

    static {
        TopicType r100 = new TopicType("SpecTopic", 0, 0);
        SpecTopic = r100;
        TopicType r101 = new TopicType("GlobalTopic", 1, 1);
        GlobalTopic = r101;
        TopicType r102 = new TopicType("CustomTopic", 2, 2);
        CustomTopic = r102;
        $VALUES = new TopicType[]{r100, r101, r102};
        ADAPTER = new ProtoAdapter_TopicType();
    }

    public static TopicType[] values() {
        return (TopicType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static TopicType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return CustomTopic;
    L12:
        return GlobalTopic;
    L14:
        return SpecTopic;
    }

    public static TopicType valueOf(String r100) {
        return (TopicType) r27.a.a(TopicType.class, r100);
    }

    private TopicType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
