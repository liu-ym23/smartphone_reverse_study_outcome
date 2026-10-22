package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/LinearCrossGravity;", "", "", "value", "I", "getValue", "()I", "None", "Start", "End", "Center", "Stretch", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearCrossGravity extends Enum<LinearCrossGravity> {
    public static final LinearCrossGravity Center = null;
    public static final LinearCrossGravity End = null;
    public static final LinearCrossGravity None = null;
    public static final LinearCrossGravity Start = null;
    public static final LinearCrossGravity Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearCrossGravity[] f404759a = null;
    private final int value;

    public static LinearCrossGravity valueOf(String r100) {
        return (LinearCrossGravity) r27.a.a(LinearCrossGravity.class, r100);
    }

    public static LinearCrossGravity[] values() {
        return (LinearCrossGravity[]) f404759a.clone();
    }

    static {
        LinearCrossGravity r100 = new LinearCrossGravity("None", 0, 0);
        None = r100;
        LinearCrossGravity r101 = new LinearCrossGravity("Start", 1, 1);
        Start = r101;
        LinearCrossGravity r102 = new LinearCrossGravity("End", 2, 2);
        End = r102;
        LinearCrossGravity r103 = new LinearCrossGravity("Center", 3, 3);
        Center = r103;
        LinearCrossGravity r104 = new LinearCrossGravity("Stretch", 4, 4);
        Stretch = r104;
        f404759a = new LinearCrossGravity[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearCrossGravity(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
