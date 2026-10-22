package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.m0;
import cq8.n0;
import cq8.o0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class p extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d0 f312009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public bq8.a f312010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f312011r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f312012s;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 10;
    }

    public p() {
        super("MusicTemplateSelectorController");
        this.f312012s = true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        d0 r100 = this.f312009p;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295061c, Boolean.TRUE);
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
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        d0 r102 = this.f312009p;
        boolean r103 = this.f312011r;
        com.larus.bmhome.actionbar.model.u r104 = this.f311920b;
        if (r104 == null) goto L5;
        boolean r105 = Intrinsics.areEqual(r104.f295479f, Boolean.TRUE);
    L6:
        com.larus.bmhome.actionbar.model.u r106 = this.f311920b;
        String r107 = null;
        if (r106 == null) goto L13;
        String r108 = r106.f295476c;
        if (r108 == null) goto L13;
        if ((!StringsKt.isBlank(r108)) == false) goto L13;
        String r109 = r108;
    L14:
        bq8.a r110 = this.f312010q;
        com.larus.bmhome.instruction.core.impl.base.c r111 = this.f311921c;
        if (r111 == null) goto L21;
        aq8.d r112 = r111.f311935a;
        if (r112 == null) goto L21;
        dq8.h r113 = r112.f15937a;
        if (r113 == null) goto L21;
        String r114 = r113.getBotId();
    L22:
        com.larus.bmhome.instruction.core.impl.base.c r115 = this.f311921c;
        if (r115 == null) goto L29;
        aq8.d r116 = r115.f311935a;
        if (r116 == null) goto L29;
        dq8.h r117 = r116.f15937a;
        if (r117 == null) goto L29;
        String r118 = r117.getChatType();
    L30:
        com.larus.bmhome.instruction.core.impl.base.c r119 = this.f311921c;
        if (r119 == null) goto L37;
        aq8.d r120 = r119.f311935a;
        if (r120 == null) goto L37;
        dq8.h r121 = r120.f15937a;
        if (r121 == null) goto L37;
        String r122 = r121.getTemplateType();
    L38:
        com.larus.bmhome.instruction.core.impl.base.c r123 = this.f311921c;
        if (r123 == null) goto L47;
        aq8.d r124 = r123.f311935a;
        if (r124 == null) goto L47;
        dq8.h r125 = r124.f15937a;
        if (r125 == null) goto L47;
        Integer r126 = r125.getInstructionType();
        if (r126 == null) goto L47;
        String r127 = r126.toString();
    L48:
        com.larus.bmhome.instruction.core.impl.base.c r128 = this.f311921c;
        if (r128 == null) goto L55;
        aq8.d r129 = r128.f311935a;
        if (r129 == null) goto L55;
        dq8.h r130 = r129.f15937a;
        if (r130 == null) goto L55;
        String r131 = r130.a();
    L56:
        com.larus.bmhome.instruction.core.impl.base.c r132 = this.f311921c;
        if (r132 == null) goto L63;
        aq8.d r133 = r132.f311935a;
        if (r133 == null) goto L63;
        dq8.h r134 = r133.f15937a;
        if (r134 == null) goto L63;
        String r135 = r134.b();
    L64:
        com.larus.bmhome.instruction.core.impl.base.c r136 = this.f311921c;
        if (r136 == null) goto L71;
        aq8.d r137 = r136.f311935a;
        if (r137 == null) goto L71;
        dq8.h r138 = r137.f15937a;
        if (r138 == null) goto L71;
        Boolean r139 = r138.isCreationActionBar();
    L72:
        com.larus.bmhome.actionbar.model.u r140 = this.f311920b;
        if (r140 == null) goto L79;
        String r141 = r140.f295476c;
        if (r141 == null) goto L79;
        if ((!StringsKt.isBlank(r141)) == false) goto L79;
        String r142 = r141;
    L80:
        com.larus.bmhome.instruction.core.impl.base.c r143 = this.f311921c;
        if (r143 == null) goto L88;
        aq8.d r144 = r143.f311935a;
        if (r144 == null) goto L88;
        dq8.h r145 = r144.f15937a;
        if (r145 == null) goto L88;
        r107 = r145.c();
    L88:
        return new o0(r100, r101, r102, r109, r105, r103, r110, new z0(r114, r118, r122, r107, r127, r131, r135, r139, r142, 2), this.f312012s);
    L79:
        r142 = null;
    L71:
        r139 = null;
    L63:
        r135 = null;
    L55:
        r131 = null;
    L47:
        r127 = null;
    L37:
        r122 = null;
    L29:
        r118 = null;
    L21:
        r114 = null;
    L13:
        r109 = null;
        goto L14
    L5:
        r105 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        d0 r100 = this.f312009p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295059a;
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
        d0 r109 = this.f312009p;
        if (r109 == null) goto L29;
        d0 r110 = d0.d(r109, r104, this.f312010q, 14);
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(d0.Companion.serializer()), r110));     // Catch: Throwable -> L32
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

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        bq8.a r102 = null;
        if ((r101 instanceof Map) == false) goto L5;
        Map r103 = (Map) r101;
    L6:
        if (r103 == null) goto L9;
        Object r104 = r103.get(null);
        if (r104 == null) goto L9;
    L13:
        if ((r104 instanceof Map) == false) goto L15;
        Map r105 = (Map) r104;
    L16:
        if (r105 == null) goto L47;
        Object r106 = r105.get("default_select_id");
        if (r106 == null) goto L48;
        String r107 = r106.toString();
        if (r107 == null) goto L49;
        c0.f348199b.d("MusicTemplateSelectorController", "onRestoreComponentStateByDefaultParams: select:".concat(r107));
        d0 r108 = this.f312009p;
        if (r108 == null) goto L38;
        List<w> r109 = r108.f295059a;
        if (r109 == null) goto L38;
        Iterator<T> r110 = r109.iterator();
        int r111 = 0;
    L27:
        if (r110.hasNext() == false) goto L38;
        Object r112 = r110.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        w r114 = (w) r112;
        if (Intrinsics.areEqual(String.valueOf(r114.f295510a), r107) == false) goto L36;
        r114.f295528s = 1;
        d0 r115 = this.f312009p;
        if (r115 == null) goto L37;
        r115.f295060b = Integer.valueOf(r111);
    L37:
        r111 = r113;
        goto L27
    L36:
        r114.f295528s = 0;
    L38:
        d0 r116 = this.f312009p;
        if (r116 == null) goto L41;
        r102 = r116.f295063e;
    L41:
        this.f312010q = r102;
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L15:
        r105 = null;
    L9:
        if (r103 == null) goto L11;
        r104 = r103.get("match_all_id");
        goto L13
    L11:
        r104 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if ((r110 instanceof m0) == false) goto L34;
        m0 r111 = (m0) r110;
        d0 r100 = this.f312009p;
        if (r100 == null) goto L32;
        List<w> r101 = r100.f295059a;
        if (r101 == null) goto L32;
        boolean r102 = Intrinsics.areEqual(r100.f295061c, Boolean.TRUE);
        List<w> r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L10:
        int r106 = 0;
        if (r105.hasNext() == false) goto L28;
        w r107 = (w) r105.next();
        Long r108 = r107.f295510a;
        long r109 = r111.f464900c;
        if (r108 != null) goto L16;
    L21:
        Long r112 = r107.f295510a;
        long r113 = r111.f464900c;
        if (r112 == null) goto L27;
        if (r112.longValue() != r113) goto L27;
        r106 = 1;
    L27:
        r104.add(w.a(r107, null, null, Integer.valueOf(r106), null, null, null, 8126463));
        goto L10
    L16:
        if (r108.longValue() != r109) goto L21;
        if (r111.f464901d == false) goto L21;
        if (r102 == true) goto L21;
    L28:
        List<w> r114 = CollectionsKt.toMutableList(r104);
        d0 r115 = this.f312009p;
        if (r115 == null) goto L31;
        r115.f295059a = r114;
    L31:
        this.f312012s = false;
    L32:
        j();
        return;
    L34:
        if ((r110 instanceof n0) == false) goto L43;
        n0 r116 = (n0) r110;
        p(r116.f464905c);
        o(new com.larus.bmhome.instruction.core.impl.base.k.i(r116.f464905c));
        e(new com.larus.bmhome.instruction.core.impl.base.j(getWidgetId(), r116.f464905c));
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((d0) xt7.d.f565073b.c(d0.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L28;
        d0 r106 = (d0) r104;
        List<w> r107 = r106.f295062d;
        if (r107 == null) goto L25;
        w r108 = (w) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L25;
        if (r108.f295519j != true) goto L25;
        r101 = true;
    L25:
        this.f312011r = r101;
        this.f312009p = r106;
        this.f312010q = r106.f295063e;
        return new wa8.a0(Boolean.TRUE, "");
    L28:
        return new wa8.a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "music template selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.larus.bmhome.instruction.core.impl.base.j) == true) goto L5;
        return;
    L5:
        p(((com.larus.bmhome.instruction.core.impl.base.j) r100).f311944c);
        j();
    }

    public final void p(bq8.a r110) {
        boolean r100 = true;
        this.f312012s = true;
        this.f312010q = r110;
        bq8.e r111 = r110.b().f20081c;
        d0 r101 = null;
        if (r111 == null) goto L5;
        Long r112 = Long.valueOf(r111.f20084a);
    L6:
        d0 r102 = this.f312009p;
        if (r102 == null) goto L41;
        List<w> r103 = r102.f295059a;
        if (r103 == null) goto L43;
        if (r112 != null) goto L13;
        return;
    L13:
        if (r112.longValue() == 0) goto L44;
        List<w> r104 = r103;
        if ((r104 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r105 = r104.iterator();
    L22:
        if (r105.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((w) r105.next()).f295510a, r112) == false) goto L22;
        r100 = false;
    L26:
        if (r100 == false) goto L28;
        return;
    L28:
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r107 = r104.iterator();
    L30:
        if (r107.hasNext() == false) goto L32;
        w r108 = (w) r107.next();
        r106.add(w.a(r108, null, null, Integer.valueOf(Intrinsics.areEqual(r108.f295510a, r112) ? 1 : 0), null, null, null, 8126463));
        goto L30
    L32:
        List r113 = CollectionsKt.toMutableList(r106);
        d0 r109 = this.f312009p;
        if (r109 == null) goto L35;
        r101 = d0.d(r109, r113, null, 30);
    L35:
        this.f312009p = r101;
        return;
    L18:
        if (r104.isEmpty() == false) goto L20;
    L44:
        return;
    L43:
        return;
    L41:
        return;
    L5:
        r112 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl((d0) xt7.d.f565073b.c(d0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        d0 r102 = (d0) r101;
        if (r102 != null) goto L13;
        return;
    L13:
        List<w> r112 = r102.f295059a;
        if (r112 == null) goto L35;
        Iterator<T> r113 = r112.iterator();
    L17:
        if (r113.hasNext() == false) goto L35;
        w r103 = (w) r113.next();
        d0 r104 = this.f312009p;
        if (r104 == null) goto L17;
        List<w> r105 = r104.f295059a;
        if (r105 == null) goto L17;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L24:
        if (r106.hasNext() == false) goto L17;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        w r114 = (w) r108;
        if (Intrinsics.areEqual(r114.f295510a, r103.f295510a) == false) goto L33;
        r114.f295528s = 1;
        d0 r115 = this.f312009p;
        if (r115 == null) goto L34;
        r115.f295060b = Integer.valueOf(r107);
    L34:
        r107 = r109;
        goto L24
    L33:
        r114.f295528s = 0;
    L35:
        bq8.a r116 = r102.f295063e;
        if (r116 == null) goto L51;
        this.f312010q = r116;
        return;
    L51:
        return;
    L5:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
