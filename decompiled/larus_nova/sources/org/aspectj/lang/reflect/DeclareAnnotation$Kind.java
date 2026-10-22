package org.aspectj.lang.reflect;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum DeclareAnnotation$Kind extends Enum<DeclareAnnotation$Kind> {
    public static final DeclareAnnotation$Kind Constructor = null;
    public static final DeclareAnnotation$Kind Field = null;
    public static final DeclareAnnotation$Kind Method = null;
    public static final DeclareAnnotation$Kind Type = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeclareAnnotation$Kind[] f525019a = null;

    static {
        DeclareAnnotation$Kind r100 = new DeclareAnnotation$Kind("Field", 0);
        Field = r100;
        DeclareAnnotation$Kind r101 = new DeclareAnnotation$Kind("Method", 1);
        Method = r101;
        DeclareAnnotation$Kind r102 = new DeclareAnnotation$Kind("Constructor", 2);
        Constructor = r102;
        DeclareAnnotation$Kind r103 = new DeclareAnnotation$Kind("Type", 3);
        Type = r103;
        f525019a = new DeclareAnnotation$Kind[]{r100, r101, r102, r103};
    }

    public static DeclareAnnotation$Kind[] values() {
        return (DeclareAnnotation$Kind[]) f525019a.clone();
    }

    public static DeclareAnnotation$Kind valueOf(String r100) {
        return (DeclareAnnotation$Kind) a.a(DeclareAnnotation$Kind.class, r100);
    }

    public DeclareAnnotation$Kind(String r100, int r101) {
        super(r100, r101);
    }
}
