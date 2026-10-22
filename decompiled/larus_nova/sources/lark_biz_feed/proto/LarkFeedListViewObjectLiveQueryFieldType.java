package lark_biz_feed.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum LarkFeedListViewObjectLiveQueryFieldType extends Enum<LarkFeedListViewObjectLiveQueryFieldType> implements WireEnum {
    private static final /* synthetic */ LarkFeedListViewObjectLiveQueryFieldType[] $VALUES = null;
    public static final ProtoAdapter<LarkFeedListViewObjectLiveQueryFieldType> ADAPTER = null;
    public static final LarkFeedListViewObjectLiveQueryFieldType VAR_LARK_FEED_LIST_VIEW_OBJECT_LIVE_QUERY_FIELD_TYPE_FEED_LIST = null;
    private final int value;

    static {
        LarkFeedListViewObjectLiveQueryFieldType r100 = new LarkFeedListViewObjectLiveQueryFieldType("VAR_LARK_FEED_LIST_VIEW_OBJECT_LIVE_QUERY_FIELD_TYPE_FEED_LIST", 0, 0);
        VAR_LARK_FEED_LIST_VIEW_OBJECT_LIVE_QUERY_FIELD_TYPE_FEED_LIST = r100;
        $VALUES = new LarkFeedListViewObjectLiveQueryFieldType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(LarkFeedListViewObjectLiveQueryFieldType.class);
    }

    public static LarkFeedListViewObjectLiveQueryFieldType[] values() {
        return (LarkFeedListViewObjectLiveQueryFieldType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LarkFeedListViewObjectLiveQueryFieldType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return VAR_LARK_FEED_LIST_VIEW_OBJECT_LIVE_QUERY_FIELD_TYPE_FEED_LIST;
    }

    public static LarkFeedListViewObjectLiveQueryFieldType valueOf(String r100) {
        return (LarkFeedListViewObjectLiveQueryFieldType) a.a(LarkFeedListViewObjectLiveQueryFieldType.class, r100);
    }

    private LarkFeedListViewObjectLiveQueryFieldType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
