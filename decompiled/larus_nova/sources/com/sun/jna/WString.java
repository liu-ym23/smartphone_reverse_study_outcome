package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public final class WString implements CharSequence, Comparable {
    private String string;

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.string;
    }

    public WString(String r100) {
        if (r100 == null) goto L7;
        this.string = r100;
        return;
    L7:
        throw new NullPointerException("String initializer must be non-null");
    }

    @Override // java.lang.CharSequence
    public char charAt(int r100) {
        return toString().charAt(r100);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        return toString().compareTo(r100.toString());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof WString) == true) goto L5;
    L7:
        return false;
    L5:
        if (toString().equals(r100.toString()) == false) goto L7;
        return true;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return toString().subSequence(r100, r101);
    }
}
