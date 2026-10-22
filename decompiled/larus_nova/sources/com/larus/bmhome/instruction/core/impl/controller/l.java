package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.v;
import com.larus.bmhome.actionbar.model.z0;
import cq8.a0;
import cq8.f0;
import cq8.g0;
import cq8.h0;
import cq8.y;
import cq8.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public final class l extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<z0> f312001p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f312002q;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return -100;
    }

    public l() {
        super("MenuTabContainerController");
        this.f312001p = CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        List r100 = CollectionsKt.filterNotNull(this.f311924f);
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((com.larus.bmhome.instruction.core.impl.base.e) r101.next()).a() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final List<com.larus.bmhome.actionbar.model.u> c() {
        List<com.larus.bmhome.instruction.core.impl.base.e> r100 = this.f311924f;
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) r100).iterator();
    L3:
        boolean r103 = true;
        Object r104 = null;
        if (r102.hasNext() == false) goto L25;
        com.larus.bmhome.instruction.core.impl.base.e r105 = (com.larus.bmhome.instruction.core.impl.base.e) r102.next();
        if ((r105 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L8;
        com.larus.bmhome.instruction.core.impl.base.b r106 = (com.larus.bmhome.instruction.core.impl.base.b) r105;
    L9:
        if (r106 == null) goto L23;
        String r110 = r106.g();
        if (r110 != null) goto L14;
    L17:
        if (r103 == true) goto L23;
        com.larus.bmhome.actionbar.model.u r107 = r106.f311920b;
        if (r107 == null) goto L22;
        r104 = r107.f295474a;
    L22:
        r104 = new com.larus.bmhome.actionbar.model.u(r104, Integer.valueOf(r106.getType()), null, r110, null, null, null, 244);
        goto L23
    L14:
        if (r110.length() == 0) goto L17;
        r103 = false;
    L23:
        if (r104 == null) goto L3;
        r101.add(r104);
        goto L3
    L8:
        r106 = null;
        goto L9
    L25:
        List r108 = CollectionsKt.toMutableList(r101);
        com.larus.bmhome.instruction.core.impl.base.c r109 = this.f311921c;
        if (r109 == null) goto L32;
        aq8.d r111 = r109.f311935a;
        if (r111 == null) goto L32;
        dq8.f r112 = r111.f15939c;
        if (r112 == null) goto L32;
        List<MediaAttachment> r113 = r112.a();
    L33:
        List<MediaAttachment> r114 = r113;
        if (r114 != null) goto L36;
    L39:
        boolean r115 = true;
    L40:
        if (r115 == true) goto L90;
        z0 r116 = (z0) CollectionsKt.getOrNull(this.f312001p, this.f312002q);
        if (r116 == null) goto L90;
        com.larus.bmhome.actionbar.model.r r117 = r116.f295621q;
        if (r117 == null) goto L90;
        List<com.larus.bmhome.actionbar.model.u> r118 = r117.f295409b;
        if (r118 == null) goto L90;
        Iterator<T> r119 = r118.iterator();
    L51:
        if (r119.hasNext() == false) goto L61;
        Object r120 = r119.next();
        Integer r121 = ((com.larus.bmhome.actionbar.model.u) r120).f295475b;
        if (r121 != null) goto L56;
    L58:
        boolean r122 = false;
    L59:
        if (r122 == false) goto L51;
    L62:
        com.larus.bmhome.actionbar.model.u r123 = (com.larus.bmhome.actionbar.model.u) r120;
        if (r123 == null) goto L90;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L70
        String r125 = r123.f295477d;     // Catch: Throwable -> L70
        if (r125 == null) goto L67;
        v r126 = (v) xt7.d.f565073b.c(v.Companion.serializer(), r125);     // Catch: Throwable -> L70
    L68:
        Object r127 = Result.m9449constructorimpl(r126);     // Catch: Throwable -> L70
    L73:
        if (Result.m9455isFailureimpl(r127) == false) goto L75;
        r127 = null;
    L75:
        v r128 = (v) r127;
        if (r128 != null) goto L78;
        r128 = new v(null, null, 15);
    L78:
        r128.f295497c = r113;
        Object r129 = Result.m9449constructorimpl(xt7.d.f565073b.a(v.Companion.serializer(), r128));     // Catch: Throwable -> L81
    L84:
        if (Result.m9455isFailureimpl(r129) == false) goto L86;
        r129 = null;
    L86:
        String r130 = (String) r129;
        if (r130 == null) goto L90;
        com.larus.bmhome.actionbar.model.u r131 = new com.larus.bmhome.actionbar.model.u(r123.f295474a, 15, null, r130, null, null, null, 244);
    L91:
        if (r131 == null) goto L93;
        r108.add(r131);
    L93:
        List r132 = r108;
        if (r132.isEmpty() == true) goto L98;
        r104 = r132;
    L98:
        return (List) r104;
    L81:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L84
    L67:
        r126 = null;
    L70:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L56:
        if (r121.intValue() != 15) goto L58;
        r122 = true;
        goto L59
    L61:
        r120 = null;
    L90:
        r131 = null;
        goto L91
    L36:
        if (r114.isEmpty() == true) goto L39;
        r115 = false;
    L32:
        r113 = null;
        goto L33
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        Iterator r100 = ((ArrayList) this.f311924f).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        com.larus.bmhome.instruction.core.impl.base.e r101 = (com.larus.bmhome.instruction.core.impl.base.e) r100.next();
        if (r101 == null) goto L4;
        r101.j();
        goto L4
    L8:
        String r102 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r103 = this.f311933o;
        com.larus.bmhome.actionbar.model.u r104 = this.f311920b;
        if (r104 == null) goto L15;
        String r105 = r104.f295476c;
        if (r105 == null) goto L15;
        if ((!StringsKt.isBlank(r105)) == false) goto L15;
    L16:
        String r106 = r105;
        com.larus.bmhome.actionbar.model.u r107 = this.f311920b;
        if (r107 == null) goto L19;
        boolean r108 = Intrinsics.areEqual(r107.f295479f, Boolean.TRUE);
    L20:
        List<z0> r109 = this.f312001p;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
        int r112 = 0;
    L22:
        if (r111.hasNext() == false) goto L37;
        Object r113 = r111.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        z0 r115 = (z0) r113;
        com.larus.bmhome.actionbar.model.r r116 = r115.f295621q;
        if (r116 == null) goto L31;
        Integer r117 = r116.f295408a;
        if (r117 == null) goto L31;
        int r118 = r117.intValue();
    L32:
        long r119 = r118;
        String r120 = r115.f295609e;
        if (r112 != this.f312002q) goto L35;
        boolean r121 = true;
    L36:
        r110.add(new g0(r119, r120, r121));
        r112 = r114;
        goto L22
    L35:
        r121 = false;
    L31:
        r118 = 0;
        goto L32
    L37:
        List r122 = CollectionsKt.filterNotNull(this.f311924f);
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
    L39:
        if (r124.hasNext() == false) goto L42;
        com.larus.bmhome.instruction.core.impl.base.e r125 = (com.larus.bmhome.instruction.core.impl.base.e) r124.next();
        String r126 = r125.getWidgetId();
        CoroutineScope r127 = this.f311925g;
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type com.larus.bmhome.instruction.core.impl.base.AbsInstructionController");
        r123.add(new y0(r126, r127, ((com.larus.bmhome.instruction.core.impl.base.b) r125).f311928j));
        goto L39
    L42:
        return new f0(r102, r103, r110, r106, r108, r123);
    L19:
        r108 = false;
    L15:
        r105 = null;
        goto L16
    }

    public final void p() {
        ((ArrayList) this.f311924f).clear();
        z0 r100 = (z0) CollectionsKt.getOrNull(this.f312001p, this.f312002q);
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.instruction.core.impl.base.c r101 = this.f311921c;
        if (r101 != null) goto L8;
        return;
    L8:
        com.larus.bmhome.actionbar.model.r r102 = r100.f295621q;
        if (r102 == null) goto L11;
        Integer r103 = r102.f295408a;
    L12:
        if (r102 == null) goto L43;
        List<com.larus.bmhome.actionbar.model.u> r104 = r102.f295409b;
        if (r104 == null) goto L55;
        Iterator<T> r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L56;
        com.larus.bmhome.actionbar.model.u r106 = (com.larus.bmhome.actionbar.model.u) r105.next();
        Lazy r107 = xp8.h.f564739a;
        Integer r108 = r106.f295475b;
        if (r108 == null) goto L21;
        int r109 = r108.intValue();
    L22:
        Iterator r110 = ((Set) xp8.h.f564739a.getValue()).iterator();
    L24:
        if (r110.hasNext() == false) goto L31;
        Object r111 = r110.next();
        if (r109 != ((com.larus.bmhome.instruction.core.impl.base.f) r111).p()) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L24;
    L32:
        com.larus.bmhome.instruction.core.impl.base.f r113 = (com.larus.bmhome.instruction.core.impl.base.f) r111;
        if (r113 == null) goto L34;
        com.larus.bmhome.instruction.core.impl.base.e r114 = r113.d();
        if ((r114 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L38;
        com.larus.bmhome.instruction.core.impl.base.b r115 = (com.larus.bmhome.instruction.core.impl.base.b) r114;
        CoroutineScope r116 = this.f311925g;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r115.f311925g = r116;
        r115.f311926h = r103;
    L38:
        wa8.a0 r117 = r114.k(r106, r101, this.f311923e, this, r106.f295477d);
        List<com.larus.bmhome.instruction.core.impl.base.e> r118 = this.f311924f;
        if (Intrinsics.areEqual(r117.f558831a, Boolean.TRUE) == true) goto L42;
        r114 = null;
    L42:
        ((ArrayList) r118).add(r114);
        goto L17
    L34:
        ((ArrayList) this.f311924f).add(null);
        goto L17
    L28:
        r112 = false;
        goto L29
    L31:
        r111 = null;
        goto L32
    L21:
        r109 = 0;
        goto L22
    L56:
        return;
    L55:
        return;
    L43:
        return;
    L11:
        r103 = null;
        goto L12
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof h0) == false) goto L29;
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(r101.f464845b, getWidgetId()) == true) goto L7;
        return;
    L7:
        long r102 = r101.f464846c;
        Iterator<z0> r103 = this.f312001p.iterator();
        int r104 = 0;
    L9:
        if (r103.hasNext() == false) goto L23;
        com.larus.bmhome.actionbar.model.r r105 = r103.next().f295621q;
        if (r105 == null) goto L15;
        Integer r106 = r105.f295408a;
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L17:
        if (r107 != r102) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L24;
        r104 = r104 + 1;
    L24:
        if (r104 >= 0) goto L26;
        return;
    L26:
        if (r104 == this.f312002q) goto L44;
        this.f312002q = r104;
        p();
        o(new com.larus.bmhome.instruction.core.impl.base.k.m(this.f312002q));
        j();
        return;
    L44:
        return;
    L19:
        r108 = false;
    L15:
        r107 = 0;
        goto L17
    L23:
        r104 = -1;
        goto L24
    L29:
        Iterator r109 = ((ArrayList) this.f311924f).iterator();
    L31:
        if (r109.hasNext() == false) goto L45;
        com.larus.bmhome.instruction.core.impl.base.e r110 = (com.larus.bmhome.instruction.core.impl.base.e) r109.next();
        if (r110 == null) goto L31;
        r110.m(r100);
        goto L31
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r110) {
        com.larus.bmhome.instruction.core.impl.base.c r111 = this.f311921c;
        if (r111 == null) goto L5;
        com.larus.bmhome.instruction.core.impl.base.i r112 = r111.f311937c;
    L6:
        if (r112 == null) goto L12;
        com.larus.bmhome.actionbar.model.r r100 = r112.f311942d;
        if (r100 == null) goto L12;
        com.larus.bmhome.actionbar.model.y r101 = r100.f295416i;
        if (r101 == null) goto L12;
        ArrayList<z0> r102 = r101.f295561a;
    L14:
        if (r102 != null) goto L16;
    L19:
        boolean r103 = true;
    L20:
        if (r103 == true) goto L22;
        com.larus.bmhome.actionbar.model.r r104 = r112.f311940b;
        com.larus.bmhome.actionbar.model.r r113 = r112.f311941c;
        this.f312001p = r102;
        if (r104 != null) goto L26;
        com.larus.bmhome.actionbar.model.r r105 = r113;
    L27:
        if (r105 == null) goto L56;
        com.larus.bmhome.actionbar.model.y r106 = r105.f295416i;
        if (r106 == null) goto L56;
        ArrayList<z0> r107 = r106.f295561a;
        if (r107 == null) goto L56;
        z0 r108 = (z0) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L56;
        com.larus.bmhome.actionbar.model.r r109 = r108.f295621q;
        if (r109 == null) goto L56;
        Integer r114 = r109.f295408a;
        if (r114 == null) goto L56;
        int r115 = r114.intValue();
        Iterator<z0> r116 = this.f312001p.iterator();
        int r117 = 0;
    L40:
        if (r116.hasNext() == false) goto L53;
        com.larus.bmhome.actionbar.model.r r118 = r116.next().f295621q;
        if (r118 == null) goto L49;
        Integer r119 = r118.f295408a;
        if (r119 == null) goto L49;
        if (r119.intValue() != r115) goto L49;
        boolean r120 = true;
    L50:
        if (r120 == true) goto L54;
        r117 = r117 + 1;
    L54:
        if (r117 < 0) goto L56;
    L57:
        this.f312002q = r117;
        p();
        if (r104 != null) goto L60;
        r104 = r113;
    L60:
        z0 r121 = (z0) CollectionsKt.getOrNull(this.f312001p, this.f312002q);
        if (r121 == null) goto L131;
        if (r104 == null) goto L131;
        com.larus.bmhome.actionbar.model.y r122 = r104.f295416i;
        if (r122 == null) goto L131;
        ArrayList<z0> r123 = r122.f295561a;
        if (r123 == null) goto L131;
        Iterator<T> r124 = r123.iterator();
    L70:
        if (r124.hasNext() == false) goto L82;
        Object r125 = r124.next();
        com.larus.bmhome.actionbar.model.r r126 = ((z0) r125).f295621q;
        if (r126 == null) goto L74;
        Integer r127 = r126.f295408a;
    L75:
        com.larus.bmhome.actionbar.model.r r128 = r121.f295621q;
        if (r128 == null) goto L78;
        Integer r129 = r128.f295408a;
    L80:
        if (Intrinsics.areEqual(r127, r129) == false) goto L70;
    L83:
        z0 r130 = (z0) r125;
        if (r130 == null) goto L131;
        com.larus.bmhome.actionbar.model.r r131 = r130.f295621q;
        if (r131 == null) goto L131;
        List<com.larus.bmhome.actionbar.model.u> r132 = r131.f295409b;
        if (r132 == null) goto L131;
        Iterator r133 = ((ArrayList) this.f311924f).iterator();
        int r134 = 0;
    L93:
        if (r133.hasNext() == false) goto L131;
        Object r135 = r133.next();
        int r136 = r134 + 1;
        if (r134 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();
    L97:
        com.larus.bmhome.instruction.core.impl.base.e r137 = (com.larus.bmhome.instruction.core.impl.base.e) r135;
        if (r137 == null) goto L129;
        com.larus.bmhome.actionbar.model.r r138 = r121.f295621q;
        if (r138 == null) goto L129;
        List<com.larus.bmhome.actionbar.model.u> r139 = r138.f295409b;
        if (r139 == null) goto L129;
        com.larus.bmhome.actionbar.model.u r140 = (com.larus.bmhome.actionbar.model.u) CollectionsKt.getOrNull(r139, r134);
        if (r140 == null) goto L129;
        Iterator<T> r141 = r132.iterator();
    L109:
        if (r141.hasNext() == false) goto L118;
        Object r142 = r141.next();
        com.larus.bmhome.actionbar.model.u r143 = (com.larus.bmhome.actionbar.model.u) r142;
        if (Intrinsics.areEqual(r143.f295475b, r140.f295475b) == true) goto L113;
    L115:
        boolean r144 = false;
    L116:
        if (r144 == false) goto L109;
    L119:
        com.larus.bmhome.actionbar.model.u r145 = (com.larus.bmhome.actionbar.model.u) r142;
        if (r145 == null) goto L129;
        String r146 = r145.f295477d;
        if (r146 == null) goto L129;
        if (r146.length() <= 0) goto L126;
        boolean r147 = true;
    L127:
        if (r147 == false) goto L129;
        r137.i(r146, false);
        goto L129
    L126:
        r147 = false;
        goto L127
    L113:
        if (Intrinsics.areEqual(r143.f295474a, r140.f295474a) == false) goto L115;
        r144 = true;
        goto L116
    L118:
        r142 = null;
    L129:
        r134 = r136;
        goto L93
    L78:
        r129 = null;
        goto L80
    L74:
        r127 = null;
        goto L75
    L82:
        r125 = null;
    L131:
        return new wa8.a0(Boolean.TRUE, "");
    L49:
        r120 = false;
        goto L50
    L53:
        r117 = -1;
    L56:
        r117 = 0;
        goto L57
    L26:
        r105 = r104;
        goto L27
    L22:
        return new wa8.a0(Boolean.FALSE, "menuConf actionBarItemList is empty");
    L16:
        if (r102.isEmpty() == true) goto L19;
        r103 = false;
    L12:
        r102 = null;
        goto L14
    L5:
        r112 = null;
        goto L6
    }
}
