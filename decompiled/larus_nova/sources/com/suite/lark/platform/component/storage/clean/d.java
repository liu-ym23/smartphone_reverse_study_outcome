package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    public final Context getContext() {
        return null;
    }

    public static Pair a(File r110, List r111) {
        ArrayList r100 = null;
        boolean r101 = false;
        if (r110.isDirectory() == false) goto L8;
        StringBuilder r102 = new StringBuilder();
        r102.append(r110.getAbsolutePath());
        String r103 = r110.getAbsolutePath();
        String r104 = File.separator;
        if (StringsKt.endsWith$default(r103, r104, false, 2, null) == false) goto L7;
        r104 = "";
    L7:
        r102.append(r104);
        String r105 = r102.toString();
    L9:
        Intrinsics.checkNotNull(r105);
        boolean r106 = true;
        if (r111 != null) goto L12;
    L28:
        boolean r107 = false;
    L29:
        long r108 = 0;
        if (r107 == false) goto L32;
        Log.i("StorageCleaner", "file is in whitelist, path:" + r110.getAbsolutePath());
    L77:
        return TuplesKt.to(Boolean.valueOf(r106), Long.valueOf(r108));
    L32:
        if (r110.isDirectory() == false) goto L65;
        if (r111 == null) goto L41;
        ArrayList r109 = new ArrayList();
        Iterator r112 = r111.iterator();
    L36:
        if (r112.hasNext() == false) goto L40;
        Object r113 = r112.next();
        if (StringsKt.startsWith$default((String) r113, r105, false, 2, null) == false) goto L36;
        r109.add(r113);
        goto L36
    L40:
        r100 = r109;
    L41:
        File[] r114 = r110.listFiles();
        if (r114 == null) goto L51;
        int r115 = r114.length;
        int r116 = 0;
        boolean r117 = true;
    L44:
        if (r116 >= r115) goto L52;
        File r118 = r114[r116];
        Intrinsics.checkNotNull(r118);
        Pair r119 = a(r118, r100);
        boolean r120 = ((Boolean) r119.component1()).booleanValue();
        long r121 = ((Number) r119.component2()).longValue();
        if (r120 == false) goto L49;
        if (r117 == false) goto L49;
        r117 = true;
    L50:
        r108 = r108 + r121;
        r116 = r116 + 1;
    L49:
        r117 = false;
    L52:
        if (r100 != null) goto L54;
    L57:
        boolean r122 = true;
    L58:
        if (r122 == true) goto L60;
        r106 = r117;
        goto L77
    L60:
        if (r110.delete() == false) goto L63;
        if (r117 == false) goto L63;
        r101 = true;
    L63:
        r106 = r101;
        goto L77
    L54:
        if (r100.isEmpty() == true) goto L57;
        r122 = false;
        goto L58
    L51:
        r117 = true;
        goto L52
    L65:
        long r123 = r110.length();
        if (r110.delete() == true) goto L69;
        r123 = 0;
    L69:
        long r124 = r123 + 0;
        if (r123 == 0) goto L72;
    L73:
        r101 = true;
    L74:
        r106 = r101;
        r108 = r124;
        goto L77
    L72:
        if (r110.exists() == true) goto L74;
    L12:
        if (r111.isEmpty() == true) goto L28;
        Iterator r125 = r111.iterator();
    L16:
        if (r125.hasNext() == false) goto L28;
        String r126 = p.a((String) r125.next());
        if (Intrinsics.areEqual(r105, r126) == false) goto L20;
    L25:
        boolean r127 = true;
    L26:
        if (r127 == false) goto L16;
        r107 = true;
        goto L29
    L20:
        if (new PolarisFileWrapper(r126).isDirectory() == true) goto L22;
    L24:
        r127 = false;
        goto L26
    L22:
        if (StringsKt.startsWith$default(r105, r126, false, 2, null) == false) goto L24;
    L8:
        r105 = r110.getAbsolutePath();
        goto L9
    }
}
