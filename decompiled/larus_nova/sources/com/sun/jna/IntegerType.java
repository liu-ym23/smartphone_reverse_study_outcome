package com.sun.jna;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IntegerType extends Number implements NativeMapped {
    private static final long serialVersionUID = 1;
    private Number number;
    private int size;
    private boolean unsigned;
    private long value;

    public static final int compare(long r100, long r101) {
        if (r100 != r101) goto L6;
        return 0;
    L6:
        if (r100 >= r101) goto L9;
        return -1;
    L9:
        return 1;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.number.doubleValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.number.floatValue();
    }

    public int hashCode() {
        return this.number.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // com.sun.jna.NativeMapped
    public Class<?> nativeType() {
        return this.number.getClass();
    }

    public String toString() {
        return this.number.toString();
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // com.sun.jna.NativeMapped
    public Object toNative() {
        return this.number;
    }

    public IntegerType(int r100) {
        this(r100, 0, false);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof IntegerType) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.number.equals(((IntegerType) r100).number) == false) goto L7;
        return true;
    }

    public void setValue(long r100) {
        this.value = r100;
        int r101 = this.size;
        if (r101 == 1) goto L21;
        if (r101 == 2) goto L17;
        if (r101 == 4) goto L13;
        if (r101 != 8) goto L11;
        this.number = Long.valueOf(r100);
        long r102 = r100;
    L24:
        int r103 = this.size;
        if (r103 >= 8) goto L36;
        long r104 = ~((1 << (r103 * 8)) - 1);
        if (r100 < 0) goto L29;
    L30:
        if (r100 >= 0) goto L32;
        return;
    L32:
        if ((r104 & r100) != 0) goto L35;
        return;
    L35:
        throw new IllegalArgumentException("Argument value 0x" + Long.toHexString(r100) + " exceeds native capacity (" + this.size + " bytes) mask=0x" + Long.toHexString(r104));
    L29:
        if (r102 != r100) goto L35;
    L36:
        return;
    L11:
        throw new IllegalArgumentException("Unsupported size: " + this.size);
    L13:
        if (this.unsigned == false) goto L15;
        this.value = BodyPartID.bodyIdMax & r100;
    L15:
        int r105 = (int) r100;
        r102 = r105;
        this.number = Integer.valueOf(r105);
        goto L24
    L17:
        if (this.unsigned == false) goto L19;
        this.value = 65535 & r100;
    L19:
        short r106 = (short) r100;
        r102 = r106;
        this.number = Short.valueOf(r106);
        goto L24
    L21:
        if (this.unsigned == false) goto L23;
        this.value = 255 & r100;
    L23:
        byte r107 = (byte) r100;
        r102 = r107;
        this.number = Byte.valueOf(r107);
        goto L24
    }

    public IntegerType(int r100, boolean r101) {
        this(r100, 0, r101);
    }

    public static <T extends IntegerType> int compare(T r100, T r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r100 != null) goto L8;
        return 1;
    L8:
        if (r101 != null) goto L12;
        return -1;
    L12:
        return compare(r100.longValue(), r101.longValue());
    }

    @Override // com.sun.jna.NativeMapped
    public Object fromNative(Object r100, FromNativeContext r101) {
        if (r100 != null) goto L4;
        long r102 = 0;
    L5:
        IntegerType r103 = (IntegerType) Klass.newInstance(getClass());
        r103.setValue(r102);
        return r103;
    L4:
        r102 = ((Number) r100).longValue();
        goto L5
    }

    public IntegerType(int r100, long r101) {
        this(r100, r101, false);
    }

    public static int compare(IntegerType r100, long r101) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return compare(r100.longValue(), r101);
    }

    public IntegerType(int r100, long r101, boolean r102) {
        this.size = r100;
        this.unsigned = r102;
        setValue(r101);
    }
}
