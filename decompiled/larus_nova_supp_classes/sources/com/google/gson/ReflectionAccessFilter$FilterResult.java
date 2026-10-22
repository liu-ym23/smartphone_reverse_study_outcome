package com.google.gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final enum ReflectionAccessFilter$FilterResult extends Enum<ReflectionAccessFilter$FilterResult> {
    private static final /* synthetic */ ReflectionAccessFilter$FilterResult[] $VALUES = null;
    public static final ReflectionAccessFilter$FilterResult ALLOW = null;
    public static final ReflectionAccessFilter$FilterResult BLOCK_ALL = null;
    public static final ReflectionAccessFilter$FilterResult BLOCK_INACCESSIBLE = null;
    public static final ReflectionAccessFilter$FilterResult INDECISIVE = null;

    static {
        ReflectionAccessFilter$FilterResult r0 = new ReflectionAccessFilter$FilterResult("ALLOW", 0);
        ALLOW = r0;
        ReflectionAccessFilter$FilterResult r1 = new ReflectionAccessFilter$FilterResult("INDECISIVE", 1);
        INDECISIVE = r1;
        ReflectionAccessFilter$FilterResult r3 = new ReflectionAccessFilter$FilterResult("BLOCK_INACCESSIBLE", 2);
        BLOCK_INACCESSIBLE = r3;
        ReflectionAccessFilter$FilterResult r5 = new ReflectionAccessFilter$FilterResult("BLOCK_ALL", 3);
        BLOCK_ALL = r5;
        $VALUES = new ReflectionAccessFilter$FilterResult[]{r0, r1, r3, r5};
    }

    public static ReflectionAccessFilter$FilterResult[] values() {
        return (ReflectionAccessFilter$FilterResult[]) $VALUES.clone();
    }

    public static ReflectionAccessFilter$FilterResult valueOf(String r1) {
        return (ReflectionAccessFilter$FilterResult) Enum.valueOf(ReflectionAccessFilter$FilterResult.class, r1);
    }

    private ReflectionAccessFilter$FilterResult(String r1, int r2) {
        super(r1, r2);
    }
}
