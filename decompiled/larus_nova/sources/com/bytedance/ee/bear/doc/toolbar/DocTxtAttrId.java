package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum DocTxtAttrId extends Enum<DocTxtAttrId> implements ItemId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocTxtAttrId[] f218297a = null;
    public static final DocTxtAttrId alignCenter = null;
    public static final DocTxtAttrId alignLeft = null;
    public static final DocTxtAttrId alignRight = null;
    public static final DocTxtAttrId blockQuote = null;
    public static final DocTxtAttrId bold = null;
    public static final DocTxtAttrId checkbox = null;
    public static final DocTxtAttrId codeList = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final DocTxtAttrId f218298h1 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final DocTxtAttrId f218299h2 = null;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final DocTxtAttrId f218300h3 = null;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public static final DocTxtAttrId f218301h4 = null;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    public static final DocTxtAttrId f218302h5 = null;

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    public static final DocTxtAttrId f218303h6 = null;

    /* JADX INFO: renamed from: h7, reason: collision with root package name */
    public static final DocTxtAttrId f218304h7 = null;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final DocTxtAttrId f218305h8 = null;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public static final DocTxtAttrId f218306h9 = null;
    public static final DocTxtAttrId highlight = null;
    public static final DocTxtAttrId inlineCode = null;
    public static final DocTxtAttrId insertSeparator = null;
    public static final DocTxtAttrId italic = null;
    public static final DocTxtAttrId orderedList = null;
    public static final DocTxtAttrId strikethrough = null;
    public static final DocTxtAttrId underline = null;
    public static final DocTxtAttrId unorderedList = null;

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        return null;
    }

    static {
        DocTxtAttrId r100 = new DocTxtAttrId(CommodityText.BOLD, 0);
        bold = r100;
        DocTxtAttrId r101 = new DocTxtAttrId("italic", 1);
        italic = r101;
        DocTxtAttrId r102 = new DocTxtAttrId(SegmentStyle.UNDERLINE, 2);
        underline = r102;
        DocTxtAttrId r103 = new DocTxtAttrId("strikethrough", 3);
        strikethrough = r103;
        DocTxtAttrId r104 = new DocTxtAttrId("highlight", 4);
        highlight = r104;
        DocTxtAttrId r105 = new DocTxtAttrId("h1", 5);
        f218298h1 = r105;
        DocTxtAttrId r110 = new DocTxtAttrId("h2", 6);
        f218299h2 = r110;
        DocTxtAttrId r111 = new DocTxtAttrId("h3", 7);
        f218300h3 = r111;
        DocTxtAttrId r112 = new DocTxtAttrId("h4", 8);
        f218301h4 = r112;
        DocTxtAttrId r113 = new DocTxtAttrId("h5", 9);
        f218302h5 = r113;
        DocTxtAttrId r114 = new DocTxtAttrId("h6", 10);
        f218303h6 = r114;
        DocTxtAttrId r115 = new DocTxtAttrId("h7", 11);
        f218304h7 = r115;
        DocTxtAttrId r106 = new DocTxtAttrId("h8", 12);
        f218305h8 = r106;
        DocTxtAttrId r107 = new DocTxtAttrId("h9", 13);
        f218306h9 = r107;
        DocTxtAttrId r108 = new DocTxtAttrId("checkbox", 14);
        checkbox = r108;
        DocTxtAttrId r109 = new DocTxtAttrId("unorderedList", 15);
        unorderedList = r109;
        DocTxtAttrId r116 = new DocTxtAttrId("orderedList", 16);
        orderedList = r116;
        DocTxtAttrId r117 = new DocTxtAttrId("inlineCode", 17);
        inlineCode = r117;
        DocTxtAttrId r118 = new DocTxtAttrId("codeList", 18);
        codeList = r118;
        DocTxtAttrId r119 = new DocTxtAttrId("blockQuote", 19);
        blockQuote = r119;
        DocTxtAttrId r120 = new DocTxtAttrId("alignLeft", 20);
        alignLeft = r120;
        DocTxtAttrId r121 = new DocTxtAttrId("alignCenter", 21);
        alignCenter = r121;
        DocTxtAttrId r122 = new DocTxtAttrId("alignRight", 22);
        alignRight = r122;
        DocTxtAttrId r123 = new DocTxtAttrId("insertSeparator", 23);
        insertSeparator = r123;
        f218297a = new DocTxtAttrId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public static DocTxtAttrId[] values() {
        return (DocTxtAttrId[]) f218297a.clone();
    }

    public static DocTxtAttrId valueOf(String r100) {
        return (DocTxtAttrId) a.a(DocTxtAttrId.class, r100);
    }

    public DocTxtAttrId(String r100, int r101) {
        super(r100, r101);
    }
}
