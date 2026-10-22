package com.ss.android.lark.pb.security_event;

import com.larus.im.internal.network.proto2.AvCmd;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType EntityBitableID = null;
    public static final EntityType EntityBotID = null;
    public static final EntityType EntityCCMSpace = null;
    public static final EntityType EntityChatID = null;
    public static final EntityType EntityChatPinId = null;
    public static final EntityType EntityChatter = null;
    public static final EntityType EntityDepartmentID = null;
    public static final EntityType EntityDevice = null;
    public static final EntityType EntityDocID = null;
    public static final EntityType EntityDocxID = null;
    public static final EntityType EntityDoubaoChatID = null;
    public static final EntityType EntityDriverSDKFileID = null;
    public static final EntityType EntityEmailAttachment = null;
    public static final EntityType EntityEmailContent = null;
    public static final EntityType EntityEmailGroup = null;
    public static final EntityType EntityEmailSubject = null;
    public static final EntityType EntityFileID = null;
    public static final EntityType EntityFileIM = null;
    public static final EntityType EntityFolderID = null;
    public static final EntityType EntityIMContent = null;
    public static final EntityType EntityImage = null;
    public static final EntityType EntityLink = null;
    public static final EntityType EntityLocalFile = null;
    public static final EntityType EntityMiaodaApplication = null;
    public static final EntityType EntityMiaodaProduct = null;
    public static final EntityType EntityMindNoteID = null;
    public static final EntityType EntityMiniProgramsAndH5 = null;
    public static final EntityType EntityMomentsComment = null;
    public static final EntityType EntityMomentsImage = null;
    public static final EntityType EntityMomentsPost = null;
    public static final EntityType EntityMomentsPostDetail = null;
    public static final EntityType EntityMomentsVideo = null;
    public static final EntityType EntityOKRType = null;
    public static final EntityType EntityPublicEmail = null;
    public static final EntityType EntitySheetID = null;
    public static final EntityType EntitySlideID = null;
    public static final EntityType EntitySlidesDocs = null;
    public static final EntityType EntityTenantID = null;
    public static final EntityType EntityTypeUnknown = null;
    public static final EntityType EntityUserEmail = null;
    public static final EntityType EntityUserID = null;
    public static final EntityType EntityUserMobile = null;
    public static final EntityType EntityVideoID = null;
    public static final EntityType EntityVideoIM = null;
    public static final EntityType EntityWikiToken = null;
    private final int value;

    static {
        EntityType r100 = new EntityType("EntityTypeUnknown", 0, 0);
        EntityTypeUnknown = r100;
        EntityType r101 = new EntityType("EntityUserID", 1, 1);
        EntityUserID = r101;
        EntityType r102 = new EntityType("EntityDepartmentID", 2, 2);
        EntityDepartmentID = r102;
        EntityType r103 = new EntityType("EntityTenantID", 3, 3);
        EntityTenantID = r103;
        EntityType r104 = new EntityType("EntityChatID", 4, 4);
        EntityChatID = r104;
        EntityType r105 = new EntityType("EntityDocID", 5, 5);
        EntityDocID = r105;
        EntityType r110 = new EntityType("EntitySheetID", 6, 6);
        EntitySheetID = r110;
        EntityType r111 = new EntityType("EntityFileID", 7, 7);
        EntityFileID = r111;
        EntityType r112 = new EntityType("EntityFolderID", 8, 8);
        EntityFolderID = r112;
        EntityType r113 = new EntityType("EntityMindNoteID", 9, 9);
        EntityMindNoteID = r113;
        EntityType r114 = new EntityType("EntityBitableID", 10, 10);
        EntityBitableID = r114;
        EntityType r115 = new EntityType("EntitySlideID", 11, 11);
        EntitySlideID = r115;
        EntityType r106 = new EntityType("EntityBotID", 12, 12);
        EntityBotID = r106;
        EntityType r107 = new EntityType("EntityVideoID", 13, 13);
        EntityVideoID = r107;
        EntityType r108 = new EntityType("EntityDriverSDKFileID", 14, 14);
        EntityDriverSDKFileID = r108;
        EntityType r109 = new EntityType("EntityLink", 15, 15);
        EntityLink = r109;
        EntityType r116 = new EntityType("EntityChatter", 16, 16);
        EntityChatter = r116;
        EntityType r117 = new EntityType("EntityImage", 17, 17);
        EntityImage = r117;
        EntityType r118 = new EntityType("EntityVideoIM", 18, 18);
        EntityVideoIM = r118;
        EntityType r119 = new EntityType("EntityFileIM", 19, 19);
        EntityFileIM = r119;
        EntityType r120 = new EntityType("EntityMiniProgramsAndH5", 20, 20);
        EntityMiniProgramsAndH5 = r120;
        EntityType r121 = new EntityType("EntityLocalFile", 21, 21);
        EntityLocalFile = r121;
        EntityType r122 = new EntityType("EntityUserEmail", 22, 22);
        EntityUserEmail = r122;
        EntityType r123 = new EntityType("EntityPublicEmail", 23, 23);
        EntityPublicEmail = r123;
        EntityType r124 = new EntityType("EntityEmailGroup", 24, 24);
        EntityEmailGroup = r124;
        EntityType r125 = new EntityType("EntityUserMobile", 25, 25);
        EntityUserMobile = r125;
        EntityType r126 = new EntityType("EntityEmailContent", 26, 26);
        EntityEmailContent = r126;
        EntityType r127 = new EntityType("EntityEmailSubject", 27, 27);
        EntityEmailSubject = r127;
        EntityType r128 = new EntityType("EntityEmailAttachment", 28, 28);
        EntityEmailAttachment = r128;
        EntityType r129 = new EntityType("EntityOKRType", 29, 29);
        EntityOKRType = r129;
        EntityType r130 = new EntityType("EntityIMContent", 30, 30);
        EntityIMContent = r130;
        EntityType r131 = new EntityType("EntityDocxID", 31, 31);
        EntityDocxID = r131;
        EntityType r132 = new EntityType("EntityDevice", 32, 45);
        EntityDevice = r132;
        EntityType r133 = new EntityType("EntityMomentsPost", 33, 75);
        EntityMomentsPost = r133;
        EntityType r134 = new EntityType("EntityMomentsComment", 34, 76);
        EntityMomentsComment = r134;
        EntityType r135 = new EntityType("EntityMomentsImage", 35, 77);
        EntityMomentsImage = r135;
        EntityType r136 = new EntityType("EntityMomentsVideo", 36, 78);
        EntityMomentsVideo = r136;
        EntityType r137 = new EntityType("EntitySlidesDocs", 37, 106);
        EntitySlidesDocs = r137;
        EntityType r138 = new EntityType("EntityCCMSpace", 38, 107);
        EntityCCMSpace = r138;
        EntityType r139 = new EntityType("EntityWikiToken", 39, 144);
        EntityWikiToken = r139;
        EntityType r140 = new EntityType("EntityMomentsPostDetail", 40, 2001);
        EntityMomentsPostDetail = r140;
        EntityType r141 = new EntityType("EntityChatPinId", 41, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK);
        EntityChatPinId = r141;
        EntityType r142 = new EntityType("EntityDoubaoChatID", 42, AvCmd.CommandEventType.SPEECH_ONLY_VALUE);
        EntityDoubaoChatID = r142;
        EntityType r143 = new EntityType("EntityMiaodaProduct", 43, 70007);
        EntityMiaodaProduct = r143;
        EntityType r144 = new EntityType("EntityMiaodaApplication", 44, 70008);
        EntityMiaodaApplication = r144;
        $VALUES = new EntityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144};
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
        if (r100 == 45) goto L110;
        if (r100 == 144) goto L108;
        if (r100 == 499) goto L106;
        if (r100 == 2001) goto L104;
        if (r100 == 60001) goto L102;
        if (r100 == 106) goto L100;
        if (r100 == 107) goto L98;
        switch(r100) {
            case 0: goto L96;
            case 1: goto L94;
            case 2: goto L92;
            case 3: goto L90;
            case 4: goto L88;
            case 5: goto L86;
            case 6: goto L84;
            case 7: goto L82;
            case 8: goto L80;
            case 9: goto L78;
            case 10: goto L76;
            case 11: goto L74;
            case 12: goto L72;
            case 13: goto L70;
            case 14: goto L68;
            case 15: goto L66;
            case 16: goto L64;
            case 17: goto L62;
            case 18: goto L60;
            case 19: goto L58;
            case 20: goto L56;
            case 21: goto L54;
            case 22: goto L52;
            case 23: goto L50;
            case 24: goto L48;
            case 25: goto L46;
            case 26: goto L44;
            case 27: goto L42;
            case 28: goto L40;
            case 29: goto L38;
            case 30: goto L36;
            case 31: goto L34;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 75: goto L32;
            case 76: goto L30;
            case 77: goto L28;
            case 78: goto L26;
            default: goto L18;
        };
    L18:
        switch(r100) {
            case 70007: goto L24;
            case 70008: goto L22;
            default: goto L19;
        };
    L19:
        return null;
    L22:
        return EntityMiaodaApplication;
    L24:
        return EntityMiaodaProduct;
    L26:
        return EntityMomentsVideo;
    L28:
        return EntityMomentsImage;
    L30:
        return EntityMomentsComment;
    L32:
        return EntityMomentsPost;
    L34:
        return EntityDocxID;
    L36:
        return EntityIMContent;
    L38:
        return EntityOKRType;
    L40:
        return EntityEmailAttachment;
    L42:
        return EntityEmailSubject;
    L44:
        return EntityEmailContent;
    L46:
        return EntityUserMobile;
    L48:
        return EntityEmailGroup;
    L50:
        return EntityPublicEmail;
    L52:
        return EntityUserEmail;
    L54:
        return EntityLocalFile;
    L56:
        return EntityMiniProgramsAndH5;
    L58:
        return EntityFileIM;
    L60:
        return EntityVideoIM;
    L62:
        return EntityImage;
    L64:
        return EntityChatter;
    L66:
        return EntityLink;
    L68:
        return EntityDriverSDKFileID;
    L70:
        return EntityVideoID;
    L72:
        return EntityBotID;
    L74:
        return EntitySlideID;
    L76:
        return EntityBitableID;
    L78:
        return EntityMindNoteID;
    L80:
        return EntityFolderID;
    L82:
        return EntityFileID;
    L84:
        return EntitySheetID;
    L86:
        return EntityDocID;
    L88:
        return EntityChatID;
    L90:
        return EntityTenantID;
    L92:
        return EntityDepartmentID;
    L94:
        return EntityUserID;
    L96:
        return EntityTypeUnknown;
    L98:
        return EntityCCMSpace;
    L100:
        return EntitySlidesDocs;
    L102:
        return EntityDoubaoChatID;
    L104:
        return EntityMomentsPostDetail;
    L106:
        return EntityChatPinId;
    L108:
        return EntityWikiToken;
    L110:
        return EntityDevice;
    }

    public static EntityType valueOf(String r100) {
        return (EntityType) a.a(EntityType.class, r100);
    }

    private EntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
