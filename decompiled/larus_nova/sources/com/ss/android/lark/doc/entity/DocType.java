package com.ss.android.lark.doc.entity;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum DocType extends Enum<DocType> {
    public static final DocType BITABLE = null;
    public static final DocType CATALOG = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType DOCX_SYNCED_BLOCK = null;
    public static final DocType DOUBAO_CHAT = null;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocType[] f420495a = null;
    private int value;

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
        DocType r107 = new DocType("DOCX_SYNCED_BLOCK", 13, 13);
        DOCX_SYNCED_BLOCK = r107;
        DocType r108 = new DocType("MIAODA", 14, 14);
        MIAODA = r108;
        DocType r109 = new DocType("MIAODA_APP_DEVELOPMENT", 15, 15);
        MIAODA_APP_DEVELOPMENT = r109;
        DocType r116 = new DocType("DOUBAO_CHAT", 16, 16);
        DOUBAO_CHAT = r116;
        f420495a = new DocType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
    }

    public static DocType[] values() {
        return (DocType[]) f420495a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static DocType forNumber(int r100) {
        switch(r100) {
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
            default: goto L4;
        };
    L4:
        return UNKNOWN_DOC_TYPE;
    L6:
        return DOUBAO_CHAT;
    L8:
        return MIAODA_APP_DEVELOPMENT;
    L10:
        return MIAODA;
    L12:
        return DOCX_SYNCED_BLOCK;
    L14:
        return SHORTCUT;
    L16:
        return SLIDES;
    L18:
        return CATALOG;
    L20:
        return FOLDER;
    L22:
        return DOCX;
    L24:
        return WIKI;
    L26:
        return SLIDE;
    L28:
        return FILE;
    L30:
        return MINDNOTE;
    L32:
        return BITABLE;
    L34:
        return SHEET;
    L36:
        return DOC;
    }

    public static DocType valueOf(String r100) {
        return (DocType) a.a(DocType.class, r100);
    }

    public DocType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
