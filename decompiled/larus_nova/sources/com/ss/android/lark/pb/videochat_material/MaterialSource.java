package com.ss.android.lark.pb.videochat_material;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum MaterialSource extends Enum<MaterialSource> implements WireEnum {
    private static final /* synthetic */ MaterialSource[] $VALUES = null;
    public static final ProtoAdapter<MaterialSource> ADAPTER = null;
    public static final MaterialSource APP_ADMIN = null;
    public static final MaterialSource APP_ANDROID = null;
    public static final MaterialSource APP_CALENDAR = null;
    public static final MaterialSource APP_HARMONY_MOBILE = null;
    public static final MaterialSource APP_HARMONY_PC = null;
    public static final MaterialSource APP_IOS = null;
    public static final MaterialSource APP_IPAD = null;
    public static final MaterialSource APP_LINUX = null;
    public static final MaterialSource APP_MAC = null;
    public static final MaterialSource APP_PEOPLE = null;
    public static final MaterialSource APP_SETTINGS = null;
    public static final MaterialSource APP_WIN = null;
    public static final MaterialSource All_SOURCE = null;
    public static final MaterialSource ISV_UPLOAD = null;
    public static final MaterialSource ISV_UPLOAD_FROM_PRESET = null;
    public static final MaterialSource ISV_UPLOAD_FROM_VC = null;
    public static final MaterialSource UNKNOWN_SOURCE = null;
    private final int value;

    static {
        MaterialSource r100 = new MaterialSource("UNKNOWN_SOURCE", 0, 0);
        UNKNOWN_SOURCE = r100;
        MaterialSource r101 = new MaterialSource("All_SOURCE", 1, 1);
        All_SOURCE = r101;
        MaterialSource r102 = new MaterialSource("APP_WIN", 2, 2);
        APP_WIN = r102;
        MaterialSource r103 = new MaterialSource("APP_MAC", 3, 3);
        APP_MAC = r103;
        MaterialSource r104 = new MaterialSource("APP_ANDROID", 4, 4);
        APP_ANDROID = r104;
        MaterialSource r105 = new MaterialSource("APP_IOS", 5, 5);
        APP_IOS = r105;
        MaterialSource r110 = new MaterialSource("APP_IPAD", 6, 6);
        APP_IPAD = r110;
        MaterialSource r111 = new MaterialSource("APP_SETTINGS", 7, 7);
        APP_SETTINGS = r111;
        MaterialSource r112 = new MaterialSource("APP_ADMIN", 8, 8);
        APP_ADMIN = r112;
        MaterialSource r113 = new MaterialSource("APP_PEOPLE", 9, 9);
        APP_PEOPLE = r113;
        MaterialSource r114 = new MaterialSource("APP_CALENDAR", 10, 10);
        APP_CALENDAR = r114;
        MaterialSource r115 = new MaterialSource("APP_LINUX", 11, 11);
        APP_LINUX = r115;
        MaterialSource r106 = new MaterialSource("APP_HARMONY_MOBILE", 12, 12);
        APP_HARMONY_MOBILE = r106;
        MaterialSource r107 = new MaterialSource("APP_HARMONY_PC", 13, 13);
        APP_HARMONY_PC = r107;
        MaterialSource r108 = new MaterialSource("ISV_UPLOAD", 14, 21);
        ISV_UPLOAD = r108;
        MaterialSource r109 = new MaterialSource("ISV_UPLOAD_FROM_VC", 15, 22);
        ISV_UPLOAD_FROM_VC = r109;
        MaterialSource r116 = new MaterialSource("ISV_UPLOAD_FROM_PRESET", 16, 23);
        ISV_UPLOAD_FROM_PRESET = r116;
        $VALUES = new MaterialSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        ADAPTER = ProtoAdapter.newEnumAdapter(MaterialSource.class);
    }

    public static MaterialSource[] values() {
        return (MaterialSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MaterialSource fromValue(int r100) {
        switch(r100) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L25;
            case 8: goto L23;
            case 9: goto L21;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L15;
            case 13: goto L13;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 21: goto L11;
            case 22: goto L9;
            case 23: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return ISV_UPLOAD_FROM_PRESET;
    L9:
        return ISV_UPLOAD_FROM_VC;
    L11:
        return ISV_UPLOAD;
    L13:
        return APP_HARMONY_PC;
    L15:
        return APP_HARMONY_MOBILE;
    L17:
        return APP_LINUX;
    L19:
        return APP_CALENDAR;
    L21:
        return APP_PEOPLE;
    L23:
        return APP_ADMIN;
    L25:
        return APP_SETTINGS;
    L27:
        return APP_IPAD;
    L29:
        return APP_IOS;
    L31:
        return APP_ANDROID;
    L33:
        return APP_MAC;
    L35:
        return APP_WIN;
    L37:
        return All_SOURCE;
    L39:
        return UNKNOWN_SOURCE;
    }

    public static MaterialSource valueOf(String r100) {
        return (MaterialSource) a.a(MaterialSource.class, r100);
    }

    private MaterialSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
