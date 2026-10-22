package tsc;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    public static class a extends c {

        /* JADX INFO: renamed from: tsc.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes41.dex */
        public static class C7768a implements Iterable<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f547433a;

            /* JADX INFO: renamed from: tsc.c$a$a$a, reason: collision with other inner class name */
            public class C7769a implements Iterator<d> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final d f547434a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final StringBuilder f547435b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final int f547436c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public int f547437d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ C7768a f547438e;

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    d r100 = this.f547434a;
                    r100.f547441a = "";
                    r100.f547442b = "";
                    this.f547435b.setLength(0);
                    int r101 = this.f547437d;
                    String r102 = null;
                    String r103 = null;
                    boolean r104 = false;
                L4:
                    if (r101 >= this.f547436c) goto L40;
                    char r105 = this.f547438e.f547433a.charAt(r101);
                    if (r102 == null) goto L8;
                    if (r103 != null) goto L39;
                    if (Character.isWhitespace(r105) == true) goto L27;
                    if (';' != r105) goto L38;
                    r103 = this.f547435b.toString().trim();
                    this.f547435b.setLength(0);
                    if (TextUtils.isEmpty(r102) == false) goto L33;
                L35:
                    boolean r106 = false;
                L36:
                    if (r106 == false) goto L39;
                    this.f547437d = r101 + 1;
                    d r107 = this.f547434a;
                    r107.f547441a = r102;
                    r107.f547442b = r103;
                L44:
                    d r108 = this.f547434a;
                    String r109 = r108.f547441a;
                    String r110 = r108.f547442b;
                    if (TextUtils.isEmpty(r109) == false) goto L47;
                    return false;
                L47:
                    if (TextUtils.isEmpty(r110) == true) goto L64;
                    return true;
                L64:
                    return false;
                L33:
                    if (TextUtils.isEmpty(r103) == true) goto L35;
                    r106 = true;
                    goto L36
                L38:
                    this.f547435b.append(r105);
                    goto L39
                L27:
                    if (this.f547435b.length() <= 0) goto L39;
                    this.f547435b.append(r105);
                L39:
                    r101 = r101 + 1;
                    goto L4
                L8:
                    if (':' == r105) goto L10;
                    if (';' != r105) goto L16;
                    this.f547435b.setLength(0);
                    goto L39
                L16:
                    if (Character.isWhitespace(r105) == true) goto L18;
                    if (r104 == false) goto L22;
                    this.f547435b.setLength(0);
                    this.f547435b.append(r105);
                    r104 = false;
                    goto L39
                L22:
                    this.f547435b.append(r105);
                    goto L39
                L18:
                    if (this.f547435b.length() <= 0) goto L39;
                    r104 = true;
                    goto L39
                L10:
                    if (this.f547435b.length() <= 0) goto L12;
                    r102 = this.f547435b.toString().trim();
                L12:
                    this.f547435b.setLength(0);
                    goto L39
                L40:
                    if (r102 == null) goto L44;
                    if (this.f547435b.length() <= 0) goto L44;
                    String r111 = this.f547435b.toString().trim();
                    d r112 = this.f547434a;
                    r112.f547441a = r102;
                    r112.f547442b = r111;
                    this.f547437d = this.f547436c;
                    goto L44
                }

                @Override // java.util.Iterator
                public final d next() {
                    d r100 = this.f547434a;
                    String r101 = r100.f547441a;
                    String r102 = r100.f547442b;
                    if (TextUtils.isEmpty(r101) == false) goto L5;
                L7:
                    boolean r103 = false;
                L8:
                    if (r103 == false) goto L12;
                    return this.f547434a;
                L12:
                    throw new NoSuchElementException();
                L5:
                    if (TextUtils.isEmpty(r102) == true) goto L7;
                    r103 = true;
                    goto L8
                }

                public C7769a(C7768a r100) {
                    this.f547438e = r100;
                    this.f547434a = new d();
                    this.f547435b = new StringBuilder();
                    this.f547436c = r100.f547433a.length();
                }
            }

            @Override // java.lang.Iterable
            public final Iterator<d> iterator() {
                return new C7769a(this);
            }

            public C7768a(String r100) {
                this.f547433a = r100;
            }
        }

        public a() {
        }
    }

    public c() {
    }
}
