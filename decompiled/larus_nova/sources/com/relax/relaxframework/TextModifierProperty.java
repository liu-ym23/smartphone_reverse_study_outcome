package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/relax/relaxframework/TextModifierProperty;", "", "", "value", "I", "getValue", "()I", "Color", "WhiteSpace", "LetterSpacing", "TextAlign", "LineHeight", "TextOverflow", "FontSize", "FontWeight", "FontFamily", "FontStyle", "LineSpacing", "AdaptFontSize", "TextDecoration", "TextShadowOffsetX", "TextShadowOffsetY", "TextShadowBlurRadius", "TextShadowColor", "TextShadowSpreadRadius", "WordBreak", "TextDecorationColor", "TextIndent", "TextStroke", "TextStrokeWidth", "TextStrokeColor", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextModifierProperty extends Enum<TextModifierProperty> {
    public static final TextModifierProperty AdaptFontSize = null;
    public static final TextModifierProperty Color = null;
    public static final TextModifierProperty FontFamily = null;
    public static final TextModifierProperty FontSize = null;
    public static final TextModifierProperty FontStyle = null;
    public static final TextModifierProperty FontWeight = null;
    public static final TextModifierProperty LetterSpacing = null;
    public static final TextModifierProperty LineHeight = null;
    public static final TextModifierProperty LineSpacing = null;
    public static final TextModifierProperty TextAlign = null;
    public static final TextModifierProperty TextDecoration = null;
    public static final TextModifierProperty TextDecorationColor = null;
    public static final TextModifierProperty TextIndent = null;
    public static final TextModifierProperty TextOverflow = null;
    public static final TextModifierProperty TextShadowBlurRadius = null;
    public static final TextModifierProperty TextShadowColor = null;
    public static final TextModifierProperty TextShadowOffsetX = null;
    public static final TextModifierProperty TextShadowOffsetY = null;
    public static final TextModifierProperty TextShadowSpreadRadius = null;
    public static final TextModifierProperty TextStroke = null;
    public static final TextModifierProperty TextStrokeColor = null;
    public static final TextModifierProperty TextStrokeWidth = null;
    public static final TextModifierProperty WhiteSpace = null;
    public static final TextModifierProperty WordBreak = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextModifierProperty[] f404968a = null;
    private final int value;

    public static TextModifierProperty valueOf(String r100) {
        return (TextModifierProperty) r27.a.a(TextModifierProperty.class, r100);
    }

    public static TextModifierProperty[] values() {
        return (TextModifierProperty[]) f404968a.clone();
    }

    static {
        TextModifierProperty r100 = new TextModifierProperty("Color", 0, 25);
        Color = r100;
        TextModifierProperty r101 = new TextModifierProperty("WhiteSpace", 1, 44);
        WhiteSpace = r101;
        TextModifierProperty r102 = new TextModifierProperty("LetterSpacing", 2, 45);
        LetterSpacing = r102;
        TextModifierProperty r103 = new TextModifierProperty("TextAlign", 3, 46);
        TextAlign = r103;
        TextModifierProperty r104 = new TextModifierProperty("LineHeight", 4, 47);
        LineHeight = r104;
        TextModifierProperty r105 = new TextModifierProperty("TextOverflow", 5, 48);
        TextOverflow = r105;
        TextModifierProperty r110 = new TextModifierProperty("FontSize", 6, 49);
        FontSize = r110;
        TextModifierProperty r111 = new TextModifierProperty("FontWeight", 7, 50);
        FontWeight = r111;
        TextModifierProperty r112 = new TextModifierProperty("FontFamily", 8, 53);
        FontFamily = r112;
        TextModifierProperty r113 = new TextModifierProperty("FontStyle", 9, 54);
        FontStyle = r113;
        TextModifierProperty r114 = new TextModifierProperty("LineSpacing", 10, 65);
        LineSpacing = r114;
        TextModifierProperty r106 = new TextModifierProperty("AdaptFontSize", 11, 87);
        AdaptFontSize = r106;
        TextModifierProperty r107 = new TextModifierProperty("TextDecoration", 12, 89);
        TextDecoration = r107;
        TextModifierProperty r108 = new TextModifierProperty("TextShadowOffsetX", 13, 91);
        TextShadowOffsetX = r108;
        TextModifierProperty r109 = new TextModifierProperty("TextShadowOffsetY", 14, 92);
        TextShadowOffsetY = r109;
        TextModifierProperty r115 = new TextModifierProperty("TextShadowBlurRadius", 15, 93);
        TextShadowBlurRadius = r115;
        TextModifierProperty r116 = new TextModifierProperty("TextShadowColor", 16, 94);
        TextShadowColor = r116;
        TextModifierProperty r117 = new TextModifierProperty("TextShadowSpreadRadius", 17, 95);
        TextShadowSpreadRadius = r117;
        TextModifierProperty r118 = new TextModifierProperty("WordBreak", 18, 124);
        WordBreak = r118;
        TextModifierProperty r119 = new TextModifierProperty("TextDecorationColor", 19, 137);
        TextDecorationColor = r119;
        TextModifierProperty r120 = new TextModifierProperty("TextIndent", 20, 165);
        TextIndent = r120;
        TextModifierProperty r121 = new TextModifierProperty("TextStroke", 21, 167);
        TextStroke = r121;
        TextModifierProperty r122 = new TextModifierProperty("TextStrokeWidth", 22, 168);
        TextStrokeWidth = r122;
        TextModifierProperty r123 = new TextModifierProperty("TextStrokeColor", 23, 169);
        TextStrokeColor = r123;
        f404968a = new TextModifierProperty[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public final int getValue() {
        return this.value;
    }

    public TextModifierProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
