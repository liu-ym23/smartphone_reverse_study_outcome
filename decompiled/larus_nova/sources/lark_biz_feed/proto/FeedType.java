package lark_biz_feed.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FeedType extends Enum<FeedType> implements WireEnum {
    private static final /* synthetic */ FeedType[] $VALUES = null;
    public static final ProtoAdapter<FeedType> ADAPTER = null;
    public static final FeedType VAR_FEED_TYPE_ALL = null;
    public static final FeedType VAR_FEED_TYPE_DONE = null;
    public static final FeedType VAR_FEED_TYPE_INBOX = null;
    private final int value;

    static {
        FeedType r100 = new FeedType("VAR_FEED_TYPE_ALL", 0, 0);
        VAR_FEED_TYPE_ALL = r100;
        FeedType r101 = new FeedType("VAR_FEED_TYPE_INBOX", 1, 1);
        VAR_FEED_TYPE_INBOX = r101;
        FeedType r102 = new FeedType("VAR_FEED_TYPE_DONE", 2, 2);
        VAR_FEED_TYPE_DONE = r102;
        $VALUES = new FeedType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeedType.class);
    }

    public static FeedType[] values() {
        return (FeedType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeedType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return VAR_FEED_TYPE_DONE;
    L12:
        return VAR_FEED_TYPE_INBOX;
    L14:
        return VAR_FEED_TYPE_ALL;
    }

    public static FeedType valueOf(String r100) {
        return (FeedType) a.a(FeedType.class, r100);
    }

    private FeedType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
