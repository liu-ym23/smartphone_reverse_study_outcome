package com.larus.dora.impl.alive;

import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.huawei.hms.android.SystemUtils;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f332013a = null;

    static {
        f332013a = LazyKt.lazy(new k());
    }

    public static final i a() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        g49.d.d("DoraKeepAlive", "getKeepAliveEntry: manufacturer=".concat(r100));
        Locale r101 = Locale.ROOT;
        String r102 = r100.toUpperCase(r101);
        switch(r102.hashCode()) {
            case -1712043046: goto L29;
            case -1706170181: goto L25;
            case 2432928: goto L21;
            case 2634924: goto L17;
            case 68924490: goto L13;
            case 2141820391: goto L9;
            default: goto L32;
        };
    L32:
        List r103 = CollectionsKt.listOf(new j("res:///2131240392", ""));
        String r104 = r100.toUpperCase(r101);
        if (Intrinsics.areEqual(r104, "REALME") == false) goto L36;
        int r105 = j0.f375426a;
        j r106 = new j(b("realme.png"), j0.d(R.string.larus_dora_keep_alive_auto_start_realme_cn));
    L40:
        return new i(FlowDoraWifiScene.OTHER, r103, CollectionsKt.listOf(r106));
    L36:
        if (Intrinsics.areEqual(r104, RomUtils.ROM_ONEPLUS) == false) goto L38;
        int r107 = j0.f375426a;
        r106 = new j(b("oneplus.png"), j0.d(R.string.larus_dora_keep_alive_auto_start_oneplus_cn));
        goto L40
    L38:
        r106 = new j("", "");
        goto L40
    L9:
        if (r102.equals(SystemUtils.PRODUCT_HUAWEI) == false) goto L32;
        String r108 = b("dora_keep_alive_multi_task_locked_huawei_1_cn");
        int r109 = j0.f375426a;
        return new i(SystemUtils.PRODUCT_HUAWEI, CollectionsKt.listOf(new j[]{new j(r108, j0.d(R.string.larus_dora_keep_alive_multi_task_locked_huawei_1_cn)), new j(b("dora_keep_alive_multi_task_locked_huawei_2_cn"), j0.d(R.string.larus_dora_keep_alive_multi_task_locked_huawei_2_cn))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_huawei_1_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_huawei_1_cn)), new j(b("dora_keep_alive_auto_start_huawei_2_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_huawei_2_cn)), new j(b("dora_keep_alive_auto_start_huawei_3_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_huawei_3_cn))}));
    L13:
        if (r102.equals(SystemUtils.PRODUCT_HONOR) == false) goto L32;
        String r110 = b("dora_keep_alive_multi_task_locked_honor_1_cn");
        int r111 = j0.f375426a;
        return new i(SystemUtils.PRODUCT_HONOR, CollectionsKt.listOf(new j[]{new j(r110, j0.d(R.string.larus_dora_keep_alive_multi_task_locked_honor_1_cn)), new j(b("dora_keep_alive_multi_task_locked_honor_2_cn"), j0.d(R.string.larus_dora_keep_alive_multi_task_locked_honor_2_cn))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_honor_1_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_honor_1_cn)), new j(b("dora_keep_alive_auto_start_honor_2_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_honor_2_cn)), new j(b("dora_keep_alive_auto_start_honor_3_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_honor_3_cn))}));
    L17:
        if (r102.equals("VIVO") == false) goto L32;
        String r112 = b("dora_keep_alive_multi_task_locked_vivo_1_cn");
        int r113 = j0.f375426a;
        return new i("VIVO", CollectionsKt.listOf(new j(r112, j0.d(R.string.larus_dora_keep_alive_multi_task_locked_vivo_1_cn))), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_vivo_1_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_vivo_1_cn)), new j(b("dora_keep_alive_auto_start_vivo_2_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_vivo_2_cn)), new j(b("dora_keep_alive_auto_start_vivo_3_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_vivo_3_cn))}));
    L21:
        if (r102.equals("OPPO") == false) goto L32;
        String r114 = b("dora_keep_alive_multi_task_locked_oppo_1_cn");
        int r115 = j0.f375426a;
        return new i("OPPO", CollectionsKt.listOf(new j[]{new j(r114, j0.d(R.string.larus_dora_keep_alive_multi_task_locked_oppo_1_cn)), new j(b("dora_keep_alive_multi_task_locked_oppo_2_cn"), j0.d(R.string.larus_dora_keep_alive_multi_task_locked_oppo_2_cn))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_oppo_1_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_oppo_1_cn)), new j(b("dora_keep_alive_auto_start_oppo_2_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_oppo_2_cn))}));
    L25:
        if (r102.equals("XIAOMI") == false) goto L32;
        String r116 = b("dora_keep_alive_multi_task_locked_xiaomi_1_cn");
        int r117 = j0.f375426a;
        return new i("XIAOMI", CollectionsKt.listOf(new j(r116, j0.d(R.string.larus_dora_keep_alive_multi_task_locked_xiaomi_1_cn))), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_xiaomi_1_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_xiaomi_1_cn)), new j(b("dora_keep_alive_auto_start_xiaomi_2_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_xiaomi_2_cn))}));
    L29:
        if (r102.equals("SAMSUNG") == false) goto L32;
        String r118 = b("dora_keep_alive_multi_task_locked_samsung_1_cn");
        int r119 = j0.f375426a;
        return new i("SAMSUNG", CollectionsKt.listOf(new j[]{new j(r118, j0.d(R.string.larus_dora_keep_alive_multi_task_locked_samsung_1_cn)), new j(b("dora_keep_alive_multi_task_locked_samsung_2_cn"), j0.d(R.string.larus_dora_keep_alive_multi_task_locked_samsung_2_cn))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_samsung_1_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_samsung_1_cn)), new j(b("dora_keep_alive_auto_start_samsung_2_cn"), j0.d(R.string.larus_dora_keep_alive_auto_start_samsung_2_cn))}));
    }

    public static final String b(String r100) {
        String r101 = (String) f332013a.getValue();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r101 = "https://lf-dora-heartbeat.olafriend.com/obj/dora-heartbeat/";
    L9:
        if (StringsKt.endsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == false) goto L12;
        return r101 + r100 + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
    L12:
        return r101 + '/' + r100 + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
    L5:
        r102 = false;
        goto L6
    }
}
