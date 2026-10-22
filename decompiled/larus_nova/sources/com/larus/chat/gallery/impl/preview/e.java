package com.larus.chat.gallery.impl.preview;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f324288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f324289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f324290d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f324287a == r101.f324287a) goto L12;
        return false;
    L12:
        if (this.f324288b == r101.f324288b) goto L15;
        return false;
    L15:
        if (this.f324289c == r101.f324289c) goto L18;
        return false;
    L18:
        if (this.f324290d == r101.f324290d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f324287a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f324288b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f324289c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f324290d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewDisplayProfile(useUnifiedMediaCanvas=" + this.f324287a + ", enableDownScale=" + this.f324288b + ", enableLongImageTopInset=" + this.f324289c + ", enableLongImageRadius=" + this.f324290d + ')';
    }

    public e(boolean r100) {
        this.f324287a = r100;
        this.f324288b = false;
        this.f324289c = false;
        this.f324290d = false;
    }
}
