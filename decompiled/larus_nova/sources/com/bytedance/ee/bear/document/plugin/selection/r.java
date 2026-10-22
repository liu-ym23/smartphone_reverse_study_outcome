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

/* JADX INFO: loaded from: classes16.dex */
public final class r {
    public r() {
    }

    public static boolean a(Menu r100, LinkedHashMap r101) {
        Intrinsics.checkNotNullParameter(r101, "jsMenuItems");
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L13;
        int r103 = r100.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        if (r100.getItem(r104).getGroupId() != 6767770) goto L9;
    L10:
        r102.add(r100.getItem(r104));
    L11:
        r104 = r104 + 1;
        goto L5
    L9:
        if (r100.getItem(r104).getGroupId() != 6767771) goto L11;
    L13:
        if (r102.size() == r101.size()) goto L15;
        return true;
    L15:
        Iterator r105 = r101.entrySet().iterator();
        int r106 = 0;
    L17:
        if (r105.hasNext() == false) goto L24;
        String r107 = (String) ((Map.Entry) r105.next()).getValue();
        MenuItem r108 = (MenuItem) ListProtector.get(r102, r106);
        if (r108 == null) goto L23;
        if (StringsKt.contentEquals(r107, r108.getTitle()) == true) goto L23;
        return true;
    L23:
        r106 = r106 + 1;
        goto L17
    L24:
        return false;
    }
}
