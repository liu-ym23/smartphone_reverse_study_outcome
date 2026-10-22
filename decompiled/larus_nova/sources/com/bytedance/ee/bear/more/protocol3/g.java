package com.bytedance.ee.bear.more.protocol3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f234884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f234885b;

    public abstract k a();

    public c b() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public void create() {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public void release() {
    }

    public final oj5.c c() {
        h r100 = this.f234884a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r100 = null;
    L6:
        return r100.f234889d;
    }

    public final void f() {
        h r100 = this.f234884a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r100 = null;
    L5:
        r100.g();
    }

    public final sj5.b getHost() {
        h r100 = this.f234884a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r100 = null;
    L6:
        return r100.f();
    }

    public final void j() {
        if (this.f234885b.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        h r101 = this.f234884a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r101 = null;
    L10:
        r101.h(this.f234885b);
        return;
    L12:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public g() {
        this.f234885b = "";
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public final k buildUI() {
        k r100 = a();
        if (r100 != null) goto L5;
    L10:
        return r100;
    L5:
        if (this.f234885b.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        this.f234885b = r100.f234901a;
        goto L10
    L7:
        r101 = false;
        goto L8
    }

    public final <T extends oj5.c> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        h r101 = this.f234884a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "clz");
        T r102 = (T) r101.f234889d;
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r100.isAssignableFrom(r102.getClass()) == true) goto L10;
        return null;
    L10:
        return r102;
    }

    public final String e(int r100) {
        if (r100 > 0) goto L5;
        return "";
    L5:
        Context r101 = getHost().getHostFragment().getContext();
        if (r101 == null) goto L12;
        String r102 = r101.getString(r100);
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L12:
        return "";
    }

    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        oj5.c r101 = c();
        if (r101 != null) goto L5;
        return false;
    L5:
        String[] r102 = r101.u();
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.length != 0) goto L10;
        boolean r103 = true;
    L12:
        if ((!r103) == true) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r100) == true) goto L27;
        Iterator r104 = ArrayIteratorKt.iterator(r102);
    L17:
        if (r104.hasNext() == false) goto L28;
        if (TextUtils.equals(r100, (String) r104.next()) == false) goto L17;
        return true;
    L28:
        return false;
    L27:
        return false;
    L10:
        r103 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public void init(h r100) {
        Intrinsics.checkNotNullParameter(r100, "hostProvider");
        this.f234884a = r100;
    }

    public final k h(f r100, e r101, List<? extends m> r110, List<? extends a> r111, View.OnClickListener r112) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "style");
        ArrayList r102 = new ArrayList();
        if (r110 != null) goto L5;
        r110 = CollectionsKt.emptyList();
    L5:
        r102.addAll(r110);
        r102.add(new com.bytedance.ee.bear.more.protocol3.checker.c(r100.f234853a));
        ArrayList r103 = new ArrayList();
        if (r111 != null) goto L8;
        r111 = CollectionsKt.emptyList();
    L8:
        r103.addAll(r111);
        r103.add(new com.bytedance.ee.bear.more.protocol3.checker.c(r100.f234853a));
        Iterator r113 = r102.iterator();
    L9:
        j r104 = null;
        if (r113.hasNext() == false) goto L16;
        m r114 = (m) r113.next();
        if ((r114 instanceof j) == false) goto L14;
        r104 = (j) r114;
    L14:
        if (r104 == null) goto L9;
        r104.f234897a = this;
        goto L9
    L16:
        Iterator r115 = r103.iterator();
    L18:
        if (r115.hasNext() == false) goto L25;
        a r116 = (a) r115.next();
        if ((r116 instanceof j) == false) goto L22;
        j r117 = (j) r116;
    L23:
        if (r117 == null) goto L18;
        r117.f234897a = this;
        goto L18
    L22:
        r117 = null;
        goto L23
    L25:
        h r118 = this.f234884a;
        if (r118 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r118 = null;
    L28:
        l r119 = r118.f234887b;
        if (r119 == null) goto L31;
        l r105 = r119;
    L33:
        return r105.b(r100, r101, r102, r103, r112);
    L31:
        Intrinsics.throwUninitializedPropertyAccessException("uiItemFactory");
        r105 = null;
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k i(g r100, f r101, e r102, List r110, List r111, View.OnClickListener r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        r102 = new e.f(false, false, false);
    L5:
        e r103 = r102;
        if ((r113 & 4) == 0) goto L8;
        List r104 = null;
    L10:
        if ((r113 & 8) == 0) goto L12;
        List r105 = null;
    L14:
        if ((r113 & 16) == 0) goto L16;
        View.OnClickListener r106 = null;
    L18:
        return r100.h(r101, r103, r104, r105, r106);
    L16:
        r106 = r112;
        goto L18
    L12:
        r105 = r111;
        goto L14
    L8:
        r104 = r110;
        goto L10
    }
}
