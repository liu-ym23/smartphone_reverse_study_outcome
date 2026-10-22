package com.larus.bmhome.setting;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f313822a;

    public k() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (this.f313822a == ((k) r100).f313822a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f313822a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "SettingsData(isAppSettings=" + this.f313822a + ')';
    }

    public k(boolean r100) {
        this.f313822a = r100;
    }
}
