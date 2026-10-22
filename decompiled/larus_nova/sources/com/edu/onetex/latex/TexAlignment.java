package com.edu.onetex.latex;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/edu/onetex/latex/TexAlignment;", "", "", "value", "I", "getValue", "()I", "LEFT", "RIGHT", "CENTER", "JUSTIFIED", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final enum TexAlignment extends Enum<TexAlignment> {
    public static final TexAlignment CENTER = null;
    public static final TexAlignment JUSTIFIED = null;
    public static final TexAlignment LEFT = null;
    public static final TexAlignment RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TexAlignment[] f273699a = null;
    private final int value;

    static {
        TexAlignment r100 = new TexAlignment("LEFT", 0, 0);
        LEFT = r100;
        TexAlignment r101 = new TexAlignment("RIGHT", 1, 1);
        RIGHT = r101;
        TexAlignment r102 = new TexAlignment("CENTER", 2, 2);
        CENTER = r102;
        TexAlignment r103 = new TexAlignment("JUSTIFIED", 3, 5);
        JUSTIFIED = r103;
        f273699a = new TexAlignment[]{r100, r101, r102, r103};
    }

    public static TexAlignment valueOf(String r100) {
        return (TexAlignment) a.a(TexAlignment.class, r100);
    }

    public static TexAlignment[] values() {
        return (TexAlignment[]) f273699a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TexAlignment(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
