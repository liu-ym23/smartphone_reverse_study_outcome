package com.bytedance.awemeopen.apps.framework.feed.slide.framework.group;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.d;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseGroup<E extends d, LAYOUT extends ViewGroup, C extends tz3.a, DATA> {
    public final Context a;
    public C b;
    public boolean c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final ArrayList<BaseElement<?, ?, ?, DATA>> g;
    public final ArrayList<BaseElement<?, ?, ?, DATA>> h;
    public final ArrayList<BaseElement<?, ?, ?, DATA>> i;

    public abstract E a();

    public abstract LAYOUT b(Context r1);

    public abstract ArrayList<BaseElement<?, ?, ?, DATA>> c();

    public void f() {
    }

    public abstract void g(DATA r1);

    public abstract void h();

    public void i() {
    }

    public abstract void j();

    public final E d() {
        return (E) this.e.getValue();
    }

    public final LAYOUT e() {
        return (LAYOUT) this.f.getValue();
    }

    public final void k() {
        ArrayList<BaseElement<?, ?, ?, DATA>> r0 = this.h;
        ArrayList r1 = new ArrayList();
        Iterator<BaseElement<?, ?, ?, DATA>> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        BaseElement<?, ?, ?, DATA> r3 = r2.next();
        if (Intrinsics.areEqual(r3.f.c, Boolean.TRUE) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        Integer r7 = Integer.valueOf(((BaseElement) r6).e().b());
        Object r8 = r4.get(r7);
        if (r8 != null) goto L14;
        r8 = new ArrayList();
        r4.put(r7, r8);
    L14:
        ((List) r8).add(r6);
        goto L10
    L15:
        ArrayList r9 = new ArrayList(r4.size());
        Iterator r10 = r4.entrySet().iterator();
    L17:
        if (r10.hasNext() == false) goto L32;
        Iterator r11 = ((Iterable) ((Map.Entry) r10.next()).getValue()).iterator();
        if (r11.hasNext() == true) goto L21;
        Object r12 = null;
    L31:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement<*, *, *, DATA of com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup.calculateShowElements$lambda$13>{ com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroupKt.ELEMENT<DATA of com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup.calculateShowElements$lambda$13> }");
        r9.add((BaseElement) r12);
        goto L17
    L21:
        Object r13 = r11.next();
        if (r11.hasNext() == true) goto L24;
    L23:
        r12 = r13;
        goto L31
    L24:
        int r14 = ((BaseElement) r13).e().d();
    L25:
        Object r15 = r11.next();
        int r16 = ((BaseElement) r15).e().d();
        if (Intrinsics.compare(r14, r16) <= 0) goto L29;
        r13 = r15;
        r14 = r16;
    L29:
        if (r11.hasNext() == true) goto L25;
    L32:
        ArrayList r17 = new ArrayList(r9);
        Iterator<BaseElement<?, ?, ?, DATA>> r18 = this.i.iterator();
    L34:
        if (r18.hasNext() == false) goto L47;
        BaseElement<?, ?, ?, DATA> r19 = r18.next();
        if (r17.contains(r19) == false) goto L34;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r17.iterator();
    L39:
        if (r21.hasNext() == false) goto L43;
        Object r22 = r21.next();
        com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d[] r23 = r19.e().a();
        Intrinsics.checkNotNull(r23);
        if (ArraysKt.contains(r23, ((BaseElement) r22).e()) == false) goto L39;
        r20.add(r22);
        goto L39
    L43:
        Iterator r24 = r20.iterator();
    L45:
        if (r24.hasNext() == false) goto L34;
        r17.remove((BaseElement) r24.next());
        goto L45
    L47:
        Iterator r25 = r17.iterator();
        int r26 = -1;
    L49:
        if (r25.hasNext() == false) goto L55;
        BaseElement r27 = (BaseElement) r25.next();
        int r28 = e().indexOfChild(r27.i().b());
        if (r28 < 0) goto L53;
        r26 = r28;
    L54:
        r27.i().b().setVisibility(0);
        goto L49
    L53:
        r26 = r26 + 1;
        e().addView(r27.i().b(), r26);
        goto L54
    L55:
        ArrayList<BaseElement<?, ?, ?, DATA>> r29 = this.g;
        ArrayList r30 = new ArrayList();
        Iterator<T> r31 = r29.iterator();
    L57:
        if (r31.hasNext() == false) goto L61;
        Object r32 = r31.next();
        if ((!r17.contains((BaseElement) r32)) == false) goto L57;
        r30.add(r32);
        goto L57
    L61:
        Iterator r33 = r30.iterator();
    L63:
        if (r33.hasNext() == false) goto L66;
        ((BaseElement) r33.next()).i().b().setVisibility(8);
        goto L63
    L66:
        if (this.d == false) goto L77;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r17.iterator();
    L69:
        if (r35.hasNext() == false) goto L73;
        Object r36 = r35.next();
        if ((!this.g.contains((BaseElement) r36)) == false) goto L69;
        r34.add(r36);
        goto L69
    L73:
        Iterator r37 = r34.iterator();
    L75:
        if (r37.hasNext() == false) goto L77;
        ((BaseElement) r37.next()).n();
    L77:
        this.g.clear();
        this.g.addAll(r17);
    }

    public final Context getContext() {
        return this.a;
    }

    public BaseGroup(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.e = LazyKt.lazy(r3, new BaseGroup$event$2(this));
        this.f = LazyKt.lazy(r3, new BaseGroup$rootView$2(this));
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
    }
}
