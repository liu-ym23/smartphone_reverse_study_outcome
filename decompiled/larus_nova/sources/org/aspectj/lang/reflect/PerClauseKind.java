package org.aspectj.lang.reflect;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PerClauseKind extends Enum<PerClauseKind> {
    public static final PerClauseKind PERCFLOW = null;
    public static final PerClauseKind PERCFLOWBELOW = null;
    public static final PerClauseKind PERTARGET = null;
    public static final PerClauseKind PERTHIS = null;
    public static final PerClauseKind PERTYPEWITHIN = null;
    public static final PerClauseKind SINGLETON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerClauseKind[] f525020a = null;

    static {
        PerClauseKind r100 = new PerClauseKind("SINGLETON", 0);
        SINGLETON = r100;
        PerClauseKind r101 = new PerClauseKind("PERTHIS", 1);
        PERTHIS = r101;
        PerClauseKind r102 = new PerClauseKind("PERTARGET", 2);
        PERTARGET = r102;
        PerClauseKind r103 = new PerClauseKind("PERCFLOW", 3);
        PERCFLOW = r103;
        PerClauseKind r104 = new PerClauseKind("PERCFLOWBELOW", 4);
        PERCFLOWBELOW = r104;
        PerClauseKind r105 = new PerClauseKind("PERTYPEWITHIN", 5);
        PERTYPEWITHIN = r105;
        f525020a = new PerClauseKind[]{r100, r101, r102, r103, r104, r105};
    }

    public static PerClauseKind[] values() {
        return (PerClauseKind[]) f525020a.clone();
    }

    public static PerClauseKind valueOf(String r100) {
        return (PerClauseKind) a.a(PerClauseKind.class, r100);
    }

    public PerClauseKind(String r100, int r101) {
        super(r100, r101);
    }
}
