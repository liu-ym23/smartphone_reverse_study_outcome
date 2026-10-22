package n4a;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public abstract class j0 extends a5 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f517395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e5 f517396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f517397m;

    public static byte[] l() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(f5.j("PANDORA$"));     // Catch: Throwable -> L9
        r100.write(new byte[]{1});     // Catch: Throwable -> L9
        r100.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r101 = r100.toByteArray();     // Catch: Throwable -> L9
        r100.close();     // Catch: Throwable -> L6
    L8:
        return r101;
    L6:
        th = move-exception;
        n.a(th, "bre", "gbh");
    L9:
        th = move-exception;
        n.a(th, "bre", "gbh");     // Catch: Throwable -> L17
        r100.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        n.a(th, "bre", "gbh");
        return null;
    L17:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        n.a(th, "bre", "gbh");
        goto L22
    }

    @Override // com.loc.bo
    public Map<String, String> h() {
        String r100 = v4.g(this.f517395k);
        String r101 = w4.a();
        String r102 = w4.b(this.f517395k, r101, "key=".concat(String.valueOf(r100)));
        HashMap r103 = new HashMap();
        r103.put("ts", r101);
        r103.put("key", r100);
        r103.put("scode", r102);
        return r103;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        byte[] r100 = this.f517397m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r101.write(l());     // Catch: Throwable -> L12
        r101.write(m());     // Catch: Throwable -> L12
        r101.write(n());     // Catch: Throwable -> L12
        r101.write(o());     // Catch: Throwable -> L12
        byte[] r102 = r101.toByteArray();     // Catch: Throwable -> L12
        this.f517397m = r102;     // Catch: Throwable -> L12
        r101.close();     // Catch: Throwable -> L9
    L11:
        return r102;
    L9:
        th = move-exception;
        n.a(th, "bre", "geb");
    L12:
        th = move-exception;
        n.a(th, "bre", "geb");     // Catch: Throwable -> L20
        r101.close();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        n.a(th, "bre", "geb");
        return null;
    L20:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        n.a(th, "bre", "geb");
        goto L25
    }

    public abstract byte[] p();

    public abstract byte[] q();

    public String r() {
        return "2.1";
    }

    public boolean s() {
        return true;
    }

    public String t() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f517396l.b(), this.f517396l.a()});
    }

    public boolean u() {
        return false;
    }

    public final byte[] m() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(new byte[]{3});     // Catch: Throwable -> L16
        if (s() == false) goto L18;
        Context r101 = this.f517395k;     // Catch: Throwable -> L16
        boolean r102 = u();     // Catch: Throwable -> L16
        e5 r103 = this.f517396l;     // Catch: Throwable -> L16
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L58:
        byte[] r105 = w4.e(w4.d(r101, r102, r104));     // Catch: Throwable -> L13
    L15:
        r100.write(f5.i(r105.length));     // Catch: Throwable -> L16
        r100.write(r105);     // Catch: Throwable -> L16
    L19:
        byte[] r106 = f5.j(r());     // Catch: Throwable -> L16
        if (r106 != null) goto L22;
    L24:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L25:
        byte[] r107 = f5.j(t());     // Catch: Throwable -> L16
        if (r107 != null) goto L28;
    L30:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L31:
        byte[] r108 = r100.toByteArray();     // Catch: Throwable -> L16
        r100.close();     // Catch: Throwable -> L34
    L36:
        return r108;
    L34:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L36
    L28:
        if (r107.length <= 0) goto L30;
        r100.write(f5.i(r107.length));     // Catch: Throwable -> L16
        r100.write(r107);     // Catch: Throwable -> L16
        goto L31
    L22:
        if (r106.length <= 0) goto L24;
        r100.write(f5.i(r106.length));     // Catch: Throwable -> L16
        r100.write(r106);     // Catch: Throwable -> L16
        goto L25
    L13:
        th = move-exception;
        n.a(th, "CI", "gz");     // Catch: Throwable -> L16
        r105 = null;
        goto L15
    L8:
        if ("navi".equals(r103.a()) == false) goto L10;
        r104 = true;
        goto L58
    L18:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        n.a(th, "bre", "gpd");     // Catch: Throwable -> L44
        r100.close();     // Catch: Throwable -> L40
    L43:
        return new byte[]{0};
    L40:
        th = move-exception;
        n.a(th, "bre", "gred");
    L44:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L47
    L49:
        throw th;
    L47:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L49
    }

    public final byte[] n() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = p();     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
    L16:
        r100.write(new byte[]{0});     // Catch: Throwable -> L14
        byte[] r102 = r100.toByteArray();     // Catch: Throwable -> L14
        r100.close();     // Catch: Throwable -> L19
    L21:
        return r102;
    L19:
        th = move-exception;
        n.a(th, "bre", "grrd");
        goto L21
    L6:
        if (r101.length == 0) goto L16;
        r100.write(new byte[]{1});     // Catch: Throwable -> L14
        r100.write(f5.i(r101.length));     // Catch: Throwable -> L14
        r100.write(r101);     // Catch: Throwable -> L14
        byte[] r103 = r100.toByteArray();     // Catch: Throwable -> L14
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r103;
    L11:
        th = move-exception;
        n.a(th, "bre", "grrd");
    L14:
        th = move-exception;
        n.a(th, "bre", "grrd");     // Catch: Throwable -> L29
        r100.close();     // Catch: Throwable -> L25
    L28:
        return new byte[]{0};
    L25:
        th = move-exception;
        n.a(th, "bre", "grrd");
    L29:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        n.a(th, "bre", "grrd");
        goto L34
    }

    public final byte[] o() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = q();     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
    L16:
        r100.write(new byte[]{0});     // Catch: Throwable -> L14
        byte[] r102 = r100.toByteArray();     // Catch: Throwable -> L14
        r100.close();     // Catch: Throwable -> L19
    L21:
        return r102;
    L19:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L21
    L6:
        if (r101.length == 0) goto L16;
        r100.write(new byte[]{1});     // Catch: Throwable -> L14
        byte[] r103 = y4.a(r101);     // Catch: Throwable -> L14
        r100.write(f5.i(r103.length));     // Catch: Throwable -> L14
        r100.write(r103);     // Catch: Throwable -> L14
        byte[] r104 = r100.toByteArray();     // Catch: Throwable -> L14
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r104;
    L11:
        th = move-exception;
        n.a(th, "bre", "gred");
    L14:
        th = move-exception;
        n.a(th, "bre", "gred");     // Catch: Throwable -> L29
        r100.close();     // Catch: Throwable -> L25
    L28:
        return new byte[]{0};
    L25:
        th = move-exception;
        n.a(th, "bre", "gred");
    L29:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L34
    }

    public j0(Context r100, e5 r101) {
        if (r100 == null) goto L5;
        this.f517395k = r100.getApplicationContext();
    L5:
        this.f517396l = r101;
        this.f379926c = true;
    }
}
