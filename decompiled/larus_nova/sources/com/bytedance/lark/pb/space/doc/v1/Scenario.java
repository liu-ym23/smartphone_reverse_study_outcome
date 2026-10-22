package com.bytedance.lark.pb.space.doc.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum Scenario extends Enum<Scenario> implements WireEnum {
    private static final /* synthetic */ Scenario[] $VALUES = null;
    public static final ProtoAdapter<Scenario> ADAPTER = null;
    public static final Scenario BASE = null;
    public static final Scenario BOARD = null;
    public static final Scenario CALENDAR = null;
    public static final Scenario DOC = null;
    public static final Scenario EMAIL = null;
    public static final Scenario GROUP_CHAT = null;
    public static final Scenario IM = null;
    public static final Scenario MEEGO = null;
    public static final Scenario OPEN_WEB_CONTAINER = null;
    public static final Scenario P2P_CHAT = null;
    public static final Scenario PDF_VIEW = null;
    public static final Scenario SEARCH = null;
    public static final Scenario SHEET = null;
    public static final Scenario SLIDES = null;
    public static final Scenario VC = null;
    public static final Scenario VOICE_INPUT = null;
    public static final Scenario WIKI_SPACE = null;
    private final int value;

    static {
        Scenario r100 = new Scenario("IM", 0, 0);
        IM = r100;
        Scenario r101 = new Scenario(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1);
        DOC = r101;
        Scenario r102 = new Scenario("SHEET", 2, 2);
        SHEET = r102;
        Scenario r103 = new Scenario("BASE", 3, 3);
        BASE = r103;
        Scenario r104 = new Scenario("VC", 4, 4);
        VC = r104;
        Scenario r105 = new Scenario("CALENDAR", 5, 5);
        CALENDAR = r105;
        Scenario r110 = new Scenario(CommonConstant.RETKEY.EMAIL, 6, 6);
        EMAIL = r110;
        Scenario r111 = new Scenario("MEEGO", 7, 7);
        MEEGO = r111;
        Scenario r112 = new Scenario("OPEN_WEB_CONTAINER", 8, 8);
        OPEN_WEB_CONTAINER = r112;
        Scenario r113 = new Scenario("SEARCH", 9, 9);
        SEARCH = r113;
        Scenario r114 = new Scenario("SLIDES", 10, 10);
        SLIDES = r114;
        Scenario r115 = new Scenario("GROUP_CHAT", 11, 11);
        GROUP_CHAT = r115;
        Scenario r106 = new Scenario("P2P_CHAT", 12, 12);
        P2P_CHAT = r106;
        Scenario r107 = new Scenario("BOARD", 13, 13);
        BOARD = r107;
        Scenario r108 = new Scenario("PDF_VIEW", 14, 14);
        PDF_VIEW = r108;
        Scenario r109 = new Scenario("WIKI_SPACE", 15, 15);
        WIKI_SPACE = r109;
        Scenario r116 = new Scenario("VOICE_INPUT", 16, 16);
        VOICE_INPUT = r116;
        $VALUES = new Scenario[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        ADAPTER = ProtoAdapter.newEnumAdapter(Scenario.class);
    }

    public static Scenario[] values() {
        return (Scenario[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Scenario fromValue(int r100) {
        switch(r100) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L12;
            case 14: goto L10;
            case 15: goto L8;
            case 16: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VOICE_INPUT;
    L8:
        return WIKI_SPACE;
    L10:
        return PDF_VIEW;
    L12:
        return BOARD;
    L14:
        return P2P_CHAT;
    L16:
        return GROUP_CHAT;
    L18:
        return SLIDES;
    L20:
        return SEARCH;
    L22:
        return OPEN_WEB_CONTAINER;
    L24:
        return MEEGO;
    L26:
        return EMAIL;
    L28:
        return CALENDAR;
    L30:
        return VC;
    L32:
        return BASE;
    L34:
        return SHEET;
    L36:
        return DOC;
    L38:
        return IM;
    }

    public static Scenario valueOf(String r100) {
        return (Scenario) a.a(Scenario.class, r100);
    }

    private Scenario(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
