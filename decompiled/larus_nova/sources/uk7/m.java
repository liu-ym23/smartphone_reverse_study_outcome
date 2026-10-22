package uk7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile m f550546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f550547c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Long> f550548a;

    static {
        f550547c = Arrays.asList(new String[]{"/invoke/getCaseList", "/invoke/getProductionList", "/invoke/getGroupCaseList", "/invoke/createReport"});
    }

    public static m b() {
        if (f550546b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f550546b != null) goto L9;
        f550546b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f550546b;
    }

    public m() {
    }

    public static String a(String r100) {
        qm7.d r101 = qm7.d.a.f533911a;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L21:
        return "";
    L6:
        if (r101.f533906b != null) goto L8;
        List r102 = new ArrayList();
    L9:
        if (r102 == null) goto L21;
        if (r102.size() <= 0) goto L21;
        Iterator r103 = r102.iterator();
    L15:
        if (r103.hasNext() == false) goto L21;
        tm7.a.C7743a r104 = (tm7.a.C7743a) r103.next();
        if (r104 == null) goto L15;
        if (r100.equals(r104.activityId) == false) goto L15;
        return r104.actHash;
    L8:
        r102 = r101.f533906b.activityInfos;
        goto L9
    }

    public static void c(Map r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NetworkManager", "putCommonParams called");
        if (r100 != null) goto L5;
        r100 = new HashMap();
    L5:
        tm7.b.c(r100);
        if (tm7.b.b(r100) == true) goto L8;
        um7.e.a("tryPutCommonParams() 通参存在空");
        um7.d.a("putCommon", "", r100);
    L8:
        r100.put("luckydog_sdk_version", il7.h.c());
        r100.put("luckydog_api_version", "8.75.0-rc.12-db");
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r101 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        r100.put("static_settings_version", String.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.STATIC)));
        r100.put("dynamic_settings_version", String.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.DYNAMIC)));
        r100.put("polling_settings_version", String.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.POLL)));
    }
}
