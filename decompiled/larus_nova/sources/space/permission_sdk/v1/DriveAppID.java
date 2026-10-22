package space.permission_sdk.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum DriveAppID extends Enum<DriveAppID> implements WireEnum {
    private static final /* synthetic */ DriveAppID[] $VALUES = null;
    public static final ProtoAdapter<DriveAppID> ADAPTER = null;
    public static final DriveAppID APPID_BITABLE_FILE = null;
    public static final DriveAppID APPID_BITABLE_LOCAL = null;
    public static final DriveAppID APPID_CALENDAR = null;
    public static final DriveAppID APPID_DOCX_FILE = null;
    public static final DriveAppID APPID_DOC_FILE = null;
    public static final DriveAppID APPID_MAIL = null;
    public static final DriveAppID APPID_MEEGO = null;
    public static final DriveAppID APPID_MINIAPP = null;
    public static final DriveAppID APPID_SHEET_FILE = null;
    public static final DriveAppID APPID_SPACE = null;
    public static final DriveAppID APPID_TODO = null;
    public static final DriveAppID APPID_WEB_BROWSER = null;
    private final int value;

    static {
        DriveAppID r100 = new DriveAppID("APPID_SPACE", 0, 0);
        APPID_SPACE = r100;
        DriveAppID r101 = new DriveAppID("APPID_MAIL", 1, 1);
        APPID_MAIL = r101;
        DriveAppID r102 = new DriveAppID("APPID_CALENDAR", 2, 2);
        APPID_CALENDAR = r102;
        DriveAppID r103 = new DriveAppID("APPID_DOC_FILE", 3, 3);
        APPID_DOC_FILE = r103;
        DriveAppID r104 = new DriveAppID("APPID_BITABLE_FILE", 4, 4);
        APPID_BITABLE_FILE = r104;
        DriveAppID r105 = new DriveAppID("APPID_BITABLE_LOCAL", 5, 5);
        APPID_BITABLE_LOCAL = r105;
        DriveAppID r110 = new DriveAppID("APPID_SHEET_FILE", 6, 6);
        APPID_SHEET_FILE = r110;
        DriveAppID r111 = new DriveAppID("APPID_DOCX_FILE", 7, 7);
        APPID_DOCX_FILE = r111;
        DriveAppID r112 = new DriveAppID("APPID_TODO", 8, 8);
        APPID_TODO = r112;
        DriveAppID r113 = new DriveAppID("APPID_MINIAPP", 9, 9);
        APPID_MINIAPP = r113;
        DriveAppID r114 = new DriveAppID("APPID_MEEGO", 10, 10);
        APPID_MEEGO = r114;
        DriveAppID r115 = new DriveAppID("APPID_WEB_BROWSER", 11, 11);
        APPID_WEB_BROWSER = r115;
        $VALUES = new DriveAppID[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        ADAPTER = ProtoAdapter.newEnumAdapter(DriveAppID.class);
    }

    public static DriveAppID[] values() {
        return (DriveAppID[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DriveAppID fromValue(int r100) {
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
        return APPID_WEB_BROWSER;
    L8:
        return APPID_MEEGO;
    L10:
        return APPID_MINIAPP;
    L12:
        return APPID_TODO;
    L14:
        return APPID_DOCX_FILE;
    L16:
        return APPID_SHEET_FILE;
    L18:
        return APPID_BITABLE_LOCAL;
    L20:
        return APPID_BITABLE_FILE;
    L22:
        return APPID_DOC_FILE;
    L24:
        return APPID_CALENDAR;
    L26:
        return APPID_MAIL;
    L28:
        return APPID_SPACE;
    }

    public static DriveAppID valueOf(String r100) {
        return (DriveAppID) a.a(DriveAppID.class, r100);
    }

    private DriveAppID(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
