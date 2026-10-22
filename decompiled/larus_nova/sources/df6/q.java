package df6;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes20.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f468227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile r f468228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f468229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f468230d;

    static {
        p r100 = null;
        p r101 = (p) ff6.b.a().asSubclass(p.class).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L5
    L7:
        if (r101 == null) goto L26;
    L22:
        f468227a = r101;
        return;
    L26:
        r101 = (p) ff6.c.a().asSubclass(p.class).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
    L13:
        if (r101 != null) goto L22;
        r100 = (p) ff6.d.a().asSubclass(p.class).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L17
    L19:
        if (r100 == null) goto L21;
        r101 = r100;
        goto L22
    L21:
        r101 = new ff6.a();
    L17:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
    L5:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L7
    }

    public static r a() {
        if (f468228b == null) goto L7;
        return f468228b;
    L7:
        throw new IllegalStateException("Lighten:lighten is not initialized, call Lighten.init");
    }

    public static void b(r r100) {
        if (f468229c == false) goto L5;
        return;
    L5:
        f468229c = true;
        f468228b = r100;
        f468230d = r100.getContext().getPackageName();
        f468227a.init(r100);
    }

    public static u c(ef6.a r100) {
        return f468227a.load(r100);
    }

    public static u d(Object r100) {
        if ((r100 instanceof File) == false) goto L13;
        File r101 = (File) r100;
        if (r101.exists() == true) goto L11;
        r101.toString();
        if (f468229c == false) goto L26;
        s r102 = s.f468248a;
        a().getClass();
    L26:
        return u.B;
    L11:
        return f468227a.load(r101);
    L13:
        if ((r100 instanceof String) == false) goto L17;
        return e((String) r100);
    L17:
        if ((r100 instanceof Uri) == false) goto L21;
        p r103 = f468227a;
        return r103.load((Uri) r100);
    L21:
        if ((r100 instanceof ef6.a) == false) goto L25;
        return c((ef6.a) r100);
    L25:
        return f468227a.load(r100);
    }

    public static u e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        if (f468229c == false) goto L8;
        s r101 = s.f468248a;
        a().getClass();
    L8:
        return u.B;
    L10:
        return f468227a.load(r100);
    }
}
