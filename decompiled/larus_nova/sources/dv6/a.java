package dv6;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f470156a = null;

    /* JADX INFO: renamed from: dv6.a$a, reason: collision with other inner class name */
    public static final class C5711a {
    }

    public a() {
    }

    static {
        f470156a = CollectionsKt.listOf(new String[]{"/data/life/live/agg/card/detail/", "/data/life/live/agg/card/detail/paged/", "/data/life/live/agg/card/detail/prefetch/", "/data/life/live/agg/card/detail/prefetch/paged/", "/data/life/live/pack_life_component/", "/data/life/live/preview/pack_life_component/"});
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L79
        Request r101 = r110.request();     // Catch: Throwable -> L79
        SsResponse<?> r102 = r110.proceed(r101);     // Catch: Throwable -> L79
        long r103 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L79
        String r104 = r110.request().getPath();     // Catch: Throwable -> L79
        if (f470156a.contains(r104) == true) goto L6;
        return r102;
    L6:
        List r105 = CollectionsKt.filterNotNull(r102.headers());     // Catch: Throwable -> L79
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));     // Catch: Throwable -> L79
        Iterator r107 = r105.iterator();     // Catch: Throwable -> L79
    L8:
        if (r107.hasNext() == false) goto L10;
        Object r108 = r107.next();     // Catch: Throwable -> L79
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.retrofit2.client.Header");     // Catch: Throwable -> L79
        r106.add((Header) r108);     // Catch: Throwable -> L79
        goto L8
    L10:
        Iterator r109 = r106.iterator();     // Catch: Throwable -> L79
    L12:
        String r111 = null;
        if (r109.hasNext() == false) goto L22;
        Object r112 = r109.next();     // Catch: Throwable -> L79
        Header r113 = (Header) r112;     // Catch: Throwable -> L79
        if (Intrinsics.areEqual(r113.getName(), "server-timing") == true) goto L17;
    L19:
        boolean r114 = false;
    L20:
        if (r114 == false) goto L12;
    L23:
        Header r115 = (Header) r112;     // Catch: Throwable -> L79
        if (r115 == null) goto L60;
        String r116 = r115.getValue();     // Catch: Throwable -> L79
        if (r116 == null) goto L60;
        List r117 = StringsKt.split$default(r116, new String[]{", "}, false, 0, 6, null);     // Catch: Throwable -> L79
        if (r117 == null) goto L60;
        Iterator r118 = r117.iterator();     // Catch: Throwable -> L79
    L31:
        if (r118.hasNext() == false) goto L35;
        Object r119 = r118.next();     // Catch: Throwable -> L79
        if (StringsKt.contains$default((String) r119, "inner; dur=", false, 2, null) == false) goto L31;
    L36:
        String r120 = (String) r119;     // Catch: Throwable -> L79
        if (r120 == null) goto L60;
        List r121 = StringsKt.split$default(r120, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);     // Catch: Throwable -> L79
        if (r121 == null) goto L60;
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L79
        Iterator r123 = r121.iterator();     // Catch: Throwable -> L79
    L42:
        if (r123.hasNext() == false) goto L57;
        Object r124 = r123.next();     // Catch: Throwable -> L79
        String r125 = (String) r124;     // Catch: Throwable -> L79
        if (r125 != null) goto L46;
    L49:
        boolean r126 = true;
    L50:
        if (r126 == false) goto L52;
    L54:
        boolean r127 = false;
    L55:
        if (r127 == false) goto L42;
        r122.add(r124);     // Catch: Throwable -> L79
        goto L42
    L52:
        if (r125.length() <= 1) goto L54;
        r127 = true;
        goto L55
    L46:
        if (r125.length() == 0) goto L49;
        r126 = false;
        goto L50
    L57:
        String r128 = (String) ListProtector.get(r122, 1);     // Catch: Throwable -> L79
        if (r128 == null) goto L60;
    L62:
        if (StringsKt.contains$default(r104, "agg/card", false, 2, null) == false) goto L64;
        String r129 = "live_shelf";
    L65:
        long r130 = r103 - ((long) CastIntegerProtector.parseInt(r128));     // Catch: Throwable -> L79
        LinkedHashMap r131 = new LinkedHashMap();     // Catch: Throwable -> L79
        if (Intrinsics.areEqual(r104, "/data/life/live/agg/card/detail/paged/") == false) goto L77;
        Uri r132 = UriProtector.parse(r101.getUrl());     // Catch: Throwable -> L79
        if (r132 == null) goto L71;
        String r133 = UriProtector.getQueryParameter(r132, "selected_tab_id");     // Catch: Throwable -> L79
    L72:
        r131.put("selected_tab_id", r133);     // Catch: Throwable -> L79
        if (r132 == null) goto L76;
        r111 = UriProtector.getQueryParameter(r132, ChameleonOpenTracker.ParamKey.LOAD_TYPE);     // Catch: Throwable -> L79
    L76:
        r131.put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r111);     // Catch: Throwable -> L79
        goto L77
    L71:
        r133 = null;
    L77:
        qv6.c.b(r129, String.valueOf(r103), r128, String.valueOf(r130), r131);     // Catch: Throwable -> L79
        return r102;
    L64:
        r129 = "live_card";
        goto L65
    L35:
        r119 = null;
    L60:
        r128 = "0";
        goto L62
    L17:
        if (StringsKt.contains$default(r113.getValue(), "inner; dur=", false, 2, null) == false) goto L19;
        r114 = true;
        goto L20
    L22:
        r112 = null;
    L79:
        th = move-exception;
        throw th;
    }
}
