package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum HomepageAction extends Enum<HomepageAction> implements WireEnum {
    private static final /* synthetic */ HomepageAction[] $VALUES = null;
    public static final ProtoAdapter<HomepageAction> ADAPTER = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_CANCEL_PIN = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_DELETE = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_LOAD_MORE = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_OPEN_BITABLE = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_OPEN_MORE = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_OPEN_SHARE = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_REFRESH = null;
    public static final HomepageAction VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE = null;
    private final int value;

    static {
        HomepageAction r100 = new HomepageAction("VAR_HOMEPAGE_ACTION_REFRESH", 0, 0);
        VAR_HOMEPAGE_ACTION_REFRESH = r100;
        HomepageAction r101 = new HomepageAction("VAR_HOMEPAGE_ACTION_LOAD_MORE", 1, 1);
        VAR_HOMEPAGE_ACTION_LOAD_MORE = r101;
        HomepageAction r102 = new HomepageAction("VAR_HOMEPAGE_ACTION_DELETE", 2, 2);
        VAR_HOMEPAGE_ACTION_DELETE = r102;
        HomepageAction r103 = new HomepageAction("VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE", 3, 3);
        VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE = r103;
        HomepageAction r104 = new HomepageAction("VAR_HOMEPAGE_ACTION_CANCEL_PIN", 4, 4);
        VAR_HOMEPAGE_ACTION_CANCEL_PIN = r104;
        HomepageAction r105 = new HomepageAction("VAR_HOMEPAGE_ACTION_OPEN_SHARE", 5, 5);
        VAR_HOMEPAGE_ACTION_OPEN_SHARE = r105;
        HomepageAction r110 = new HomepageAction("VAR_HOMEPAGE_ACTION_OPEN_MORE", 6, 6);
        VAR_HOMEPAGE_ACTION_OPEN_MORE = r110;
        HomepageAction r111 = new HomepageAction("VAR_HOMEPAGE_ACTION_OPEN_BITABLE", 7, 7);
        VAR_HOMEPAGE_ACTION_OPEN_BITABLE = r111;
        HomepageAction r112 = new HomepageAction("VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE", 8, 8);
        VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE = r112;
        HomepageAction r113 = new HomepageAction("VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL", 9, 9);
        VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL = r113;
        $VALUES = new HomepageAction[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(HomepageAction.class);
    }

    public static HomepageAction[] values() {
        return (HomepageAction[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static HomepageAction fromValue(int r100) {
        switch(r100) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL;
    L8:
        return VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE;
    L10:
        return VAR_HOMEPAGE_ACTION_OPEN_BITABLE;
    L12:
        return VAR_HOMEPAGE_ACTION_OPEN_MORE;
    L14:
        return VAR_HOMEPAGE_ACTION_OPEN_SHARE;
    L16:
        return VAR_HOMEPAGE_ACTION_CANCEL_PIN;
    L18:
        return VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE;
    L20:
        return VAR_HOMEPAGE_ACTION_DELETE;
    L22:
        return VAR_HOMEPAGE_ACTION_LOAD_MORE;
    L24:
        return VAR_HOMEPAGE_ACTION_REFRESH;
    }

    public static HomepageAction valueOf(String r100) {
        return (HomepageAction) a.a(HomepageAction.class, r100);
    }

    private HomepageAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
