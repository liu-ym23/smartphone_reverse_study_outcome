package com.bytedance.ee.bear.document.plugin.selection;

import android.view.Menu;
import android.view.MenuItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public r() {
    }

    public static boolean a(Menu r6, LinkedHashMap r7) {
        Intrinsics.checkNotNullParameter(r7, "jsMenuItems");
        ArrayList r0 = new ArrayList();
        if (r6 == null) goto L13;
        int r2 = r6.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        if (r6.getItem(r3).getGroupId() != 6767770) goto L9;
    L10:
        r0.add(r6.getItem(r3));
    L11:
        r3 = r3 + 1;
        goto L5
    L9:
        if (r6.getItem(r3).getGroupId() != 6767771) goto L11;
    L13:
        if (r0.size() == r7.size()) goto L15;
        return true;
    L15:
        Iterator r8 = r7.entrySet().iterator();
        int r9 = 0;
    L17:
        if (r8.hasNext() == false) goto L24;
        String r4 = (String) ((Map.Entry) r8.next()).getValue();
        MenuItem r5 = (MenuItem) ListProtector.get(r0, r9);
        if (r5 == null) goto L23;
        if (StringsKt.contentEquals(r4, r5.getTitle()) == true) goto L23;
        return true;
    L23:
        r9 = r9 + 1;
        goto L17
    L24:
        return false;
    }
}
