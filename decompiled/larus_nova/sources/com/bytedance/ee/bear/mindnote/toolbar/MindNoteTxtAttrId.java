package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum MindNoteTxtAttrId extends Enum<MindNoteTxtAttrId> implements ItemId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MindNoteTxtAttrId[] f234485a = null;
    public static final MindNoteTxtAttrId bold = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final MindNoteTxtAttrId f234486h1 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final MindNoteTxtAttrId f234487h2 = null;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final MindNoteTxtAttrId f234488h3 = null;
    public static final MindNoteTxtAttrId highlight = null;
    public static final MindNoteTxtAttrId italic = null;
    public static final MindNoteTxtAttrId underline = null;

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        return null;
    }

    static {
        MindNoteTxtAttrId r100 = new MindNoteTxtAttrId(CommodityText.BOLD, 0);
        bold = r100;
        MindNoteTxtAttrId r101 = new MindNoteTxtAttrId("italic", 1);
        italic = r101;
        MindNoteTxtAttrId r102 = new MindNoteTxtAttrId(SegmentStyle.UNDERLINE, 2);
        underline = r102;
        MindNoteTxtAttrId r103 = new MindNoteTxtAttrId("h1", 3);
        f234486h1 = r103;
        MindNoteTxtAttrId r104 = new MindNoteTxtAttrId("h2", 4);
        f234487h2 = r104;
        MindNoteTxtAttrId r105 = new MindNoteTxtAttrId("h3", 5);
        f234488h3 = r105;
        MindNoteTxtAttrId r110 = new MindNoteTxtAttrId("highlight", 6);
        highlight = r110;
        f234485a = new MindNoteTxtAttrId[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static MindNoteTxtAttrId[] values() {
        return (MindNoteTxtAttrId[]) f234485a.clone();
    }

    public static MindNoteTxtAttrId valueOf(String r100) {
        return (MindNoteTxtAttrId) a.a(MindNoteTxtAttrId.class, r100);
    }

    public MindNoteTxtAttrId(String r100, int r101) {
        super(r100, r101);
    }
}
