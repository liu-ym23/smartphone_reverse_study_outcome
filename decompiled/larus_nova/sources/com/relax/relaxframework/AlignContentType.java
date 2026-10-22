package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/AlignContentType;", "", "", "value", "I", "getValue", "()I", "Start", "End", "Center", "Stretch", "SpaceBetween", "SpaceAround", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AlignContentType extends Enum<AlignContentType> {
    public static final AlignContentType Center = null;
    public static final AlignContentType End = null;
    public static final AlignContentType SpaceAround = null;
    public static final AlignContentType SpaceBetween = null;
    public static final AlignContentType Start = null;
    public static final AlignContentType Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlignContentType[] f404664a = null;
    private final int value;

    public static AlignContentType valueOf(String r100) {
        return (AlignContentType) r27.a.a(AlignContentType.class, r100);
    }

    public static AlignContentType[] values() {
        return (AlignContentType[]) f404664a.clone();
    }

    static {
        AlignContentType r100 = new AlignContentType("Start", 0, 0);
        Start = r100;
        AlignContentType r101 = new AlignContentType("End", 1, 1);
        End = r101;
        AlignContentType r102 = new AlignContentType("Center", 2, 2);
        Center = r102;
        AlignContentType r103 = new AlignContentType("Stretch", 3, 3);
        Stretch = r103;
        AlignContentType r104 = new AlignContentType("SpaceBetween", 4, 4);
        SpaceBetween = r104;
        AlignContentType r105 = new AlignContentType("SpaceAround", 5, 5);
        SpaceAround = r105;
        f404664a = new AlignContentType[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public AlignContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
