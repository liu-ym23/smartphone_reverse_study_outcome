package com.bytedance.ee.bear.document.selection;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public l() {
    }

    public static boolean b(Menu r6, LinkedHashMap r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "jsMenuItems");
        ArrayList r0 = new ArrayList();
        if (r6 == null) goto L14;
        int r2 = r6.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L14;
        if (r6.getItem(r3).getGroupId() == 6767770) goto L11;
        if (r8 == false) goto L12;
        if (r6.getItem(r3).getGroupId() == 6767771) goto L11;
    L12:
        r3 = r3 + 1;
    L11:
        r0.add(r6.getItem(r3));
    L14:
        if (r0.size() == r7.size()) goto L16;
        return true;
    L16:
        Iterator r9 = r7.entrySet().iterator();
        int r10 = 0;
    L18:
        if (r9.hasNext() == false) goto L25;
        String r11 = (String) ((Map.Entry) r9.next()).getValue();
        MenuItem r4 = (MenuItem) ListProtector.get(r0, r10);
        if (r4 == null) goto L24;
        if (StringsKt.contentEquals(r11, r4.getTitle()) == true) goto L24;
        return true;
    L24:
        r10 = r10 + 1;
        goto L18
    L25:
        return false;
    }

    public static int a(WebView r1, float r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "webView");
        float r0 = r1.getHeight();
        if (r2 >= (r3 * r0)) goto L8;
        if (r1.canScrollVertically(-1) == true) goto L14;
    L12:
        return 0;
    L14:
        return -1;
    L8:
        if (r2 <= (r0 * r4)) goto L12;
        if (r1.canScrollVertically(1) == false) goto L12;
        return 1;
    }
}
