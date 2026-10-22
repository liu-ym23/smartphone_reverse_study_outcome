package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/CoreViewType;", "", "", "value", "I", "getValue", "()I", "AnnieXCard", "BulletCard", "BDXView", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum CoreViewType extends Enum<CoreViewType> {
    public static final CoreViewType AnnieXCard = null;
    public static final CoreViewType BDXView = null;
    public static final CoreViewType BulletCard = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoreViewType[] f267874a = null;
    private final int value;

    public static CoreViewType valueOf(String r100) {
        return (CoreViewType) r27.a.a(CoreViewType.class, r100);
    }

    public static CoreViewType[] values() {
        return (CoreViewType[]) f267874a.clone();
    }

    static {
        CoreViewType r100 = new CoreViewType("AnnieXCard", 0, 0);
        AnnieXCard = r100;
        CoreViewType r101 = new CoreViewType("BulletCard", 1, 1);
        BulletCard = r101;
        CoreViewType r102 = new CoreViewType("BDXView", 2, 2);
        BDXView = r102;
        f267874a = new CoreViewType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public CoreViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
