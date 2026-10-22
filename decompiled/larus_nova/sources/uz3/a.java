package uz3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.b;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tz3.a;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<C extends tz3.a, DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f552184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f552185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tz3.a f552186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<BaseGroup<?, ?, ?, DATA>> f552187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f552188e;

    public abstract ArrayList<BaseGroup<?, ?, ?, DATA>> e();

    public abstract void f(DATA r100);

    public abstract void g();

    public abstract void h();

    public final void a() {
        Iterator<T> r100 = this.f552187d.iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        BaseGroup r101 = (BaseGroup) r100.next();
        r101.f();
        Iterator<BaseElement<?, ?, ?, DATA>> r102 = r101.f195907h.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().k();
        goto L7
    L9:
        Iterator<BaseElement<?, ?, ?, DATA>> r103 = r101.f195906g.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r103.next().n();
        goto L11
    L13:
        r101.f195903d = true;
        goto L4
    L14:
        this.f552188e = true;
    }

    public final void d() {
        Iterator<T> r100 = this.f552187d.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        BaseGroup r101 = (BaseGroup) r100.next();
        Iterator<BaseElement<?, ?, ?, DATA>> r102 = r101.f195907h.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().m();
        goto L7
    L9:
        r101.i();
        r101.f195903d = false;
        goto L4
    L10:
        this.f552188e = false;
    }

    public final void i() {
        if (this.f552188e == false) goto L5;
        d();
    L5:
        Iterator<BaseGroup<?, ?, ?, DATA>> r100 = this.f552187d.iterator();
    L7:
        if (r100.hasNext() == false) goto L13;
        BaseGroup<?, ?, ?, DATA> r101 = r100.next();
        Iterator<BaseElement<?, ?, ?, DATA>> r102 = r101.f195907h.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        r102.next().o();
        goto L10
    L12:
        r101.j();
        r101.f195902c = false;
        goto L7
    L13:
        h();
    }

    public final void c() {
        g();
        this.f552187d.addAll(e());
        Iterator<BaseGroup<?, ?, ?, DATA>> r100 = this.f552187d.iterator();
    L4:
        if (r100.hasNext() == false) goto L33;
        final BaseGroup<?, ?, ?, DATA> r101 = r100.next();
        C r102 = (C) this.f552186c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "config");
        r101.f195901b = r102;
        r101.h();
        ArrayList<BaseElement<?, ?, ?, DATA>> r103 = r101.c();
        Iterator<T> r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L24;
        BaseElement<?, ?, ?, DATA> r105 = (BaseElement) r104.next();
        d[] r106 = r105.e().a();
        boolean r107 = true;
        if (r106 != null) goto L11;
    L17:
        if (r107 == true) goto L23;
        if (r105.e().c() == (-1)) goto L22;
        r101.f195908i.add(r105);
        goto L23
    L22:
        throw new RuntimeException(r105.getClass().getName().concat(" 没有设置 priorityInExclude"));
    L23:
        r105.f195895f.a(new c(r101));
        goto L7
    L11:
        if (r106.length != 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == true) goto L17;
        r107 = false;
        goto L17
    L13:
        r108 = false;
        goto L14
    L24:
        r101.f195907h.addAll(r103);
        CollectionsKt.sortWith(r101.f195907h, new com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.a());
        CollectionsKt.sortWith(r101.f195908i, new b());
        Iterator<BaseElement<?, ?, ?, DATA>> r109 = r101.f195907h.iterator();
    L26:
        if (r109.hasNext() == false) goto L32;
        BaseElement<?, ?, ?, DATA> r110 = r109.next();
        C r111 = r101.f195901b;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r111 = null;
    L31:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "config");
        r110.f195891b = r111;
        ViewGroup r112 = r101.e();
        Intrinsics.checkNotNullParameter(r112, "parentView");
        r110.onCreate();
        com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<E, M> r113 = r110.i();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r112, "parentView");
        r113.f195899d = r113.a(r112);
        r113.c();
        goto L26
    L32:
        this.f552185b.addView(r101.e());
        goto L4
    }

    public final Context getContext() {
        return this.f552184a;
    }

    public final void b(DATA r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        f(r100);
        Iterator<BaseGroup<?, ?, ?, DATA>> r101 = this.f552187d.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        BaseGroup<?, ?, ?, DATA> r102 = r101.next();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        r102.g(r100);
        Iterator<BaseElement<?, ?, ?, DATA>> r103 = r102.f195907h.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        BaseElement<?, ?, ?, DATA> r104 = r103.next();
        r104.p();
        Intrinsics.checkNotNullParameter(r100, "data");
        r104.l(r100);
        goto L7
    L9:
        r102.k();
        r102.f195902c = true;
        goto L4
    }

    public a(Context r100, ViewGroup r101, vz3.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "config");
        this.f552184a = r100;
        this.f552185b = r101;
        this.f552186c = r102;
        this.f552187d = new ArrayList();
    }
}
