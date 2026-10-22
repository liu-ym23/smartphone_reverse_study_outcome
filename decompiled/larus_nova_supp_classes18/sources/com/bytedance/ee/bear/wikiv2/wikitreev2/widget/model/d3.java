package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d3 {
    public static final d3 e = null;
    public final List<j> a;
    public int b;
    public final Map<String, Integer> c;
    public final Map<String, List<Integer>> d;

    public static final class a {
    }

    static {
        e = new d3();
    }

    public final void b() {
        Iterator<T> r0 = this.a.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        int r2 = r1 + 1;
        j r3 = (j) r0.next();
        Integer r4 = Integer.valueOf(r1);
        this.c.put(r3.n, r4);
        Map<String, List<Integer>> r5 = this.d;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        List<Integer> r7 = (List) r6.get(r3.b);
        if (r7 != null) goto L8;
        r7 = new ArrayList();
        this.d.put(r3.b, r7);
    L8:
        r7.add(Integer.valueOf(r1));
        int r8 = r3.o;
        if (r8 <= this.b) goto L11;
        this.b = r8;
    L11:
        r1 = r2;
        goto L4
    }

    public d3() {
        this.a = new ArrayList();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public final void a(List<j> r2) {
        Intrinsics.checkNotNullParameter(r2, "uiList");
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r2);
    }

    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.d.containsKey(r2) == false) goto L7;
        return true;
    }

    public final int d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Integer r3 = (Integer) ((LinkedHashMap) this.c).get(r2);
        if (r3 != null) goto L7;
        return -1;
    L7:
        return r3.intValue();
    }
}
