package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.core.model.widget.TranslatorSelectorType;
import com.larus.im.FlowRuntime;
import cq8.a0;
import cq8.v0;
import cq8.w0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: classes26.dex */
public final class TranslatorController extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l0 f311979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f311980q;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f311981a = null;

        static {
            int[] r100 = new int[TranslatorSelectorType.values().length];
            r100[TranslatorSelectorType.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TranslatorSelectorType.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TranslatorSelectorType.VOICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f311981a = r100;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 5;
    }

    public TranslatorController() {
        super("TranslatorController");
        this.f311980q = LazyKt.lazy(new t());
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        l0 r102 = this.f311979p;
        com.larus.bmhome.actionbar.model.u r103 = this.f311920b;
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.f295476c;
        if (r105 == null) goto L9;
        if ((!StringsKt.isBlank(r105)) == false) goto L9;
        String r106 = r105;
    L10:
        com.larus.bmhome.instruction.core.impl.base.c r107 = this.f311921c;
        if (r107 == null) goto L21;
        aq8.d r108 = r107.f311935a;
        if (r108 == null) goto L21;
        dq8.h r109 = r108.f15937a;
        if (r109 == null) goto L21;
        String r110 = r109.d();
        if (r110 == null) goto L21;
        if ((!StringsKt.isBlank(r110)) == false) goto L21;
        String r111 = r110;
    L22:
        com.larus.bmhome.actionbar.model.u r112 = this.f311920b;
        if (r112 == null) goto L25;
        boolean r113 = Intrinsics.areEqual(r112.f295479f, Boolean.TRUE);
    L26:
        com.larus.bmhome.instruction.core.impl.base.c r114 = this.f311921c;
        if (r114 == null) goto L33;
        aq8.d r115 = r114.f311935a;
        if (r115 == null) goto L33;
        dq8.h r116 = r115.f15937a;
        if (r116 == null) goto L33;
        String r117 = r116.getBotId();
    L34:
        com.larus.bmhome.instruction.core.impl.base.c r118 = this.f311921c;
        if (r118 == null) goto L41;
        aq8.d r119 = r118.f311935a;
        if (r119 == null) goto L41;
        dq8.h r120 = r119.f15937a;
        if (r120 == null) goto L41;
        String r121 = r120.getChatType();
    L42:
        com.larus.bmhome.instruction.core.impl.base.c r122 = this.f311921c;
        if (r122 == null) goto L49;
        aq8.d r123 = r122.f311935a;
        if (r123 == null) goto L49;
        dq8.h r124 = r123.f15937a;
        if (r124 == null) goto L49;
        String r125 = r124.getTemplateType();
    L50:
        com.larus.bmhome.instruction.core.impl.base.c r126 = this.f311921c;
        if (r126 == null) goto L59;
        aq8.d r127 = r126.f311935a;
        if (r127 == null) goto L59;
        dq8.h r128 = r127.f15937a;
        if (r128 == null) goto L59;
        Integer r129 = r128.getInstructionType();
        if (r129 == null) goto L59;
        String r130 = r129.toString();
    L60:
        com.larus.bmhome.instruction.core.impl.base.c r131 = this.f311921c;
        if (r131 == null) goto L67;
        aq8.d r132 = r131.f311935a;
        if (r132 == null) goto L67;
        dq8.h r133 = r132.f15937a;
        if (r133 == null) goto L67;
        String r134 = r133.a();
    L68:
        com.larus.bmhome.instruction.core.impl.base.c r135 = this.f311921c;
        if (r135 == null) goto L75;
        aq8.d r136 = r135.f311935a;
        if (r136 == null) goto L75;
        dq8.h r137 = r136.f15937a;
        if (r137 == null) goto L75;
        String r138 = r137.b();
    L76:
        com.larus.bmhome.instruction.core.impl.base.c r139 = this.f311921c;
        if (r139 == null) goto L83;
        aq8.d r140 = r139.f311935a;
        if (r140 == null) goto L83;
        dq8.h r141 = r140.f15937a;
        if (r141 == null) goto L83;
        Boolean r142 = r141.isCreationActionBar();
    L84:
        com.larus.bmhome.actionbar.model.u r143 = this.f311920b;
        if (r143 == null) goto L91;
        String r144 = r143.f295476c;
        if (r144 == null) goto L91;
        if ((!StringsKt.isBlank(r144)) == false) goto L91;
        String r145 = r144;
    L92:
        com.larus.bmhome.instruction.core.impl.base.c r146 = this.f311921c;
        if (r146 == null) goto L100;
        aq8.d r147 = r146.f311935a;
        if (r147 == null) goto L100;
        dq8.h r148 = r147.f15937a;
        if (r148 == null) goto L100;
        r104 = r148.c();
    L100:
        return new v0(r100, r101, r102, r106, r111, r113, new z0(r117, r121, r125, r104, r130, r134, r138, r142, r145, 2));
    L91:
        r145 = null;
    L83:
        r142 = null;
    L75:
        r138 = null;
    L67:
        r134 = null;
    L59:
        r130 = null;
    L49:
        r125 = null;
    L41:
        r121 = null;
    L33:
        r117 = null;
        goto L34
    L25:
        r113 = false;
    L21:
        r111 = null;
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        l0 r100 = this.f311979p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.h r102 = r100.f295275a;
        if (r102 == null) goto L22;
        List<w> r103 = r102.f295167e;
        if (r103 == null) goto L22;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        Integer r107 = ((w) r106).f295528s;
        if (r107 != null) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L11;
        r104.add(r106);
        goto L11
    L16:
        if (r107.intValue() != 1) goto L18;
        r108 = true;
        goto L19
    L21:
        ArrayList r110 = r104;
    L23:
        l0 r109 = this.f311979p;
        if (r109 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r111 = r109.f295275a;
        if (r111 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r112 = com.larus.bmhome.actionbar.model.h.a(r111, null, null, null, r110, null, null, 4079);
    L29:
        l0 r113 = this.f311979p;
        if (r113 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r114 = r113.f295276b;
        if (r114 == null) goto L48;
        List<w> r115 = r114.f295167e;
        if (r115 == null) goto L48;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L37:
        if (r117.hasNext() == false) goto L47;
        Object r118 = r117.next();
        Integer r119 = ((w) r118).f295528s;
        if (r119 != null) goto L42;
    L44:
        boolean r120 = false;
    L45:
        if (r120 == false) goto L37;
        r116.add(r118);
        goto L37
    L42:
        if (r119.intValue() != 1) goto L44;
        r120 = true;
        goto L45
    L47:
        ArrayList r121 = r116;
    L49:
        l0 r122 = this.f311979p;
        if (r122 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r123 = r122.f295276b;
        if (r123 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r124 = com.larus.bmhome.actionbar.model.h.a(r123, null, null, null, r121, null, null, 4079);
    L55:
        l0 r125 = this.f311979p;
        if (r125 == null) goto L74;
        com.larus.bmhome.actionbar.model.h r126 = r125.f295277c;
        if (r126 == null) goto L74;
        List<w> r127 = r126.f295167e;
        if (r127 == null) goto L74;
        ArrayList r128 = new ArrayList();
        Iterator<T> r129 = r127.iterator();
    L63:
        if (r129.hasNext() == false) goto L73;
        Object r130 = r129.next();
        Integer r131 = ((w) r130).f295528s;
        if (r131 != null) goto L68;
    L70:
        boolean r132 = false;
    L71:
        if (r132 == false) goto L63;
        r128.add(r130);
        goto L63
    L68:
        if (r131.intValue() != 1) goto L70;
        r132 = true;
        goto L71
    L73:
        ArrayList r133 = r128;
    L75:
        l0 r134 = this.f311979p;
        if (r134 == null) goto L80;
        com.larus.bmhome.actionbar.model.h r135 = r134.f295277c;
        if (r135 == null) goto L80;
        com.larus.bmhome.actionbar.model.h r136 = com.larus.bmhome.actionbar.model.h.a(r135, null, null, null, r133, null, null, 4079);
    L81:
        l0 r137 = this.f311979p;
        if (r137 == null) goto L84;
        l0 r138 = l0.d(r137, r112, r124, r136, 24);
    L95:
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L87
        Object r140 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(l0.Companion.serializer()), r138));     // Catch: Throwable -> L87
    L90:
        if (Result.m9455isFailureimpl(r140) == true) goto L94;
        r101 = r140;
    L94:
        return (String) r101;
    L87:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L90
    L84:
        r138 = null;
    L80:
        r136 = null;
    L74:
        r133 = null;
    L54:
        r124 = null;
    L48:
        r121 = null;
    L28:
        r112 = null;
    L22:
        r110 = null;
        goto L23
    }

    public static void q(com.larus.bmhome.actionbar.model.h r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r(r100) == false) goto L7;
        return;
    L7:
        List<w> r101 = r100.f295167e;
        w r102 = null;
        if (r101 == null) goto L17;
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((w) r104).f295510a, r100.f295169g) == false) goto L11;
    L16:
        w r105 = (w) r104;
    L18:
        if (r105 == null) goto L21;
        u(r100, r105.f295510a);
        return;
    L21:
        List<w> r106 = r100.f295167e;
        if (r106 == null) goto L28;
        Integer r107 = r100.f295168f;
        if (r107 == null) goto L26;
        int r108 = r107.intValue();
    L27:
        r102 = (w) CollectionsKt.getOrNull(r106, r108);
        goto L28
    L26:
        r108 = -1;
    L28:
        if (r102 == null) goto L34;
        u(r100, r102.f295510a);
        return;
    L34:
        return;
    L15:
        r104 = null;
        goto L16
    L17:
        r105 = null;
        goto L18
    }

    public static boolean r(com.larus.bmhome.actionbar.model.h r100) {
        if (r100 == null) goto L32;
        List<w> r101 = r100.f295167e;
        if (r101 == null) goto L33;
        List<w> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L23;
        Integer r104 = ((w) r103.next()).f295528s;
        if (r104 != null) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L13;
        boolean r106 = true;
    L24:
        if (r106 != true) goto L34;
        return true;
    L34:
        return false;
    L18:
        if (r104.intValue() != 1) goto L20;
        r105 = true;
    L23:
        r106 = false;
        goto L24
    L9:
        if (r102.isEmpty() == false) goto L11;
    L33:
        return false;
    L32:
        return false;
    }

    public static String v(String r100) {
        return FlowRuntime.b().h().getUserId() + '-' + r100;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof w0) == false) goto L37;
        w0 r101 = (w0) r100;
        TranslatorSelectorType r102 = r101.f464991c;
        int[] r103 = b.f311981a;
        int r104 = r103[r102.ordinal()];
        if (r104 == 1) goto L16;
        if (r104 == 2) goto L13;
        if (r104 != 3) goto L12;
        l0 r105 = this.f311979p;
        if (r105 == null) goto L19;
        com.larus.bmhome.actionbar.model.h r106 = r105.f295277c;
    L21:
        if (u(r106, Long.valueOf(r101.f464992d)) == false) goto L38;
        int r107 = r103[r101.f464991c.ordinal()];
        if (r107 == 1) goto L35;
        if (r107 == 2) goto L29;
        if (r107 != 3) goto L28;
        p(r106);
        goto L35
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        String r108 = v("selected_target_language");
        long r109 = r101.f464992d;
        if (com.flow.kmp.common.thread.a.a() == false) goto L34;
        gb6.c r110 = (gb6.c) this.f311980q.getValue();
        if (r110 == null) goto L35;
        r110.storeLong(r108, r109);
        goto L35
    L34:
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$storeLong$$inlined$runOnMainThreadIfNeed$1(null, this, r108, r109));
    L35:
        j();
        return;
    L38:
        return;
    L19:
        r106 = null;
        goto L21
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        l0 r111 = this.f311979p;
        if (r111 == null) goto L19;
        r106 = r111.f295276b;
        goto L21
    L16:
        l0 r112 = this.f311979p;
        if (r112 == null) goto L19;
        r106 = r112.f295275a;
        goto L21
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r110) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        Object r111 = Result.m9449constructorimpl((l0) xt7.d.f565073b.c(l0.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r111);
        if (r103 != null) goto L111;
        l0 r112 = (l0) r111;
        Object r104 = null;
        if (r112 == null) goto L21;
        com.larus.bmhome.actionbar.model.h r105 = r112.f295275a;
    L22:
        if (r105 == null) goto L109;
        if (r112.f295276b == null) goto L109;
        this.f311979p = r112;
        q(r112.f295275a);
        l0 r113 = this.f311979p;
        if (r113 == null) goto L29;
        com.larus.bmhome.actionbar.model.h r114 = r113.f295276b;
    L31:
        if (r(r114) == true) goto L43;
        String r106 = v("selected_target_language");
        if (com.flow.kmp.common.thread.a.a() == false) goto L39;
        gb6.c r107 = (gb6.c) this.f311980q.getValue();
        if (r107 == null) goto L37;
        long r108 = r107.getLong(r106, -1);
    L38:
        Object r109 = Long.valueOf(r108);
    L40:
        long r115 = ((Number) r109).longValue();
        if (r115 == (-1)) goto L43;
        u(r114, Long.valueOf(r115));
        goto L43
    L37:
        r108 = -1;
        goto L38
    L39:
        r109 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1(null, this, r106, -1));
    L43:
        q(r114);
        l0 r116 = this.f311979p;
        if (r116 == null) goto L46;
        com.larus.bmhome.actionbar.model.h r117 = r116.f295277c;
    L47:
        if (r117 == null) goto L49;
        List<w> r118 = r117.f295167e;
    L50:
        List<w> r119 = r118;
        if (r119 != null) goto L53;
    L56:
        boolean r120 = true;
    L58:
        if (r120 == false) goto L61;
        t(v("selected_translator_mode"), "-1");
    L107:
        return new wa8.a0(Boolean.TRUE, "");
    L61:
        if (r(r117) == false) goto L114;
        p(r117);
        goto L107
    L114:
        Object r121 = FlowRuntime.b().b().e("simultaneous_interpretation_client_configs", new d0(MapsKt.emptyMap()), false).get("enabled_simultaneous_interpretation_record_status");     // Catch: Throwable -> L81
        if ((r121 instanceof g0) == false) goto L66;
        g0 r122 = (g0) r121;     // Catch: Throwable -> L81
    L67:
        if (r122 == null) goto L71;
        Boolean r123 = ouc.k.f(r122);     // Catch: Throwable -> L81
        if (r123 == null) goto L71;
        boolean r124 = r123.booleanValue();     // Catch: Throwable -> L81
    L79:
        Object r125 = Result.m9449constructorimpl(Boolean.valueOf(r124));     // Catch: Throwable -> L81
    L83:
        Boolean r126 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r125) == false) goto L87;
        r125 = r126;
    L87:
        if (((Boolean) r125).booleanValue() == true) goto L89;
        s(r117, "1");
        t(v("selected_translator_mode"), "1");
        goto L107
    L89:
        String r127 = v("selected_translator_mode");
        if (com.flow.kmp.common.thread.a.a() == false) goto L94;
        gb6.c r128 = (gb6.c) this.f311980q.getValue();
        if (r128 == null) goto L95;
        r104 = r128.getString(r127, "1");
    L95:
        String r129 = (String) r104;
        if (r129 != null) goto L98;
    L101:
        if (r100 == false) goto L103;
    L105:
        q(r117);
        p(r117);
        goto L107
    L103:
        if (Intrinsics.areEqual(r129, "1") == true) goto L105;
        s(r117, r129);
        goto L105
    L98:
        if (r129.length() == 0) goto L101;
        r100 = false;
        goto L101
    L94:
        r104 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$getString$$inlined$runOnMainThreadIfNeed$1(null, this, r127, "1"));
    L71:
        if (r122 == null) goto L75;
        String r130 = ouc.k.g(r122);     // Catch: Throwable -> L81
        if (r130 == null) goto L75;
        Boolean r131 = StringsKt.toBooleanStrictOrNull(r130);     // Catch: Throwable -> L81
    L76:
        if (r131 == null) goto L78;
        r124 = r131.booleanValue();     // Catch: Throwable -> L81
        goto L79
    L78:
        r124 = false;
    L75:
        r131 = null;
        goto L76
    L66:
        r122 = null;
    L81:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L83
    L53:
        if (r119.isEmpty() == true) goto L56;
        r120 = false;
        goto L58
    L49:
        r118 = null;
        goto L50
    L46:
        r117 = null;
        goto L47
    L29:
        r114 = null;
    L109:
        return new wa8.a0(Boolean.FALSE, "translator source or target is null");
    L21:
        r105 = null;
        goto L22
    L111:
        return new wa8.a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "translator is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void p(com.larus.bmhome.actionbar.model.h r100) {
        if (r100 == null) goto L25;
        List<w> r101 = r100.f295167e;
        if (r101 == null) goto L25;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        Integer r104 = ((w) r103).f295528s;
        if (r104 == null) goto L14;
        boolean r105 = true;
        if (r104.intValue() != 1) goto L14;
    L15:
        if (r105 == false) goto L7;
    L18:
        w r106 = (w) r103;
        if (r106 == null) goto L25;
        Map<String, String> r107 = r106.f295526q;
        if (r107 == null) goto L25;
        String r108 = r107.get("speaker_mode");
        if (r108 == null) goto L25;
    L26:
        t(v("selected_translator_mode"), r108);
        return;
    L14:
        r105 = false;
        goto L15
    L17:
        r103 = null;
    L25:
        r108 = "1";
        goto L26
    }

    public static void s(com.larus.bmhome.actionbar.model.h r100, String r101) {
        if (r100 == null) goto L32;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L33;
        List<w> r103 = r100.f295167e;
        Long r104 = null;
        if (r103 == null) goto L27;
        Iterator<T> r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        Map<String, String> r107 = ((w) r106).f295526q;
        if (r107 == null) goto L19;
        String r108 = r107.get("speaker_mode");
    L21:
        if (Intrinsics.areEqual(r108, r101) == false) goto L15;
    L24:
        w r109 = (w) r106;
        if (r109 == null) goto L27;
        r104 = r109.f295510a;
        goto L27
    L19:
        r108 = null;
        goto L21
    L23:
        r106 = null;
    L27:
        u(r100, r104);
        return;
    L33:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean u(com.larus.bmhome.actionbar.model.h r100, Long r101) {
        if (r100 == null) goto L32;
        if (r101 == null) goto L32;
        List<w> r102 = r100.f295167e;
        if (r102 != null) goto L9;
        return false;
    L9:
        List<w> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((w) r104.next()).f295510a, r101) == false) goto L16;
        boolean r105 = false;
    L21:
        if (r105 == false) goto L23;
        return false;
    L23:
        Iterator<T> r106 = r103.iterator();
    L25:
        if (r106.hasNext() == false) goto L31;
        w r107 = (w) r106.next();
        if (Intrinsics.areEqual(r107.f295510a, r101) == false) goto L29;
        int r108 = 1;
    L30:
        r107.f295528s = r108;
        goto L25
    L29:
        r108 = 0;
        goto L30
    L31:
        return true;
    L20:
        r105 = true;
        goto L21
    L12:
        if (r103.isEmpty() == false) goto L14;
    L32:
        return false;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((l0) xt7.d.f565073b.c(l0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L7:
        com.larus.bmhome.actionbar.model.h r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        l0 r105 = (l0) r103;
        if (r105 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.h r106 = r105.f295275a;
        if (r106 == null) goto L33;
        List<w> r107 = r106.f295167e;
        if (r107 == null) goto L33;
        w r108 = (w) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L33;
        l0 r109 = this.f311979p;
        if (r109 == null) goto L33;
        com.larus.bmhome.actionbar.model.h r110 = r109.f295275a;
        if (r110 == null) goto L33;
        List<w> r111 = r110.f295167e;
        if (r111 == null) goto L33;
        Iterator<T> r112 = r111.iterator();
    L27:
        if (r112.hasNext() == false) goto L33;
        w r113 = (w) r112.next();
        if (Intrinsics.areEqual(r113.f295510a, r108.f295510a) == false) goto L31;
        int r114 = 1;
    L32:
        r113.f295528s = r114;
        goto L27
    L31:
        r114 = 0;
    L33:
        com.larus.bmhome.actionbar.model.h r115 = r105.f295276b;
        if (r115 == null) goto L53;
        List<w> r116 = r115.f295167e;
        if (r116 == null) goto L53;
        w r117 = (w) CollectionsKt.firstOrNull(r116);
        if (r117 == null) goto L53;
        l0 r118 = this.f311979p;
        if (r118 == null) goto L53;
        com.larus.bmhome.actionbar.model.h r119 = r118.f295276b;
        if (r119 == null) goto L53;
        List<w> r120 = r119.f295167e;
        if (r120 == null) goto L53;
        Iterator<T> r121 = r120.iterator();
    L47:
        if (r121.hasNext() == false) goto L53;
        w r122 = (w) r121.next();
        if (Intrinsics.areEqual(r122.f295510a, r117.f295510a) == false) goto L51;
        int r123 = 1;
    L52:
        r122.f295528s = r123;
        goto L47
    L51:
        r123 = 0;
    L53:
        com.larus.bmhome.actionbar.model.h r124 = r105.f295277c;
        if (r124 == null) goto L89;
        List<w> r125 = r124.f295167e;
        if (r125 == null) goto L90;
        w r126 = (w) CollectionsKt.firstOrNull(r125);
        if (r126 == null) goto L91;
        l0 r127 = this.f311979p;
        if (r127 == null) goto L73;
        com.larus.bmhome.actionbar.model.h r128 = r127.f295277c;
        if (r128 == null) goto L73;
        List<w> r129 = r128.f295167e;
        if (r129 == null) goto L73;
        Iterator<T> r130 = r129.iterator();
    L67:
        if (r130.hasNext() == false) goto L73;
        w r131 = (w) r130.next();
        if (Intrinsics.areEqual(r131.f295510a, r126.f295510a) == false) goto L71;
        int r132 = 1;
    L72:
        r131.f295528s = r132;
        goto L67
    L71:
        r132 = 0;
    L73:
        l0 r133 = this.f311979p;
        if (r133 == null) goto L76;
        r104 = r133.f295277c;
    L76:
        p(r104);
        return;
    L91:
        return;
    L90:
        return;
    L89:
        return;
    L5:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void t(String r100, String r101) {
        if (com.flow.kmp.common.thread.a.a() == false) goto L7;
        gb6.c r102 = (gb6.c) this.f311980q.getValue();
        if (r102 == null) goto L9;
        r102.storeString(r100, r101);
        return;
    L9:
        return;
    L7:
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new TranslatorController$storeString$$inlined$runOnMainThreadIfNeed$1(null, this, r100, r101));
    }
}
