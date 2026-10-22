package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum QueryIntentionType extends Enum<QueryIntentionType> implements WireEnum {
    private static final /* synthetic */ QueryIntentionType[] $VALUES = null;
    public static final ProtoAdapter<QueryIntentionType> ADAPTER = null;
    public static final QueryIntentionType ANSWER_IN_SEARCH_QUESTION = null;
    public static final QueryIntentionType UNKNOWN_TYPE = null;
    private final int value;

    static {
        QueryIntentionType r100 = new QueryIntentionType("UNKNOWN_TYPE", 0, 0);
        UNKNOWN_TYPE = r100;
        QueryIntentionType r101 = new QueryIntentionType("ANSWER_IN_SEARCH_QUESTION", 1, 1);
        ANSWER_IN_SEARCH_QUESTION = r101;
        $VALUES = new QueryIntentionType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(QueryIntentionType.class);
    }

    public static QueryIntentionType[] values() {
        return (QueryIntentionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static QueryIntentionType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return ANSWER_IN_SEARCH_QUESTION;
    L10:
        return UNKNOWN_TYPE;
    }

    public static QueryIntentionType valueOf(String r100) {
        return (QueryIntentionType) a.a(QueryIntentionType.class, r100);
    }

    private QueryIntentionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
