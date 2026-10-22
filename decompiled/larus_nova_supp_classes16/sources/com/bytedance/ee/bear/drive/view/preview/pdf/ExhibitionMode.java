package com.bytedance.ee.bear.drive.view.preview.pdf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ExhibitionMode extends Enum<ExhibitionMode> {
    public static final ExhibitionMode NORMAL = null;
    public static final ExhibitionMode PRESENTATION = null;
    public static final /* synthetic */ ExhibitionMode[] a = null;

    static {
        ExhibitionMode r0 = new ExhibitionMode("NORMAL", 0);
        NORMAL = r0;
        ExhibitionMode r1 = new ExhibitionMode("PRESENTATION", 1);
        PRESENTATION = r1;
        a = new ExhibitionMode[]{r0, r1};
    }

    public static ExhibitionMode[] values() {
        return (ExhibitionMode[]) a.clone();
    }

    public static ExhibitionMode valueOf(String r1) {
        return (ExhibitionMode) r27.a.a(ExhibitionMode.class, r1);
    }

    public ExhibitionMode(String r1, int r2) {
        super(r1, r2);
    }
}
