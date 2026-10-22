package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
final enum LynxSubErrorCode$Consumer extends Enum<LynxSubErrorCode$Consumer> {
    public static final LynxSubErrorCode$Consumer CLIENT = null;
    public static final LynxSubErrorCode$Consumer FRONT_END = null;
    public static final LynxSubErrorCode$Consumer LYNX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxSubErrorCode$Consumer[] f381672a = null;
    public final String value;

    static {
        LynxSubErrorCode$Consumer r100 = new LynxSubErrorCode$Consumer("FRONT_END", 0, "front-end");
        FRONT_END = r100;
        LynxSubErrorCode$Consumer r101 = new LynxSubErrorCode$Consumer("CLIENT", 1, "client");
        CLIENT = r101;
        LynxSubErrorCode$Consumer r102 = new LynxSubErrorCode$Consumer("LYNX", 2, "lynx");
        LYNX = r102;
        f381672a = new LynxSubErrorCode$Consumer[]{r100, r101, r102};
    }

    public static LynxSubErrorCode$Consumer[] values() {
        return (LynxSubErrorCode$Consumer[]) f381672a.clone();
    }

    public static LynxSubErrorCode$Consumer valueOf(String r100) {
        return (LynxSubErrorCode$Consumer) r27.a.a(LynxSubErrorCode$Consumer.class, r100);
    }

    public LynxSubErrorCode$Consumer(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
