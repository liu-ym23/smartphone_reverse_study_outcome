package gn6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckReason;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements hn6.d {
    public b() {
    }

    @Override // hn6.d
    public final hn6.c a(hn6.b r100) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        Object r101 = r100.f486112a.f450808b.b();
        CheckReason r102 = CheckReason.SUCCESS;
        if ((r101 instanceof JSONObject) == false) goto L6;
        boolean r103 = zn6.a.a(((JSONObject) r101).optString("btm"));
    L14:
        if (r103 == true) goto L17;
        r102 = CheckReason.COVER_BTM_NULL;
    L17:
        return new hn6.c(r103, r102, r100);
    L6:
        if ((r101 instanceof Map) == false) goto L13;
        Object r104 = ((Map) r101).get("btm");
        if ((r104 instanceof String) == false) goto L10;
        String r105 = (String) r104;
    L11:
        if (r105 == null) goto L13;
        r103 = zn6.a.a(r105);
        goto L14
    L10:
        r105 = null;
    L13:
        r103 = false;
        goto L14
    }
}
