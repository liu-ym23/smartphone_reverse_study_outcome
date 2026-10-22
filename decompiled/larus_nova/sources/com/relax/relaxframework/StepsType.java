package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/StepsType;", "", "", "value", "I", "getValue", "()I", "Invalid", "Start", "End", "JumpBoth", "JumpNone", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum StepsType extends Enum<StepsType> {
    public static final StepsType End = null;
    public static final StepsType Invalid = null;
    public static final StepsType JumpBoth = null;
    public static final StepsType JumpNone = null;
    public static final StepsType Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StepsType[] f404960a = null;
    private final int value;

    public static StepsType valueOf(String r100) {
        return (StepsType) r27.a.a(StepsType.class, r100);
    }

    public static StepsType[] values() {
        return (StepsType[]) f404960a.clone();
    }

    static {
        StepsType r100 = new StepsType("Invalid", 0, 0);
        Invalid = r100;
        StepsType r101 = new StepsType("Start", 1, 1);
        Start = r101;
        StepsType r102 = new StepsType("End", 2, 2);
        End = r102;
        StepsType r103 = new StepsType("JumpBoth", 3, 3);
        JumpBoth = r103;
        StepsType r104 = new StepsType("JumpNone", 4, 4);
        JumpNone = r104;
        f404960a = new StepsType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public StepsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
