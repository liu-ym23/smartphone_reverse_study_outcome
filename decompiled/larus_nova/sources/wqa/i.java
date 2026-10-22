package wqa;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560776b;

    public final int hashCode() {
        String r100 = this.f560775a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f560776b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.f560775a;
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r100.append(r101);
        r100.append(": ");
        String r103 = this.f560776b;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (i.class != r100.getClass()) goto L26;
        i r101 = (i) r100;
        String r102 = this.f560775a;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f560775a) == false) goto L17;
    L18:
        String r103 = this.f560776b;
        String r104 = r101.f560776b;
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
        if (r101.f560775a == null) goto L18;
        goto L17
    }

    public i(String r100, String r101) {
        this.f560775a = r100;
        this.f560776b = r101;
    }
}
