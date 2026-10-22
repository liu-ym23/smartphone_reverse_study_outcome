package io.noties.markwon.ext.tables;

/* JADX INFO: loaded from: classes41.dex */
public final enum Table$Alignment extends Enum<Table$Alignment> {
    public static final Table$Alignment CENTER = null;
    public static final Table$Alignment LEFT = null;
    public static final Table$Alignment RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Table$Alignment[] f492487a = null;

    static {
        Table$Alignment r100 = new Table$Alignment("LEFT", 0);
        LEFT = r100;
        Table$Alignment r101 = new Table$Alignment("CENTER", 1);
        CENTER = r101;
        Table$Alignment r102 = new Table$Alignment("RIGHT", 2);
        RIGHT = r102;
        f492487a = new Table$Alignment[]{r100, r101, r102};
    }

    public static Table$Alignment[] values() {
        return (Table$Alignment[]) f492487a.clone();
    }

    public static Table$Alignment valueOf(String r100) {
        return (Table$Alignment) r27.a.a(Table$Alignment.class, r100);
    }

    public Table$Alignment(String r100, int r101) {
        super(r100, r101);
    }
}
