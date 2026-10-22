package org.threeten.bp.format;

/* JADX INFO: loaded from: classes41.dex */
public final enum TextStyle extends Enum<TextStyle> {
    public static final TextStyle FULL = null;
    public static final TextStyle FULL_STANDALONE = null;
    public static final TextStyle NARROW = null;
    public static final TextStyle NARROW_STANDALONE = null;
    public static final TextStyle SHORT = null;
    public static final TextStyle SHORT_STANDALONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextStyle[] f526397a = null;

    static {
        TextStyle r100 = new TextStyle("FULL", 0);
        FULL = r100;
        TextStyle r101 = new TextStyle("FULL_STANDALONE", 1);
        FULL_STANDALONE = r101;
        TextStyle r102 = new TextStyle("SHORT", 2);
        SHORT = r102;
        TextStyle r103 = new TextStyle("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = r103;
        TextStyle r104 = new TextStyle("NARROW", 4);
        NARROW = r104;
        TextStyle r105 = new TextStyle("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = r105;
        f526397a = new TextStyle[]{r100, r101, r102, r103, r104, r105};
    }

    public static TextStyle[] values() {
        return (TextStyle[]) f526397a.clone();
    }

    public TextStyle asNormal() {
        return values()[ordinal() & (-2)];
    }

    public TextStyle asStandalone() {
        return values()[ordinal() | 1];
    }

    public boolean isStandalone() {
        if ((ordinal() & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static TextStyle valueOf(String r100) {
        return (TextStyle) r27.a.a(TextStyle.class, r100);
    }

    public TextStyle(String r100, int r101) {
        super(r100, r101);
    }
}
