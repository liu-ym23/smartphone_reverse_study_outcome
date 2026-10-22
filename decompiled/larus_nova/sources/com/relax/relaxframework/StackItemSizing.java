package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/StackItemSizing;", "", "", "value", "I", "getValue", "()I", "Auto", "Fill", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum StackItemSizing extends Enum<StackItemSizing> {
    public static final StackItemSizing Auto = null;
    public static final StackItemSizing Fill = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StackItemSizing[] f404959a = null;
    private final int value;

    public static StackItemSizing valueOf(String r100) {
        return (StackItemSizing) r27.a.a(StackItemSizing.class, r100);
    }

    public static StackItemSizing[] values() {
        return (StackItemSizing[]) f404959a.clone();
    }

    static {
        StackItemSizing r100 = new StackItemSizing("Auto", 0, 0);
        Auto = r100;
        StackItemSizing r101 = new StackItemSizing("Fill", 1, 1);
        Fill = r101;
        f404959a = new StackItemSizing[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public StackItemSizing(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
