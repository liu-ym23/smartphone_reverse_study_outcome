package xv3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.o0;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final h a = null;
    public static final String b = null;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static AlertDialog f;
    public static final List<Pair<String, Function0<Unit>>> g = null;

    public h() {
    }

    static {
        a = new h();
        b = h.class.getSimpleName();
        g = new ArrayList();
    }

    public static boolean b(Context r3, String r4) {
        boolean r1 = true;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        return false;
    L15:
        if (r3.getPackageManager().getPackageInfo(r4, 0) != null) goto L13;
        r1 = false;
    L13:
        return r1;
    L17:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(Context r8, Location r9, NavigateMode r10, Location r11) {
        if (c == true) goto L34;
        Intent r12 = new Intent("android.intent.action.VIEW", UriProtector.parse("market://details?id=com.autonavi.minimap"));
        if (r12.resolveActivity(r8.getPackageManager()) == null) goto L32;
        r8.startActivity(r12);
        return;
    L32:
        com.bytedance.ai.utils.g.a.e(b, "can not find market app");
        return;
    L34:
    L27:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e(b, "[callUpAMapApp] with error msg:" + e.getMessage());
        return;
    L5:
        if (r9.getLat() != null) goto L7;
        return;
    L7:
        if (r9.getLng() == null) goto L36;
        int r1 = wq9.d.a;     // Catch: URISyntaxException -> L27
        Double r2 = r9.getLat();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        double r3 = r2.doubleValue();     // Catch: URISyntaxException -> L27
        Double r4 = r9.getLng();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        wq9.a r5 = wq9.d.a(r3, r4.doubleValue());     // Catch: URISyntaxException -> L27
        Intent r6 = new Intent();     // Catch: URISyntaxException -> L27
        r6.setAction("android.intent.action.VIEW");     // Catch: URISyntaxException -> L27
        r6.addCategory("android.intent.category.DEFAULT");     // Catch: URISyntaxException -> L27
        Uri.Builder r7 = new Uri.Builder().scheme("androidamap").authority("route").path("plan").appendQueryParameter("sourceApplication", "flow").appendQueryParameter("dev", CommentScene.COMMENTSCENE_NO_AWEME).appendQueryParameter("t", String.valueOf(r4.g.a(r10))).appendQueryParameter("dlat", String.valueOf(r5.a)).appendQueryParameter("dlon", String.valueOf(r5.b));     // Catch: URISyntaxException -> L27
        if (o0.d(r9.getName()) == false) goto L12;
        r7.appendQueryParameter("dname", r9.getName());     // Catch: URISyntaxException -> L27
    L12:
        if (r11 == null) goto L22;
        if (o0.d(r11.getName()) == false) goto L17;
        r7.appendQueryParameter("sname", r11.getName());     // Catch: URISyntaxException -> L27
    L17:
        if (r11.getLat() == null) goto L22;
        if (r11.getLng() == null) goto L22;
        Double r13 = r11.getLat();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        double r14 = r13.doubleValue();     // Catch: URISyntaxException -> L27
        Double r15 = r11.getLng();     // Catch: URISyntaxException -> L27
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Double");     // Catch: URISyntaxException -> L27
        wq9.a r16 = wq9.d.a(r14, r15.doubleValue());     // Catch: URISyntaxException -> L27
        r7.appendQueryParameter("slat", String.valueOf(r16.a));     // Catch: URISyntaxException -> L27
        r7.appendQueryParameter("slon", String.valueOf(r16.b));     // Catch: URISyntaxException -> L27
    L22:
        if (r10 != NavigateMode.RIDING) goto L24;
        r7.appendQueryParameter("rideType", "bike");     // Catch: URISyntaxException -> L27
    L24:
        r6.setData(r7.build());     // Catch: URISyntaxException -> L27
        r8.startActivity(r6);     // Catch: URISyntaxException -> L27
        return;
    }
}
