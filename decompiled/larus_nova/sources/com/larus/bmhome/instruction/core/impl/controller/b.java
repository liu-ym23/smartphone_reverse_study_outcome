package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.a f311984p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f311985q;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 16;
    }

    public b() {
        super("ButtonRouterController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.a r100 = this.f311984p;
        if (r100 == null) goto L28;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.f294947b;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L29;
        com.larus.bmhome.actionbar.model.a r104 = this.f311984p;
        if (r104 == null) goto L19;
        r101 = r104.f294948c;
    L19:
        if (r101 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (r101.length() == 0) goto L24;
        r105 = false;
        goto L25
    L29:
        return false;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L7:
        r102 = null;
        goto L9
    L28:
        return false;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.c(getWidgetId(), this.f311933o, this.f311984p, p());
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.a r100 = this.f311984p;
        Object r101 = null;
        if (r100 != null) goto L15;
        return null;
    L15:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(xt7.d.f565073b.a(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r101 = r103;
    L14:
        return (String) r101;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final z0 p() {
        com.larus.bmhome.instruction.core.impl.base.c r100 = this.f311921c;
        if (r100 == null) goto L9;
        aq8.d r101 = r100.f311935a;
        if (r101 == null) goto L9;
        dq8.h r102 = r101.f15937a;
        if (r102 == null) goto L9;
        String r103 = r102.getBotId();
    L10:
        com.larus.bmhome.instruction.core.impl.base.c r104 = this.f311921c;
        if (r104 == null) goto L17;
        aq8.d r105 = r104.f311935a;
        if (r105 == null) goto L17;
        dq8.h r106 = r105.f15937a;
        if (r106 == null) goto L17;
        String r107 = r106.getConversationId();
    L18:
        com.larus.bmhome.instruction.core.impl.base.c r108 = this.f311921c;
        if (r108 == null) goto L25;
        aq8.d r109 = r108.f311935a;
        if (r109 == null) goto L25;
        dq8.h r110 = r109.f15937a;
        if (r110 == null) goto L25;
        String r111 = r110.getChatType();
    L26:
        com.larus.bmhome.instruction.core.impl.base.c r112 = this.f311921c;
        if (r112 == null) goto L33;
        aq8.d r113 = r112.f311935a;
        if (r113 == null) goto L33;
        dq8.h r114 = r113.f15937a;
        if (r114 == null) goto L33;
        String r115 = r114.getTemplateType();
    L34:
        com.larus.bmhome.instruction.core.impl.base.c r116 = this.f311921c;
        if (r116 == null) goto L41;
        aq8.d r117 = r116.f311935a;
        if (r117 == null) goto L41;
        dq8.h r118 = r117.f15937a;
        if (r118 == null) goto L41;
        String r119 = r118.c();
    L42:
        com.larus.bmhome.instruction.core.impl.base.c r120 = this.f311921c;
        if (r120 == null) goto L51;
        aq8.d r121 = r120.f311935a;
        if (r121 == null) goto L51;
        dq8.h r122 = r121.f15937a;
        if (r122 == null) goto L51;
        Integer r123 = r122.getInstructionType();
        if (r123 == null) goto L51;
        String r124 = r123.toString();
    L52:
        com.larus.bmhome.instruction.core.impl.base.c r125 = this.f311921c;
        if (r125 == null) goto L59;
        aq8.d r126 = r125.f311935a;
        if (r126 == null) goto L59;
        dq8.h r127 = r126.f15937a;
        if (r127 == null) goto L59;
        String r128 = r127.a();
    L60:
        com.larus.bmhome.instruction.core.impl.base.c r129 = this.f311921c;
        if (r129 == null) goto L67;
        aq8.d r130 = r129.f311935a;
        if (r130 == null) goto L67;
        dq8.h r131 = r130.f15937a;
        if (r131 == null) goto L67;
        String r132 = r131.b();
    L68:
        com.larus.bmhome.instruction.core.impl.base.c r133 = this.f311921c;
        if (r133 == null) goto L75;
        aq8.d r134 = r133.f311935a;
        if (r134 == null) goto L75;
        dq8.h r135 = r134.f15937a;
        if (r135 == null) goto L75;
        Boolean r136 = r135.isCreationActionBar();
    L76:
        com.larus.bmhome.actionbar.model.u r137 = this.f311920b;
        if (r137 == null) goto L86;
        String r138 = r137.f295476c;
        if (r138 == null) goto L86;
        if (r138.length() <= 0) goto L83;
        boolean r139 = true;
    L84:
        if (r139 == false) goto L86;
        String r140 = r138;
    L88:
        return new z0(r103, r107, r111, r115, r119, r124, r128, r132, r136, r140);
    L83:
        r139 = false;
    L86:
        r140 = null;
    L75:
        r136 = null;
    L67:
        r132 = null;
    L59:
        r128 = null;
    L51:
        r124 = null;
    L41:
        r119 = null;
    L33:
        r115 = null;
    L25:
        r111 = null;
    L17:
        r107 = null;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        boolean r100 = true;
        if ((r110 instanceof cq8.e) == false) goto L14;
        if (Intrinsics.areEqual(((cq8.e) r110).f464822b, getWidgetId()) == true) goto L7;
        return;
    L7:
        if (this.f311985q == true) goto L63;
        com.larus.bmhome.actionbar.model.a r111 = this.f311984p;
        if (r111 == null) goto L64;
        this.f311985q = true;
        o(new com.larus.bmhome.instruction.core.impl.base.k.b(new dq8.b(getWidgetId(), r111, p())));
        return;
    L64:
        return;
    L63:
        return;
    L14:
        if ((r110 instanceof cq8.b) == false) goto L33;
        if (Intrinsics.areEqual(((cq8.b) r110).f464802b, getWidgetId()) == false) goto L65;
        com.larus.bmhome.actionbar.model.a r101 = this.f311984p;
        if (r101 == null) goto L66;
        String r102 = getWidgetId();
        com.larus.bmhome.actionbar.model.a r103 = this.f311984p;
        if (r103 == null) goto L30;
        List<w> r104 = r103.f294955j;
        if (r104 == null) goto L30;
        w r105 = (w) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L30;
        Map<String, String> r106 = r105.f295526q;
        if (r106 == null) goto L30;
        String r107 = r106.get("selected_id");
    L31:
        o(new com.larus.bmhome.instruction.core.impl.base.k.a(new dq8.a(r102, r101, r107, p(), this.f311933o)));
        return;
    L30:
        r107 = null;
        goto L31
    L66:
        return;
    L65:
        return;
    L33:
        if ((r110 instanceof cq8.d) == false) goto L62;
        cq8.d r112 = (cq8.d) r110;
        if (Intrinsics.areEqual(r112.f464814b, getWidgetId()) == false) goto L67;
        com.larus.bmhome.actionbar.model.a r108 = this.f311984p;
        if (r108 == null) goto L68;
        String r109 = r112.f464816d;
        String r113 = r112.f464815c;
        if (r113 != null) goto L43;
    L56:
        List<w> r114 = CollectionsKt.emptyList();
    L57:
        r108.f294955j = r114;
        j();
        return;
    L43:
        if (r109 != null) goto L45;
    L50:
        r100 = false;
    L51:
        if (r100 == false) goto L56;
        Map r115 = MapsKt.createMapBuilder();
        r115.put("selected_id", r113);
        r115.put("selected_name", r109);
        Map<String, String> r116 = r112.f464818f;
        if (r116 == null) goto L55;
        r115.putAll(r116);
    L55:
        Unit r117 = Unit.INSTANCE;
        r114 = CollectionsKt.listOf(new w(null, r109, null, null, 0, MapsKt.toMutableMap(MapsKt.build(r115)), null, 8323069));
        goto L57
    L45:
        if (r109.length() <= 0) goto L47;
        boolean r118 = true;
    L48:
        if (r118 != true) goto L50;
    L47:
        r118 = false;
        goto L48
    L68:
        return;
    L67:
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
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.a) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L42;
        com.larus.bmhome.actionbar.model.a r106 = (com.larus.bmhome.actionbar.model.a) r104;
        if (r106 == null) goto L21;
        String r107 = r106.f294947b;
    L22:
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == true) goto L40;
        String r109 = r106.f294948c;
        if (r109 != null) goto L32;
    L35:
        if (r101 == true) goto L40;
        this.f311984p = r106;
        return new wa8.a0(Boolean.TRUE, "");
    L32:
        if (r109.length() == 0) goto L35;
        r101 = false;
    L40:
        return new wa8.a0(Boolean.FALSE, "ButtonRouter info is required displayText=" + r106.f294947b + " schema=" + r106.f294948c);
    L24:
        if (r107.length() == 0) goto L27;
        r108 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L42:
        return new wa8.a0(Boolean.FALSE, "Failed to parse button router template: " + r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "Button router template is empty");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.a) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.a r104 = (com.larus.bmhome.actionbar.model.a) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        this.f311984p = r104;
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
