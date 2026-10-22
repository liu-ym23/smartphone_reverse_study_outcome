package com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class MultiTypePagerAdapter extends VerticalPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f193748a;

    public abstract int f(int r100);

    public abstract int g(View r100);

    public abstract List<Integer> h();

    public abstract View i(int r100, View r101, ViewGroup r102);

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    public void j(View r100, int r101) {
    }

    public MultiTypePagerAdapter() {
        this.f193748a = new a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        a r101 = this.f193748a;
        int r102 = 0;
    L4:
        if (r102 >= r101.f193802b.size()) goto L25;
        LinkedList<View> r103 = r101.f193802b.valueAt(r102);
        if (r103 == null) goto L24;
        if (r103.isEmpty() == true) goto L24;
        Iterator<View> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L23;
        View r105 = r104.next();
        if (r105 == null) goto L12;
        Lazy<Method> r106 = TDViewHelper.f193749a;
        Intrinsics.checkNotNullParameter(r105, "view");
        Method r107 = TDViewHelper.f193749a.getValue();     // Catch: Exception -> L26
        if (r107 == null) goto L19;
        r107.invoke(r105, new Object[0]);     // Catch: Exception -> L26
    L19:
        int r108 = r101.f193802b.keyAt(r102);
        LinkedList<Object> r109 = r101.f193801a.get(r108);
        if (r109 != null) goto L22;
        r109 = new LinkedList();
        r101.f193801a.put(r108, r109);
    L22:
        r109.add(r105);
        goto L12
    L23:
        r103.clear();
    L24:
        r102 = r102 + 1;
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        int r102 = f(r101);
        if (r102 >= 0) goto L6;
        r102 = 0;
    L6:
        LinkedList<Object> r103 = this.f193748a.f193801a.get(r102);
        if (r103 == null) goto L9;
        Object r104 = r103.poll();
    L10:
        View r105 = i(r101, (View) r104, r100);
        if (r105.getParent() == null) goto L17;
        ((ViewGroup) r105.getParent()).removeView(r105);     // Catch: Exception -> L15
    L17:
        if (r105.getParent() == r100) goto L19;
        r100.addView(r105);
    L19:
        return r105;
    L9:
        r104 = null;
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        if (r102 != null) goto L12;
        return;
    L12:
        View r103 = (View) r102;     // Catch: Exception -> L11
        r100.removeView(r103);     // Catch: Exception -> L11
        j(r103, r101);     // Catch: Exception -> L11
        int r104 = g((View) r102);     // Catch: Exception -> L11
        if (h().contains(Integer.valueOf(r104)) == true) goto L14;
        a r105 = this.f193748a;     // Catch: Exception -> L11
        LinkedList<Object> r106 = r105.f193801a.get(r104);     // Catch: Exception -> L11
        if (r106 != null) goto L9;
        r106 = new LinkedList();     // Catch: Exception -> L11
        r105.f193801a.put(r104, r106);     // Catch: Exception -> L11
    L9:
        r106.add(r102);     // Catch: Exception -> L11
        return;
    L14:
        return;
    }
}
