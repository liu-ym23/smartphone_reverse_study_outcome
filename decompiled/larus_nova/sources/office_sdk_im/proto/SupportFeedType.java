package office_sdk_im.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum SupportFeedType extends Enum<SupportFeedType> implements WireEnum {
    private static final /* synthetic */ SupportFeedType[] $VALUES = null;
    public static final ProtoAdapter<SupportFeedType> ADAPTER = null;
    public static final SupportFeedType VAR_SUPPORT_FEED_TYPE_DOUBAO_CUSTOM = null;
    private final int value;

    static {
        SupportFeedType r100 = new SupportFeedType("VAR_SUPPORT_FEED_TYPE_DOUBAO_CUSTOM", 0, 0);
        VAR_SUPPORT_FEED_TYPE_DOUBAO_CUSTOM = r100;
        $VALUES = new SupportFeedType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(SupportFeedType.class);
    }

    public static SupportFeedType[] values() {
        return (SupportFeedType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SupportFeedType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return VAR_SUPPORT_FEED_TYPE_DOUBAO_CUSTOM;
    }

    public static SupportFeedType valueOf(String r100) {
        return (SupportFeedType) a.a(SupportFeedType.class, r100);
    }

    private SupportFeedType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
