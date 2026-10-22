package com.bytedance.badger.z;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n0 extends u0 {
    public n0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r110, BadgerModuleBase.BadgerRequestData r111) {
        String r100 = "";
        boolean r101 = false;
        String r102 = Build.BRAND;     // Catch: Throwable -> L42
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        String r103 = Build.MANUFACTURER;     // Catch: Throwable -> L42
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        String r104 = Build.PRODUCT;     // Catch: Throwable -> L42
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        String r105 = Build.DISPLAY;     // Catch: Throwable -> L42
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        String r112 = Build.FINGERPRINT;     // Catch: Throwable -> L42
        if (r112 != null) goto L18;
        r112 = "";
    L18:
        String r106 = r102 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r104 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r105 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112;     // Catch: Throwable -> L42
        Locale r107 = Locale.ENGLISH;     // Catch: Throwable -> L42
        String r108 = r106.toLowerCase(r107);     // Catch: Throwable -> L42
        if (r108.contains(DimLocationCheckUtil.VIVO) == false) goto L21;
    L41:
        boolean r109 = true;
    L44:
        if (r109 == false) goto L46;
        com.bytedance.badger.e.f("vivo#", "start execute vivo id...");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L50;
        com.bytedance.badger.utils.f r113 = com.bytedance.badger.utils.f.f199243d;
        Long r114 = Long.valueOf(r111.getToken());
        b0 r115 = new b0(this);
        r113.getClass();
        com.bytedance.badger.utils.b0 r116 = com.bytedance.badger.utils.f.b(r110, r114, r115);
        String r117 = r116.f199224a;
        if (r117 != null) goto L56;
        r117 = "";
    L56:
        if (r117.length() <= 0) goto L58;
        r101 = true;
    L58:
        if (r101 == true) goto L60;
        Integer r118 = r116.f199225b;
        if (r118 == null) goto L64;
        int r119 = r118.intValue();
    L65:
        String r120 = r116.f199226c;
        if (r120 == null) goto L69;
        r100 = r120;
    L69:
        return new BadgerResult.Failure(r119, r100);
    L64:
        r119 = -1003;
        goto L65
    L60:
        return new BadgerResult.Success(new DataString(r117));
    L50:
        return new BadgerResult.Failure(-1000, "cannot be called on the main thread.");
    L46:
        return new BadgerResult.Failure(-999, "not support");
    L21:
        if (r108.contains("iqoo") == true) goto L41;
        if (r108.contains("bbk") == true) goto L41;
        String r121 = (com.bytedance.badger.utils.y.b("ro.vivo.os.build.display.id") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + com.bytedance.badger.utils.y.b("ro.vivo.product.version") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + com.bytedance.badger.utils.y.b("ro.vivo.os.name") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + com.bytedance.badger.utils.y.b("ro.vivo.os.version")).toLowerCase(r107);     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r121) == true) goto L38;
        if (r121.contains(DimLocationCheckUtil.VIVO) == true) goto L41;
        if (r121.contains("iqoo") == true) goto L41;
        if (r121.contains("funtouch") == true) goto L41;
        if (r121.contains("originos") == true) goto L41;
    L38:
        if (r108.contains("funtouch") == true) goto L41;
        if (r108.contains("originos") == true) goto L41;
    L43:
        r109 = false;
        goto L44
    }
}
