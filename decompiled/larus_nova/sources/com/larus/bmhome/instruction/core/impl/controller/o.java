package com.larus.bmhome.instruction.core.impl.controller;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.im.FlowRuntime;
import cq8.a0;
import cq8.l0;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import ouc.e0;

/* JADX INFO: loaded from: classes26.dex */
public final class o extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b0 f312008p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public o() {
        super("MultiSelectorController");
        ((ArrayList) this.f311924f).clear();
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

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        List<com.larus.bmhome.instruction.core.impl.base.e> r100 = this.f311924f;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = ((ArrayList) r100).iterator();
    L3:
        Unit r103 = null;
        if (r102.hasNext() == false) goto L9;
        com.larus.bmhome.instruction.core.impl.base.e r104 = (com.larus.bmhome.instruction.core.impl.base.e) r102.next();
        if (r104 == null) goto L8;
        r104.j();
        r103 = Unit.INSTANCE;
    L8:
        r101.add(r103);
        goto L3
    L9:
        String r105 = getWidgetId();
        com.larus.bmhome.actionbar.model.u r106 = this.f311920b;
        if (r106 == null) goto L14;
        Integer r107 = r106.f295481h;
        if (r107 == null) goto L14;
        int r108 = r107.intValue();
    L15:
        com.larus.bmhome.actionbar.model.u r109 = this.f311920b;
        if (r109 == null) goto L22;
        String r110 = r109.f295476c;
        if (r110 == null) goto L22;
        if (com.flow.kmp.common.util.f.a(r110) == false) goto L22;
        String r111 = r110;
    L23:
        com.larus.bmhome.actionbar.model.u r112 = this.f311920b;
        if (r112 == null) goto L26;
        boolean r113 = Intrinsics.areEqual(r112.f295479f, Boolean.TRUE);
    L27:
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r114 = this.f311933o;
        b0 r115 = this.f312008p;
        com.larus.bmhome.actionbar.model.u r116 = this.f311920b;
        if (r116 == null) goto L32;
        Integer r117 = r116.f295475b;
        if (r117 == null) goto L32;
        int r118 = r117.intValue();
    L33:
        List<com.larus.bmhome.instruction.core.impl.base.e> r119 = this.f311924f;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = ((ArrayList) r119).iterator();
    L35:
        if (r121.hasNext() == false) goto L45;
        com.larus.bmhome.instruction.core.impl.base.e r122 = (com.larus.bmhome.instruction.core.impl.base.e) r121.next();
        if ((r122 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L39;
        com.larus.bmhome.instruction.core.impl.base.b r123 = (com.larus.bmhome.instruction.core.impl.base.b) r122;
    L40:
        if (r123 == null) goto L42;
        y0 r124 = new y0(r123.getWidgetId(), this.f311925g, r123.f311928j);
    L43:
        r120.add(r124);
        goto L35
    L42:
        r124 = null;
        goto L43
    L39:
        r123 = null;
        goto L40
    L45:
        return new l0(r105, r114, r111, Integer.valueOf(r108), r113, r115, r118, r120);
    L32:
        r118 = 0;
        goto L33
    L26:
        r113 = false;
    L22:
        r111 = null;
    L14:
        r108 = 0;
        goto L15
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r100 = null;
        if (this.f312008p != null) goto L5;
        return null;
    L5:
        Iterator r101 = ((ArrayList) this.f311924f).iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L31;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.larus.bmhome.instruction.core.impl.base.e r105 = (com.larus.bmhome.instruction.core.impl.base.e) r103;
        if (r105 == null) goto L20;
        b0 r106 = this.f312008p;
        if (r106 == null) goto L20;
        List<c0> r107 = r106.f294985a;
        if (r107 == null) goto L20;
        c0 r108 = (c0) ListProtector.get(r107, r102);
        if (r108 == null) goto L20;
        r108.f295033c = r105.g();
    L20:
        r102 = r104;
        goto L7
    L31:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L23
        Object r110 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(b0.Companion.serializer()), this.f312008p));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r110) == true) goto L30;
        r100 = r110;
    L30:
        return (String) r100;
    L23:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Iterator<T> r101 = this.f311924f.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        com.larus.bmhome.instruction.core.impl.base.e r102 = (com.larus.bmhome.instruction.core.impl.base.e) r101.next();
        if (r102 == null) goto L4;
        r102.m(r100);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [T, com.larus.bmhome.instruction.core.impl.base.e] */
    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        Object r102 = Result.m9449constructorimpl((b0) xt7.d.f565073b.c(b0.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 != null) goto L88;
        b0 r104 = (b0) r102;
        if (r104 == null) goto L21;
        List<c0> r105 = r104.f294985a;
    L22:
        List<c0> r106 = r105;
        if (r106 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == true) goto L31;
        this.f312008p = r104;
        if (r104 == null) goto L86;
        List<c0> r108 = r104.f294985a;
        if (r108 == null) goto L86;
        Iterator<T> r109 = r108.iterator();
        int r111 = 0;
    L38:
        if (r109.hasNext() == false) goto L86;
        Object r112 = r109.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        c0 r114 = (c0) r112;
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        Ref.ObjectRef r116 = new Ref.ObjectRef();
        Lazy r117 = xp8.h.f564739a;
        int r118 = r114.f295032b;
        Iterator r119 = ((Set) xp8.h.f564740b.getValue()).iterator();
    L44:
        if (r119.hasNext() == false) goto L51;
        Object r120 = r119.next();
        if (r118 != ((com.larus.bmhome.instruction.core.impl.base.g) r120).getMultiItemType()) goto L48;
        boolean r121 = true;
    L49:
        if (r121 == false) goto L44;
    L52:
        com.larus.bmhome.instruction.core.impl.base.g r122 = (com.larus.bmhome.instruction.core.impl.base.g) r120;
        if (r122 == null) goto L64;
        ?? r123 = r122.d();
        if ((r123 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L57;
        com.larus.bmhome.instruction.core.impl.base.b r124 = (com.larus.bmhome.instruction.core.impl.base.b) r123;
        CoroutineScope r125 = this.f311925g;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r124.f311925g = r125;
        r124.f311926h = this.f311926h;
    L57:
        r123.h(r114.f295031a);
        String r126 = r114.f295033c;
        if (r126 == null) goto L62;
        com.larus.bmhome.instruction.core.impl.base.c r127 = this.f311921c;
        if (r127 == null) goto L62;
        T r128 = r123.k(this.f311920b, r127, this.f311923e, this, r126);
    L63:
        r116.element = r128;
        r115.element = r123;
    L62:
        r128 = 0;
    L64:
        wa8.a0 r129 = (wa8.a0) r116.element;
        if (r129 == null) goto L67;
        boolean r130 = Intrinsics.areEqual(r129.f558831a, Boolean.TRUE);
    L68:
        if (r130 == false) goto L72;
        com.larus.bmhome.instruction.core.impl.base.e r131 = (com.larus.bmhome.instruction.core.impl.base.e) r115.element;
        if (r131 == null) goto L73;
        ((ArrayList) this.f311924f).add(r131);
    L73:
        e0 r132 = new e0();
        wa8.a0 r133 = (wa8.a0) r116.element;
        if (r133 == null) goto L76;
        boolean r134 = Intrinsics.areEqual(r133.f558831a, Boolean.TRUE);
    L77:
        if (r134 == false) goto L79;
        String r135 = "1";
    L80:
        ouc.j.c(r132, "is_success", r135);
        wa8.a0 r136 = (wa8.a0) r116.element;
        if (r136 == null) goto L83;
        String r137 = r136.f558832b;
    L84:
        ouc.j.c(r132, "fail_reason", r137);
        ouc.j.c(r132, "instruction_type", String.valueOf(r114.f295032b));
        FlowRuntime.b().d().a("flow_instruction_decode_template", r132.a());
        r111 = r113;
        goto L38
    L83:
        r137 = null;
        goto L84
    L79:
        r135 = "0";
        goto L80
    L76:
        r134 = false;
        goto L77
    L72:
        ((ArrayList) this.f311924f).add(null);
        goto L73
    L67:
        r130 = false;
        goto L68
    L48:
        r121 = false;
        goto L49
    L51:
        r120 = null;
    L86:
        return new wa8.a0(Boolean.TRUE, "");
    L31:
        return new wa8.a0(Boolean.FALSE, "multi option is empty");
    L25:
        if (r106.isEmpty() == true) goto L28;
        r107 = false;
        goto L29
    L21:
        r105 = null;
        goto L22
    L88:
        return new wa8.a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((b0) xt7.d.f565073b.c(b0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        b0 r104 = (b0) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<c0> r105 = r104.f294985a;
        if (r105 == null) goto L42;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L60;
        c0 r107 = (c0) r106.next();
        b0 r108 = this.f312008p;
        if (r108 == null) goto L17;
        List<c0> r109 = r108.f294985a;
        if (r109 == null) goto L17;
        Iterator<c0> r110 = r109.iterator();
        int r111 = 0;
    L24:
        if (r110.hasNext() == false) goto L34;
        c0 r112 = r110.next();
        if (r112.f295032b == r107.f295032b) goto L28;
    L30:
        boolean r113 = false;
    L31:
        if (r113 == true) goto L35;
        r111 = r111 + 1;
    L35:
        String r114 = r107.f295033c;
        if (r114 == null) goto L17;
        List<com.larus.bmhome.instruction.core.impl.base.e> r115 = this.f311924f;
        if (r115 == null) goto L17;
        com.larus.bmhome.instruction.core.impl.base.e r116 = (com.larus.bmhome.instruction.core.impl.base.e) CollectionsKt.getOrNull(r115, r111);
        if (r116 == null) goto L17;
        r116.i(r114, false);
        goto L17
    L28:
        if (Intrinsics.areEqual(r112.f295031a, r107.f295031a) == false) goto L30;
        r113 = true;
        goto L31
    L34:
        r111 = -1;
        goto L35
    L60:
        return;
    L42:
        return;
    L5:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
