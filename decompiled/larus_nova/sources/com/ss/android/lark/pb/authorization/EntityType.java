package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType ANY = null;
    public static final EntityType CCM_BITABLE = null;
    public static final EntityType CCM_DOC = null;
    public static final EntityType CCM_FILE = null;
    public static final EntityType CCM_MINDNOTE = null;
    public static final EntityType CCM_SHEET = null;
    public static final EntityType CCM_SLIDE = null;
    public static final EntityType ENTITY_TYPE_UNKNOWN = null;
    public static final EntityType IM_FILE = null;
    public static final EntityType IM_IMAGE = null;
    public static final EntityType IM_VIDEO = null;
    public static final EntityType USER = null;
    private final int value;

    static {
        EntityType r100 = new EntityType("ENTITY_TYPE_UNKNOWN", 0, 0);
        ENTITY_TYPE_UNKNOWN = r100;
        EntityType r101 = new EntityType("ANY", 1, 1);
        ANY = r101;
        EntityType r102 = new EntityType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 2, 2);
        USER = r102;
        EntityType r103 = new EntityType("IM_IMAGE", 3, 3);
        IM_IMAGE = r103;
        EntityType r104 = new EntityType("IM_VIDEO", 4, 4);
        IM_VIDEO = r104;
        EntityType r105 = new EntityType("IM_FILE", 5, 5);
        IM_FILE = r105;
        EntityType r110 = new EntityType("CCM_DOC", 6, 6);
        CCM_DOC = r110;
        EntityType r111 = new EntityType("CCM_SHEET", 7, 7);
        CCM_SHEET = r111;
        EntityType r112 = new EntityType("CCM_BITABLE", 8, 8);
        CCM_BITABLE = r112;
        EntityType r113 = new EntityType("CCM_MINDNOTE", 9, 9);
        CCM_MINDNOTE = r113;
        EntityType r114 = new EntityType("CCM_FILE", 10, 10);
        CCM_FILE = r114;
        EntityType r115 = new EntityType("CCM_SLIDE", 11, 11);
        CCM_SLIDE = r115;
        $VALUES = new EntityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EntityType fromValue(int r100) {
        switch(r100) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CCM_SLIDE;
    L8:
        return CCM_FILE;
    L10:
        return CCM_MINDNOTE;
    L12:
        return CCM_BITABLE;
    L14:
        return CCM_SHEET;
    L16:
        return CCM_DOC;
    L18:
        return IM_FILE;
    L20:
        return IM_VIDEO;
    L22:
        return IM_IMAGE;
    L24:
        return USER;
    L26:
        return ANY;
    L28:
        return ENTITY_TYPE_UNKNOWN;
    }

    public static EntityType valueOf(String r100) {
        return (EntityType) a.a(EntityType.class, r100);
    }

    private EntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
