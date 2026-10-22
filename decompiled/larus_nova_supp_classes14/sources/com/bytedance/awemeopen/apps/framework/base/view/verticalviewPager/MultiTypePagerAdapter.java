package com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class MultiTypePagerAdapter extends VerticalPagerAdapter {
    public final a a;

    public abstract int f(int r1);

    public abstract int g(View r1);

    public abstract List<Integer> h();

    public abstract View i(int r1, View r2, ViewGroup r3);

    public final boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    public void j(View r1, int r2) {
    }

    public MultiTypePagerAdapter() {
        this.a = new a();
    }

    public final void finishUpdate(ViewGroup r9) {
        a r10 = this.a;
        int r1 = 0;
    L4:
        if (r1 >= r10.b.size()) goto L25;
        LinkedList<View> r2 = r10.b.valueAt(r1);
        if (r2 == null) goto L24;
        if (r2.isEmpty() == true) goto L24;
        Iterator<View> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L23;
        View r4 = r3.next();
        if (r4 == null) goto L12;
        Lazy<Method> r5 = TDViewHelper.a;
        Intrinsics.checkNotNullParameter(r4, "view");
        Method r6 = (Method) TDViewHelper.a.getValue();     // Catch: Exception -> L26
        if (r6 == null) goto L19;
        r6.invoke(r4, new Object[0]);     // Catch: Exception -> L26
    L19:
        int r7 = r10.b.keyAt(r1);
        LinkedList<Object> r8 = r10.a.get(r7);
        if (r8 != null) goto L22;
        r8 = new LinkedList();
        r10.a.put(r7, r8);
    L22:
        r8.add(r4);
        goto L12
    L23:
        r2.clear();
    L24:
        r1 = r1 + 1;
        goto L4
    }

    public final Object instantiateItem(ViewGroup r3, int r4) {
        int r0 = f(r4);
        if (r0 >= 0) goto L6;
        r0 = 0;
    L6:
        LinkedList<Object> r1 = this.a.a.get(r0);
        if (r1 == null) goto L9;
        Object r2 = r1.poll();
    L10:
        View r5 = i(r4, (View) r2, r3);
        if (r5.getParent() == null) goto L17;
        ((ViewGroup) r5.getParent()).removeView(r5);     // Catch: Exception -> L15
    L17:
        if (r5.getParent() == r3) goto L19;
        r3.addView(r5);
    L19:
        return r5;
    L9:
        r2 = null;
        goto L10
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        return;
    L12:
        View r0 = (View) r4;     // Catch: Exception -> L11
        r2.removeView(r0);     // Catch: Exception -> L11
        j(r0, r3);     // Catch: Exception -> L11
        int r5 = g((View) r4);     // Catch: Exception -> L11
        if (h().contains(Integer.valueOf(r5)) == true) goto L14;
        a r6 = this.a;     // Catch: Exception -> L11
        LinkedList<Object> r1 = r6.a.get(r5);     // Catch: Exception -> L11
        if (r1 != null) goto L9;
        r1 = new LinkedList();     // Catch: Exception -> L11
        r6.a.put(r5, r1);     // Catch: Exception -> L11
    L9:
        r1.add(r4);     // Catch: Exception -> L11
        return;
    L14:
        return;
    }
}
