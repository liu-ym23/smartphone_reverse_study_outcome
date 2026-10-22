package hc4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    public static final String i() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        DisplayMetrics r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.getApplicationContext();
    L6:
        if (r102 == null) goto L10;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L10;
        r101 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
    L10:
        int r104 = 0;
        if (r101 == null) goto L13;
        int r105 = r101.widthPixels;
    L14:
        if (r101 == null) goto L16;
        r104 = r101.heightPixels;
    L16:
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        r106.append('*');
        r106.append(r104);
        return r106.toString();
    L13:
        r105 = 0;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public static final StringBuilder e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        StringBuilder r101 = new StringBuilder();
        ArrayList r102 = new ArrayList();
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();
        String r105 = JSONObjectProtectorUtils.getString(r100, r104);     // Catch: Exception -> L8
    L10:
        r102.add(new Pair(r104, r105));
    L8:
        e = move-exception;
        e.printStackTrace();
        r105 = null;
        goto L10
    L11:
        r101.append(NetworkUtils.format(r102, "UTF-8"));
        return r101;
    }

    public static final Point f(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Rect r101 = new Rect();
        View r102 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L7:
        r102.getWindowVisibleDisplayFrame(r101);
        return new Point(r101.width(), r101.height());
    }

    public static final int g(Activity r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.getWindowManager().getDefaultDisplay().getRotation();
        int r102 = n.f532367a;
        if (r101 != 0) goto L8;
        return 2;
    L8:
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L11;
        return 2;
    L11:
        if (r101 == 3) goto L13;
        return 0;
    L13:
        return 1;
    }

    public static final float h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Method r101 = DisplayMetrics.class.getDeclaredMethod("getDeviceDensity", new Class[0]);     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Exception -> L8
        if (r102 == null) goto L7;
        return ((Integer) r102).intValue() / 160.0f;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        Resources r103 = r100.getApplicationContext().getResources();
        return WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
    }

    public static final void a(StringBuilder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("verify_host", "key");
        if (r101 != null) goto L10;
        return;
    L10:
        r100.append("verify_host");     // Catch: UnsupportedEncodingException -> L7
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: UnsupportedEncodingException -> L7
        r100.append(URLEncoder.encode(r101, XML.CHARSET_UTF8));     // Catch: UnsupportedEncodingException -> L7
        return;
    L7:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static final StringBuilder d(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "params");
        StringBuilder r102 = new StringBuilder(r100);
        if (StringsKt.indexOf$default(r100, '?', 0, false, 6, null) >= 0) goto L5;
        r102.append("?");
    L6:
        ArrayList r103 = new ArrayList();
        Iterator<String> r104 = r101.keys();
    L8:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        String r106 = JSONObjectProtectorUtils.getString(r101, r105);     // Catch: Exception -> L12
    L14:
        r103.add(new Pair(r105, r106));
    L12:
        e = move-exception;
        e.printStackTrace();
        r106 = null;
        goto L14
    L15:
        r102.append(NetworkUtils.format(r103, "UTF-8"));
        return r102;
    L5:
        r102.append("&");
        goto L6
    }

    public static final void b(StringBuilder r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        c(r100, r101, String.valueOf(r102));
    }

    public static final void c(StringBuilder r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L10;
        return;
    L10:
        r100.append("&");     // Catch: UnsupportedEncodingException -> L7
        r100.append(r101);     // Catch: UnsupportedEncodingException -> L7
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: UnsupportedEncodingException -> L7
        r100.append(URLEncoder.encode(r102, XML.CHARSET_UTF8));     // Catch: UnsupportedEncodingException -> L7
        return;
    L7:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }
}
