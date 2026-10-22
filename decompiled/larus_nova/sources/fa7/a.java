package fa7;

import com.alipay.sdk.m.u.i;
import com.bytedance.express.command.Instruction;
import com.bytedance.ruler.base.models.e;
import com.google.gson.JsonElement;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends com.bytedance.express.command.b> f476024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<a> f476025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f476026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Instruction> f476027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f476028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f476029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f476030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f476031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f476032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f476033j;

    /* JADX INFO: renamed from: fa7.a$a, reason: collision with other inner class name */
    public static final class C5876a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, 8191);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{");
        String r101 = a();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r100.append(" cel = " + a());
    L12:
        if (b() == null) goto L14;
        r100.append(" conf = ".concat(String.valueOf(b())));
    L14:
        String r104 = c();
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L23;
        r100.append(" key = " + c());
    L23:
        List<a> r106 = this.f476025b;
        if (r106 != null) goto L26;
    L27:
        r102 = true;
    L28:
        if (r102 == true) goto L36;
        r100.append("\nchild = ");
        List<a> r107 = this.f476025b;
        if (r107 == null) goto L36;
        Iterator<T> r108 = r107.iterator();
    L33:
        if (r108.hasNext() == false) goto L36;
        r100.append(tb2.c.DEFAULT_TEXT + ((a) r108.next()));
    L36:
        if (this.f476026c == null) goto L38;
        r100.append("type = " + this.f476026c);
    L38:
        Integer r109 = this.f476026c;
        if (r109 != null) goto L42;
    L44:
        r100.append(i.f25855d);
        return r100.toString();
    L42:
        if (r109.intValue() != 2) goto L44;
        r100.append("c_para = " + this.f476030g);
        r100.append("c_type = " + this.f476031h);
        r100.append("c_limi = " + this.f476032i);
        r100.append("c_ival = " + this.f476033j);
        goto L44
    L26:
        if (r106.isEmpty() == false) goto L28;
    L17:
        if (r104.length() == 0) goto L20;
        r105 = false;
        goto L21
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final int hashCode() {
        String r100 = c();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final Integer getType() {
        return this.f476026c;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        Integer r101 = this.f476026c;
        if (r101 != null) goto L9;
    L10:
        a r102 = (a) r100;
        Integer r103 = r102.f476026c;
        if (r103 == null) goto L17;
        if (r103.intValue() != 2) goto L17;
    L18:
        a r104 = (a) r100;
        if (Intrinsics.areEqual(c(), r104.c()) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f476028e, r104.f476028e) == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        return Intrinsics.areEqual(c(), r102.c());
    L9:
        if (r101.intValue() == 2) goto L18;
        goto L10
    }

    public a(String r100, List r101, JsonElement r102, String r103, Integer r104, List r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        super(r100, r102, r103, null);
        this.f476025b = r101;
        this.f476026c = r104;
        this.f476027d = r105;
        this.f476028e = null;
        this.f476029f = null;
        this.f476030g = null;
        this.f476031h = null;
        this.f476032i = null;
        this.f476033j = null;
    }
}
