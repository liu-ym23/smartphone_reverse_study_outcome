package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ModuleType extends Enum<ModuleType> implements WireEnum {
    private static final /* synthetic */ ModuleType[] $VALUES = null;
    public static final ProtoAdapter<ModuleType> ADAPTER = null;
    public static final ModuleType ModuleAPP = null;
    public static final ModuleType ModuleAddressBook = null;
    public static final ModuleType ModuleBitable = null;
    public static final ModuleType ModuleCalendar = null;
    public static final ModuleType ModuleChat = null;
    public static final ModuleType ModuleCommunication = null;
    public static final ModuleType ModuleDevice = null;
    public static final ModuleType ModuleDocs = null;
    public static final ModuleType ModuleDocx = null;
    public static final ModuleType ModuleDoubao = null;
    public static final ModuleType ModuleEmail = null;
    public static final ModuleType ModuleFiles = null;
    public static final ModuleType ModuleFolders = null;
    public static final ModuleType ModuleIM = null;
    public static final ModuleType ModuleIMFile = null;
    public static final ModuleType ModuleIMImageAndVideo = null;
    public static final ModuleType ModuleMindNote = null;
    public static final ModuleType ModuleMoments = null;
    public static final ModuleType ModuleOpenPlatform = null;
    public static final ModuleType ModulePassport = null;
    public static final ModuleType ModulePeople = null;
    public static final ModuleType ModuleSheets = null;
    public static final ModuleType ModuleSlide = null;
    public static final ModuleType ModuleUnknown = null;
    public static final ModuleType ModuleVideo = null;
    private final int value;

    static {
        ModuleType r100 = new ModuleType("ModuleUnknown", 0, 0);
        ModuleUnknown = r100;
        ModuleType r101 = new ModuleType("ModuleDocs", 1, 1);
        ModuleDocs = r101;
        ModuleType r102 = new ModuleType("ModuleSheets", 2, 2);
        ModuleSheets = r102;
        ModuleType r103 = new ModuleType("ModuleFiles", 3, 3);
        ModuleFiles = r103;
        ModuleType r104 = new ModuleType("ModuleFolders", 4, 4);
        ModuleFolders = r104;
        ModuleType r105 = new ModuleType("ModulePassport", 5, 5);
        ModulePassport = r105;
        ModuleType r110 = new ModuleType("ModuleMindNote", 6, 6);
        ModuleMindNote = r110;
        ModuleType r111 = new ModuleType("ModuleBitable", 7, 7);
        ModuleBitable = r111;
        ModuleType r112 = new ModuleType("ModuleSlide", 8, 8);
        ModuleSlide = r112;
        ModuleType r113 = new ModuleType("ModuleChat", 9, 9);
        ModuleChat = r113;
        ModuleType r114 = new ModuleType("ModuleIMImageAndVideo", 10, 10);
        ModuleIMImageAndVideo = r114;
        ModuleType r115 = new ModuleType("ModuleVideo", 11, 11);
        ModuleVideo = r115;
        ModuleType r106 = new ModuleType("ModuleIMFile", 12, 12);
        ModuleIMFile = r106;
        ModuleType r107 = new ModuleType("ModuleCommunication", 13, 13);
        ModuleCommunication = r107;
        ModuleType r108 = new ModuleType("ModuleCalendar", 14, 14);
        ModuleCalendar = r108;
        ModuleType r109 = new ModuleType("ModuleAddressBook", 15, 15);
        ModuleAddressBook = r109;
        ModuleType r116 = new ModuleType("ModuleAPP", 16, 16);
        ModuleAPP = r116;
        ModuleType r117 = new ModuleType("ModuleEmail", 17, 17);
        ModuleEmail = r117;
        ModuleType r118 = new ModuleType("ModuleIM", 18, 18);
        ModuleIM = r118;
        ModuleType r119 = new ModuleType("ModuleDocx", 19, 19);
        ModuleDocx = r119;
        ModuleType r120 = new ModuleType("ModulePeople", 20, 20);
        ModulePeople = r120;
        ModuleType r121 = new ModuleType("ModuleDevice", 21, 21);
        ModuleDevice = r121;
        ModuleType r122 = new ModuleType("ModuleMoments", 22, 22);
        ModuleMoments = r122;
        ModuleType r123 = new ModuleType("ModuleOpenPlatform", 23, 23);
        ModuleOpenPlatform = r123;
        ModuleType r124 = new ModuleType("ModuleDoubao", 24, 24);
        ModuleDoubao = r124;
        $VALUES = new ModuleType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
        ADAPTER = ProtoAdapter.newEnumAdapter(ModuleType.class);
    }

    public static ModuleType[] values() {
        return (ModuleType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ModuleType fromValue(int r100) {
        switch(r100) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            case 8: goto L38;
            case 9: goto L36;
            case 10: goto L34;
            case 11: goto L32;
            case 12: goto L30;
            case 13: goto L28;
            case 14: goto L26;
            case 15: goto L24;
            case 16: goto L22;
            case 17: goto L20;
            case 18: goto L18;
            case 19: goto L16;
            case 20: goto L14;
            case 21: goto L12;
            case 22: goto L10;
            case 23: goto L8;
            case 24: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return ModuleDoubao;
    L8:
        return ModuleOpenPlatform;
    L10:
        return ModuleMoments;
    L12:
        return ModuleDevice;
    L14:
        return ModulePeople;
    L16:
        return ModuleDocx;
    L18:
        return ModuleIM;
    L20:
        return ModuleEmail;
    L22:
        return ModuleAPP;
    L24:
        return ModuleAddressBook;
    L26:
        return ModuleCalendar;
    L28:
        return ModuleCommunication;
    L30:
        return ModuleIMFile;
    L32:
        return ModuleVideo;
    L34:
        return ModuleIMImageAndVideo;
    L36:
        return ModuleChat;
    L38:
        return ModuleSlide;
    L40:
        return ModuleBitable;
    L42:
        return ModuleMindNote;
    L44:
        return ModulePassport;
    L46:
        return ModuleFolders;
    L48:
        return ModuleFiles;
    L50:
        return ModuleSheets;
    L52:
        return ModuleDocs;
    L54:
        return ModuleUnknown;
    }

    public static ModuleType valueOf(String r100) {
        return (ModuleType) a.a(ModuleType.class, r100);
    }

    private ModuleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
