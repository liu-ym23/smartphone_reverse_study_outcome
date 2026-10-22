package in6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckReason;
import com.bytedance.locallife.common.utils.j;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements hn6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, fn6.d> f490612a;

    public c() {
        fn6.c r100 = fn6.b.f477930a;
        if (r100 == null) goto L6;
        Map<String, fn6.d> r101 = r100.g();
        if (r101 == null) goto L6;
    L7:
        this.f490612a = r101;
        return;
    L6:
        r101 = new LinkedHashMap();
        goto L7
    }

    @Override // hn6.d
    public final hn6.c a(hn6.b r100) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        Object r101 = r100.f486112a.f450808b.b();
        CheckReason r102 = CheckReason.SUCCESS;
        fn6.d r103 = this.f490612a.get(r100.f486112a.f450807a);
        List<String> r104 = null;
        boolean r105 = false;
        if ((r101 instanceof JSONObject) == false) goto L18;
        String r106 = ((JSONObject) r101).optString("btm");
        if (r106.length() != 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L10;
        if (r103 == null) goto L13;
        String r108 = r103.a();
    L14:
        if (r103 == null) goto L16;
        r104 = r103.b();
    L16:
        r105 = b(r108, r104, r106);
    L29:
        if (r105 == true) goto L32;
        r102 = CheckReason.BTM_INVALID;
    L32:
        return new hn6.c(r105, r102, r100);
    L13:
        r108 = null;
        goto L14
    L10:
        return new hn6.c(false, CheckReason.COVER_BTM_NULL, r100);
    L7:
        r107 = false;
        goto L8
    L18:
        if ((r101 instanceof Map) == false) goto L29;
        Object r109 = ((Map) r101).get("btm");
        if (r109 == null) goto L22;
        if (r103 == null) goto L25;
        String r110 = r103.a();
    L26:
        if (r103 == null) goto L28;
        r104 = r103.b();
    L28:
        r105 = b(r110, r104, (String) r109);
        goto L29
    L25:
        r110 = null;
        goto L26
    L22:
        return new hn6.c(false, CheckReason.COVER_BTM_NULL, r100);
    }

    public static boolean b(String r100, List r101, String r102) {
        if (j.a(r100) == false) goto L6;
        Intrinsics.checkNotNull(r100);
        return StringsKt.startsWith$default(r102, r100, false, 2, null);
    L6:
        if (r101 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L23;
        Iterator r104 = r101.iterator();
    L14:
        if (r104.hasNext() == false) goto L24;
        if (StringsKt.startsWith$default(r102, (String) r104.next(), false, 2, null) == false) goto L14;
        return true;
    L24:
        return false;
    L23:
        return false;
    L8:
        if ((!r101.isEmpty()) != true) goto L10;
        r103 = true;
        goto L11
    }
}
