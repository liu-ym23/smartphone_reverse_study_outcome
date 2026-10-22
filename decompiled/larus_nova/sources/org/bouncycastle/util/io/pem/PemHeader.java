package org.bouncycastle.util.io.pem;

/* JADX INFO: loaded from: classes42.dex */
public class PemHeader {
    private String name;
    private String value;

    public PemHeader(String r100, String r101) {
        this.name = r100;
        this.value = r101;
    }

    private int getHashCode(String r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return r100.hashCode();
    }

    private boolean isEqual(String r100, String r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 == null) goto L10;
        if (r101 != null) goto L9;
        return false;
    L9:
        return r100.equals(r101);
    L10:
        return false;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PemHeader) == true) goto L5;
        return false;
    L5:
        PemHeader r101 = (PemHeader) r100;
        if (r101 != this) goto L8;
    L11:
        return true;
    L8:
        if (isEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (isEqual(this.value, r101.value) == true) goto L11;
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return getHashCode(this.name) + (getHashCode(this.value) * 31);
    }
}
