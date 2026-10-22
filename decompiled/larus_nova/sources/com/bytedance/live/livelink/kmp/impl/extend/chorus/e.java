package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import bg2.g;
import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import com.bytedance.live.livelink.kmp.impl.extend.model.MixedStreamConfigProxy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hi6.f;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zf2.d0;
import zf2.s;
import zf2.z;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements com.bytedance.live.livelink.kmp.impl.extend.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f255579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f255580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, com.bytedance.live.livelink.kmp.impl.extend.model.a> f255581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, d0> f255582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f255583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f255584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExtendContext f255585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f255586h;

    public final void b() {
        this.f255580b = false;
        this.f255583e = CollectionsKt.emptyList();
        ((LinkedHashMap) this.f255582d).clear();
        ((LinkedHashMap) this.f255581c).clear();
    }

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255585g;
    }

    public final void e(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "singerList");
        List<String> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
        int r101 = 0;
        int r102 = 0;
    L3:
        boolean r103 = true;
        if (r112.hasNext() == false) goto L15;
        Object r104 = r112.next();
        int r105 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r106 = (String) r104;
        if (r106.length() == 0) goto L12;
        r103 = false;
    L12:
        if (r103 == false) goto L14;
        r106 = "test_" + r102;
    L14:
        r100.add(r106);
        r102 = r105;
        goto L3
    L15:
        this.f255583e = r100;
        ((LinkedHashMap) this.f255581c).clear();
        if (this.f255580b == true) goto L18;
        return;
    L18:
        if (this.f255583e.size() <= 3) goto L75;
        List<String> r113 = this.f255583e;
        ArrayList r107 = new ArrayList();
        Iterator<T> r114 = r113.iterator();
    L22:
        if (r114.hasNext() == false) goto L26;
        Object r108 = r114.next();
        if (Intrinsics.areEqual((String) r108, this.f255584f) == true) goto L22;
        r107.add(r108);
        goto L22
    L26:
        List r115 = CollectionsKt.toMutableList(r107);
        Iterator r109 = ((LinkedHashMap) this.f255581c).entrySet().iterator();
    L27:
        Integer r116 = null;
        if (r109.hasNext() == false) goto L42;
        Map.Entry r117 = (Map.Entry) r109.next();
        ((Number) r117.getKey()).intValue();
        com.bytedance.live.livelink.kmp.impl.extend.model.a r118 = (com.bytedance.live.livelink.kmp.impl.extend.model.a) r117.getValue();
        if (r118.f255594c == false) goto L27;
        Integer r119 = Integer.valueOf(r115.indexOf(r118.f255592a));
        if (r119.intValue() < 0) goto L34;
        boolean r120 = true;
    L35:
        if (r120 == false) goto L37;
        r116 = r119;
    L37:
        if (r116 == null) goto L40;
        int r121 = r116.intValue();
        this.f255582d.put(r118.f255592a, r118.f255593b);
        if (((String) ListProtector.remove(r115, r121)) != null) goto L27;
    L40:
        r118.f255594c = false;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r118.f255592a = "";
        Unit r122 = Unit.INSTANCE;
        goto L27
    L34:
        r120 = false;
    L42:
        if (r101 >= r115.size()) goto L77;
        Iterator r123 = ((LinkedHashMap) this.f255581c).values().iterator();
    L45:
        if (r123.hasNext() == false) goto L49;
        Object r124 = r123.next();
        if ((!((com.bytedance.live.livelink.kmp.impl.extend.model.a) r124).f255594c) == false) goto L45;
    L50:
        com.bytedance.live.livelink.kmp.impl.extend.model.a r125 = (com.bytedance.live.livelink.kmp.impl.extend.model.a) r124;
        if (r125 == null) goto L76;
        r125.f255594c = true;
        String r126 = (String) ListProtector.get(r115, r101);
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r125.f255592a = r126;
        this.f255582d.put(r126, r125.f255593b);
        r101 = r101 + 1;
        goto L42
    L76:
        return;
    L49:
        r124 = null;
        goto L50
    L77:
        return;
    }

    public e(ExtendContext r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        Intrinsics.checkNotNullParameter(r101, "chorusScope");
        this.f255585g = r100;
        this.f255586h = r101;
        this.f255579a = new CompositeDisposable();
        this.f255581c = new LinkedHashMap();
        this.f255582d = new LinkedHashMap();
        this.f255583e = CollectionsKt.emptyList();
        this.f255584f = "#";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v20, types: [java.util.ArrayList] */
    public static final f a(e r100, com.bytedance.live.livelink.kmp.impl.extend.d r110) {
        r100.getClass();
        HashMap<String, Object> r111 = r110.f255589a;
        if (r111 == null) goto L64;
        Object r112 = r111.get("mixedConfig");
        if (r112 == null) goto L65;
        MixedStreamConfigProxy r101 = new MixedStreamConfigProxy(r112);
        if (r100.f255586h.h() == false) goto L48;
        if (Intrinsics.areEqual(r100.f255584f, "#") == true) goto L48;
        if (r100.f255580b == true) goto L16;
    L46:
        ((com.bytedance.live.livelink.kmp.impl.extend.model.c) r101.f255591b.getValue()).f255596a.getClass();
        goto L48
    L16:
        if (r100.f255583e.size() <= 3) goto L46;
        com.bytedance.live.livelink.kmp.impl.extend.model.c r113 = (com.bytedance.live.livelink.kmp.impl.extend.model.c) r101.f255591b.getValue();
        r113.f255596a.getClass();
        d0 r102 = new d0(0);
        Intrinsics.checkNotNullParameter(r102, "value");
        r113.f255596a.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        s r103 = new s(new z(), new z(), new z());
        Intrinsics.checkNotNullParameter(r103, "value");
        r113.f255596a.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        g[] r114 = r101.f255590a.f18873h;
        if (r114 == null) goto L33;
        ArrayList r104 = new ArrayList();
        int r105 = r114.length;
        int r106 = 0;
    L21:
        if (r106 >= r105) goto L29;
        g r107 = r114[r106];
        if (r107 == null) goto L25;
        boolean r108 = true;
    L26:
        if (r108 == false) goto L28;
        r104.add(r107);
    L28:
        r106 = r106 + 1;
        goto L21
    L25:
        r108 = false;
        goto L26
    L29:
        ?? r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r109 = r104.iterator();
    L31:
        if (r109.hasNext() == false) goto L34;
        g r116 = (g) r109.next();
        Intrinsics.checkNotNull(r116);
        r115.add(new com.bytedance.live.livelink.kmp.impl.extend.model.b(r116));
    L34:
        Iterator r117 = ((Iterable) r115).iterator();
    L36:
        if (r117.hasNext() == false) goto L48;
        com.bytedance.live.livelink.kmp.impl.extend.model.b r118 = (com.bytedance.live.livelink.kmp.impl.extend.model.b) r117.next();
        String r119 = r118.f255595a.f18891a;
        if (Intrinsics.areEqual(r119, r100.f255584f) == true) goto L39;
        if (r100.f255582d.containsKey(r119) == true) goto L42;
        r118.f255595a.f18907q = false;
        goto L36
    L42:
        r118.f255595a.f18907q = true;
        d0 r120 = (d0) ((LinkedHashMap) r100.f255582d).get(r119);
        if (r120 == null) goto L36;
        Intrinsics.checkNotNullParameter(r120, "value");
        r118.f255595a.getClass();
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        goto L36
    L39:
        r118.f255595a.f18907q = false;
        goto L36
    L33:
        r115 = CollectionsKt.emptyList();
    L48:
        return com.bytedance.live.livelink.kmp.impl.extend.d.f255587b;
    L65:
        return com.bytedance.live.livelink.kmp.impl.extend.d.f255587b;
    L64:
        return com.bytedance.live.livelink.kmp.impl.extend.d.f255587b;
    }

    public final void d(zi6.c r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "layout");
        this.f255580b = true;
        if (Intrinsics.areEqual(r110, zi6.c.C8463c.f572263a) == false) goto L5;
        Map<Integer, com.bytedance.live.livelink.kmp.impl.extend.model.a> r112 = this.f255581c;
        r112.put(0, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(1, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(2, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(3, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(4, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(5, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(6, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(7, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(8, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r112.put(9, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        return;
    L5:
        Map<Integer, com.bytedance.live.livelink.kmp.impl.extend.model.a> r113 = this.f255581c;
        r113.put(0, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(1, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(2, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(3, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(4, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(5, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(6, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(7, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(8, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
        r113.put(9, new com.bytedance.live.livelink.kmp.impl.extend.model.a(new d0(0)));
    }
}
