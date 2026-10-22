package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/DisplayType;", "", "", "value", "I", "getValue", "()I", "None", "Flex", "Grid", "Linear", "Relative", "Block", "Auto", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum DisplayType extends Enum<DisplayType> {
    public static final DisplayType Auto = null;
    public static final DisplayType Block = null;
    public static final DisplayType Flex = null;
    public static final DisplayType Grid = null;
    public static final DisplayType Linear = null;
    public static final DisplayType None = null;
    public static final DisplayType Relative = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayType[] f404708a = null;
    private final int value;

    public static DisplayType valueOf(String r100) {
        return (DisplayType) r27.a.a(DisplayType.class, r100);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) f404708a.clone();
    }

    static {
        DisplayType r100 = new DisplayType("None", 0, 0);
        None = r100;
        DisplayType r101 = new DisplayType("Flex", 1, 1);
        Flex = r101;
        DisplayType r102 = new DisplayType("Grid", 2, 2);
        Grid = r102;
        DisplayType r103 = new DisplayType("Linear", 3, 3);
        Linear = r103;
        DisplayType r104 = new DisplayType("Relative", 4, 4);
        Relative = r104;
        DisplayType r105 = new DisplayType("Block", 5, 5);
        Block = r105;
        DisplayType r110 = new DisplayType("Auto", 6, 6);
        Auto = r110;
        f404708a = new DisplayType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public DisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
