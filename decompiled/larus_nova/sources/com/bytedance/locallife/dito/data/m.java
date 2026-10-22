package com.bytedance.locallife.dito.data;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.locallife.dito.view.VisibleState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes21.dex */
public final class m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f258220f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DitoNode f258221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f258223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<m> f258224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VisibleState f258225e;

    public static final class a {
        public static Map a(m r100, Map r101, Map r102, Map r110) {
            Intrinsics.checkNotNullParameter(r100, "parentNode");
            Intrinsics.checkNotNullParameter(r101, "resultLayoutMap");
            Intrinsics.checkNotNullParameter(r102, "resultNodesMap");
            LinkedHashMap r103 = new LinkedHashMap();
            DitoNode r104 = r100.f258221a;
            r103.put(r100.f258222b, r100);
            if (r104 == null) goto L5;
            String r105 = r104.getType();
        L7:
            if (Intrinsics.areEqual(r105, KtvSubElement.CONTAINER) == false) goto L12;
            String r106 = r104.getSubType();
            if (r106 == null) goto L12;
            if (r110 == null) goto L12;
            m r107 = (m) r110.put(r106, r100);
        L12:
            List r108 = (List) r101.get(r100.f258222b);
            if (r108 != null) goto L15;
            r108 = new ArrayList();
        L15:
            Iterator r109 = r108.iterator();
        L17:
            if (r109.hasNext() == false) goto L33;
            String r111 = (String) r109.next();
            DitoNode r112 = (DitoNode) r102.get(r111);
            m r113 = new m(r112, r111, r100, 8);
            boolean r114 = false;
            if (r112 != null) goto L21;
        L23:
            boolean r115 = false;
        L24:
            if (r115 == false) goto L32;
            DitoNode r116 = r100.f258221a;
            if (r116 != null) goto L28;
        L30:
            if (r114 == false) goto L32;
            r112.setMultiColumn(true);
            goto L32
        L28:
            if (r116.getMultiColumn() != true) goto L30;
            r114 = true;
        L32:
            r103.putAll(a(r113, r101, r102, r110));
            r100.f258224d.add(r113);
            goto L17
        L21:
            if (r112.isComponentNode() != true) goto L23;
            r115 = true;
            goto L24
        L33:
            return r103;
        L5:
            r105 = null;
            goto L7
        }
    }

    static {
    }

    public final int f() {
        int r100 = this.f258224d.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L14;
        DitoNode r103 = ((m) ListProtector.get(this.f258224d, r101)).f258221a;
        if (r103 == null) goto L9;
        boolean r104 = true;
        if (r103.isComponentNode() != true) goto L9;
    L10:
        if (r104 == false) goto L12;
        r102 = r102 + 1;
    L13:
        r101 = r101 + 1;
        goto L3
    L12:
        r102 = r102 + ((m) ListProtector.get(this.f258224d, r101)).f();
    L9:
        r104 = false;
        goto L10
    L14:
        return r102;
    }

    public final m k() {
        m r100 = this.f258223c;
        if (r100 != null) goto L5;
        return null;
    L5:
        DitoNode r101 = r100.f258221a;
        if (r101 == null) goto L8;
        String r102 = r101.getType();
    L10:
        if (Intrinsics.areEqual(r102, "group") == true) goto L12;
        return null;
    L12:
        DitoNode r103 = r100.f258221a;
        if (r103 == null) goto L20;
        DitoStyle r104 = r103.getStyle();
        if (r104 == null) goto L20;
        if (r104.getBackgroundColor() == null) goto L20;
        return r100;
    L20:
        return r100.k();
    L8:
        r102 = null;
        goto L10
    }

    public final m l() {
        m r100 = this.f258223c;
        if (r100 != null) goto L5;
        return null;
    L5:
        DitoNode r101 = r100.f258221a;
        if (r101 == null) goto L8;
        String r102 = r101.getType();
    L10:
        if (Intrinsics.areEqual(r102, "group") == true) goto L12;
        return null;
    L12:
        DitoNode r103 = r100.f258221a;
        if (r103 == null) goto L20;
        DitoStyle r104 = r103.getStyle();
        if (r104 == null) goto L20;
        if (r104.getCornerRadius() == null) goto L20;
        return r100;
    L20:
        return r100.l();
    L8:
        r102 = null;
        goto L10
    }

    public final int q() {
        m r100 = this.f258223c;
        if (r100 == null) goto L20;
        List<m> r101 = r100.f258224d;
        if (r101 == null) goto L20;
        IntRange r102 = CollectionsKt.getIndices(r101);
        if (r102 == null) goto L20;
        int r103 = r102.getFirst();
        int r104 = r102.getLast();
        if (r103 > r104) goto L20;
        int r105 = 0;
    L13:
        if (Intrinsics.areEqual(ListProtector.get(this.f258223c.f258224d, r103), this) == true) goto L14;
        if (((m) ListProtector.get(this.f258223c.f258224d, r103)).f258221a == null) goto L18;
        r105 = r105 + 1;
    L18:
        if (r103 == r104) goto L20;
        r103 = r103 + 1;
        goto L13
    L14:
        return r105;
    L20:
        return 0;
    }

    public final boolean r() {
        DitoNode r100 = this.f258221a;
        if (r100 == null) goto L5;
        String r101 = r100.getType();
    L7:
        return Intrinsics.areEqual(r101, "component");
    L5:
        r101 = null;
        goto L7
    }

    public final boolean s() {
        DitoNode r100 = this.f258221a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isFloat();
    }

    public static m d(m r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DitoNode r101 = r100.f258221a;
        if (r101 == null) goto L8;
        String r102 = r101.getType();
    L10:
        if (Intrinsics.areEqual(r102, "component") == false) goto L12;
        return r100;
    L12:
        List<m> r103 = r100.f258224d;
        int r104 = r103.size();
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L18;
        m r106 = d((m) ListProtector.get(r103, r105));
        if (r106 != null) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        return r106;
    L18:
        return null;
    L8:
        r102 = null;
        goto L10
    }

    public static String h(m r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        DitoNode r102 = r100.f258221a;
        if (r102 == null) goto L9;
        r101 = r102.getType();
    L9:
        if (Intrinsics.areEqual(r101, KtvSubElement.CONTAINER) == false) goto L13;
        return r100.f258222b;
    L13:
        return h(r100.f258223c);
    }

    public static String i(m r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DitoNode r101 = r100.f258221a;
        if (r101 != null) goto L10;
        return i(r100.f258223c);
    L10:
        if (Intrinsics.areEqual(r101.getType(), KtvSubElement.CONTAINER) == false) goto L14;
        return r101.getSubType();
    L14:
        return i(r100.f258223c);
    }

    public static /* synthetic */ String j(m r100) {
        r100.getClass();
        return i(r100);
    }

    @Deprecated(message = "存在bug缺陷")
    public static m n(m r100) {
        String r101 = null;
        if (r100 == null) goto L28;
        m r102 = r100.f258223c;
        if (r102 == null) goto L28;
        List<m> r103 = r102.f258224d;
        if (r103 == null) goto L28;
        boolean r104 = true;
        int r105 = r103.indexOf(r100) - 1;
        if (r105 < 0) goto L29;
        m r106 = (m) ListProtector.get(r103, r105);
        DitoNode r107 = r106.f258221a;
        if (r107 == null) goto L16;
        r101 = r107.getType();
    L16:
        if (Intrinsics.areEqual(r101, "component") == true) goto L31;
        List<m> r108 = r106.f258224d;
        if (r108 != null) goto L21;
    L24:
        if (r104 == false) goto L27;
        return n(r106);
    L27:
        return n((m) CollectionsKt.last(r106.f258224d));
    L21:
        if (r108.isEmpty() == true) goto L24;
        r104 = false;
        goto L24
    L31:
        return r106;
    L29:
        return n(r100.f258223c);
    L28:
        return null;
    }

    public final boolean a(m r100) {
        m r101 = this;
    L3:
        String r102 = null;
        if (r101 == null) goto L6;
        m r103 = r101.f258223c;
    L7:
        if (r103 == null) goto L16;
        String r104 = r101.f258222b;
        if (r100 == null) goto L12;
        r102 = r100.f258222b;
    L12:
        if (Intrinsics.areEqual(r104, r102) == true) goto L13;
        r101 = r101.f258223c;
        goto L3
    L13:
        return true;
    L16:
        return false;
    L6:
        r103 = null;
        goto L7
    }

    public final int g(m r100) {
        Intrinsics.checkNotNullParameter(r100, "treeNode");
        DitoNode r101 = r100.f258221a;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L36;
        DitoNode r103 = this.f258221a;
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L36;
        int r105 = this.f258224d.size();
        int r106 = 0;
        int r107 = -1;
    L18:
        if (r106 >= r105) goto L36;
        DitoNode r108 = ((m) ListProtector.get(this.f258224d, r106)).f258221a;
        if (r108 != null) goto L22;
    L24:
        boolean r109 = false;
    L25:
        if (r109 == false) goto L27;
        r107 = r107 + 1;
    L31:
        if (Intrinsics.areEqual(ListProtector.get(this.f258224d, r106), r100) == true) goto L32;
        r106 = r106 + 1;
        goto L18
    L32:
        return r107;
    L27:
        int r110 = ((m) ListProtector.get(this.f258224d, r106)).g(r100);
        if (r110 != (-1)) goto L35;
        r107 = r107 + ((m) ListProtector.get(this.f258224d, r106)).f();
        goto L31
    L35:
        return (r107 + r110) + 1;
    L22:
        if (r108.isComponentNode() != true) goto L24;
        r109 = true;
        goto L25
    L13:
        if (r103.isGroupNode() != true) goto L15;
        r104 = true;
    L36:
        return -1;
    L5:
        if (r101.isComponentNode() != true) goto L7;
        r102 = true;
        goto L9
    }

    public final void p(List<m> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        DitoNode r101 = this.f258221a;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.getMultiColumn() != true) goto L7;
    L8:
        if (r102 == false) goto L12;
        m r103 = (m) CollectionsKt.lastOrNull(this.f258224d);
        if (r103 == null) goto L16;
        ((ArrayList) r100).add(r103);
        return;
    L16:
        return;
    L12:
        Iterator<T> r104 = this.f258224d.iterator();
    L14:
        if (r104.hasNext() == false) goto L19;
        ((m) r104.next()).p(r100);
        goto L14
    L19:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public static void b(Map r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "treeMap");
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<T> r102 = r101.f258224d.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        m r103 = (m) r102.next();
        r100.remove(r103.f258222b);
        b(r100, r103);
        goto L7
    }

    public static void c(Map r100, Map r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "nodesLayout");
        Intrinsics.checkNotNullParameter(r101, "nodesMap");
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = r102.f258222b;
        if (r103 != null) goto L8;
        return;
    L8:
        DitoNode r104 = r102.f258221a;
        if (r104 != null) goto L11;
        return;
    L11:
        r101.put(r103, r104);
        DitoNode r105 = r102.f258221a;
        if (r105 == null) goto L14;
        String r106 = r105.getType();
    L16:
        if (Intrinsics.areEqual(r106, "component") == false) goto L18;
        return;
    L18:
        ArrayList r107 = new ArrayList();
        r100.put(r103, r107);
        Iterator<T> r108 = r102.f258224d.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        m r109 = (m) r108.next();
        String r110 = r109.f258222b;
        if (r110 == null) goto L20;
        r107.add(r110);
        c(r100, r101, r109);
        goto L20
    L24:
        return;
    L14:
        r106 = null;
        goto L16
    }

    public static m o(m r100, m r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100;
    L5:
        if (r101 == null) goto L15;
        m r103 = r101.f258223c;
        if (r103 == null) goto L15;
        List<m> r104 = r103.f258224d;
        if (r104 == null) goto L15;
        int r105 = r104.indexOf(r101) - 1;
        if (r105 >= 0) goto L18;
        return o(r100, r101.f258223c, 2);
    L18:
        return (m) ListProtector.get(r104, r105);
    L15:
        return null;
    }

    public m(DitoNode r100, String r101, m r102, List<m> r103) {
        Intrinsics.checkNotNullParameter(r101, "nodeTag");
        Intrinsics.checkNotNullParameter(r103, "childList");
        this.f258221a = r100;
        this.f258222b = r101;
        this.f258223c = r102;
        this.f258224d = r103;
        this.f258225e = VisibleState.VISIBLE;
    }

    public static m e(m r100, m r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100;
    L6:
        if ((r103 & 2) == 0) goto L8;
        boolean r104 = true;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = false;
    L12:
        r100.getClass();
        if (r101 == null) goto L35;
        if (r104 == false) goto L23;
        DitoNode r105 = r101.f258221a;
        if (r105 == null) goto L19;
        String r106 = r105.getType();
    L21:
        if (Intrinsics.areEqual(r106, "component") == false) goto L23;
        return r101;
    L19:
        r106 = null;
    L23:
        List<m> r107 = r101.f258224d;
        int r108 = r107.size() - 1;
    L24:
        if ((-1) >= r108) goto L35;
        m r109 = (m) ListProtector.get(r107, r108);
        if (r102 == true) goto L28;
    L30:
        m r110 = e(r100, r109, false, 6);
        if (r110 == null) goto L33;
        return r110;
    L33:
        r108 = r108 - 1;
        goto L24
    L28:
        if (r109.f258221a != null) goto L30;
    L35:
        return null;
    L8:
        r104 = false;
        goto L10
    }

    public /* synthetic */ m(DitoNode r100, String r101, m r102, int r103) {
        ArrayList r104 = null;
        if ((r103 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r104 = new ArrayList();
    L8:
        this(r100, r101, r102, r104);
    }

    public final void m(m r110, int r111, Boolean r112, List<Float> r210, List<Float> r211, m r212, boolean r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r110, "leafNode");
        Intrinsics.checkNotNullParameter(r210, "totalMargin");
        Intrinsics.checkNotNullParameter(r211, "totalPadding");
        DitoNode r100 = this.f258221a;
        if (r100 == null) goto L5;
        String r101 = r100.getType();
    L7:
        if (Intrinsics.areEqual(r101, "group") == true) goto L9;
        return;
    L9:
        DitoNode r102 = this.f258221a;
        if (r102 == null) goto L15;
        DitoStyle r103 = r102.getStyle();
        if (r103 == null) goto L15;
        List<Float> r104 = r103.getMargin();
        if (r104 == null) goto L15;
    L17:
        if (r104.size() == 4) goto L19;
        return;
    L19:
        int r105 = g(r110);
        if (r111 == 1) goto L29;
        if (Intrinsics.areEqual(r112, Boolean.FALSE) == true) goto L29;
        if (r105 < 0) goto L27;
        if (r105 >= r111) goto L27;
        boolean r106 = true;
        boolean r113 = true;
    L36:
        Pair r114 = new Pair(Boolean.valueOf(r113), Boolean.valueOf(r106));
        boolean r107 = ((Boolean) r114.getFirst()).booleanValue();
        boolean r115 = ((Boolean) r114.getSecond()).booleanValue();
        if (r213 == true) goto L49;
        ListProtector.set(r211, 0, Float.valueOf(((Number) ListProtector.get(r211, 0)).floatValue() + ((Number) ListProtector.get(r104, 0)).floatValue()));
        if (r214 == false) goto L41;
        if (r107 == true) goto L41;
    L42:
        ListProtector.set(r211, 2, Float.valueOf(((Number) ListProtector.get(r211, 2)).floatValue() + ((Number) ListProtector.get(r104, 2)).floatValue()));
        if (r214 == false) goto L45;
        if (r115 == true) goto L45;
    L46:
        m r108 = this.f258223c;
        if (r108 == null) goto L61;
        r108.m(r110, r111, r112, r210, r211, r212, Intrinsics.areEqual(r212, r108), r214);
        return;
    L61:
        return;
    L45:
        ListProtector.set(r211, 3, Float.valueOf(((Number) ListProtector.get(r211, 3)).floatValue() + ((Number) ListProtector.get(r104, 3)).floatValue()));
    L41:
        ListProtector.set(r211, 1, Float.valueOf(((Number) ListProtector.get(r211, 1)).floatValue() + ((Number) ListProtector.get(r104, 1)).floatValue()));
        goto L42
    L49:
        ListProtector.set(r210, 0, Float.valueOf(((Number) ListProtector.get(r210, 0)).floatValue() + ((Number) ListProtector.get(r104, 0)).floatValue()));
        if (r214 == false) goto L52;
        if (r107 == true) goto L52;
    L53:
        ListProtector.set(r210, 2, Float.valueOf(((Number) ListProtector.get(r210, 2)).floatValue() + ((Number) ListProtector.get(r104, 2)).floatValue()));
        if (r214 == false) goto L56;
        if (r115 == true) goto L56;
    L57:
        m r109 = this.f258223c;
        if (r109 == null) goto L63;
        r109.m(r110, r111, r112, r210, r211, r212, true, r214);
        return;
    L63:
        return;
    L56:
        ListProtector.set(r210, 3, Float.valueOf(((Number) ListProtector.get(r210, 3)).floatValue() + ((Number) ListProtector.get(r104, 3)).floatValue()));
    L52:
        ListProtector.set(r210, 1, Float.valueOf(((Number) ListProtector.get(r210, 1)).floatValue() + ((Number) ListProtector.get(r104, 1)).floatValue()));
    L27:
        r106 = true;
        r113 = false;
    L29:
        if (r105 != 0) goto L31;
        r113 = true;
    L33:
        if (r105 != (f() - 1)) goto L35;
        r106 = true;
        goto L36
    L35:
        r106 = false;
        goto L36
    L31:
        r113 = false;
    L15:
        r104 = CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)});
        goto L17
    L5:
        r101 = null;
        goto L7
    }
}
