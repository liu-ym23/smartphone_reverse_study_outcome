package com.bytedance.crash.general;

import android.os.Build;
import android.text.TextUtils;
import zg4.i;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static String a() {
        StringBuilder r100 = new StringBuilder();
        String[] r101 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L20
        if (r101.length <= 0) goto L16;
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L20
        int r103 = 0;
    L23:
    L14:
        r100 = r102;
        goto L15
    L8:
        if (r103 >= r101.length) goto L13;
        r102.append(r101[r103]);     // Catch: Exception -> L14
        if (r103 == (r101.length - 1)) goto L12;
        r102.append(", ");     // Catch: Exception -> L14
    L12:
        r103 = r103 + 1;
        goto L23
    L13:
        r100 = r102;
    L16:
        String r104 = r100.toString();
        if (TextUtils.isEmpty(r104) == false) goto L28;
        return "unknown";
    L28:
        return r104;
    L15:
        boolean r105 = i.f572087c;
        goto L16
    }
}
