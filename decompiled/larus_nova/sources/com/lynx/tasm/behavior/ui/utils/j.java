package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f383146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f383147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadableArray f383148c;

    public final float a() {
        if (this.f383146a == 0) goto L7;
        return 0.0f;
    L7:
        return this.f383147b;
    }

    public j() {
        this.f383147b = 0.0f;
        this.f383146a = 0;
    }

    public final float b(float r100) {
        return c(this.f383148c, this.f383147b, this.f383146a, r100);
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        j r101 = (j) r100;
        int r102 = this.f383146a;
        if (r102 == r101.f383146a) goto L9;
        return false;
    L9:
        if (r102 == 2) goto L13;
        return com.lynx.tasm.utils.b.a(this.f383147b, r101.f383147b);
    L13:
        return this.f383148c.asArrayList().equals(r101.f383148c.asArrayList());
    }

    public j(f6a.a r100, int r101) {
        if (r101 != 2) goto L5;
        this.f383148c = r100.asArray();
    L9:
        this.f383146a = r101;
        return;
    L5:
        if (r101 != 0) goto L7;
    L8:
        this.f383147b = (float) r100.asDouble();
        goto L9
    L7:
        if (r101 != 1) goto L9;
        goto L8
    }

    public static float c(ReadableArray r100, float r101, int r102, float r110) {
        if (r102 == 1) goto L5;
        if (r102 != 0) goto L9;
        return r101;
    L9:
        if (r102 != 2) goto L23;
        int r103 = 0;
        float r104 = 0.0f;
    L12:
        if (r103 >= r100.size()) goto L22;
        int r105 = r100.getInt(r103 + 1);
        if (r105 != 2) goto L17;
        ReadableArray r106 = r100.getArray(r103);
    L16:
        float r107 = 0.0f;
    L21:
        r104 = r104 + c(r106, r107, r105, r110);
        r103 = r103 + 2;
        goto L12
    L17:
        r106 = null;
        if (r105 == 0) goto L20;
        if (r105 != 1) goto L16;
    L20:
        r107 = (float) r100.getDouble(r103);
        goto L21
    L22:
        return r104;
    L23:
        return 0.0f;
    L5:
        return r101 * r110;
    }
}
