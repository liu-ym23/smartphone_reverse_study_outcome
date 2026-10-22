package com.edu.onetex.latex.graphic;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/edu/onetex/latex/graphic/FontStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Regular", "Bold", "Italic", "BoldItalic", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final enum FontStyle extends Enum<FontStyle> {
    private static final /* synthetic */ FontStyle[] $VALUES = null;
    public static final FontStyle Bold = null;
    public static final FontStyle BoldItalic = null;
    public static final FontStyle Italic = null;
    public static final FontStyle Regular = null;
    private final int value;

    static {
        FontStyle r100 = new FontStyle("Regular", 0, 0);
        Regular = r100;
        FontStyle r101 = new FontStyle("Bold", 1, 2);
        Bold = r101;
        FontStyle r102 = new FontStyle("Italic", 2, 4);
        Italic = r102;
        FontStyle r103 = new FontStyle("BoldItalic", 3, r101.value | r102.value);
        BoldItalic = r103;
        $VALUES = new FontStyle[]{r100, r101, r102, r103};
    }

    public static FontStyle valueOf(String r100) {
        return (FontStyle) a.a(FontStyle.class, r100);
    }

    public static FontStyle[] values() {
        return (FontStyle[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private FontStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
