package com.bytedance.kmp.ec.yata.common.utils;

import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部API")
public final class YataClipDataUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f251562a = 0;

    static {
    }

    public static boolean a(Map r100, final int r101, final List r102, Map r110) {
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L14;
        String r104 = YaTaLog.f251436a;
        YaTaLog.c("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$1(r101, r102));
        return false;
    L14:
        if (r101 < r102.size()) goto L17;
        String r105 = YaTaLog.f251436a;
        YaTaLog.d("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$2(r101, r102));
        return false;
    L17:
        final String r106 = (String) CollectionsKt.getOrNull(r102, r101);
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L27;
        String r108 = YaTaLog.f251436a;
        YaTaLog.d("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$3(r101, r102));
        return a(r100, r101 + 1, r102, r110);
    L27:
        final Object r109 = r100.get(r106);
        if (r101 == (r102.size() - 1)) goto L30;
        boolean r111 = r109 instanceof Map;
        Map r112 = null;
        if (r111 == false) goto L37;
        Map r113 = (Map) r109;
    L38:
        if (r113 != null) goto L41;
        String r114 = YaTaLog.f251436a;
        YaTaLog.d("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$6(r101, r102, r109));
        return false;
    L41:
        LinkedHashMap r115 = new LinkedHashMap();
        if (r111 == false) goto L44;
        Map r116 = (Map) r109;
    L46:
        if (a(r116, r101 + 1, r102, r115) == false) goto L56;
        LinkedHashMap r117 = (LinkedHashMap) r110;
        if (r117.get(r106) != null) goto L50;
        r110.put(r106, new LinkedHashMap());
    L50:
        Object r118 = r117.get(r106);
        if (TypeIntrinsics.isMutableMap(r118) == false) goto L53;
        r112 = (Map) r118;
    L53:
        if (r112 == null) goto L55;
        e.a(r112, r115);
    L55:
        String r119 = YaTaLog.f251436a;
        YaTaLog.c("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$7(r101, r102));
        return true;
    L56:
        String r120 = YaTaLog.f251436a;
        YaTaLog.d("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$8(r101, r102));
        return false;
    L44:
        r116 = null;
        goto L46
    L37:
        r113 = null;
        goto L38
    L30:
        if (r100.containsKey(r106) == false) goto L32;
        r110.put(r106, r109);
        String r121 = YaTaLog.f251436a;
        YaTaLog.c("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$4(r101, r102, r106, r109));
    L33:
        return true;
    L32:
        String r122 = YaTaLog.f251436a;
        YaTaLog.c("YataClipDataUtils", new YataClipDataUtils$clipDataInternal$5(r101, r102, r106, r109));
        goto L33
    L20:
        if (StringsKt.isBlank(r106) == true) goto L23;
        r107 = false;
        goto L24
    L5:
        if (r100.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }
}
