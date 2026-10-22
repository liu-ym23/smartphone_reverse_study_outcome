package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/LinearOrientation;", "", "", "value", "I", "getValue", "()I", "Horizontal", "Vertical", "HorizontalReverse", "VerticalReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearOrientation extends Enum<LinearOrientation> {
    public static final LinearOrientation Horizontal = null;
    public static final LinearOrientation HorizontalReverse = null;
    public static final LinearOrientation Vertical = null;
    public static final LinearOrientation VerticalReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearOrientation[] f404766a = null;
    private final int value;

    public static LinearOrientation valueOf(String r100) {
        return (LinearOrientation) r27.a.a(LinearOrientation.class, r100);
    }

    public static LinearOrientation[] values() {
        return (LinearOrientation[]) f404766a.clone();
    }

    static {
        LinearOrientation r100 = new LinearOrientation("Horizontal", 0, 0);
        Horizontal = r100;
        LinearOrientation r101 = new LinearOrientation("Vertical", 1, 1);
        Vertical = r101;
        LinearOrientation r102 = new LinearOrientation("HorizontalReverse", 2, 2);
        HorizontalReverse = r102;
        LinearOrientation r103 = new LinearOrientation("VerticalReverse", 3, 3);
        VerticalReverse = r103;
        f404766a = new LinearOrientation[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
