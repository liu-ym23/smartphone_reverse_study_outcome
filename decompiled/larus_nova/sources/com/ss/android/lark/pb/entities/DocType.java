package com.ss.android.lark.pb.entities;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum DocType extends Enum<DocType> implements WireEnum {
    private static final /* synthetic */ DocType[] $VALUES = null;
    public static final ProtoAdapter<DocType> ADAPTER = null;
    public static final DocType BITABLE = null;
    public static final DocType CATALOG = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType FILE = null;
    public static final DocType FOLDER = null;
    public static final DocType MIAODA = null;
    public static final DocType MIAODA_APP_DEVELOPMENT = null;
    public static final DocType MINDNOTE = null;
    public static final DocType SHEET = null;
    public static final DocType SHORTCUT = null;
    public static final DocType SLIDE = null;
    public static final DocType SLIDES = null;
    public static final DocType UNKNOWN_DOC_TYPE = null;
    public static final DocType WIKI = null;
    private final int value;

    static {
        DocType r100 = new DocType("UNKNOWN_DOC_TYPE", 0, 0);
        UNKNOWN_DOC_TYPE = r100;
        DocType r101 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1);
        DOC = r101;
        DocType r102 = new DocType("SHEET", 2, 2);
        SHEET = r102;
        DocType r103 = new DocType("BITABLE", 3, 3);
        BITABLE = r103;
        DocType r104 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 4, 4);
        MINDNOTE = r104;
        DocType r105 = new DocType("FILE", 5, 5);
        FILE = r105;
        DocType r110 = new DocType("SLIDE", 6, 6);
        SLIDE = r110;
        DocType r111 = new DocType("WIKI", 7, 7);
        WIKI = r111;
        DocType r112 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 8, 8);
        DOCX = r112;
        DocType r113 = new DocType("FOLDER", 9, 9);
        FOLDER = r113;
        DocType r114 = new DocType("CATALOG", 10, 10);
        CATALOG = r114;
        DocType r115 = new DocType("SLIDES", 11, 11);
        SLIDES = r115;
        DocType r106 = new DocType("SHORTCUT", 12, 12);
        SHORTCUT = r106;
        DocType r107 = new DocType("MIAODA", 13, 14);
        MIAODA = r107;
        DocType r108 = new DocType("MIAODA_APP_DEVELOPMENT", 14, 15);
        MIAODA_APP_DEVELOPMENT = r108;
        $VALUES = new DocType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        ADAPTER = ProtoAdapter.newEnumAdapter(DocType.class);
    }

    public static DocType[] values() {
        return (DocType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DocType fromValue(int r100) {
        switch(r100) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L3;
            case 14: goto L8;
            case 15: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MIAODA_APP_DEVELOPMENT;
    L8:
        return MIAODA;
    L10:
        return SHORTCUT;
    L12:
        return SLIDES;
    L14:
        return CATALOG;
    L16:
        return FOLDER;
    L18:
        return DOCX;
    L20:
        return WIKI;
    L22:
        return SLIDE;
    L24:
        return FILE;
    L26:
        return MINDNOTE;
    L28:
        return BITABLE;
    L30:
        return SHEET;
    L32:
        return DOC;
    L34:
        return UNKNOWN_DOC_TYPE;
    }

    public static DocType valueOf(String r100) {
        return (DocType) a.a(DocType.class, r100);
    }

    private DocType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
