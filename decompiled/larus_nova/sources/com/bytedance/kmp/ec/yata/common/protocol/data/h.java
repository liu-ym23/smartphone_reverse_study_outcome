package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {
    public static final g a(Map<String, ? extends Object> r100) throws ClassCastException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = (String) r100.get("type");
        Map r102 = (Map) r100.get(SlcCommonAction.KEY_PARAMS);
        o r103 = null;
        ArrayList r104 = null;
        if (r102 == null) goto L5;
        Map r105 = com.bytedance.kmp.ec.yata.common.utils.d.g(r102);
    L6:
        Map r106 = (Map) r100.get(TeaEventTrack.ACTION_DRAMA_NEXT);
        if (r106 == null) goto L34;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        List r107 = (List) r106.get("success");
        if (r107 == null) goto L19;
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L12:
        if (r109.hasNext() == false) goto L20;
        Map r110 = (Map) r109.next();
        if (r110 == null) goto L16;
        g r111 = a(r110);
    L17:
        if (r111 == null) goto L12;
        r108.add(r111);
        goto L12
    L16:
        r111 = null;
    L20:
        List r112 = (List) r106.get("failed");
        if (r112 == null) goto L32;
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L24:
        if (r114.hasNext() == false) goto L31;
        Map r115 = (Map) r114.next();
        if (r115 == null) goto L28;
        g r116 = a(r115);
    L29:
        if (r116 == null) goto L24;
        r113.add(r116);
        goto L24
    L28:
        r116 = null;
        goto L29
    L31:
        r104 = r113;
    L32:
        r103 = new o(r108, r104);
        goto L34
    L19:
        r108 = null;
    L34:
        return new g(r101, r105, r103, (String) r100.get("event_control_flow"));
    L5:
        r105 = null;
        goto L6
    }
}
