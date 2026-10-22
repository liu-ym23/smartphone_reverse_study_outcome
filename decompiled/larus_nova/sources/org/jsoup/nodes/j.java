package org.jsoup.nodes;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.jsoup.SerializationException;
import org.jsoup.helper.ValidationException;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes42.dex */
public abstract class j implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<j> f525932c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public j f525933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f525934b;

    public static class a implements gwc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f525935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Document.OutputSettings f525936b;

        public a(Appendable r100, Document.OutputSettings r101) {
            this.f525935a = r100;
            this.f525936b = r101;
            CharsetEncoder r102 = r101.f525894b.newEncoder();
            r101.f525895c.set(r102);
            r101.f525896d = Entities.CoreCharset.byName(r102.charset().name());
        }

        @Override // gwc.b
        public final void a(j r100, int r101) {
            if (r100.t().equals("#text") == false) goto L10;
            return;
        L10:
            r100.w(this.f525935a, r101, this.f525936b);     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new SerializationException(e);
        }

        @Override // gwc.b
        public final void b(j r100, int r101) {
            r100.v(this.f525935a, r101, this.f525936b);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new SerializationException(e);
        }
    }

    public j D() {
        j r100 = this;
    L3:
        j r101 = r100.f525933a;
        if (r101 == null) goto L6;
        r100 = r101;
        goto L3
    L6:
        return r100;
    }

    public final boolean equals(@Nullable Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract b f();

    public abstract String g();

    public abstract int i();

    public j k() {
        j r100 = l(null);
        LinkedList r101 = new LinkedList();
        r101.add(r100);
    L4:
        if (r101.isEmpty() == true) goto L8;
        j r102 = (j) r101.remove();
        int r103 = r102.i();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L4;
        List<j> r105 = r102.n();
        j r106 = ((j) ListProtector.get(r105, r104)).l(r102);
        ListProtector.set(r105, r104, r106);
        r101.add(r106);
        r104 = r104 + 1;
        goto L6
    L8:
        return r100;
    }

    public abstract j m();

    public abstract List<j> n();

    public abstract boolean q();

    public abstract String t();

    public abstract void v(Appendable r100, int r101, Document.OutputSettings r102) throws IOException;

    public abstract void w(Appendable r100, int r101, Document.OutputSettings r102) throws IOException;

    public final void A() {
        ewc.b.d(this.f525933a);
        this.f525933a.B(this);
    }

    @Nullable
    public final j s() {
        j r100 = this.f525933a;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<j> r101 = r100.n();
        int r102 = this.f525934b + 1;
        if (r101.size() > r102) goto L8;
        return null;
    L8:
        return (j) ListProtector.get(r101, r102);
    }

    static {
        f525932c = Collections.emptyList();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return k();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final List<j> j() {
        if (i() == 0) goto L5;
        List<j> r100 = n();
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        return Collections.unmodifiableList(r101);
    L5:
        return f525932c;
    }

    public String toString() {
        return u();
    }

    public String u() {
        StringBuilder r100 = fwc.b.b();
        Document r101 = x();
        if (r101 != null) goto L6;
        r101 = new Document("");
    L6:
        org.jsoup.select.d.b(new a(r100, r101.f525890k), this);
        return fwc.b.g(r100);
    }

    @Nullable
    public final Document x() {
        j r100 = D();
        if ((r100 instanceof Document) == true) goto L7;
        return null;
    L7:
        return (Document) r100;
    }

    public j() {
    }

    @Nullable
    public j y() {
        return this.f525933a;
    }

    public static Element o(Element r100) {
        Elements r101 = r100.K();
        if (r101.size() > 0) goto L5;
        return r100;
    L5:
        return o((Element) ListProtector.get(r101, 0));
    }

    public void B(j r100) {
        if (r100.f525933a != this) goto L5;
        boolean r101 = true;
    L6:
        ewc.b.a(r101);
        int r102 = r100.f525934b;
        ListProtector.remove(n(), r102);
        z(r102);
        r100.f525933a = null;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public String a(String r100) {
        ewc.b.b(r100);
        String r101 = "";
        if (q() == true) goto L5;
    L20:
        return "";
    L5:
        if (f().i(r100) == (-1)) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L20;
        String r103 = g();
        String r104 = f().f(r100);
        Pattern r105 = fwc.b.f479048d;
        String r106 = r105.matcher(r103).replaceAll("");
        String r107 = r105.matcher(r104).replaceAll("");
        r107 = fwc.b.h(new URL(r106), r107).toExternalForm();     // Catch: MalformedURLException -> L15
    L23:
        return r107;
    L13:
        r107 = new URL(r107).toExternalForm();     // Catch: MalformedURLException -> L15
    L16:
        if (fwc.b.f479047c.matcher(r107).find() == false) goto L25;
        r101 = r107;
    L25:
        return r101;
    L7:
        r102 = false;
        goto L8
    }

    public String d(String r100) {
        ewc.b.d(r100);
        if (q() == true) goto L5;
        return "";
    L5:
        String r101 = f().f(r100);
        if (r101.length() <= 0) goto L9;
        return r101;
    L9:
        if (r100.startsWith("abs:") == true) goto L11;
        return "";
    L11:
        return a(r100.substring(4));
    }

    public final j h(int r100) {
        return (j) ListProtector.get(n(), r100);
    }

    public j l(@Nullable j r100) {
        j r101 = (j) super.clone();     // Catch: CloneNotSupportedException -> L18
        r101.f525933a = r100;
        if (r100 != null) goto L6;
        int r102 = 0;
    L7:
        r101.f525934b = r102;
        if (r100 == null) goto L10;
    L17:
        return r101;
    L10:
        if ((this instanceof Document) == true) goto L17;
        Document r103 = x();
        if (r103 == null) goto L17;
        Document r104 = new Document(r103.g());
        b r105 = r103.f525909g;
        if (r105 == null) goto L16;
        r104.f525909g = r105.d();
    L16:
        r104.f525890k = r103.f525890k.a();
        r101.f525933a = r104;
        r104.n().add(r101);
        goto L17
    L6:
        r102 = this.f525934b;
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final boolean p(String r100) {
        ewc.b.d(r100);
        if (q() == true) goto L6;
        return false;
    L6:
        if (r100.startsWith("abs:") == false) goto L16;
        String r101 = r100.substring(4);
        if (f().i(r101) == (-1)) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L16;
        if (a(r101).isEmpty() == true) goto L16;
        return true;
    L10:
        r102 = false;
    L16:
        if (f().i(r100) == (-1)) goto L19;
        return true;
    L19:
        return false;
    }

    public final void z(int r100) {
        int r101 = i();
        if (r101 != 0) goto L5;
        return;
    L5:
        List<j> r102 = n();
    L6:
        if (r100 >= r101) goto L8;
        ((j) ListProtector.get(r102, r100)).f525934b = r100;
        r100 = r100 + 1;
        goto L6
    }

    public final void C(j r100, Element r101) {
        if (r100.f525933a != this) goto L5;
        boolean r102 = true;
    L6:
        ewc.b.a(r102);
        j r103 = r101.f525933a;
        if (r103 == null) goto L9;
        r103.B(r101);
    L9:
        int r104 = r100.f525934b;
        ListProtector.set(n(), r104, r101);
        r101.f525933a = this;
        r101.f525934b = r104;
        r100.f525933a = null;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void b(int r100, j... r110) {
        ewc.b.d(r110);
        if (r110.length != 0) goto L5;
        return;
    L5:
        List<j> r101 = n();
        int r102 = 0;
        j r103 = r110[0].y();
        if (r103 != null) goto L8;
    L31:
        int r104 = r110.length;
        int r105 = 0;
    L32:
        if (r105 >= r104) goto L38;
        if (r110[r105] == null) goto L37;
        r105 = r105 + 1;
        goto L32
    L37:
        throw new ValidationException("Array must not contain any null objects");
    L38:
        int r106 = r110.length;
    L39:
        if (r102 >= r106) goto L44;
        j r107 = r110[r102];
        r107.getClass();
        j r108 = r107.f525933a;
        if (r108 == null) goto L43;
        r108.B(r107);
    L43:
        r107.f525933a = this;
        r102 = r102 + 1;
        goto L39
    L44:
        r101.addAll(r100, Arrays.asList(r110));
        z(r100);
        return;
    L8:
        if (r103.i() != r110.length) goto L31;
        List<j> r109 = r103.n();
        int r111 = r110.length;
    L10:
        int r112 = r111 - 1;
        boolean r113 = true;
        if (r111 <= 0) goto L16;
        if (r110[r112] != ListProtector.get(r109, r112)) goto L14;
        r111 = r112;
        goto L10
    L14:
        boolean r114 = false;
    L17:
        if (r114 == false) goto L31;
        if (i() == 0) goto L22;
        r113 = false;
    L22:
        r103.m();
        r101.addAll(r100, Arrays.asList(r110));
        int r115 = r110.length;
    L23:
        int r116 = r115 - 1;
        if (r115 <= 0) goto L26;
        r110[r116].f525933a = this;
        r115 = r116;
        goto L23
    L26:
        if (r113 == true) goto L28;
    L29:
        z(r100);
        return;
    L28:
        if (r110[0].f525934b != 0) goto L29;
        return;
    L16:
        r114 = true;
        goto L17
    }

    public final void c(int r100, String r101) {
        ewc.b.d(r101);
        ewc.b.d(this.f525933a);
        if ((y() instanceof Element) == false) goto L5;
        Element r102 = (Element) y();
    L6:
        List<j> r103 = k.a(this).a(r101, r102, g());
        this.f525933a.b(r100, (j[]) r103.toArray(new j[0]));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void e(String r100, String r101) {
        org.jsoup.parser.d r102 = k.a(this).f526026c;
        r102.getClass();
        String r103 = r100.trim();
        if (r102.f526023b == true) goto L5;
        r103 = fwc.a.a(r103);
    L5:
        b r104 = f();
        int r105 = r104.i(r103);
        if (r105 == (-1)) goto L10;
        r104.f525926c[r105] = r101;
        if (r104.f525925b[r105].equals(r103) == true) goto L12;
        r104.f525925b[r105] = r103;
        return;
    L12:
        return;
    L10:
        r104.a(r103, r101);
    }

    public static void r(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        Appendable r103 = r100.append('\n');
        int r104 = r101 * r102.f525898f;
        int r105 = r102.f525899g;
        String[] r106 = fwc.b.f479045a;
        int r107 = 0;
        boolean r108 = true;
        if (r104 < 0) goto L5;
        boolean r109 = true;
    L6:
        if (r109 == false) goto L24;
        if (r105 >= (-1)) goto L11;
        r108 = false;
    L11:
        ewc.b.a(r108);
        if (r105 == (-1)) goto L14;
        r104 = Math.min(r104, r105);
    L14:
        String[] r110 = fwc.b.f479045a;
        if (r104 >= r110.length) goto L17;
        String r111 = r110[r104];
    L21:
        r103.append(r111);
        return;
    L17:
        char[] r112 = new char[r104];
    L18:
        if (r107 >= r104) goto L20;
        r112[r107] = ' ';
        r107 = r107 + 1;
        goto L18
    L20:
        r111 = String.valueOf(r112);
        goto L21
    L24:
        throw new ValidationException("width must be >= 0");
    L5:
        r109 = false;
        goto L6
    }
}
