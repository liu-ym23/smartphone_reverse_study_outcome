package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/RxModifierType;", "", "", "value", "I", "getValue", "()I", "Static", "Reactive", "Computed", "Composed", "Builtin", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RxModifierType extends Enum<RxModifierType> {
    public static final RxModifierType Builtin = null;
    public static final RxModifierType Composed = null;
    public static final RxModifierType Computed = null;
    public static final RxModifierType Reactive = null;
    public static final RxModifierType Static = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RxModifierType[] f404947a = null;
    private final int value;

    public static RxModifierType valueOf(String r100) {
        return (RxModifierType) r27.a.a(RxModifierType.class, r100);
    }

    public static RxModifierType[] values() {
        return (RxModifierType[]) f404947a.clone();
    }

    static {
        RxModifierType r100 = new RxModifierType("Static", 0, 0);
        Static = r100;
        RxModifierType r101 = new RxModifierType("Reactive", 1, 1);
        Reactive = r101;
        RxModifierType r102 = new RxModifierType("Computed", 2, 2);
        Computed = r102;
        RxModifierType r103 = new RxModifierType("Composed", 3, 3);
        Composed = r103;
        RxModifierType r104 = new RxModifierType("Builtin", 4, 4);
        Builtin = r104;
        f404947a = new RxModifierType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public RxModifierType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
