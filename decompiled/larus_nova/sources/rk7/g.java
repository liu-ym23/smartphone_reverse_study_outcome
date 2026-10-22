package rk7;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f538340a = 0;

    public static void a() {
        Context r100 = m.f538361o.e();
        fk7.d r101 = fk7.c.b(ILuckyDogSettingsService.class);
        if ((r101 instanceof ILuckyDogSettingsService) == true) goto L5;
        r101 = null;
    L5:
        ILuckyDogSettingsService r102 = (ILuckyDogSettingsService) r101;
        if (r102 == null) goto L8;
        Object r103 = r102.getSettingsByKey(ILuckyDogCommonSettingsService.Channel.STATIC, "data.common_info.extra.remove_data");
    L10:
        if ((r103 instanceof String) == true) goto L54;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("FirstScreenDataCleanManager", "remove data is config error");
        return;
    L54:
        JSONArray r104 = new JSONArray((String) r103);     // Catch: Exception -> L50
        int r105 = r104.length();
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L69;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r104, r106);
        String r108 = r107.optString("type");
        JSONArray r109 = r107.optJSONArray("keys");
        if (r109 == null) goto L19;
        ArrayList r110 = new ArrayList();
        int r111 = r109.length();
        int r112 = 0;
    L17:
        if (r112 >= r111) goto L20;
        r110.add(r109.optString(r112));
        r112 = r112 + 1;
    L20:
        long r113 = r107.optLong("version");
        if (r110 == null) goto L49;
        Iterator r114 = r110.iterator();
    L24:
        if (r114.hasNext() == false) goto L49;
        String r115 = (String) r114.next();
        long r116 = il7.m.a().d(b(r108, r115), -1);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("FirstScreenDataCleanManager", "key is:" + r115 + "&localVersion:" + r116 + "&version:" + r113);
        if (r116 >= r113) goto L47;
        int r117 = r108.hashCode();
        if (r117 == (-1672220236)) goto L44;
        if (r117 == (-1288666633)) goto L41;
        if (r117 != 1871131410) goto L48;
        if (r108.equals("cat_storage") == false) goto L48;
        bk7.a r118 = (bk7.a) hn7.d.b(bk7.a.class);
        if (r118 == null) goto L39;
        r118.a(r115);
    L39:
        com.bytedance.ug.sdk.luckydog.api.log.d.a("FirstScreenDataCleanManager", "clean cat storage" + r115);
    L48:
        il7.m.a().j(b(r108, r115), r113);
        goto L24
    L41:
        if (r108.equals(ErrorType.PREFETCH) == false) goto L48;
        Application r119 = m.f538347a;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("FirstScreenDataCleanManager", "clean prefetch url:" + r115);
        goto L48
    L44:
        if (r108.equals("x_storage") == false) goto L48;
        if (r100 == null) goto L48;
        Application r120 = m.f538347a;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("FirstScreenDataCleanManager", "clean x storage" + r115);
        goto L48
    L47:
        com.bytedance.ug.sdk.luckydog.api.log.d.a("FirstScreenDataCleanManager", "local version >= server version,not need clean");
    L49:
        r106 = r106 + 1;
        goto L13
    L19:
        r110 = null;
        goto L20
    L69:
        return;
    L50:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("FirstScreenDataCleanManager", "remove data is not json array");
        return;
    L8:
        r103 = null;
        goto L10
    }

    static {
    }

    public static String b(String r100, String r101) {
        if (Intrinsics.areEqual(r100, ErrorType.PREFETCH) == false) goto L6;
        return r100 + DigestUtils.md5Hex(r101);
    L6:
        return r100 + r101;
    }
}
