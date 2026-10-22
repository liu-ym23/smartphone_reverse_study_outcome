package rw4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public static final n c = null;
    public static final n d = null;
    public static final n e = null;
    public static final n f = null;
    public static final n g = null;
    public static final n h = null;
    public static final n i = null;
    public static final n j = null;
    public final String a;
    public final boolean b;

    static {
        c = new n("docx");
        d = new n("pdf");
        e = new n("docx", 0);
        f = new n("pdf", 0);
        g = new n("xlsx");
        h = new n("pptx");
        i = new n("txt");
        j = new n("md");
    }

    public final String toString() {
        return this.a.toLowerCase();
    }

    public n(String r1) {
        this.a = r1;
    }

    public n(String r1, int r2) {
        this.a = r1;
        this.b = true;
    }
}
