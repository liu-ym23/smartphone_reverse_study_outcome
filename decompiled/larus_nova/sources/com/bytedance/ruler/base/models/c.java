package com.bytedance.ruler.base.models;

import com.google.gson.JsonElement;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f267661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f267663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f267664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JsonElement f267665e;

    public c() {
        this(0, null, null, null, 31);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("[code = ");
        r100.append(this.f267661a);
        r100.append(", ruleModel=");
        e r101 = this.f267663c;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append(", msg = ");
        r100.append(this.f267662b);
        r100.append(", error = ");
        r100.append(this.f267664d);
        r100.append(", result = ");
        r100.append(this.f267665e);
        r100.append(']');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public c(int r100, String r101, Throwable r102, JsonElement r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 16) == 0) goto L14;
        r103 = null;
    L14:
        this.f267661a = r100;
        this.f267662b = r101;
        this.f267663c = null;
        this.f267664d = r102;
        this.f267665e = r103;
    }
}
