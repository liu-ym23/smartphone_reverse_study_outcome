package kr0;

import com.bytedance.android.live.openplatform.api.utils.e;
import kotlin.jvm.internal.Intrinsics;
import tb1.c;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f505700a = null;

    static {
        if (c.f545231c == false) goto L5;
        String r100 = "ad_28001_live";
    L6:
        f505700a = r100;
        return;
    L5:
        r100 = "ad_40001_live";
        goto L6
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        int r101 = r100.hashCode();
        if (r101 == 993236629) goto L27;
        if (r101 == 993512319) goto L19;
        if (r101 == 1050044054) goto L10;
    L35:
        return "live_mg_link";
    L10:
        if (r100.equals("mg_detail") == false) goto L35;
        if (e.b() == false) goto L15;
        return f505700a + "_detail_dou+";
    L15:
        if (e.a() == true) goto L38;
        return "live_mg_detail";
    L38:
        return f505700a + "_detail";
    L19:
        if (r100.equals("mg_link") == false) goto L35;
        if (e.b() == false) goto L24;
        return f505700a + "_link_dou+";
    L24:
        if (e.a() == false) goto L35;
        return f505700a + "_link";
    L27:
        if (r100.equals("mg_card") == false) goto L35;
        if (e.b() == false) goto L32;
        return f505700a + "_card_dou+";
    L32:
        if (e.a() == true) goto L43;
        return "live_mg_card";
    L43:
        return f505700a + "_card";
    }
}
