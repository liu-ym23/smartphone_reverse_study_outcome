package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/AlignItems;", "", "", "value", "I", "getValue", "()I", "Auto", "Stretch", "Start", "End", "Center", "Baseline", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AlignItems extends Enum<AlignItems> {
    public static final AlignItems Auto = null;
    public static final AlignItems Baseline = null;
    public static final AlignItems Center = null;
    public static final AlignItems End = null;
    public static final AlignItems Start = null;
    public static final AlignItems Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlignItems[] f404665a = null;
    private final int value;

    public static AlignItems valueOf(String r100) {
        return (AlignItems) r27.a.a(AlignItems.class, r100);
    }

    public static AlignItems[] values() {
        return (AlignItems[]) f404665a.clone();
    }

    static {
        AlignItems r100 = new AlignItems("Auto", 0, 0);
        Auto = r100;
        AlignItems r101 = new AlignItems("Stretch", 1, 1);
        Stretch = r101;
        AlignItems r102 = new AlignItems("Start", 2, 2);
        Start = r102;
        AlignItems r103 = new AlignItems("End", 3, 3);
        End = r103;
        AlignItems r104 = new AlignItems("Center", 4, 4);
        Center = r104;
        AlignItems r105 = new AlignItems("Baseline", 5, 5);
        Baseline = r105;
        f404665a = new AlignItems[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public AlignItems(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
