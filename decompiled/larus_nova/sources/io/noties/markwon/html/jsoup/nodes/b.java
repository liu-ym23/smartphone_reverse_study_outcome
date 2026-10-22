package io.noties.markwon.html.jsoup.nodes;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Iterable<io.noties.markwon.html.jsoup.nodes.a>, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f492574d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f492575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f492576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f492577c;

    public class a implements Iterator<io.noties.markwon.html.jsoup.nodes.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f492578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f492579b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f492578a >= this.f492579b.f492575a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final io.noties.markwon.html.jsoup.nodes.a next() {
            b r100 = this.f492579b;
            String[] r101 = r100.f492577c;
            int r102 = this.f492578a;
            String r103 = r101[r102];
            String r104 = r100.f492576b[r102];
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            io.noties.markwon.html.jsoup.nodes.a r105 = new io.noties.markwon.html.jsoup.nodes.a(r104, r103, r100);
            this.f492578a++;
            return r105;
        }

        @Override // java.util.Iterator
        public final void remove() {
            b r100 = this.f492579b;
            int r101 = this.f492578a - 1;
            this.f492578a = r101;
            int r102 = r100.f492575a;
            if (r101 < r102) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == true) goto L13;
            int r104 = (r102 - r101) - 1;
            if (r104 <= 0) goto L10;
            String[] r105 = r100.f492576b;
            int r106 = r101 + 1;
            System.arraycopy(r105, r106, r105, r101, r104);
            String[] r107 = r100.f492577c;
            System.arraycopy(r107, r106, r107, r101, r104);
        L10:
            int r108 = r100.f492575a - 1;
            r100.f492575a = r108;
            r100.f492576b[r108] = null;
            r100.f492577c[r108] = null;
            return;
        L13:
            throw new IllegalArgumentException("Must be false");
        L5:
            r103 = false;
            goto L6
        }

        public a(b r100) {
            this.f492579b = r100;
            this.f492578a = 0;
        }
    }

    static {
        f492574d = new String[0];
    }

    public final int hashCode() {
        return (((this.f492575a * 31) + Arrays.hashCode(this.f492576b)) * 31) + Arrays.hashCode(this.f492577c);
    }

    @Override // java.lang.Iterable
    public final Iterator<io.noties.markwon.html.jsoup.nodes.a> iterator() {
        return new a(this);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= this.f492575a) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L13;
        String r103 = this.f492577c[r101];
        String r104 = this.f492576b[r101];
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        io.noties.markwon.html.jsoup.nodes.a r105 = new io.noties.markwon.html.jsoup.nodes.a(r104, r103, this);
        r101 = r101 + 1;
        r100.append(r105.f492571a);
        r100.append("=\"");
        r100.append(r105.f492572b);
        r100.append("\" ");
        goto L4
    L13:
        return r100.toString();
    L6:
        r102 = false;
        goto L7
    }

    public b() {
        this.f492575a = 0;
        String[] r100 = f492574d;
        this.f492576b = r100;
        this.f492577c = r100;
    }

    public final Object clone() throws CloneNotSupportedException {
        b r100 = (b) super.clone();     // Catch: CloneNotSupportedException -> L5
        r100.f492575a = this.f492575a;
        String[] r101 = this.f492576b;
        int r102 = this.f492575a;
        String[] r103 = new String[r102];
        System.arraycopy(r101, 0, r103, 0, Math.min(r101.length, r102));
        this.f492576b = r103;
        String[] r104 = this.f492577c;
        int r105 = this.f492575a;
        String[] r106 = new String[r105];
        System.arraycopy(r104, 0, r106, 0, Math.min(r104.length, r105));
        this.f492577c = r106;
        return r100;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final int a(String r100) {
        if (r100 == null) goto L13;
        int r101 = 0;
    L5:
        if (r101 >= this.f492575a) goto L10;
        if (r100.equals(this.f492576b[r101]) == true) goto L8;
        r101 = r101 + 1;
        goto L5
    L8:
        return r101;
    L10:
        return -1;
    L13:
        throw new IllegalArgumentException("Object must not be null");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (b.class != r100.getClass()) goto L18;
        b r101 = (b) r100;
        if (this.f492575a == r101.f492575a) goto L14;
        return false;
    L14:
        if (Arrays.equals(this.f492576b, r101.f492576b) == true) goto L17;
        return false;
    L17:
        return Arrays.equals(this.f492577c, r101.f492577c);
    }
}
