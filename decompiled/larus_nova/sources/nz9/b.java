package nz9;

import android.text.TextUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.larus.ugc.perf.impl.g;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements vy9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f521556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f521557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f521558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Boolean> f521559d = null;

    public b() {
    }

    static {
        f521556a = new b();
        f521557b = "";
        f521558c = "";
        f521559d = new LinkedHashMap();
    }

    @Override // vy9.a
    public final void a() {
        Intrinsics.checkNotNullParameter("1", "code");
        e("creation_page", "1", null);
    }

    public static String b(String r100, String r101) {
        return r100 + '/' + r101;
    }

    @JvmStatic
    public static final void d(String r100, List<Pair<String, String>> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "keyValues");
        String r103 = b(r100, r102);
        com.larus.ugc.perf.impl.c r104 = com.larus.ugc.perf.impl.c.f375100a;
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r101, "keyValues");
        if (TextUtils.isEmpty(r103) == true) goto L15;
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        g r105 = com.larus.ugc.perf.impl.c.b(r103);
        if (r105 == null) goto L14;
        Iterator<T> r106 = r101.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        Pair r107 = (Pair) r106.next();
        r105.d((String) r107.component1(), (String) r107.component2());
        goto L9
    L11:
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        com.larus.ugc.perf.impl.c.d(r103, r105);
        return;
    L14:
        return;
    }

    @JvmStatic
    public static final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        String r103 = b(r100, r102);
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        g r104 = com.larus.ugc.perf.impl.c.b(r103);
        if (r104 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, "0") == false) goto L7;
        r104.d("success", "1");
    L8:
        com.larus.ugc.perf.impl.c.e(r103);
        JSONObject r105 = r104.c();
        com.larus.ugc.perf.impl.c.f(r104.f375111a, r105);
        return;
    L7:
        r104.d("success", "0");
        r104.d("err_code", r101);
        goto L8
    }

    @JvmStatic
    public static final void f(String r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, InvRouter.SCENES);
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        e((String) r103.next(), r100, r102);
        goto L4
    }

    @JvmStatic
    public static final void c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        com.larus.ugc.perf.impl.c.c(b(r100, r103), new String[]{r101, r102});
    }

    @JvmStatic
    public static final void g(String r100, String r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "parentScene");
        String r105 = b(r101, r103);
        if (Intrinsics.areEqual(r100, r101) == true) goto L7;
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        if (com.larus.ugc.perf.impl.c.b(r105) != null) goto L7;
        return;
    L7:
        String r106 = b(r100, r102);
        g r107 = new g("creation_page_perf_report");
        r107.d(BindCardPayConfirmConstants.Key.TRACE_ID, f521557b);
        r107.d("instruction_type", f521558c);
        r107.d("scene", r100);
        r107.d("parent_scene", r101);
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        com.larus.ugc.perf.impl.c.d(r106, r107);
        if (r104 == false) goto L11;
        f521559d.put(r100, Boolean.FALSE);
        return;
    }

    public static /* synthetic */ void h(String r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        g(r100, r101, r102, r103, false);
    }
}
