package x7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import v7b.x;
import w7b.f;
import w7b.g;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f562873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f562874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f562875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f562876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f562877e;

    public final int m() {
        int r100 = 0;
    L3:
        char r101 = j();
        if (r101 == ' ') goto L7;
        switch(r101) {
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L6;
        };
    L6:
        return r100;
    L7:
        r100 = r100 + 1;
        g();
        goto L3
    }

    public final boolean d() {
        if (this.f562875c >= this.f562877e) goto L6;
        return true;
    L6:
        if (this.f562874b < (this.f562873a.size() - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    public final void g() {
        int r100 = this.f562875c + 1;
        this.f562875c = r100;
        if (r100 <= this.f562877e) goto L10;
        int r101 = this.f562874b + 1;
        this.f562874b = r101;
        if (r101 >= this.f562873a.size()) goto L7;
        f r102 = (f) ListProtector.get(this.f562873a, this.f562874b);
        this.f562876d = r102;
        this.f562877e = r102.f558606a.length();
    L8:
        this.f562875c = 0;
        return;
    L7:
        f r103 = new f("", null);
        this.f562876d = r103;
        this.f562877e = r103.f558606a.length();
        goto L8
    }

    public final char j() {
        int r100 = this.f562875c;
        if (r100 >= this.f562877e) goto L7;
        return this.f562876d.f558606a.charAt(r100);
    L7:
        if (this.f562874b >= (this.f562873a.size() - 1)) goto L10;
        return '\n';
    L10:
        return 0;
    }

    public final d k() {
        return new d(this.f562874b, this.f562875c);
    }

    public e(List r100) {
        this.f562876d = new f("", null);
        this.f562877e = 0;
        this.f562873a = r100;
        this.f562874b = 0;
        this.f562875c = 0;
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == true) goto L6;
        a(0, 0);
        f r102 = (f) ListProtector.get(r101, 0);
        this.f562876d = r102;
        this.f562877e = r102.f558606a.length();
        return;
    }

    public final int b(char r100) {
        int r101 = 0;
    L3:
        char r102 = j();
        if (r102 == 0) goto L5;
        if (r102 == r100) goto L8;
        r101 = r101 + 1;
        g();
        goto L3
    L8:
        return r101;
    L5:
        return -1;
    }

    public final int e(a8b.a r100) {
        int r101 = 0;
    L3:
        char r102 = j();
        if (r100.f2208a.get(r102) == false) goto L6;
        r101 = r101 + 1;
        g();
        goto L3
    L6:
        return r101;
    }

    public final int f(char r100) {
        int r101 = 0;
    L4:
        if (j() != r100) goto L6;
        r101 = r101 + 1;
        g();
        goto L4
    L6:
        return r101;
    }

    public final boolean h(char r100) {
        if (j() != r100) goto L6;
        g();
        return true;
    L6:
        return false;
    }

    public final boolean i(String r100) {
        int r101 = this.f562875c;
        if (r101 < this.f562877e) goto L5;
    L15:
        return false;
    L5:
        if ((r101 + r100.length()) > this.f562877e) goto L15;
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L13;
        if (this.f562876d.f558606a.charAt(this.f562875c + r102) != r100.charAt(r102)) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return false;
    L13:
        this.f562875c += r100.length();
        return true;
    }

    public final void l(d r100) {
        a(r100.f562871a, r100.f562872b);
        int r101 = r100.f562871a;
        this.f562874b = r101;
        this.f562875c = r100.f562872b;
        f r102 = (f) ListProtector.get(this.f562873a, r101);
        this.f562876d = r102;
        this.f562877e = r102.f558606a.length();
    }

    public final void a(int r100, int r101) {
        if (r100 < 0) goto L13;
        if (r100 >= this.f562873a.size()) goto L13;
        f r102 = (f) ListProtector.get(this.f562873a, r100);
        if (r101 < 0) goto L11;
        if (r101 > r102.f558606a.length()) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Index " + r101 + " out of range, line length: " + r102.f558606a.length());
    L13:
        throw new IllegalArgumentException("Line index " + r100 + " out of range, number of lines: " + this.f562873a.size());
    }

    public final g c(d r100, d r101) {
        int r102 = r100.f562871a;
        if (r102 != r101.f562871a) goto L10;
        f r103 = (f) ListProtector.get(this.f562873a, r102);
        CharSequence r104 = r103.f558606a.subSequence(r100.f562872b, r101.f562872b);
        x r105 = r103.f558607b;
        if (r105 == null) goto L7;
        x r106 = new x(r105.f553578a, r105.f553579b + r100.f562872b, r104.length());
    L8:
        f r107 = new f(r104, r106);
        g r108 = new g();
        ((ArrayList) r108.f558608a).add(r107);
        return r108;
    L7:
        r106 = null;
        goto L8
    L10:
        g r109 = new g();
        f r110 = (f) ListProtector.get(this.f562873a, r100.f562871a);
        f r111 = r110.a(r100.f562872b, r110.f558606a.length());
        ((ArrayList) r109.f558608a).add(r111);
        int r112 = r100.f562871a;
    L11:
        r112 = r112 + 1;
        int r113 = r101.f562871a;
        if (r112 >= r113) goto L14;
        f r114 = (f) ListProtector.get(this.f562873a, r112);
        ((ArrayList) r109.f558608a).add(r114);
        goto L11
    L14:
        f r115 = ((f) ListProtector.get(this.f562873a, r113)).a(0, r101.f562872b);
        ((ArrayList) r109.f558608a).add(r115);
        return r109;
    }
}
