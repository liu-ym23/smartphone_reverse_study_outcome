package com.lynx.tasm.behavior.ui;

import android.graphics.Color;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f382527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f382528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f382529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f382530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f382531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f382532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f382533g;

    public final boolean a() {
        if (this.f382533g == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f382533g * 31) + this.f382527a) * 31;
        float r101 = this.f382528b;
        int r102 = 0;
        if (r101 == 0.0f) goto L5;
        int r103 = Float.floatToIntBits(r101);
    L6:
        int r104 = (r100 + r103) * 31;
        float r105 = this.f382529c;
        if (r105 == 0.0f) goto L9;
        int r106 = Float.floatToIntBits(r105);
    L10:
        int r107 = (r104 + r106) * 31;
        float r108 = this.f382530d;
        if (r108 == 0.0f) goto L13;
        int r109 = Float.floatToIntBits(r108);
    L14:
        int r110 = (r107 + r109) * 31;
        float r111 = this.f382531e;
        if (r111 == 0.0f) goto L17;
        int r112 = Float.floatToIntBits(r111);
    L18:
        int r113 = (r110 + r112) * 31;
        float r114 = this.f382532f;
        if (r114 == 0.0f) goto L22;
        r102 = Float.floatToIntBits(r114);
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ShadowData: Color: red " + Color.red(this.f382527a) + " green: " + Color.green(this.f382527a) + " blue: " + Color.blue(Color.blue(this.f382527a)) + " OffsetX: " + this.f382528b + " offsetY: " + this.f382529c + " blurRadius: " + this.f382530d + " spreadRadius: " + this.f382531e + "option: " + this.f382533g;
    }

    public g() {
        this.f382533g = 0;
    }

    public static List<g> b(ReadableArray r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.size() == 0) goto L31;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L8:
        if (r102 >= r100.size()) goto L25;
        ReadableArray r103 = r100.getArray(r102);
        g r104 = new g();
        r104.f382528b = (float) r103.getDouble(0);
        boolean r105 = true;
        r104.f382529c = (float) r103.getDouble(1);
        float r106 = (float) r103.getDouble(2);
        r104.f382530d = r106;
        r104.f382532f = r106 * 1.25f;
        r104.f382531e = (float) r103.getDouble(3);
        r104.f382533g = r103.getInt(4);
        int r107 = (int) r103.getLong(5);
        r104.f382527a = r107;
        if (r104.f382528b != 0.0f) goto L18;
        if (r104.f382529c != 0.0f) goto L18;
        if (r104.f382530d != 0.0f) goto L18;
        if (r104.f382531e != 0.0f) goto L18;
    L21:
        r105 = false;
    L22:
        if (r105 == false) goto L24;
        r101.add(r104);
    L24:
        r102 = r102 + 1;
    L18:
        if (Color.alpha(r107) == 0) goto L21;
        if (r104.f382530d >= 0.0f) goto L22;
    L25:
        return r101;
    L31:
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L33:
        return false;
    L8:
        if (g.class != r100.getClass()) goto L33;
        g r101 = (g) r100;
        if (this.f382527a == r101.f382527a) goto L14;
        return false;
    L14:
        if (Float.compare(r101.f382528b, this.f382528b) == 0) goto L17;
        return false;
    L17:
        if (Float.compare(r101.f382529c, this.f382529c) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(r101.f382530d, this.f382530d) == 0) goto L23;
        return false;
    L23:
        if (Float.compare(r101.f382531e, this.f382531e) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(r101.f382532f, this.f382532f) == 0) goto L29;
        return false;
    L29:
        if (this.f382533g == r101.f382533g) goto L34;
        return false;
    L34:
        return true;
    }
}
