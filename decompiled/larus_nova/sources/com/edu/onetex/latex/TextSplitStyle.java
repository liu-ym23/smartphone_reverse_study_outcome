package com.edu.onetex.latex;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/edu/onetex/latex/TextSplitStyle;", "", "", "value", "I", "getValue", "()I", "SPLIT_STYLE_CHAR", "SPLIT_STYLE_WORD", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final enum TextSplitStyle extends Enum<TextSplitStyle> {
    public static final TextSplitStyle SPLIT_STYLE_CHAR = null;
    public static final TextSplitStyle SPLIT_STYLE_WORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextSplitStyle[] f273700a = null;
    private final int value;

    static {
        TextSplitStyle r100 = new TextSplitStyle("SPLIT_STYLE_CHAR", 0, 0);
        SPLIT_STYLE_CHAR = r100;
        TextSplitStyle r101 = new TextSplitStyle("SPLIT_STYLE_WORD", 1, 1);
        SPLIT_STYLE_WORD = r101;
        f273700a = new TextSplitStyle[]{r100, r101};
    }

    public static TextSplitStyle valueOf(String r100) {
        return (TextSplitStyle) a.a(TextSplitStyle.class, r100);
    }

    public static TextSplitStyle[] values() {
        return (TextSplitStyle[]) f273700a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TextSplitStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
