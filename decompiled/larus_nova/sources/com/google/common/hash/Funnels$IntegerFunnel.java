package com.google.common.hash;

/* JADX INFO: loaded from: classes23.dex */
final enum Funnels$IntegerFunnel extends Enum<Funnels$IntegerFunnel> implements Funnel<Integer> {
    public static final Funnels$IntegerFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$IntegerFunnel[] f275562a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.integerFunnel()";
    }

    static {
        Funnels$IntegerFunnel r100 = new Funnels$IntegerFunnel();
        INSTANCE = r100;
        f275562a = new Funnels$IntegerFunnel[]{r100};
    }

    public Funnels$IntegerFunnel() {
        super("INSTANCE", 0);
    }

    public static Funnels$IntegerFunnel[] values() {
        return (Funnels$IntegerFunnel[]) f275562a.clone();
    }

    public static Funnels$IntegerFunnel valueOf(String r100) {
        return (Funnels$IntegerFunnel) r27.a.a(Funnels$IntegerFunnel.class, r100);
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(Integer r100, k r101) {
        r101.putInt(r100.intValue());
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Integer r100, k r101) {
        funnel2(r100, r101);
    }
}
