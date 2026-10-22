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

/* JADX INFO: loaded from: classes16.dex */
public final class l {
    public l() {
    }

    public static boolean b(Menu r100, LinkedHashMap r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "jsMenuItems");
        ArrayList r103 = new ArrayList();
        if (r100 == null) goto L14;
        int r104 = r100.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L14;
        if (r100.getItem(r105).getGroupId() == 6767770) goto L11;
        if (r102 == false) goto L12;
        if (r100.getItem(r105).getGroupId() == 6767771) goto L11;
    L12:
        r105 = r105 + 1;
    L11:
        r103.add(r100.getItem(r105));
    L14:
        if (r103.size() == r101.size()) goto L16;
        return true;
    L16:
        Iterator r106 = r101.entrySet().iterator();
        int r107 = 0;
    L18:
        if (r106.hasNext() == false) goto L25;
        String r108 = (String) ((Map.Entry) r106.next()).getValue();
        MenuItem r109 = (MenuItem) ListProtector.get(r103, r107);
        if (r109 == null) goto L24;
        if (StringsKt.contentEquals(r108, r109.getTitle()) == true) goto L24;
        return true;
    L24:
        r107 = r107 + 1;
        goto L18
    L25:
        return false;
    }

    public static int a(WebView r100, float r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        float r104 = r100.getHeight();
        if (r101 >= (r102 * r104)) goto L8;
        if (r100.canScrollVertically(-1) == true) goto L14;
    L12:
        return 0;
    L14:
        return -1;
    L8:
        if (r101 <= (r104 * r103)) goto L12;
        if (r100.canScrollVertically(1) == false) goto L12;
        return 1;
    }
}
