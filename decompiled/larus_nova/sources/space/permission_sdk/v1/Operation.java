package space.permission_sdk.v1;

import com.lynx.serval.svg.SVGRenderEngine;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum Operation extends Enum<Operation> implements WireEnum {
    private static final /* synthetic */ Operation[] $VALUES = null;
    public static final ProtoAdapter<Operation> ADAPTER = null;
    public static final Operation applyEmbed = null;
    public static final Operation comment = null;
    public static final Operation copyContent = null;
    public static final Operation createCopy = null;
    public static final Operation createSubNode = null;
    public static final Operation delete = null;
    public static final Operation deleteEntity = null;
    public static final Operation deleteVersion = null;
    public static final Operation download = null;
    public static final Operation downloadAttachment = null;
    public static final Operation edit = null;
    public static final Operation export = null;
    public static final Operation fullAccess = null;
    public static final Operation importToOnlineDocument = null;
    public static final Operation inviteEdit = null;
    public static final Operation inviteFullAccess = null;
    public static final Operation inviteSinglePageEdit = null;
    public static final Operation inviteSinglePageFullAccess = null;
    public static final Operation inviteSinglePageView = null;
    public static final Operation inviteView = null;
    public static final Operation isContainerFullAccess = null;
    public static final Operation isSinglePageFullAccess = null;
    public static final Operation manageCollaborator = null;
    public static final Operation manageContainerCollaborator = null;
    public static final Operation manageContainerPermissionMeta = null;
    public static final Operation managePermissionMeta = null;
    public static final Operation manageSinglePageCollaborator = null;
    public static final Operation manageSinglePagePermissionMeta = null;
    public static final Operation manageVersion = null;
    public static final Operation modifySecretLabel = null;
    public static final Operation moveSheetTab = null;
    public static final Operation moveSubNode = null;
    public static final Operation moveThisNode = null;
    public static final Operation moveToHere = null;
    public static final Operation openWithOtherApp = null;
    public static final Operation perceive = null;
    public static final Operation preview = null;
    public static final Operation save = null;
    public static final Operation secretLabelVisible = null;
    public static final Operation shareToExternal = null;
    public static final Operation shareToPartnerTenant = null;
    public static final Operation updateTimeZone = null;
    public static final Operation upload = null;
    public static final Operation uploadAttachment = null;
    public static final Operation view = null;
    public static final Operation viewCollaboratorInfo = null;
    private final int value;

    static {
        Operation r100 = new Operation("export", 0, 0);
        export = r100;
        Operation r101 = new Operation("view", 1, 1);
        view = r101;
        Operation r102 = new Operation("perceive", 2, 2);
        perceive = r102;
        Operation r103 = new Operation("preview", 3, 3);
        preview = r103;
        Operation r104 = new Operation("edit", 4, 4);
        edit = r104;
        Operation r105 = new Operation("copyContent", 5, 5);
        copyContent = r105;
        Operation r110 = new Operation("createCopy", 6, 6);
        createCopy = r110;
        Operation r111 = new Operation("upload", 7, 7);
        upload = r111;
        Operation r112 = new Operation("download", 8, 8);
        download = r112;
        Operation r113 = new Operation(SVGRenderEngine.SAVE, 9, 9);
        save = r113;
        Operation r114 = new Operation("openWithOtherApp", 10, 10);
        openWithOtherApp = r114;
        Operation r115 = new Operation("delete", 11, 11);
        delete = r115;
        Operation r106 = new Operation("downloadAttachment", 12, 12);
        downloadAttachment = r106;
        Operation r107 = new Operation("uploadAttachment", 13, 13);
        uploadAttachment = r107;
        Operation r108 = new Operation("comment", 14, 14);
        comment = r108;
        Operation r109 = new Operation("manageCollaborator", 15, 15);
        manageCollaborator = r109;
        Operation r116 = new Operation("managePermissionMeta", 16, 16);
        managePermissionMeta = r116;
        Operation r117 = new Operation("createSubNode", 17, 17);
        createSubNode = r117;
        Operation r118 = new Operation("deleteEntity", 18, 18);
        deleteEntity = r118;
        Operation r119 = new Operation("inviteFullAccess", 19, 19);
        inviteFullAccess = r119;
        Operation r120 = new Operation("inviteEdit", 20, 20);
        inviteEdit = r120;
        Operation r121 = new Operation("inviteView", 21, 21);
        inviteView = r121;
        Operation r122 = new Operation("inviteSinglePageFullAccess", 22, 22);
        inviteSinglePageFullAccess = r122;
        Operation r123 = new Operation("inviteSinglePageEdit", 23, 23);
        inviteSinglePageEdit = r123;
        Operation r124 = new Operation("inviteSinglePageView", 24, 24);
        inviteSinglePageView = r124;
        Operation r125 = new Operation("moveThisNode", 25, 25);
        moveThisNode = r125;
        Operation r126 = new Operation("moveSubNode", 26, 26);
        moveSubNode = r126;
        Operation r127 = new Operation("moveToHere", 27, 27);
        moveToHere = r127;
        Operation r128 = new Operation("applyEmbed", 28, 28);
        applyEmbed = r128;
        Operation r129 = new Operation("manageContainerCollaborator", 29, 29);
        manageContainerCollaborator = r129;
        Operation r130 = new Operation("manageContainerPermissionMeta", 30, 30);
        manageContainerPermissionMeta = r130;
        Operation r131 = new Operation("manageSinglePageCollaborator", 31, 31);
        manageSinglePageCollaborator = r131;
        Operation r132 = new Operation("manageSinglePagePermissionMeta", 32, 32);
        manageSinglePagePermissionMeta = r132;
        Operation r133 = new Operation("secretLabelVisible", 33, 33);
        secretLabelVisible = r133;
        Operation r134 = new Operation("modifySecretLabel", 34, 34);
        modifySecretLabel = r134;
        Operation r135 = new Operation("isContainerFullAccess", 35, 35);
        isContainerFullAccess = r135;
        Operation r136 = new Operation("isSinglePageFullAccess", 36, 36);
        isSinglePageFullAccess = r136;
        Operation r137 = new Operation("viewCollaboratorInfo", 37, 37);
        viewCollaboratorInfo = r137;
        Operation r138 = new Operation("manageVersion", 38, 38);
        manageVersion = r138;
        Operation r139 = new Operation("deleteVersion", 39, 39);
        deleteVersion = r139;
        Operation r140 = new Operation("shareToExternal", 40, 40);
        shareToExternal = r140;
        Operation r141 = new Operation("updateTimeZone", 41, 41);
        updateTimeZone = r141;
        Operation r142 = new Operation("importToOnlineDocument", 42, 42);
        importToOnlineDocument = r142;
        Operation r143 = new Operation("moveSheetTab", 43, 43);
        moveSheetTab = r143;
        Operation r144 = new Operation("fullAccess", 44, 44);
        fullAccess = r144;
        Operation r145 = new Operation("shareToPartnerTenant", 45, 45);
        shareToPartnerTenant = r145;
        $VALUES = new Operation[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145};
        ADAPTER = ProtoAdapter.newEnumAdapter(Operation.class);
    }

    public static Operation[] values() {
        return (Operation[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Operation fromValue(int r100) {
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
            case 32: goto L32;
            case 33: goto L30;
            case 34: goto L28;
            case 35: goto L26;
            case 36: goto L24;
            case 37: goto L22;
            case 38: goto L20;
            case 39: goto L18;
            case 40: goto L16;
            case 41: goto L14;
            case 42: goto L12;
            case 43: goto L10;
            case 44: goto L8;
            case 45: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return shareToPartnerTenant;
    L8:
        return fullAccess;
    L10:
        return moveSheetTab;
    L12:
        return importToOnlineDocument;
    L14:
        return updateTimeZone;
    L16:
        return shareToExternal;
    L18:
        return deleteVersion;
    L20:
        return manageVersion;
    L22:
        return viewCollaboratorInfo;
    L24:
        return isSinglePageFullAccess;
    L26:
        return isContainerFullAccess;
    L28:
        return modifySecretLabel;
    L30:
        return secretLabelVisible;
    L32:
        return manageSinglePagePermissionMeta;
    L34:
        return manageSinglePageCollaborator;
    L36:
        return manageContainerPermissionMeta;
    L38:
        return manageContainerCollaborator;
    L40:
        return applyEmbed;
    L42:
        return moveToHere;
    L44:
        return moveSubNode;
    L46:
        return moveThisNode;
    L48:
        return inviteSinglePageView;
    L50:
        return inviteSinglePageEdit;
    L52:
        return inviteSinglePageFullAccess;
    L54:
        return inviteView;
    L56:
        return inviteEdit;
    L58:
        return inviteFullAccess;
    L60:
        return deleteEntity;
    L62:
        return createSubNode;
    L64:
        return managePermissionMeta;
    L66:
        return manageCollaborator;
    L68:
        return comment;
    L70:
        return uploadAttachment;
    L72:
        return downloadAttachment;
    L74:
        return delete;
    L76:
        return openWithOtherApp;
    L78:
        return save;
    L80:
        return download;
    L82:
        return upload;
    L84:
        return createCopy;
    L86:
        return copyContent;
    L88:
        return edit;
    L90:
        return preview;
    L92:
        return perceive;
    L94:
        return view;
    L96:
        return export;
    }

    public static Operation valueOf(String r100) {
        return (Operation) a.a(Operation.class, r100);
    }

    private Operation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
