package com.bytedance.ee.bear.browser.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.widgets.NoConsumeInsetsFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements t.a {
    public final String a;
    public n b;
    public final t c;
    public ViewGroup d;

    public final void a() {
        ViewGroup r0 = (ViewGroup) this.c.findView(2131382479);
        this.d = r0;
        if (r0 == null) goto L7;
        r0.setTag("AllPluginsRoot");
        return;
    L7:
        throw new IllegalStateException("All plugins root not found ! [find by id: R.id.pluginUIContainer]");
    }

    public c(t r3) {
        this.a = "LayoutStrategy#" + Integer.toHexString(hashCode());
        this.c = r3;
    }

    public static String c(f r1) {
        if ((r1 instanceof e) == false) goto L6;
        return ((e) r1).getLegacyPlugin().getClass().getName();
    L6:
        return r1.getClass().getName();
    }

    public final ViewGroup d(f r7) {
        String r0 = c(r7);
        if (this.d.findViewWithTag(r0) != null) goto L22;
        n r1 = this.b;
        if (r1 == null) goto L13;
        Iterator<n.a> r2 = r1.a.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        n.a r3 = r2.next();
        if (r3.a != r7) goto L9;
    L14:
        if (r3 != null) goto L16;
        com.ss.android.lark.officesdk.utils.di.j.f(this.a, "Plugin metadata not found:" + r7);
    L16:
        if (r3 != null) goto L18;
    L20:
        r0 = "AllPluginsRoot";
        goto L22
    L18:
        if (r3.c == Integer.MIN_VALUE) goto L20;
    L13:
        r3 = null;
    L22:
        if ("AllPluginsRoot".equals(r0) == false) goto L24;
        View r4 = this.d;
    L25:
        if (r4 != null) goto L29;
        com.ss.android.lark.officesdk.utils.di.j.c(this.a, "no pluginContainer found:".concat(r0), new IllegalStateException(r7.toString()));
        return this.d;
    L29:
        return (ViewGroup) r4;
    L24:
        r4 = this.c.findView(r0);
        goto L25
    }

    public final void e(n r7) {
        this.b = r7;
        a();
        ArrayList r0 = new ArrayList();
        final HashMap r1 = new HashMap();
        r7.getClass();
        HashMap r2 = new HashMap();
        Iterator<n.a> r8 = r7.a.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        n.a r3 = r8.next();
        r2.put(r3.a, r3);
        goto L4
    L6:
        Iterator r9 = r2.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r9.next();
        f r5 = (f) r4.getKey();
        n.a r6 = (n.a) r4.getValue();
        if (r6.c == Integer.MIN_VALUE) goto L8;
        r0.add(r5);
        r1.put(r5, Integer.valueOf(r6.c));
        goto L8
    L12:
        Collections.sort(r0, new b(r1));
        int r10 = 0;
    L14:
        if (r10 >= r0.size()) goto L20;
        f r11 = (f) ListProtector.get(r0, r10);
        String r12 = c(r11);
        View r13 = this.d.findViewWithTag(c(r11));
        if (r13 == null) goto L18;
        int r14 = r13.getId();
    L19:
        b(r12, r14);
        r10 = r10 + 1;
        goto L14
    L18:
        r14 = View.generateViewId();
        goto L19
    }

    public final void b(Object r3, int r4) {
        if (this.d.findViewWithTag(r3) == null) goto L5;
        return;
    L5:
        NoConsumeInsetsFrameLayout r0 = new NoConsumeInsetsFrameLayout(this.c.getContext());
        r0.setTag(r3);
        r0.setTag(2131382479, r3);
        r0.setId(r4);
        this.d.addView(r0, -1, -1);
    }
}
