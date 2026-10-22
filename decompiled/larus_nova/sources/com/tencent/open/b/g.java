package com.tencent.open.b;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public class g {
    public static void a(String r100) {
    }

    public static void a(String r100, List<Serializable> r101) {
    }

    public static void a() {
        Context r100 = com.tencent.open.utils.g.a();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.deleteDatabase("sdk_report.db");
    }

    public static List<Serializable> b(String r100) {
        return Collections.synchronizedList(new ArrayList());
    }
}
