package com.bytedance.locallife.live.util;

import android.text.TextUtils;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f260732a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "logExtra");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        JSONObject r102 = LiveLocalLifeUtil.c(r101);
        if (r102 == null) goto L22;
        String r103 = r102.optString("log_extra");
        if (TextUtils.isEmpty(r103) == true) goto L23;
        JSONObject r104 = new JSONObject(r100);     // Catch: Exception -> L14
        JSONObject r105 = new JSONObject(r103);     // Catch: Exception -> L14
        Iterator<String> r106 = r104.keys();     // Catch: Exception -> L14
    L8:
        if (r106.hasNext() == false) goto L12;
        String r107 = r106.next();     // Catch: Exception -> L14
        if (r105.has(r107) == true) goto L8;
        r105.put(r107, r104.get(r107));     // Catch: Exception -> L14
        goto L8
    L12:
        return r105.toString();
    L24:
        return r100;
    L23:
        return r100;
    L22:
        return r100;
    }
}
