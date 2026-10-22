package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/TextAlignType;", "", "", "value", "I", "getValue", "()I", "Left", "Center", "Right", "Start", "End", "Justify", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextAlignType extends Enum<TextAlignType> {
    public static final TextAlignType Center = null;
    public static final TextAlignType End = null;
    public static final TextAlignType Justify = null;
    public static final TextAlignType Left = null;
    public static final TextAlignType Right = null;
    public static final TextAlignType Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextAlignType[] f404964a = null;
    private final int value;

    public static TextAlignType valueOf(String r100) {
        return (TextAlignType) r27.a.a(TextAlignType.class, r100);
    }

    public static TextAlignType[] values() {
        return (TextAlignType[]) f404964a.clone();
    }

    static {
        TextAlignType r100 = new TextAlignType("Left", 0, 0);
        Left = r100;
        TextAlignType r101 = new TextAlignType("Center", 1, 1);
        Center = r101;
        TextAlignType r102 = new TextAlignType("Right", 2, 2);
        Right = r102;
        TextAlignType r103 = new TextAlignType("Start", 3, 3);
        Start = r103;
        TextAlignType r104 = new TextAlignType("End", 4, 4);
        End = r104;
        TextAlignType r105 = new TextAlignType("Justify", 5, 5);
        Justify = r105;
        f404964a = new TextAlignType[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public TextAlignType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
