package com.bytedance.kmp.ec.yata.common.protocol.utils;

import com.bytedance.kmp.ec.yata.common.protocol.data.i;
import com.bytedance.kmp.ec.yata.common.protocol.data.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa6.b f251558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa6.b f251559b;

    public static final class a {
        public static void a(i r100, String r101, String r102, Function2 r103) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r103, "continueVisitor");
            if (r102 != null) goto L6;
            return;
        L6:
            if (((Boolean) r103.invoke(r101, r102)).booleanValue() == false) goto L16;
            Map<String, List<String>> r104 = r100.h();
            if (r104 == null) goto L11;
            List<String> r105 = r104.get(r102);
            if (r105 == null) goto L11;
        L12:
            Iterator<String> r106 = r105.iterator();
        L14:
            if (r106.hasNext() == false) goto L18;
            a(r100, r102, r106.next(), r103);
            goto L14
        L18:
            return;
        L11:
            r105 = CollectionsKt.emptyList();
            goto L12
        }
    }

    static {
    }

    public e(aa6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "originData");
        this.f251558a = r100;
        this.f251559b = r100.a(1);
    }

    public final void a(final com.bytedance.android.shopping.orderlist.list.cache.a r100) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        String[] r101 = new String[1];
        i r102 = this.f251558a.g();
        if (r102 == null) goto L5;
        String r103 = r102.g();
    L6:
        r101[0] = r103;
        List r104 = CollectionsKt.mutableListOf(r101);
        i r105 = this.f251558a.g();
        if (r105 == null) goto L11;
        List<String> r106 = r105.e();
        if (r106 == null) goto L11;
    L12:
        r104.addAll(r106);
        i r107 = this.f251558a.g();
        if (r107 == null) goto L17;
        List<String> r108 = r107.c();
        if (r108 == null) goto L17;
    L18:
        r104.addAll(r108);
        Iterator r109 = r104.iterator();
    L20:
        if (r109.hasNext() == false) goto L33;
        String r110 = (String) r109.next();
        i r111 = this.f251558a.g();
        if (r111 == null) goto L24;
        a.a(r111, null, r110, new YataProtocolModifierV2$dfsVisitOriginFacadeNode$1(this, r100));
    L24:
        i r112 = this.f251559b.g();
        if (r112 == null) goto L27;
        j.b(r112);
    L27:
        i r113 = this.f251559b.g();
        if (r113 == null) goto L30;
        j.a(r113);
    L30:
        i r114 = this.f251559b.g();
        if (r114 == null) goto L20;
        a.a(r114, null, r110, new YataProtocolModifierV2$dfsVisitResultNodeData$1(this, r100));
        goto L20
    L33:
        String[] r115 = new String[1];
        i r116 = this.f251559b.g();
        if (r116 == null) goto L36;
        String r117 = r116.g();
    L37:
        r115[0] = r117;
        List r118 = CollectionsKt.mutableListOf(r115);
        i r119 = this.f251559b.g();
        if (r119 == null) goto L42;
        List<String> r120 = r119.e();
        if (r120 == null) goto L42;
    L43:
        r118.addAll(r120);
        i r121 = this.f251559b.g();
        if (r121 == null) goto L48;
        List<String> r122 = r121.c();
        if (r122 == null) goto L48;
    L49:
        r118.addAll(r122);
        final LinkedHashMap r123 = new LinkedHashMap();
        Iterator r124 = r118.iterator();
    L51:
        if (r124.hasNext() == false) goto L55;
        String r125 = (String) r124.next();
        i r126 = this.f251559b.g();
        if (r126 == null) goto L51;
        a.a(r126, null, r125, new YataProtocolModifierV2$clearResultNodeData$1$1(this, r123));
        goto L51
    L55:
        this.f251559b.m(r123);
        return;
    L48:
        r122 = CollectionsKt.emptyList();
    L42:
        r120 = CollectionsKt.emptyList();
        goto L43
    L36:
        r117 = null;
    L17:
        r108 = CollectionsKt.emptyList();
    L11:
        r106 = CollectionsKt.emptyList();
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
