package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/BackgroundSizeType;", "", "", "value", "I", "getValue", "()I", "Auto", "Cover", "Contain", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BackgroundSizeType extends Enum<BackgroundSizeType> {
    public static final BackgroundSizeType Auto = null;
    public static final BackgroundSizeType Contain = null;
    public static final BackgroundSizeType Cover = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundSizeType[] f404685a = null;
    private final int value;

    public static BackgroundSizeType valueOf(String r100) {
        return (BackgroundSizeType) r27.a.a(BackgroundSizeType.class, r100);
    }

    public static BackgroundSizeType[] values() {
        return (BackgroundSizeType[]) f404685a.clone();
    }

    static {
        BackgroundSizeType r100 = new BackgroundSizeType("Auto", 0, 32);
        Auto = r100;
        BackgroundSizeType r101 = new BackgroundSizeType("Cover", 1, 33);
        Cover = r101;
        BackgroundSizeType r102 = new BackgroundSizeType("Contain", 2, 34);
        Contain = r102;
        f404685a = new BackgroundSizeType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public BackgroundSizeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
