package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum DocTxtAttrId extends Enum<DocTxtAttrId> implements ItemId {
    public static final /* synthetic */ DocTxtAttrId[] a = null;
    public static final DocTxtAttrId alignCenter = null;
    public static final DocTxtAttrId alignLeft = null;
    public static final DocTxtAttrId alignRight = null;
    public static final DocTxtAttrId blockQuote = null;
    public static final DocTxtAttrId bold = null;
    public static final DocTxtAttrId checkbox = null;
    public static final DocTxtAttrId codeList = null;
    public static final DocTxtAttrId h1 = null;
    public static final DocTxtAttrId h2 = null;
    public static final DocTxtAttrId h3 = null;
    public static final DocTxtAttrId h4 = null;
    public static final DocTxtAttrId h5 = null;
    public static final DocTxtAttrId h6 = null;
    public static final DocTxtAttrId h7 = null;
    public static final DocTxtAttrId h8 = null;
    public static final DocTxtAttrId h9 = null;
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
        DocTxtAttrId r0 = new DocTxtAttrId("bold", 0);
        bold = r0;
        DocTxtAttrId r1 = new DocTxtAttrId("italic", 1);
        italic = r1;
        DocTxtAttrId r3 = new DocTxtAttrId("underline", 2);
        underline = r3;
        DocTxtAttrId r5 = new DocTxtAttrId("strikethrough", 3);
        strikethrough = r5;
        DocTxtAttrId r7 = new DocTxtAttrId("highlight", 4);
        highlight = r7;
        DocTxtAttrId r9 = new DocTxtAttrId("h1", 5);
        h1 = r9;
        DocTxtAttrId r11 = new DocTxtAttrId("h2", 6);
        h2 = r11;
        DocTxtAttrId r13 = new DocTxtAttrId("h3", 7);
        h3 = r13;
        DocTxtAttrId r16 = new DocTxtAttrId("h4", 8);
        h4 = r16;
        DocTxtAttrId r14 = new DocTxtAttrId("h5", 9);
        h5 = r14;
        DocTxtAttrId r12 = new DocTxtAttrId("h6", 10);
        h6 = r12;
        DocTxtAttrId r10 = new DocTxtAttrId("h7", 11);
        h7 = r10;
        DocTxtAttrId r8 = new DocTxtAttrId("h8", 12);
        h8 = r8;
        DocTxtAttrId r6 = new DocTxtAttrId("h9", 13);
        h9 = r6;
        DocTxtAttrId r4 = new DocTxtAttrId("checkbox", 14);
        checkbox = r4;
        DocTxtAttrId r2 = new DocTxtAttrId("unorderedList", 15);
        unorderedList = r2;
        DocTxtAttrId r17 = new DocTxtAttrId("orderedList", 16);
        orderedList = r17;
        DocTxtAttrId r18 = new DocTxtAttrId("inlineCode", 17);
        inlineCode = r18;
        DocTxtAttrId r19 = new DocTxtAttrId("codeList", 18);
        codeList = r19;
        DocTxtAttrId r20 = new DocTxtAttrId("blockQuote", 19);
        blockQuote = r20;
        DocTxtAttrId r21 = new DocTxtAttrId("alignLeft", 20);
        alignLeft = r21;
        DocTxtAttrId r22 = new DocTxtAttrId("alignCenter", 21);
        alignCenter = r22;
        DocTxtAttrId r23 = new DocTxtAttrId("alignRight", 22);
        alignRight = r23;
        DocTxtAttrId r24 = new DocTxtAttrId("insertSeparator", 23);
        insertSeparator = r24;
        a = new DocTxtAttrId[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2, r17, r18, r19, r20, r21, r22, r23, r24};
    }

    public static DocTxtAttrId[] values() {
        return (DocTxtAttrId[]) a.clone();
    }

    public static DocTxtAttrId valueOf(String r1) {
        return (DocTxtAttrId) a.a(DocTxtAttrId.class, r1);
    }

    public DocTxtAttrId(String r1, int r2) {
        super(r1, r2);
    }
}
