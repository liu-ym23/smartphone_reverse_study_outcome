package gu;

import com.bytedance.android.gamecp.common.setting.LiveInfraSettingKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<a> f482734a;

    public c() {
    }

    public static List a() {
        Boolean r100 = Boolean.TRUE;
        return CollectionsKt.mutableListOf(new a[]{new a("live_offline_patterns", r100), new a("live_gurd_patterns", r100)});
    }

    static {
        f482734a = new ArrayList();
    }

    public static List b() {
    L6:
        e = move-exception;
        yr.b.d("LiveKevaKeyList", null, e);
    L9:
        return LiveInfraSettingKeys.KEVA_REMOTE_CONFIG_SETTING_KEY.getSpValue();
    L3:
        if ((!f482734a.isEmpty()) == false) goto L9;
        return f482734a;
    }
}
