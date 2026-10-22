package hc4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final String i() {
        BdTuringConfig r0 = qb4.b.c.a.a;
        DisplayMetrics r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getApplicationContext();
    L6:
        if (r2 == null) goto L10;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L10;
        r1 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
    L10:
        int r4 = 0;
        if (r1 == null) goto L13;
        int r5 = r1.widthPixels;
    L14:
        if (r1 == null) goto L16;
        r4 = r1.heightPixels;
    L16:
        StringBuilder r6 = new StringBuilder();
        r6.append(r5);
        r6.append('*');
        r6.append(r4);
        return r6.toString();
    L13:
        r5 = 0;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public static final StringBuilder e(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r6.keys();
    L4:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        String r4 = JSONObjectProtectorUtils.getString(r6, r3);     // Catch: Exception -> L8
    L10:
        r1.add(new Pair(r3, r4));
    L8:
        e = move-exception;
        e.printStackTrace();
        r4 = null;
        goto L10
    L11:
        r0.append(NetworkUtils.format(r1, "UTF-8"));
        return r0;
    }

    public static final Point f(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Rect r0 = new Rect();
        View r5 = r4.getWindow().getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == c.a) goto L7;
        c.a(r1, "getDecorView");
    L7:
        r5.getWindowVisibleDisplayFrame(r0);
        return new Point(r0.width(), r0.height());
    }

    public static final int g(Activity r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r4 = r3.getWindowManager().getDefaultDisplay().getRotation();
        int r1 = n.a;
        if (r4 != 0) goto L8;
        return 2;
    L8:
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L11;
        return 2;
    L11:
        if (r4 == 3) goto L13;
        return 0;
    L13:
        return 1;
    }

    public static final float h(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Method r0 = DisplayMetrics.class.getDeclaredMethod("getDeviceDensity", new Class[0]);     // Catch: Exception -> L8
        r0.setAccessible(true);     // Catch: Exception -> L8
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return ((Integer) r1).intValue() / 160.0f;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        Resources r5 = r4.getApplicationContext().getResources();
        return WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
    }

    public static final void a(StringBuilder r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter("verify_host", "key");
        if (r3 != null) goto L10;
        return;
    L10:
        r2.append("verify_host");     // Catch: UnsupportedEncodingException -> L7
        r2.append("=");     // Catch: UnsupportedEncodingException -> L7
        r2.append(URLEncoder.encode(r3, "utf-8"));     // Catch: UnsupportedEncodingException -> L7
        return;
    L7:
        e = move-exception;
        int r4 = n.a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static final StringBuilder d(String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "params");
        StringBuilder r0 = new StringBuilder(r7);
        if (StringsKt.indexOf$default(r7, '?', 0, false, 6, null) >= 0) goto L5;
        r0.append("?");
    L6:
        ArrayList r9 = new ArrayList();
        Iterator<String> r1 = r8.keys();
    L8:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();
        String r3 = JSONObjectProtectorUtils.getString(r8, r2);     // Catch: Exception -> L12
    L14:
        r9.add(new Pair(r2, r3));
    L12:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L14
    L15:
        r0.append(NetworkUtils.format(r9, "UTF-8"));
        return r0;
    L5:
        r0.append("&");
        goto L6
    }

    public static final void b(StringBuilder r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        c(r1, r2, String.valueOf(r3));
    }

    public static final void c(StringBuilder r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L10;
        return;
    L10:
        r1.append("&");     // Catch: UnsupportedEncodingException -> L7
        r1.append(r2);     // Catch: UnsupportedEncodingException -> L7
        r1.append("=");     // Catch: UnsupportedEncodingException -> L7
        r1.append(URLEncoder.encode(r3, "utf-8"));     // Catch: UnsupportedEncodingException -> L7
        return;
    L7:
        e = move-exception;
        int r4 = n.a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }
}
