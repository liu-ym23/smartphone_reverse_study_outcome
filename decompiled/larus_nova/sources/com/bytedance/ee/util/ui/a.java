package com.bytedance.ee.util.ui;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(Activity r100) {
        if (r100 != null) goto L17;
        return false;
    L17:
        List r101 = CollectionsKt.listOf(new String[]{"DocExpandActivity", "WikiExpandActivity", "DriveExpandActivity"});
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L14
        Iterator r103 = r101.iterator();     // Catch: Exception -> L14
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();     // Catch: Exception -> L14
        if (StringsKt.contains$default(r100.getClass().getSimpleName(), (String) r104, false, 2, null) == false) goto L8;
        r102.add(r104);     // Catch: Exception -> L14
        goto L8
    L12:
        return !hu5.a.d(r102);
    L14:
        e = move-exception;
        tt5.a.d("ActivityExpandUtils", "isExpandActivity fail: " + e);
        return false;
    }
}
