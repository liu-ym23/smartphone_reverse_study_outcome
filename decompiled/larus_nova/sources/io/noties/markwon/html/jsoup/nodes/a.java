package io.noties.markwon.html.jsoup.nodes;

import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Map.Entry<String, String>, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f492571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f492572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f492573c;

    @Override // java.util.Map.Entry
    public final int hashCode() {
        String r100 = this.f492571a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f492572b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Object clone() throws CloneNotSupportedException {
        return (a) super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // java.util.Map.Entry
    public final String getKey() {
        return this.f492571a;
    }

    @Override // java.util.Map.Entry
    public final String getValue() {
        return this.f492572b;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L25;
        a r101 = (a) r100;
        String r102 = this.f492571a;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f492571a) == false) goto L17;
    L18:
        String r103 = this.f492572b;
        String r104 = r101.f492572b;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.f492571a == null) goto L18;
        goto L17
    }

    @Override // java.util.Map.Entry
    public final String setValue(String r100) {
        String r101 = r100;
        b r102 = this.f492573c;
        int r103 = r102.a(this.f492571a);
        if (r103 == (-1)) goto L7;
        String r104 = r102.f492577c[r103];
        if (r104 == null) goto L7;
    L8:
        b r105 = this.f492573c;
        if (r105 == null) goto L13;
        int r106 = r105.a(this.f492571a);
        if (r106 == (-1)) goto L13;
        this.f492573c.f492577c[r106] = r101;
    L13:
        this.f492572b = r101;
        return r104;
    L7:
        r104 = "";
        goto L8
    }

    public a(String r100, String r101, b r102) {
        if (r100 == null) goto L11;
        this.f492571a = r100.trim();
        if (r100.length() == 0) goto L9;
        this.f492572b = r101;
        this.f492573c = r102;
        return;
    L9:
        throw new IllegalArgumentException("String must not be empty");
    L11:
        throw new IllegalArgumentException("Object must not be null");
    }
}
