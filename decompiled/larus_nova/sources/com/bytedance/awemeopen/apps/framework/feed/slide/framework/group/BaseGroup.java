package com.bytedance.awemeopen.apps.framework.feed.slide.framework.group;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tz3.a;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseGroup<E extends d, LAYOUT extends ViewGroup, C extends tz3.a, DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f195900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C f195901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f195902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f195903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f195904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f195905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<BaseElement<?, ?, ?, DATA>> f195906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<BaseElement<?, ?, ?, DATA>> f195907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<BaseElement<?, ?, ?, DATA>> f195908i;

    public abstract E a();

    public abstract LAYOUT b(Context r100);

    public abstract ArrayList<BaseElement<?, ?, ?, DATA>> c();

    public void f() {
    }

    public abstract void g(DATA r100);

    public abstract void h();

    public void i() {
    }

    public abstract void j();

    public final E d() {
        return (E) this.f195904e.getValue();
    }

    public final LAYOUT e() {
        return (LAYOUT) this.f195905f.getValue();
    }

    public final void k() {
        ArrayList<BaseElement<?, ?, ?, DATA>> r100 = this.f195907h;
        ArrayList r101 = new ArrayList();
        Iterator<BaseElement<?, ?, ?, DATA>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        BaseElement<?, ?, ?, DATA> r103 = r102.next();
        if (Intrinsics.areEqual(r103.f195895f.f548046c, Boolean.TRUE) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        Integer r107 = Integer.valueOf(((BaseElement) r106).e().b());
        Object r108 = r104.get(r107);
        if (r108 != null) goto L14;
        r108 = new ArrayList();
        r104.put(r107, r108);
    L14:
        ((List) r108).add(r106);
        goto L10
    L15:
        ArrayList r109 = new ArrayList(r104.size());
        Iterator r110 = r104.entrySet().iterator();
    L17:
        if (r110.hasNext() == false) goto L32;
        Iterator r111 = ((Iterable) ((Map.Entry) r110.next()).getValue()).iterator();
        if (r111.hasNext() == true) goto L21;
        Object r112 = null;
    L31:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement<*, *, *, DATA of com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup.calculateShowElements$lambda$13>{ com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroupKt.ELEMENT<DATA of com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup.calculateShowElements$lambda$13> }");
        r109.add((BaseElement) r112);
        goto L17
    L21:
        Object r113 = r111.next();
        if (r111.hasNext() == true) goto L24;
    L23:
        r112 = r113;
        goto L31
    L24:
        int r114 = ((BaseElement) r113).e().d();
    L25:
        Object r115 = r111.next();
        int r116 = ((BaseElement) r115).e().d();
        if (Intrinsics.compare(r114, r116) <= 0) goto L29;
        r113 = r115;
        r114 = r116;
    L29:
        if (r111.hasNext() == true) goto L25;
    L32:
        ArrayList r117 = new ArrayList(r109);
        Iterator<BaseElement<?, ?, ?, DATA>> r118 = this.f195908i.iterator();
    L34:
        if (r118.hasNext() == false) goto L47;
        BaseElement<?, ?, ?, DATA> r119 = r118.next();
        if (r117.contains(r119) == false) goto L34;
        ArrayList r120 = new ArrayList();
        Iterator r121 = r117.iterator();
    L39:
        if (r121.hasNext() == false) goto L43;
        Object r122 = r121.next();
        com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d[] r123 = r119.e().a();
        Intrinsics.checkNotNull(r123);
        if (ArraysKt.contains(r123, ((BaseElement) r122).e()) == false) goto L39;
        r120.add(r122);
        goto L39
    L43:
        Iterator r124 = r120.iterator();
    L45:
        if (r124.hasNext() == false) goto L34;
        r117.remove((BaseElement) r124.next());
        goto L45
    L47:
        Iterator r125 = r117.iterator();
        int r126 = -1;
    L49:
        if (r125.hasNext() == false) goto L55;
        BaseElement r127 = (BaseElement) r125.next();
        int r128 = e().indexOfChild(r127.i().b());
        if (r128 < 0) goto L53;
        r126 = r128;
    L54:
        r127.i().b().setVisibility(0);
        goto L49
    L53:
        r126 = r126 + 1;
        e().addView(r127.i().b(), r126);
        goto L54
    L55:
        ArrayList<BaseElement<?, ?, ?, DATA>> r129 = this.f195906g;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L57:
        if (r131.hasNext() == false) goto L61;
        Object r132 = r131.next();
        if ((!r117.contains((BaseElement) r132)) == false) goto L57;
        r130.add(r132);
        goto L57
    L61:
        Iterator r133 = r130.iterator();
    L63:
        if (r133.hasNext() == false) goto L66;
        ((BaseElement) r133.next()).i().b().setVisibility(8);
        goto L63
    L66:
        if (this.f195903d == false) goto L77;
        ArrayList r134 = new ArrayList();
        Iterator r135 = r117.iterator();
    L69:
        if (r135.hasNext() == false) goto L73;
        Object r136 = r135.next();
        if ((!this.f195906g.contains((BaseElement) r136)) == false) goto L69;
        r134.add(r136);
        goto L69
    L73:
        Iterator r137 = r134.iterator();
    L75:
        if (r137.hasNext() == false) goto L77;
        ((BaseElement) r137.next()).n();
    L77:
        this.f195906g.clear();
        this.f195906g.addAll(r117);
    }

    public final Context getContext() {
        return this.f195900a;
    }

    public BaseGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f195900a = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f195904e = LazyKt.lazy(r101, new BaseGroup$event$2(this));
        this.f195905f = LazyKt.lazy(r101, new BaseGroup$rootView$2(this));
        this.f195906g = new ArrayList();
        this.f195907h = new ArrayList();
        this.f195908i = new ArrayList();
    }
}
