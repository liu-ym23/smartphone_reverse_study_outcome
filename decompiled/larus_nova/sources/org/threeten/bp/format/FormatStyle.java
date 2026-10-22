package org.threeten.bp.format;

/* JADX INFO: loaded from: classes41.dex */
public final enum FormatStyle extends Enum<FormatStyle> {
    public static final FormatStyle FULL = null;
    public static final FormatStyle LONG = null;
    public static final FormatStyle MEDIUM = null;
    public static final FormatStyle SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatStyle[] f526394a = null;

    static {
        FormatStyle r100 = new FormatStyle("FULL", 0);
        FULL = r100;
        FormatStyle r101 = new FormatStyle("LONG", 1);
        LONG = r101;
        FormatStyle r102 = new FormatStyle("MEDIUM", 2);
        MEDIUM = r102;
        FormatStyle r103 = new FormatStyle("SHORT", 3);
        SHORT = r103;
        f526394a = new FormatStyle[]{r100, r101, r102, r103};
    }

    public static FormatStyle[] values() {
        return (FormatStyle[]) f526394a.clone();
    }

    public static FormatStyle valueOf(String r100) {
        return (FormatStyle) r27.a.a(FormatStyle.class, r100);
    }

    public FormatStyle(String r100, int r101) {
        super(r100, r101);
    }
}
