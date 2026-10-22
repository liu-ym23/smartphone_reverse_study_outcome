package com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum DocSDKTxtAttrId extends Enum<DocSDKTxtAttrId> implements ItemId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocSDKTxtAttrId[] f232376a = null;
    public static final DocSDKTxtAttrId alignCenter = null;
    public static final DocSDKTxtAttrId alignLeft = null;
    public static final DocSDKTxtAttrId alignRight = null;
    public static final DocSDKTxtAttrId blockQuote = null;
    public static final DocSDKTxtAttrId bold = null;
    public static final DocSDKTxtAttrId checkbox = null;
    public static final DocSDKTxtAttrId codeList = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final DocSDKTxtAttrId f232377h1 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final DocSDKTxtAttrId f232378h2 = null;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final DocSDKTxtAttrId f232379h3 = null;
    public static final DocSDKTxtAttrId highlight = null;
    public static final DocSDKTxtAttrId inlineCode = null;
    public static final DocSDKTxtAttrId insertSeparator = null;
    public static final DocSDKTxtAttrId italic = null;
    public static final DocSDKTxtAttrId orderedList = null;
    public static final DocSDKTxtAttrId strikethrough = null;
    public static final DocSDKTxtAttrId underline = null;
    public static final DocSDKTxtAttrId unorderedList = null;

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        return null;
    }

    static {
        DocSDKTxtAttrId r100 = new DocSDKTxtAttrId(CommodityText.BOLD, 0);
        bold = r100;
        DocSDKTxtAttrId r101 = new DocSDKTxtAttrId("italic", 1);
        italic = r101;
        DocSDKTxtAttrId r102 = new DocSDKTxtAttrId(SegmentStyle.UNDERLINE, 2);
        underline = r102;
        DocSDKTxtAttrId r103 = new DocSDKTxtAttrId("strikethrough", 3);
        strikethrough = r103;
        DocSDKTxtAttrId r104 = new DocSDKTxtAttrId("highlight", 4);
        highlight = r104;
        DocSDKTxtAttrId r105 = new DocSDKTxtAttrId("h1", 5);
        f232377h1 = r105;
        DocSDKTxtAttrId r110 = new DocSDKTxtAttrId("h2", 6);
        f232378h2 = r110;
        DocSDKTxtAttrId r111 = new DocSDKTxtAttrId("h3", 7);
        f232379h3 = r111;
        DocSDKTxtAttrId r112 = new DocSDKTxtAttrId("checkbox", 8);
        checkbox = r112;
        DocSDKTxtAttrId r113 = new DocSDKTxtAttrId("unorderedList", 9);
        unorderedList = r113;
        DocSDKTxtAttrId r114 = new DocSDKTxtAttrId("orderedList", 10);
        orderedList = r114;
        DocSDKTxtAttrId r115 = new DocSDKTxtAttrId("inlineCode", 11);
        inlineCode = r115;
        DocSDKTxtAttrId r106 = new DocSDKTxtAttrId("codeList", 12);
        codeList = r106;
        DocSDKTxtAttrId r107 = new DocSDKTxtAttrId("blockQuote", 13);
        blockQuote = r107;
        DocSDKTxtAttrId r108 = new DocSDKTxtAttrId("alignLeft", 14);
        alignLeft = r108;
        DocSDKTxtAttrId r109 = new DocSDKTxtAttrId("alignCenter", 15);
        alignCenter = r109;
        DocSDKTxtAttrId r116 = new DocSDKTxtAttrId("alignRight", 16);
        alignRight = r116;
        DocSDKTxtAttrId r117 = new DocSDKTxtAttrId("insertSeparator", 17);
        insertSeparator = r117;
        f232376a = new DocSDKTxtAttrId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
    }

    public static DocSDKTxtAttrId[] values() {
        return (DocSDKTxtAttrId[]) f232376a.clone();
    }

    public static DocSDKTxtAttrId valueOf(String r100) {
        return (DocSDKTxtAttrId) a.a(DocSDKTxtAttrId.class, r100);
    }

    public DocSDKTxtAttrId(String r100, int r101) {
        super(r100, r101);
    }
}
