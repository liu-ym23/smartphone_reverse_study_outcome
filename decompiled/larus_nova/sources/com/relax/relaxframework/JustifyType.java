package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/JustifyType;", "", "", "value", "I", "getValue", "()I", "Auto", "Stretch", "Start", "End", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum JustifyType extends Enum<JustifyType> {
    public static final JustifyType Auto = null;
    public static final JustifyType Center = null;
    public static final JustifyType End = null;
    public static final JustifyType Start = null;
    public static final JustifyType Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JustifyType[] f404751a = null;
    private final int value;

    public static JustifyType valueOf(String r100) {
        return (JustifyType) r27.a.a(JustifyType.class, r100);
    }

    public static JustifyType[] values() {
        return (JustifyType[]) f404751a.clone();
    }

    static {
        JustifyType r100 = new JustifyType("Auto", 0, 0);
        Auto = r100;
        JustifyType r101 = new JustifyType("Stretch", 1, 1);
        Stretch = r101;
        JustifyType r102 = new JustifyType("Start", 2, 2);
        Start = r102;
        JustifyType r103 = new JustifyType("End", 3, 3);
        End = r103;
        JustifyType r104 = new JustifyType("Center", 4, 4);
        Center = r104;
        f404751a = new JustifyType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public JustifyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
