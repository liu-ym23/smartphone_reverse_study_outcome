package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum MindNoteTxtAttrId extends Enum<MindNoteTxtAttrId> implements ItemId {
    public static final /* synthetic */ MindNoteTxtAttrId[] a = null;
    public static final MindNoteTxtAttrId bold = null;
    public static final MindNoteTxtAttrId h1 = null;
    public static final MindNoteTxtAttrId h2 = null;
    public static final MindNoteTxtAttrId h3 = null;
    public static final MindNoteTxtAttrId highlight = null;
    public static final MindNoteTxtAttrId italic = null;
    public static final MindNoteTxtAttrId underline = null;

    public ItemId[] children() {
        return null;
    }

    static {
        MindNoteTxtAttrId r0 = new MindNoteTxtAttrId("bold", 0);
        bold = r0;
        MindNoteTxtAttrId r1 = new MindNoteTxtAttrId(SegmentStyle.FONT_STYLE_ITALIC, 1);
        italic = r1;
        MindNoteTxtAttrId r3 = new MindNoteTxtAttrId(SegmentStyle.UNDERLINE, 2);
        underline = r3;
        MindNoteTxtAttrId r5 = new MindNoteTxtAttrId("h1", 3);
        h1 = r5;
        MindNoteTxtAttrId r7 = new MindNoteTxtAttrId("h2", 4);
        h2 = r7;
        MindNoteTxtAttrId r9 = new MindNoteTxtAttrId("h3", 5);
        h3 = r9;
        MindNoteTxtAttrId r11 = new MindNoteTxtAttrId("highlight", 6);
        highlight = r11;
        a = new MindNoteTxtAttrId[]{r0, r1, r3, r5, r7, r9, r11};
    }

    public static MindNoteTxtAttrId[] values() {
        return (MindNoteTxtAttrId[]) a.clone();
    }

    public static MindNoteTxtAttrId valueOf(String r1) {
        return (MindNoteTxtAttrId) a.a(MindNoteTxtAttrId.class, r1);
    }

    public MindNoteTxtAttrId(String r1, int r2) {
        super(r1, r2);
    }
}
