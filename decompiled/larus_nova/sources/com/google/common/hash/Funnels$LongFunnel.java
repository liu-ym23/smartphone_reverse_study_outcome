package com.google.common.hash;

/* JADX INFO: loaded from: classes23.dex */
final enum Funnels$LongFunnel extends Enum<Funnels$LongFunnel> implements Funnel<Long> {
    public static final Funnels$LongFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$LongFunnel[] f275563a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.longFunnel()";
    }

    static {
        Funnels$LongFunnel r100 = new Funnels$LongFunnel();
        INSTANCE = r100;
        f275563a = new Funnels$LongFunnel[]{r100};
    }

    public Funnels$LongFunnel() {
        super("INSTANCE", 0);
    }

    public static Funnels$LongFunnel[] values() {
        return (Funnels$LongFunnel[]) f275563a.clone();
    }

    public static Funnels$LongFunnel valueOf(String r100) {
        return (Funnels$LongFunnel) r27.a.a(Funnels$LongFunnel.class, r100);
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(Long r100, k r101) {
        r101.putLong(r100.longValue());
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Long r100, k r101) {
        funnel2(r100, r101);
    }
}
