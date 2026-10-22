package com.lynx.textra;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class TTTextDefinition {
    private static final CanvasOp[] canvas_ordinal_ = null;
    private static final CharacterVerticalAlign[] character_vertical_ordinal_ = null;
    private static final LayoutResult[] layout_result_ordinal_ = null;
    private static final LinkStyle[] link_ordinal_ = null;
    private static final ParagraphHorizontalAlign[] paragraph_horizon_ordinal_ = null;
    private static final ParagraphVerticalAlign[] paragraph_vertical_ordinal_ = null;
    private static final PathType[] path_ordinal_ = null;
    private static final ThemeColorType[] theme_color_ordinal = null;
    private static final FontWeight[] weight_ordinal_ = null;

    public static final enum CanvasOp extends Enum<CanvasOp> {
        private static final /* synthetic */ CanvasOp[] $VALUES = null;
        public static final CanvasOp kClear = null;
        public static final CanvasOp kClearRect = null;
        public static final CanvasOp kClipRect = null;
        public static final CanvasOp kDrawArc = null;
        public static final CanvasOp kDrawArcTo = null;
        public static final CanvasOp kDrawBackgroundDelegate = null;
        public static final CanvasOp kDrawBlockRegion = null;
        public static final CanvasOp kDrawCircle = null;
        public static final CanvasOp kDrawColor = null;
        public static final CanvasOp kDrawGlyphs = null;
        public static final CanvasOp kDrawImage = null;
        public static final CanvasOp kDrawImageRect = null;
        public static final CanvasOp kDrawLine = null;
        public static final CanvasOp kDrawOval = null;
        public static final CanvasOp kDrawPath = null;
        public static final CanvasOp kDrawRect = null;
        public static final CanvasOp kDrawRoundRect = null;
        public static final CanvasOp kDrawRunDelegate = null;
        public static final CanvasOp kDrawText = null;
        public static final CanvasOp kEndPaint = null;
        public static final CanvasOp kFillRect = null;
        public static final CanvasOp kRestore = null;
        public static final CanvasOp kRotate = null;
        public static final CanvasOp kSave = null;
        public static final CanvasOp kScale = null;
        public static final CanvasOp kSkew = null;
        public static final CanvasOp kStartPaint = null;
        public static final CanvasOp kTranslate = null;

        static {
            CanvasOp r100 = new CanvasOp("kStartPaint", 0);
            kStartPaint = r100;
            CanvasOp r101 = new CanvasOp("kEndPaint", 1);
            kEndPaint = r101;
            CanvasOp r102 = new CanvasOp("kSave", 2);
            kSave = r102;
            CanvasOp r103 = new CanvasOp("kRestore", 3);
            kRestore = r103;
            CanvasOp r104 = new CanvasOp("kTranslate", 4);
            kTranslate = r104;
            CanvasOp r105 = new CanvasOp("kScale", 5);
            kScale = r105;
            CanvasOp r110 = new CanvasOp("kRotate", 6);
            kRotate = r110;
            CanvasOp r111 = new CanvasOp("kSkew", 7);
            kSkew = r111;
            CanvasOp r112 = new CanvasOp("kClipRect", 8);
            kClipRect = r112;
            CanvasOp r113 = new CanvasOp("kClear", 9);
            kClear = r113;
            CanvasOp r114 = new CanvasOp("kClearRect", 10);
            kClearRect = r114;
            CanvasOp r115 = new CanvasOp("kFillRect", 11);
            kFillRect = r115;
            CanvasOp r106 = new CanvasOp("kDrawColor", 12);
            kDrawColor = r106;
            CanvasOp r107 = new CanvasOp("kDrawLine", 13);
            kDrawLine = r107;
            CanvasOp r108 = new CanvasOp("kDrawRect", 14);
            kDrawRect = r108;
            CanvasOp r109 = new CanvasOp("kDrawOval", 15);
            kDrawOval = r109;
            CanvasOp r116 = new CanvasOp("kDrawCircle", 16);
            kDrawCircle = r116;
            CanvasOp r117 = new CanvasOp("kDrawArc", 17);
            kDrawArc = r117;
            CanvasOp r118 = new CanvasOp("kDrawPath", 18);
            kDrawPath = r118;
            CanvasOp r119 = new CanvasOp("kDrawArcTo", 19);
            kDrawArcTo = r119;
            CanvasOp r120 = new CanvasOp("kDrawText", 20);
            kDrawText = r120;
            CanvasOp r121 = new CanvasOp("kDrawGlyphs", 21);
            kDrawGlyphs = r121;
            CanvasOp r122 = new CanvasOp("kDrawRunDelegate", 22);
            kDrawRunDelegate = r122;
            CanvasOp r123 = new CanvasOp("kDrawImage", 23);
            kDrawImage = r123;
            CanvasOp r124 = new CanvasOp("kDrawImageRect", 24);
            kDrawImageRect = r124;
            CanvasOp r125 = new CanvasOp("kDrawBackgroundDelegate", 25);
            kDrawBackgroundDelegate = r125;
            CanvasOp r126 = new CanvasOp("kDrawBlockRegion", 26);
            kDrawBlockRegion = r126;
            CanvasOp r127 = new CanvasOp("kDrawRoundRect", 27);
            kDrawRoundRect = r127;
            $VALUES = new CanvasOp[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        }

        public static CanvasOp[] values() {
            return (CanvasOp[]) $VALUES.clone();
        }

        public static CanvasOp valueOf(String r100) {
            return (CanvasOp) a.a(CanvasOp.class, r100);
        }

        private CanvasOp(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CharacterVerticalAlign extends Enum<CharacterVerticalAlign> {
        private static final /* synthetic */ CharacterVerticalAlign[] $VALUES = null;
        public static final CharacterVerticalAlign kBaseLine = null;
        public static final CharacterVerticalAlign kBottom = null;
        public static final CharacterVerticalAlign kMiddle = null;
        public static final CharacterVerticalAlign kSubScript = null;
        public static final CharacterVerticalAlign kSuperScript = null;
        public static final CharacterVerticalAlign kTop = null;

        static {
            CharacterVerticalAlign r100 = new CharacterVerticalAlign("kBaseLine", 0);
            kBaseLine = r100;
            CharacterVerticalAlign r101 = new CharacterVerticalAlign("kSuperScript", 1);
            kSuperScript = r101;
            CharacterVerticalAlign r102 = new CharacterVerticalAlign("kSubScript", 2);
            kSubScript = r102;
            CharacterVerticalAlign r103 = new CharacterVerticalAlign("kTop", 3);
            kTop = r103;
            CharacterVerticalAlign r104 = new CharacterVerticalAlign("kBottom", 4);
            kBottom = r104;
            CharacterVerticalAlign r105 = new CharacterVerticalAlign("kMiddle", 5);
            kMiddle = r105;
            $VALUES = new CharacterVerticalAlign[]{r100, r101, r102, r103, r104, r105};
        }

        public static CharacterVerticalAlign[] values() {
            return (CharacterVerticalAlign[]) $VALUES.clone();
        }

        public static CharacterVerticalAlign valueOf(String r100) {
            return (CharacterVerticalAlign) a.a(CharacterVerticalAlign.class, r100);
        }

        private CharacterVerticalAlign(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DecorationType extends Enum<DecorationType> {
        private static final /* synthetic */ DecorationType[] $VALUES = null;
        public static final DecorationType kNone = null;
        public static final DecorationType kUnderLine = null;

        static {
            DecorationType r100 = new DecorationType("kNone", 0);
            kNone = r100;
            DecorationType r101 = new DecorationType("kUnderLine", 1);
            kUnderLine = r101;
            $VALUES = new DecorationType[]{r100, r101};
        }

        public static DecorationType[] values() {
            return (DecorationType[]) $VALUES.clone();
        }

        public static DecorationType valueOf(String r100) {
            return (DecorationType) a.a(DecorationType.class, r100);
        }

        private DecorationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class FontFace {
        public String font_family;
        public String[] resource;

        public FontFace() {
        }
    }

    public static final enum FontWeight extends Enum<FontWeight> {
        private static final /* synthetic */ FontWeight[] $VALUES = null;
        public static final FontWeight kBlack_900 = null;
        public static final FontWeight kBold_700 = null;
        public static final FontWeight kExtraBold_800 = null;
        public static final FontWeight kExtraLight_200 = null;
        public static final FontWeight kLight_300 = null;
        public static final FontWeight kMedium_500 = null;
        public static final FontWeight kNormal_400 = null;
        public static final FontWeight kSemiBold_600 = null;
        public static final FontWeight kThin_100 = null;
        public static final FontWeight kUndefined = null;

        static {
            FontWeight r100 = new FontWeight("kUndefined", 0);
            kUndefined = r100;
            FontWeight r101 = new FontWeight("kThin_100", 1);
            kThin_100 = r101;
            FontWeight r102 = new FontWeight("kExtraLight_200", 2);
            kExtraLight_200 = r102;
            FontWeight r103 = new FontWeight("kLight_300", 3);
            kLight_300 = r103;
            FontWeight r104 = new FontWeight("kNormal_400", 4);
            kNormal_400 = r104;
            FontWeight r105 = new FontWeight("kMedium_500", 5);
            kMedium_500 = r105;
            FontWeight r110 = new FontWeight("kSemiBold_600", 6);
            kSemiBold_600 = r110;
            FontWeight r111 = new FontWeight("kBold_700", 7);
            kBold_700 = r111;
            FontWeight r112 = new FontWeight("kExtraBold_800", 8);
            kExtraBold_800 = r112;
            FontWeight r113 = new FontWeight("kBlack_900", 9);
            kBlack_900 = r113;
            $VALUES = new FontWeight[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static FontWeight[] values() {
            return (FontWeight[]) $VALUES.clone();
        }

        public static FontWeight valueOf(String r100) {
            return (FontWeight) a.a(FontWeight.class, r100);
        }

        private FontWeight(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class LayoutPosition {
        public int char_index_;
        public int run_index_;

        public LayoutPosition() {
            this.run_index_ = 0;
            this.char_index_ = 0;
        }

        public LayoutPosition(int r100, int r101) {
            this.run_index_ = r100;
            this.char_index_ = r101;
        }
    }

    public static final enum LayoutResult extends Enum<LayoutResult> {
        private static final /* synthetic */ LayoutResult[] $VALUES = null;
        public static final LayoutResult kBreakColumn = null;
        public static final LayoutResult kBreakPage = null;
        public static final LayoutResult kNormal = null;
        public static final LayoutResult kParagraphEnd = null;
        public static final LayoutResult kRelayoutLine = null;
        public static final LayoutResult kRelayoutPage = null;

        static {
            LayoutResult r100 = new LayoutResult("kNormal", 0);
            kNormal = r100;
            LayoutResult r101 = new LayoutResult("kRelayoutPage", 1);
            kRelayoutPage = r101;
            LayoutResult r102 = new LayoutResult("kRelayoutLine", 2);
            kRelayoutLine = r102;
            LayoutResult r103 = new LayoutResult("kBreakPage", 3);
            kBreakPage = r103;
            LayoutResult r104 = new LayoutResult("kBreakColumn", 4);
            kBreakColumn = r104;
            LayoutResult r105 = new LayoutResult("kParagraphEnd", 5);
            kParagraphEnd = r105;
            $VALUES = new LayoutResult[]{r100, r101, r102, r103, r104, r105};
        }

        public static LayoutResult[] values() {
            return (LayoutResult[]) $VALUES.clone();
        }

        public static LayoutResult valueOf(String r100) {
            return (LayoutResult) a.a(LayoutResult.class, r100);
        }

        private LayoutResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LinkStyle extends Enum<LinkStyle> {
        private static final /* synthetic */ LinkStyle[] $VALUES = null;
        public static final LinkStyle kNone = null;
        public static final LinkStyle kUnderline = null;

        static {
            LinkStyle r100 = new LinkStyle("kNone", 0);
            kNone = r100;
            LinkStyle r101 = new LinkStyle("kUnderline", 1);
            kUnderline = r101;
            $VALUES = new LinkStyle[]{r100, r101};
        }

        public static LinkStyle[] values() {
            return (LinkStyle[]) $VALUES.clone();
        }

        public static LinkStyle valueOf(String r100) {
            return (LinkStyle) a.a(LinkStyle.class, r100);
        }

        private LinkStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ParagraphHorizontalAlign extends Enum<ParagraphHorizontalAlign> {
        private static final /* synthetic */ ParagraphHorizontalAlign[] $VALUES = null;
        public static final ParagraphHorizontalAlign kCenter = null;
        public static final ParagraphHorizontalAlign kDistributed = null;
        public static final ParagraphHorizontalAlign kJustify = null;
        public static final ParagraphHorizontalAlign kLeft = null;
        public static final ParagraphHorizontalAlign kRight = null;

        static {
            ParagraphHorizontalAlign r100 = new ParagraphHorizontalAlign("kLeft", 0);
            kLeft = r100;
            ParagraphHorizontalAlign r101 = new ParagraphHorizontalAlign("kCenter", 1);
            kCenter = r101;
            ParagraphHorizontalAlign r102 = new ParagraphHorizontalAlign("kRight", 2);
            kRight = r102;
            ParagraphHorizontalAlign r103 = new ParagraphHorizontalAlign("kJustify", 3);
            kJustify = r103;
            ParagraphHorizontalAlign r104 = new ParagraphHorizontalAlign("kDistributed", 4);
            kDistributed = r104;
            $VALUES = new ParagraphHorizontalAlign[]{r100, r101, r102, r103, r104};
        }

        public static ParagraphHorizontalAlign[] values() {
            return (ParagraphHorizontalAlign[]) $VALUES.clone();
        }

        public static ParagraphHorizontalAlign valueOf(String r100) {
            return (ParagraphHorizontalAlign) a.a(ParagraphHorizontalAlign.class, r100);
        }

        private ParagraphHorizontalAlign(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ParagraphVerticalAlign extends Enum<ParagraphVerticalAlign> {
        private static final /* synthetic */ ParagraphVerticalAlign[] $VALUES = null;
        public static final ParagraphVerticalAlign kBaseline = null;
        public static final ParagraphVerticalAlign kBottom = null;
        public static final ParagraphVerticalAlign kCenter = null;
        public static final ParagraphVerticalAlign kTop = null;

        static {
            ParagraphVerticalAlign r100 = new ParagraphVerticalAlign("kTop", 0);
            kTop = r100;
            ParagraphVerticalAlign r101 = new ParagraphVerticalAlign("kCenter", 1);
            kCenter = r101;
            ParagraphVerticalAlign r102 = new ParagraphVerticalAlign("kBaseline", 2);
            kBaseline = r102;
            ParagraphVerticalAlign r103 = new ParagraphVerticalAlign("kBottom", 3);
            kBottom = r103;
            $VALUES = new ParagraphVerticalAlign[]{r100, r101, r102, r103};
        }

        public static ParagraphVerticalAlign[] values() {
            return (ParagraphVerticalAlign[]) $VALUES.clone();
        }

        public static ParagraphVerticalAlign valueOf(String r100) {
            return (ParagraphVerticalAlign) a.a(ParagraphVerticalAlign.class, r100);
        }

        private ParagraphVerticalAlign(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PathType extends Enum<PathType> {
        private static final /* synthetic */ PathType[] $VALUES = null;
        public static final PathType kArc = null;
        public static final PathType kBezier = null;
        public static final PathType kLines = null;
        public static final PathType kMoveTo = null;
        public static final PathType kMultiPath = null;

        static {
            PathType r100 = new PathType("kLines", 0);
            kLines = r100;
            PathType r101 = new PathType("kArc", 1);
            kArc = r101;
            PathType r102 = new PathType("kBezier", 2);
            kBezier = r102;
            PathType r103 = new PathType("kMoveTo", 3);
            kMoveTo = r103;
            PathType r104 = new PathType("kMultiPath", 4);
            kMultiPath = r104;
            $VALUES = new PathType[]{r100, r101, r102, r103, r104};
        }

        public static PathType[] values() {
            return (PathType[]) $VALUES.clone();
        }

        public static PathType valueOf(String r100) {
            return (PathType) a.a(PathType.class, r100);
        }

        private PathType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class Size {
        public float height;
        public float width;

        public Size(float r100, float r101) {
            this.width = r100;
            this.height = r101;
        }
    }

    public static final enum Slant extends Enum<Slant> {
        private static final /* synthetic */ Slant[] $VALUES = null;
        public static final Slant kItalicSlant = null;
        public static final Slant kObliqueSlant = null;
        public static final Slant kUpRightSlant = null;

        static {
            Slant r100 = new Slant("kUpRightSlant", 0);
            kUpRightSlant = r100;
            Slant r101 = new Slant("kItalicSlant", 1);
            kItalicSlant = r101;
            Slant r102 = new Slant("kObliqueSlant", 2);
            kObliqueSlant = r102;
            $VALUES = new Slant[]{r100, r101, r102};
        }

        public static Slant[] values() {
            return (Slant[]) $VALUES.clone();
        }

        public static Slant valueOf(String r100) {
            return (Slant) a.a(Slant.class, r100);
        }

        private Slant(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ThemeColorType extends Enum<ThemeColorType> {
        private static final /* synthetic */ ThemeColorType[] $VALUES = null;
        public static final ThemeColorType kBackground = null;
        public static final ThemeColorType kBlock = null;
        public static final ThemeColorType kFootnote = null;
        public static final ThemeColorType kLink = null;
        public static final ThemeColorType kNormal = null;
        public static final ThemeColorType kPressedLink = null;

        static {
            ThemeColorType r100 = new ThemeColorType("kNormal", 0);
            kNormal = r100;
            ThemeColorType r101 = new ThemeColorType("kLink", 1);
            kLink = r101;
            ThemeColorType r102 = new ThemeColorType("kBackground", 2);
            kBackground = r102;
            ThemeColorType r103 = new ThemeColorType("kBlock", 3);
            kBlock = r103;
            ThemeColorType r104 = new ThemeColorType("kFootnote", 4);
            kFootnote = r104;
            ThemeColorType r105 = new ThemeColorType("kPressedLink", 5);
            kPressedLink = r105;
            $VALUES = new ThemeColorType[]{r100, r101, r102, r103, r104, r105};
        }

        public static ThemeColorType[] values() {
            return (ThemeColorType[]) $VALUES.clone();
        }

        public static ThemeColorType valueOf(String r100) {
            return (ThemeColorType) a.a(ThemeColorType.class, r100);
        }

        private ThemeColorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TTTextDefinition() {
    }

    static {
        weight_ordinal_ = FontWeight.values();
        link_ordinal_ = LinkStyle.values();
        theme_color_ordinal = ThemeColorType.values();
        canvas_ordinal_ = CanvasOp.values();
        path_ordinal_ = PathType.values();
        character_vertical_ordinal_ = CharacterVerticalAlign.values();
        paragraph_horizon_ordinal_ = ParagraphHorizontalAlign.values();
        paragraph_vertical_ordinal_ = ParagraphVerticalAlign.values();
        layout_result_ordinal_ = LayoutResult.values();
    }

    public static CanvasOp GetCanvasOp(int r100) {
        return canvas_ordinal_[r100];
    }

    public static CharacterVerticalAlign GetCharacterVerticalAlign(int r100) {
        return character_vertical_ordinal_[r100];
    }

    public static FontWeight GetFontWeight(int r100) {
        if (r100 < 0) goto L9;
        FontWeight[] r101 = weight_ordinal_;
        if (r100 >= r101.length) goto L9;
        return r101[r100];
    L9:
        return FontWeight.kNormal_400;
    }

    public static LayoutResult GetLayoutResult(int r100) {
        return layout_result_ordinal_[r100];
    }

    public static LinkStyle GetLinkStyle(int r100) {
        if (r100 < 0) goto L9;
        LinkStyle[] r101 = link_ordinal_;
        if (r100 >= r101.length) goto L9;
        return r101[r100];
    L9:
        return LinkStyle.kNone;
    }

    public static ParagraphHorizontalAlign GetParagraphHorizontalAlign(int r100) {
        return paragraph_horizon_ordinal_[r100];
    }

    public static ParagraphVerticalAlign GetParagraphVerticalAlign(int r100) {
        return paragraph_vertical_ordinal_[r100];
    }

    public static PathType GetPathType(int r100) {
        return path_ordinal_[r100];
    }

    public static ThemeColorType GetThemeColorType(int r100) {
        if (r100 < 0) goto L9;
        ThemeColorType[] r101 = theme_color_ordinal;
        if (r100 >= r101.length) goto L9;
        return r101[r100];
    L9:
        return ThemeColorType.kNormal;
    }
}
