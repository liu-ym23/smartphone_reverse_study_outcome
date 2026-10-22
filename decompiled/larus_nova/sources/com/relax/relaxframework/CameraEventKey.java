package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/CameraEventKey;", "", "", "value", "I", "getValue", "()I", "CameraFrame", "CameraError", "CameraReady", "CameraStop", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum CameraEventKey extends Enum<CameraEventKey> {
    public static final CameraEventKey CameraError = null;
    public static final CameraEventKey CameraFrame = null;
    public static final CameraEventKey CameraReady = null;
    public static final CameraEventKey CameraStop = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraEventKey[] f404694a = null;
    private final int value;

    public static CameraEventKey valueOf(String r100) {
        return (CameraEventKey) r27.a.a(CameraEventKey.class, r100);
    }

    public static CameraEventKey[] values() {
        return (CameraEventKey[]) f404694a.clone();
    }

    static {
        CameraEventKey r100 = new CameraEventKey("CameraFrame", 0, 30123);
        CameraFrame = r100;
        CameraEventKey r101 = new CameraEventKey("CameraError", 1, 30124);
        CameraError = r101;
        CameraEventKey r102 = new CameraEventKey("CameraReady", 2, 30125);
        CameraReady = r102;
        CameraEventKey r103 = new CameraEventKey("CameraStop", 3, 30126);
        CameraStop = r103;
        f404694a = new CameraEventKey[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public CameraEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
