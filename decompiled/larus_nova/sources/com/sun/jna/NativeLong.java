package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public class NativeLong extends IntegerType {
    public static final int SIZE = 0;
    private static final long serialVersionUID = 1;

    static {
        SIZE = Native.LONG_SIZE;
    }

    public NativeLong() {
        this(0);
    }

    public NativeLong(long r100) {
        this(r100, false);
    }

    public NativeLong(long r100, boolean r101) {
        super(SIZE, r100, r101);
    }
}
