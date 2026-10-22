package com.bytedance.locallife.poi.newdetail;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f263241d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f263242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f263243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f263244c;

    public static final class a {
        public static int[] a(e r100) {
            if (r100 == null) goto L6;
            int[] r101 = r100.f263242a;
            if (r101 == null) goto L6;
            return r101;
        L6:
            return new int[]{12, 8, 12, 0};
        }

        public static int[] b(e r100) {
            if (r100 == null) goto L6;
            int[] r101 = r100.f263243b;
            if (r101 == null) goto L6;
            return r101;
        L6:
            return new int[]{12, 16, 12, 16};
        }

        public static int c(e r100) {
            if (r100 != null) goto L6;
            return 8;
        L6:
            return r100.f263244c;
        }
    }

    static {
    }

    public e() {
        this.f263242a = new int[4];
        this.f263243b = new int[4];
    }
}
