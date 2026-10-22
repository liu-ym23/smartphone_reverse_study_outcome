package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;

/* JADX INFO: loaded from: classes32.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableMap f383219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MapBuffer f383220b;

    public final boolean j() {
        ReadableMap r100 = this.f383219a;
        if (r100 != null) goto L5;
    L6:
        MapBuffer r101 = this.f383220b;
        if (r101 != null) goto L9;
    L12:
        return true;
    L9:
        if (r101.count() == 0) goto L12;
    L11:
        return false;
    L5:
        if (r100.size() != 0) goto L11;
        goto L6
    }

    public final String toString() {
        return "{ " + x0.class.getSimpleName() + ": " + this.f383219a.toString() + " }";
    }

    public x0(ReadableMap r100) {
        this.f383220b = null;
        this.f383219a = r100;
    }

    public final ReadableArray a(String r100) {
        return this.f383219a.getArray(r100);
    }

    public final f6a.a d(String r100) {
        return this.f383219a.getDynamic(r100);
    }

    public final ReadableMap g(String r100) {
        return this.f383219a.getMap(r100);
    }

    public final String h(String r100) {
        return this.f383219a.getString(r100);
    }

    public final boolean i(String r100) {
        return this.f383219a.hasKey(r100);
    }

    public final boolean k(String r100) {
        return this.f383219a.isNull(r100);
    }

    public x0(ReadableMap r100, MapBuffer r101) {
        this.f383220b = null;
        this.f383219a = r100;
        this.f383220b = r101;
    }

    public final boolean b(String r100, boolean r101) {
        if (this.f383219a.isNull(r100) == false) goto L6;
        return r101;
    L6:
        return this.f383219a.getBoolean(r100);
    }

    public final double c(String r100, double r101) {
        if (this.f383219a.isNull(r100) == false) goto L6;
        return r101;
    L6:
        return this.f383219a.getDouble(r100);
    }

    public final float e(String r100, float r101) {
        if (this.f383219a.isNull(r100) == false) goto L6;
        return r101;
    L6:
        return (float) this.f383219a.getDouble(r100);
    }

    public final int f(String r100, int r101) {
        if (this.f383219a.isNull(r100) == false) goto L6;
        return r101;
    L6:
        return this.f383219a.getInt(r100);
    }
}
