package gn6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckReason;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements hn6.d {
    public c() {
    }

    @Override // hn6.d
    public final hn6.c a(hn6.b r110) {
        Intrinsics.checkNotNullParameter(r110, HiAnalyticsConstant.Direction.REQUEST);
        Object r100 = r110.f486112a.f450808b.b();
        CheckReason r101 = CheckReason.SUCCESS;
        boolean r102 = false;
        if ((r100 instanceof JSONObject) == false) goto L15;
        String r103 = ((JSONObject) r100).optString("btm_pre");
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L29;
        r102 = !StringsKt.contains$default(r103, "c0.d0", false, 2, null);
    L29:
        if (r102 == true) goto L32;
        r101 = CheckReason.COVER_BTM_PRE_CD_NULL;
    L32:
        return new hn6.c(r102, r101, r110);
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    L15:
        if ((r100 instanceof Map) == false) goto L29;
        Object r105 = ((Map) r100).get("btm_pre");
        if ((r105 instanceof String) == false) goto L19;
        String r106 = (String) r105;
    L20:
        if (r106 != null) goto L22;
    L25:
        boolean r107 = true;
    L26:
        if (r107 == true) goto L29;
        r102 = !StringsKt.contains$default(r106, "c0.d0", false, 2, null);
        goto L29
    L22:
        if (r106.length() == 0) goto L25;
        r107 = false;
        goto L26
    L19:
        r106 = null;
        goto L20
    }
}
