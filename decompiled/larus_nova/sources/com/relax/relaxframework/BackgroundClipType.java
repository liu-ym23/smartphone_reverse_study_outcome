package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/BackgroundClipType;", "", "", "value", "I", "getValue", "()I", "PaddingBox", "BorderBox", "ContentBox", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BackgroundClipType extends Enum<BackgroundClipType> {
    public static final BackgroundClipType BorderBox = null;
    public static final BackgroundClipType ContentBox = null;
    public static final BackgroundClipType PaddingBox = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundClipType[] f404679a = null;
    private final int value;

    public static BackgroundClipType valueOf(String r100) {
        return (BackgroundClipType) r27.a.a(BackgroundClipType.class, r100);
    }

    public static BackgroundClipType[] values() {
        return (BackgroundClipType[]) f404679a.clone();
    }

    static {
        BackgroundClipType r100 = new BackgroundClipType("PaddingBox", 0, 0);
        PaddingBox = r100;
        BackgroundClipType r101 = new BackgroundClipType("BorderBox", 1, 1);
        BorderBox = r101;
        BackgroundClipType r102 = new BackgroundClipType("ContentBox", 2, 2);
        ContentBox = r102;
        f404679a = new BackgroundClipType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public BackgroundClipType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
