package com.bytedance.ee.bear.more.protocol3;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sj5.b f234886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f234887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f234888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oj5.c f234889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f234890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<i> f234891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<k> f234892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f234893h;

    public static final class a {
    }

    static {
    }

    public abstract c b();

    public abstract void d();

    public abstract void i();

    public final void c() {
        if (this.f234886a == null) goto L6;
        f().a();
        return;
    }

    public final void e() {
        c r100 = this.f234890e;
        if (r100 == null) goto L5;
        c.b(r100.f234777a, MoreItemList$release$1.INSTANCE);
    L5:
        i();
    }

    public final sj5.b f() {
        sj5.b r100 = this.f234886a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    public final void g() {
        c r100 = this.f234890e;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f234886a != null) goto L8;
    L14:
        tt5.a.k("MoreProvider", "invalidate but fragment is not added!");
        return;
    L8:
        if (f().getHostFragment().isAdded() == false) goto L14;
        if (f().getHostFragment().isDetached() == true) goto L14;
        tt5.a.h("MoreProvider", "invalidate.");
        i r101 = r100.a();
        this.f234891f.setValue(r101);
    }

    public h() {
        this.f234891f = new MutableLiveData();
        this.f234892g = new MutableLiveData();
        this.f234893h = new CompositeDisposable();
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        c r101 = this.f234890e;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f234886a != null) goto L8;
    L34:
        tt5.a.k("MoreProvider", "notifyIdItemChanged " + r100 + " but fragment is not added!");
        return;
    L8:
        if (f().getHostFragment().isAdded() == false) goto L34;
        if (f().getHostFragment().isDetached() == true) goto L34;
        Intrinsics.checkNotNullParameter(r100, "id");
        b r102 = (b) ((LinkedHashMap) r101.f234778b).get(r100);
        k r103 = null;
        if (r102 != null) goto L24;
        Iterator<b> r104 = r101.f234777a.iterator();
    L16:
        if (r104.hasNext() == false) goto L24;
        b r105 = r104.next();
        if ((r105 instanceof g) == false) goto L16;
        c r106 = ((g) r105).b();
        if (r106 == null) goto L22;
        Intrinsics.checkNotNullParameter(r100, "id");
        r102 = (b) ((LinkedHashMap) r106.f234778b).get(r100);
    L23:
        if (r102 == null) goto L16;
    L22:
        r102 = null;
    L24:
        if (r102 == null) goto L26;
        r103 = r102.buildUI();
    L26:
        StringBuilder r107 = new StringBuilder("notifyItemChanged. id=");
        r107.append(r100);
        r107.append(", uiItem?=");
        if (r103 != null) goto L29;
        boolean r108 = true;
    L30:
        r107.append(r108);
        tt5.a.h("MoreProvider", r107.toString());
        if (r103 == null) goto L42;
        this.f234892g.setValue(r103);
        return;
    L42:
        return;
    L29:
        r108 = false;
        goto L30
    }

    public void a(sj5.b r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiItemFactory");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f234886a = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f234887b = r101;
        c r102 = b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "hostProvider");
        c.b(r102.f234777a, new MoreItemList$init$1(this));
        this.f234890e = r102;
        d();
        c.b(r102.f234777a, MoreItemList$create$1.INSTANCE);
    }
}
