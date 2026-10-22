package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum PermissionType extends Enum<PermissionType> implements WireEnum {
    private static final /* synthetic */ PermissionType[] $VALUES = null;
    public static final ProtoAdapter<PermissionType> ADAPTER = null;
    public static final PermissionType BAIKE_REPO_VIEW = null;
    public static final PermissionType DOC_DOWNLOAD = null;
    public static final PermissionType DOC_EXPORT = null;
    public static final PermissionType DOC_PREVIEW_AND_OPEN = null;
    public static final PermissionType DOC_PRINT = null;
    public static final PermissionType FILE_ACCESS_FOLDER = null;
    public static final PermissionType FILE_APP_OPEN = null;
    public static final PermissionType FILE_COMMENT = null;
    public static final PermissionType FILE_COPY = null;
    public static final PermissionType FILE_DELETE = null;
    public static final PermissionType FILE_DOWNLOAD = null;
    public static final PermissionType FILE_EDIT = null;
    public static final PermissionType FILE_EXPORT = null;
    public static final PermissionType FILE_IMPORT = null;
    public static final PermissionType FILE_PRINT = null;
    public static final PermissionType FILE_READ = null;
    public static final PermissionType FILE_SHARE = null;
    public static final PermissionType FILE_UPLOAD = null;
    public static final PermissionType LOCAL_FILE_PREVIEW = null;
    public static final PermissionType LOCAL_FILE_SHARE = null;
    public static final PermissionType MOBILE_PASTE_PROTECTION = null;
    public static final PermissionType MOBILE_SCREEN_PROTECT = null;
    public static final PermissionType PC_PASTE_PROTECTION = null;
    public static final PermissionType PC_SCREEN_PROTECT = null;
    public static final PermissionType PERMISSION_TYPE_UNKNOWN = null;
    public static final PermissionType PRIVACY_GPS_LOCATION = null;
    public static final PermissionType SDK_SWITCH = null;
    public static final PermissionType SEARCH = null;
    public static final PermissionType WEB_PASTE_PROTECTION = null;
    private final int value;

    static {
        PermissionType r100 = new PermissionType("PERMISSION_TYPE_UNKNOWN", 0, 0);
        PERMISSION_TYPE_UNKNOWN = r100;
        PermissionType r101 = new PermissionType("FILE_UPLOAD", 1, 1);
        FILE_UPLOAD = r101;
        PermissionType r102 = new PermissionType("FILE_IMPORT", 2, 2);
        FILE_IMPORT = r102;
        PermissionType r103 = new PermissionType("FILE_DOWNLOAD", 3, 3);
        FILE_DOWNLOAD = r103;
        PermissionType r104 = new PermissionType("FILE_EXPORT", 4, 4);
        FILE_EXPORT = r104;
        PermissionType r105 = new PermissionType("FILE_PRINT", 5, 5);
        FILE_PRINT = r105;
        PermissionType r110 = new PermissionType("FILE_APP_OPEN", 6, 6);
        FILE_APP_OPEN = r110;
        PermissionType r111 = new PermissionType("FILE_ACCESS_FOLDER", 7, 7);
        FILE_ACCESS_FOLDER = r111;
        PermissionType r112 = new PermissionType("FILE_READ", 8, 8);
        FILE_READ = r112;
        PermissionType r113 = new PermissionType("FILE_EDIT", 9, 9);
        FILE_EDIT = r113;
        PermissionType r114 = new PermissionType("FILE_COMMENT", 10, 10);
        FILE_COMMENT = r114;
        PermissionType r115 = new PermissionType("FILE_COPY", 11, 11);
        FILE_COPY = r115;
        PermissionType r106 = new PermissionType("FILE_DELETE", 12, 12);
        FILE_DELETE = r106;
        PermissionType r107 = new PermissionType("FILE_SHARE", 13, 13);
        FILE_SHARE = r107;
        PermissionType r108 = new PermissionType("SEARCH", 14, 14);
        SEARCH = r108;
        PermissionType r109 = new PermissionType("LOCAL_FILE_SHARE", 15, 15);
        LOCAL_FILE_SHARE = r109;
        PermissionType r116 = new PermissionType("LOCAL_FILE_PREVIEW", 16, 16);
        LOCAL_FILE_PREVIEW = r116;
        PermissionType r117 = new PermissionType("DOC_PREVIEW_AND_OPEN", 17, 17);
        DOC_PREVIEW_AND_OPEN = r117;
        PermissionType r118 = new PermissionType("PRIVACY_GPS_LOCATION", 18, 18);
        PRIVACY_GPS_LOCATION = r118;
        PermissionType r119 = new PermissionType("PC_PASTE_PROTECTION", 19, 19);
        PC_PASTE_PROTECTION = r119;
        PermissionType r120 = new PermissionType("WEB_PASTE_PROTECTION", 20, 20);
        WEB_PASTE_PROTECTION = r120;
        PermissionType r121 = new PermissionType("MOBILE_PASTE_PROTECTION", 21, 21);
        MOBILE_PASTE_PROTECTION = r121;
        PermissionType r122 = new PermissionType("MOBILE_SCREEN_PROTECT", 22, 22);
        MOBILE_SCREEN_PROTECT = r122;
        PermissionType r123 = new PermissionType("PC_SCREEN_PROTECT", 23, 23);
        PC_SCREEN_PROTECT = r123;
        PermissionType r124 = new PermissionType("DOC_DOWNLOAD", 24, 24);
        DOC_DOWNLOAD = r124;
        PermissionType r125 = new PermissionType("DOC_EXPORT", 25, 25);
        DOC_EXPORT = r125;
        PermissionType r126 = new PermissionType("DOC_PRINT", 26, 26);
        DOC_PRINT = r126;
        PermissionType r127 = new PermissionType("BAIKE_REPO_VIEW", 27, 27);
        BAIKE_REPO_VIEW = r127;
        PermissionType r128 = new PermissionType("SDK_SWITCH", 28, 28);
        SDK_SWITCH = r128;
        $VALUES = new PermissionType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
        ADAPTER = ProtoAdapter.newEnumAdapter(PermissionType.class);
    }

    public static PermissionType[] values() {
        return (PermissionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PermissionType fromValue(int r100) {
        switch(r100) {
            case 0: goto L62;
            case 1: goto L60;
            case 2: goto L58;
            case 3: goto L56;
            case 4: goto L54;
            case 5: goto L52;
            case 6: goto L50;
            case 7: goto L48;
            case 8: goto L46;
            case 9: goto L44;
            case 10: goto L42;
            case 11: goto L40;
            case 12: goto L38;
            case 13: goto L36;
            case 14: goto L34;
            case 15: goto L32;
            case 16: goto L30;
            case 17: goto L28;
            case 18: goto L26;
            case 19: goto L24;
            case 20: goto L22;
            case 21: goto L20;
            case 22: goto L18;
            case 23: goto L16;
            case 24: goto L14;
            case 25: goto L12;
            case 26: goto L10;
            case 27: goto L8;
            case 28: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SDK_SWITCH;
    L8:
        return BAIKE_REPO_VIEW;
    L10:
        return DOC_PRINT;
    L12:
        return DOC_EXPORT;
    L14:
        return DOC_DOWNLOAD;
    L16:
        return PC_SCREEN_PROTECT;
    L18:
        return MOBILE_SCREEN_PROTECT;
    L20:
        return MOBILE_PASTE_PROTECTION;
    L22:
        return WEB_PASTE_PROTECTION;
    L24:
        return PC_PASTE_PROTECTION;
    L26:
        return PRIVACY_GPS_LOCATION;
    L28:
        return DOC_PREVIEW_AND_OPEN;
    L30:
        return LOCAL_FILE_PREVIEW;
    L32:
        return LOCAL_FILE_SHARE;
    L34:
        return SEARCH;
    L36:
        return FILE_SHARE;
    L38:
        return FILE_DELETE;
    L40:
        return FILE_COPY;
    L42:
        return FILE_COMMENT;
    L44:
        return FILE_EDIT;
    L46:
        return FILE_READ;
    L48:
        return FILE_ACCESS_FOLDER;
    L50:
        return FILE_APP_OPEN;
    L52:
        return FILE_PRINT;
    L54:
        return FILE_EXPORT;
    L56:
        return FILE_DOWNLOAD;
    L58:
        return FILE_IMPORT;
    L60:
        return FILE_UPLOAD;
    L62:
        return PERMISSION_TYPE_UNKNOWN;
    }

    public static PermissionType valueOf(String r100) {
        return (PermissionType) a.a(PermissionType.class, r100);
    }

    private PermissionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
