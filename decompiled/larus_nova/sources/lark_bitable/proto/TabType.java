package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TabType extends Enum<TabType> implements WireEnum {
    private static final /* synthetic */ TabType[] $VALUES = null;
    public static final ProtoAdapter<TabType> ADAPTER = null;
    public static final TabType VAR_TAB_TYPE_MAIN = null;
    public static final TabType VAR_TAB_TYPE_STAGE = null;
    private final int value;

    static {
        TabType r100 = new TabType("VAR_TAB_TYPE_MAIN", 0, 0);
        VAR_TAB_TYPE_MAIN = r100;
        TabType r101 = new TabType("VAR_TAB_TYPE_STAGE", 1, 1);
        VAR_TAB_TYPE_STAGE = r101;
        $VALUES = new TabType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(TabType.class);
    }

    public static TabType[] values() {
        return (TabType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TabType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_TAB_TYPE_STAGE;
    L10:
        return VAR_TAB_TYPE_MAIN;
    }

    public static TabType valueOf(String r100) {
        return (TabType) a.a(TabType.class, r100);
    }

    private TabType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
