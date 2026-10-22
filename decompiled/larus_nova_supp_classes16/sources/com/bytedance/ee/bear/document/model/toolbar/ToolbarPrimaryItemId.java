package com.bytedance.ee.bear.document.model.toolbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ToolbarPrimaryItemId extends Enum<ToolbarPrimaryItemId> implements ItemIdV2.a {
    public static final /* synthetic */ ToolbarPrimaryItemId[] a = null;
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
        public static final /* synthetic */ AlignTransformSecondaryItemId[] a = null;
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
            AlignTransformSecondaryItemId r0 = new AlignTransformSecondaryItemId("separator", 0);
            separator = r0;
            AlignTransformSecondaryItemId r1 = new AlignTransformSecondaryItemId("indentLeft", 1);
            indentLeft = r1;
            AlignTransformSecondaryItemId r3 = new AlignTransformSecondaryItemId("indentRight", 2);
            indentRight = r3;
            AlignTransformSecondaryItemId r5 = new AlignTransformSecondaryItemId("alignLeft", 3);
            alignLeft = r5;
            AlignTransformSecondaryItemId r7 = new AlignTransformSecondaryItemId("alignCenter", 4);
            alignCenter = r7;
            AlignTransformSecondaryItemId r9 = new AlignTransformSecondaryItemId("alignRight", 5);
            alignRight = r9;
            AlignTransformSecondaryItemId r11 = new AlignTransformSecondaryItemId("moveUp", 6);
            moveUp = r11;
            AlignTransformSecondaryItemId r13 = new AlignTransformSecondaryItemId("moveDown", 7);
            moveDown = r13;
            a = new AlignTransformSecondaryItemId[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static AlignTransformSecondaryItemId[] values() {
            return (AlignTransformSecondaryItemId[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static AlignTransformSecondaryItemId valueOf(String r1) {
            return (AlignTransformSecondaryItemId) r27.a.a(AlignTransformSecondaryItemId.class, r1);
        }

        public AlignTransformSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum BlockTransformSecondaryItemId extends Enum<BlockTransformSecondaryItemId> implements ItemIdV2 {
        public static final /* synthetic */ BlockTransformSecondaryItemId[] a = null;
        public static final BlockTransformSecondaryItemId blockQuote = null;
        public static final BlockTransformSecondaryItemId checkList = null;
        public static final BlockTransformSecondaryItemId checkbox = null;
        public static final BlockTransformSecondaryItemId codeList = null;
        public static final BlockTransformSecondaryItemId h1 = null;
        public static final BlockTransformSecondaryItemId h2 = null;
        public static final BlockTransformSecondaryItemId h3 = null;
        public static final BlockTransformSecondaryItemId h4 = null;
        public static final BlockTransformSecondaryItemId h5 = null;
        public static final BlockTransformSecondaryItemId h6 = null;
        public static final BlockTransformSecondaryItemId h7 = null;
        public static final BlockTransformSecondaryItemId h8 = null;
        public static final BlockTransformSecondaryItemId h9 = null;
        public static final BlockTransformSecondaryItemId insertSeparator = null;
        public static final BlockTransformSecondaryItemId orderedList = null;
        public static final BlockTransformSecondaryItemId plainText = null;
        public static final BlockTransformSecondaryItemId separator = null;
        public static final BlockTransformSecondaryItemId t = null;
        public static final BlockTransformSecondaryItemId unorderedList = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            BlockTransformSecondaryItemId r0 = new BlockTransformSecondaryItemId("separator", 0);
            separator = r0;
            BlockTransformSecondaryItemId r1 = new BlockTransformSecondaryItemId("t", 1);
            t = r1;
            BlockTransformSecondaryItemId r3 = new BlockTransformSecondaryItemId("h1", 2);
            h1 = r3;
            BlockTransformSecondaryItemId r5 = new BlockTransformSecondaryItemId("h2", 3);
            h2 = r5;
            BlockTransformSecondaryItemId r7 = new BlockTransformSecondaryItemId("h3", 4);
            h3 = r7;
            BlockTransformSecondaryItemId r9 = new BlockTransformSecondaryItemId("h4", 5);
            h4 = r9;
            BlockTransformSecondaryItemId r11 = new BlockTransformSecondaryItemId("h5", 6);
            h5 = r11;
            BlockTransformSecondaryItemId r13 = new BlockTransformSecondaryItemId("h6", 7);
            h6 = r13;
            BlockTransformSecondaryItemId r16 = new BlockTransformSecondaryItemId("h7", 8);
            h7 = r16;
            BlockTransformSecondaryItemId r14 = new BlockTransformSecondaryItemId("h8", 9);
            h8 = r14;
            BlockTransformSecondaryItemId r12 = new BlockTransformSecondaryItemId("h9", 10);
            h9 = r12;
            BlockTransformSecondaryItemId r10 = new BlockTransformSecondaryItemId("checkbox", 11);
            checkbox = r10;
            BlockTransformSecondaryItemId r8 = new BlockTransformSecondaryItemId("checkList", 12);
            checkList = r8;
            BlockTransformSecondaryItemId r6 = new BlockTransformSecondaryItemId("unorderedList", 13);
            unorderedList = r6;
            BlockTransformSecondaryItemId r4 = new BlockTransformSecondaryItemId("orderedList", 14);
            orderedList = r4;
            BlockTransformSecondaryItemId r2 = new BlockTransformSecondaryItemId("codeList", 15);
            codeList = r2;
            BlockTransformSecondaryItemId r17 = new BlockTransformSecondaryItemId("blockQuote", 16);
            blockQuote = r17;
            BlockTransformSecondaryItemId r18 = new BlockTransformSecondaryItemId("insertSeparator", 17);
            insertSeparator = r18;
            BlockTransformSecondaryItemId r19 = new BlockTransformSecondaryItemId("plainText", 18);
            plainText = r19;
            a = new BlockTransformSecondaryItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2, r17, r18, r19};
        }

        public static BlockTransformSecondaryItemId[] values() {
            return (BlockTransformSecondaryItemId[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static BlockTransformSecondaryItemId valueOf(String r1) {
            return (BlockTransformSecondaryItemId) r27.a.a(BlockTransformSecondaryItemId.class, r1);
        }

        public BlockTransformSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum ListTransformSecondaryItemId extends Enum<ListTransformSecondaryItemId> implements ItemIdV2 {
        public static final /* synthetic */ ListTransformSecondaryItemId[] a = null;
        public static final ListTransformSecondaryItemId noneList = null;
        public static final ListTransformSecondaryItemId orderedList = null;
        public static final ListTransformSecondaryItemId unorderedList = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            ListTransformSecondaryItemId r0 = new ListTransformSecondaryItemId("noneList", 0);
            noneList = r0;
            ListTransformSecondaryItemId r1 = new ListTransformSecondaryItemId("unorderedList", 1);
            unorderedList = r1;
            ListTransformSecondaryItemId r3 = new ListTransformSecondaryItemId("orderedList", 2);
            orderedList = r3;
            a = new ListTransformSecondaryItemId[]{r0, r1, r3};
        }

        public static ListTransformSecondaryItemId[] values() {
            return (ListTransformSecondaryItemId[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static ListTransformSecondaryItemId valueOf(String r1) {
            return (ListTransformSecondaryItemId) r27.a.a(ListTransformSecondaryItemId.class, r1);
        }

        public ListTransformSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum TextTransformSecondaryItemId extends Enum<TextTransformSecondaryItemId> implements ItemIdV2 {
        public static final /* synthetic */ TextTransformSecondaryItemId[] a = null;
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
            TextTransformSecondaryItemId r0 = new TextTransformSecondaryItemId("separator", 0);
            separator = r0;
            TextTransformSecondaryItemId r1 = new TextTransformSecondaryItemId("bold", 1);
            bold = r1;
            TextTransformSecondaryItemId r3 = new TextTransformSecondaryItemId("italic", 2);
            italic = r3;
            TextTransformSecondaryItemId r5 = new TextTransformSecondaryItemId("underline", 3);
            underline = r5;
            TextTransformSecondaryItemId r7 = new TextTransformSecondaryItemId("strikethrough", 4);
            strikethrough = r7;
            TextTransformSecondaryItemId r9 = new TextTransformSecondaryItemId("highlight", 5);
            highlight = r9;
            TextTransformSecondaryItemId r11 = new TextTransformSecondaryItemId("oldHighlight", 6);
            oldHighlight = r11;
            TextTransformSecondaryItemId r13 = new TextTransformSecondaryItemId("inlineCode", 7);
            inlineCode = r13;
            TextTransformSecondaryItemId r16 = new TextTransformSecondaryItemId("fontSize", 8);
            fontSize = r16;
            TextTransformSecondaryItemId r14 = new TextTransformSecondaryItemId("fontColor", 9);
            fontColor = r14;
            TextTransformSecondaryItemId r12 = new TextTransformSecondaryItemId("fontName", 10);
            fontName = r12;
            a = new TextTransformSecondaryItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12};
        }

        public static TextTransformSecondaryItemId[] values() {
            return (TextTransformSecondaryItemId[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static TextTransformSecondaryItemId valueOf(String r1) {
            return (TextTransformSecondaryItemId) r27.a.a(TextTransformSecondaryItemId.class, r1);
        }

        public TextTransformSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolbarPrimaryItemId.values().length];
            a = r0;
            r0[ToolbarPrimaryItemId.blockTransform.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ToolbarPrimaryItemId.textTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ToolbarPrimaryItemId.alignTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[ToolbarPrimaryItemId.listTransform.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[ToolbarPrimaryItemId.insertImage.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        ToolbarPrimaryItemId r0 = new ToolbarPrimaryItemId("addNewBlock", 0);
        addNewBlock = r0;
        ToolbarPrimaryItemId r1 = new ToolbarPrimaryItemId("separator", 1);
        separator = r1;
        ToolbarPrimaryItemId r3 = new ToolbarPrimaryItemId("blockTransform", 2);
        blockTransform = r3;
        ToolbarPrimaryItemId r5 = new ToolbarPrimaryItemId("textTransform", 3);
        textTransform = r5;
        ToolbarPrimaryItemId r7 = new ToolbarPrimaryItemId("reminder", 4);
        reminder = r7;
        ToolbarPrimaryItemId r9 = new ToolbarPrimaryItemId("alignTransform", 5);
        alignTransform = r9;
        ToolbarPrimaryItemId r11 = new ToolbarPrimaryItemId("insertImage", 6);
        insertImage = r11;
        ToolbarPrimaryItemId r13 = new ToolbarPrimaryItemId("checkbox", 7);
        checkbox = r13;
        ToolbarPrimaryItemId r16 = new ToolbarPrimaryItemId("checkList", 8);
        checkList = r16;
        ToolbarPrimaryItemId r14 = new ToolbarPrimaryItemId("mention", 9);
        mention = r14;
        ToolbarPrimaryItemId r12 = new ToolbarPrimaryItemId("insertTable", 10);
        insertTable = r12;
        ToolbarPrimaryItemId r10 = new ToolbarPrimaryItemId("calloutBlock", 11);
        calloutBlock = r10;
        ToolbarPrimaryItemId r8 = new ToolbarPrimaryItemId("undo", 12);
        undo = r8;
        ToolbarPrimaryItemId r6 = new ToolbarPrimaryItemId("redo", 13);
        redo = r6;
        ToolbarPrimaryItemId r4 = new ToolbarPrimaryItemId("indentLeft", 14);
        indentLeft = r4;
        ToolbarPrimaryItemId r2 = new ToolbarPrimaryItemId("indentRight", 15);
        indentRight = r2;
        ToolbarPrimaryItemId r17 = new ToolbarPrimaryItemId("transTask", 16);
        transTask = r17;
        ToolbarPrimaryItemId r18 = new ToolbarPrimaryItemId("aiRewrite", 17);
        aiRewrite = r18;
        ToolbarPrimaryItemId r19 = new ToolbarPrimaryItemId("inlineAI", 18);
        inlineAI = r19;
        ToolbarPrimaryItemId r20 = new ToolbarPrimaryItemId("listTransform", 19);
        listTransform = r20;
        a = new ToolbarPrimaryItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2, r17, r18, r19, r20};
    }

    public static ToolbarPrimaryItemId[] values() {
        return (ToolbarPrimaryItemId[]) a.clone();
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public ItemIdV2[] children() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L13;
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
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L15;
        return ItemIdV2.DisplayMode.NoDisplay;
    L15:
        return ItemIdV2.DisplayMode.FunctionPanel;
    L17:
        return ItemIdV2.DisplayMode.SubToolBarV2;
    }

    public static ItemIdV2 of(String r5) {
        ToolbarPrimaryItemId[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        ToolbarPrimaryItemId r3 = r0[r2];
        if (r3.name().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return ItemIdV2.ConstId.unknown;
    }

    public static ToolbarPrimaryItemId valueOf(String r1) {
        return (ToolbarPrimaryItemId) r27.a.a(ToolbarPrimaryItemId.class, r1);
    }

    public ToolbarPrimaryItemId(String r1, int r2) {
        super(r1, r2);
    }
}
