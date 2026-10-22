package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/AlignContent;", "", "", "value", "I", "getValue", "()I", "Start", "End", "Center", "Stretch", "SpaceBetween", "SpaceAround", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AlignContent extends Enum<AlignContent> {
    public static final AlignContent Center = null;
    public static final AlignContent End = null;
    public static final AlignContent SpaceAround = null;
    public static final AlignContent SpaceBetween = null;
    public static final AlignContent Start = null;
    public static final AlignContent Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlignContent[] f404663a = null;
    private final int value;

    public static AlignContent valueOf(String r100) {
        return (AlignContent) r27.a.a(AlignContent.class, r100);
    }

    public static AlignContent[] values() {
        return (AlignContent[]) f404663a.clone();
    }

    static {
        AlignContent r100 = new AlignContent("Start", 0, 0);
        Start = r100;
        AlignContent r101 = new AlignContent("End", 1, 1);
        End = r101;
        AlignContent r102 = new AlignContent("Center", 2, 2);
        Center = r102;
        AlignContent r103 = new AlignContent("Stretch", 3, 3);
        Stretch = r103;
        AlignContent r104 = new AlignContent("SpaceBetween", 4, 4);
        SpaceBetween = r104;
        AlignContent r105 = new AlignContent("SpaceAround", 5, 5);
        SpaceAround = r105;
        f404663a = new AlignContent[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public AlignContent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
