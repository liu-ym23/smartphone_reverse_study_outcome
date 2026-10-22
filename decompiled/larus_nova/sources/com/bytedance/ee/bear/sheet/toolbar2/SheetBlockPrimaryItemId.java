package com.bytedance.ee.bear.sheet.toolbar2;

import androidx.core.app.NotificationCompat;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.ugc.aweme.discover.model.CommodityText;

/* JADX INFO: loaded from: classes18.dex */
public final enum SheetBlockPrimaryItemId extends Enum<SheetBlockPrimaryItemId> implements ItemIdV2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SheetBlockPrimaryItemId[] f238424a = null;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AlignAttrSecondaryItemId[] f238425a = null;
        public static final AlignAttrSecondaryItemId horizontalCenter = null;
        public static final AlignAttrSecondaryItemId horizontalLeft = null;
        public static final AlignAttrSecondaryItemId horizontalRight = null;
        public static final AlignAttrSecondaryItemId separator = null;
        public static final AlignAttrSecondaryItemId verticalBottom = null;
        public static final AlignAttrSecondaryItemId verticalCenter = null;
        public static final AlignAttrSecondaryItemId verticalTop = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            AlignAttrSecondaryItemId r100 = new AlignAttrSecondaryItemId("separator", 0);
            separator = r100;
            AlignAttrSecondaryItemId r101 = new AlignAttrSecondaryItemId("horizontalLeft", 1);
            horizontalLeft = r101;
            AlignAttrSecondaryItemId r102 = new AlignAttrSecondaryItemId("horizontalCenter", 2);
            horizontalCenter = r102;
            AlignAttrSecondaryItemId r103 = new AlignAttrSecondaryItemId("horizontalRight", 3);
            horizontalRight = r103;
            AlignAttrSecondaryItemId r104 = new AlignAttrSecondaryItemId("verticalTop", 4);
            verticalTop = r104;
            AlignAttrSecondaryItemId r105 = new AlignAttrSecondaryItemId("verticalCenter", 5);
            verticalCenter = r105;
            AlignAttrSecondaryItemId r110 = new AlignAttrSecondaryItemId("verticalBottom", 6);
            verticalBottom = r110;
            f238425a = new AlignAttrSecondaryItemId[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static AlignAttrSecondaryItemId[] values() {
            return (AlignAttrSecondaryItemId[]) f238425a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static AlignAttrSecondaryItemId valueOf(String r100) {
            return (AlignAttrSecondaryItemId) r27.a.a(AlignAttrSecondaryItemId.class, r100);
        }

        public AlignAttrSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CellAttrSecondaryItemId extends Enum<CellAttrSecondaryItemId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CellAttrSecondaryItemId[] f238426a = null;
        public static final CellAttrSecondaryItemId autoWrap = null;
        public static final CellAttrSecondaryItemId backColor = null;
        public static final CellAttrSecondaryItemId borderLine = null;
        public static final CellAttrSecondaryItemId clip = null;
        public static final CellAttrSecondaryItemId merge = null;
        public static final CellAttrSecondaryItemId overflow = null;
        public static final CellAttrSecondaryItemId separator = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            CellAttrSecondaryItemId r100 = new CellAttrSecondaryItemId("separator", 0);
            separator = r100;
            CellAttrSecondaryItemId r101 = new CellAttrSecondaryItemId("merge", 1);
            merge = r101;
            CellAttrSecondaryItemId r102 = new CellAttrSecondaryItemId("autoWrap", 2);
            autoWrap = r102;
            CellAttrSecondaryItemId r103 = new CellAttrSecondaryItemId("overflow", 3);
            overflow = r103;
            CellAttrSecondaryItemId r104 = new CellAttrSecondaryItemId("clip", 4);
            clip = r104;
            CellAttrSecondaryItemId r105 = new CellAttrSecondaryItemId("borderLine", 5);
            borderLine = r105;
            CellAttrSecondaryItemId r110 = new CellAttrSecondaryItemId("backColor", 6);
            backColor = r110;
            f238426a = new CellAttrSecondaryItemId[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static CellAttrSecondaryItemId[] values() {
            return (CellAttrSecondaryItemId[]) f238426a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static CellAttrSecondaryItemId valueOf(String r100) {
            return (CellAttrSecondaryItemId) r27.a.a(CellAttrSecondaryItemId.class, r100);
        }

        public CellAttrSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TextAttrSecondaryItemId extends Enum<TextAttrSecondaryItemId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextAttrSecondaryItemId[] f238427a = null;
        public static final TextAttrSecondaryItemId bold = null;
        public static final TextAttrSecondaryItemId fontSize = null;
        public static final TextAttrSecondaryItemId foreColor = null;
        public static final TextAttrSecondaryItemId italic = null;
        public static final TextAttrSecondaryItemId separator = null;
        public static final TextAttrSecondaryItemId strikethrough = null;
        public static final TextAttrSecondaryItemId underline = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            TextAttrSecondaryItemId r100 = new TextAttrSecondaryItemId("separator", 0);
            separator = r100;
            TextAttrSecondaryItemId r101 = new TextAttrSecondaryItemId(CommodityText.BOLD, 1);
            bold = r101;
            TextAttrSecondaryItemId r102 = new TextAttrSecondaryItemId("italic", 2);
            italic = r102;
            TextAttrSecondaryItemId r103 = new TextAttrSecondaryItemId(SegmentStyle.UNDERLINE, 3);
            underline = r103;
            TextAttrSecondaryItemId r104 = new TextAttrSecondaryItemId("strikethrough", 4);
            strikethrough = r104;
            TextAttrSecondaryItemId r105 = new TextAttrSecondaryItemId("foreColor", 5);
            foreColor = r105;
            TextAttrSecondaryItemId r110 = new TextAttrSecondaryItemId("fontSize", 6);
            fontSize = r110;
            f238427a = new TextAttrSecondaryItemId[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static TextAttrSecondaryItemId[] values() {
            return (TextAttrSecondaryItemId[]) f238427a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2.DisplayMode displayMode() {
            return ItemIdV2.DisplayMode.NoDisplay;
        }

        public static TextAttrSecondaryItemId valueOf(String r100) {
            return (TextAttrSecondaryItemId) r27.a.a(TextAttrSecondaryItemId.class, r100);
        }

        public TextAttrSecondaryItemId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238428a = null;

        static {
            int[] r100 = new int[SheetBlockPrimaryItemId.values().length];
            f238428a = r100;
            r100[SheetBlockPrimaryItemId.cellAttribute.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f238428a[SheetBlockPrimaryItemId.textTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f238428a[SheetBlockPrimaryItemId.alignTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f238428a[SheetBlockPrimaryItemId.insertImage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        SheetBlockPrimaryItemId r100 = new SheetBlockPrimaryItemId("addNewBlock", 0);
        addNewBlock = r100;
        SheetBlockPrimaryItemId r101 = new SheetBlockPrimaryItemId("separator", 1);
        separator = r101;
        SheetBlockPrimaryItemId r102 = new SheetBlockPrimaryItemId("cellAttribute", 2);
        cellAttribute = r102;
        SheetBlockPrimaryItemId r103 = new SheetBlockPrimaryItemId("textTransform", 3);
        textTransform = r103;
        SheetBlockPrimaryItemId r104 = new SheetBlockPrimaryItemId(NotificationCompat.CATEGORY_REMINDER, 4);
        reminder = r104;
        SheetBlockPrimaryItemId r105 = new SheetBlockPrimaryItemId("alignTransform", 5);
        alignTransform = r105;
        SheetBlockPrimaryItemId r110 = new SheetBlockPrimaryItemId("insertImage", 6);
        insertImage = r110;
        SheetBlockPrimaryItemId r111 = new SheetBlockPrimaryItemId("checkbox", 7);
        checkbox = r111;
        SheetBlockPrimaryItemId r112 = new SheetBlockPrimaryItemId("mention", 8);
        mention = r112;
        SheetBlockPrimaryItemId r113 = new SheetBlockPrimaryItemId("fullScreen", 9);
        fullScreen = r113;
        f238424a = new SheetBlockPrimaryItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static SheetBlockPrimaryItemId[] values() {
        return (SheetBlockPrimaryItemId[]) f238424a.clone();
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public ItemIdV2[] children() {
        int r100 = a.f238428a[ordinal()];
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return AlignAttrSecondaryItemId.values();
    L13:
        return TextAttrSecondaryItemId.values();
    L15:
        return CellAttrSecondaryItemId.values();
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public ItemIdV2.DisplayMode displayMode() {
        int r100 = a.f238428a[ordinal()];
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return ItemIdV2.DisplayMode.NoDisplay;
    L13:
        return ItemIdV2.DisplayMode.FunctionPanel;
    L15:
        return ItemIdV2.DisplayMode.SubToolBarV2;
    }

    public static SheetBlockPrimaryItemId valueOf(String r100) {
        return (SheetBlockPrimaryItemId) r27.a.a(SheetBlockPrimaryItemId.class, r100);
    }

    public SheetBlockPrimaryItemId(String r100, int r101) {
        super(r100, r101);
    }
}
