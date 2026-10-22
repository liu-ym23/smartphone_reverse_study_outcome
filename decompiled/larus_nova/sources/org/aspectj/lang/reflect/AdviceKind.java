package org.aspectj.lang.reflect;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum AdviceKind extends Enum<AdviceKind> {
    public static final AdviceKind AFTER = null;
    public static final AdviceKind AFTER_RETURNING = null;
    public static final AdviceKind AFTER_THROWING = null;
    public static final AdviceKind AROUND = null;
    public static final AdviceKind BEFORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdviceKind[] f525018a = null;

    static {
        AdviceKind r100 = new AdviceKind("BEFORE", 0);
        BEFORE = r100;
        AdviceKind r101 = new AdviceKind("AFTER", 1);
        AFTER = r101;
        AdviceKind r102 = new AdviceKind("AFTER_RETURNING", 2);
        AFTER_RETURNING = r102;
        AdviceKind r103 = new AdviceKind("AFTER_THROWING", 3);
        AFTER_THROWING = r103;
        AdviceKind r104 = new AdviceKind("AROUND", 4);
        AROUND = r104;
        f525018a = new AdviceKind[]{r100, r101, r102, r103, r104};
    }

    public static AdviceKind[] values() {
        return (AdviceKind[]) f525018a.clone();
    }

    public static AdviceKind valueOf(String r100) {
        return (AdviceKind) a.a(AdviceKind.class, r100);
    }

    public AdviceKind(String r100, int r101) {
        super(r100, r101);
    }
}
