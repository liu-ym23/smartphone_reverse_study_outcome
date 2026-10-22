package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.background.BackgroundRepeat;
import com.lynx.tasm.behavior.ui.utils.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public abstract class f<T extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f383141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f383142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable.Callback f383143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f383144d;

    public abstract T a();

    public final T b() {
        if (this.f383142b != null) goto L6;
        T r100 = (T) a();
        this.f383142b = r100;
        r100.setCallback(this.f383143c);
    L6:
        return this.f383142b;
    }

    public final void c() {
        T r100 = this.f383142b;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator r101 = ((ArrayList) r100.f383137e.f2094a).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((a7a.d) r101.next()).d();
        goto L7
    }

    public final void d() {
        T r100 = this.f383142b;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator r101 = ((ArrayList) r100.f383137e.f2094a).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((a7a.d) r101.next()).e();
        goto L7
    }

    public final void e() {
        T r100 = this.f383142b;
        if (r100 == null) goto L8;
        Iterator r101 = ((ArrayList) r100.f383137e.f2094a).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((a7a.d) r101.next()).f();
        goto L6
    L10:
        return;
    }

    public f(LynxContext r100) {
        this.f383143c = null;
        this.f383141a = r100;
    }

    public final void f(Bitmap.Config r100) {
        T r101 = b().f383137e;
        if (r101 == 0) goto L14;
        r101.f2102i = r100;
        List<a7a.d> r102 = r101.f2094a;
        if (r102 == null) goto L20;
        Iterator r103 = ((ArrayList) r102).iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        a7a.d r104 = (a7a.d) r103.next();
        if (r104 == null) goto L10;
        r104.h(r101.f2102i);
        goto L10
    L21:
        return;
    L20:
        return;
    }

    public final void g(ReadableArray r100) {
        T r101 = b().f383137e;
        ((ArrayList) r101.f2097d).clear();
        if (r100 == null) goto L15;
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L19;
        int r104 = r100.getInt(r103);
        if (r104 >= 0) goto L10;
    L13:
        ((ArrayList) r101.f2097d).add(1);
    L14:
        r103 = r103 + 1;
        goto L6
    L10:
        if (r104 > 4) goto L13;
        List<Integer> r105 = r101.f2097d;
        ArrayList r106 = (ArrayList) r105;
        r106.add(Integer.valueOf(r104));
        goto L14
    L19:
        return;
    }

    public final void h(ReadableArray r100) {
        T r101 = b().f383137e;
        ((ArrayList) r101.f2096c).clear();
        if (r100 == null) goto L13;
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L17;
        int r104 = r100.getInt(r103);
        if (r104 >= 0) goto L10;
    L11:
        r104 = 1;
    L12:
        List<Integer> r105 = r101.f2096c;
        ArrayList r106 = (ArrayList) r105;
        r106.add(Integer.valueOf(r104));
        r103 = r103 + 1;
        goto L6
    L10:
        if (r104 <= 2) goto L12;
    L17:
        return;
    }

    public final void i(ReadableArray r100) {
        T r101 = b().f383137e;
        ((ArrayList) r101.f2095b).clear();
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100.size() % 2) != 0) goto L13;
        int r102 = 0;
    L9:
        if (r102 >= r100.size()) goto L14;
        int r103 = r100.getInt(r102 + 1);
        List<a7a.h> r104 = r101.f2095b;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new a7a.h(r100.getDynamic(r102), r103));
        r102 = r102 + 2;
        goto L9
    L14:
        return;
    }

    public final void j(ReadableArray r100) {
        T r101 = b().f383137e;
        ((ArrayList) r101.f2098e).clear();
        if (r100 == null) goto L8;
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L10;
        List<BackgroundRepeat> r104 = r101.f2098e;
        ArrayList r105 = (ArrayList) r104;
        r105.add(BackgroundRepeat.valueOf(r100.getInt(r103)));
        r103 = r103 + 1;
        goto L6
    L10:
        return;
    }

    public final void k(ReadableArray r100) {
        T r101 = b().f383137e;
        ((ArrayList) r101.f2099f).clear();
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100.size() % 2) != 0) goto L12;
        int r102 = r100.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        List<a7a.j> r104 = r101.f2099f;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new a7a.j(r100.getDynamic(r103), r100.getInt(r103 + 1)));
        r103 = r103 + 2;
        goto L8
    L13:
        return;
    }
}
