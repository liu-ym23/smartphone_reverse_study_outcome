package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/ContainerType;", "", "", "value", "I", "getValue", "()I", "Lynx", "Web", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType Lynx = null;
    public static final ContainerType Unknown = null;
    public static final ContainerType Web = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f267873a = null;
    private final int value;

    public static ContainerType valueOf(String r100) {
        return (ContainerType) r27.a.a(ContainerType.class, r100);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f267873a.clone();
    }

    static {
        ContainerType r100 = new ContainerType("Lynx", 0, 0);
        Lynx = r100;
        ContainerType r101 = new ContainerType("Web", 1, 1);
        Web = r101;
        ContainerType r102 = new ContainerType("Unknown", 2, 2);
        Unknown = r102;
        f267873a = new ContainerType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
