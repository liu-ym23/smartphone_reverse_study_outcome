package com.bytedance.ee.bear.more.protocol3;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class h {
    public sj5.b a;
    public l b;
    public Bundle c;
    public oj5.c d;
    public c e;
    public final MutableLiveData<i> f;
    public final MutableLiveData<k> g;
    public final CompositeDisposable h;

    public static final class a {
    }

    static {
    }

    public abstract c b();

    public abstract void d();

    public abstract void i();

    public final void c() {
        if (this.a == null) goto L6;
        f().a();
        return;
    }

    public final void e() {
        c r0 = this.e;
        if (r0 == null) goto L5;
        c.b(r0.a, MoreItemList$release$1.INSTANCE);
    L5:
        i();
    }

    public final sj5.b f() {
        sj5.b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    public final void g() {
        c r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
    L14:
        tt5.a.k("MoreProvider", "invalidate but fragment is not added!");
        return;
    L8:
        if (f().getHostFragment().isAdded() == false) goto L14;
        if (f().getHostFragment().isDetached() == true) goto L14;
        tt5.a.h("MoreProvider", "invalidate.");
        i r1 = r0.a();
        this.f.setValue(r1);
    }

    public h() {
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        this.h = new CompositeDisposable();
    }

    public final void h(String r8) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        c r1 = this.e;
        if (r1 != null) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
    L34:
        tt5.a.k("MoreProvider", "notifyIdItemChanged " + r8 + " but fragment is not added!");
        return;
    L8:
        if (f().getHostFragment().isAdded() == false) goto L34;
        if (f().getHostFragment().isDetached() == true) goto L34;
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        b r2 = (b) ((LinkedHashMap) r1.b).get(r8);
        k r4 = null;
        if (r2 != null) goto L24;
        Iterator<b> r3 = r1.a.iterator();
    L16:
        if (r3.hasNext() == false) goto L24;
        b r5 = r3.next();
        if ((r5 instanceof g) == false) goto L16;
        c r6 = ((g) r5).b();
        if (r6 == null) goto L22;
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        r2 = (b) ((LinkedHashMap) r6.b).get(r8);
    L23:
        if (r2 == null) goto L16;
    L22:
        r2 = null;
    L24:
        if (r2 == null) goto L26;
        r4 = r2.buildUI();
    L26:
        StringBuilder r0 = new StringBuilder("notifyItemChanged. id=");
        r0.append(r8);
        r0.append(", uiItem?=");
        if (r4 != null) goto L29;
        boolean r9 = true;
    L30:
        r0.append(r9);
        tt5.a.h("MoreProvider", r0.toString());
        if (r4 == null) goto L42;
        this.g.setValue(r4);
        return;
    L42:
        return;
    L29:
        r9 = false;
        goto L30
    }

    public void a(sj5.b r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiItemFactory");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.b = r3;
        c r4 = b();
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "hostProvider");
        c.b(r4.a, new MoreItemList$init$1(this));
        this.e = r4;
        d();
        c.b(r4.a, MoreItemList$create$1.INSTANCE);
    }
}
