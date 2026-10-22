package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.l f311993p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f311994q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f311995r;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 6;
    }

    public i() {
        super("ImageListSelectorController");
        this.f311994q = -1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.l r100 = this.f311993p;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295272c, Boolean.TRUE);
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

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        if (this.f311995r == true) goto L48;
        this.f311995r = true;
        com.larus.bmhome.actionbar.model.l r100 = this.f311993p;
        if (r100 == null) goto L10;
        Integer r101 = r100.f295271b;
        if (r101 == null) goto L10;
        int r102 = r101.intValue();
    L11:
        if (r102 < 0) goto L19;
        com.larus.bmhome.actionbar.model.l r103 = this.f311993p;
        if (r103 == null) goto L19;
        List<w> r104 = r103.f295270a;
        if (r104 == null) goto L19;
        w r105 = (w) CollectionsKt.getOrNull(r104, r102);
        if (r105 == null) goto L19;
        r105.f295528s = 1;
    L19:
        com.larus.bmhome.actionbar.model.l r106 = this.f311993p;
        if (r106 == null) goto L43;
        List<w> r107 = r106.f295270a;
        if (r107 == null) goto L43;
        List<w> r108 = r107;
        if ((r108 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r109 = r108.iterator();
    L30:
        if (r109.hasNext() == false) goto L40;
        Integer r110 = ((w) r109.next()).f295528s;
        if (r110 != null) goto L35;
    L37:
        boolean r111 = false;
    L38:
        if (r111 == false) goto L30;
        boolean r112 = true;
    L41:
        if (r112 != true) goto L43;
        boolean r113 = true;
    L44:
        if (r113 == false) goto L48;
        if (p() == false) goto L48;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L48
    L35:
        if (r110.intValue() != 1) goto L37;
        r111 = true;
    L40:
        r112 = false;
        goto L41
    L26:
        if (r108.isEmpty() == false) goto L28;
    L43:
        r113 = false;
    L10:
        r102 = -1;
    L48:
        String r114 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r115 = this.f311933o;
        com.larus.bmhome.actionbar.model.l r116 = this.f311993p;
        com.larus.bmhome.actionbar.model.u r117 = this.f311920b;
        String r118 = null;
        if (r117 == null) goto L55;
        String r119 = r117.f295476c;
        if (r119 == null) goto L55;
        if ((!StringsKt.isBlank(r119)) == false) goto L55;
        String r120 = r119;
    L56:
        com.larus.bmhome.actionbar.model.u r121 = this.f311920b;
        if (r121 == null) goto L59;
        boolean r122 = Intrinsics.areEqual(r121.f295479f, Boolean.TRUE);
    L60:
        boolean r123 = p();
        com.larus.bmhome.instruction.core.impl.base.c r124 = this.f311921c;
        if (r124 == null) goto L67;
        aq8.d r125 = r124.f311935a;
        if (r125 == null) goto L67;
        dq8.h r126 = r125.f15937a;
        if (r126 == null) goto L67;
        String r127 = r126.getBotId();
    L68:
        com.larus.bmhome.instruction.core.impl.base.c r128 = this.f311921c;
        if (r128 == null) goto L75;
        aq8.d r129 = r128.f311935a;
        if (r129 == null) goto L75;
        dq8.h r130 = r129.f15937a;
        if (r130 == null) goto L75;
        String r131 = r130.getChatType();
    L76:
        com.larus.bmhome.instruction.core.impl.base.c r132 = this.f311921c;
        if (r132 == null) goto L83;
        aq8.d r133 = r132.f311935a;
        if (r133 == null) goto L83;
        dq8.h r134 = r133.f15937a;
        if (r134 == null) goto L83;
        String r135 = r134.getTemplateType();
    L84:
        com.larus.bmhome.instruction.core.impl.base.c r136 = this.f311921c;
        if (r136 == null) goto L93;
        aq8.d r137 = r136.f311935a;
        if (r137 == null) goto L93;
        dq8.h r138 = r137.f15937a;
        if (r138 == null) goto L93;
        Integer r139 = r138.getInstructionType();
        if (r139 == null) goto L93;
        String r140 = r139.toString();
    L94:
        com.larus.bmhome.instruction.core.impl.base.c r141 = this.f311921c;
        if (r141 == null) goto L101;
        aq8.d r142 = r141.f311935a;
        if (r142 == null) goto L101;
        dq8.h r143 = r142.f15937a;
        if (r143 == null) goto L101;
        String r144 = r143.a();
    L102:
        com.larus.bmhome.instruction.core.impl.base.c r145 = this.f311921c;
        if (r145 == null) goto L109;
        aq8.d r146 = r145.f311935a;
        if (r146 == null) goto L109;
        dq8.h r147 = r146.f15937a;
        if (r147 == null) goto L109;
        String r148 = r147.b();
    L110:
        com.larus.bmhome.instruction.core.impl.base.c r149 = this.f311921c;
        if (r149 == null) goto L117;
        aq8.d r150 = r149.f311935a;
        if (r150 == null) goto L117;
        dq8.h r151 = r150.f15937a;
        if (r151 == null) goto L117;
        Boolean r152 = r151.isCreationActionBar();
    L118:
        com.larus.bmhome.actionbar.model.u r153 = this.f311920b;
        if (r153 == null) goto L125;
        String r154 = r153.f295476c;
        if (r154 == null) goto L125;
        if ((!StringsKt.isBlank(r154)) == false) goto L125;
        String r210 = r154;
    L126:
        com.larus.bmhome.instruction.core.impl.base.c r155 = this.f311921c;
        if (r155 == null) goto L134;
        aq8.d r156 = r155.f311935a;
        if (r156 == null) goto L134;
        dq8.h r157 = r156.f15937a;
        if (r157 == null) goto L134;
        r118 = r157.c();
    L134:
        return new cq8.r(r114, r115, r116, r120, r122, r123, new z0(r127, r131, r135, r118, r140, r144, r148, r152, r210, 2), this.f311994q);
    L125:
        r210 = null;
    L117:
        r152 = null;
    L109:
        r148 = null;
    L101:
        r144 = null;
    L93:
        r140 = null;
    L83:
        r135 = null;
    L75:
        r131 = null;
    L67:
        r127 = null;
        goto L68
    L59:
        r122 = false;
    L55:
        r120 = null;
        goto L56
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.l r100 = this.f311993p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295270a;
        boolean r103 = false;
        if (r102 == null) goto L19;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        Integer r107 = ((w) r106).f295528s;
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
        if (r104 != null) goto L22;
    L23:
        r103 = true;
    L24:
        if (r103 == false) goto L26;
        return null;
    L26:
        com.larus.bmhome.actionbar.model.l r109 = this.f311993p;
        if (r109 == null) goto L29;
        com.larus.bmhome.actionbar.model.l r110 = new com.larus.bmhome.actionbar.model.l(r104, r109.f295271b, r109.f295272c);
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.l.Companion.serializer()), r110));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r112) == true) goto L39;
        r101 = r112;
    L39:
        return (String) r101;
    L32:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L29:
        r110 = null;
        goto L40
    L22:
        if (r104.isEmpty() == false) goto L24;
    L19:
        r104 = null;
        goto L20
    }

    public final boolean p() {
        com.larus.bmhome.actionbar.model.u r100 = this.f311920b;
        if (r100 == null) goto L11;
        Integer r101 = r100.f295474a;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final void q() {
        if (p() == true) goto L5;
        return;
    L5:
        com.larus.bmhome.actionbar.model.l r100 = this.f311993p;
        boolean r101 = false;
        if (r100 == null) goto L28;
        List<w> r102 = r100.f295270a;
        if (r102 == null) goto L28;
        List<w> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L13;
        Integer r105 = ((w) r104.next()).f295528s;
        if (r105 != null) goto L21;
    L23:
        boolean r106 = false;
    L24:
        if (r106 == false) goto L16;
        boolean r107 = true;
    L26:
        if (r107 != true) goto L28;
        r101 = true;
        goto L28
    L21:
        if (r105.intValue() != 1) goto L23;
        r106 = true;
    L13:
        r107 = false;
        goto L26
    L12:
        if (r103.isEmpty() == false) goto L14;
    L28:
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(r101));
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if (Intrinsics.areEqual(r110.a(), getWidgetId()) == true) goto L5;
        return;
    L5:
        int r100 = 0;
        if ((r110 instanceof cq8.q) == false) goto L38;
        cq8.q r111 = (cq8.q) r110;
        com.larus.bmhome.actionbar.model.l r101 = this.f311993p;
        if (r101 == null) goto L36;
        List<w> r102 = r101.f295270a;
        if (r102 == null) goto L36;
        boolean r103 = Intrinsics.areEqual(r101.f295272c, Boolean.TRUE);
        List<w> r104 = r102;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L32;
        w r107 = (w) r106.next();
        Long r108 = r107.f295510a;
        long r109 = r111.f464932c;
        if (r108 != null) goto L19;
    L24:
        Long r112 = r107.f295510a;
        long r113 = r111.f464932c;
        if (r112 != null) goto L28;
    L30:
        int r114 = 0;
    L31:
        r105.add(w.a(r107, null, null, Integer.valueOf(r114), null, null, null, 8126463));
        goto L14
    L28:
        if (r112.longValue() != r113) goto L30;
        r114 = 1;
        goto L31
    L19:
        if (r108.longValue() != r109) goto L24;
        if (r111.f464933d == false) goto L24;
        if (r103 == true) goto L24;
    L32:
        List<w> r115 = CollectionsKt.toMutableList(r105);
        com.larus.bmhome.actionbar.model.l r116 = this.f311993p;
        if (r116 == null) goto L35;
        r116.f295270a = r115;
    L35:
        this.f311994q = -1;
        q();
    L36:
        j();
        return;
    L38:
        if ((r110 instanceof cq8.s) == false) goto L67;
        cq8.s r117 = (cq8.s) r110;
        com.larus.bmhome.actionbar.model.l r118 = this.f311993p;
        if (r118 == null) goto L58;
        List<w> r119 = r118.f295270a;
        if (r119 == null) goto L58;
        Long r120 = r117.f464953c;
        List<w> r121 = r119;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
        int r124 = 0;
    L46:
        if (r123.hasNext() == false) goto L54;
        Object r125 = r123.next();
        int r126 = r100 + 1;
        if (r100 >= 0) goto L50;
        CollectionsKt.throwIndexOverflow();
    L50:
        w r127 = (w) r125;
        boolean r128 = Intrinsics.areEqual(r127.f295510a, r120);
        if (r128 == false) goto L53;
        r124 = r100;
    L53:
        r122.add(w.a(r127, null, null, Integer.valueOf(r128 ? 1 : 0), null, null, null, 8126463));
        r100 = r126;
        goto L46
    L54:
        List<w> r129 = CollectionsKt.toMutableList(r122);
        com.larus.bmhome.actionbar.model.l r130 = this.f311993p;
        if (r130 == null) goto L57;
        r130.f295270a = r129;
    L57:
        this.f311994q = r124;
        q();
    L58:
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.l) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.l.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L30;
        com.larus.bmhome.actionbar.model.l r106 = (com.larus.bmhome.actionbar.model.l) r104;
        List<w> r107 = r106.f295270a;
        if (r107 != null) goto L21;
    L24:
        if (r101 == true) goto L26;
        this.f311993p = r106;
        return new wa8.a0(Boolean.TRUE, "");
    L26:
        return new wa8.a0(Boolean.FALSE, "imageList is empty");
    L21:
        if (r107.isEmpty() == true) goto L24;
        r101 = false;
        goto L24
    L30:
        return new wa8.a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.l) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.l.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.l r104 = (com.larus.bmhome.actionbar.model.l) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<w> r105 = r104.f295270a;
        if (r105 == null) goto L29;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L44;
        w r107 = (w) r106.next();
        com.larus.bmhome.actionbar.model.l r108 = this.f311993p;
        if (r108 == null) goto L17;
        List<w> r109 = r108.f295270a;
        if (r109 == null) goto L17;
        Iterator<T> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L17;
        w r111 = (w) r110.next();
        if (Intrinsics.areEqual(r111.f295510a, r107.f295510a) == true) goto L27;
        r111.f295528s = 0;
        goto L24
    L27:
        r111.f295528s = 1;
        goto L24
    L44:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
