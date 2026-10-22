package ao5;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final CharSequence a;
    public boolean b;
    public final List<TemplateV4> c;
    public final long d;
    public boolean e;
    public final HashMap<String, TemplateV4> f;
    public final HashMap<Integer, List<TemplateV4>> g;

    /* JADX INFO: renamed from: ao5.a$a, reason: collision with other inner class name */
    public static final class C0002a {
    }

    static {
    }

    public a() {
        this(null, false, null, 0, 127);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return ((((r5 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "Category(name=" + this.a + ", hasMore=" + this.b + ", templates=" + this.c + ", categoryId=" + this.d + ", loadFirstTab=" + this.e + ", templateMap=" + this.f + ", categoryPage=" + this.g + ')';
    }

    public final List<e> a() {
        ArrayList r0 = new ArrayList();
        r0.add(new d(this.a));
        if (this.c.isEmpty() == false) goto L5;
        r0.add(new c());
    L6:
        return r0;
    L5:
        r0.addAll(this.c);
        goto L6
    }

    public a(CharSequence r4, boolean r5, List r6, long r7, int r9) {
        if ((r9 & 1) == 0) goto L5;
        r4 = "";
    L5:
        boolean r1 = false;
        if ((r9 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r6 = new ArrayList();
    L12:
        if ((r9 & 8) == 0) goto L15;
        r7 = -1;
    L15:
        if ((r9 & 16) == 0) goto L17;
        r1 = true;
    L17:
        HashMap<Integer, List<TemplateV4>> r2 = null;
        if ((r9 & 32) == 0) goto L20;
        HashMap<String, TemplateV4> r0 = new HashMap();
    L22:
        if ((r9 & 64) == 0) goto L24;
        r2 = new HashMap();
    L24:
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r6, "templates");
        Intrinsics.checkNotNullParameter(r0, "templateMap");
        Intrinsics.checkNotNullParameter(r2, "categoryPage");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r1;
        this.f = r0;
        this.g = r2;
        return;
    L20:
        r0 = null;
        goto L22
    }
}
