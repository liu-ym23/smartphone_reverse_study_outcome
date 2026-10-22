package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public abstract enum LongSerializationPolicy extends Enum<LongSerializationPolicy> {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES = null;
    public static final LongSerializationPolicy DEFAULT = null;
    public static final LongSerializationPolicy STRING = null;

    public abstract JsonElement serialize(Long r100);

    static {
        final String r100 = "DEFAULT";
        final int r101 = 0;
        LongSerializationPolicy r102 = new AnonymousClass1(r100, r101);
        DEFAULT = r102;
        final String r103 = "STRING";
        final int r104 = 1;
        LongSerializationPolicy r105 = new AnonymousClass2(r103, r104);
        STRING = r105;
        $VALUES = new LongSerializationPolicy[]{r102, r105};
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public static LongSerializationPolicy valueOf(String r100) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, r100);
    }

    private LongSerializationPolicy(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ LongSerializationPolicy(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
