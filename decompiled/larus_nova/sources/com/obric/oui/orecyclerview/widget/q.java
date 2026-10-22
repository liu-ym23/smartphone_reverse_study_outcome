package com.obric.oui.orecyclerview.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f401887a = null;

    public class a implements Comparator<c> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(c r100, c r101) {
            return r100.f401888a - r101.f401888a;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(int r100, int r101);

        public abstract boolean b(int r100, int r101);

        public abstract void c(int r100, int r101);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f401888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f401889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f401890c;

        public c(int r100, int r101, int r102) {
            this.f401888a = r100;
            this.f401889b = r101;
            this.f401890c = r102;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f401891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f401892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f401893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f401894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f401895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f401896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f401897g;

        public static f a(Collection<f> r100, int r101, boolean r102) {
            Iterator r103 = ((ArrayDeque) r100).iterator();
        L4:
            if (r103.hasNext() == false) goto L10;
            f r104 = (f) r103.next();
            if (r104.f401898a != r101) goto L4;
            if (r104.f401900c != r102) goto L4;
            r103.remove();
        L12:
            if (r103.hasNext() == false) goto L17;
            f r105 = (f) r103.next();
            if (r102 == true) goto L15;
            r105.f401899b++;
            goto L12
        L15:
            r105.f401899b--;
            goto L12
        L17:
            return r104;
        L10:
            r104 = null;
            goto L12
        }

        public d(com.obric.oui.orecyclerview.widget.d.a r100, List r101, int[] r102, int[] r110) {
            this.f401891a = r101;
            this.f401892b = r102;
            this.f401893c = r110;
            Arrays.fill(r102, 0);
            Arrays.fill(r110, 0);
            this.f401894d = r100;
            int r103 = r100.f401796a.f401791a.size();
            this.f401895e = r103;
            int r104 = r100.f401796a.f401792b.size();
            this.f401896f = r104;
            this.f401897g = true;
            ArrayList r105 = (ArrayList) r101;
            if (r105.isEmpty() == false) goto L5;
            c r106 = null;
        L6:
            if (r106 != null) goto L8;
        L11:
            ListProtector.add(r101, 0, new c(0, 0, 0));
        L12:
            r105.add(new c(r103, r104, 0));
            Iterator r107 = r105.iterator();
        L14:
            if (r107.hasNext() == false) goto L24;
            c r108 = (c) r107.next();
            int r109 = 0;
        L17:
            if (r109 >= r108.f401890c) goto L14;
            int r111 = r108.f401888a + r109;
            int r112 = r108.f401889b + r109;
            if (this.f401894d.a(r111, r112) == false) goto L21;
            int r113 = 1;
        L22:
            this.f401892b[r111] = (r112 << 4) | r113;
            this.f401893c[r112] = (r111 << 4) | r113;
            r109 = r109 + 1;
            goto L17
        L21:
            r113 = 2;
            goto L22
        L24:
            if (this.f401897g == false) goto L51;
            Iterator<c> r114 = this.f401891a.iterator();
            int r115 = 0;
        L27:
            if (r114.hasNext() == false) goto L65;
            c r116 = r114.next();
        L29:
            int r117 = r116.f401888a;
            if (r115 >= r117) goto L50;
            if (this.f401892b[r115] != 0) goto L49;
            int r118 = this.f401891a.size();
            int r119 = 0;
            int r120 = 0;
        L34:
            if (r119 >= r118) goto L49;
            c r121 = (c) ListProtector.get(this.f401891a, r119);
        L36:
            int r122 = r121.f401889b;
            if (r120 >= r122) goto L48;
            if (this.f401893c[r120] != 0) goto L47;
            if (this.f401894d.b(r115, r120) == false) goto L47;
            if (this.f401894d.a(r115, r120) == false) goto L45;
            int r123 = 8;
        L46:
            this.f401892b[r115] = (r120 << 4) | r123;
            this.f401893c[r120] = r123 | (r115 << 4);
            goto L49
        L45:
            r123 = 4;
        L47:
            r120 = r120 + 1;
            goto L36
        L48:
            r120 = r121.f401890c + r122;
            r119 = r119 + 1;
        L49:
            r115 = r115 + 1;
            goto L29
        L50:
            r115 = r116.f401890c + r117;
            goto L27
        L65:
            return;
        L51:
            return;
        L8:
            if (r106.f401888a != 0) goto L11;
            if (r106.f401889b == 0) goto L12;
        L5:
            r106 = (c) ListProtector.get(r101, 0);
            goto L6
        }
    }

    public static abstract class e<T> {
        public e() {
        }

        public abstract boolean a(T r100, T r101);

        public abstract boolean b(T r100, T r101);
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f401898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f401900c;

        public f(int r100, int r101, boolean r102) {
            this.f401898a = r100;
            this.f401899b = r101;
            this.f401900c = r102;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401904d;

        public g() {
        }

        public g(int r100, int r101) {
            this.f401901a = 0;
            this.f401902b = r100;
            this.f401903c = 0;
            this.f401904d = r101;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f401909e;

        public h() {
        }

        public final int a() {
            return Math.min(this.f401907c - this.f401905a, this.f401908d - this.f401906b);
        }
    }

    static {
        f401887a = new a();
    }
}
