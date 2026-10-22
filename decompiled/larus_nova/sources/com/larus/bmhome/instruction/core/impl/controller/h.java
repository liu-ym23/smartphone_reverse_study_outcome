package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.k f311992p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 4;
    }

    public h() {
        super("FeatureSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.p(getWidgetId(), this.f311933o, this.f311992p);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r100 = null;
        if (this.f311992p != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        com.larus.bmhome.actionbar.model.k r102 = this.f311992p;
        if (r102 == null) goto L35;
        List<com.larus.bmhome.actionbar.model.h> r103 = r102.f295258c;
        if (r103 == null) goto L35;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.h r105 = (com.larus.bmhome.actionbar.model.h) r104.next();
        List<w> r106 = r105.f295167e;
        if (r106 == null) goto L27;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L16:
        if (r108.hasNext() == false) goto L26;
        Object r109 = r108.next();
        Integer r110 = ((w) r109).f295528s;
        if (r110 != null) goto L21;
    L23:
        boolean r111 = false;
    L24:
        if (r111 == false) goto L16;
        r107.add(r109);
        goto L16
    L21:
        if (r110.intValue() != 1) goto L23;
        r111 = true;
        goto L24
    L26:
        ArrayList r112 = r107;
    L28:
        if (r112 != null) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L11;
        r101.add(com.larus.bmhome.actionbar.model.h.a(r105, null, null, null, r112, null, null, 4079));
        goto L11
    L30:
        if ((!r112.isEmpty()) != true) goto L32;
        r113 = true;
        goto L33
    L27:
        r112 = null;
    L35:
        ArrayList r114 = new ArrayList();
        com.larus.bmhome.actionbar.model.k r115 = this.f311992p;
        if (r115 == null) goto L65;
        List<com.larus.bmhome.actionbar.model.t> r116 = r115.f295257b;
        if (r116 == null) goto L65;
        Iterator<T> r117 = r116.iterator();
    L41:
        if (r117.hasNext() == false) goto L65;
        com.larus.bmhome.actionbar.model.t r118 = (com.larus.bmhome.actionbar.model.t) r117.next();
        List<w> r119 = r118.f295445c;
        if (r119 == null) goto L56;
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r119.iterator();
    L46:
        if (r121.hasNext() == false) goto L57;
        Object r122 = r121.next();
        Integer r123 = ((w) r122).f295528s;
        if (r123 != null) goto L51;
    L53:
        boolean r124 = false;
    L54:
        if (r124 == false) goto L46;
        r120.add(r122);
        goto L46
    L51:
        if (r123.intValue() != 1) goto L53;
        r124 = true;
    L57:
        if (r120 != null) goto L59;
    L61:
        boolean r125 = false;
    L62:
        if (r125 == false) goto L41;
        r114.add(com.larus.bmhome.actionbar.model.t.a(r118, r120));
        goto L41
    L59:
        if ((!r120.isEmpty()) != true) goto L61;
        r125 = true;
        goto L62
    L56:
        r120 = null;
    L65:
        if (r101.isEmpty() == true) goto L67;
    L69:
        com.larus.bmhome.actionbar.model.k r126 = this.f311992p;
        if (r126 == null) goto L72;
        com.larus.bmhome.actionbar.model.k r127 = com.larus.bmhome.actionbar.model.k.d(r126, r114, r101, 1);
    L83:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L75
        Object r129 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.k.Companion.serializer()), r127));     // Catch: Throwable -> L75
    L78:
        if (Result.m9455isFailureimpl(r129) == true) goto L82;
        r100 = r129;
    L82:
        return (String) r100;
    L75:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L78
    L72:
        r127 = null;
        goto L83
    L67:
        if (r114.isEmpty() == false) goto L69;
        return null;
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
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.k) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.k.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L67;
        com.larus.bmhome.actionbar.model.k r106 = (com.larus.bmhome.actionbar.model.k) r104;
        if (r106 == null) goto L21;
        List<com.larus.bmhome.actionbar.model.t> r107 = r106.f295257b;
    L22:
        List<com.larus.bmhome.actionbar.model.t> r108 = r107;
        if (r108 != null) goto L25;
    L28:
        if (r101 == true) goto L30;
        this.f311992p = r106;
        if (r106 == null) goto L65;
        List<com.larus.bmhome.actionbar.model.h> r109 = r106.f295258c;
        if (r109 == null) goto L65;
        Iterator<T> r110 = r109.iterator();
    L37:
        if (r110.hasNext() == false) goto L65;
        com.larus.bmhome.actionbar.model.h r111 = (com.larus.bmhome.actionbar.model.h) r110.next();
        if (Intrinsics.areEqual(r111.f295170h, Boolean.TRUE) == true) goto L37;
        Integer r112 = r111.f295168f;
        if (r112 == null) goto L43;
        int r113 = r112.intValue();
    L44:
        List<w> r114 = r111.f295167e;
        if (r114 == null) goto L56;
        Iterator<T> r115 = r114.iterator();
    L48:
        if (r115.hasNext() == false) goto L52;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((w) r116).f295510a, r111.f295169g) == false) goto L48;
    L53:
        w r117 = (w) r116;
        if (r117 == null) goto L56;
        r117.f295528s = 1;
    L57:
        if (r117 != null) goto L37;
        if (r113 < 0) goto L37;
        List<w> r118 = r111.f295167e;
        if (r118 == null) goto L37;
        w r119 = (w) CollectionsKt.getOrNull(r118, r113);
        if (r119 == null) goto L37;
        r119.f295528s = 1;
        goto L37
    L52:
        r116 = null;
    L56:
        r117 = null;
        goto L57
    L43:
        r113 = -1;
    L65:
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "feature option is empty");
    L25:
        if (r108.isEmpty() == true) goto L28;
        r101 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L67:
        return new wa8.a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.k) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.k.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        com.larus.bmhome.actionbar.model.k r102 = (com.larus.bmhome.actionbar.model.k) r101;
        if (r102 != null) goto L13;
        return;
    L13:
        List<com.larus.bmhome.actionbar.model.h> r112 = r102.f295258c;
        if (r112 == null) goto L48;
        Iterator<T> r113 = r112.iterator();
    L17:
        if (r113.hasNext() == false) goto L48;
        com.larus.bmhome.actionbar.model.h r103 = (com.larus.bmhome.actionbar.model.h) r113.next();
        com.larus.bmhome.actionbar.model.k r104 = this.f311992p;
        if (r104 == null) goto L17;
        List<com.larus.bmhome.actionbar.model.h> r105 = r104.f295258c;
        if (r105 == null) goto L17;
        Iterator<T> r106 = r105.iterator();
    L24:
        if (r106.hasNext() == false) goto L28;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r107).f295164b, r103.f295164b) == false) goto L24;
    L29:
        com.larus.bmhome.actionbar.model.h r108 = (com.larus.bmhome.actionbar.model.h) r107;
        if (r108 == null) goto L17;
        List<w> r109 = r103.f295167e;
        if (r109 == null) goto L36;
        w r114 = (w) CollectionsKt.firstOrNull(r109);
        if (r114 == null) goto L36;
        Long r115 = r114.f295510a;
    L37:
        if (r115 == null) goto L17;
        List<w> r116 = r108.f295167e;
        if (r116 == null) goto L17;
        Iterator<T> r117 = r116.iterator();
    L42:
        if (r117.hasNext() == false) goto L17;
        w r118 = (w) r117.next();
        if (Intrinsics.areEqual(r118.f295510a, r115) == false) goto L46;
        int r119 = 1;
    L47:
        r118.f295528s = r119;
        goto L42
    L46:
        r119 = 0;
    L36:
        r115 = null;
        goto L37
    L28:
        r107 = null;
    L48:
        List<com.larus.bmhome.actionbar.model.t> r120 = r102.f295257b;
        if (r120 == null) goto L83;
        Iterator<T> r121 = r120.iterator();
    L52:
        if (r121.hasNext() == false) goto L122;
        com.larus.bmhome.actionbar.model.t r122 = (com.larus.bmhome.actionbar.model.t) r121.next();
        com.larus.bmhome.actionbar.model.k r123 = this.f311992p;
        if (r123 == null) goto L52;
        List<com.larus.bmhome.actionbar.model.t> r124 = r123.f295257b;
        if (r124 == null) goto L52;
        Iterator<T> r125 = r124.iterator();
    L59:
        if (r125.hasNext() == false) goto L63;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.t) r126).f295443a, r122.f295443a) == false) goto L59;
    L64:
        com.larus.bmhome.actionbar.model.t r127 = (com.larus.bmhome.actionbar.model.t) r126;
        if (r127 == null) goto L52;
        List<w> r128 = r122.f295445c;
        if (r128 == null) goto L71;
        w r129 = (w) CollectionsKt.firstOrNull(r128);
        if (r129 == null) goto L71;
        Long r130 = r129.f295510a;
    L72:
        if (r130 == null) goto L52;
        List<w> r131 = r127.f295445c;
        if (r131 == null) goto L52;
        Iterator<T> r132 = r131.iterator();
    L77:
        if (r132.hasNext() == false) goto L52;
        w r133 = (w) r132.next();
        if (Intrinsics.areEqual(r133.f295510a, r130) == false) goto L81;
        int r134 = 1;
    L82:
        r133.f295528s = r134;
        goto L77
    L81:
        r134 = 0;
    L71:
        r130 = null;
        goto L72
    L63:
        r126 = null;
        goto L64
    L122:
        return;
    L83:
        return;
    L5:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
