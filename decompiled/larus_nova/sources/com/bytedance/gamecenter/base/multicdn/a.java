package com.bytedance.gamecenter.base.multicdn;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.gamecenter.base.r;
import com.bytedance.gamecenter.base.w;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245008a = 0;

    static {
    }

    public static void c(List r110) {
        if (r110 == null) goto L8;
        if (((ArrayList) r110).isEmpty() != true) goto L8;
        return;
    L8:
        if (r110 == null) goto L14;
        Object[] r100 = r110.toArray(new String[0]);
        if (r100 == null) goto L13;
        Arrays.toString((String[]) r100);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        ArrayList r102 = null;
        if (r110 == null) goto L23;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r110.iterator();
    L18:
        if (r104.hasNext() == false) goto L22;
        Object r105 = r104.next();
        if ((!StringsKt.contains$default((String) r105, "lf9-apk-open.bytesmanager.com", false, 2, null)) == false) goto L18;
        r103.add(r105);
        goto L18
    L22:
        r102 = r103;
    L23:
        if (r102 == null) goto L26;
        ArrayList r106 = (ArrayList) r110;
        r106.clear();
        r106.addAll(r102);
    L26:
        if (r110 == null) goto L32;
        Object[] r111 = r110.toArray(new String[0]);
        if (r111 == null) goto L31;
        Arrays.toString((String[]) r111);
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L32:
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
    }

    public static String e(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return "";
    L12:
        return Intrinsics.stringPlus(UriProtector.parse(r100).getHost(), UriProtector.parse(r100).getPath());
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void b(List r100, String r101) {
        Lazy r102 = GMultiCDNDownloadOpt.f245007a;
        if (r100 == null) goto L32;
        Object[] r103 = r100.toArray(new String[0]);     // Catch: Exception -> L28
        if (r103 == null) goto L27;
        Arrays.toString(r103);     // Catch: Exception -> L28
        boolean r104 = r.f245056a;     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");     // Catch: Exception -> L28
        JSONObject r105 = w.b();     // Catch: Exception -> L28
        if (r105 == null) goto L11;
        int r106 = r105.optInt(BdpAppEventConstant.PARAMS_STRATEGY_NAME, 0);     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");     // Catch: Exception -> L28
    L13:
        if (r106 != 1) goto L15;
    L20:
        GMultiCDNDownloadOpt.a(r100, r101);     // Catch: Exception -> L28
    L21:
        Object[] r107 = r100.toArray(new String[0]);     // Catch: Exception -> L28
        if (r107 == null) goto L25;
        Arrays.toString(r107);     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");     // Catch: Exception -> L28
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L28
    L15:
        if (r106 == 2) goto L20;
        if (r106 != 3) goto L21;
        GMultiCDNDownloadOpt.b(r100, r101);     // Catch: Exception -> L28
        goto L21
    L11:
        r106 = 0;
        goto L13
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L28
    L28:
        boolean r108 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        return;
    }

    public static void a(String r100, List r101, String r102, List r103, String r110, List r111, String r112, List r113) {
    L30:
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        return;
    L5:
        if (r101 == null) goto L11;
        Object[] r105 = r101.toArray(new String[0]);     // Catch: Exception -> L30
        if (r105 == null) goto L10;
        Arrays.toString((String[]) r105);     // Catch: Exception -> L30
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L30
    L11:
        boolean r106 = r.f245056a;     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");     // Catch: Exception -> L30
        int r107 = w.c();     // Catch: Exception -> L30
        if (r107 != 0) goto L14;
        b(r101, r100);     // Catch: Exception -> L30
    L22:
        if (r101 == null) goto L28;
        Object[] r108 = r101.toArray(new String[0]);     // Catch: Exception -> L30
        if (r108 == null) goto L27;
        Arrays.toString((String[]) r108);     // Catch: Exception -> L30
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L30
    L28:
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");     // Catch: Exception -> L30
        return;
    L14:
        if (r107 != 1) goto L16;
        c(r101);     // Catch: Exception -> L30
        goto L22
    L16:
        if (r107 != 2) goto L22;
        d(r100, r101, r102, r103, r110, r111, r112, r113);     // Catch: Exception -> L30
        goto L22
    }

    public static void d(String r100, List r101, String r102, List r103, String r104, List r105, String r106, List r110) {
        if (r100 != null) goto L4;
    L7:
        boolean r107 = true;
    L8:
        if (r107 == false) goto L10;
        return;
    L10:
        String r108 = e(r100);
        String r109 = e(r102);
        String r111 = e(r104);
        String r112 = e(r106);
        boolean r113 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        if (Intrinsics.areEqual(r108, r109) == false) goto L19;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        if (r103 == null) goto L35;
        if (r101 == null) goto L16;
        ((ArrayList) r101).clear();
    L16:
        if (r101 == null) goto L36;
        ((ArrayList) r101).addAll(r103);
        return;
    L36:
        return;
    L35:
        return;
    L19:
        if (Intrinsics.areEqual(r108, r111) == false) goto L27;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        if (r105 == null) goto L38;
        if (r101 == null) goto L24;
        ((ArrayList) r101).clear();
    L24:
        if (r101 == null) goto L39;
        ((ArrayList) r101).addAll(r105);
        return;
    L39:
        return;
    L38:
        return;
    L27:
        if (Intrinsics.areEqual(r108, r112) == false) goto L41;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        if (r110 == null) goto L42;
        if (r101 == null) goto L32;
        ((ArrayList) r101).clear();
    L32:
        if (r101 == null) goto L43;
        ((ArrayList) r101).addAll(r110);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r107 = false;
        goto L8
    }
}
