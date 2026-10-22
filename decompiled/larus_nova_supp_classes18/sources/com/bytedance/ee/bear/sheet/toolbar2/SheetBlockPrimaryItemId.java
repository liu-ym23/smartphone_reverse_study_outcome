package com.bytedance.ee.bear.sheet.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum SheetBlockPrimaryItemId extends Enum<SheetBlockPrimaryItemId> implements ItemIdV2.a {
    public static final /* synthetic */ SheetBlockPrimaryItemId[] a = null;
    public static final SheetBlockPrimaryItemId addNewBlock = null;
    public static final SheetBlockPrimaryItemId alignTransform = null;
    public static final SheetBlockPrimaryItemId cellAttribute = null;
    public static final SheetBlockPrimaryItemId checkbox = null;
    public static final SheetBlockPrimaryItemId fullScreen = null;
    public static final SheetBlockPrimaryItemId insertImage = null;
    public static final SheetBlockPrimaryItemId mention = null;
    public static final SheetBlockPrimaryItemId reminder = null;
    public static final SheetBlockPrimaryItemId separator = null;
    public static final SheetBlockPrimaryItemId textTransform = null;

    public static final enum AlignAttrSecondaryItemId extends Enum<AlignAttrSecondaryItemId> implements ItemIdV2 {
        public static final /* synthetic */ AlignAttrSecondaryItemId[] a = null;
        public static final AlignAttrSecondaryItemId horizontalCenter = null;
        public static final AlignAttrSecondaryItemId horizontalLeft = null;
        public static final AlignAttrSecondaryItemId horizontalRight = null;
        public static final AlignAttrSecondaryItemId separator = null;
        public static final AlignAttrSecondaryItemId verticalBottom = null;
        public static final AlignAttrSecondaryItemId verticalCenter = null;
        public static final AlignAttrSecondaryItemId verticalTop = null;

        public ItemIdV2[] children() {
            return null;
        }

        static {
            AlignAttrSecondaryItemId r0 = new AlignAttrSecondaryItemId("separator", 0);
            separator = r0;
            AlignAttrSecondaryItemId r1 = new AlignAttrSecondaryItemId("horizontalLeft", 1);
            horizontalLeft = r1;
            AlignAttrSecondaryItemId r3 = new AlignAttrSecondaryItemId("horizontalCenter", 2);
            horizontalCenter = r3;
            AlignAttrSecondaryItemId r5 = new AlignAttrSecondaryItemId("horizontalRight", 3);
            horizontalRight = r5;
            AlignAttrSecondaryItemId r7 = new AlignAttrSecondaryItemId("verticalTop", 4);
            verticalTop = r7;
            AlignAttrSecondaryItemId r9 = new AlignAttrSecondaryItemId("verticalCenter", 5);
            verticalCenter = r9;
            AlignAttrSecondaryItemId r11 = new AlignAttrSecondaryItemId("verticalBottom", 6);
            verticalBottom = r11;
            a = new AlignAttrSecondaryItemId[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static AlignAttrSecondaryItemId[] values() {
            return (AlignAttrSecondaryItemId[]) a.clone();
        }

        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static AlignAttrSecondaryItemId valueOf(String r1) {
            return (AlignAttrSecondaryItemId) r27.a.a(AlignAttrSecondaryItemId.class, r1);
        }

        public AlignAttrSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum CellAttrSecondaryItemId extends Enum<CellAttrSecondaryItemId> implements ItemIdV2 {
        public static final /* synthetic */ CellAttrSecondaryItemId[] a = null;
        public static final CellAttrSecondaryItemId autoWrap = null;
        public static final CellAttrSecondaryItemId backColor = null;
        public static final CellAttrSecondaryItemId borderLine = null;
        public static final CellAttrSecondaryItemId clip = null;
        public static final CellAttrSecondaryItemId merge = null;
        public static final CellAttrSecondaryItemId overflow = null;
        public static final CellAttrSecondaryItemId separator = null;

        public ItemIdV2[] children() {
            return null;
        }

        static {
            CellAttrSecondaryItemId r0 = new CellAttrSecondaryItemId("separator", 0);
            separator = r0;
            CellAttrSecondaryItemId r1 = new CellAttrSecondaryItemId("merge", 1);
            merge = r1;
            CellAttrSecondaryItemId r3 = new CellAttrSecondaryItemId("autoWrap", 2);
            autoWrap = r3;
            CellAttrSecondaryItemId r5 = new CellAttrSecondaryItemId("overflow", 3);
            overflow = r5;
            CellAttrSecondaryItemId r7 = new CellAttrSecondaryItemId("clip", 4);
            clip = r7;
            CellAttrSecondaryItemId r9 = new CellAttrSecondaryItemId("borderLine", 5);
            borderLine = r9;
            CellAttrSecondaryItemId r11 = new CellAttrSecondaryItemId("backColor", 6);
            backColor = r11;
            a = new CellAttrSecondaryItemId[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static CellAttrSecondaryItemId[] values() {
            return (CellAttrSecondaryItemId[]) a.clone();
        }

        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static CellAttrSecondaryItemId valueOf(String r1) {
            return (CellAttrSecondaryItemId) r27.a.a(CellAttrSecondaryItemId.class, r1);
        }

        public CellAttrSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum TextAttrSecondaryItemId extends Enum<TextAttrSecondaryItemId> implements ItemIdV2 {
        public static final /* synthetic */ TextAttrSecondaryItemId[] a = null;
        public static final TextAttrSecondaryItemId bold = null;
        public static final TextAttrSecondaryItemId fontSize = null;
        public static final TextAttrSecondaryItemId foreColor = null;
        public static final TextAttrSecondaryItemId italic = null;
        public static final TextAttrSecondaryItemId separator = null;
        public static final TextAttrSecondaryItemId strikethrough = null;
        public static final TextAttrSecondaryItemId underline = null;

        public ItemIdV2[] children() {
            return null;
        }

        static {
            TextAttrSecondaryItemId r0 = new TextAttrSecondaryItemId("separator", 0);
            separator = r0;
            TextAttrSecondaryItemId r1 = new TextAttrSecondaryItemId("bold", 1);
            bold = r1;
            TextAttrSecondaryItemId r3 = new TextAttrSecondaryItemId(SegmentStyle.FONT_STYLE_ITALIC, 2);
            italic = r3;
            TextAttrSecondaryItemId r5 = new TextAttrSecondaryItemId(SegmentStyle.UNDERLINE, 3);
            underline = r5;
            TextAttrSecondaryItemId r7 = new TextAttrSecondaryItemId("strikethrough", 4);
            strikethrough = r7;
            TextAttrSecondaryItemId r9 = new TextAttrSecondaryItemId("foreColor", 5);
            foreColor = r9;
            TextAttrSecondaryItemId r11 = new TextAttrSecondaryItemId("fontSize", 6);
            fontSize = r11;
            a = new TextAttrSecondaryItemId[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static TextAttrSecondaryItemId[] values() {
            return (TextAttrSecondaryItemId[]) a.clone();
        }

        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static TextAttrSecondaryItemId valueOf(String r1) {
            return (TextAttrSecondaryItemId) r27.a.a(TextAttrSecondaryItemId.class, r1);
        }

        public TextAttrSecondaryItemId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SheetBlockPrimaryItemId.values().length];
            a = r0;
            r0[SheetBlockPrimaryItemId.cellAttribute.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[SheetBlockPrimaryItemId.textTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[SheetBlockPrimaryItemId.alignTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[SheetBlockPrimaryItemId.insertImage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        SheetBlockPrimaryItemId r0 = new SheetBlockPrimaryItemId("addNewBlock", 0);
        addNewBlock = r0;
        SheetBlockPrimaryItemId r1 = new SheetBlockPrimaryItemId("separator", 1);
        separator = r1;
        SheetBlockPrimaryItemId r3 = new SheetBlockPrimaryItemId("cellAttribute", 2);
        cellAttribute = r3;
        SheetBlockPrimaryItemId r5 = new SheetBlockPrimaryItemId("textTransform", 3);
        textTransform = r5;
        SheetBlockPrimaryItemId r7 = new SheetBlockPrimaryItemId("reminder", 4);
        reminder = r7;
        SheetBlockPrimaryItemId r9 = new SheetBlockPrimaryItemId("alignTransform", 5);
        alignTransform = r9;
        SheetBlockPrimaryItemId r11 = new SheetBlockPrimaryItemId("insertImage", 6);
        insertImage = r11;
        SheetBlockPrimaryItemId r13 = new SheetBlockPrimaryItemId("checkbox", 7);
        checkbox = r13;
        SheetBlockPrimaryItemId r15 = new SheetBlockPrimaryItemId("mention", 8);
        mention = r15;
        SheetBlockPrimaryItemId r14 = new SheetBlockPrimaryItemId("fullScreen", 9);
        fullScreen = r14;
        a = new SheetBlockPrimaryItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public static SheetBlockPrimaryItemId[] values() {
        return (SheetBlockPrimaryItemId[]) a.clone();
    }

    public ItemIdV2[] children() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        return null;
    L11:
        return AlignAttrSecondaryItemId.values();
    L13:
        return TextAttrSecondaryItemId.values();
    L15:
        return CellAttrSecondaryItemId.values();
    }

    public ItemIdV2.DisplayMode displayMode() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L13;
        return ItemIdV2.DisplayMode.NoDisplay;
    L13:
        return ItemIdV2.DisplayMode.FunctionPanel;
    L15:
        return ItemIdV2.DisplayMode.SubToolBarV2;
    }

    public static SheetBlockPrimaryItemId valueOf(String r1) {
        return (SheetBlockPrimaryItemId) r27.a.a(SheetBlockPrimaryItemId.class, r1);
    }

    public SheetBlockPrimaryItemId(String r1, int r2) {
        super(r1, r2);
    }
}
