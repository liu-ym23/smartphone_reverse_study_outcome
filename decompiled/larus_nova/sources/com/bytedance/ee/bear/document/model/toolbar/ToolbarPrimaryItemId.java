package com.bytedance.ee.bear.document.model.toolbar;

import androidx.core.app.NotificationCompat;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.ugc.aweme.discover.model.CommodityText;

/* JADX INFO: loaded from: classes16.dex */
public final enum ToolbarPrimaryItemId extends Enum<ToolbarPrimaryItemId> implements ItemIdV2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolbarPrimaryItemId[] f220261a = null;
    public static final ToolbarPrimaryItemId addNewBlock = null;
    public static final ToolbarPrimaryItemId aiRewrite = null;
    public static final ToolbarPrimaryItemId alignTransform = null;
    public static final ToolbarPrimaryItemId blockTransform = null;
    public static final ToolbarPrimaryItemId calloutBlock = null;
    public static final ToolbarPrimaryItemId checkList = null;
    public static final ToolbarPrimaryItemId checkbox = null;
    public static final ToolbarPrimaryItemId indentLeft = null;
    public static final ToolbarPrimaryItemId indentRight = null;
    public static final ToolbarPrimaryItemId inlineAI = null;
    public static final ToolbarPrimaryItemId insertImage = null;
    public static final ToolbarPrimaryItemId insertTable = null;
    public static final ToolbarPrimaryItemId listTransform = null;
    public static final ToolbarPrimaryItemId mention = null;
    public static final ToolbarPrimaryItemId redo = null;
    public static final ToolbarPrimaryItemId reminder = null;
    public static final ToolbarPrimaryItemId separator = null;
    public static final ToolbarPrimaryItemId textTransform = null;
    public static final ToolbarPrimaryItemId transTask = null;
    public static final ToolbarPrimaryItemId undo = null;

    public static final enum AlignTransformSecondaryItemId extends Enum<AlignTransformSecondaryItemId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AlignTransformSecondaryItemId[] f220262a = null;
        public static final AlignTransformSecondaryItemId alignCenter = null;
        public static final AlignTransformSecondaryItemId alignLeft = null;
        public static final AlignTransformSecondaryItemId alignRight = null;
        public static final AlignTransformSecondaryItemId indentLeft = null;
        public static final AlignTransformSecondaryItemId indentRight = null;
        public static final AlignTransformSecondaryItemId moveDown = null;
        public static final AlignTransformSecondaryItemId moveUp = null;
        public static final AlignTransformSecondaryItemId separator = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            AlignTransformSecondaryItemId r100 = new AlignTransformSecondaryItemId("separator", 0);
            separator = r100;
            AlignTransformSecondaryItemId r101 = new AlignTransformSecondaryItemId("indentLeft", 1);
            indentLeft = r101;
            AlignTransformSecondaryItemId r102 = new AlignTransformSecondaryItemId("indentRight", 2);
            indentRight = r102;
            AlignTransformSecondaryItemId r103 = new AlignTransformSecondaryItemId("alignLeft", 3);
            alignLeft = r103;
            AlignTransformSecondaryItemId r104 = new AlignTransformSecondaryItemId("alignCenter", 4);
            alignCenter = r104;
            AlignTransformSecondaryItemId r105 = new AlignTransformSecondaryItemId("alignRight", 5);
            alignRight = r105;
            AlignTransformSecondaryItemId r110 = new AlignTransformSecondaryItemId("moveUp", 6);
            moveUp = r110;
            AlignTransformSecondaryItemId r111 = new AlignTransformSecondaryItemId("moveDown", 7);
            moveDown = r111;
            f220262a = new AlignTransformSecondaryItemId[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static AlignTransformSecondaryItemId[] values() {
            return (AlignTransformSecondaryItemId[]) f220262a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static AlignTransformSecondaryItemId valueOf(String r100) {
            return (AlignTransformSecondaryItemId) r27.a.a(AlignTransformSecondaryItemId.class, r100);
        }

        public AlignTransformSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum BlockTransformSecondaryItemId extends Enum<BlockTransformSecondaryItemId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BlockTransformSecondaryItemId[] f220263a = null;
        public static final BlockTransformSecondaryItemId blockQuote = null;
        public static final BlockTransformSecondaryItemId checkList = null;
        public static final BlockTransformSecondaryItemId checkbox = null;
        public static final BlockTransformSecondaryItemId codeList = null;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220264h1 = null;

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220265h2 = null;

        /* JADX INFO: renamed from: h3, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220266h3 = null;

        /* JADX INFO: renamed from: h4, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220267h4 = null;

        /* JADX INFO: renamed from: h5, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220268h5 = null;

        /* JADX INFO: renamed from: h6, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220269h6 = null;

        /* JADX INFO: renamed from: h7, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220270h7 = null;

        /* JADX INFO: renamed from: h8, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220271h8 = null;

        /* JADX INFO: renamed from: h9, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220272h9 = null;
        public static final BlockTransformSecondaryItemId insertSeparator = null;
        public static final BlockTransformSecondaryItemId orderedList = null;
        public static final BlockTransformSecondaryItemId plainText = null;
        public static final BlockTransformSecondaryItemId separator = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final BlockTransformSecondaryItemId f220273t = null;
        public static final BlockTransformSecondaryItemId unorderedList = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            BlockTransformSecondaryItemId r100 = new BlockTransformSecondaryItemId("separator", 0);
            separator = r100;
            BlockTransformSecondaryItemId r101 = new BlockTransformSecondaryItemId("t", 1);
            f220273t = r101;
            BlockTransformSecondaryItemId r102 = new BlockTransformSecondaryItemId("h1", 2);
            f220264h1 = r102;
            BlockTransformSecondaryItemId r103 = new BlockTransformSecondaryItemId("h2", 3);
            f220265h2 = r103;
            BlockTransformSecondaryItemId r104 = new BlockTransformSecondaryItemId("h3", 4);
            f220266h3 = r104;
            BlockTransformSecondaryItemId r105 = new BlockTransformSecondaryItemId("h4", 5);
            f220267h4 = r105;
            BlockTransformSecondaryItemId r110 = new BlockTransformSecondaryItemId("h5", 6);
            f220268h5 = r110;
            BlockTransformSecondaryItemId r111 = new BlockTransformSecondaryItemId("h6", 7);
            f220269h6 = r111;
            BlockTransformSecondaryItemId r112 = new BlockTransformSecondaryItemId("h7", 8);
            f220270h7 = r112;
            BlockTransformSecondaryItemId r113 = new BlockTransformSecondaryItemId("h8", 9);
            f220271h8 = r113;
            BlockTransformSecondaryItemId r114 = new BlockTransformSecondaryItemId("h9", 10);
            f220272h9 = r114;
            BlockTransformSecondaryItemId r115 = new BlockTransformSecondaryItemId("checkbox", 11);
            checkbox = r115;
            BlockTransformSecondaryItemId r106 = new BlockTransformSecondaryItemId("checkList", 12);
            checkList = r106;
            BlockTransformSecondaryItemId r107 = new BlockTransformSecondaryItemId("unorderedList", 13);
            unorderedList = r107;
            BlockTransformSecondaryItemId r108 = new BlockTransformSecondaryItemId("orderedList", 14);
            orderedList = r108;
            BlockTransformSecondaryItemId r109 = new BlockTransformSecondaryItemId("codeList", 15);
            codeList = r109;
            BlockTransformSecondaryItemId r116 = new BlockTransformSecondaryItemId("blockQuote", 16);
            blockQuote = r116;
            BlockTransformSecondaryItemId r117 = new BlockTransformSecondaryItemId("insertSeparator", 17);
            insertSeparator = r117;
            BlockTransformSecondaryItemId r118 = new BlockTransformSecondaryItemId("plainText", 18);
            plainText = r118;
            f220263a = new BlockTransformSecondaryItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
        }

        public static BlockTransformSecondaryItemId[] values() {
            return (BlockTransformSecondaryItemId[]) f220263a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static BlockTransformSecondaryItemId valueOf(String r100) {
            return (BlockTransformSecondaryItemId) r27.a.a(BlockTransformSecondaryItemId.class, r100);
        }

        public BlockTransformSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ListTransformSecondaryItemId extends Enum<ListTransformSecondaryItemId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ListTransformSecondaryItemId[] f220274a = null;
        public static final ListTransformSecondaryItemId noneList = null;
        public static final ListTransformSecondaryItemId orderedList = null;
        public static final ListTransformSecondaryItemId unorderedList = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            ListTransformSecondaryItemId r100 = new ListTransformSecondaryItemId("noneList", 0);
            noneList = r100;
            ListTransformSecondaryItemId r101 = new ListTransformSecondaryItemId("unorderedList", 1);
            unorderedList = r101;
            ListTransformSecondaryItemId r102 = new ListTransformSecondaryItemId("orderedList", 2);
            orderedList = r102;
            f220274a = new ListTransformSecondaryItemId[]{r100, r101, r102};
        }

        public static ListTransformSecondaryItemId[] values() {
            return (ListTransformSecondaryItemId[]) f220274a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static ListTransformSecondaryItemId valueOf(String r100) {
            return (ListTransformSecondaryItemId) r27.a.a(ListTransformSecondaryItemId.class, r100);
        }

        public ListTransformSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TextTransformSecondaryItemId extends Enum<TextTransformSecondaryItemId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextTransformSecondaryItemId[] f220275a = null;
        public static final TextTransformSecondaryItemId bold = null;
        public static final TextTransformSecondaryItemId fontColor = null;
        public static final TextTransformSecondaryItemId fontName = null;
        public static final TextTransformSecondaryItemId fontSize = null;
        public static final TextTransformSecondaryItemId highlight = null;
        public static final TextTransformSecondaryItemId inlineCode = null;
        public static final TextTransformSecondaryItemId italic = null;
        public static final TextTransformSecondaryItemId oldHighlight = null;
        public static final TextTransformSecondaryItemId separator = null;
        public static final TextTransformSecondaryItemId strikethrough = null;
        public static final TextTransformSecondaryItemId underline = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            TextTransformSecondaryItemId r100 = new TextTransformSecondaryItemId("separator", 0);
            separator = r100;
            TextTransformSecondaryItemId r101 = new TextTransformSecondaryItemId(CommodityText.BOLD, 1);
            bold = r101;
            TextTransformSecondaryItemId r102 = new TextTransformSecondaryItemId("italic", 2);
            italic = r102;
            TextTransformSecondaryItemId r103 = new TextTransformSecondaryItemId(SegmentStyle.UNDERLINE, 3);
            underline = r103;
            TextTransformSecondaryItemId r104 = new TextTransformSecondaryItemId("strikethrough", 4);
            strikethrough = r104;
            TextTransformSecondaryItemId r105 = new TextTransformSecondaryItemId("highlight", 5);
            highlight = r105;
            TextTransformSecondaryItemId r110 = new TextTransformSecondaryItemId("oldHighlight", 6);
            oldHighlight = r110;
            TextTransformSecondaryItemId r111 = new TextTransformSecondaryItemId("inlineCode", 7);
            inlineCode = r111;
            TextTransformSecondaryItemId r112 = new TextTransformSecondaryItemId("fontSize", 8);
            fontSize = r112;
            TextTransformSecondaryItemId r113 = new TextTransformSecondaryItemId("fontColor", 9);
            fontColor = r113;
            TextTransformSecondaryItemId r114 = new TextTransformSecondaryItemId("fontName", 10);
            fontName = r114;
            f220275a = new TextTransformSecondaryItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static TextTransformSecondaryItemId[] values() {
            return (TextTransformSecondaryItemId[]) f220275a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static TextTransformSecondaryItemId valueOf(String r100) {
            return (TextTransformSecondaryItemId) r27.a.a(TextTransformSecondaryItemId.class, r100);
        }

        public TextTransformSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220276a = null;

        static {
            int[] r100 = new int[ToolbarPrimaryItemId.values().length];
            f220276a = r100;
            r100[ToolbarPrimaryItemId.blockTransform.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f220276a[ToolbarPrimaryItemId.textTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f220276a[ToolbarPrimaryItemId.alignTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f220276a[ToolbarPrimaryItemId.listTransform.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f220276a[ToolbarPrimaryItemId.insertImage.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        ToolbarPrimaryItemId r100 = new ToolbarPrimaryItemId("addNewBlock", 0);
        addNewBlock = r100;
        ToolbarPrimaryItemId r101 = new ToolbarPrimaryItemId("separator", 1);
        separator = r101;
        ToolbarPrimaryItemId r102 = new ToolbarPrimaryItemId("blockTransform", 2);
        blockTransform = r102;
        ToolbarPrimaryItemId r103 = new ToolbarPrimaryItemId("textTransform", 3);
        textTransform = r103;
        ToolbarPrimaryItemId r104 = new ToolbarPrimaryItemId(NotificationCompat.CATEGORY_REMINDER, 4);
        reminder = r104;
        ToolbarPrimaryItemId r105 = new ToolbarPrimaryItemId("alignTransform", 5);
        alignTransform = r105;
        ToolbarPrimaryItemId r110 = new ToolbarPrimaryItemId("insertImage", 6);
        insertImage = r110;
        ToolbarPrimaryItemId r111 = new ToolbarPrimaryItemId("checkbox", 7);
        checkbox = r111;
        ToolbarPrimaryItemId r112 = new ToolbarPrimaryItemId("checkList", 8);
        checkList = r112;
        ToolbarPrimaryItemId r113 = new ToolbarPrimaryItemId("mention", 9);
        mention = r113;
        ToolbarPrimaryItemId r114 = new ToolbarPrimaryItemId("insertTable", 10);
        insertTable = r114;
        ToolbarPrimaryItemId r115 = new ToolbarPrimaryItemId("calloutBlock", 11);
        calloutBlock = r115;
        ToolbarPrimaryItemId r106 = new ToolbarPrimaryItemId("undo", 12);
        undo = r106;
        ToolbarPrimaryItemId r107 = new ToolbarPrimaryItemId("redo", 13);
        redo = r107;
        ToolbarPrimaryItemId r108 = new ToolbarPrimaryItemId("indentLeft", 14);
        indentLeft = r108;
        ToolbarPrimaryItemId r109 = new ToolbarPrimaryItemId("indentRight", 15);
        indentRight = r109;
        ToolbarPrimaryItemId r116 = new ToolbarPrimaryItemId("transTask", 16);
        transTask = r116;
        ToolbarPrimaryItemId r117 = new ToolbarPrimaryItemId("aiRewrite", 17);
        aiRewrite = r117;
        ToolbarPrimaryItemId r118 = new ToolbarPrimaryItemId("inlineAI", 18);
        inlineAI = r118;
        ToolbarPrimaryItemId r119 = new ToolbarPrimaryItemId("listTransform", 19);
        listTransform = r119;
        f220261a = new ToolbarPrimaryItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
    }

    public static ToolbarPrimaryItemId[] values() {
        return (ToolbarPrimaryItemId[]) f220261a.clone();
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public ItemIdV2[] children() {
        int r100 = a.f220276a[ordinal()];
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return null;
    L13:
        return ListTransformSecondaryItemId.values();
    L15:
        return AlignTransformSecondaryItemId.values();
    L17:
        return TextTransformSecondaryItemId.values();
    L19:
        return BlockTransformSecondaryItemId.values();
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public ItemIdV2.DisplayMode displayMode() {
        int r100 = a.f220276a[ordinal()];
        if (r100 == 1) goto L17;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return ItemIdV2.DisplayMode.NoDisplay;
    L15:
        return ItemIdV2.DisplayMode.FunctionPanel;
    L17:
        return ItemIdV2.DisplayMode.SubToolBarV2;
    }

    public static ItemIdV2 of(String r100) {
        ToolbarPrimaryItemId[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ToolbarPrimaryItemId r104 = r101[r103];
        if (r104.name().equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ItemIdV2.ConstId.unknown;
    }

    public static ToolbarPrimaryItemId valueOf(String r100) {
        return (ToolbarPrimaryItemId) r27.a.a(ToolbarPrimaryItemId.class, r100);
    }

    public ToolbarPrimaryItemId(String r100, int r101) {
        super(r100, r101);
    }
}
