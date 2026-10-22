package com.google.common.hash;

/* JADX INFO: loaded from: classes23.dex */
final enum Funnels$ByteArrayFunnel extends Enum<Funnels$ByteArrayFunnel> implements Funnel<byte[]> {
    public static final Funnels$ByteArrayFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$ByteArrayFunnel[] f275561a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.byteArrayFunnel()";
    }

    static {
        Funnels$ByteArrayFunnel r100 = new Funnels$ByteArrayFunnel();
        INSTANCE = r100;
        f275561a = new Funnels$ByteArrayFunnel[]{r100};
    }

    public Funnels$ByteArrayFunnel() {
        super("INSTANCE", 0);
    }

    public static Funnels$ByteArrayFunnel[] values() {
        return (Funnels$ByteArrayFunnel[]) f275561a.clone();
    }

    public static Funnels$ByteArrayFunnel valueOf(String r100) {
        return (Funnels$ByteArrayFunnel) r27.a.a(Funnels$ByteArrayFunnel.class, r100);
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(byte[] r100, k r101) {
        funnel2(r100, r101);
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(byte[] r100, k r101) {
        r101.f(r100);
    }
}
