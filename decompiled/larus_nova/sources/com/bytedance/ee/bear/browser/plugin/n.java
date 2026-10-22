package com.bytedance.ee.bear.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.lynx.tasm.LynxError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f216627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f216628b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f216629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f216630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f216631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PluginMountStrategy f216632d;

        public a() {
            this.f216630b = true;
            this.f216631c = Integer.MIN_VALUE;
        }
    }

    public final void b() {
        Iterator<a> r100 = this.f216627a.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        a r101 = r100.next();
        if (r101.f216630b == true) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.a("PluginList", "Disable plugin: " + r101.f216629a);
        goto L4
    L7:
        this.f216628b.add(r101.f216629a);
        goto L4
    }

    public n(a[] r100) {
        this.f216628b = new ArrayList();
        this.f216627a = new ArrayList(Arrays.asList(r100));
        b();
    }

    public final List<a> a(boolean r100) {
        if (r100 == false) goto L4;
        ArrayList r101 = new ArrayList();
        Iterator<a> r102 = this.f216627a.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        a r103 = r102.next();
        if (r103.f216630b == false) goto L7;
        r101.add(r103);
        goto L7
    L11:
        return r101;
    L4:
        return this.f216627a;
    }

    public final void l(Class<? extends f> r100) {
        Iterator<a> r101 = this.f216627a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        a r102 = r101.next();
        if (r100.isAssignableFrom(r102.f216629a.getClass()) == false) goto L4;
        r101.remove();
        if (r102.f216630b == false) goto L4;
        List<f> r103 = this.f216628b;
        ArrayList r104 = (ArrayList) r103;
        r104.remove(r102.f216629a);
        goto L4
    }

    public final void m(PluginMountStrategy r100) {
        com.ss.android.lark.officesdk.utils.di.j.e("PluginList", "setDefaultMountStrategy:" + r100);
        Iterator<a> r101 = this.f216627a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        a r102 = r101.next();
        if (r102.f216632d != null) goto L4;
        r102.f216632d = r100;
        goto L4
    }

    public n(List<a> r100) {
        this.f216628b = new ArrayList();
        if (r100 != null) goto L5;
        r100 = new ArrayList();
    L5:
        this.f216627a = r100;
        b();
    }

    public static n c(n r100, n r101) {
        ArrayList r102 = new ArrayList();
        HashSet r103 = new HashSet();
        HashSet r104 = new HashSet();
        d(r100.f216627a, r102, r103, r104);
        d(r101.f216627a, r102, r103, r104);
        a[] r105 = new a[r102.size()];
        r102.toArray(r105);
        return new n(r105);
    }

    public static a e(BasePlugin r100, Enum r101) {
        return j(r100, r101.ordinal(), true, null);
    }

    public static a h(BasePlugin r100, boolean r101) {
        return j(r100, Integer.MIN_VALUE, r101, null);
    }

    public static a k(f<?> r100, PluginMountStrategy r101) {
        return j(r100, Integer.MIN_VALUE, true, r101);
    }

    public static a f(BasePlugin r100, Enum r101, PluginMountStrategy r102) {
        return j(r100, r101.ordinal(), true, r102);
    }

    public static a i(BasePlugin r100, boolean r101, PluginMountStrategy r102) {
        return j(r100, Integer.MIN_VALUE, r101, r102);
    }

    public static void d(Collection<a> r100, List<a> r110, Set<Class> r111, Set<Integer> r112) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L42;
        Iterator<a> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L43;
        a r102 = r101.next();
        Class<?> r103 = r102.f216629a.getClass();
        HashSet r104 = (HashSet) r111;
        if (r104.contains(r103) == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        HashSet r106 = (HashSet) r112;
        boolean r107 = r106.contains(Integer.valueOf(r102.f216631c));
        if (r105 == true) goto L24;
        if (r107 == true) goto L24;
        r104.add(r103);
        ((ArrayList) r110).add(r102);
        int r108 = r102.f216631c;
        if (r108 == Integer.MIN_VALUE) goto L8;
        if (r108 == Integer.MAX_VALUE) goto L8;
        r106.add(Integer.valueOf(r108));
    L24:
        if (r105 == false) goto L26;
        IllegalStateException r109 = new IllegalStateException("Found same type plugin :" + r103);
        int r113 = com.ss.android.lark.officesdk.utils.di.j.f437226a;
        Intrinsics.checkNotNullParameter("PluginList", "tag");
        Intrinsics.checkNotNullParameter(r109, LynxError.LYNX_THROWABLE);
        com.ss.android.lark.officesdk.utils.di.j.g("PluginList", "", r109);
    L26:
        if (r107 == false) goto L8;
        IllegalStateException r114 = new IllegalStateException("Found same level plugin :" + r103);
        int r115 = com.ss.android.lark.officesdk.utils.di.j.f437226a;
        Intrinsics.checkNotNullParameter("PluginList", "tag");
        Intrinsics.checkNotNullParameter(r114, LynxError.LYNX_THROWABLE);
        com.ss.android.lark.officesdk.utils.di.j.g("PluginList", "", r114);
        goto L8
    L12:
        if ((r102.f216629a instanceof e) == true) goto L14;
        r105 = true;
        goto L15
    L43:
        return;
    }

    public static a g(BasePlugin r100, Enum r101, boolean r102, PluginMountStrategy r103) {
        return j(r100, r101.ordinal(), r102, r103);
    }

    public static a j(f<?> r100, int r101, boolean r102, PluginMountStrategy r103) {
        a r104 = new a();
        r104.f216629a = r100;
        r104.f216631c = r101;
        r104.f216630b = r102;
        r104.f216632d = r103;
        return r104;
    }
}
