package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
class NativeString implements CharSequence, Comparable {
    static final String WIDE_STRING = "--WIDE-STRING--";
    private String encoding;
    private Pointer pointer;

    public class StringMemory extends Memory {
        final /* synthetic */ NativeString this$0;

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return this.this$0.toString();
        }

        public StringMemory(NativeString r100, long r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (WIDE_STRING.equals(this.encoding) == false) goto L6;
        return this.pointer.getWideString(0);
    L6:
        return this.pointer.getString(0, this.encoding);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    public NativeString(WString r100) {
        this(r100.toString(), WIDE_STRING);
    }

    @Override // java.lang.CharSequence
    public char charAt(int r100) {
        return toString().charAt(r100);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return toString().compareTo(r100.toString());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CharSequence) == true) goto L5;
        return false;
    L5:
        if (compareTo(r100) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public NativeString(String r100) {
        this(r100, Native.getDefaultStringEncoding());
    }

    public NativeString(String r110, String r111) {
        if (r110 == null) goto L10;
        this.encoding = r111;
        if (WIDE_STRING.equals(r111) == false) goto L7;
        StringMemory r100 = new StringMemory(this, (r110.length() + 1) * Native.WCHAR_SIZE);
        this.pointer = r100;
        r100.setWideString(0, r110);
        return;
    L7:
        byte[] r112 = Native.getBytes(r110, r111);
        StringMemory r101 = new StringMemory(this, r112.length + 1);
        this.pointer = r101;
        r101.write(0, r112, 0, r112.length);
        this.pointer.setByte(r112.length, (byte) 0);
        return;
    L10:
        throw new NullPointerException("String must not be null");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return toString().subSequence(r100, r101);
    }

    public NativeString(String r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = WIDE_STRING;
    L5:
        this(r100, r102);
        return;
    L4:
        r102 = Native.getDefaultStringEncoding();
        goto L5
    }
}
