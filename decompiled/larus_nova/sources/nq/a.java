package nq;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f520084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f520085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f520086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f520087d;

    @JvmStatic
    public static final boolean g() {
        if (f520084a == true) goto L5;
        SliceRender.f50121o.getClass();
        pq.a r100 = SliceRender.f50108b;
        if (r100 == null) goto L10;
        f520084a = true;
        boolean r101 = r100.isDebug();
        f520085b = r101;
        return r101;
    L10:
        return false;
    L5:
        return f520085b;
    }

    @JvmStatic
    public static final boolean h() {
        if (f520086c == true) goto L5;
        SliceRender.f50121o.getClass();
        pq.a r100 = SliceRender.f50108b;
        if (r100 == null) goto L10;
        f520086c = true;
        boolean r101 = r100.isLocalTest();
        f520087d = r101;
        return r101;
    L10:
        return false;
    L5:
        return f520087d;
    }

    @JvmStatic
    public static final void a() {
        if (g() == true) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == true) goto L8;
        return;
    L8:
        throw new IllegalStateException("必须执行在主线程");
    }

    static {
    }

    @JvmStatic
    public static final void b(Throwable r100, Function0<String> r101) {
        if (g() == true) goto L5;
        if (r101 != null) goto L12;
        if (r100 != null) goto L12;
        return;
    L12:
        SliceRender.f50121o.getClass();
        pq.a r102 = SliceRender.f50108b;
        if (r102 == null) goto L22;
        if (r101 == null) goto L18;
        String r103 = r101.invoke();
        if (r103 == null) goto L18;
    L19:
        r102.ensureNotReachHere(r100, r103);
        return;
    L18:
        r103 = "";
        goto L19
    L22:
        return;
    L5:
        if (r101 == null) goto L7;
        String r104 = r101.invoke();
    L9:
        throw new IllegalStateException(r104, r100);
    L7:
        r104 = null;
        goto L9
    }

    @JvmStatic
    public static final void f(Throwable r100, String r101) {
        if (r101 != null) goto L4;
        if (r100 != null) goto L4;
        return;
    L4:
        SliceRender.f50121o.getClass();
        pq.a r102 = SliceRender.f50108b;
        if (r102 == null) goto L12;
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r102.ensureNotReachHere(r100, r101);
        return;
    }

    @JvmStatic
    public static final void i(Context r100, String r101) {
        if (g() == true) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L15;
        Toast.makeText(r100, r101, 0).show();
        return;
    L15:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public static /* synthetic */ void c(Throwable r100, Function0 r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        b(r100, r101);
    }

    @JvmStatic
    public static final void d(boolean r100, Throwable r101, Function0<String> r102) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (g() == true) goto L6;
        if (r102 != null) goto L13;
        if (r101 != null) goto L13;
        return;
    L13:
        SliceRender.f50121o.getClass();
        pq.a r103 = SliceRender.f50108b;
        if (r103 == null) goto L24;
        if (r102 == null) goto L19;
        String r104 = r102.invoke();
        if (r104 == null) goto L19;
    L20:
        r103.ensureNotReachHere(r101, r104);
        return;
    L19:
        r104 = "";
        goto L20
    L24:
        return;
    L6:
        if (r102 == null) goto L8;
        String r105 = r102.invoke();
    L10:
        throw new IllegalStateException(r105, r101);
    L8:
        r105 = null;
        goto L10
    }

    public static /* synthetic */ void e(boolean r100, Function0 r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = null;
    L5:
        d(r100, null, r101);
    }
}
