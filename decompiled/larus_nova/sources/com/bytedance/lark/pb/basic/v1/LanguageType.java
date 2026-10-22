package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum LanguageType extends Enum<LanguageType> implements WireEnum {
    private static final /* synthetic */ LanguageType[] $VALUES = null;
    public static final ProtoAdapter<LanguageType> ADAPTER = null;
    public static final LanguageType DE_DE = null;
    public static final LanguageType EN_US = null;
    public static final LanguageType ES_ES = null;
    public static final LanguageType FR_FR = null;
    public static final LanguageType HI_IN = null;
    public static final LanguageType ID_ID = null;
    public static final LanguageType IT_IT = null;
    public static final LanguageType JA_JP = null;
    public static final LanguageType KO_KR = null;
    public static final LanguageType MS_MY = null;
    public static final LanguageType PT_BR = null;
    public static final LanguageType RU_RU = null;
    public static final LanguageType RW = null;
    public static final LanguageType SE_JO = null;
    public static final LanguageType TH_TH = null;
    public static final LanguageType UNKNOWN_LANGUAGE = null;
    public static final LanguageType VI_VN = null;
    public static final LanguageType ZH_CN = null;
    public static final LanguageType ZH_HK = null;
    public static final LanguageType ZH_TW = null;
    private final int value;

    static {
        LanguageType r100 = new LanguageType("UNKNOWN_LANGUAGE", 0, 0);
        UNKNOWN_LANGUAGE = r100;
        LanguageType r101 = new LanguageType("ZH_CN", 1, 1);
        ZH_CN = r101;
        LanguageType r102 = new LanguageType("EN_US", 2, 2);
        EN_US = r102;
        LanguageType r103 = new LanguageType("JA_JP", 3, 3);
        JA_JP = r103;
        LanguageType r104 = new LanguageType("RW", 4, 4);
        RW = r104;
        LanguageType r105 = new LanguageType("ES_ES", 5, 5);
        ES_ES = r105;
        LanguageType r110 = new LanguageType("IT_IT", 6, 6);
        IT_IT = r110;
        LanguageType r111 = new LanguageType("DE_DE", 7, 7);
        DE_DE = r111;
        LanguageType r112 = new LanguageType("FR_FR", 8, 8);
        FR_FR = r112;
        LanguageType r113 = new LanguageType("PT_BR", 9, 9);
        PT_BR = r113;
        LanguageType r114 = new LanguageType("ID_ID", 10, 10);
        ID_ID = r114;
        LanguageType r115 = new LanguageType("VI_VN", 11, 11);
        VI_VN = r115;
        LanguageType r106 = new LanguageType("TH_TH", 12, 12);
        TH_TH = r106;
        LanguageType r107 = new LanguageType("KO_KR", 13, 13);
        KO_KR = r107;
        LanguageType r108 = new LanguageType("RU_RU", 14, 14);
        RU_RU = r108;
        LanguageType r109 = new LanguageType("HI_IN", 15, 15);
        HI_IN = r109;
        LanguageType r116 = new LanguageType("ZH_HK", 16, 16);
        ZH_HK = r116;
        LanguageType r117 = new LanguageType("ZH_TW", 17, 17);
        ZH_TW = r117;
        LanguageType r118 = new LanguageType("MS_MY", 18, 18);
        MS_MY = r118;
        LanguageType r119 = new LanguageType("SE_JO", 19, 99);
        SE_JO = r119;
        $VALUES = new LanguageType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        ADAPTER = ProtoAdapter.newEnumAdapter(LanguageType.class);
    }

    public static LanguageType[] values() {
        return (LanguageType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LanguageType fromValue(int r100) {
        if (r100 == 99) goto L46;
        switch(r100) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L34;
            case 6: goto L32;
            case 7: goto L30;
            case 8: goto L28;
            case 9: goto L26;
            case 10: goto L24;
            case 11: goto L22;
            case 12: goto L20;
            case 13: goto L18;
            case 14: goto L16;
            case 15: goto L14;
            case 16: goto L12;
            case 17: goto L10;
            case 18: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return MS_MY;
    L10:
        return ZH_TW;
    L12:
        return ZH_HK;
    L14:
        return HI_IN;
    L16:
        return RU_RU;
    L18:
        return KO_KR;
    L20:
        return TH_TH;
    L22:
        return VI_VN;
    L24:
        return ID_ID;
    L26:
        return PT_BR;
    L28:
        return FR_FR;
    L30:
        return DE_DE;
    L32:
        return IT_IT;
    L34:
        return ES_ES;
    L36:
        return RW;
    L38:
        return JA_JP;
    L40:
        return EN_US;
    L42:
        return ZH_CN;
    L44:
        return UNKNOWN_LANGUAGE;
    L46:
        return SE_JO;
    }

    public static LanguageType valueOf(String r100) {
        return (LanguageType) a.a(LanguageType.class, r100);
    }

    private LanguageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
