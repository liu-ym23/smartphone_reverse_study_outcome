package com.bytedance.gamecenter.base.multicdn;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.gamecenter.base.r;
import com.bytedance.gamecenter.base.w;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class GMultiCDNDownloadOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f245007a = null;

    static {
        f245007a = LazyKt.lazy(GMultiCDNDownloadOpt$cdnConfig$2.INSTANCE);
    }

    public static boolean c(String r100) {
        Lazy r101 = f245007a;
        if (((GDownloadMultiCDNConfig) r101.getValue()) == null) goto L27;
        GDownloadMultiCDNConfig r102 = (GDownloadMultiCDNConfig) r101.getValue();
        if (r102 == null) goto L7;
        List<GDownloadMultiCDNHostConfig> r103 = r102.getCdnHostList();
    L8:
        List<GDownloadMultiCDNHostConfig> r104 = r103;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L27;
        if (r100 != null) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == false) goto L26;
        boolean r107 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        return false;
    L26:
        return true;
    L19:
        if (r100.length() == 0) goto L22;
        r106 = false;
        goto L23
    L11:
        if (r104.isEmpty() == true) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = null;
    L27:
        boolean r108 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        return false;
    }

    public static void a(List r110, String r111) {
        if (c(r111) == true) goto L5;
        return;
    L5:
        GDownloadMultiCDNConfig r100 = (GDownloadMultiCDNConfig) f245007a.getValue();
        if (r100 == null) goto L78;
        List<GDownloadMultiCDNHostConfig> r101 = r100.getCdnHostList();
        if (r101 == null) goto L79;
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L80;
        GDownloadMultiCDNHostConfig r103 = (GDownloadMultiCDNHostConfig) r102.next();
        List<String> r104 = r103.getSupCDNList();
        List<String> r105 = r104;
        boolean r106 = true;
        if (r105 != null) goto L15;
    L18:
        boolean r107 = true;
    L20:
        if (r107 == true) goto L21;
        String r112 = (String) ListProtector.get(r104, 0);
        if (r112.length() != 0) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L60;
        if (d(r110, r112) == true) goto L60;
        JSONObject r109 = w.b();
        if (r109 == null) goto L34;
        int r113 = r109.optInt(BdpAppEventConstant.PARAMS_STRATEGY_NAME, 0);
        boolean r114 = r.f245056a;
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");
    L36:
        if (r113 != 2) goto L38;
        boolean r115 = true;
    L39:
        if (r115 == false) goto L41;
        ((ArrayList) r110).clear();
    L41:
        Intrinsics.checkNotNull(r111);
        String r116 = UriProtector.parse(r111).getHost();
        if (r116 == null) goto L11;
        if (r116.length() != 0) goto L46;
        boolean r117 = true;
    L47:
        if (r117 == true) goto L59;
        if ((!Intrinsics.areEqual(r116, r103.getMainHost())) == true) goto L59;
        if (r116.length() > 0) goto L55;
        r106 = false;
    L55:
        if (r106 == false) goto L11;
        if (Intrinsics.areEqual(r116, r103.getMainHost()) == false) goto L11;
        String r118 = StringsKt.replace$default(r111, r116, r112, false, 4, null);
        boolean r119 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        ((ArrayList) r110).add(r118);
    L59:
        r103.getMainHost();
        boolean r120 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        goto L11
    L46:
        r117 = false;
        goto L47
    L38:
        r115 = false;
        goto L39
    L34:
        r113 = 0;
    L60:
        Objects.toString((GDownloadMultiCDNConfig) f245007a.getValue());
        boolean r121 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        return;
    L26:
        r108 = false;
        goto L27
    L21:
        boolean r122 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        return;
    L15:
        if (r105.isEmpty() == true) goto L18;
        r107 = false;
        goto L20
    L80:
        return;
    L79:
        return;
    }

    public static void b(List r110, String r111) {
        if (c(r111) == true) goto L5;
        return;
    L5:
        GDownloadMultiCDNConfig r100 = (GDownloadMultiCDNConfig) f245007a.getValue();
        if (r100 == null) goto L45;
        List<GDownloadMultiCDNHostConfig> r101 = r100.getCdnHostList();
        if (r101 == null) goto L62;
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L63;
        GDownloadMultiCDNHostConfig r103 = (GDownloadMultiCDNHostConfig) r102.next();
        List<String> r104 = r103.getSupCDNList();
        List<String> r105 = r104;
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L21;
        Intrinsics.checkNotNull(r111);
        String r107 = UriProtector.parse(r111).getHost();
        if (r107 == null) goto L11;
        if (r107.length() != 0) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L44;
        if ((!Intrinsics.areEqual(r107, r103.getMainHost())) == true) goto L44;
        Iterator<T> r109 = r104.iterator();
    L35:
        if (r109.hasNext() == false) goto L11;
        String r112 = (String) r109.next();
        if (r112.length() <= 0) goto L39;
        boolean r113 = true;
    L40:
        if (r113 == false) goto L35;
        if (d(r110, r112) == true) goto L35;
        String r114 = StringsKt.replace$default(r111, r107, r112, false, 4, null);
        boolean r115 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        ((ArrayList) r110).add(r114);
        goto L35
    L39:
        r113 = false;
    L44:
        r103.getMainHost();
        boolean r116 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        goto L11
    L28:
        r108 = false;
        goto L29
    L21:
        boolean r117 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNDownloadOpt", "tag");
        return;
    L15:
        if (r105.isEmpty() == true) goto L18;
        r106 = false;
        goto L20
    L63:
        return;
    L62:
        return;
    }

    public static boolean d(List r100, String r101) {
        ArrayList r102 = (ArrayList) r100;
        if (r102.isEmpty() == false) goto L5;
    L19:
        return false;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L19;
        Iterator r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        if (StringsKt.contains$default((String) r104.next(), r101, false, 2, null) == false) goto L15;
        return true;
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
        goto L11
    }
}
