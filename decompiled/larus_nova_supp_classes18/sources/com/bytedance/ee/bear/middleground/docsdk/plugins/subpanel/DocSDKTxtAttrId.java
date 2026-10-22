package com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum DocSDKTxtAttrId extends Enum<DocSDKTxtAttrId> implements ItemId {
    public static final /* synthetic */ DocSDKTxtAttrId[] a = null;
    public static final DocSDKTxtAttrId alignCenter = null;
    public static final DocSDKTxtAttrId alignLeft = null;
    public static final DocSDKTxtAttrId alignRight = null;
    public static final DocSDKTxtAttrId blockQuote = null;
    public static final DocSDKTxtAttrId bold = null;
    public static final DocSDKTxtAttrId checkbox = null;
    public static final DocSDKTxtAttrId codeList = null;
    public static final DocSDKTxtAttrId h1 = null;
    public static final DocSDKTxtAttrId h2 = null;
    public static final DocSDKTxtAttrId h3 = null;
    public static final DocSDKTxtAttrId highlight = null;
    public static final DocSDKTxtAttrId inlineCode = null;
    public static final DocSDKTxtAttrId insertSeparator = null;
    public static final DocSDKTxtAttrId italic = null;
    public static final DocSDKTxtAttrId orderedList = null;
    public static final DocSDKTxtAttrId strikethrough = null;
    public static final DocSDKTxtAttrId underline = null;
    public static final DocSDKTxtAttrId unorderedList = null;

    public ItemId[] children() {
        return null;
    }

    static {
        DocSDKTxtAttrId r0 = new DocSDKTxtAttrId("bold", 0);
        bold = r0;
        DocSDKTxtAttrId r1 = new DocSDKTxtAttrId(SegmentStyle.FONT_STYLE_ITALIC, 1);
        italic = r1;
        DocSDKTxtAttrId r3 = new DocSDKTxtAttrId(SegmentStyle.UNDERLINE, 2);
        underline = r3;
        DocSDKTxtAttrId r5 = new DocSDKTxtAttrId("strikethrough", 3);
        strikethrough = r5;
        DocSDKTxtAttrId r7 = new DocSDKTxtAttrId("highlight", 4);
        highlight = r7;
        DocSDKTxtAttrId r9 = new DocSDKTxtAttrId("h1", 5);
        h1 = r9;
        DocSDKTxtAttrId r11 = new DocSDKTxtAttrId("h2", 6);
        h2 = r11;
        DocSDKTxtAttrId r13 = new DocSDKTxtAttrId("h3", 7);
        h3 = r13;
        DocSDKTxtAttrId r15 = new DocSDKTxtAttrId("checkbox", 8);
        checkbox = r15;
        DocSDKTxtAttrId r14 = new DocSDKTxtAttrId("unorderedList", 9);
        unorderedList = r14;
        DocSDKTxtAttrId r12 = new DocSDKTxtAttrId("orderedList", 10);
        orderedList = r12;
        DocSDKTxtAttrId r10 = new DocSDKTxtAttrId("inlineCode", 11);
        inlineCode = r10;
        DocSDKTxtAttrId r8 = new DocSDKTxtAttrId("codeList", 12);
        codeList = r8;
        DocSDKTxtAttrId r6 = new DocSDKTxtAttrId("blockQuote", 13);
        blockQuote = r6;
        DocSDKTxtAttrId r4 = new DocSDKTxtAttrId("alignLeft", 14);
        alignLeft = r4;
        DocSDKTxtAttrId r2 = new DocSDKTxtAttrId("alignCenter", 15);
        alignCenter = r2;
        DocSDKTxtAttrId r16 = new DocSDKTxtAttrId("alignRight", 16);
        alignRight = r16;
        DocSDKTxtAttrId r17 = new DocSDKTxtAttrId("insertSeparator", 17);
        insertSeparator = r17;
        a = new DocSDKTxtAttrId[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
    }

    public static DocSDKTxtAttrId[] values() {
        return (DocSDKTxtAttrId[]) a.clone();
    }

    public static DocSDKTxtAttrId valueOf(String r1) {
        return (DocSDKTxtAttrId) a.a(DocSDKTxtAttrId.class, r1);
    }

    public DocSDKTxtAttrId(String r1, int r2) {
        super(r1, r2);
    }
}
