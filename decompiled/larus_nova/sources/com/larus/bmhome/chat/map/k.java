package com.larus.bmhome.chat.map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f306889a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f306890b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static double f306891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static double f306892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f306893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f306894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f306895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f306896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<Pair<String, Function0<Unit>>> f306897i = null;

    public k() {
    }

    static {
        f306889a = new k();
        f306890b = k.class.getSimpleName();
        f306893e = "";
        f306897i = new ArrayList();
    }

    public static void b(Context r100) {
        if (f306894f == true) goto L13;
        Intent r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("market://details?id=com.autonavi.minimap"));
        if (r101.resolveActivity(r100.getPackageManager()) == null) goto L11;
        r100.startActivity(r101);
        return;
    L11:
        FLogger.f375446a.e(f306890b, "can not find market app:com.autonavi.minimap");
        return;
    L13:
        int r102 = wq9.d.f560766a;     // Catch: URISyntaxException -> L6
        wq9.a r103 = wq9.d.a(f306891c, f306892d);     // Catch: URISyntaxException -> L6
        Intent r104 = new Intent();     // Catch: URISyntaxException -> L6
        r104.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: URISyntaxException -> L6
        r104.addCategory("android.intent.category.DEFAULT");     // Catch: URISyntaxException -> L6
        r104.setData(UriProtector.parse("androidamap://route?&sourceApplication=Flow&dname=" + f306893e + "&dlat=" + r103.f560759a + "&dlon=" + r103.f560760b + "&dev=1&t=0"));     // Catch: URISyntaxException -> L6
        r100.startActivity(r104);     // Catch: URISyntaxException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean c(Context r100, String r101) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context r100, double r101, double r102, String r103, final Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        f306891c = r101;
        f306892d = r102;
        f306893e = r103;
        ArrayList r105 = (ArrayList) f306897i;
        r105.clear();
        f306894f = c(r100, MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);
        f306895g = c(r100, MapRouteService.MapPackageName.PACKAGE_NAME_QQMAP);
        f306896h = c(r100, MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP);
        if (f306894f == false) goto L6;
        r105.add(new Pair(r100.getString(R.string.larus_map_plugin_open_autonavi_map), new g(r100)));
    L6:
        if (f306895g == false) goto L9;
        r105.add(new Pair(r100.getString(R.string.larus_map_plugin_open_tencent_map), new h(r100)));
    L9:
        if (f306896h == false) goto L12;
        r105.add(new Pair(r100.getString(R.string.larus_map_plugin_open_baidu_map), new i(r100)));
    L12:
        if (r105.isEmpty() == false) goto L18;
        StringBuilder r106 = new StringBuilder();
        r106.append(r100.getString(R.string.larus_gold_map));
        if (f306894f == false) goto L16;
        String r107 = "";
    L17:
        r106.append(r107);
        r105.add(new Pair(r106.toString(), new j(r100)));
        goto L18
    L16:
        r107 = r100.getString(R.string.larus_not_install);
    L18:
        String[] r108 = new String[r105.size()];
        int r109 = r105.size();
        int r110 = 0;
    L19:
        if (r110 >= r109) goto L21;
        r108[r110] = ((Pair) ListProtector.get(f306897i, r110)).getFirst();
        r110 = r110 + 1;
        goto L19
    L21:
        AlertDialog r111 = new AlertDialog.Builder(r100).setTitle(r100.getString(R.string.larus_select_map)).setItems(r108, new f(r104)).create();
        if (DialogLancet.shouldBlockDialogShow(r111) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r111);
        return;
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        DialogLancet.beforeDialogShow(r111);
        r111.show();
        DialogLancet.afterDialogShow(r111);
    }
}
