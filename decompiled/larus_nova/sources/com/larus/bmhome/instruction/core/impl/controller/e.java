package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.h f311991p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public e() {
        super("DropFeatureSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        com.larus.bmhome.actionbar.model.h r102 = this.f311991p;
        com.larus.bmhome.actionbar.model.u r103 = this.f311920b;
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.f295476c;
        if (r105 == null) goto L9;
        if ((!StringsKt.isBlank(r105)) == false) goto L9;
        String r106 = r105;
    L10:
        com.larus.bmhome.actionbar.model.u r107 = this.f311920b;
        if (r107 == null) goto L18;
        Integer r108 = r107.f295474a;
        if (r108 == null) goto L18;
        if (r108.intValue() != 1) goto L18;
        boolean r109 = true;
    L19:
        Integer r110 = this.f311926h;
        com.larus.bmhome.instruction.core.impl.base.c r111 = this.f311921c;
        if (r111 == null) goto L26;
        aq8.d r112 = r111.f311935a;
        if (r112 == null) goto L26;
        dq8.h r113 = r112.f15937a;
        if (r113 == null) goto L26;
        String r114 = r113.getBotId();
    L27:
        com.larus.bmhome.instruction.core.impl.base.c r115 = this.f311921c;
        if (r115 == null) goto L34;
        aq8.d r116 = r115.f311935a;
        if (r116 == null) goto L34;
        dq8.h r117 = r116.f15937a;
        if (r117 == null) goto L34;
        String r118 = r117.getChatType();
    L35:
        com.larus.bmhome.instruction.core.impl.base.c r119 = this.f311921c;
        if (r119 == null) goto L42;
        aq8.d r120 = r119.f311935a;
        if (r120 == null) goto L42;
        dq8.h r121 = r120.f15937a;
        if (r121 == null) goto L42;
        String r122 = r121.getTemplateType();
    L43:
        com.larus.bmhome.instruction.core.impl.base.c r123 = this.f311921c;
        if (r123 == null) goto L52;
        aq8.d r124 = r123.f311935a;
        if (r124 == null) goto L52;
        dq8.h r125 = r124.f15937a;
        if (r125 == null) goto L52;
        Integer r126 = r125.getInstructionType();
        if (r126 == null) goto L52;
        String r127 = r126.toString();
    L53:
        com.larus.bmhome.instruction.core.impl.base.c r128 = this.f311921c;
        if (r128 == null) goto L60;
        aq8.d r129 = r128.f311935a;
        if (r129 == null) goto L60;
        dq8.h r130 = r129.f15937a;
        if (r130 == null) goto L60;
        String r131 = r130.a();
    L61:
        com.larus.bmhome.instruction.core.impl.base.c r132 = this.f311921c;
        if (r132 == null) goto L68;
        aq8.d r133 = r132.f311935a;
        if (r133 == null) goto L68;
        dq8.h r134 = r133.f15937a;
        if (r134 == null) goto L68;
        String r135 = r134.b();
    L69:
        com.larus.bmhome.instruction.core.impl.base.c r136 = this.f311921c;
        if (r136 == null) goto L76;
        aq8.d r137 = r136.f311935a;
        if (r137 == null) goto L76;
        dq8.h r138 = r137.f15937a;
        if (r138 == null) goto L76;
        Boolean r139 = r138.isCreationActionBar();
    L77:
        com.larus.bmhome.actionbar.model.u r140 = this.f311920b;
        if (r140 == null) goto L84;
        String r141 = r140.f295476c;
        if (r141 == null) goto L84;
        if ((true ^ StringsKt.isBlank(r141)) == false) goto L84;
        String r142 = r141;
    L85:
        com.larus.bmhome.instruction.core.impl.base.c r143 = this.f311921c;
        if (r143 == null) goto L93;
        aq8.d r144 = r143.f311935a;
        if (r144 == null) goto L93;
        dq8.h r145 = r144.f15937a;
        if (r145 == null) goto L93;
        r104 = r145.c();
    L93:
        return new cq8.k(r100, r101, r102, r106, r109, r110, new z0(r114, r118, r122, r104, r127, r131, r135, r139, r142, 2));
    L84:
        r142 = null;
    L76:
        r139 = null;
    L68:
        r135 = null;
    L60:
        r131 = null;
    L52:
        r127 = null;
    L42:
        r122 = null;
    L34:
        r118 = null;
    L26:
        r114 = null;
    L18:
        r109 = false;
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.h r100 = this.f311991p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295167e;
        boolean r103 = false;
        if (r102 == null) goto L20;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L19;
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
        goto L17
    L19:
        ArrayList r110 = r104;
    L21:
        if (r110 != null) goto L23;
    L24:
        r103 = true;
    L25:
        if (r103 == false) goto L27;
        return null;
    L27:
        com.larus.bmhome.actionbar.model.h r109 = this.f311991p;
        if (r109 == null) goto L30;
        com.larus.bmhome.actionbar.model.h r111 = com.larus.bmhome.actionbar.model.h.a(r109, null, null, null, r110, null, null, 4079);
    L41:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L33
        Object r113 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r111));     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r113) == true) goto L40;
        r101 = r113;
    L40:
        return (String) r101;
    L33:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L30:
        r111 = null;
        goto L41
    L23:
        if (r110.isEmpty() == false) goto L25;
    L20:
        r110 = null;
        goto L21
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        if ((r101 instanceof Map) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        if (r102 == null) goto L8;
        Object r103 = r102.get(String.valueOf(6));
    L10:
        if ((r103 instanceof Map) == false) goto L12;
        Map r104 = (Map) r103;
    L13:
        if (r104 == null) goto L16;
        Object r105 = r104.get(null);
        if (r105 == null) goto L16;
    L20:
        if ((r105 instanceof Map) == false) goto L22;
        Map r106 = (Map) r105;
    L23:
        if (r106 == null) goto L41;
        Object r107 = r106.get("default_select_id");
        if (r107 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r108 = this.f311991p;
        if (r108 == null) goto L49;
        List<w> r109 = r108.f295167e;
        if (r109 == null) goto L50;
        Iterator<T> r110 = r109.iterator();
    L32:
        if (r110.hasNext() == false) goto L51;
        w r111 = (w) r110.next();
        Long r112 = r111.f295510a;
        if (r112 == null) goto L36;
        String r113 = r112.toString();
    L38:
        if (Intrinsics.areEqual(r113, r107) == true) goto L39;
        r111.f295528s = 0;
        goto L32
    L39:
        r111.f295528s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L32
    L36:
        r113 = null;
        goto L38
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L41:
        return;
    L22:
        r106 = null;
    L16:
        if (r104 == null) goto L18;
        r105 = r104.get("match_all_id");
        goto L20
    L18:
        r105 = null;
        goto L20
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof cq8.j) == false) goto L12;
        com.larus.bmhome.actionbar.model.h r101 = this.f311991p;
        if (r101 == null) goto L10;
        r101.f295167e = ((cq8.j) r100).f464856c;
    L10:
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
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L30;
        com.larus.bmhome.actionbar.model.h r106 = (com.larus.bmhome.actionbar.model.h) r104;
        List<w> r107 = r106.f295167e;
        if (r107 != null) goto L21;
    L24:
        if (r101 == true) goto L26;
        this.f311991p = r106;
        return new wa8.a0(Boolean.TRUE, "");
    L26:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
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
        return new wa8.a0(Boolean.FALSE, "style feature selector box is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r104 = (com.larus.bmhome.actionbar.model.h) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<w> r105 = r104.f295167e;
        if (r105 == null) goto L29;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L44;
        w r107 = (w) r106.next();
        com.larus.bmhome.actionbar.model.h r108 = this.f311991p;
        if (r108 == null) goto L17;
        List<w> r109 = r108.f295167e;
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
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
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
