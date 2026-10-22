package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/BackgroundImageType;", "", "", "value", "I", "getValue", "()I", "None", "Url", "LinearGradient", "RadialGradient", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BackgroundImageType extends Enum<BackgroundImageType> {
    public static final BackgroundImageType LinearGradient = null;
    public static final BackgroundImageType None = null;
    public static final BackgroundImageType RadialGradient = null;
    public static final BackgroundImageType Url = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundImageType[] f404680a = null;
    private final int value;

    public static BackgroundImageType valueOf(String r100) {
        return (BackgroundImageType) r27.a.a(BackgroundImageType.class, r100);
    }

    public static BackgroundImageType[] values() {
        return (BackgroundImageType[]) f404680a.clone();
    }

    static {
        BackgroundImageType r100 = new BackgroundImageType("None", 0, 0);
        None = r100;
        BackgroundImageType r101 = new BackgroundImageType("Url", 1, 1);
        Url = r101;
        BackgroundImageType r102 = new BackgroundImageType("LinearGradient", 2, 2);
        LinearGradient = r102;
        BackgroundImageType r103 = new BackgroundImageType("RadialGradient", 3, 3);
        RadialGradient = r103;
        f404680a = new BackgroundImageType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public BackgroundImageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
