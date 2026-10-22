package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: classes32.dex */
public final enum PlatformMethodCallbackResult extends Enum<PlatformMethodCallbackResult> {
    public static final PlatformMethodCallbackResult METHOD_NOT_FOUND = null;
    public static final PlatformMethodCallbackResult NODE_NOT_FOUND = null;
    public static final PlatformMethodCallbackResult PARAM_INVALID = null;
    public static final PlatformMethodCallbackResult SUCCESS = null;
    public static final PlatformMethodCallbackResult UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformMethodCallbackResult[] f380850a = null;

    static {
        PlatformMethodCallbackResult r100 = new PlatformMethodCallbackResult("SUCCESS", 0);
        SUCCESS = r100;
        PlatformMethodCallbackResult r101 = new PlatformMethodCallbackResult("UNKNOWN", 1);
        UNKNOWN = r101;
        PlatformMethodCallbackResult r102 = new PlatformMethodCallbackResult("NODE_NOT_FOUND", 2);
        NODE_NOT_FOUND = r102;
        PlatformMethodCallbackResult r103 = new PlatformMethodCallbackResult("METHOD_NOT_FOUND", 3);
        METHOD_NOT_FOUND = r103;
        PlatformMethodCallbackResult r104 = new PlatformMethodCallbackResult("PARAM_INVALID", 4);
        PARAM_INVALID = r104;
        f380850a = new PlatformMethodCallbackResult[]{r100, r101, r102, r103, r104};
    }

    public static PlatformMethodCallbackResult[] values() {
        return (PlatformMethodCallbackResult[]) f380850a.clone();
    }

    public static PlatformMethodCallbackResult valueOf(String r100) {
        return (PlatformMethodCallbackResult) r27.a.a(PlatformMethodCallbackResult.class, r100);
    }

    public PlatformMethodCallbackResult(String r100, int r101) {
        super(r100, r101);
    }
}
