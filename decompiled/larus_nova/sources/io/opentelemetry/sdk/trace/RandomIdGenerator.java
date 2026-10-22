package io.opentelemetry.sdk.trace;

import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes41.dex */
final enum RandomIdGenerator extends Enum<RandomIdGenerator> implements d {
    public static final RandomIdGenerator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RandomIdGenerator[] f492727a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "RandomIdGenerator{}";
    }

    static {
        RandomIdGenerator r100 = new RandomIdGenerator();
        INSTANCE = r100;
        f492727a = new RandomIdGenerator[]{r100};
        new io.opentelemetry.sdk.internal.f();
    }

    public RandomIdGenerator() {
        super("INSTANCE", 0);
    }

    public static RandomIdGenerator[] values() {
        return (RandomIdGenerator[]) f492727a.clone();
    }

    @Override // io.opentelemetry.sdk.trace.d
    public String generateSpanId() {
        ThreadLocalRandom r100 = ThreadLocalRandom.current();
    L3:
        long r101 = r100.nextLong();
        if (r101 == 0) goto L3;
        if (r101 != 0) goto L7;
        return "0000000000000000";
    L7:
        ThreadLocal<char[]> r102 = io.opentelemetry.api.internal.k.f492680a;
        char[] r103 = r102.get();
        if (r103 != null) goto L10;
    L11:
        r103 = new char[16];
        r102.set(r103);
    L12:
        io.opentelemetry.api.internal.j.b(r101, r103, 0);
        return new String(r103, 0, 16);
    L10:
        if (r103.length >= 16) goto L12;
        goto L11
    }

    @Override // io.opentelemetry.sdk.trace.d
    public String generateTraceId() {
        ThreadLocalRandom r100 = ThreadLocalRandom.current();
        long r101 = r100.nextLong();
    L3:
        long r102 = r100.nextLong();
        if (r102 == 0) goto L3;
        if (r101 != 0) goto L9;
        if (r102 != 0) goto L9;
        return "00000000000000000000000000000000";
    L9:
        ThreadLocal<char[]> r103 = io.opentelemetry.api.internal.k.f492680a;
        char[] r104 = r103.get();
        if (r104 != null) goto L12;
    L13:
        r104 = new char[32];
        r103.set(r104);
    L14:
        io.opentelemetry.api.internal.j.b(r101, r104, 0);
        io.opentelemetry.api.internal.j.b(r102, r104, 16);
        return new String(r104, 0, 32);
    L12:
        if (r104.length >= 32) goto L14;
        goto L13
    }

    public static RandomIdGenerator valueOf(String r100) {
        return (RandomIdGenerator) r27.a.a(RandomIdGenerator.class, r100);
    }
}
