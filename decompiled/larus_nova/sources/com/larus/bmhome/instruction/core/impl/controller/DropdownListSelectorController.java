package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.f1;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public final class DropdownListSelectorController extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f311971p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.i f311972q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<com.larus.bmhome.actionbar.model.h> f311973r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f311974s;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 2;
    }

    public DropdownListSelectorController() {
        super("DropdownListSelectorController");
        this.f311971p = LazyKt.lazy(new f());
        this.f311973r = new ArrayList();
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r100 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r101 = this.f311933o;
        com.larus.bmhome.actionbar.model.i r102 = this.f311972q;
        List<com.larus.bmhome.actionbar.model.h> r103 = this.f311973r;
        com.larus.bmhome.actionbar.model.u r104 = this.f311920b;
        String r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.f295476c;
        if (r106 == null) goto L9;
        if ((!StringsKt.isBlank(r106)) == false) goto L9;
        String r107 = r106;
    L10:
        com.larus.bmhome.actionbar.model.u r108 = this.f311920b;
        if (r108 == null) goto L13;
        Integer r109 = r108.f295481h;
    L14:
        if (r108 == null) goto L16;
        boolean r110 = Intrinsics.areEqual(r108.f295479f, Boolean.TRUE);
    L17:
        com.larus.bmhome.instruction.core.impl.base.c r111 = this.f311921c;
        if (r111 == null) goto L24;
        aq8.d r112 = r111.f311935a;
        if (r112 == null) goto L24;
        dq8.h r113 = r112.f15937a;
        if (r113 == null) goto L24;
        String r114 = r113.getBotId();
    L25:
        com.larus.bmhome.instruction.core.impl.base.c r115 = this.f311921c;
        if (r115 == null) goto L32;
        aq8.d r116 = r115.f311935a;
        if (r116 == null) goto L32;
        dq8.h r117 = r116.f15937a;
        if (r117 == null) goto L32;
        String r118 = r117.getChatType();
    L33:
        com.larus.bmhome.instruction.core.impl.base.c r119 = this.f311921c;
        if (r119 == null) goto L40;
        aq8.d r120 = r119.f311935a;
        if (r120 == null) goto L40;
        dq8.h r121 = r120.f15937a;
        if (r121 == null) goto L40;
        String r122 = r121.getTemplateType();
    L41:
        com.larus.bmhome.instruction.core.impl.base.c r123 = this.f311921c;
        if (r123 == null) goto L50;
        aq8.d r124 = r123.f311935a;
        if (r124 == null) goto L50;
        dq8.h r125 = r124.f15937a;
        if (r125 == null) goto L50;
        Integer r126 = r125.getInstructionType();
        if (r126 == null) goto L50;
        String r127 = r126.toString();
    L51:
        com.larus.bmhome.instruction.core.impl.base.c r128 = this.f311921c;
        if (r128 == null) goto L58;
        aq8.d r129 = r128.f311935a;
        if (r129 == null) goto L58;
        dq8.h r130 = r129.f15937a;
        if (r130 == null) goto L58;
        String r131 = r130.a();
    L59:
        com.larus.bmhome.instruction.core.impl.base.c r132 = this.f311921c;
        if (r132 == null) goto L66;
        aq8.d r133 = r132.f311935a;
        if (r133 == null) goto L66;
        dq8.h r134 = r133.f15937a;
        if (r134 == null) goto L66;
        String r135 = r134.b();
    L67:
        com.larus.bmhome.instruction.core.impl.base.c r136 = this.f311921c;
        if (r136 == null) goto L74;
        aq8.d r137 = r136.f311935a;
        if (r137 == null) goto L74;
        dq8.h r138 = r137.f15937a;
        if (r138 == null) goto L74;
        Boolean r139 = r138.isCreationActionBar();
    L75:
        com.larus.bmhome.actionbar.model.u r140 = this.f311920b;
        if (r140 == null) goto L82;
        String r141 = r140.f295476c;
        if (r141 == null) goto L82;
        if ((!StringsKt.isBlank(r141)) == false) goto L82;
        String r142 = r141;
    L83:
        com.larus.bmhome.instruction.core.impl.base.c r143 = this.f311921c;
        if (r143 == null) goto L91;
        aq8.d r144 = r143.f311935a;
        if (r144 == null) goto L91;
        dq8.h r145 = r144.f15937a;
        if (r145 == null) goto L91;
        r105 = r145.c();
    L91:
        return new cq8.m(r100, r101, r102, r103, r109, r107, r110, new z0(r114, r118, r122, r105, r127, r131, r135, r139, r142, 2), this.f311974s);
    L82:
        r142 = null;
    L74:
        r139 = null;
    L66:
        r135 = null;
    L58:
        r131 = null;
    L50:
        r127 = null;
    L40:
        r122 = null;
    L32:
        r118 = null;
    L24:
        r114 = null;
        goto L25
    L16:
        r110 = false;
        goto L17
    L13:
        r109 = null;
    L9:
        r107 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r100 = null;
        if (this.f311972q != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        com.larus.bmhome.actionbar.model.i r102 = this.f311972q;
        if (r102 == null) goto L35;
        List<com.larus.bmhome.actionbar.model.h> r103 = r102.f295193a;
        if (r103 == null) goto L35;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.h r105 = (com.larus.bmhome.actionbar.model.h) r104.next();
        List<w> r106 = r105.f295167e;
        boolean r107 = false;
        if (r106 == null) goto L27;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r106.iterator();
    L16:
        if (r109.hasNext() == false) goto L26;
        Object r110 = r109.next();
        Integer r111 = ((w) r110).f295528s;
        if (r111 != null) goto L21;
    L23:
        boolean r112 = false;
    L24:
        if (r112 == false) goto L16;
        r108.add(r110);
        goto L16
    L21:
        if (r111.intValue() != 1) goto L23;
        r112 = true;
        goto L24
    L26:
        ArrayList r113 = r108;
    L28:
        if (r113 != null) goto L30;
    L32:
        if (r107 == false) goto L11;
        r101.add(com.larus.bmhome.actionbar.model.h.a(r105, null, null, null, r113, null, null, 4079));
        goto L11
    L30:
        if ((!r113.isEmpty()) != true) goto L32;
        r107 = true;
        goto L32
    L27:
        r113 = null;
    L35:
        if (r101.isEmpty() == false) goto L38;
        return null;
    L38:
        if (this.f311972q == null) goto L40;
        com.larus.bmhome.actionbar.model.i r114 = new com.larus.bmhome.actionbar.model.i(r101);
    L51:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L43
        Object r116 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.i.Companion.serializer()), r114));     // Catch: Throwable -> L43
    L46:
        if (Result.m9455isFailureimpl(r116) == true) goto L50;
        r100 = r116;
    L50:
        return (String) r100;
    L43:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L40:
        r114 = null;
        goto L51
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        if ((r101 instanceof Map) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        com.larus.bmhome.actionbar.model.i r103 = this.f311972q;
        if (r103 == null) goto L46;
        List<com.larus.bmhome.actionbar.model.h> r104 = r103.f295193a;
        if (r104 == null) goto L59;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L60;
        com.larus.bmhome.actionbar.model.h r106 = (com.larus.bmhome.actionbar.model.h) r105.next();
        if (r102 == null) goto L17;
        Object r107 = r102.get(String.valueOf(r106.f295164b));
        if (r107 == null) goto L17;
    L21:
        if ((r107 instanceof Map) == false) goto L23;
        Map r108 = (Map) r107;
    L24:
        if (r108 == null) goto L28;
        Object r109 = r108.get("default_select_id");
        if (r109 == null) goto L28;
        String r110 = r109.toString();
    L30:
        if (r110 != null) goto L32;
    L35:
        boolean r111 = true;
    L36:
        if (r111 == true) goto L12;
        List<w> r112 = r106.f295167e;
        if (r112 == null) goto L12;
        Iterator<T> r113 = r112.iterator();
    L41:
        if (r113.hasNext() == false) goto L12;
        w r114 = (w) r113.next();
        if (Intrinsics.areEqual(String.valueOf(r114.f295510a), r110) == true) goto L44;
        r114.f295528s = 0;
        goto L41
    L44:
        r114.f295528s = 1;
        goto L41
    L32:
        if (r110.length() == 0) goto L35;
        r111 = false;
    L28:
        r110 = null;
        goto L30
    L23:
        r108 = null;
    L17:
        if (r102 == null) goto L19;
        r107 = r102.get("match_all_id");
        goto L21
    L19:
        r107 = null;
        goto L21
    L60:
        return;
    L59:
        return;
    L46:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof cq8.l) == false) goto L5;
        this.f311974s = false;
        cq8.l r101 = (cq8.l) r100;
        int r102 = r101.f464878c;
        q(r102, r101.f464879d, r102);
        j();
        return;
    L5:
        boolean r103 = r100 instanceof cq8.n;
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
        Object r111 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.i) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r111);
        if (r103 != null) goto L115;
        com.larus.bmhome.actionbar.model.i r112 = (com.larus.bmhome.actionbar.model.i) r111;
        List<com.larus.bmhome.actionbar.model.h> r104 = null;
        if (r112 == null) goto L21;
        List<com.larus.bmhome.actionbar.model.h> r105 = r112.f295193a;
    L22:
        List<com.larus.bmhome.actionbar.model.h> r106 = r105;
        if (r106 != null) goto L25;
    L28:
        if (r100 == true) goto L30;
        this.f311972q = r112;
        if (r112 == null) goto L109;
        List<com.larus.bmhome.actionbar.model.h> r113 = r112.f295193a;
        if (r113 == null) goto L109;
        Iterator<T> r114 = r113.iterator();
    L37:
        if (r114.hasNext() == false) goto L109;
        com.larus.bmhome.actionbar.model.h r107 = (com.larus.bmhome.actionbar.model.h) r114.next();
        if (com.flow.kmp.common.thread.a.a() == true) goto L41;
        Object r108 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownListSelectorController$parseTemplate$lambda$9$$inlined$runOnMainThreadIfNeed$1(null, r107, this));
    L61:
        Long r109 = (Long) r108;
        if (r109 != null) goto L65;
    L66:
        List<w> r115 = r107.f295167e;
        if (r115 == null) goto L78;
        Iterator<T> r116 = r115.iterator();
    L70:
        if (r116.hasNext() == false) goto L74;
        Object r117 = r116.next();
        if (Intrinsics.areEqual(((w) r117).f295510a, r109) == false) goto L70;
    L75:
        w r118 = (w) r117;
        if (r118 == null) goto L78;
        r118.f295528s = 1;
    L79:
        if (r118 == null) goto L81;
    L94:
        w r119 = null;
    L95:
        if (r119 != null) goto L37;
        if (r118 != null) goto L37;
        if (Intrinsics.areEqual(r107.f295170h, Boolean.TRUE) == true) goto L102;
        Integer r120 = r107.f295168f;
        if (r120 == null) goto L102;
        int r121 = r120.intValue();
    L103:
        if (r121 < 0) goto L37;
        List<w> r122 = r107.f295167e;
        if (r122 == null) goto L37;
        w r123 = (w) CollectionsKt.getOrNull(r122, r121);
        if (r123 == null) goto L37;
        r123.f295528s = 1;
    L102:
        r121 = -1;
        goto L103
    L81:
        if (Intrinsics.areEqual(r107.f295170h, Boolean.TRUE) == true) goto L94;
        List<w> r124 = r107.f295167e;
        if (r124 == null) goto L94;
        Iterator<T> r125 = r124.iterator();
    L86:
        if (r125.hasNext() == false) goto L90;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((w) r126).f295510a, r107.f295169g) == false) goto L86;
    L91:
        r119 = (w) r126;
        if (r119 == null) goto L94;
        r119.f295528s = 1;
        goto L95
    L90:
        r126 = null;
        goto L91
    L74:
        r117 = null;
    L78:
        r118 = null;
        goto L79
    L65:
        if (r109.longValue() == (-1)) goto L78;
    L41:
        if (Intrinsics.areEqual(r107.f295171i, Boolean.TRUE) == false) goto L59;
        StringBuilder r127 = new StringBuilder("dropbox_");
        com.larus.bmhome.instruction.core.impl.base.c r128 = this.f311921c;
        if (r128 == null) goto L49;
        aq8.d r129 = r128.f311935a;
        if (r129 == null) goto L49;
        dq8.h r130 = r129.f15937a;
        if (r130 == null) goto L49;
        Integer r131 = r130.getInstructionType();
    L50:
        r127.append(r131);
        r127.append('_');
        com.larus.bmhome.actionbar.model.u r132 = this.f311920b;
        if (r132 == null) goto L53;
        Integer r133 = r132.f295474a;
    L54:
        r127.append(r133);
        r127.append('_');
        r127.append(r107.f295164b);
        String r134 = r127.toString();
        gb6.c r135 = (gb6.c) this.f311971p.getValue();
        if (r135 == null) goto L57;
        r108 = Long.valueOf(r135.getLong(r134, -1));
    L58:
        c0.f348199b.i("DropdownListSelectorController", "key is " + r134 + ' ' + r108 + " is " + r108);
        goto L61
    L57:
        r108 = null;
        goto L58
    L53:
        r133 = null;
    L49:
        r131 = null;
        goto L50
    L59:
        r108 = -1L;
    L109:
        com.larus.bmhome.actionbar.model.i r136 = this.f311972q;
        if (r136 == null) goto L112;
        r104 = new com.larus.bmhome.actionbar.model.i(r136.f295193a).f295193a;
    L112:
        this.f311973r = r104;
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r106.isEmpty() == true) goto L28;
        r100 = false;
        goto L28
    L21:
        r105 = null;
        goto L22
    L115:
        return new wa8.a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.util.ArrayList] */
    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        boolean r100 = true;
        if ((r210 instanceof com.larus.bmhome.instruction.core.impl.base.l) == false) goto L176;
        c0 r101 = c0.f348199b;
        StringBuilder r102 = new StringBuilder("[onEvent] ParamFilterConfChangedEvent: ");
        com.larus.bmhome.instruction.core.impl.base.l r103 = (com.larus.bmhome.instruction.core.impl.base.l) r210;
        r102.append(r103.f311969c);
        r101.i("DropdownListSelectorController", r102.toString());
        this.f311974s = false;
        com.larus.bmhome.actionbar.model.i r104 = this.f311972q;
        if (r104 == null) goto L7;
        List<com.larus.bmhome.actionbar.model.h> r105 = r104.f295193a;
    L8:
        if (r105 != null) goto L10;
        r105 = CollectionsKt.emptyList();
    L10:
        List<com.larus.bmhome.actionbar.model.h> r106 = this.f311973r;
        if (r106 != null) goto L14;
        r106 = CollectionsKt.emptyList();
    L14:
        if (r105.isEmpty() == false) goto L16;
    L84:
        com.larus.bmhome.actionbar.model.i r107 = this.f311972q;
        if (r107 == null) goto L174;
        t1 r108 = r103.f311969c;
        boolean r109 = r103.f311970d;
        List<f1> r110 = r108.f295471a;
        if (r110 != null) goto L89;
        List<com.larus.bmhome.actionbar.model.h> r111 = r107.f295193a;
    L173:
        r107.f295193a = r111;
        goto L174
    L89:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r110.iterator();
    L91:
        if (r113.hasNext() == false) goto L172;
        f1 r114 = (f1) r113.next();
        List<com.larus.bmhome.actionbar.model.h> r115 = this.f311973r;
        if (r115 == null) goto L91;
        Iterator r116 = r115.iterator();
    L96:
        if (r116.hasNext() == false) goto L100;
        Object r117 = r116.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r117).f295163a, r114.f295140a) == false) goto L96;
    L101:
        com.larus.bmhome.actionbar.model.h r118 = (com.larus.bmhome.actionbar.model.h) r117;
        if (r118 == null) goto L91;
        List<Long> r119 = r114.f295141b;
        if (r119 == null) goto L125;
        ?? r120 = new ArrayList();
        Iterator r121 = r119.iterator();
    L107:
        if (r121.hasNext() == false) goto L126;
        Long r122 = (Long) r121.next();
        List<w> r123 = r118.f295167e;
        if (r123 == null) goto L121;
        Iterator r124 = r123.iterator();
    L112:
        if (r124.hasNext() == false) goto L117;
        Object r125 = r124.next();
        if (Intrinsics.areEqual(((w) r125).f295510a, r122) == false) goto L112;
    L118:
        w r126 = (w) r125;
        if (r126 == null) goto L121;
        w r127 = w.a(r126, null, null, null, null, null, null, 8388607);
    L122:
        if (r127 == null) goto L107;
        r120.add(r127);
        goto L107
    L117:
        r125 = null;
    L121:
        r127 = null;
    L126:
        if (r120 != 0) goto L128;
        r120 = CollectionsKt.emptyList();
    L128:
        if (r109 == true) goto L130;
        Long r128 = r114.f295142c;
    L161:
        Iterable r129 = (Iterable) r120;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r131 = r129.iterator();
    L163:
        if (r131.hasNext() == false) goto L171;
        w r132 = (w) r131.next();
        Long r133 = r132.f295510a;
        if (r133 != null) goto L167;
    L169:
        Integer r134 = 0;
    L170:
        r132.f295528s = r134;
        r130.add(r132);
        goto L163
    L167:
        if (Intrinsics.areEqual(r133, r128) == false) goto L169;
        r134 = 1;
        goto L170
    L171:
        r112.add(com.larus.bmhome.actionbar.model.h.a(r118, null, null, null, r130, null, null, 4079));
        goto L91
    L130:
        List<w> r135 = r118.f295167e;
        if (r135 == null) goto L148;
        Iterator r136 = r135.iterator();
    L134:
        if (r136.hasNext() == false) goto L144;
        Object r137 = r136.next();
        Integer r138 = ((w) r137).f295528s;
        if (r138 != null) goto L139;
    L141:
        boolean r139 = false;
    L142:
        if (r139 == false) goto L134;
    L145:
        w r140 = (w) r137;
        if (r140 == null) goto L148;
        r128 = r140.f295510a;
    L149:
        ArrayList r141 = new ArrayList();
        Iterator r142 = ((Iterable) r120).iterator();
    L151:
        if (r142.hasNext() == false) goto L155;
        Long r143 = ((w) r142.next()).f295510a;
        if (r143 == null) goto L151;
        r141.add(r143);
        goto L151
    L155:
        Set r144 = CollectionsKt.toSet(r141);
        if (r128 != null) goto L158;
    L160:
        r128 = r114.f295142c;
        goto L161
    L158:
        if (r144.contains(r128) == false) goto L160;
    L139:
        if (r138.intValue() != 1) goto L141;
        r139 = true;
        goto L142
    L144:
        r137 = null;
    L148:
        r128 = null;
        goto L149
    L125:
        r120 = 0;
        goto L126
    L100:
        r117 = null;
        goto L101
    L172:
        r111 = r112;
    L174:
        j();
        return;
    L16:
        if (r106.isEmpty() == true) goto L84;
        Iterator r145 = r105.iterator();
    L20:
        if (r145.hasNext() == false) goto L84;
        com.larus.bmhome.actionbar.model.h r146 = (com.larus.bmhome.actionbar.model.h) r145.next();
        List<w> r147 = r146.f295167e;
        if (r147 == null) goto L20;
        Iterator r148 = r147.iterator();
    L25:
        if (r148.hasNext() == false) goto L35;
        Object r149 = r148.next();
        Integer r150 = ((w) r149).f295528s;
        if (r150 != null) goto L30;
    L32:
        boolean r151 = false;
    L33:
        if (r151 == false) goto L25;
    L36:
        w r152 = (w) r149;
        if (r152 == null) goto L20;
        Long r153 = r152.f295510a;
        if (r153 == null) goto L20;
        long r154 = r153.longValue();
        Iterator r155 = r106.iterator();
    L42:
        if (r155.hasNext() == false) goto L67;
        Object r156 = r155.next();
        com.larus.bmhome.actionbar.model.h r157 = (com.larus.bmhome.actionbar.model.h) r156;
        String r158 = r146.f295163a;
        if (r158 != null) goto L46;
    L49:
        boolean r159 = true;
    L50:
        if (r159 == false) goto L52;
    L53:
        String r160 = r146.f295163a;
        if (r160 != null) goto L56;
    L59:
        boolean r161 = true;
    L60:
        if (r161 == true) goto L62;
    L64:
        boolean r162 = false;
    L65:
        if (r162 == false) goto L42;
    L68:
        com.larus.bmhome.actionbar.model.h r163 = (com.larus.bmhome.actionbar.model.h) r156;
        if (r163 == null) goto L20;
        List<w> r164 = r163.f295167e;
        if (r164 == null) goto L20;
        Iterator r165 = r164.iterator();
    L75:
        if (r165.hasNext() == false) goto L20;
        w r166 = (w) r165.next();
        Long r167 = r166.f295510a;
        if (r167 != null) goto L80;
    L82:
        Integer r168 = 0;
    L83:
        r166.f295528s = r168;
        goto L75
    L80:
        if (r167.longValue() != r154) goto L82;
        r168 = 1;
        goto L83
    L62:
        if (Intrinsics.areEqual(r157.f295164b, r146.f295164b) == false) goto L64;
    L63:
        r162 = true;
        goto L65
    L56:
        if (r160.length() == 0) goto L59;
        r161 = false;
        goto L60
    L52:
        if (Intrinsics.areEqual(r157.f295163a, r146.f295163a) == true) goto L63;
    L46:
        if (r158.length() == 0) goto L49;
        r159 = false;
        goto L50
    L67:
        r156 = null;
        goto L68
    L30:
        if (r150.intValue() != 1) goto L32;
        r151 = true;
        goto L33
    L35:
        r149 = null;
        goto L36
    L7:
        r105 = null;
        goto L8
    L176:
        if ((r210 instanceof com.larus.bmhome.instruction.core.impl.base.j) == false) goto L267;
        c0 r169 = c0.f348199b;
        StringBuilder r170 = new StringBuilder("[onEvent] InstructionMusicTemplatePromptEvent: ");
        com.larus.bmhome.instruction.core.impl.base.j r171 = (com.larus.bmhome.instruction.core.impl.base.j) r210;
        r170.append(r171.f311944c);
        r169.i("DropdownListSelectorController", r170.toString());
        this.f311974s = false;
        bq8.d r172 = r171.f311944c.b();
        bq8.e r173 = r172.f20080b;
        bq8.e r174 = r172.f20079a;
        bq8.e r175 = r172.f20081c;
        if (r173 == null) goto L185;
        Integer r176 = Integer.valueOf(r173.f20087d);
        if (r176.intValue() != 0) goto L183;
        r100 = false;
    L183:
        if (r100 == false) goto L185;
        Integer r177 = r176;
    L187:
        if (r173 == null) goto L193;
        int r178 = r173.f20087d;
        if (r178 == 0) goto L193;
        long r179 = r173.f20084a;
        if (r179 == 0) goto L193;
        q(r178, r179, r178);
    L193:
        if (r174 == null) goto L202;
        int r180 = r174.f20087d;
        if (r180 == 0) goto L202;
        long r181 = r174.f20084a;
        if (r181 == 0) goto L202;
        if (r177 == null) goto L200;
        int r182 = r177.intValue();
    L201:
        q(r180, r181, r182);
        goto L202
    L200:
        r182 = r180;
    L202:
        if (r175 == null) goto L211;
        int r183 = r175.f20087d;
        if (r183 == 0) goto L211;
        long r184 = r175.f20084a;
        if (r184 == 0) goto L211;
        if (r177 == null) goto L209;
        int r185 = r177.intValue();
    L210:
        q(r183, r184, r185);
        goto L211
    L209:
        r185 = r183;
    L211:
        j();
        return;
    L185:
        r177 = null;
        goto L187
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.i) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.i r104 = (com.larus.bmhome.actionbar.model.i) r103;
        if (r104 != null) goto L14;
        return;
    L14:
        if (r101 == false) goto L16;
        this.f311974s = true;
    L16:
        List<com.larus.bmhome.actionbar.model.h> r105 = r104.f295193a;
        if (r105 == null) goto L89;
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L128;
        com.larus.bmhome.actionbar.model.h r107 = (com.larus.bmhome.actionbar.model.h) r106.next();
        String r108 = r107.f295163a;
        if (r108 != null) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == false) goto L29;
        com.larus.bmhome.actionbar.model.i r110 = this.f311972q;
        if (r110 == null) goto L20;
        List<com.larus.bmhome.actionbar.model.h> r111 = r110.f295193a;
        if (r111 == null) goto L20;
        Iterator<T> r112 = r111.iterator();
    L65:
        if (r112.hasNext() == false) goto L69;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r113).f295164b, r107.f295164b) == false) goto L65;
    L70:
        com.larus.bmhome.actionbar.model.h r114 = (com.larus.bmhome.actionbar.model.h) r113;
        if (r114 == null) goto L20;
        List<w> r115 = r107.f295167e;
        if (r115 == null) goto L77;
        w r116 = (w) CollectionsKt.firstOrNull(r115);
        if (r116 == null) goto L77;
        Long r117 = r116.f295510a;
    L78:
        if (r117 == null) goto L20;
        List<w> r118 = r114.f295167e;
        if (r118 == null) goto L20;
        Iterator<T> r119 = r118.iterator();
    L83:
        if (r119.hasNext() == false) goto L20;
        w r120 = (w) r119.next();
        if (Intrinsics.areEqual(r120.f295510a, r117) == false) goto L87;
        int r121 = 1;
    L88:
        r120.f295528s = r121;
        goto L83
    L87:
        r121 = 0;
    L77:
        r117 = null;
        goto L78
    L69:
        r113 = null;
        goto L70
    L29:
        com.larus.bmhome.actionbar.model.i r122 = this.f311972q;
        if (r122 == null) goto L20;
        List<com.larus.bmhome.actionbar.model.h> r123 = r122.f295193a;
        if (r123 == null) goto L20;
        Iterator<T> r124 = r123.iterator();
    L35:
        if (r124.hasNext() == false) goto L39;
        Object r125 = r124.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r125).f295163a, r107.f295163a) == false) goto L35;
    L40:
        com.larus.bmhome.actionbar.model.h r126 = (com.larus.bmhome.actionbar.model.h) r125;
        if (r126 == null) goto L20;
        List<w> r127 = r107.f295167e;
        if (r127 == null) goto L47;
        w r128 = (w) CollectionsKt.firstOrNull(r127);
        if (r128 == null) goto L47;
        Long r129 = r128.f295510a;
    L48:
        if (r129 == null) goto L20;
        List<w> r130 = r126.f295167e;
        if (r130 == null) goto L20;
        Iterator<T> r131 = r130.iterator();
    L53:
        if (r131.hasNext() == false) goto L20;
        w r132 = (w) r131.next();
        if (Intrinsics.areEqual(r132.f295510a, r129) == false) goto L57;
        int r133 = 1;
    L58:
        r132.f295528s = r133;
        goto L53
    L57:
        r133 = 0;
    L47:
        r129 = null;
        goto L48
    L39:
        r125 = null;
        goto L40
    L24:
        if (r108.length() == 0) goto L27;
        r109 = false;
        goto L28
    L128:
        return;
    L89:
        return;
    L5:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void p(com.larus.bmhome.actionbar.model.h r110, int r111, long r112) {
        if (com.flow.kmp.common.thread.a.a() == true) goto L5;
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownListSelectorController$persistIfNeedSave$$inlined$runOnMainThreadIfNeed$1(null, r110, this, r111, r112));
        return;
    L5:
        if (Intrinsics.areEqual(r110.f295171i, Boolean.TRUE) == false) goto L22;
        StringBuilder r113 = new StringBuilder("dropbox_");
        com.larus.bmhome.instruction.core.impl.base.c r100 = this.f311921c;
        Integer r101 = null;
        if (r100 == null) goto L13;
        aq8.d r102 = r100.f311935a;
        if (r102 == null) goto L13;
        dq8.h r103 = r102.f15937a;
        if (r103 == null) goto L13;
        Integer r104 = r103.getInstructionType();
    L14:
        r113.append(r104);
        r113.append('_');
        com.larus.bmhome.actionbar.model.u r105 = this.f311920b;
        if (r105 == null) goto L17;
        r101 = r105.f295474a;
    L17:
        r113.append(r101);
        r113.append('_');
        r113.append(r111);
        String r114 = r113.toString();
        gb6.c r115 = (gb6.c) this.f311971p.getValue();
        if (r115 == null) goto L23;
        r115.storeLong(r114, r112);
        return;
    L23:
        return;
    L13:
        r104 = null;
        goto L14
    }

    public final void q(int r110, long r111, int r112) {
        com.larus.bmhome.actionbar.model.i r100 = this.f311972q;
        Object r101 = null;
        if (r100 == null) goto L35;
        List<com.larus.bmhome.actionbar.model.h> r102 = r100.f295193a;
        if (r102 == null) goto L35;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        Integer r105 = ((com.larus.bmhome.actionbar.model.h) r104).f295164b;
        if (r105 != null) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L8;
    L19:
        com.larus.bmhome.actionbar.model.h r107 = (com.larus.bmhome.actionbar.model.h) r104;
        if (r107 == null) goto L35;
        List<w> r108 = r107.f295167e;
        if (r108 == null) goto L34;
        Iterator<T> r109 = r108.iterator();
    L25:
        if (r109.hasNext() == false) goto L34;
        w r113 = (w) r109.next();
        Long r114 = r113.f295510a;
        if (r114 != null) goto L30;
    L32:
        Integer r115 = 0;
    L33:
        r113.f295528s = r115;
        goto L25
    L30:
        if (r114.longValue() != r111) goto L32;
        r115 = 1;
    L34:
        p(r107, r112, r111);
        goto L35
    L13:
        if (r105.intValue() != r110) goto L15;
        r106 = true;
        goto L16
    L18:
        r104 = null;
    L35:
        List<com.larus.bmhome.actionbar.model.h> r116 = this.f311973r;
        if (r116 == null) goto L82;
        Iterator<T> r117 = r116.iterator();
    L39:
        if (r117.hasNext() == false) goto L49;
        Object r118 = r117.next();
        Integer r119 = ((com.larus.bmhome.actionbar.model.h) r118).f295164b;
        if (r119 != null) goto L44;
    L46:
        boolean r120 = false;
    L47:
        if (r120 == false) goto L39;
        r101 = r118;
        goto L49
    L44:
        if (r119.intValue() != r110) goto L46;
        r120 = true;
    L49:
        com.larus.bmhome.actionbar.model.h r121 = (com.larus.bmhome.actionbar.model.h) r101;
        if (r121 == null) goto L83;
        List<w> r122 = r121.f295167e;
        if (r122 == null) goto L64;
        Iterator<T> r123 = r122.iterator();
    L55:
        if (r123.hasNext() == false) goto L64;
        w r124 = (w) r123.next();
        Long r125 = r124.f295510a;
        if (r125 != null) goto L60;
    L62:
        Integer r126 = 0;
    L63:
        r124.f295528s = r126;
        goto L55
    L60:
        if (r125.longValue() != r111) goto L62;
        r126 = 1;
    L64:
        p(r121, r112, r111);
        return;
    L83:
        return;
    }
}
