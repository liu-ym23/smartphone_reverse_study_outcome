package org.jsoup.nodes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.jsoup.SerializationException;
import org.jsoup.helper.ValidationException;

/* JADX INFO: loaded from: classes42.dex */
public final class b implements Iterable<org.jsoup.nodes.a>, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f525924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f525925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f525926c;

    public class a implements Iterator<org.jsoup.nodes.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f525927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f525928b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
        L2:
            int r100 = this.f525927a;
            b r101 = this.f525928b;
            if (r100 >= r101.f525924a) goto L8;
            if (b.j(r101.f525925b[r100]) == false) goto L8;
            this.f525927a++;
        L8:
            if (this.f525927a < this.f525928b.f525924a) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // java.util.Iterator
        public final org.jsoup.nodes.a next() {
            b r100 = this.f525928b;
            String[] r101 = r100.f525925b;
            int r102 = this.f525927a;
            org.jsoup.nodes.a r103 = new org.jsoup.nodes.a(r101[r102], (String) r100.f525926c[r102], r100);
            this.f525927a++;
            return r103;
        }

        @Override // java.util.Iterator
        public final void remove() {
            b r100 = this.f525928b;
            int r101 = this.f525927a - 1;
            this.f525927a = r101;
            r100.m(r101);
        }

        public a(b r100) {
            this.f525928b = r100;
            this.f525927a = 0;
        }
    }

    public final int hashCode() {
        return (((this.f525924a * 31) + Arrays.hashCode(this.f525925b)) * 31) + Arrays.hashCode(this.f525926c);
    }

    @Override // java.lang.Iterable
    public final Iterator<org.jsoup.nodes.a> iterator() {
        return new a(this);
    }

    public b() {
        this.f525924a = 0;
        this.f525925b = new String[3];
        this.f525926c = new Object[3];
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return d();
    }

    public final b d() {
        b r100 = (b) super.clone();     // Catch: CloneNotSupportedException -> L5
        r100.f525924a = this.f525924a;
        r100.f525925b = (String[]) Arrays.copyOf(this.f525925b, this.f525924a);
        r100.f525926c = Arrays.copyOf(this.f525926c, this.f525924a);
        return r100;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final String toString() {
        StringBuilder r100 = fwc.b.b();
        g(r100, new Document("").f525890k);     // Catch: IOException -> L6
        return fwc.b.g(r100);
    L6:
        e = move-exception;
        throw new SerializationException(e);
    }

    public static boolean j(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() > 1) goto L7;
        return false;
    L7:
        if (r100.charAt(0) != '/') goto L12;
        return true;
    L12:
        return false;
    }

    public final void c(int r100) {
        if (r100 < this.f525924a) goto L5;
        boolean r101 = true;
    L6:
        ewc.b.a(r101);
        String[] r102 = this.f525925b;
        int r103 = r102.length;
        if (r103 < r100) goto L9;
        return;
    L9:
        int r104 = 3;
        if (r103 < 3) goto L12;
        r104 = this.f525924a * 2;
    L12:
        if (r100 > r104) goto L15;
        r100 = r104;
    L15:
        this.f525925b = (String[]) Arrays.copyOf(r102, r100);
        this.f525926c = Arrays.copyOf(this.f525926c, r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final String e(String r100) {
        int r101 = h(r100);
        if (r101 == (-1)) goto L10;
        Object r102 = this.f525926c[r101];
        if (r102 != null) goto L9;
        return "";
    L9:
        return (String) r102;
    L10:
        return "";
    }

    public final boolean equals(@Nullable Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L28:
        return false;
    L8:
        if (b.class != r100.getClass()) goto L28;
        b r101 = (b) r100;
        if (this.f525924a == r101.f525924a) goto L13;
        return false;
    L13:
        int r102 = 0;
    L15:
        if (r102 >= this.f525924a) goto L27;
        int r103 = r101.h(this.f525925b[r102]);
        if (r103 == (-1)) goto L18;
        Object r104 = this.f525926c[r102];
        Object r105 = r101.f525926c[r103];
        if (r104 != null) goto L24;
        if (r105 == null) goto L26;
        return false;
    L26:
        r102 = r102 + 1;
        goto L15
    L24:
        if (r104.equals(r105) == true) goto L26;
        return false;
    L18:
        return false;
    L27:
        return true;
    }

    public final String f(String r100) {
        int r101 = i(r100);
        if (r101 == (-1)) goto L10;
        Object r102 = this.f525926c[r101];
        if (r102 != null) goto L9;
        return "";
    L9:
        return (String) r102;
    L10:
        return "";
    }

    public final int h(String r100) {
        ewc.b.d(r100);
        int r101 = 0;
    L4:
        if (r101 >= this.f525924a) goto L9;
        if (r100.equals(this.f525925b[r101]) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L9:
        return -1;
    }

    public final int i(String r100) {
        ewc.b.d(r100);
        int r101 = 0;
    L4:
        if (r101 >= this.f525924a) goto L9;
        if (r100.equalsIgnoreCase(this.f525925b[r101]) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L9:
        return -1;
    }

    public final void l(org.jsoup.nodes.a r100) {
        String r101 = r100.f525921a;
        String r102 = r100.f525922b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        k(r101, r102);
        r100.f525923c = this;
    }

    public final void m(int r100) {
        int r101 = this.f525924a;
        if (r100 < r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L13;
        int r103 = (r101 - r100) - 1;
        if (r103 <= 0) goto L10;
        String[] r104 = this.f525925b;
        int r105 = r100 + 1;
        System.arraycopy(r104, r105, r104, r100, r103);
        Object[] r106 = this.f525926c;
        System.arraycopy(r106, r105, r106, r100, r103);
    L10:
        int r107 = this.f525924a - 1;
        this.f525924a = r107;
        this.f525925b[r107] = null;
        this.f525926c[r107] = null;
        return;
    L13:
        throw new ValidationException("Must be false");
    L5:
        r102 = false;
        goto L6
    }

    public final void a(String r100, @Nullable Object r101) {
        c(this.f525924a + 1);
        String[] r102 = this.f525925b;
        int r103 = this.f525924a;
        r102[r103] = r100;
        this.f525926c[r103] = r101;
        this.f525924a = r103 + 1;
    }

    public final void g(Appendable r100, Document.OutputSettings r101) throws IOException {
        int r102 = this.f525924a;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (j(this.f525925b[r103]) == true) goto L10;
        String r104 = org.jsoup.nodes.a.a(this.f525925b[r103], r101.f525900h);
        if (r104 == null) goto L10;
        org.jsoup.nodes.a.b(r104, (String) this.f525926c[r103], r100.append(' '), r101);
    L10:
        r103 = r103 + 1;
        goto L3
    }

    public final void k(String r100, @Nullable String r101) {
        ewc.b.d(r100);
        int r102 = h(r100);
        if (r102 == (-1)) goto L5;
        this.f525926c[r102] = r101;
        return;
    L5:
        a(r100, r101);
    }
}
