package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/BackgroundOriginType;", "", "", "value", "I", "getValue", "()I", "PaddingBox", "BorderBox", "ContentBox", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BackgroundOriginType extends Enum<BackgroundOriginType> {
    public static final BackgroundOriginType BorderBox = null;
    public static final BackgroundOriginType ContentBox = null;
    public static final BackgroundOriginType PaddingBox = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundOriginType[] f404682a = null;
    private final int value;

    public static BackgroundOriginType valueOf(String r100) {
        return (BackgroundOriginType) r27.a.a(BackgroundOriginType.class, r100);
    }

    public static BackgroundOriginType[] values() {
        return (BackgroundOriginType[]) f404682a.clone();
    }

    static {
        BackgroundOriginType r100 = new BackgroundOriginType("PaddingBox", 0, 0);
        PaddingBox = r100;
        BackgroundOriginType r101 = new BackgroundOriginType("BorderBox", 1, 1);
        BorderBox = r101;
        BackgroundOriginType r102 = new BackgroundOriginType("ContentBox", 2, 2);
        ContentBox = r102;
        f404682a = new BackgroundOriginType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public BackgroundOriginType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
