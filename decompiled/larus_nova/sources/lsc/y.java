package lsc;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class y implements Appendable, CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f510625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<a> f510626b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f510627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f510628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f510629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f510630d;

        public a(Object r100, int r101, int r102, int r103) {
            this.f510627a = r100;
            this.f510628b = r101;
            this.f510629c = r102;
            this.f510630d = r103;
        }
    }

    public static class b extends SpannableStringBuilder {
        public b(CharSequence r100) {
            super(r100);
        }
    }

    public final b h() {
        b r100 = new b(this.f510625a);
        Iterator r101 = ((ArrayDeque) this.f510626b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = (a) r101.next();
        r100.setSpan(r102.f510627a, r102.f510628b, r102.f510629c, r102.f510630d);
        goto L4
    L6:
        return r100;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f510625a.length();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f510625a.toString();
    }

    public y(CharSequence r100) {
        this.f510626b = new ArrayDeque(8);
        this.f510625a = new StringBuilder(r100);
        d(0, r100);
    }

    public final void a(char r100) {
        this.f510625a.append(r100);
    }

    @Override // java.lang.Appendable
    public final Appendable append(char r100) throws IOException {
        this.f510625a.append(r100);
        return this;
    }

    public final void b(CharSequence r100) {
        d(length(), r100);
        this.f510625a.append(r100);
    }

    public final void c(String r100) {
        this.f510625a.append(r100);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r100) {
        return this.f510625a.charAt(r100);
    }

    public final b e(int r100) {
        int r101 = length();
        b r102 = new b(this.f510625a.subSequence(r100, r101));
        Iterator r103 = ((ArrayDeque) this.f510626b).iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        a r104 = (a) r103.next();
        if (r104 == null) goto L12;
        int r105 = r104.f510628b;
        if (r105 < r100) goto L4;
        int r106 = r104.f510629c;
        if (r106 > r101) goto L4;
        r102.setSpan(r104.f510627a, r105 - r100, r106 - r100, 33);
        r103.remove();
    L12:
        this.f510625a.replace(r100, r101, "");
        return r102;
    }

    @Override // java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
        b(r100);
        return this;
    }

    public final void d(int r100, CharSequence r101) {
        if ((r101 instanceof Spanned) == false) goto L15;
        Spanned r102 = (Spanned) r101;
        boolean r103 = r102 instanceof b;
        int r104 = 0;
        Object[] r105 = r102.getSpans(0, r102.length(), Object.class);
        if (r105 == null) goto L7;
        int r106 = r105.length;
    L8:
        if (r106 <= 0) goto L18;
        if (r103 == false) goto L13;
    L10:
        r106 = r106 - 1;
        if (r106 < 0) goto L19;
        Object r107 = r105[r106];
        setSpan(r107, r102.getSpanStart(r107) + r100, r102.getSpanEnd(r107) + r100, r102.getSpanFlags(r107));
        goto L10
    L19:
        return;
    L13:
        if (r104 >= r106) goto L20;
        Object r108 = r105[r104];
        setSpan(r108, r102.getSpanStart(r108) + r100, r102.getSpanEnd(r108) + r100, r102.getSpanFlags(r108));
        r104 = r104 + 1;
        goto L13
    L20:
        return;
    L18:
        return;
    L7:
        r106 = 0;
        goto L8
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r100, int r101) {
        int r102 = length();
        if (r101 <= r100) goto L7;
        if (r100 < 0) goto L7;
        if (r101 > r102) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        List r104 = Collections.emptyList();
    L27:
        if (r104.isEmpty() == true) goto L45;
        SpannableStringBuilder r105 = new SpannableStringBuilder(this.f510625a.subSequence(r100, r101));
        int r106 = r105.length();
        Iterator r107 = r104.iterator();
    L31:
        if (r107.hasNext() == false) goto L34;
        a r108 = (a) r107.next();
        int r109 = Math.max(0, r108.f510628b - r100);
        int r110 = Math.min(r106, (r108.f510629c - r108.f510628b) + r109);
        r105.setSpan(r108.f510627a, r109, r110, r108.f510630d);
        goto L31
    L34:
        return r105;
    L45:
        return this.f510625a.subSequence(r100, r101);
    L10:
        if (r100 != 0) goto L13;
        if (r102 != r101) goto L13;
        ArrayList r111 = new ArrayList(this.f510626b);
        Collections.reverse(r111);
        r104 = Collections.unmodifiableList(r111);
    L13:
        ArrayList r112 = new ArrayList(0);
        Iterator r113 = ((ArrayDeque) this.f510626b).descendingIterator();
    L15:
        if (r113.hasNext() == false) goto L25;
        a r114 = (a) r113.next();
        int r115 = r114.f510628b;
        if (r115 < r100) goto L19;
        if (r115 >= r101) goto L19;
    L24:
        r112.add(r114);
    L19:
        int r116 = r114.f510629c;
        if (r116 > r101) goto L22;
        if (r116 > r100) goto L24;
    L22:
        if (r115 >= r100) goto L15;
        if (r116 <= r101) goto L15;
    L25:
        r104 = Collections.unmodifiableList(r112);
    L7:
        r103 = false;
        goto L8
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r100, int r101, int r102) throws IOException {
        CharSequence r103 = r100.subSequence(r101, r102);
        d(length(), r103);
        this.f510625a.append(r103);
        return this;
    }

    public static void f(y r100, Object r101, int r102, int r103) {
        if (r101 == null) goto L13;
        int r104 = r100.length();
        if (r103 <= r102) goto L8;
        if (r102 < 0) goto L8;
        if (r103 > r104) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
        return;
    L11:
        g(r100, r101, r102, r103);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public static void g(y r100, Object r101, int r102, int r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getClass().isArray() == false) goto L8;
        Object[] r104 = (Object[]) r101;
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        g(r100, r104[r106], r102, r103);
        r106 = r106 + 1;
        goto L6
    L12:
        return;
    L8:
        r100.setSpan(r101, r102, r103, 33);
    }

    public final void setSpan(Object r100, int r101, int r102, int r103) {
        Deque<a> r104 = this.f510626b;
        ArrayDeque r105 = (ArrayDeque) r104;
        r105.push(new a(r100, r101, r102, r103));
    }
}
