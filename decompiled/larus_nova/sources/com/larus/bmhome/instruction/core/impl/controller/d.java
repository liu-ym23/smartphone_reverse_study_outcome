package com.larus.bmhome.instruction.core.impl.controller;

import com.alibaba.gaiax.template.GXTemplateKey;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.c f311989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f311990q;

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
        return 0;
    }

    public d() {
        super("CommandController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        com.larus.bmhome.actionbar.model.c r102 = this.f311989p;
        boolean r103 = false;
        if (r102 != null) goto L5;
        boolean r104 = false;
    L15:
        return new cq8.i(r100, r101, r102, r104, p());
    L5:
        Integer r105 = r102.f295026i;
        if (r105 != null) goto L9;
    L13:
        r104 = r103;
        goto L15
    L9:
        if (r105.intValue() != 1) goto L13;
        if (Intrinsics.areEqual(r102.f295021d, "gaokao_query_choice") == false) goto L13;
        r103 = true;
        goto L13
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.c r100 = this.f311989p;
        Object r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f311990q == true) goto L18;
        return null;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.c.Companion.serializer()), r100));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r103) == true) goto L17;
        r101 = r103;
    L17:
        return (String) r101;
    L10:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final z0 p() {
        com.larus.bmhome.instruction.core.impl.base.c r100 = this.f311921c;
        String r101 = null;
        if (r100 == null) goto L9;
        aq8.d r102 = r100.f311935a;
        if (r102 == null) goto L9;
        dq8.h r103 = r102.f15937a;
        if (r103 == null) goto L9;
        String r104 = r103.getBotId();
    L10:
        com.larus.bmhome.instruction.core.impl.base.c r105 = this.f311921c;
        if (r105 == null) goto L17;
        aq8.d r106 = r105.f311935a;
        if (r106 == null) goto L17;
        dq8.h r107 = r106.f15937a;
        if (r107 == null) goto L17;
        String r108 = r107.getConversationId();
    L18:
        com.larus.bmhome.instruction.core.impl.base.c r109 = this.f311921c;
        if (r109 == null) goto L25;
        aq8.d r110 = r109.f311935a;
        if (r110 == null) goto L25;
        dq8.h r111 = r110.f15937a;
        if (r111 == null) goto L25;
        String r112 = r111.getChatType();
    L26:
        com.larus.bmhome.instruction.core.impl.base.c r113 = this.f311921c;
        if (r113 == null) goto L33;
        aq8.d r114 = r113.f311935a;
        if (r114 == null) goto L33;
        dq8.h r115 = r114.f15937a;
        if (r115 == null) goto L33;
        String r116 = r115.getTemplateType();
    L34:
        com.larus.bmhome.instruction.core.impl.base.c r117 = this.f311921c;
        if (r117 == null) goto L43;
        aq8.d r118 = r117.f311935a;
        if (r118 == null) goto L43;
        dq8.h r119 = r118.f15937a;
        if (r119 == null) goto L43;
        Integer r120 = r119.getInstructionType();
        if (r120 == null) goto L43;
        String r121 = r120.toString();
    L44:
        com.larus.bmhome.instruction.core.impl.base.c r122 = this.f311921c;
        if (r122 == null) goto L51;
        aq8.d r123 = r122.f311935a;
        if (r123 == null) goto L51;
        dq8.h r124 = r123.f15937a;
        if (r124 == null) goto L51;
        String r125 = r124.a();
    L52:
        com.larus.bmhome.instruction.core.impl.base.c r126 = this.f311921c;
        if (r126 == null) goto L59;
        aq8.d r127 = r126.f311935a;
        if (r127 == null) goto L59;
        dq8.h r128 = r127.f15937a;
        if (r128 == null) goto L59;
        String r129 = r128.b();
    L60:
        com.larus.bmhome.instruction.core.impl.base.c r130 = this.f311921c;
        if (r130 == null) goto L67;
        aq8.d r131 = r130.f311935a;
        if (r131 == null) goto L67;
        dq8.h r132 = r131.f15937a;
        if (r132 == null) goto L67;
        Boolean r133 = r132.isCreationActionBar();
    L68:
        com.larus.bmhome.actionbar.model.u r134 = this.f311920b;
        if (r134 == null) goto L75;
        String r135 = r134.f295476c;
        if (r135 == null) goto L75;
        if ((!StringsKt.isBlank(r135)) == false) goto L75;
        String r136 = r135;
    L76:
        com.larus.bmhome.instruction.core.impl.base.c r137 = this.f311921c;
        if (r137 == null) goto L84;
        aq8.d r138 = r137.f311935a;
        if (r138 == null) goto L84;
        dq8.h r139 = r138.f15937a;
        if (r139 == null) goto L84;
        r101 = r139.c();
    L84:
        return new z0(r104, r108, r112, r116, r101, r121, r125, r129, r133, r136);
    L75:
        r136 = null;
    L67:
        r133 = null;
    L59:
        r129 = null;
    L51:
        r125 = null;
    L43:
        r121 = null;
    L33:
        r116 = null;
    L25:
        r112 = null;
    L17:
        r108 = null;
    L9:
        r104 = null;
        goto L10
    }

    public final void q() {
        com.larus.bmhome.actionbar.model.c r100 = this.f311989p;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f311990q == false) goto L7;
        int r101 = 1;
    L8:
        r100.f295026i = r101;
        return;
    L7:
        r101 = 0;
        goto L8
    }

    public final void r() {
        com.larus.bmhome.actionbar.model.c r100 = this.f311989p;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f295021d;
    L7:
        if (Intrinsics.areEqual(r102, "gaokao_query_choice") == true) goto L9;
        return;
    L9:
        HashMap<String, String> r103 = r100.f295020c;
        if (r103 == null) goto L12;
        r101 = r103.get(GXTemplateKey.GAIAX_PLACEHOLDER);
    L12:
        if (r101 != null) goto L14;
        r101 = "";
    L14:
        Integer r104 = r100.f295026i;
        if (r104 != null) goto L18;
    L25:
        Integer r105 = r100.f295026i;
        if (r105 != null) goto L29;
    L30:
        o(new com.larus.bmhome.instruction.core.impl.base.k.d(getWidgetId()));
        return;
    L29:
        if (r105.intValue() != 1) goto L30;
        return;
    L18:
        if (r104.intValue() != 1) goto L25;
        if (r101.length() <= 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L25;
        o(new com.larus.bmhome.instruction.core.impl.base.k.c(getWidgetId(), r101));
        return;
    L22:
        r106 = false;
        goto L23
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof cq8.h) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((cq8.h) r100).f464844b, getWidgetId()) == false) goto L7;
        com.larus.bmhome.instruction.core.impl.base.e r101 = this.f311922d;
        if ((r101 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L12;
        com.larus.bmhome.instruction.core.impl.base.b r102 = (com.larus.bmhome.instruction.core.impl.base.b) r101;
    L14:
        if (r102 == null) goto L30;
        List<com.larus.bmhome.instruction.core.impl.base.e> r103 = r102.f311924f;
        if (r103 == null) goto L30;
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((ArrayList) r103).iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        if ((r106 instanceof d) == false) goto L19;
        r104.add(r106);
        goto L19
    L23:
        Iterator r107 = r104.iterator();
    L25:
        if (r107.hasNext() == false) goto L31;
        d r108 = (d) r107.next();
        if (Intrinsics.areEqual(r108.getWidgetId(), getWidgetId()) == true) goto L28;
        r108.f311990q = false;
        r108.q();
        r108.r();
        r108.j();
        goto L25
    L28:
        r108.f311990q = true;
        r108.q();
        r108.r();
        r108.j();
    L31:
        com.larus.bmhome.actionbar.model.c r109 = this.f311989p;
        if (r109 == null) goto L78;
        String r110 = r109.f295021d;
        if (r110 != null) goto L36;
        return;
    L36:
        switch(r110.hashCode()) {
            case -1732143341: goto L60;
            case -1391384679: goto L56;
            case -916614717: goto L52;
            case -369428202: goto L48;
            case 675262186: goto L44;
            case 893571170: goto L40;
            case 1031694963: goto L38;
            default: goto L86;
        };
    L38:
        r110.equals("gaokao_query_choice");
        return;
    L86:
        return;
    L40:
        if (r110.equals("sync_calendar") == false) goto L87;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(dq8.i.e.f469703b));
        return;
    L87:
        return;
    L44:
        if (r110.equals("send_user_message") == false) goto L88;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.c(r109)));
        return;
    L88:
        return;
    L48:
        if (r110.equals("gaokao_preference") == false) goto L89;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.a(getWidgetId(), r109)));
        return;
    L89:
        return;
    L52:
        if (r110.equals("paste_url") == false) goto L90;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(dq8.i.b.f469700b));
        return;
    L90:
        return;
    L56:
        if (r110.equals("universal_camera") == false) goto L91;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.f(getWidgetId(), r109, p())));
        return;
    L91:
        return;
    L60:
        if (r110.equals("single_file") == false) goto L92;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.d(r109)));
        return;
    L92:
        return;
    L78:
        return;
    L30:
        this.f311990q = true;
        q();
        r();
        j();
        goto L31
    L12:
        r102 = null;
        goto L14
    L7:
        if (this.f311990q == false) goto L76;
        this.f311990q = false;
        q();
        r();
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        Object r111 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.c) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r111);
        if (r103 != null) goto L48;
        com.larus.bmhome.actionbar.model.c r112 = (com.larus.bmhome.actionbar.model.c) r111;
        String r104 = null;
        if (r112 == null) goto L21;
        String r105 = r112.f295019b;
    L22:
        if (r105 != null) goto L24;
    L27:
        boolean r106 = true;
    L28:
        if (r106 == true) goto L30;
        if (r112 == null) goto L34;
        r104 = r112.f295021d;
    L34:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"send_user_message", "sync_calendar", "universal_camera", "gaokao_preference", "gaokao_query_choice", "single_file", "paste_url"}), r104) == false) goto L36;
        this.f311989p = r112;
        if (r112 == null) goto L45;
        Integer r113 = r112.f295026i;
        if (r113 == null) goto L45;
        if (r113.intValue() != 1) goto L45;
        r100 = true;
    L45:
        this.f311990q = r100;
        q();
        r();
        return new wa8.a0(Boolean.TRUE, "");
    L36:
        return new wa8.a0(Boolean.FALSE, "not support command type");
    L30:
        return new wa8.a0(Boolean.FALSE, "display text is empty");
    L24:
        if (r105.length() == 0) goto L27;
        r106 = false;
        goto L28
    L21:
        r105 = null;
        goto L22
    L48:
        return new wa8.a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "command template is empty");
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.c) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.c r104 = (com.larus.bmhome.actionbar.model.c) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        this.f311989p = r104;
        this.f311990q = true;
        q();
        r();
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
