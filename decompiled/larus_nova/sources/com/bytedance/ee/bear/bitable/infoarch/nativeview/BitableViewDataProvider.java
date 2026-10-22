package com.bytedance.ee.bear.bitable.infoarch.nativeview;

import dt4.d;
import dt4.e;
import dt4.f;
import dt4.i;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableViewDataProvider implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, d> f213244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<? super Boolean, ? super HashMap<String, Boolean>, ? extends d> f213245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, e> f213246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<? super Boolean, ? super HashMap<String, Boolean>, ? extends e> f213247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, f> f213248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<? super Boolean, ? super HashMap<String, Boolean>, ? extends f> f213249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ct4.f f213250g;

    public BitableViewDataProvider() {
        this.f213244a = new HashMap();
        this.f213245b = BitableViewDataProvider$cardDataProviderBuilder$1.INSTANCE;
        this.f213246c = new HashMap();
        this.f213247d = BitableViewDataProvider$galleryDataProviderBuilder$1.INSTANCE;
        this.f213248e = new HashMap();
        this.f213249f = BitableViewDataProvider$gridDataProviderBuilder$1.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.a
    public final void b(ct4.f r100) {
        this.f213250g = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.a
    public final f a(String r100, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r110, "viewId");
        Intrinsics.checkNotNullParameter(r112, "groupUniqueKey");
        return (f) f(r100, r110, r111, this.f213248e, this.f213249f, r112);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.a
    public final e c(String r100, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r110, "viewId");
        Intrinsics.checkNotNullParameter(r112, "groupUniqueKey");
        return (e) f(r100, r110, r111, this.f213246c, this.f213247d, r112);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.a
    public final d d(String r100, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r110, "viewId");
        Intrinsics.checkNotNullParameter(r112, "groupUniqueKey");
        return (d) f(r100, r110, r111, this.f213244a, this.f213245b, r112);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.a
    public final void e(String r110, String r111, boolean r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "tableId");
        Intrinsics.checkNotNullParameter(r111, "viewId");
        Intrinsics.checkNotNullParameter(r114, "groupUniqueKey");
        if (this.f213250g != null) goto L5;
        return;
    L5:
        String r100 = r110 + r111;
        String r101 = r110 + '-' + r111;
        if (r113 == false) goto L8;
        HashMap<String, Boolean> r102 = d(r110, r111, r112, r114).b1();
    L9:
        ct4.f r103 = this.f213250g;
        if (r103 == null) goto L17;
        Intrinsics.checkNotNullParameter(r101, "tableViewKey");
        HashMap<String, ct4.c> r104 = r103.f465351a.f465345a;
        if (r104 == null) goto L17;
        ct4.c r105 = r104.get(r101);
        if (r105 == null) goto L17;
        String r106 = r105.f465349a;
        if (r106 == null) goto L17;
    L18:
        boolean r107 = true;
        if (r106.length() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L24;
    L26:
        r107 = false;
    L27:
        if (r107 == false) goto L29;
        r102.clear();
    L29:
        if (r113 == true) goto L31;
    L33:
        if (r113 == false) goto L35;
    L37:
        ct4.f r115 = this.f213250g;
        if (r115 == null) goto L49;
        Intrinsics.checkNotNullParameter(r101, "tableViewKey");
        Intrinsics.checkNotNullParameter(r102, "collapsedGroupMap");
        Intrinsics.checkNotNullParameter(r114, "groupUniqueKey");
        HashMap<String, ct4.c> r116 = r115.f465351a.f465345a;
        if (r116 == null) goto L43;
        ct4.c r117 = r116.get(r101);
        if (r117 == null) goto L43;
    L44:
        r117.f465350b.clear();
        r117.f465350b.putAll(r102);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r117.f465349a = r114;
        HashMap<String, ct4.c> r118 = r115.f465351a.f465345a;
        if (r118 == null) goto L47;
        ct4.c r119 = r118.put(r101, r117);
    L47:
        tt5.a.h("NativeBizCacheController", "putBaseBizCache,groupCacheMap is change");
        return;
    L43:
        r117 = new ct4.c();
        goto L44
    L49:
        return;
    L35:
        if (this.f213244a.containsKey(r100) == false) goto L37;
        d(r110, r111, r112, r114).Y1(r102);
        goto L37
    L31:
        if (this.f213248e.containsKey(r100) == false) goto L33;
        a(r110, r111, r112, r114).Y1(r102);
        goto L37
    L24:
        if (Intrinsics.areEqual(r106, r114) == true) goto L26;
    L21:
        r108 = false;
    L17:
        r106 = "";
        goto L18
    L8:
        r102 = a(r110, r111, r112, r114).b1();
        goto L9
    }

    public final <T extends i> T f(String r100, String r101, boolean r110, HashMap<String, T> r111, Function2<? super Boolean, ? super HashMap<String, Boolean>, ? extends T> r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r101, "viewId");
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r112, "builder");
        Intrinsics.checkNotNullParameter(r113, "groupUniqueKey");
        String r102 = r100 + r101;
        T r103 = r111.get(r102);
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        boolean r105 = true ^ r104;
        if (r105 == false) goto L11;
        b.c("getProvider>>> partialChange. new:" + r110 + ". ", false);
    L11:
        if (r103 == null) goto L13;
        if (r105 == true) goto L13;
        return r103;
    L13:
        Boolean r114 = Boolean.valueOf(r110);
        String r106 = r100 + '-' + r101;
        ct4.f r107 = this.f213250g;
        if (r107 == null) goto L30;
        Intrinsics.checkNotNullParameter(r106, "tableViewKey");
        Intrinsics.checkNotNullParameter(r113, "groupUniqueKey");
        HashMap<String, ct4.c> r108 = r107.f465351a.f465345a;
        if (r108 == null) goto L18;
        ct4.c r109 = r108.get(r106);
    L19:
        if (r109 == null) goto L22;
        String r115 = r109.f465349a;
        if (r115 == null) goto L22;
    L24:
        if (Intrinsics.areEqual(r113, r115) == false) goto L29;
        if (r109 == null) goto L28;
        HashMap<String, Boolean> r116 = r109.f465350b;
        if (r116 == null) goto L28;
    L31:
        T r117 = r112.invoke(r114, r116);
        r111.put(r102, r117);
        return r117;
    L28:
        r116 = new HashMap();
        goto L31
    L29:
        r116 = new HashMap();
    L22:
        r115 = "";
        goto L24
    L18:
        r109 = null;
        goto L19
    L30:
        r116 = new HashMap();
        goto L31
    L5:
        if (r103.m() != r110) goto L7;
        r104 = true;
        goto L8
    }
}
