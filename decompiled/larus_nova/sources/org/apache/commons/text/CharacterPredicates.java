package org.apache.commons.text;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public abstract enum CharacterPredicates extends Enum<CharacterPredicates> {
    private static final /* synthetic */ CharacterPredicates[] $VALUES = null;
    public static final CharacterPredicates ARABIC_NUMERALS = null;
    public static final CharacterPredicates ASCII_ALPHA_NUMERALS = null;
    public static final CharacterPredicates ASCII_LETTERS = null;
    public static final CharacterPredicates ASCII_LOWERCASE_LETTERS = null;
    public static final CharacterPredicates ASCII_UPPERCASE_LETTERS = null;
    public static final CharacterPredicates DIGITS = null;
    public static final CharacterPredicates LETTERS = null;

    public abstract /* synthetic */ boolean test(int r100);

    static {
        final String r100 = "LETTERS";
        final int r101 = 0;
        CharacterPredicates r102 = new AnonymousClass1(r100, r101);
        LETTERS = r102;
        final String r103 = "DIGITS";
        final int r104 = 1;
        CharacterPredicates r105 = new AnonymousClass2(r103, r104);
        DIGITS = r105;
        final String r106 = "ARABIC_NUMERALS";
        final int r107 = 2;
        CharacterPredicates r108 = new AnonymousClass3(r106, r107);
        ARABIC_NUMERALS = r108;
        final String r109 = "ASCII_LOWERCASE_LETTERS";
        final int r110 = 3;
        CharacterPredicates r111 = new AnonymousClass4(r109, r110);
        ASCII_LOWERCASE_LETTERS = r111;
        final String r112 = "ASCII_UPPERCASE_LETTERS";
        final int r113 = 4;
        CharacterPredicates r114 = new AnonymousClass5(r112, r113);
        ASCII_UPPERCASE_LETTERS = r114;
        final String r115 = "ASCII_LETTERS";
        final int r116 = 5;
        CharacterPredicates r117 = new AnonymousClass6(r115, r116);
        ASCII_LETTERS = r117;
        final String r118 = "ASCII_ALPHA_NUMERALS";
        final int r119 = 6;
        CharacterPredicates r120 = new AnonymousClass7(r118, r119);
        ASCII_ALPHA_NUMERALS = r120;
        $VALUES = new CharacterPredicates[]{r102, r105, r108, r111, r114, r117, r120};
    }

    public static CharacterPredicates[] values() {
        return (CharacterPredicates[]) $VALUES.clone();
    }

    public static CharacterPredicates valueOf(String r100) {
        return (CharacterPredicates) a.a(CharacterPredicates.class, r100);
    }

    private CharacterPredicates(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ CharacterPredicates(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
