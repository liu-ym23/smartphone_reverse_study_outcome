package com.bytedance.ee.bear.browser.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.widgets.NoConsumeInsetsFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f216615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f216616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f216617d;

    public final void a() {
        ViewGroup r100 = (ViewGroup) this.f216616c.findView(R.id.pluginUIContainer);
        this.f216617d = r100;
        if (r100 == null) goto L7;
        r100.setTag("AllPluginsRoot");
        return;
    L7:
        throw new IllegalStateException("All plugins root not found ! [find by id: R.id.pluginUIContainer]");
    }

    public c(t r100) {
        this.f216614a = "LayoutStrategy#" + Integer.toHexString(hashCode());
        this.f216616c = r100;
    }

    public static String c(f r100) {
        if ((r100 instanceof e) == false) goto L6;
        return ((e) r100).getLegacyPlugin().getClass().getName();
    L6:
        return r100.getClass().getName();
    }

    public final ViewGroup d(f r100) {
        String r101 = c(r100);
        if (this.f216617d.findViewWithTag(r101) != null) goto L22;
        n r102 = this.f216615b;
        if (r102 == null) goto L13;
        Iterator<n.a> r103 = r102.f216627a.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        n.a r104 = r103.next();
        if (r104.f216629a != r100) goto L9;
    L14:
        if (r104 != null) goto L16;
        com.ss.android.lark.officesdk.utils.di.j.f(this.f216614a, "Plugin metadata not found:" + r100);
    L16:
        if (r104 != null) goto L18;
    L20:
        r101 = "AllPluginsRoot";
        goto L22
    L18:
        if (r104.f216631c == Integer.MIN_VALUE) goto L20;
    L13:
        r104 = null;
    L22:
        if ("AllPluginsRoot".equals(r101) == false) goto L24;
        View r105 = this.f216617d;
    L25:
        if (r105 != null) goto L29;
        com.ss.android.lark.officesdk.utils.di.j.c(this.f216614a, "no pluginContainer found:".concat(r101), new IllegalStateException(r100.toString()));
        return this.f216617d;
    L29:
        return (ViewGroup) r105;
    L24:
        r105 = this.f216616c.findView(r101);
        goto L25
    }

    public final void e(n r100) {
        this.f216615b = r100;
        a();
        ArrayList r101 = new ArrayList();
        final HashMap r102 = new HashMap();
        r100.getClass();
        HashMap r103 = new HashMap();
        Iterator<n.a> r104 = r100.f216627a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        n.a r105 = r104.next();
        r103.put(r105.f216629a, r105);
        goto L4
    L6:
        Iterator r106 = r103.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Map.Entry r107 = (Map.Entry) r106.next();
        f r108 = (f) r107.getKey();
        n.a r109 = (n.a) r107.getValue();
        if (r109.f216631c == Integer.MIN_VALUE) goto L8;
        r101.add(r108);
        r102.put(r108, Integer.valueOf(r109.f216631c));
        goto L8
    L12:
        Collections.sort(r101, new b(r102));
        int r110 = 0;
    L14:
        if (r110 >= r101.size()) goto L20;
        f r111 = (f) ListProtector.get(r101, r110);
        String r112 = c(r111);
        View r113 = this.f216617d.findViewWithTag(c(r111));
        if (r113 == null) goto L18;
        int r114 = r113.getId();
    L19:
        b(r112, r114);
        r110 = r110 + 1;
        goto L14
    L18:
        r114 = View.generateViewId();
        goto L19
    }

    public final void b(Object r100, int r101) {
        if (this.f216617d.findViewWithTag(r100) == null) goto L5;
        return;
    L5:
        NoConsumeInsetsFrameLayout r102 = new NoConsumeInsetsFrameLayout(this.f216616c.getContext());
        r102.setTag(r100);
        r102.setTag(R.id.pluginUIContainer, r100);
        r102.setId(r101);
        this.f216617d.addView(r102, -1, -1);
    }
}
