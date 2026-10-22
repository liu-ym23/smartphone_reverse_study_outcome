package com.bytedance.ee.bear.browser.plugin;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public final List<a> a;
    public final List<f> b;

    public static class a {
        public f a;
        public boolean b;
        public int c;
        public PluginMountStrategy d;

        public a() {
            this.b = true;
            this.c = ShareItemModel.SRC_TINT_UNDEFINED;
        }
    }

    public final void b() {
        Iterator<a> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        a r1 = r0.next();
        if (r1.b == true) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.a("PluginList", "Disable plugin: " + r1.a);
        goto L4
    L7:
        this.b.add(r1.a);
        goto L4
    }

    public n(a[] r2) {
        this.b = new ArrayList();
        this.a = new ArrayList(Arrays.asList(r2));
        b();
    }

    public final List<a> a(boolean r4) {
        if (r4 == false) goto L4;
        ArrayList r5 = new ArrayList();
        Iterator<a> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        a r1 = r0.next();
        if (r1.b == false) goto L7;
        r5.add(r1);
        goto L7
    L11:
        return r5;
    L4:
        return this.a;
    }

    public final void l(Class<? extends f> r4) {
        Iterator<a> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a r1 = r0.next();
        if (r4.isAssignableFrom(r1.a.getClass()) == false) goto L4;
        r0.remove();
        if (r1.b == false) goto L4;
        List<f> r2 = this.b;
        ArrayList r3 = (ArrayList) r2;
        r3.remove(r1.a);
        goto L4
    }

    public final void m(PluginMountStrategy r4) {
        com.ss.android.lark.officesdk.utils.di.j.e("PluginList", "setDefaultMountStrategy:" + r4);
        Iterator<a> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = r0.next();
        if (r1.d != null) goto L4;
        r1.d = r4;
        goto L4
    }

    public n(List<a> r2) {
        this.b = new ArrayList();
        if (r2 != null) goto L5;
        r2 = new ArrayList();
    L5:
        this.a = r2;
        b();
    }

    public static n c(n r3, n r4) {
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        HashSet r2 = new HashSet();
        d(r3.a, r0, r1, r2);
        d(r4.a, r0, r1, r2);
        a[] r5 = new a[r0.size()];
        r0.toArray(r5);
        return new n(r5);
    }

    public static a e(BasePlugin r2, Enum r3) {
        return j(r2, r3.ordinal(), true, null);
    }

    public static a h(BasePlugin r2, boolean r3) {
        return j(r2, ShareItemModel.SRC_TINT_UNDEFINED, r3, null);
    }

    public static a k(f<?> r2, PluginMountStrategy r3) {
        return j(r2, ShareItemModel.SRC_TINT_UNDEFINED, true, r3);
    }

    public static a f(BasePlugin r1, Enum r2, PluginMountStrategy r3) {
        return j(r1, r2.ordinal(), true, r3);
    }

    public static a i(BasePlugin r1, boolean r2, PluginMountStrategy r3) {
        return j(r1, ShareItemModel.SRC_TINT_UNDEFINED, r2, r3);
    }

    public static void d(Collection<a> r9, List<a> r10, Set<Class> r11, Set<Integer> r12) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.isEmpty() == true) goto L42;
        Iterator<a> r13 = r9.iterator();
    L8:
        if (r13.hasNext() == false) goto L43;
        a r0 = r13.next();
        Class<?> r1 = r0.a.getClass();
        HashSet r2 = (HashSet) r11;
        if (r2.contains(r1) == true) goto L12;
    L14:
        boolean r3 = false;
    L15:
        HashSet r5 = (HashSet) r12;
        boolean r4 = r5.contains(Integer.valueOf(r0.c));
        if (r3 == true) goto L24;
        if (r4 == true) goto L24;
        r2.add(r1);
        ((ArrayList) r10).add(r0);
        int r6 = r0.c;
        if (r6 == Integer.MIN_VALUE) goto L8;
        if (r6 == Integer.MAX_VALUE) goto L8;
        r5.add(Integer.valueOf(r6));
    L24:
        if (r3 == false) goto L26;
        IllegalStateException r7 = new IllegalStateException("Found same type plugin :" + r1);
        int r8 = com.ss.android.lark.officesdk.utils.di.j.a;
        Intrinsics.checkNotNullParameter("PluginList", "tag");
        Intrinsics.checkNotNullParameter(r7, "throwable");
        com.ss.android.lark.officesdk.utils.di.j.g("PluginList", "", r7);
    L26:
        if (r4 == false) goto L8;
        IllegalStateException r14 = new IllegalStateException("Found same level plugin :" + r1);
        int r16 = com.ss.android.lark.officesdk.utils.di.j.a;
        Intrinsics.checkNotNullParameter("PluginList", "tag");
        Intrinsics.checkNotNullParameter(r14, "throwable");
        com.ss.android.lark.officesdk.utils.di.j.g("PluginList", "", r14);
        goto L8
    L12:
        if ((r0.a instanceof e) == true) goto L14;
        r3 = true;
        goto L15
    L43:
        return;
    }

    public static a g(BasePlugin r0, Enum r1, boolean r2, PluginMountStrategy r3) {
        return j(r0, r1.ordinal(), r2, r3);
    }

    public static a j(f<?> r1, int r2, boolean r3, PluginMountStrategy r4) {
        a r0 = new a();
        r0.a = r1;
        r0.c = r2;
        r0.b = r3;
        r0.d = r4;
        return r0;
    }
}
