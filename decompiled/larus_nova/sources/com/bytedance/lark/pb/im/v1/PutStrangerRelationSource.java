package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum PutStrangerRelationSource extends Enum<PutStrangerRelationSource> implements WireEnum {
    private static final /* synthetic */ PutStrangerRelationSource[] $VALUES = null;
    public static final ProtoAdapter<PutStrangerRelationSource> ADAPTER = null;
    public static final PutStrangerRelationSource SOURCE_MESSAGE = null;
    public static final PutStrangerRelationSource SOURCE_PROFILE = null;
    public static final PutStrangerRelationSource SOURCE_UNKNOWN = null;
    private final int value;

    static {
        PutStrangerRelationSource r100 = new PutStrangerRelationSource("SOURCE_UNKNOWN", 0, 0);
        SOURCE_UNKNOWN = r100;
        PutStrangerRelationSource r101 = new PutStrangerRelationSource("SOURCE_PROFILE", 1, 1);
        SOURCE_PROFILE = r101;
        PutStrangerRelationSource r102 = new PutStrangerRelationSource("SOURCE_MESSAGE", 2, 2);
        SOURCE_MESSAGE = r102;
        $VALUES = new PutStrangerRelationSource[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(PutStrangerRelationSource.class);
    }

    public static PutStrangerRelationSource[] values() {
        return (PutStrangerRelationSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PutStrangerRelationSource fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return SOURCE_MESSAGE;
    L12:
        return SOURCE_PROFILE;
    L14:
        return SOURCE_UNKNOWN;
    }

    public static PutStrangerRelationSource valueOf(String r100) {
        return (PutStrangerRelationSource) a.a(PutStrangerRelationSource.class, r100);
    }

    private PutStrangerRelationSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
