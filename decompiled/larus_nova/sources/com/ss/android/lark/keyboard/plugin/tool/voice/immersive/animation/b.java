package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f430251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, Integer> f430252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f430253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f430254e;

    public final void d() {
        v(0);
        n(0);
        y(0);
        b(0);
    }

    public final void f() {
        this.f430252c.put(10, -1);
        this.f430252c.remove(11);
        this.f430252c.remove(15);
    }

    public final void g() {
        this.f430252c.put(2, -1);
        this.f430252c.remove(3);
        this.f430252c.remove(17);
    }

    public final void h() {
        this.f430252c.put(4, -1);
        this.f430252c.remove(5);
        this.f430252c.remove(12);
    }

    public final void i() {
        this.f430252c.put(6, -1);
        this.f430252c.remove(7);
        this.f430252c.remove(13);
    }

    public final void j() {
        this.f430252c.put(0, -1);
        this.f430252c.remove(1);
        this.f430252c.remove(16);
    }

    public final void k() {
        this.f430252c.put(8, -1);
        this.f430252c.remove(9);
        this.f430252c.remove(14);
    }

    public final String toString() {
        Iterator<Map.Entry<Integer, Integer>> r100 = this.f430252c.entrySet().iterator();
        StringBuilder r101 = new StringBuilder("view:" + this.f430251b + '(' + this.f430250a + ")->");
    L4:
        if (r100.hasNext() == false) goto L33;
        Map.Entry<Integer, Integer> r102 = r100.next();
        int r103 = r102.getKey().intValue();
        if (r103 != 30) goto L8;
        String r104 = "CONSTRAINT_WIDTH:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
    L31:
        r101.append(r104);
        goto L4
    L8:
        if (r103 == 31) goto L29;
        switch(r103) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            default: goto L10;
        };
    L10:
        r104 = "unknown";
        goto L31
    L11:
        r104 = "END_MARGIN:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L12:
        r104 = "START_MARGIN:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L13:
        r104 = "BOTTOM_MARGIN:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L14:
        r104 = "TOP_MARGIN:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L15:
        r104 = "RIGHT_MARGIN:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L16:
        r104 = "LEFT_MARGIN:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L17:
        r104 = "BOTTOM_TO_TOP:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L18:
        r104 = "BOTTOM_TO_BOTTOM:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L19:
        r104 = "TOP_TO_BOTTOM:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L20:
        r104 = "TOP_TO_TOP:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L21:
        r104 = "RIGHT_TO_LEFT:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L22:
        r104 = "RIGHT_TO_RIGHT:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L23:
        r104 = "LEFT_TO_RIGHT:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L24:
        r104 = "LEFT_TO_LEFT:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L25:
        r104 = "END_TO_START:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L26:
        r104 = "END_TO_END:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L27:
        r104 = "START_TO_END:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L28:
        r104 = "START_TO_START :" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L29:
        r104 = "CONSTRAINT_HEIGHT:" + r102.getValue().intValue() + tb2.c.DEFAULT_TEXT;
        goto L31
    L33:
        return r101.toString();
    }

    public final void e() {
        j();
        g();
        h();
        i();
        k();
        f();
    }

    public /* synthetic */ b(int r100) {
        this(r100, "");
    }

    public final void a(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(15, r101);
    }

    public final void b(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(10, r101);
    }

    public final void c(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(11, r101);
    }

    public final void l(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(31, r101);
    }

    public final void m(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(30, r101);
    }

    public final void n(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(2, r101);
    }

    public final void o(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(3, r101);
    }

    public final void p(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(4, r101);
    }

    public final void q(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(6, r101);
    }

    public final void r(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 4;
    L5:
        this.f430253d = r101;
        return;
    L4:
        r101 = 0;
        goto L5
    }

    public final void s(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        this.f430253d = r101;
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public final void t(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(16, r101);
    }

    public final void u(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(1, r101);
    }

    public final void v(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(0, r101);
    }

    public final void w(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(14, r101);
    }

    public final void x(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(9, r101);
    }

    public final void y(int r100) {
        Integer r101 = Integer.valueOf(r100);
        this.f430252c.put(8, r101);
    }

    public b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "debugInfo");
        this.f430250a = r100;
        this.f430251b = r101;
        this.f430252c = new HashMap();
    }
}
