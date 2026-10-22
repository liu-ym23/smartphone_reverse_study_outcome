package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f401817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f401818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f401819c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f401820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f401821b;

        public final void c() {
            if (this.f401821b != null) goto L6;
            this.f401821b = new a();
            return;
        }

        public final void f() {
            this.f401820a = 0;
            a r100 = this.f401821b;
            if (r100 == null) goto L6;
            r100.f();
            return;
        }

        public final String toString() {
            if (this.f401821b != null) goto L6;
            return Long.toBinaryString(this.f401820a);
        L6:
            return this.f401821b.toString() + "xx" + Long.toBinaryString(this.f401820a);
        }

        public a() {
            this.f401820a = 0;
        }

        public final void a(int r100) {
            if (r100 < 64) goto L7;
            a r101 = this.f401821b;
            if (r101 == null) goto L9;
            r101.a(r100 - 64);
            return;
        L9:
            return;
        L7:
            this.f401820a &= ~(1 << r100);
        }

        public final int b(int r100) {
            a r101 = this.f401821b;
            if (r101 != null) goto L9;
            if (r100 < 64) goto L8;
            return Long.bitCount(this.f401820a);
        L8:
            return Long.bitCount(this.f401820a & ((1 << r100) - 1));
        L9:
            if (r100 >= 64) goto L13;
            return Long.bitCount(this.f401820a & ((1 << r100) - 1));
        L13:
            return r101.b(r100 - 64) + Long.bitCount(this.f401820a);
        }

        public final boolean d(int r100) {
            if (r100 < 64) goto L7;
            c();
            return this.f401821b.d(r100 - 64);
        L7:
            if ((this.f401820a & (1 << r100)) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        public final boolean e(int r110) {
            if (r110 < 64) goto L6;
            c();
            return this.f401821b.e(r110 - 64);
        L6:
            long r100 = 1 << r110;
            long r101 = this.f401820a;
            if ((r101 & r100) == 0) goto L9;
            boolean r102 = true;
        L10:
            long r103 = r101 & (~r100);
            this.f401820a = r103;
            long r104 = r100 - 1;
            this.f401820a = (r103 & r104) | Long.rotateRight((~r104) & r103, 1);
            a r105 = this.f401821b;
            if (r105 != null) goto L13;
        L16:
            return r102;
        L13:
            if (r105.d(0) == false) goto L15;
            g(63);
        L15:
            this.f401821b.e(0);
            goto L16
        L9:
            r102 = false;
            goto L10
        }

        public final void g(int r100) {
            if (r100 < 64) goto L5;
            c();
            this.f401821b.g(r100 - 64);
            return;
        L5:
            this.f401820a |= 1 << r100;
        }

        public void insert(int r110, boolean r111) {
            if (r110 < 64) goto L5;
            c();
            this.f401821b.insert(r110 - 64, r111);
            return;
        L5:
            long r100 = this.f401820a;
            if ((Long.MIN_VALUE & r100) == 0) goto L8;
            boolean r101 = true;
        L9:
            long r102 = (1 << r110) - 1;
            long r103 = r100 & r102;
            this.f401820a = ((r100 & (~r102)) << 1) | r103;
            if (r111 == false) goto L12;
            g(r110);
        L13:
            if (r101 == false) goto L15;
        L16:
            c();
            this.f401821b.insert(0, r101);
            return;
        L15:
            if (this.f401821b != null) goto L16;
            return;
        L12:
            a(r110);
            goto L13
        L8:
            r101 = false;
            goto L9
        }
    }

    public interface b {
    }

    public final int e() {
        return ((d0) this.f401817a).a() - ((ArrayList) this.f401819c).size();
    }

    public final int h() {
        return ((d0) this.f401817a).a();
    }

    public final String toString() {
        return this.f401818b.toString() + ", hidden list:" + ((ArrayList) this.f401819c).size();
    }

    public g(d0 r100) {
        this.f401817a = r100;
        this.f401818b = new a();
        this.f401819c = new ArrayList();
    }

    public final void c(int r100) {
        int r101 = f(r100);
        this.f401818b.e(r101);
        d0 r102 = (d0) this.f401817a;
        View r103 = r102.f401799a.getChildAt(r101);
        if (r103 == null) goto L18;
        RecyclerView.y r104 = RecyclerView.E(r103);
        if (r104 != null) goto L7;
    L19:
        RecyclerView.c(r102.f401799a, r101);
        return;
    L7:
        if (r104.k() == false) goto L14;
        if (r104.o() == true) goto L14;
        throw new IllegalArgumentException("called detach on an already detached child " + r104 + r102.f401799a.t());
    L14:
        if (RecyclerView.f401597p2 == false) goto L16;
        r104.toString();
    L16:
        r104.b(256);
        goto L19
    L18:
        if (RecyclerView.f401596h2 == false) goto L19;
        throw new IllegalArgumentException("No view at offset " + r101 + r102.f401799a.t());
    }

    public final View d(int r100) {
        int r101 = f(r100);
        return ((d0) this.f401817a).f401799a.getChildAt(r101);
    }

    public final int f(int r100) {
        if (r100 >= 0) goto L5;
        return -1;
    L5:
        int r101 = ((d0) this.f401817a).a();
        int r102 = r100;
    L6:
        if (r102 >= r101) goto L14;
        int r103 = r100 - (r102 - this.f401818b.b(r102));
        if (r103 == 0) goto L10;
        r102 = r102 + r103;
    L10:
        if (this.f401818b.d(r102) == false) goto L12;
        r102 = r102 + 1;
        goto L10
    L12:
        return r102;
    L14:
        return -1;
    }

    public final View g(int r100) {
        return ((d0) this.f401817a).f401799a.getChildAt(r100);
    }

    public final void i(View r100) {
        ((ArrayList) this.f401819c).add(r100);
        d0 r101 = (d0) this.f401817a;
        r101.getClass();
        RecyclerView.y r102 = RecyclerView.E(r100);
        if (r102 == null) goto L13;
        RecyclerView r103 = r101.f401799a;
        int r104 = r102.f401744q;
        if (r104 == (-1)) goto L7;
        r102.f401743p = r104;
    L9:
        if (r103.G() == false) goto L11;
        r102.f401744q = 4;
        ((ArrayList) r103.L1).add(r102);
        return;
    L11:
        ViewCompat.setImportantForAccessibility(r102.f401728a, 4);
        return;
    L7:
        r102.f401743p = ViewCompat.getImportantForAccessibility(r102.f401728a);
        goto L9
    }

    public final int j(View r100) {
        int r101 = ((d0) this.f401817a).f401799a.indexOfChild(r100);
        if (r101 != (-1)) goto L6;
        return -1;
    L6:
        if (this.f401818b.d(r101) == false) goto L9;
        return -1;
    L9:
        return r101 - this.f401818b.b(r101);
    }

    public final boolean k(View r100) {
        return ((ArrayList) this.f401819c).contains(r100);
    }

    public final void l(View r100) {
        if (((ArrayList) this.f401819c).remove(r100) == false) goto L12;
        d0 r101 = (d0) this.f401817a;
        r101.getClass();
        RecyclerView.y r102 = RecyclerView.E(r100);
        if (r102 == null) goto L13;
        RecyclerView r103 = r101.f401799a;
        int r104 = r102.f401743p;
        if (r103.G() == false) goto L9;
        r102.f401744q = r104;
        ((ArrayList) r103.L1).add(r102);
    L10:
        r102.f401743p = 0;
        return;
    L9:
        ViewCompat.setImportantForAccessibility(r102.f401728a, r104);
        goto L10
    L13:
        return;
    }

    public final void a(View r100, int r101, boolean r102) {
        if (r101 >= 0) goto L4;
        int r103 = ((d0) this.f401817a).a();
    L5:
        this.f401818b.insert(r103, r102);
        if (r102 == false) goto L8;
        i(r100);
    L8:
        d0 r104 = (d0) this.f401817a;
        r104.f401799a.addView(r100, r103);
        r104.f401799a.getClass();
        RecyclerView.E(r100);
        return;
    L4:
        r103 = f(r101);
        goto L5
    }

    public final void b(View r100, int r101, ViewGroup.LayoutParams r102, boolean r103) {
        if (r101 >= 0) goto L4;
        int r104 = ((d0) this.f401817a).a();
    L5:
        this.f401818b.insert(r104, r103);
        if (r103 == false) goto L8;
        i(r100);
    L8:
        d0 r105 = (d0) this.f401817a;
        r105.getClass();
        RecyclerView.y r106 = RecyclerView.E(r100);
        if (r106 == null) goto L22;
        if (r106.k() == true) goto L18;
        if (r106.o() == true) goto L18;
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + r106 + r105.f401799a.t());
    L18:
        if (RecyclerView.f401597p2 == false) goto L20;
        r106.toString();
    L20:
        r106.f401737j &= -257;
    L23:
        RecyclerView.b(r105.f401799a, r100, r104, r102);
        return;
    L22:
        if (RecyclerView.f401596h2 == false) goto L23;
        throw new IllegalArgumentException("No ViewHolder found for child: " + r100 + ", index: " + r104 + r105.f401799a.t());
    L4:
        r104 = f(r101);
        goto L5
    }
}
