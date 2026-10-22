package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.r0;
import cq8.s0;
import cq8.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class r extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i0 f312014p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 7;
    }

    public r() {
        super("TabSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        i0 r100 = this.f312014p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295197a;
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
        if (r103 == false) goto L27;
        return null;
    L27:
        if (this.f312014p == null) goto L29;
        i0 r109 = new i0(r104);
    L40:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L32
        Object r111 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(i0.Companion.serializer()), r109));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r111) == true) goto L39;
        r101 = r111;
    L39:
        return (String) r101;
    L32:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L29:
        r109 = null;
        goto L40
    L22:
        if (r104.isEmpty() == false) goto L24;
    L19:
        r104 = null;
        goto L20
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        i0 r102 = this.f312014p;
        com.larus.bmhome.actionbar.model.u r103 = this.f311920b;
        if (r103 == null) goto L9;
        String r104 = r103.f295476c;
        if (r104 == null) goto L9;
        if ((!StringsKt.isBlank(r104)) == false) goto L9;
    L10:
        String r105 = r104;
        com.larus.bmhome.actionbar.model.u r106 = this.f311920b;
        if (r106 == null) goto L13;
        boolean r107 = Intrinsics.areEqual(r106.f295479f, Boolean.TRUE);
    L15:
        return new r0(r100, r101, r102, r105, r107);
    L13:
        r107 = false;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof s0) == false) goto L6;
        p(((s0) r100).f464955c);
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
        Object r104 = Result.m9449constructorimpl((i0) xt7.d.f565073b.c(i0.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L34;
        i0 r106 = (i0) r104;
        if (r106 == null) goto L21;
        List<w> r107 = r106.f295197a;
    L22:
        List<w> r108 = r107;
        if (r108 != null) goto L25;
    L28:
        if (r101 == true) goto L30;
        this.f312014p = r106;
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "tab option list is empty");
    L25:
        if (r108.isEmpty() == true) goto L28;
        r101 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L34:
        return new wa8.a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "tab selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.larus.bmhome.instruction.core.impl.base.j) == false) goto L24;
        com.larus.bmhome.instruction.core.impl.base.j r101 = (com.larus.bmhome.instruction.core.impl.base.j) r100;
        String r102 = r101.f311944c.f20051d;
        boolean r103 = false;
        if (r102 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
        Long r105 = 1L;
    L21:
        if (r105 == null) goto L25;
        p(r105.longValue());
        return;
    L25:
        return;
    L13:
        String r106 = r101.f311944c.getLyrics();
        if (r106 != null) goto L16;
    L17:
        r103 = true;
    L18:
        if (r103 == true) goto L20;
        r105 = 2L;
        goto L21
    L20:
        r105 = null;
        goto L21
    L16:
        if (StringsKt.isBlank(r106) == false) goto L18;
    L7:
        if (StringsKt.isBlank(r102) == true) goto L10;
        r104 = false;
        goto L11
    }

    public final void p(long r110) {
        i0 r100 = this.f312014p;
        i0 r101 = null;
        if (r100 == null) goto L5;
        List<w> r102 = r100.f295197a;
    L6:
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();
    L9:
        if (r102.isEmpty() == false) goto L11;
        return;
    L11:
        List<w> r103 = r102;
        boolean r104 = false;
        boolean r105 = true;
        if ((r103 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r106 = r103.iterator();
    L18:
        if (r106.hasNext() == false) goto L28;
        Long r107 = ((w) r106.next()).f295510a;
        if (r107 != null) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L18;
        boolean r109 = false;
    L29:
        if (r109 == false) goto L31;
        return;
    L31:
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r112 = r103.iterator();
    L33:
        if (r112.hasNext() == false) goto L43;
        w r113 = (w) r112.next();
        Long r114 = r113.f295510a;
        if (r114 != null) goto L38;
    L40:
        int r115 = 0;
    L41:
        r111.add(w.a(r113, null, null, Integer.valueOf(r115), null, null, null, 8126463));
        goto L33
    L38:
        if (r114.longValue() != r110) goto L40;
        r115 = 1;
        goto L41
    L43:
        if (r102.size() != r111.size()) goto L63;
        List r116 = CollectionsKt.zip(r103, r111);
        if ((r116 instanceof Collection) == true) goto L48;
    L50:
        Iterator r117 = r116.iterator();
    L52:
        if (r117.hasNext() == false) goto L62;
        Pair r118 = (Pair) r117.next();
        w r119 = (w) r118.component1();
        w r120 = (w) r118.component2();
        if (Intrinsics.areEqual(r119.f295510a, r120.f295510a) == true) goto L56;
    L59:
        boolean r121 = true;
    L60:
        if (r121 == false) goto L52;
        r104 = true;
        goto L62
    L56:
        if (Intrinsics.areEqual(r119.f295528s, r120.f295528s) == false) goto L59;
        r121 = false;
    L62:
        r105 = r104;
        goto L63
    L48:
        if (r116.isEmpty() == false) goto L50;
    L63:
        if (r105 == true) goto L66;
        return;
    L66:
        if (this.f312014p == null) goto L68;
        r101 = new i0(r111);
    L68:
        this.f312014p = r101;
        if (r101 == null) goto L71;
        o(new com.larus.bmhome.instruction.core.impl.base.k.p(r101));
    L71:
        j();
        return;
    L23:
        if (r107.longValue() != r110) goto L25;
        r108 = true;
    L28:
        r109 = true;
        goto L29
    L14:
        if (r103.isEmpty() == false) goto L16;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((i0) xt7.d.f565073b.c(i0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        i0 r104 = (i0) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<w> r105 = r104.f295197a;
        if (r105 == null) goto L29;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L44;
        w r107 = (w) r106.next();
        i0 r108 = this.f312014p;
        if (r108 == null) goto L17;
        List<w> r109 = r108.f295197a;
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
