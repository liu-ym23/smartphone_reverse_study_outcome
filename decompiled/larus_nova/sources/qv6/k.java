package qv6;

import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import java.util.LinkedHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f534921a = 0;

    static {
    }

    public static void a(boolean r100, String r101, long r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "url");
        LinkedHashMap r105 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r106 = "success";
    L6:
        r105.put("status", r106);
        r105.put("url", r101);
        r105.put("duration", String.valueOf(r102));
        if (r103 == null) goto L9;
        String r107 = (String) r105.put("message", r103);
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 == false) goto L17;
        r104 = LiveLocalLifeUtil.g();
    L17:
        r105.put("gecko_id", r104);
        int r109 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("live_life_lynx_view_load", MapsKt.toMap(r105));
        return;
    L11:
        if (r104.length() == 0) goto L14;
        r108 = false;
        goto L15
    L5:
        r106 = "fail";
        goto L6
    }
}
