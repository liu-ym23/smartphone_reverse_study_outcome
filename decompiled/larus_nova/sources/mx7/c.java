package mx7;

import android.app.Application;
import com.ivy.ivykit.base.provider.AccountServiceProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f516265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f516266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f516267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f516268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f516269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f516270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f516271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f516272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f516273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f516274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f516275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f516276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f516277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f516278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f516279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f516280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f516281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f516282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static Application f516283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static px7.a f516284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static kx7.a f516285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static AccountServiceProvider f516286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static qx7.b f516287w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static qx7.a f516288x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static com.ivy.ivykit.api.plugin.c f516289y;

    static {
        f516265a = "";
        f516266b = "";
        f516268d = "";
        f516269e = "";
        f516270f = "";
        f516271g = "";
        f516272h = "";
        f516274j = "";
        f516277m = "";
        f516279o = "";
        f516281q = "";
        f516282r = "";
    }

    public static String a() {
        px7.a r100 = f516284t;
        if (r100 == null) goto L9;
        px7.b r101 = r100.getProps();
        if (r101 == null) goto L9;
        if (r101.f530941a == false) goto L9;
        return "dark";
    L9:
        return "light";
    }

    public static Application b() {
        Application r100 = f516283s;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }
}
