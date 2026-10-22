package com.google.common.hash;

/* JADX INFO: loaded from: classes23.dex */
final enum Funnels$UnencodedCharsFunnel extends Enum<Funnels$UnencodedCharsFunnel> implements Funnel<CharSequence> {
    public static final Funnels$UnencodedCharsFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$UnencodedCharsFunnel[] f275564a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.unencodedCharsFunnel()";
    }

    static {
        Funnels$UnencodedCharsFunnel r100 = new Funnels$UnencodedCharsFunnel();
        INSTANCE = r100;
        f275564a = new Funnels$UnencodedCharsFunnel[]{r100};
    }

    public Funnels$UnencodedCharsFunnel() {
        super("INSTANCE", 0);
    }

    public static Funnels$UnencodedCharsFunnel[] values() {
        return (Funnels$UnencodedCharsFunnel[]) f275564a.clone();
    }

    public static Funnels$UnencodedCharsFunnel valueOf(String r100) {
        return (Funnels$UnencodedCharsFunnel) r27.a.a(Funnels$UnencodedCharsFunnel.class, r100);
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(CharSequence r100, k r101) {
        c r102 = (c) r101;
        r102.getClass();
        int r103 = r100.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.h(r100.charAt(r104));
        r104 = r104 + 1;
        goto L3
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(CharSequence r100, k r101) {
        funnel2(r100, r101);
    }
}
