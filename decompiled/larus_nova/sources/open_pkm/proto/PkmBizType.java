package open_pkm.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PkmBizType extends Enum<PkmBizType> implements WireEnum {
    private static final /* synthetic */ PkmBizType[] $VALUES = null;
    public static final ProtoAdapter<PkmBizType> ADAPTER = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_BASE = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_BLOCK = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_DYNAMIC_COMPONENT = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_GADGET = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_JSSDK = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_JSSDK_BLOCK = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_JSSDK_MSG_CARD = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_UNKNOWN = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_WEB_APP = null;
    public static final PkmBizType VAR_PKM_BIZ_TYPE_WIDGET = null;
    private final int value;

    static {
        PkmBizType r100 = new PkmBizType("VAR_PKM_BIZ_TYPE_UNKNOWN", 0, 0);
        VAR_PKM_BIZ_TYPE_UNKNOWN = r100;
        PkmBizType r101 = new PkmBizType("VAR_PKM_BIZ_TYPE_GADGET", 1, 1);
        VAR_PKM_BIZ_TYPE_GADGET = r101;
        PkmBizType r102 = new PkmBizType("VAR_PKM_BIZ_TYPE_WEB_APP", 2, 2);
        VAR_PKM_BIZ_TYPE_WEB_APP = r102;
        PkmBizType r103 = new PkmBizType("VAR_PKM_BIZ_TYPE_WIDGET", 3, 3);
        VAR_PKM_BIZ_TYPE_WIDGET = r103;
        PkmBizType r104 = new PkmBizType("VAR_PKM_BIZ_TYPE_BLOCK", 4, 4);
        VAR_PKM_BIZ_TYPE_BLOCK = r104;
        PkmBizType r105 = new PkmBizType("VAR_PKM_BIZ_TYPE_DYNAMIC_COMPONENT", 5, 5);
        VAR_PKM_BIZ_TYPE_DYNAMIC_COMPONENT = r105;
        PkmBizType r110 = new PkmBizType("VAR_PKM_BIZ_TYPE_JSSDK", 6, 6);
        VAR_PKM_BIZ_TYPE_JSSDK = r110;
        PkmBizType r111 = new PkmBizType("VAR_PKM_BIZ_TYPE_JSSDK_BLOCK", 7, 7);
        VAR_PKM_BIZ_TYPE_JSSDK_BLOCK = r111;
        PkmBizType r112 = new PkmBizType("VAR_PKM_BIZ_TYPE_JSSDK_MSG_CARD", 8, 8);
        VAR_PKM_BIZ_TYPE_JSSDK_MSG_CARD = r112;
        PkmBizType r113 = new PkmBizType("VAR_PKM_BIZ_TYPE_BASE", 9, 9);
        VAR_PKM_BIZ_TYPE_BASE = r113;
        $VALUES = new PkmBizType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(PkmBizType.class);
    }

    public static PkmBizType[] values() {
        return (PkmBizType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PkmBizType fromValue(int r100) {
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
        return VAR_PKM_BIZ_TYPE_BASE;
    L8:
        return VAR_PKM_BIZ_TYPE_JSSDK_MSG_CARD;
    L10:
        return VAR_PKM_BIZ_TYPE_JSSDK_BLOCK;
    L12:
        return VAR_PKM_BIZ_TYPE_JSSDK;
    L14:
        return VAR_PKM_BIZ_TYPE_DYNAMIC_COMPONENT;
    L16:
        return VAR_PKM_BIZ_TYPE_BLOCK;
    L18:
        return VAR_PKM_BIZ_TYPE_WIDGET;
    L20:
        return VAR_PKM_BIZ_TYPE_WEB_APP;
    L22:
        return VAR_PKM_BIZ_TYPE_GADGET;
    L24:
        return VAR_PKM_BIZ_TYPE_UNKNOWN;
    }

    public static PkmBizType valueOf(String r100) {
        return (PkmBizType) a.a(PkmBizType.class, r100);
    }

    private PkmBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
