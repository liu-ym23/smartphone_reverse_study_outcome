package qu8;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.larus.ugc.perf.impl.c;
import com.larus.ugc.perf.impl.g;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f534849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Boolean> f534850b = null;

    static {
        f534849a = "";
        f534850b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(ConstraintLayout r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(((LinkedHashMap) f534850b).get(r101), Boolean.TRUE) == false) goto L12;
        return;
    L12:
        a r103 = new a(r100, r101);
        r100.getViewTreeObserver().addOnPreDrawListener(r103);
        return;
    L6:
        r102 = false;
        goto L7
    }

    @JvmStatic
    public static final void c(long r100, String... r101) {
        Intrinsics.checkNotNullParameter(r101, InvRouter.SCENES);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        d(r101[r103], r100);
        r103 = r103 + 1;
        goto L3
    }

    @JvmStatic
    public static final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        c.f375100a.getClass();
        if (c.b(r100) != null) goto L5;
        return;
    L5:
        g r102 = c.b(r100);
        if (r102 != null) goto L8;
        return;
    L8:
        if (r101 != 0) goto L10;
        r102.d("success", "1");
    L11:
        c.e(r100);
        JSONObject r103 = r102.c();
        c.f(r102.f375111a, r103);
        return;
    L10:
        r102.d("success", "0");
        r102.d("err_code", String.valueOf(r101));
        goto L11
    }

    @JvmStatic
    public static final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        c.c(r100, new String[]{r101, r102});
    }

    @JvmStatic
    public static final void e(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "parentScene");
        if (Intrinsics.areEqual(r100, r101) == true) goto L7;
        c.f375100a.getClass();
        if (c.b(r101) != null) goto L7;
        return;
    L7:
        g r103 = new g("ugc_core_segment_report");
        r103.d(BindCardPayConfirmConstants.Key.TRACE_ID, f534849a);
        r103.d("scene", r100);
        r103.d("parent_scene", r101);
        c.f375100a.getClass();
        c.d(r100, r103);
        if (r102 == false) goto L11;
        f534850b.put(r100, Boolean.FALSE);
        return;
    }
}
