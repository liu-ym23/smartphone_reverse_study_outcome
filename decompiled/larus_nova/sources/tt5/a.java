package tt5;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC7773a f547558a;

    /* JADX INFO: renamed from: tt5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7773a {
        void a(String r100);

        boolean b(String r100, String r101, Throwable r102);
    }

    public static String a(String r100) {
        return "Bear_" + r100;
    }

    public static void c(String r100) {
        d("", r100);
    }

    public static void g(Throwable r100) {
        f("EncriptUtils", r100, false);
    }

    public static void b(String r100, String r101) {
        Log.d(a(r100), r101);
    }

    public static void d(String r100, String r101) {
        e(r100, r101, null, false);
    }

    public static void h(String r100, String r101) {
        InterfaceC7773a r102 = f547558a;
        if (r102 == null) goto L5;
        r102.a(r101);
    L5:
        Log.i(a(r100), r101);
    }

    public static void j(String r100, Throwable r101) {
        i("", r100, r101);
    }

    public static void k(String r100, String r101) {
        InterfaceC7773a r102 = f547558a;
        if (r102 == null) goto L5;
        r102.a(r101);
    L5:
        Log.w(a(r100), r101);
    }

    public static void m(String r100, Throwable r101) {
        l("", r100, r101);
    }

    public static void f(String r100, Throwable r101, boolean r102) {
        e("", r100, r101, r102);
    }

    public static void i(String r100, String r101, Throwable r102) {
        InterfaceC7773a r103 = f547558a;
        if (r103 == null) goto L5;
        r103.a(r101);
    L5:
        Log.i(a(r100), r101, r102);
    }

    public static void l(String r100, String r101, Throwable r102) {
        InterfaceC7773a r103 = f547558a;
        if (r103 == null) goto L5;
        r103.a(r101);
    L5:
        Log.w(a(r100), r101, r102);
    }

    public static void e(String r100, String r101, Throwable r102, boolean r103) {
        InterfaceC7773a r104 = f547558a;
        if (r104 == null) goto L5;
        boolean r105 = r104.b(r100, r101, r102);
    L6:
        if (r105 == true) goto L9;
        Log.e(a(r100), r101, r102, r103);
        return;
    L9:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
