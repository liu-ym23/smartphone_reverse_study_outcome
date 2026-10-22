package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/relax/relaxframework/StackAlignment;", "", "", "value", "I", "getValue", "()I", "TopLeft", "TopCenter", "TopRight", "CenterLeft", "Center", "CenterRight", "BottomLeft", "BottomCenter", "BottomRight", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum StackAlignment extends Enum<StackAlignment> {
    public static final StackAlignment BottomCenter = null;
    public static final StackAlignment BottomLeft = null;
    public static final StackAlignment BottomRight = null;
    public static final StackAlignment Center = null;
    public static final StackAlignment CenterLeft = null;
    public static final StackAlignment CenterRight = null;
    public static final StackAlignment TopCenter = null;
    public static final StackAlignment TopLeft = null;
    public static final StackAlignment TopRight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StackAlignment[] f404958a = null;
    private final int value;

    public static StackAlignment valueOf(String r100) {
        return (StackAlignment) r27.a.a(StackAlignment.class, r100);
    }

    public static StackAlignment[] values() {
        return (StackAlignment[]) f404958a.clone();
    }

    static {
        StackAlignment r100 = new StackAlignment("TopLeft", 0, 0);
        TopLeft = r100;
        StackAlignment r101 = new StackAlignment("TopCenter", 1, 1);
        TopCenter = r101;
        StackAlignment r102 = new StackAlignment("TopRight", 2, 2);
        TopRight = r102;
        StackAlignment r103 = new StackAlignment("CenterLeft", 3, 3);
        CenterLeft = r103;
        StackAlignment r104 = new StackAlignment("Center", 4, 4);
        Center = r104;
        StackAlignment r105 = new StackAlignment("CenterRight", 5, 5);
        CenterRight = r105;
        StackAlignment r110 = new StackAlignment("BottomLeft", 6, 6);
        BottomLeft = r110;
        StackAlignment r111 = new StackAlignment("BottomCenter", 7, 7);
        BottomCenter = r111;
        StackAlignment r112 = new StackAlignment("BottomRight", 8, 8);
        BottomRight = r112;
        f404958a = new StackAlignment[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public StackAlignment(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
