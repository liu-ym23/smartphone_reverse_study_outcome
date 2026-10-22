package lark_biz_feed.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum LarkFeedListViewObjectFieldType extends Enum<LarkFeedListViewObjectFieldType> implements WireEnum {
    private static final /* synthetic */ LarkFeedListViewObjectFieldType[] $VALUES = null;
    public static final ProtoAdapter<LarkFeedListViewObjectFieldType> ADAPTER = null;
    public static final LarkFeedListViewObjectFieldType VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_CAN_LOAD_MORE = null;
    public static final LarkFeedListViewObjectFieldType VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_LOAD_STATUS = null;
    public static final LarkFeedListViewObjectFieldType VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_TOAST_STATUS = null;
    private final int value;

    static {
        LarkFeedListViewObjectFieldType r100 = new LarkFeedListViewObjectFieldType("VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_LOAD_STATUS", 0, 0);
        VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_LOAD_STATUS = r100;
        LarkFeedListViewObjectFieldType r101 = new LarkFeedListViewObjectFieldType("VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_TOAST_STATUS", 1, 1);
        VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_TOAST_STATUS = r101;
        LarkFeedListViewObjectFieldType r102 = new LarkFeedListViewObjectFieldType("VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_CAN_LOAD_MORE", 2, 2);
        VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_CAN_LOAD_MORE = r102;
        $VALUES = new LarkFeedListViewObjectFieldType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(LarkFeedListViewObjectFieldType.class);
    }

    public static LarkFeedListViewObjectFieldType[] values() {
        return (LarkFeedListViewObjectFieldType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LarkFeedListViewObjectFieldType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_CAN_LOAD_MORE;
    L12:
        return VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_TOAST_STATUS;
    L14:
        return VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_LOAD_STATUS;
    }

    public static LarkFeedListViewObjectFieldType valueOf(String r100) {
        return (LarkFeedListViewObjectFieldType) a.a(LarkFeedListViewObjectFieldType.class, r100);
    }

    private LarkFeedListViewObjectFieldType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
