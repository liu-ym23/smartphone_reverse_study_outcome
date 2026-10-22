package com.lynx.tasm.behavior.ui.utils;

import android.renderscript.Matrix4f;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f383162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f383163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f383164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f383165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f383166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f383167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f383168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f383169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f383170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f383171j;

    public static boolean a(List<n> r100) {
        if (r100 != null) goto L5;
    L30:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L30;
        Iterator<n> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L30;
        n r102 = r101.next();
        if (r102.f383165d != 1) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
    L27:
        boolean r104 = true;
    L28:
        if (r104 == false) goto L9;
        return true;
    L16:
        if (r102.f383168g != 1) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L27;
        if (r102.f383170i != 1) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == true) goto L27;
        r104 = false;
        goto L28
    L23:
        r106 = false;
        goto L24
    L18:
        r105 = false;
        goto L19
    L13:
        r103 = false;
        goto L14
    }

    public static float b(List<n> r100) {
        float r101 = 0.0f;
        if (r100 != null) goto L5;
    L18:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L18;
        Iterator<n> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        n r103 = r102.next();
        int r104 = r103.f383162a;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L17;
        if (r104 != 16) goto L9;
    L17:
        r101 = r103.f383164c.a();
        goto L9
    }

    public static float c(List<n> r100) {
        float r101 = 0.0f;
        if (r100 != null) goto L5;
    L19:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L19;
        Iterator<n> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        n r103 = r102.next();
        int r104 = r103.f383162a;
        if (r104 == 1) goto L18;
        if (r104 != 4) goto L15;
        r101 = r103.f383164c.a();
        goto L9
    L15:
        if (r104 != 16) goto L9;
    L18:
        r101 = r103.f383167f.a();
        goto L9
    }

    public static List<n> d(ReadableArray r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (r110.size() <= 0) goto L41;
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L8:
        if (r101 >= r110.size()) goto L32;
        ReadableArray r102 = r110.getArray(r101);
        if (r102.size() >= 7) goto L12;
        LLog.DTHROW(new IllegalArgumentException("transform params is error."));
    L31:
        r101 = r101 + 1;
        goto L8
    L12:
        int r103 = r102.getInt(0);
        if (r103 != 32768) goto L15;
    L27:
        float[] r104 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f};
        int r105 = 0;
    L28:
        if (r105 >= 16) goto L30;
        int r106 = r105 + 1;
        r104[r105] = (float) r102.getDouble(r106);
        r105 = r106;
        goto L28
    L30:
        r100.add(new n(r103, r104));
        goto L31
    L15:
        if (r103 == 65536) goto L27;
        int r107 = r102.getInt(2);
        int r111 = r102.getInt(4);
        int r112 = r102.getInt(6);
        if (r103 == 1) goto L26;
        if (r103 == 2) goto L26;
        if (r103 == 4) goto L26;
        if (r103 == 8) goto L26;
        if (r103 == 16) goto L26;
        float r108 = (float) r102.getDouble(1);
        float r109 = (float) r102.getDouble(3);
        r102.getDouble(5);
        r100.add(new n(r103, r108, r107, r109, r111, r112));
    L26:
        r100.add(new n(r103, new j(r102.getDynamic(1), r107), r107, new j(r102.getDynamic(3), r111), r111, new j(r102.getDynamic(5), r112), r112));
        goto L31
    L32:
        return r100;
    L41:
        return null;
    }

    public n(int r100, float[] r101) {
        this.f383162a = r100;
        this.f383164c = new j();
        this.f383163b = 0.0f;
        this.f383165d = 0;
        this.f383167f = new j();
        this.f383166e = 0.0f;
        this.f383168g = 0;
        this.f383169h = new j();
        this.f383170i = 0;
        this.f383171j = r101;
    }

    public n(int r100, float r101, int r102, float r103, int r104, int r105) {
        this.f383162a = r100;
        this.f383164c = new j();
        this.f383163b = r101;
        this.f383165d = r102;
        this.f383167f = new j();
        this.f383166e = r103;
        this.f383168g = r104;
        this.f383169h = new j();
        this.f383170i = r105;
        this.f383171j = new Matrix4f().getArray();
    }

    public n(int r100, j r101, int r102, j r103, int r104, j r105, int r106) {
        this.f383162a = r100;
        this.f383164c = r101;
        this.f383163b = 0.0f;
        this.f383165d = r102;
        this.f383167f = r103;
        this.f383166e = 0.0f;
        this.f383168g = r104;
        this.f383169h = r105;
        this.f383170i = r106;
        this.f383171j = new Matrix4f().getArray();
    }
}
