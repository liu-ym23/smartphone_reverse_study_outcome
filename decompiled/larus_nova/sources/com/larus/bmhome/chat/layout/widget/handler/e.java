package com.larus.bmhome.chat.layout.widget.handler;

import android.view.View;
import com.larus.nova.R;
import com.larus.platform.service.p1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {
    public static final <T> T a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (p1.f365785a.enableViewTagExtra() == false) goto L14;
        Object r102 = r100.getTag(R.id.common_view_attach_hashmap_datas);     // Catch: Exception -> L17
        if (TypeIntrinsics.isMutableMap(r102) == false) goto L8;
        Map r103 = (Map) r102;     // Catch: Exception -> L17
    L9:
        if (r103 != null) goto L11;
        return null;
    L11:
        Object r104 = r103.get(r101);     // Catch: Exception -> L17
        if (r104 != null) goto L16;
        return null;
    L16:
        return (T) r104;
    L8:
        r103 = null;
        goto L9
    L14:
        r104 = com.larus.utils.l.b(r100, r101);     // Catch: Exception -> L17
        goto L16
    L20:
        return null;
    }

    public static final <T> void b(View r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (p1.f365785a.enableViewTagExtra() == false) goto L12;
        Object r103 = r100.getTag(R.id.common_view_attach_hashmap_datas);     // Catch: Exception -> L14
        if (TypeIntrinsics.isMutableMap(r103) == false) goto L8;
        Map r104 = (Map) r103;     // Catch: Exception -> L14
    L9:
        if (r104 != null) goto L11;
        r104 = new LinkedHashMap();     // Catch: Exception -> L14
        r100.setTag(R.id.common_view_attach_hashmap_datas, r104);     // Catch: Exception -> L14
    L11:
        r104.put(r101, r102);     // Catch: Exception -> L14
        return;
    L8:
        r104 = null;
        goto L9
    L12:
        com.larus.utils.l.c(r100, r101, r102);     // Catch: Exception -> L14
        return;
    }
}
