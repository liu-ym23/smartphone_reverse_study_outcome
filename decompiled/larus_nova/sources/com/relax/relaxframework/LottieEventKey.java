package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/LottieEventKey;", "", "", "value", "I", "getValue", "()I", "LottieStart", "LottieComplete", "LottieRepeat", "LottieCancel", "LottieReady", "LottieUpdate", "LottieError", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LottieEventKey extends Enum<LottieEventKey> {
    public static final LottieEventKey LottieCancel = null;
    public static final LottieEventKey LottieComplete = null;
    public static final LottieEventKey LottieError = null;
    public static final LottieEventKey LottieReady = null;
    public static final LottieEventKey LottieRepeat = null;
    public static final LottieEventKey LottieStart = null;
    public static final LottieEventKey LottieUpdate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LottieEventKey[] f404780a = null;
    private final int value;

    public static LottieEventKey valueOf(String r100) {
        return (LottieEventKey) r27.a.a(LottieEventKey.class, r100);
    }

    public static LottieEventKey[] values() {
        return (LottieEventKey[]) f404780a.clone();
    }

    static {
        LottieEventKey r100 = new LottieEventKey("LottieStart", 0, 30022);
        LottieStart = r100;
        LottieEventKey r101 = new LottieEventKey("LottieComplete", 1, 30023);
        LottieComplete = r101;
        LottieEventKey r102 = new LottieEventKey("LottieRepeat", 2, 30024);
        LottieRepeat = r102;
        LottieEventKey r103 = new LottieEventKey("LottieCancel", 3, 30025);
        LottieCancel = r103;
        LottieEventKey r104 = new LottieEventKey("LottieReady", 4, 30026);
        LottieReady = r104;
        LottieEventKey r105 = new LottieEventKey("LottieUpdate", 5, 30027);
        LottieUpdate = r105;
        LottieEventKey r110 = new LottieEventKey("LottieError", 6, 30028);
        LottieError = r110;
        f404780a = new LottieEventKey[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public LottieEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
