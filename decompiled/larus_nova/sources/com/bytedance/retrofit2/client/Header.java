package com.bytedance.retrofit2.client;

/* JADX INFO: loaded from: classes3.dex */
public final class Header {
    private final String name;
    private final String value;

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.name;
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r100.append(r101);
        r100.append(": ");
        String r103 = this.value;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        return r100.toString();
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (Header.class != r100.getClass()) goto L26;
        Header r101 = (Header) r100;
        String r102 = this.name;
        if (r102 == null) goto L16;
        if (r102.equals(r101.name) == false) goto L17;
    L18:
        String r103 = this.value;
        String r104 = r101.value;
        if (r103 != null) goto L21;
        if (r104 == null) goto L25;
    L24:
        return false;
    L25:
        return true;
    L21:
        if (r103.equals(r104) == true) goto L25;
    L17:
        return false;
    L16:
        if (r101.name == null) goto L18;
        goto L17
    }

    public Header(String r100, String r101) {
        this.name = r100;
        this.value = r101;
    }
}
