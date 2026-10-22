package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AccountFromSource extends Enum<AccountFromSource> implements WireEnum {
    private static final /* synthetic */ AccountFromSource[] $VALUES = null;
    public static final ProtoAdapter<AccountFromSource> ADAPTER = null;
    public static final AccountFromSource ADMIN = null;
    public static final AccountFromSource AXON = null;
    public static final AccountFromSource BASE = null;
    public static final AccountFromSource CCM_ANONYMOUS = null;
    public static final AccountFromSource DOUBAO = null;
    public static final AccountFromSource KNOWLEDGE_AI = null;
    public static final AccountFromSource MEEGO = null;
    public static final AccountFromSource MEM_POPE = null;
    public static final AccountFromSource MINUTES = null;
    public static final AccountFromSource OPEN_PLATFORM = null;
    public static final AccountFromSource RECO_PAGE = null;
    public static final AccountFromSource SUITE_OFFICIAL_WEBSITE = null;
    public static final AccountFromSource TTS = null;
    public static final AccountFromSource UNKNOWN = null;
    private final int value;

    static {
        AccountFromSource r100 = new AccountFromSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        AccountFromSource r101 = new AccountFromSource("ADMIN", 1, 1);
        ADMIN = r101;
        AccountFromSource r102 = new AccountFromSource("SUITE_OFFICIAL_WEBSITE", 2, 2);
        SUITE_OFFICIAL_WEBSITE = r102;
        AccountFromSource r103 = new AccountFromSource("OPEN_PLATFORM", 3, 3);
        OPEN_PLATFORM = r103;
        AccountFromSource r104 = new AccountFromSource("MEEGO", 4, 4);
        MEEGO = r104;
        AccountFromSource r105 = new AccountFromSource("TTS", 5, 5);
        TTS = r105;
        AccountFromSource r110 = new AccountFromSource("CCM_ANONYMOUS", 6, 6);
        CCM_ANONYMOUS = r110;
        AccountFromSource r111 = new AccountFromSource("BASE", 7, 7);
        BASE = r111;
        AccountFromSource r112 = new AccountFromSource("RECO_PAGE", 8, 8);
        RECO_PAGE = r112;
        AccountFromSource r113 = new AccountFromSource("KNOWLEDGE_AI", 9, 9);
        KNOWLEDGE_AI = r113;
        AccountFromSource r114 = new AccountFromSource("AXON", 10, 10);
        AXON = r114;
        AccountFromSource r115 = new AccountFromSource("MEM_POPE", 11, 11);
        MEM_POPE = r115;
        AccountFromSource r106 = new AccountFromSource("DOUBAO", 12, 12);
        DOUBAO = r106;
        AccountFromSource r107 = new AccountFromSource("MINUTES", 13, 13);
        MINUTES = r107;
        $VALUES = new AccountFromSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        ADAPTER = ProtoAdapter.newEnumAdapter(AccountFromSource.class);
    }

    public static AccountFromSource[] values() {
        return (AccountFromSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AccountFromSource fromValue(int r100) {
        switch(r100) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            case 10: goto L12;
            case 11: goto L10;
            case 12: goto L8;
            case 13: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MINUTES;
    L8:
        return DOUBAO;
    L10:
        return MEM_POPE;
    L12:
        return AXON;
    L14:
        return KNOWLEDGE_AI;
    L16:
        return RECO_PAGE;
    L18:
        return BASE;
    L20:
        return CCM_ANONYMOUS;
    L22:
        return TTS;
    L24:
        return MEEGO;
    L26:
        return OPEN_PLATFORM;
    L28:
        return SUITE_OFFICIAL_WEBSITE;
    L30:
        return ADMIN;
    L32:
        return UNKNOWN;
    }

    public static AccountFromSource valueOf(String r100) {
        return (AccountFromSource) a.a(AccountFromSource.class, r100);
    }

    private AccountFromSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
