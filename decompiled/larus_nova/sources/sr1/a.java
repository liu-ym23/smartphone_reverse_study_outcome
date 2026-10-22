package sr1;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import j40.f4;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import xs1.e;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f543203a = 0;

    static {
    }

    public static String b(Long r100) {
        long r101 = BusinessConfigure.BusinessType.WEAK_BARRAGE;
        if (r100 != null) goto L6;
    L8:
        long r102 = BusinessConfigure.BusinessType.STRONG_BARRAGE;
        if (r100 != null) goto L12;
    L14:
        long r103 = BusinessConfigure.BusinessType.SCREEN_BAR;
        if (r100 != null) goto L18;
    L20:
        return "";
    L18:
        if (r100.longValue() != r103) goto L20;
        return "pic";
    L12:
        if (r100.longValue() != r102) goto L14;
    L13:
        return "logo";
    L6:
        if (r100.longValue() != r101) goto L8;
        goto L8
    }

    public static boolean d(BusinessConfigure r100) {
        long r101 = System.currentTimeMillis() - r100.expectedShowTS;
        StringBuilder r102 = new StringBuilder("shouldDiscard expected show time ");
        r102.append(Long.valueOf(r100.expectedShowTS));
        r102.append(", current time ");
        r102.append(System.currentTimeMillis());
        r102.append(", waiting time ");
        r102.append(r101);
        r102.append(" discard duration ");
        SettingKey<e> r103 = VSSettingKeys.LIVE_BUSINESS_INFORMATION_CONFIG;
        r102.append(r103.getValue().a());
        ALogger.i("BusinessConfigure", r102.toString());
        if (r101 <= (r103.getValue().a() * 1000)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(String r100, BusinessConfigure r101) {
        if (v.a() == true) goto L5;
    L7:
        StringBuilder r102 = new StringBuilder();
        r102.append(String.valueOf(r100));
        r102.append("_");
        BusinessResourceConfigure r103 = r101.resourceConfig;
        if (r103 == null) goto L10;
        Long r104 = Long.valueOf(r103.resourceId);
    L11:
        r102.append(String.valueOf(r104));
        String r105 = r102.toString();
        if (r101.deliveryType == BusinessConfigure.DeliveryType.ENTER) goto L14;
    L25:
        return true;
    L14:
        if (r100 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L25;
        if (f4.f497218u.getValue().get(r105) == null) goto L25;
        ALogger.i("BusinessConfigure", "business resource already show, userid_resourceId is " + r105);
        return false;
    L16:
        if (r100.length() == 0) goto L19;
        r106 = false;
        goto L20
    L10:
        r104 = null;
        goto L11
    L5:
        if (VSSettingKeys.LIVE_BUSINESS_INFORMATION_CONFIG.getValue().d() == true) goto L7;
        return true;
    }

    public static void c(String r100, String r101, BusinessConfigure r102, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "pagePosition");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("position", "live");
        r103.put("position_page", r101);
        if (r110 == null) goto L5;
        r103.putAll(r110);
    L5:
        if (r102 == null) goto L12;
        r103.put(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, String.valueOf(r102.businessId));
        BusinessResourceConfigure r104 = r102.resourceConfig;
        if (r104 == null) goto L10;
        String r105 = String.valueOf(r104.resourceId);
        if (r105 == null) goto L10;
    L11:
        r103.put("resource_id", r105);
        r103.put("resource_scene", b(Long.valueOf(r102.businessType)));
    L10:
        r105 = "";
    L12:
        r.l().s(r100, r103, "", "", "");
    }
}
