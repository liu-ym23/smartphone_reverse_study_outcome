package uz3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.b;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tz3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<C extends tz3.a, DATA> {
    public final Context a;
    public final ViewGroup b;
    public final tz3.a c;
    public final ArrayList<BaseGroup<?, ?, ?, DATA>> d;
    public boolean e;

    public abstract ArrayList<BaseGroup<?, ?, ?, DATA>> e();

    public abstract void f(DATA r1);

    public abstract void g();

    public abstract void h();

    public final void a() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        BaseGroup r1 = (BaseGroup) r0.next();
        r1.f();
        Iterator<BaseElement<?, ?, ?, DATA>> r3 = r1.h.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().k();
        goto L7
    L9:
        Iterator<BaseElement<?, ?, ?, DATA>> r4 = r1.g.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r4.next().n();
        goto L11
    L13:
        r1.d = true;
        goto L4
    L14:
        this.e = true;
    }

    public final void d() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BaseGroup r1 = (BaseGroup) r0.next();
        Iterator<BaseElement<?, ?, ?, DATA>> r3 = r1.h.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().m();
        goto L7
    L9:
        r1.i();
        r1.d = false;
        goto L4
    L10:
        this.e = false;
    }

    public final void i() {
        if (this.e == false) goto L5;
        d();
    L5:
        Iterator<BaseGroup<?, ?, ?, DATA>> r0 = this.d.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        BaseGroup<?, ?, ?, DATA> r1 = r0.next();
        Iterator<BaseElement<?, ?, ?, DATA>> r2 = r1.h.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r2.next().o();
        goto L10
    L12:
        r1.j();
        r1.c = false;
        goto L7
    L13:
        h();
    }

    public final void c() {
        g();
        this.d.addAll(e());
        Iterator<BaseGroup<?, ?, ?, DATA>> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L33;
        final BaseGroup<?, ?, ?, DATA> r1 = r0.next();
        C r2 = (C) this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        r1.b = r2;
        r1.h();
        ArrayList<BaseElement<?, ?, ?, DATA>> r3 = r1.c();
        Iterator<T> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L24;
        BaseElement<?, ?, ?, DATA> r5 = (BaseElement) r4.next();
        d[] r6 = r5.e().a();
        boolean r7 = true;
        if (r6 != null) goto L11;
    L17:
        if (r7 == true) goto L23;
        if (r5.e().c() == (-1)) goto L22;
        r1.i.add(r5);
        goto L23
    L22:
        throw new RuntimeException(r5.getClass().getName().concat(" 没有设置 priorityInExclude"));
    L23:
        r5.f.a(new c(r1));
        goto L7
    L11:
        if (r6.length != 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L17;
        r7 = false;
        goto L17
    L13:
        r8 = false;
        goto L14
    L24:
        r1.h.addAll(r3);
        CollectionsKt.sortWith(r1.h, new com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.a());
        CollectionsKt.sortWith(r1.i, new b());
        Iterator<BaseElement<?, ?, ?, DATA>> r9 = r1.h.iterator();
    L26:
        if (r9.hasNext() == false) goto L32;
        BaseElement<?, ?, ?, DATA> r10 = r9.next();
        C r11 = r1.b;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r11 = null;
    L31:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "config");
        r10.b = r11;
        ViewGroup r12 = r1.e();
        Intrinsics.checkNotNullParameter(r12, "parentView");
        r10.onCreate();
        com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<E, M> r13 = r10.i();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "parentView");
        r13.d = r13.a(r12);
        r13.c();
        goto L26
    L32:
        this.b.addView(r1.e());
        goto L4
    }

    public final Context getContext() {
        return this.a;
    }

    public final void b(DATA r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        f(r6);
        Iterator<BaseGroup<?, ?, ?, DATA>> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        BaseGroup<?, ?, ?, DATA> r2 = r1.next();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        r2.g(r6);
        Iterator<BaseElement<?, ?, ?, DATA>> r3 = r2.h.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        BaseElement<?, ?, ?, DATA> r4 = r3.next();
        r4.p();
        Intrinsics.checkNotNullParameter(r6, "data");
        r4.l(r6);
        goto L7
    L9:
        r2.k();
        r2.c = true;
        goto L4
    }

    public a(Context r2, ViewGroup r3, vz3.c r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "config");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new ArrayList();
    }
}
