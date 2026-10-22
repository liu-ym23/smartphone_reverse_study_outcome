package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.FindSameHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeadViewHolderBuilder {
    public final r a;
    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> b;
    public final Function0<Boolean> c;
    public final HashMap<n, List<String>> d;
    public Map<String, ? extends n> e;
    public final e f;
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> g;

    public final CommonFindSameElement a() {
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> r0 = this.b;
        if (r0 == null) goto L18;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r2).getType(), HeadViewType.FIND_SAME.getType()) == false) goto L6;
    L11:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r2;
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.r;
    L10:
        r2 = null;
        goto L11
    L18:
        return null;
    }

    public final List<a> b() {
        ArrayList r0 = new ArrayList();
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r1 = this.g.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(r1.next().c);
        goto L4
    L6:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<n, List<String>>> r3 = this.d.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        Map.Entry<n, List<String>> r4 = r3.next();
        n r5 = r4.getKey();
        Iterator<String> r6 = r4.getValue().iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        r2.put(r6.next(), r5);
        goto L11
    L13:
        this.e = r2;
        this.b = r0;
        if (com.bytedance.android.ec.core.opt.ab.c.d() == false) goto L38;
        Iterator r7 = ((ArrayList) com.bytedance.android.shopping.anchorv4.voavhs.head.d.a(this.g)).iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r8).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L17;
    L22:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r9 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r8;
        if (r9 == null) goto L38;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r10 = r9.i;
        if (r10 == null) goto L27;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.d(r10);
    L27:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r11 = r9.i;
        if (r11 == null) goto L30;
        r11.i();
    L30:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r12 = r9.i;
        if (r12 == null) goto L33;
        r12.g();
    L33:
        String r13 = r9.G;
        if (r13 == null) goto L38;
        u83.a r14 = g33.b.b.j();
        if (r14 == null) goto L38;
        r14.d(r13, HeadViewHolderBuilder$getHeadViewHolders$2$1$1.INSTANCE);
        goto L38
    L21:
        r8 = null;
    L38:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r0.iterator();
        int r17 = 0;
    L40:
        if (r16.hasNext() == false) goto L56;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r20 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r18;
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.j.a() == false) goto L49;
        n r21 = this.e.get(r20.getType());
        if (r21 == null) goto L52;
        com.bytedance.android.shopping.anchorv3.detail.widget.l r22 = r21.h(r20, r17);
    L53:
        if (r22 == null) goto L55;
        r15.add(r22);
    L55:
        r17 = r19;
    L52:
        r22 = null;
        goto L53
    L49:
        n r23 = this.e.get(r20.getType());
        if (r23 == null) goto L52;
        r22 = r23.o(r20, r17);
        goto L53
    L56:
        return r15;
    }

    public final int c() {
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> r0 = com.bytedance.android.shopping.anchorv4.voavhs.head.d.a(this.g);
        if (r0.isEmpty() == true) goto L28;
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L20;
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r1.next();
        if (Intrinsics.areEqual(r3.getType(), HeadViewType.VIDEO.getType()) == false) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L7;
        r2 = r2 + 1;
        if (r2 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        if (Intrinsics.areEqual(r3.getType(), HeadViewType.GOOD_COMMENT.getType()) == true) goto L14;
        r4 = false;
        goto L15
    L20:
        return r2;
    L28:
        return 0;
    }

    public final void d() {
        Iterator<T> r0 = com.bytedance.android.shopping.anchorv4.voavhs.head.d.a(this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r1).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L4;
    L9:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r2 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r1;
        if (r2 == null) goto L16;
        String r3 = r2.G;
        if (r3 == null) goto L16;
        u83.a r4 = g33.b.b.j();
        if (r4 == null) goto L16;
        r4.a(r3);
    L16:
        e83.a r5 = e83.a.d;
        r5.getClass();
        e83.a.b.clear();
        e83.a.c = null;
        r5.a.a();
        Iterator<n> r6 = this.d.keySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L25;
        n r7 = r6.next();
        if ((r7 instanceof h) == true) goto L22;
        r7 = null;
    L22:
        h r8 = (h) r7;
        if (r8 == null) goto L18;
        r8.onDestroy();
        goto L18
    L25:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void e() {
        Iterator<n> r0 = this.d.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        n r1 = r0.next();
        if ((r1 instanceof h) == true) goto L8;
        r1 = null;
    L8:
        h r2 = (h) r1;
        if (r2 == null) goto L4;
        r2.onPause();
        goto L4
    }

    public final void f() {
        Iterator<n> r0 = this.d.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        n r1 = r0.next();
        if ((r1 instanceof h) == true) goto L8;
        r1 = null;
    L8:
        h r2 = (h) r1;
        if (r2 == null) goto L4;
        r2.onResume();
        goto L4
    }

    public final void g(float r4) {
        Iterator<n> r0 = this.d.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        n r1 = r0.next();
        if ((r1 instanceof h) == true) goto L8;
        r1 = null;
    L8:
        h r2 = (h) r1;
        if (r2 == null) goto L4;
        r2.i(r4);
        goto L4
    }

    public final void h(List<Float> r6) {
        Intrinsics.checkNotNullParameter(r6, "progresses");
        r r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "progresses");
        Iterator<T> r7 = r6.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L17;
        Object r2 = r7.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        float r4 = ((Number) r2).floatValue();
        if (r0 >= ((ArrayList) r1.j).size()) goto L23;
        if (r4 <= 0.0f) goto L16;
        if (r4 >= 100.0f) goto L16;
        ((com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b) ListProtector.get(r1.j, r0)).c(r4);
    L16:
        r0 = r3;
        goto L4
    L23:
        return;
    }

    public final void update(List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r5) {
        Intrinsics.checkNotNullParameter(r5, "newList");
        ArrayList r0 = new ArrayList();
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.addAll(r6.next().c);
        goto L4
    L6:
        Unit r7 = Unit.INSTANCE;
        this.b = r0;
        ArrayList r8 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L15;
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r2 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r1.next();
        n r3 = this.e.get(r2.getType());
        if (r3 == null) goto L12;
        r3.m(r2);
        Unit r4 = Unit.INSTANCE;
    L13:
        if (r4 == null) goto L8;
        r8.add(r4);
        goto L8
    L12:
        r4 = null;
        goto L13
    }

    public HeadViewHolderBuilder(Context r5, e r6, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r7, l53.b r8, d r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "headNodeGroupList");
        this.f = r6;
        this.g = r7;
        r r11 = new r(r5, r9, r8, r10);
        this.a = r11;
        Function0<Boolean> r12 = new HeadViewHolderBuilder$queryIfShownInSmallScreenMode$1(this);
        this.c = r12;
        HashMap<n, List<String>> r13 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r11, CollectionsKt.listOf(new String[]{HeadViewType.VIDEO.getType(), HeadViewType.GOOD_COMMENT.getType()})), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.h(r5, r9), CollectionsKt.listOf(HeadViewType.PICTURE.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.n(r5, r9), CollectionsKt.listOf(HeadViewType.SIMPLE_LINK.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.a(r5, r9), CollectionsKt.listOf(HeadViewType.COMMENT.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.c(r5, r9), CollectionsKt.listOf(HeadViewType.SHOW.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.j(r5, r9), CollectionsKt.listOf(HeadViewType.COMBINATION.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.m(r5, r9, r12), CollectionsKt.listOf(HeadViewType.SIZE.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.p(r5, r9), CollectionsKt.listOf(HeadViewType.SKU.getType())), TuplesKt.to(new FindSameHolderBuilder(r5, r9), CollectionsKt.listOf(HeadViewType.FIND_SAME.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.k(r5, r9), CollectionsKt.listOf(HeadViewType.PIONEER.getType()))});
        this.d = r13;
        this.e = MapsKt.emptyMap();
        e83.a r14 = e83.a.d;
        List r15 = CollectionsKt.toList(r13.keySet());
        Function0<List<? extends com.bytedance.android.shopping.anchorv4.voavhs.head.c>> r16 = new AnonymousClass1(this);
        r14.getClass();
        e83.a.b(r15, r16);
    }
}
