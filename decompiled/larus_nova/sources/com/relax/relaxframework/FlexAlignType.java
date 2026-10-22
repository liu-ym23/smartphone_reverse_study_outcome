package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/FlexAlignType;", "", "", "value", "I", "getValue", "()I", "Auto", "Stretch", "Start", "End", "Center", "Baseline", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FlexAlignType extends Enum<FlexAlignType> {
    public static final FlexAlignType Auto = null;
    public static final FlexAlignType Baseline = null;
    public static final FlexAlignType Center = null;
    public static final FlexAlignType End = null;
    public static final FlexAlignType Start = null;
    public static final FlexAlignType Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexAlignType[] f404720a = null;
    private final int value;

    public static FlexAlignType valueOf(String r100) {
        return (FlexAlignType) r27.a.a(FlexAlignType.class, r100);
    }

    public static FlexAlignType[] values() {
        return (FlexAlignType[]) f404720a.clone();
    }

    static {
        FlexAlignType r100 = new FlexAlignType("Auto", 0, 0);
        Auto = r100;
        FlexAlignType r101 = new FlexAlignType("Stretch", 1, 1);
        Stretch = r101;
        FlexAlignType r102 = new FlexAlignType("Start", 2, 2);
        Start = r102;
        FlexAlignType r103 = new FlexAlignType("End", 3, 3);
        End = r103;
        FlexAlignType r104 = new FlexAlignType("Center", 4, 4);
        Center = r104;
        FlexAlignType r105 = new FlexAlignType("Baseline", 5, 5);
        Baseline = r105;
        f404720a = new FlexAlignType[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public FlexAlignType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
