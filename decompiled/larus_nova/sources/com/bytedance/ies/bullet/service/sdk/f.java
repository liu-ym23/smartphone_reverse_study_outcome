package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import w26.g;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public f() {
    }

    public static void a(String r110, d r111, int r112) {
        Iterator r100 = StringsKt.split$default(r110, new char[]{Typography.amp}, false, 0, 6, null).iterator();
    L4:
        if (r100.hasNext() == false) goto L58;
        List r101 = StringsKt.split$default((String) r100.next(), new char[]{com.alipay.sdk.m.n.a.f25612h}, false, 2, 2, null);
        if (r101.size() != 2) goto L4;
        String r102 = Uri.decode((String) ListProtector.get(r101, 0));
        String r103 = Uri.decode((String) ListProtector.get(r101, 1));
        if (r102 == null) goto L4;
        if (r103 == null) goto L4;
        Map<String, Map<Class<?>, Object>> r104 = x26.a.f562251a;
        g r105 = (g) x26.a.a(g.class);
        if (r105 == null) goto L15;
        w26.e r106 = (w26.e) r105.n0(w26.e.class);
        if (r106 == null) goto L15;
        boolean r107 = r106.K1();
    L16:
        String r108 = null;
        if (r107 == false) goto L26;
        if (Intrinsics.areEqual(r102, PickerReporterConstants.KEY.TARGET) == false) goto L21;
    L31:
        boolean r109 = true;
    L33:
        if (r109 == false) goto L37;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        if (((String) ((LinkedHashMap) r111.f248139p).get(r102)) != null) goto L42;
        r111.f248139p.put(r102, r103);
    L42:
        if (r109 == false) goto L4;
        if (Intrinsics.areEqual(r102, "fallback_url") == true) goto L4;
        int r113 = StringsKt.indexOf$default(r103, "://", 0, false, 6, null);
        if (r113 == (-1)) goto L56;
        int r114 = StringsKt.indexOf$default(r103, '?', r113 + 3, false, 4, null);
        if (r114 == (-1)) goto L56;
        int r115 = r114 + 1;
        int r116 = StringsKt.indexOf$default(r103, '#', r115, false, 4, null);
        if (r116 != (-1)) goto L54;
        String r117 = r103.substring(r115, r103.length());
    L55:
        r108 = r117;
        goto L56
    L54:
        r117 = r103.substring(r115, r116);
    L56:
        if (r108 == null) goto L4;
        a(r108, r111, r112 + 1);
        goto L4
    L37:
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        Integer r118 = (Integer) ((LinkedHashMap) r111.f248138o).get(r102);
        if (r118 != null) goto L40;
    L41:
        r111.f248138o.put(r102, Integer.valueOf(r112));
        r111.f248139p.put(r102, r103);
        goto L42
    L40:
        if (r118.intValue() >= r112) goto L42;
    L21:
        if (Intrinsics.areEqual(r102, "url") == true) goto L31;
        if (Intrinsics.areEqual(r102, "surl") == true) goto L31;
    L30:
        r109 = false;
        goto L33
    L26:
        if (Intrinsics.areEqual(r102, PickerReporterConstants.KEY.TARGET) == true) goto L31;
        if (StringsKt.endsWith$default(r102, "url", false, 2, null) == false) goto L30;
    L15:
        r107 = true;
        goto L16
    }
}
