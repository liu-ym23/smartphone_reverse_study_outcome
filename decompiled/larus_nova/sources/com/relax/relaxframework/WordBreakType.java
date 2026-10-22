package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/WordBreakType;", "", "", "value", "I", "getValue", "()I", "Normal", "BreakAll", "KeepAll", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum WordBreakType extends Enum<WordBreakType> {
    public static final WordBreakType BreakAll = null;
    public static final WordBreakType KeepAll = null;
    public static final WordBreakType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WordBreakType[] f404995a = null;
    private final int value;

    public static WordBreakType valueOf(String r100) {
        return (WordBreakType) r27.a.a(WordBreakType.class, r100);
    }

    public static WordBreakType[] values() {
        return (WordBreakType[]) f404995a.clone();
    }

    static {
        WordBreakType r100 = new WordBreakType("Normal", 0, 0);
        Normal = r100;
        WordBreakType r101 = new WordBreakType("BreakAll", 1, 1);
        BreakAll = r101;
        WordBreakType r102 = new WordBreakType("KeepAll", 2, 2);
        KeepAll = r102;
        f404995a = new WordBreakType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public WordBreakType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
