package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class DropdownSelectorController extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f311975p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.h f311976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f311977r;

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
        return 2;
    }

    public DropdownSelectorController() {
        super("DropdownSelectorController");
        this.f311975p = LazyKt.lazy(new g());
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        com.larus.bmhome.actionbar.model.h r100 = this.f311976q;
        String r101 = null;
        if (r100 == null) goto L22;
        List<w> r102 = r100.f295167e;
        if (r102 == null) goto L22;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        Integer r105 = ((w) r104).f295528s;
        if (r105 != null) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L8;
    L19:
        w r107 = (w) r104;
        if (r107 == null) goto L22;
        Long r108 = r107.f295510a;
    L23:
        String r109 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r110 = this.f311933o;
        com.larus.bmhome.actionbar.model.h r111 = this.f311976q;
        int r112 = this.f311977r;
        com.larus.bmhome.instruction.core.impl.base.c r113 = this.f311921c;
        if (r113 == null) goto L30;
        aq8.d r114 = r113.f311935a;
        if (r114 == null) goto L30;
        dq8.h r115 = r114.f15937a;
        if (r115 == null) goto L30;
        String r116 = r115.getBotId();
    L31:
        com.larus.bmhome.instruction.core.impl.base.c r117 = this.f311921c;
        if (r117 == null) goto L38;
        aq8.d r118 = r117.f311935a;
        if (r118 == null) goto L38;
        dq8.h r119 = r118.f15937a;
        if (r119 == null) goto L38;
        String r120 = r119.getChatType();
    L39:
        com.larus.bmhome.instruction.core.impl.base.c r121 = this.f311921c;
        if (r121 == null) goto L46;
        aq8.d r122 = r121.f311935a;
        if (r122 == null) goto L46;
        dq8.h r123 = r122.f15937a;
        if (r123 == null) goto L46;
        String r124 = r123.getTemplateType();
    L47:
        com.larus.bmhome.instruction.core.impl.base.c r125 = this.f311921c;
        if (r125 == null) goto L56;
        aq8.d r126 = r125.f311935a;
        if (r126 == null) goto L56;
        dq8.h r127 = r126.f15937a;
        if (r127 == null) goto L56;
        Integer r128 = r127.getInstructionType();
        if (r128 == null) goto L56;
        String r129 = r128.toString();
    L57:
        com.larus.bmhome.instruction.core.impl.base.c r130 = this.f311921c;
        if (r130 == null) goto L64;
        aq8.d r131 = r130.f311935a;
        if (r131 == null) goto L64;
        dq8.h r132 = r131.f15937a;
        if (r132 == null) goto L64;
        String r133 = r132.a();
    L65:
        com.larus.bmhome.instruction.core.impl.base.c r134 = this.f311921c;
        if (r134 == null) goto L72;
        aq8.d r135 = r134.f311935a;
        if (r135 == null) goto L72;
        dq8.h r136 = r135.f15937a;
        if (r136 == null) goto L72;
        String r137 = r136.b();
    L73:
        com.larus.bmhome.instruction.core.impl.base.c r138 = this.f311921c;
        if (r138 == null) goto L80;
        aq8.d r139 = r138.f311935a;
        if (r139 == null) goto L80;
        dq8.h r140 = r139.f15937a;
        if (r140 == null) goto L80;
        Boolean r141 = r140.isCreationActionBar();
    L81:
        com.larus.bmhome.actionbar.model.u r142 = this.f311920b;
        if (r142 == null) goto L88;
        String r143 = r142.f295476c;
        if (r143 == null) goto L88;
        if ((true ^ StringsKt.isBlank(r143)) == false) goto L88;
        String r144 = r143;
    L89:
        com.larus.bmhome.instruction.core.impl.base.c r145 = this.f311921c;
        if (r145 == null) goto L97;
        aq8.d r146 = r145.f311935a;
        if (r146 == null) goto L97;
        dq8.h r147 = r146.f15937a;
        if (r147 == null) goto L97;
        r101 = r147.c();
    L97:
        return new cq8.o(r109, r110, r111, r112, r108, new z0(r116, r120, r124, r101, r129, r133, r137, r141, r144, 2));
    L88:
        r144 = null;
    L80:
        r141 = null;
    L72:
        r137 = null;
    L64:
        r133 = null;
    L56:
        r129 = null;
    L46:
        r124 = null;
    L38:
        r120 = null;
    L30:
        r116 = null;
        goto L31
    L13:
        if (r105.intValue() != 1) goto L15;
        r106 = true;
        goto L16
    L18:
        r104 = null;
    L22:
        r108 = null;
        goto L23
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.h r100 = this.f311976q;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295167e;
        if (r102 == null) goto L20;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        Integer r106 = ((w) r105).f295528s;
        if (r106 == null) goto L16;
        boolean r107 = true;
        if (r106.intValue() != 1) goto L16;
    L17:
        if (r107 == false) goto L9;
        r103.add(r105);
    L16:
        r107 = false;
        goto L17
    L19:
        ArrayList r110 = r103;
    L21:
        com.larus.bmhome.actionbar.model.h r108 = this.f311976q;
        if (r108 == null) goto L24;
        com.larus.bmhome.actionbar.model.h r109 = com.larus.bmhome.actionbar.model.h.a(r108, null, null, null, r110, null, null, 4079);
    L35:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r109));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r112) == true) goto L34;
        r101 = r112;
    L34:
        return (String) r101;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L24:
        r109 = null;
        goto L35
    L20:
        r110 = null;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
    public final void p() {
        com.larus.bmhome.instruction.core.impl.base.c r100 = this.f311921c;
        Boolean r101 = null;
        if (r100 == null) goto L9;
        aq8.d r102 = r100.f311935a;
        if (r102 == null) goto L9;
        dq8.h r103 = r102.f15937a;
        if (r103 == null) goto L9;
        Integer r104 = r103.getInstructionType();
    L10:
        boolean r105 = false;
        if (r104 != null) goto L14;
    L15:
        if (r104 != null) goto L18;
    L20:
        if (r104 != null) goto L23;
    L24:
        if (r104 != null) goto L27;
    L44:
        boolean r106 = false;
    L45:
        if (r106 == false) goto L57;
        com.larus.bmhome.actionbar.model.h r107 = this.f311976q;
        if (r107 == null) goto L54;
        List<w> r108 = r107.f295167e;
        if (r108 == null) goto L54;
        List<w> r109 = r108;
        List r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L52:
        if (r111.hasNext() == false) goto L55;
        r110.add(w.a((w) r111.next(), null, null, null, null, null, null, 8388607));
    L55:
        if (r110 != 0) goto L59;
        r110 = CollectionsKt.emptyList();
    L59:
        if (this.f311977r != 4) goto L85;
        com.larus.bmhome.actionbar.model.h r112 = this.f311976q;
        if (r112 == null) goto L84;
        List<w> r113 = r112.f295167e;
        if (r113 == null) goto L84;
        List<w> r114 = r113;
        if ((r114 instanceof Collection) == true) goto L67;
    L69:
        Iterator<T> r115 = r114.iterator();
    L71:
        if (r115.hasNext() == false) goto L81;
        Integer r116 = ((w) r115.next()).f295528s;
        if (r116 != null) goto L76;
    L78:
        boolean r117 = false;
    L79:
        if (r117 == false) goto L71;
        boolean r118 = true;
    L82:
        if (r118 != true) goto L84;
        r105 = true;
        goto L84
    L76:
        if (r116.intValue() != 1) goto L78;
        r117 = true;
    L81:
        r118 = false;
        goto L82
    L67:
        if (r114.isEmpty() == false) goto L69;
    L84:
        r101 = Boolean.valueOf(r105);
    L85:
        if (r110 == 0) goto L87;
        o(new com.larus.bmhome.instruction.core.impl.base.k.o(r110));
    L87:
        if (r101 == null) goto L96;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(r101.booleanValue()));
        return;
    L96:
        return;
    L54:
        r110 = 0;
        goto L55
    L57:
        r110 = 0;
        goto L59
    L27:
        if (r104.intValue() != 24) goto L44;
    L28:
        com.larus.bmhome.actionbar.model.h r119 = this.f311976q;
        if (r119 == null) goto L44;
        Integer r120 = r119.f295164b;
        if (r120 == null) goto L44;
        if (r120.intValue() != 1) goto L44;
    L43:
        r106 = true;
        goto L45
    L23:
        if (r104.intValue() == 18) goto L28;
    L18:
        if (r104.intValue() != 4) goto L20;
    L36:
        com.larus.bmhome.actionbar.model.h r121 = this.f311976q;
        if (r121 == null) goto L44;
        Integer r122 = r121.f295164b;
        if (r122 == null) goto L44;
        if (r122.intValue() != 2) goto L44;
    L14:
        if (r104.intValue() == 16) goto L36;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L5:
        this.f311977r = r101;
        return;
    L4:
        r101 = 0;
        goto L5
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        com.larus.bmhome.actionbar.model.h r101 = this.f311976q;
        if (r101 == null) goto L7;
        Integer r102 = r101.f295164b;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        Object r104 = r100.get(String.valueOf(getType()));
        if ((r104 instanceof Map) == false) goto L11;
        Map r105 = (Map) r104;
    L12:
        if (r105 == null) goto L15;
        Object r106 = r105.get(r103);
        if (r106 == null) goto L15;
    L19:
        if ((r106 instanceof Map) == false) goto L21;
        Map r107 = (Map) r106;
    L22:
        if (r107 == null) goto L73;
        Object r108 = r107.get("default_select_id");
        if (r108 == null) goto L74;
        com.larus.bmhome.actionbar.model.h r109 = this.f311976q;
        if (r109 == null) goto L41;
        List<w> r110 = r109.f295167e;
        if (r110 == null) goto L41;
        Iterator<T> r111 = r110.iterator();
    L31:
        if (r111.hasNext() == false) goto L39;
        Object r112 = r111.next();
        Long r113 = ((w) r112).f295510a;
        if (r113 == null) goto L35;
        String r114 = r113.toString();
    L37:
        if (Intrinsics.areEqual(r114, r108.toString()) == false) goto L31;
    L40:
        w r115 = (w) r112;
    L42:
        if (r115 == null) goto L75;
        com.larus.bmhome.actionbar.model.h r116 = this.f311976q;
        if (r116 == null) goto L64;
        List<w> r117 = r116.f295167e;
        if (r117 == null) goto L64;
        Iterator<T> r118 = r117.iterator();
        int r119 = 0;
    L49:
        if (r118.hasNext() == false) goto L64;
        Object r120 = r118.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        w r122 = (w) r120;
        Long r123 = r122.f295510a;
        if (r123 == null) goto L56;
        String r124 = r123.toString();
    L58:
        if (Intrinsics.areEqual(r124, r108.toString()) == false) goto L62;
        r122.f295528s = 1;
        com.larus.bmhome.actionbar.model.h r125 = this.f311976q;
        if (r125 == null) goto L63;
        r125.f295168f = Integer.valueOf(r119);
    L63:
        r119 = r121;
        goto L49
    L62:
        r122.f295528s = 0;
        goto L63
    L56:
        r124 = null;
    L64:
        p();
        return;
    L75:
        return;
    L35:
        r114 = null;
        goto L37
    L39:
        r112 = null;
    L41:
        r115 = null;
        goto L42
    L74:
        return;
    L73:
        return;
    L21:
        r107 = null;
    L15:
        if (r105 == null) goto L17;
        r106 = r105.get("match_all_id");
        goto L19
    L17:
        r106 = null;
        goto L19
    L11:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        c0.f348199b.i("DropdownSelectorController", "[handleAction] action:" + r100.f465003a + ", widgetId:" + r100.a());
        if ((r100 instanceof cq8.n) == false) goto L44;
        long r101 = ((cq8.n) r100).f464903c;
        com.larus.bmhome.actionbar.model.h r102 = this.f311976q;
        boolean r103 = false;
        if (r102 == null) goto L19;
        List<w> r104 = r102.f295167e;
        if (r104 == null) goto L19;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L19;
        w r106 = (w) r105.next();
        Long r107 = r106.f295510a;
        if (r107 != null) goto L15;
    L17:
        int r108 = 0;
    L18:
        r106.f295528s = r108;
        goto L10
    L15:
        if (r107.longValue() != r101) goto L17;
        r108 = 1;
    L19:
        Integer r109 = null;
        if (com.flow.kmp.common.thread.a.a() == false) goto L38;
        com.larus.bmhome.actionbar.model.h r110 = this.f311976q;
        if (r110 == null) goto L24;
        r103 = Intrinsics.areEqual(r110.f295171i, Boolean.TRUE);
    L24:
        if (r103 == true) goto L26;
    L39:
        p();
        j();
        return;
    L26:
        if (this.f311977r != 4) goto L31;
        StringBuilder r111 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r112 = this.f311976q;
        if (r112 == null) goto L30;
        r109 = r112.f295164b;
    L30:
        r111.append(r109);
        String r113 = r111.toString();
    L35:
        gb6.c r114 = (gb6.c) this.f311975p.getValue();
        if (r114 == null) goto L39;
        r114.storeLong(r113, r101);
        goto L39
    L31:
        StringBuilder r115 = new StringBuilder("dropbox_");
        r115.append(this.f311977r);
        r115.append('_');
        com.larus.bmhome.actionbar.model.h r116 = this.f311976q;
        if (r116 == null) goto L34;
        r109 = r116.f295164b;
    L34:
        r115.append(r109);
        r113 = r115.toString();
        goto L35
    L38:
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownSelectorController$handleAction$$inlined$runOnMainThreadIfNeed$1(null, this, r101));
        goto L39
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
        Object r111 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r111);
        if (r103 != null) goto L143;
        com.larus.bmhome.actionbar.model.h r112 = (com.larus.bmhome.actionbar.model.h) r111;
        List<w> r104 = r112.f295167e;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == true) goto L27;
        this.f311976q = r112;
        List<w> r113 = r112.f295167e;
        w r106 = null;
        if (r113 == null) goto L44;
        Iterator<T> r114 = r113.iterator();
    L32:
        if (r114.hasNext() == false) goto L42;
        Object r107 = r114.next();
        Integer r108 = ((w) r107).f295528s;
        if (r108 != null) goto L37;
    L39:
        boolean r109 = false;
    L40:
        if (r109 == false) goto L32;
    L43:
        w r115 = (w) r107;
    L46:
        if (r115 == null) goto L48;
        Long r116 = -1L;
    L75:
        if (r116 != null) goto L78;
    L79:
        com.larus.bmhome.actionbar.model.h r117 = this.f311976q;
        if (r117 == null) goto L93;
        List<w> r118 = r117.f295167e;
        if (r118 == null) goto L93;
        Iterator<T> r119 = r118.iterator();
    L85:
        if (r119.hasNext() == false) goto L89;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((w) r120).f295510a, r116) == false) goto L85;
    L90:
        w r121 = (w) r120;
        if (r121 == null) goto L93;
        r121.f295528s = 1;
    L94:
        if (r121 != null) goto L119;
        if (r115 != null) goto L119;
        com.larus.bmhome.actionbar.model.h r122 = this.f311976q;
        if (r122 == null) goto L99;
        boolean r123 = Intrinsics.areEqual(r122.f295170h, Boolean.TRUE);
    L100:
        if (r123 == true) goto L119;
        com.larus.bmhome.actionbar.model.h r124 = this.f311976q;
        if (r124 == null) goto L119;
        List<w> r125 = r124.f295167e;
        if (r125 == null) goto L119;
        Iterator<T> r126 = r125.iterator();
    L107:
        if (r126.hasNext() == false) goto L115;
        Object r127 = r126.next();
        Long r128 = ((w) r127).f295510a;
        com.larus.bmhome.actionbar.model.h r129 = this.f311976q;
        if (r129 == null) goto L111;
        Long r130 = r129.f295169g;
    L113:
        if (Intrinsics.areEqual(r128, r130) == false) goto L107;
    L116:
        w r131 = (w) r127;
        if (r131 == null) goto L119;
        r131.f295528s = 1;
        r106 = r131;
        goto L119
    L111:
        r130 = null;
        goto L113
    L115:
        r127 = null;
        goto L116
    L99:
        r123 = false;
    L119:
        if (r106 != null) goto L140;
        if (r121 != null) goto L140;
        if (r115 != null) goto L140;
        com.larus.bmhome.actionbar.model.h r132 = this.f311976q;
        if (r132 == null) goto L125;
        r100 = Intrinsics.areEqual(r132.f295170h, Boolean.TRUE);
    L125:
        if (r100 == true) goto L131;
        com.larus.bmhome.actionbar.model.h r133 = this.f311976q;
        if (r133 == null) goto L131;
        Integer r134 = r133.f295168f;
        if (r134 == null) goto L131;
        int r135 = r134.intValue();
    L132:
        if (r135 < 0) goto L140;
        com.larus.bmhome.actionbar.model.h r136 = this.f311976q;
        if (r136 == null) goto L140;
        List<w> r137 = r136.f295167e;
        if (r137 == null) goto L140;
        w r138 = (w) CollectionsKt.getOrNull(r137, r135);
        if (r138 == null) goto L140;
        r138.f295528s = 1;
    L131:
        r135 = -1;
    L140:
        p();
        return new wa8.a0(Boolean.TRUE, "");
    L89:
        r120 = null;
    L93:
        r121 = null;
        goto L94
    L78:
        if (r116.longValue() == (-1)) goto L93;
    L48:
        com.larus.bmhome.actionbar.model.h r139 = this.f311976q;
        if (r139 == null) goto L51;
        boolean r140 = Intrinsics.areEqual(r139.f295171i, Boolean.TRUE);
    L52:
        if (r140 == true) goto L54;
        r116 = -1L;
        goto L75
    L54:
        if (com.flow.kmp.common.thread.a.a() == true) goto L56;
        Object r141 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownSelectorController$parseTemplate$$inlined$runOnMainThreadIfNeed$1(null, this));
    L73:
        r116 = (Long) r141;
        goto L75
    L56:
        if (this.f311977r != 4) goto L64;
        gb6.c r142 = (gb6.c) this.f311975p.getValue();
        if (r142 == null) goto L71;
        StringBuilder r143 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r144 = this.f311976q;
        if (r144 == null) goto L62;
        Integer r145 = r144.f295164b;
    L63:
        r143.append(r145);
        r141 = Long.valueOf(r142.getLong(r143.toString(), -1));
        goto L73
    L62:
        r145 = null;
    L71:
        r141 = null;
        goto L73
    L64:
        gb6.c r146 = (gb6.c) this.f311975p.getValue();
        if (r146 == null) goto L71;
        StringBuilder r147 = new StringBuilder("dropbox_");
        r147.append(this.f311977r);
        r147.append('_');
        com.larus.bmhome.actionbar.model.h r148 = this.f311976q;
        if (r148 == null) goto L69;
        Integer r149 = r148.f295164b;
    L70:
        r147.append(r149);
        r141 = Long.valueOf(r146.getLong(r147.toString(), -1));
        goto L73
    L69:
        r149 = null;
        goto L70
    L51:
        r140 = false;
        goto L52
    L37:
        if (r108.intValue() != 1) goto L39;
        r109 = true;
        goto L40
    L42:
        r107 = null;
        goto L43
    L44:
        r115 = null;
        goto L46
    L27:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L21:
        if (r104.isEmpty() == true) goto L24;
        r105 = false;
        goto L25
    L143:
        return new wa8.a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        if ((r210 instanceof com.larus.bmhome.instruction.core.impl.base.j) == true) goto L5;
        return;
    L5:
        com.larus.bmhome.instruction.core.impl.base.c r100 = this.f311921c;
        if (r100 == null) goto L17;
        aq8.d r101 = r100.f311935a;
        if (r101 == null) goto L17;
        dq8.h r102 = r101.f15937a;
        if (r102 == null) goto L17;
        Integer r103 = r102.getInstructionType();
        if (r103 == null) goto L17;
        if (r103.intValue() != 1) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        return;
    L20:
        bq8.d r105 = ((com.larus.bmhome.instruction.core.impl.base.j) r210).f311944c.b();
        com.larus.bmhome.actionbar.model.h r106 = this.f311976q;
        if (r106 == null) goto L96;
        Integer r107 = r106.f295164b;
        if (r107 == null) goto L97;
        int r108 = r107.intValue();
        com.larus.bmhome.actionbar.model.h r109 = null;
        if (r108 != 1) goto L27;
        bq8.e r110 = r105.f20081c;
        if (r110 == null) goto L35;
        Long r111 = Long.valueOf(r110.f20084a);
    L36:
        if (r111 != null) goto L38;
        return;
    L38:
        if (r111.longValue() == 0) goto L40;
        boolean r112 = true;
    L41:
        if (r112 == true) goto L44;
        r111 = null;
    L44:
        if (r111 == null) goto L99;
        long r113 = r111.longValue();
        com.larus.bmhome.actionbar.model.h r114 = this.f311976q;
        if (r114 == null) goto L100;
        List<w> r115 = r114.f295167e;
        if (r115 == null) goto L101;
        List<w> r116 = r115;
        if ((r116 instanceof Collection) == true) goto L53;
    L55:
        Iterator<T> r117 = r116.iterator();
    L57:
        if (r117.hasNext() == false) goto L67;
        Long r118 = ((w) r117.next()).f295510a;
        if (r118 != null) goto L62;
    L64:
        boolean r119 = false;
    L65:
        if (r119 == false) goto L57;
        boolean r120 = false;
    L69:
        if (r120 == false) goto L72;
        c0.f348199b.w("DropdownSelectorController", "[onEvent] music template option not found, dropdownId=" + r108 + ", selectedOptionId=" + r113);
        return;
    L72:
        c0.f348199b.i("DropdownSelectorController", "[onEvent] music template fill, dropdownId=" + r108 + ", selectedOptionId=" + r113);
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r122 = r116.iterator();
    L74:
        if (r122.hasNext() == false) goto L83;
        w r123 = (w) r122.next();
        Long r124 = r123.f295510a;
        if (r124 != null) goto L79;
    L81:
        int r125 = 0;
    L82:
        r121.add(w.a(r123, null, null, Integer.valueOf(r125), null, null, null, 8126463));
        goto L74
    L79:
        if (r124.longValue() != r113) goto L81;
        r125 = 1;
        goto L82
    L83:
        com.larus.bmhome.actionbar.model.h r126 = this.f311976q;
        if (r126 == null) goto L86;
        r109 = com.larus.bmhome.actionbar.model.h.a(r126, null, null, null, r121, null, null, 4079);
    L86:
        this.f311976q = r109;
        p();
        j();
        return;
    L62:
        if (r118.longValue() != r113) goto L64;
        r119 = true;
    L67:
        r120 = true;
        goto L69
    L53:
        if (r116.isEmpty() == false) goto L55;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L40:
        r112 = false;
    L35:
        r111 = null;
        goto L36
    L27:
        if (r108 != 2) goto L35;
        bq8.e r127 = r105.f20080b;
        if (r127 == null) goto L35;
        r111 = Long.valueOf(r127.f20084a);
        goto L36
    L97:
        return;
    L96:
        return;
    L17:
        r104 = false;
        goto L18
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L7:
        Object r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r105 = (com.larus.bmhome.actionbar.model.h) r103;
        if (r105 != null) goto L13;
        return;
    L13:
        List<w> r106 = r105.f295167e;
        if (r106 == null) goto L18;
        w r107 = (w) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L18;
        Long r108 = r107.f295510a;
    L19:
        if (r108 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r109 = this.f311976q;
        if (r109 == null) goto L31;
        List<w> r110 = r109.f295167e;
        if (r110 == null) goto L31;
        Iterator<T> r111 = r110.iterator();
    L26:
        if (r111.hasNext() == false) goto L30;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((w) r112).f295510a, r108) == false) goto L26;
        r104 = r112;
    L30:
        r104 = (w) r104;
    L31:
        if (r104 == null) goto L55;
        com.larus.bmhome.actionbar.model.h r113 = this.f311976q;
        if (r113 == null) goto L44;
        List<w> r114 = r113.f295167e;
        if (r114 == null) goto L44;
        Iterator<T> r115 = r114.iterator();
    L38:
        if (r115.hasNext() == false) goto L44;
        w r116 = (w) r115.next();
        if (Intrinsics.areEqual(r116.f295510a, r108) == false) goto L42;
        int r117 = 1;
    L43:
        r116.f295528s = r117;
        goto L38
    L42:
        r117 = 0;
    L44:
        p();
        return;
    L55:
        return;
    L54:
        return;
    L18:
        r108 = null;
    L5:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
