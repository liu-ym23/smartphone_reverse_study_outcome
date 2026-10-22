package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum HomepageListType extends Enum<HomepageListType> implements WireEnum {
    private static final /* synthetic */ HomepageListType[] $VALUES = null;
    public static final ProtoAdapter<HomepageListType> ADAPTER = null;
    public static final HomepageListType VAR_HOMEPAGE_LIST_TYPE_FAVORITE = null;
    public static final HomepageListType VAR_HOMEPAGE_LIST_TYPE_PIN = null;
    public static final HomepageListType VAR_HOMEPAGE_LIST_TYPE_RECENT = null;
    public static final HomepageListType VAR_HOMEPAGE_LIST_TYPE_UNKNOWN = null;
    public static final HomepageListType VAR_HOMEPAGE_LIST_TYPE_WORKSPACE = null;
    private final int value;

    static {
        HomepageListType r100 = new HomepageListType("VAR_HOMEPAGE_LIST_TYPE_RECENT", 0, 0);
        VAR_HOMEPAGE_LIST_TYPE_RECENT = r100;
        HomepageListType r101 = new HomepageListType("VAR_HOMEPAGE_LIST_TYPE_PIN", 1, 1);
        VAR_HOMEPAGE_LIST_TYPE_PIN = r101;
        HomepageListType r102 = new HomepageListType("VAR_HOMEPAGE_LIST_TYPE_FAVORITE", 2, 2);
        VAR_HOMEPAGE_LIST_TYPE_FAVORITE = r102;
        HomepageListType r103 = new HomepageListType("VAR_HOMEPAGE_LIST_TYPE_WORKSPACE", 3, 3);
        VAR_HOMEPAGE_LIST_TYPE_WORKSPACE = r103;
        HomepageListType r104 = new HomepageListType("VAR_HOMEPAGE_LIST_TYPE_UNKNOWN", 4, 4);
        VAR_HOMEPAGE_LIST_TYPE_UNKNOWN = r104;
        $VALUES = new HomepageListType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(HomepageListType.class);
    }

    public static HomepageListType[] values() {
        return (HomepageListType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static HomepageListType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return VAR_HOMEPAGE_LIST_TYPE_UNKNOWN;
    L16:
        return VAR_HOMEPAGE_LIST_TYPE_WORKSPACE;
    L18:
        return VAR_HOMEPAGE_LIST_TYPE_FAVORITE;
    L20:
        return VAR_HOMEPAGE_LIST_TYPE_PIN;
    L22:
        return VAR_HOMEPAGE_LIST_TYPE_RECENT;
    }

    public static HomepageListType valueOf(String r100) {
        return (HomepageListType) a.a(HomepageListType.class, r100);
    }

    private HomepageListType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
