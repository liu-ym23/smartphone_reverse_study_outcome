package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.q1;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.y1;
import cq8.a0;
import cq8.t0;
import cq8.u0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public class s extends com.larus.bmhome.instruction.core.impl.base.b implements com.larus.bmhome.instruction.core.impl.base.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public k0 f312015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f312016q;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        k0 r100 = this.f312015p;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295266e, Boolean.TRUE);
    L6:
        if (r101 == true) goto L8;
    L9:
        return true;
    L8:
        if (g() != null) goto L9;
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.h
    public final List<com.larus.bmhome.instruction.core.impl.base.d> b() {
        k0 r100 = this.f312015p;
        t1 r101 = null;
        if (r100 == null) goto L20;
        List<y1> r102 = r100.f295264c;
        if (r102 == null) goto L20;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        Integer r105 = ((y1) r104).f295583g;
        if (r105 != null) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L8;
    L19:
        y1 r107 = (y1) r104;
    L21:
        if (r107 == null) goto L23;
        r101 = r107.f295581e;
    L28:
        if (r101 != null) goto L32;
        return CollectionsKt.emptyList();
    L32:
        return CollectionsKt.listOf(new com.larus.bmhome.instruction.core.impl.base.l(getWidgetId(), r101, true));
    L23:
        k0 r108 = this.f312015p;
        if (r108 == null) goto L28;
        y1 r109 = r108.f295263b;
        if (r109 == null) goto L28;
        r101 = r109.f295581e;
        goto L28
    L13:
        if (r105.intValue() != 1) goto L15;
        r106 = true;
        goto L16
    L18:
        r104 = null;
    L20:
        r107 = null;
        goto L21
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public a0 d() {
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        k0 r102 = this.f312015p;
        boolean r103 = this.f312016q;
        com.larus.bmhome.actionbar.model.u r104 = this.f311920b;
        String r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.f295476c;
        if (r106 == null) goto L9;
        if ((!StringsKt.isBlank(r106)) == false) goto L9;
        String r107 = r106;
    L10:
        com.larus.bmhome.actionbar.model.u r108 = this.f311920b;
        if (r108 == null) goto L13;
        boolean r109 = Intrinsics.areEqual(r108.f295479f, Boolean.TRUE);
    L14:
        com.larus.bmhome.instruction.core.impl.base.c r110 = this.f311921c;
        if (r110 == null) goto L21;
        aq8.d r111 = r110.f311935a;
        if (r111 == null) goto L21;
        dq8.h r112 = r111.f15937a;
        if (r112 == null) goto L21;
        String r113 = r112.getBotId();
    L22:
        com.larus.bmhome.instruction.core.impl.base.c r114 = this.f311921c;
        if (r114 == null) goto L29;
        aq8.d r115 = r114.f311935a;
        if (r115 == null) goto L29;
        dq8.h r116 = r115.f15937a;
        if (r116 == null) goto L29;
        String r117 = r116.getChatType();
    L30:
        com.larus.bmhome.instruction.core.impl.base.c r118 = this.f311921c;
        if (r118 == null) goto L37;
        aq8.d r119 = r118.f311935a;
        if (r119 == null) goto L37;
        dq8.h r120 = r119.f15937a;
        if (r120 == null) goto L37;
        String r121 = r120.getTemplateType();
    L38:
        com.larus.bmhome.instruction.core.impl.base.c r122 = this.f311921c;
        if (r122 == null) goto L47;
        aq8.d r123 = r122.f311935a;
        if (r123 == null) goto L47;
        dq8.h r124 = r123.f15937a;
        if (r124 == null) goto L47;
        Integer r125 = r124.getInstructionType();
        if (r125 == null) goto L47;
        String r126 = r125.toString();
    L48:
        com.larus.bmhome.instruction.core.impl.base.c r127 = this.f311921c;
        if (r127 == null) goto L55;
        aq8.d r128 = r127.f311935a;
        if (r128 == null) goto L55;
        dq8.h r129 = r128.f15937a;
        if (r129 == null) goto L55;
        String r130 = r129.a();
    L56:
        com.larus.bmhome.instruction.core.impl.base.c r131 = this.f311921c;
        if (r131 == null) goto L63;
        aq8.d r132 = r131.f311935a;
        if (r132 == null) goto L63;
        dq8.h r133 = r132.f15937a;
        if (r133 == null) goto L63;
        String r134 = r133.b();
    L64:
        com.larus.bmhome.instruction.core.impl.base.c r135 = this.f311921c;
        if (r135 == null) goto L71;
        aq8.d r136 = r135.f311935a;
        if (r136 == null) goto L71;
        dq8.h r137 = r136.f15937a;
        if (r137 == null) goto L71;
        Boolean r138 = r137.isCreationActionBar();
    L72:
        com.larus.bmhome.actionbar.model.u r139 = this.f311920b;
        if (r139 == null) goto L79;
        String r140 = r139.f295476c;
        if (r140 == null) goto L79;
        if ((!StringsKt.isBlank(r140)) == false) goto L79;
        String r141 = r140;
    L80:
        com.larus.bmhome.instruction.core.impl.base.c r142 = this.f311921c;
        if (r142 == null) goto L88;
        aq8.d r143 = r142.f311935a;
        if (r143 == null) goto L88;
        dq8.h r144 = r143.f15937a;
        if (r144 == null) goto L88;
        r105 = r144.c();
    L88:
        return new u0(r100, r101, r102, r103, r107, r109, new z0(r113, r117, r121, r105, r126, r130, r134, r138, r141, 2));
    L79:
        r141 = null;
    L71:
        r138 = null;
    L63:
        r134 = null;
    L55:
        r130 = null;
    L47:
        r126 = null;
    L37:
        r121 = null;
    L29:
        r117 = null;
    L21:
        r113 = null;
        goto L22
    L13:
        r109 = false;
    L9:
        r107 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        k0 r100 = this.f312015p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<y1> r102 = r100.f295264c;
        boolean r103 = false;
        if (r102 == null) goto L19;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        Integer r107 = ((y1) r106).f295583g;
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L9;
        r104.add(r106);
        goto L9
    L14:
        if (r107.intValue() != 1) goto L16;
        r108 = true;
    L20:
        k0 r109 = this.f312015p;
        if (r109 == null) goto L32;
        if (r104 != null) goto L24;
    L27:
        boolean r110 = true;
    L28:
        if (r110 == false) goto L30;
        ArrayList r111 = null;
    L31:
        k0 r112 = k0.d(r109, r111);
    L33:
        if (r104 != null) goto L35;
    L36:
        r103 = true;
    L37:
        if (r103 == false) goto L54;
        k0 r113 = this.f312015p;
        if (r113 == null) goto L41;
        y1 r114 = r113.f295263b;
    L42:
        if (r114 != null) goto L54;
        return null;
    L41:
        r114 = null;
    L54:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L46
        Object r116 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(k0.Companion.serializer()), r112));     // Catch: Throwable -> L46
    L49:
        if (Result.m9455isFailureimpl(r116) == true) goto L53;
        r101 = r116;
    L53:
        return (String) r101;
    L46:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L35:
        if (r104.isEmpty() == false) goto L37;
    L30:
        r111 = r104;
        goto L31
    L24:
        if (r104.isEmpty() == true) goto L27;
        r110 = false;
        goto L28
    L32:
        r112 = null;
        goto L33
    L19:
        r104 = null;
        goto L20
    }

    public s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "controllerLogName");
        super(r100);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if ((r110 instanceof t0) == false) goto L100;
        this.f312016q = false;
        k0 r100 = this.f312015p;
        if (r100 != null) goto L7;
        return;
    L7:
        List<y1> r101 = r100.f295264c;
        if (r101 != null) goto L10;
        return;
    L10:
        List<y1> r102 = r101;
        Iterator<T> r103 = r102.iterator();
    L11:
        boolean r104 = true;
        Object r105 = null;
        if (r103.hasNext() == false) goto L22;
        Object r106 = r103.next();
        Integer r107 = ((y1) r106).f295577a;
        int r108 = ((t0) r110).f464959c;
        if (r107 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L11;
    L23:
        y1 r111 = (y1) r106;
        if (r111 != null) goto L26;
        return;
    L26:
        boolean r112 = Intrinsics.areEqual(r100.f295266e, Boolean.TRUE);
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r102.iterator();
    L28:
        if (r114.hasNext() == false) goto L38;
        Object r115 = r114.next();
        Integer r116 = ((y1) r115).f295583g;
        if (r116 != null) goto L33;
    L35:
        boolean r117 = false;
    L36:
        if (r117 == false) goto L28;
        r113.add(r115);
        goto L28
    L33:
        if (r116.intValue() != 1) goto L35;
        r117 = true;
        goto L36
    L38:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r113.iterator();
    L40:
        if (r119.hasNext() == false) goto L44;
        Integer r120 = ((y1) r119.next()).f295577a;
        if (r120 == null) goto L40;
        r118.add(r120);
        goto L40
    L44:
        Set r121 = CollectionsKt.toSet(r118);
        Integer r122 = r111.f295583g;
        if (r122 != null) goto L48;
    L50:
        r104 = false;
    L51:
        if (r112 == false) goto L53;
        Integer r123 = Integer.valueOf(((t0) r110).f464959c);
    L56:
        if (r123 == null) goto L58;
        Set r124 = SetsKt.setOf(Integer.valueOf(r123.intValue()));
    L59:
        if (r124 != null) goto L62;
        r124 = SetsKt.emptySet();
    L62:
        if (Intrinsics.areEqual(r121, r124) == false) goto L71;
        Iterator<T> r125 = r102.iterator();
    L65:
        if (r125.hasNext() == false) goto L69;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((y1) r126).f295577a, r123) == false) goto L65;
        r105 = r126;
    L69:
        q((y1) r105, false);
        return;
    L71:
        p(r101, r123);
        Iterator<T> r127 = r102.iterator();
    L73:
        if (r127.hasNext() == false) goto L77;
        Object r128 = r127.next();
        if (Intrinsics.areEqual(((y1) r128).f295577a, r123) == false) goto L73;
        r105 = r128;
    L77:
        q((y1) r105, false);
        j();
        return;
    L58:
        r124 = null;
        goto L59
    L53:
        if (r104 == false) goto L55;
        r123 = null;
        goto L56
    L55:
        r123 = Integer.valueOf(((t0) r110).f464959c);
        goto L56
    L48:
        if (r122.intValue() != 1) goto L50;
    L17:
        if (r107.intValue() != r108) goto L19;
        r109 = true;
        goto L20
    L22:
        r106 = null;
        goto L23
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        int r102 = -1;
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        k0 r105 = (k0) xt7.d.f565073b.c(kuc.a.d(k0.Companion.serializer()), r100);     // Catch: Throwable -> L21
        if (r105 != null) goto L16;
        r105 = null;
    L19:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L21
    L23:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L81;
        k0 r108 = (k0) r106;
        if (r108 == null) goto L28;
        List<y1> r109 = r108.f295264c;
    L29:
        List<y1> r110 = r109;
        if (r110 != null) goto L32;
    L35:
        boolean r111 = true;
    L36:
        if (r111 == true) goto L38;
        this.f312015p = r108;
        if (r108 == null) goto L79;
        List<y1> r112 = r108.f295264c;
        if (r112 == null) goto L79;
        Integer r113 = r108.f295265d;
        if (r113 == null) goto L48;
        r102 = r113.intValue();
    L48:
        if (r102 < 0) goto L52;
        y1 r114 = (y1) CollectionsKt.getOrNull(r112, r102);
        if (r114 == null) goto L52;
        Integer r115 = r114.f295577a;
    L53:
        if (r115 != null) goto L71;
        Iterator<T> r116 = r112.iterator();
    L56:
        if (r116.hasNext() == false) goto L66;
        Object r117 = r116.next();
        Integer r118 = ((y1) r117).f295583g;
        if (r118 != null) goto L61;
    L63:
        boolean r119 = false;
    L64:
        if (r119 == false) goto L56;
    L67:
        y1 r120 = (y1) r117;
        if (r120 == null) goto L70;
        r115 = r120.f295577a;
        goto L71
    L70:
        r115 = null;
        goto L71
    L61:
        if (r118.intValue() != 1) goto L63;
        r119 = true;
        goto L64
    L66:
        r117 = null;
    L71:
        p(r112, r115);
        Iterator<T> r121 = r112.iterator();
    L73:
        if (r121.hasNext() == false) goto L77;
        Object r122 = r121.next();
        if (Intrinsics.areEqual(((y1) r122).f295577a, r115) == false) goto L73;
        r103 = r122;
    L77:
        q((y1) r103, true);
    L52:
        r115 = null;
    L79:
        return new wa8.a0(Boolean.TRUE, "");
    L38:
        return new wa8.a0(Boolean.FALSE, "text list option list is empty");
    L32:
        if (r110.isEmpty() == true) goto L35;
        r111 = false;
        goto L36
    L28:
        r109 = null;
        goto L29
    L81:
        return new wa8.a0(Boolean.FALSE, r107.getMessage());
    L16:
        if (getType() != 13) goto L19;
        r105.f295265d = -1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L11:
        return new wa8.a0(Boolean.FALSE, "text list selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public /* synthetic */ s(int r100) {
        this("TextListSelectorController");
    }

    public static void p(List r100, Integer r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        y1 r103 = (y1) r102.next();
        if (r101 != null) goto L8;
    L10:
        int r104 = 0;
    L11:
        r103.f295583g = r104;
        goto L4
    L8:
        if (Intrinsics.areEqual(r103.f295577a, r101) == false) goto L10;
        r104 = 1;
        goto L11
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((k0) xt7.d.f565073b.c(k0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L7:
        y1 r104 = null;
        Object r105 = null;
        r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        k0 r106 = (k0) r103;
        int r107 = -1;
        if (r106 != null) goto L13;
        r106 = null;
    L16:
        if (r106 != null) goto L18;
        return;
    L18:
        List<y1> r108 = r106.f295264c;
        if (r108 == null) goto L23;
        y1 r109 = (y1) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L23;
        Integer r110 = r109.f295577a;
    L24:
        k0 r111 = this.f312015p;
        if (r111 == null) goto L29;
        List<y1> r112 = r111.f295264c;
        if (r112 == null) goto L29;
        p(r112, r110);
    L29:
        k0 r113 = this.f312015p;
        if (r113 == null) goto L46;
        List<y1> r114 = r113.f295264c;
        if (r114 == null) goto L46;
        Iterator<y1> r115 = r114.iterator();
        int r116 = 0;
    L35:
        if (r115.hasNext() == false) goto L46;
        Integer r117 = r115.next().f295583g;
        if (r117 != null) goto L40;
    L42:
        boolean r118 = false;
    L43:
        if (r118 == true) goto L44;
        r116 = r116 + 1;
        goto L35
    L44:
        r107 = r116;
        goto L46
    L40:
        if (r117.intValue() != 1) goto L42;
        r118 = true;
    L46:
        if (r107 < 0) goto L49;
        if (r101 == false) goto L49;
        this.f312016q = true;
    L49:
        k0 r119 = this.f312015p;
        if (r119 == null) goto L66;
        List<y1> r120 = r119.f295264c;
        if (r120 == null) goto L66;
        Iterator<T> r121 = r120.iterator();
    L55:
        if (r121.hasNext() == false) goto L65;
        Object r122 = r121.next();
        Integer r123 = ((y1) r122).f295583g;
        if (r123 != null) goto L60;
    L62:
        boolean r124 = false;
    L63:
        if (r124 == false) goto L55;
        r105 = r122;
        goto L65
    L60:
        if (r123.intValue() != 1) goto L62;
        r124 = true;
    L65:
        r104 = (y1) r105;
    L66:
        q(r104, true);
        return;
    L23:
        r110 = null;
        goto L24
    L13:
        if (getType() != 13) goto L16;
        r106.f295265d = -1;
    L5:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void q(y1 r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L11;
        q1 r103 = r100.f295580d;
        if (r103 == null) goto L7;
        r102 = r103.f295402a;
    L7:
        o(new com.larus.bmhome.instruction.core.impl.base.k.h(r102, "onItemSelected"));
        t1 r104 = r100.f295581e;
        if (r104 == null) goto L23;
        e(new com.larus.bmhome.instruction.core.impl.base.l(getWidgetId(), r104, r101));
        o(new com.larus.bmhome.instruction.core.impl.base.k.n(r104, r101));
        return;
    L23:
        return;
    L11:
        k0 r105 = this.f312015p;
        if (r105 == null) goto L24;
        y1 r106 = r105.f295263b;
        if (r106 == null) goto L26;
        q1 r107 = r106.f295580d;
        if (r107 == null) goto L19;
        r102 = r107.f295402a;
    L19:
        o(new com.larus.bmhome.instruction.core.impl.base.k.h(r102, "resetDefaultSelection"));
        t1 r108 = r106.f295581e;
        if (r108 == null) goto L25;
        e(new com.larus.bmhome.instruction.core.impl.base.l(getWidgetId(), r108, r101));
        o(new com.larus.bmhome.instruction.core.impl.base.k.n(r108, r101));
        return;
    L25:
        return;
    L26:
        return;
    }
}
