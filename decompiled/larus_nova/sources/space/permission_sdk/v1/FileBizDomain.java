package space.permission_sdk.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum FileBizDomain extends Enum<FileBizDomain> implements WireEnum {
    private static final /* synthetic */ FileBizDomain[] $VALUES = null;
    public static final ProtoAdapter<FileBizDomain> ADAPTER = null;
    public static final FileBizDomain FBD_CALENDAR = null;
    public static final FileBizDomain FBD_CCM = null;
    public static final FileBizDomain FBD_IM = null;
    public static final FileBizDomain FBD_IM_OTHERS = null;
    public static final FileBizDomain FBD_MAIL = null;
    public static final FileBizDomain FBD_MEETING_MINUTES = null;
    public static final FileBizDomain FBD_PASSPORT = null;
    public static final FileBizDomain FBD_TODO = null;
    public static final FileBizDomain FBD_UNKNOW = null;
    public static final FileBizDomain FBD_VC = null;
    private final int value;

    static {
        FileBizDomain r100 = new FileBizDomain("FBD_UNKNOW", 0, 0);
        FBD_UNKNOW = r100;
        FileBizDomain r101 = new FileBizDomain("FBD_CCM", 1, 1);
        FBD_CCM = r101;
        FileBizDomain r102 = new FileBizDomain("FBD_IM", 2, 2);
        FBD_IM = r102;
        FileBizDomain r103 = new FileBizDomain("FBD_MAIL", 3, 3);
        FBD_MAIL = r103;
        FileBizDomain r104 = new FileBizDomain("FBD_VC", 4, 4);
        FBD_VC = r104;
        FileBizDomain r105 = new FileBizDomain("FBD_TODO", 5, 5);
        FBD_TODO = r105;
        FileBizDomain r110 = new FileBizDomain("FBD_CALENDAR", 6, 6);
        FBD_CALENDAR = r110;
        FileBizDomain r111 = new FileBizDomain("FBD_PASSPORT", 7, 7);
        FBD_PASSPORT = r111;
        FileBizDomain r112 = new FileBizDomain("FBD_IM_OTHERS", 8, 8);
        FBD_IM_OTHERS = r112;
        FileBizDomain r113 = new FileBizDomain("FBD_MEETING_MINUTES", 9, 9);
        FBD_MEETING_MINUTES = r113;
        $VALUES = new FileBizDomain[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(FileBizDomain.class);
    }

    public static FileBizDomain[] values() {
        return (FileBizDomain[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FileBizDomain fromValue(int r100) {
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
        return FBD_MEETING_MINUTES;
    L8:
        return FBD_IM_OTHERS;
    L10:
        return FBD_PASSPORT;
    L12:
        return FBD_CALENDAR;
    L14:
        return FBD_TODO;
    L16:
        return FBD_VC;
    L18:
        return FBD_MAIL;
    L20:
        return FBD_IM;
    L22:
        return FBD_CCM;
    L24:
        return FBD_UNKNOW;
    }

    public static FileBizDomain valueOf(String r100) {
        return (FileBizDomain) a.a(FileBizDomain.class, r100);
    }

    private FileBizDomain(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
