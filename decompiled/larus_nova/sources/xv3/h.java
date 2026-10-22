package xv3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.api.navi.AppletNaviRideType;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.utils.o0;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f565166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f565167b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f565168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f565169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f565170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AlertDialog f565171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Pair<String, Function0<Unit>>> f565172g = null;

    public h() {
    }

    static {
        f565166a = new h();
        f565167b = h.class.getSimpleName();
        f565172g = new ArrayList();
    }

    public static boolean b(Context r100, String r101) {
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L15;
        return false;
    L15:
        if (r100.getPackageManager().getPackageInfo(r101, 0) != null) goto L13;
        r102 = false;
    L13:
        return r102;
    L17:
        return false;
    L5:
        r103 = false;
        goto L6
    }

    public static void a(Context r100, Location r101, NavigateMode r110, Location r111) {
        if (f565168c == true) goto L34;
        Intent r112 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("market://details?id=com.autonavi.minimap"));
        if (r112.resolveActivity(r100.getPackageManager()) == null) goto L32;
        r100.startActivity(r112);
        return;
    L32:
        com.bytedance.ai.utils.g.f37637a.e(f565167b, "can not find market app");
        return;
    L34:
    L27:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e(f565167b, "[callUpAMapApp] with error msg:" + e.getMessage());
        return;
    L5:
        if (r101.getLat() != null) goto L7;
        return;
    L7:
        if (r101.getLng() == null) goto L36;
        int r102 = wq9.d.f560766a;     // Catch: URISyntaxException -> L27
        Double r103 = r101.getLat();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        double r104 = r103.doubleValue();     // Catch: URISyntaxException -> L27
        Double r105 = r101.getLng();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        wq9.a r106 = wq9.d.a(r104, r105.doubleValue());     // Catch: URISyntaxException -> L27
        Intent r107 = new Intent();     // Catch: URISyntaxException -> L27
        r107.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: URISyntaxException -> L27
        r107.addCategory("android.intent.category.DEFAULT");     // Catch: URISyntaxException -> L27
        Uri.Builder r108 = new Uri.Builder().scheme("androidamap").authority(CloudControlInf.ROUTE).path("plan").appendQueryParameter("sourceApplication", BytedCertConstant.CertKey.FLOW).appendQueryParameter("dev", "1").appendQueryParameter("t", String.valueOf(r4.g.a(r110))).appendQueryParameter("dlat", String.valueOf(r106.f560759a)).appendQueryParameter("dlon", String.valueOf(r106.f560760b));     // Catch: URISyntaxException -> L27
        if (o0.d(r101.getName()) == false) goto L12;
        r108.appendQueryParameter("dname", r101.getName());     // Catch: URISyntaxException -> L27
    L12:
        if (r111 == null) goto L22;
        if (o0.d(r111.getName()) == false) goto L17;
        r108.appendQueryParameter("sname", r111.getName());     // Catch: URISyntaxException -> L27
    L17:
        if (r111.getLat() == null) goto L22;
        if (r111.getLng() == null) goto L22;
        Double r109 = r111.getLat();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        double r113 = r109.doubleValue();     // Catch: URISyntaxException -> L27
        Double r114 = r111.getLng();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        wq9.a r115 = wq9.d.a(r113, r114.doubleValue());     // Catch: URISyntaxException -> L27
        r108.appendQueryParameter("slat", String.valueOf(r115.f560759a));     // Catch: URISyntaxException -> L27
        r108.appendQueryParameter("slon", String.valueOf(r115.f560760b));     // Catch: URISyntaxException -> L27
    L22:
        if (r110 != NavigateMode.RIDING) goto L24;
        r108.appendQueryParameter("rideType", AppletNaviRideType.BIKE);     // Catch: URISyntaxException -> L27
    L24:
        r107.setData(r108.build());     // Catch: URISyntaxException -> L27
        r100.startActivity(r107);     // Catch: URISyntaxException -> L27
        return;
    }
}
