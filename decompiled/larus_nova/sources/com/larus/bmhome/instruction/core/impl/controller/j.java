package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import cq8.a0;
import cq8.v;
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
public final class j extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.n f311996p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TemplateInfo$TemplateInfo f311997q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f311998r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f311999s;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 11;
    }

    public j() {
        super("ImageTemplateSelectorWithMoreController");
        this.f311998r = -1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.n r100 = this.f311996p;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295325c, Boolean.TRUE);
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
        if (this.f311999s == true) goto L65;
        this.f311999s = true;
        com.larus.bmhome.actionbar.model.n r100 = this.f311996p;
        if (r100 == null) goto L29;
        List<w> r101 = r100.f295323a;
        if (r101 == null) goto L29;
        List<w> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r103 = r102.iterator();
    L16:
        if (r103.hasNext() == false) goto L26;
        Integer r104 = ((w) r103.next()).f295528s;
        if (r104 != null) goto L21;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == false) goto L16;
        boolean r106 = true;
    L27:
        if (r106 != true) goto L29;
        boolean r107 = true;
    L30:
        int r108 = -1;
        if (r107 == true) goto L46;
        com.larus.bmhome.actionbar.model.n r109 = this.f311996p;
        if (r109 == null) goto L37;
        Integer r110 = r109.f295324b;
        if (r110 == null) goto L37;
        int r111 = r110.intValue();
    L38:
        if (r111 < 0) goto L46;
        com.larus.bmhome.actionbar.model.n r112 = this.f311996p;
        if (r112 == null) goto L46;
        List<w> r113 = r112.f295323a;
        if (r113 == null) goto L46;
        w r114 = (w) CollectionsKt.getOrNull(r113, r111);
        if (r114 == null) goto L46;
        r114.f295528s = 1;
    L37:
        r111 = -1;
    L46:
        com.larus.bmhome.actionbar.model.n r115 = this.f311996p;
        if (r115 == null) goto L63;
        List<w> r116 = r115.f295323a;
        if (r116 == null) goto L63;
        Iterator<w> r117 = r116.iterator();
        int r118 = 0;
    L52:
        if (r117.hasNext() == false) goto L63;
        Integer r119 = r117.next().f295528s;
        if (r119 != null) goto L57;
    L59:
        boolean r120 = false;
    L60:
        if (r120 == true) goto L61;
        r118 = r118 + 1;
        goto L52
    L61:
        r108 = r118;
        goto L63
    L57:
        if (r119.intValue() != 1) goto L59;
        r120 = true;
    L63:
        if (r108 < 0) goto L65;
        this.f311998r = r108;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L65
    L21:
        if (r104.intValue() != 1) goto L23;
        r105 = true;
    L26:
        r106 = false;
        goto L27
    L12:
        if (r102.isEmpty() == false) goto L14;
    L29:
        r107 = false;
    L65:
        String r121 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r122 = this.f311933o;
        com.larus.bmhome.actionbar.model.n r123 = this.f311996p;
        com.larus.bmhome.actionbar.model.u r124 = this.f311920b;
        String r125 = null;
        if (r124 == null) goto L72;
        String r126 = r124.f295476c;
        if (r126 == null) goto L72;
        if ((!StringsKt.isBlank(r126)) == false) goto L72;
        String r127 = r126;
    L73:
        com.larus.bmhome.actionbar.model.u r128 = this.f311920b;
        if (r128 == null) goto L76;
        boolean r129 = Intrinsics.areEqual(r128.f295479f, Boolean.TRUE);
    L77:
        com.larus.bmhome.actionbar.model.u r130 = this.f311920b;
        if (r130 == null) goto L85;
        Integer r131 = r130.f295474a;
        if (r131 == null) goto L85;
        if (r131.intValue() != 1) goto L85;
        boolean r132 = true;
    L86:
        com.larus.bmhome.actionbar.model.n r133 = this.f311996p;
        if (r133 == null) goto L95;
        List<w> r134 = r133.f295326d;
        if (r134 == null) goto L95;
        w r135 = (w) CollectionsKt.firstOrNull(r134);
        if (r135 == null) goto L95;
        if (r135.f295519j != true) goto L95;
        boolean r136 = true;
    L96:
        TemplateInfo$TemplateInfo r137 = this.f311997q;
        com.larus.bmhome.instruction.core.impl.base.c r138 = this.f311921c;
        if (r138 == null) goto L103;
        aq8.d r139 = r138.f311935a;
        if (r139 == null) goto L103;
        dq8.h r140 = r139.f15937a;
        if (r140 == null) goto L103;
        String r141 = r140.getBotId();
    L104:
        com.larus.bmhome.instruction.core.impl.base.c r142 = this.f311921c;
        if (r142 == null) goto L111;
        aq8.d r143 = r142.f311935a;
        if (r143 == null) goto L111;
        dq8.h r144 = r143.f15937a;
        if (r144 == null) goto L111;
        String r145 = r144.getChatType();
    L112:
        com.larus.bmhome.instruction.core.impl.base.c r146 = this.f311921c;
        if (r146 == null) goto L119;
        aq8.d r147 = r146.f311935a;
        if (r147 == null) goto L119;
        dq8.h r148 = r147.f15937a;
        if (r148 == null) goto L119;
        String r149 = r148.getTemplateType();
    L120:
        com.larus.bmhome.instruction.core.impl.base.c r150 = this.f311921c;
        if (r150 == null) goto L129;
        aq8.d r151 = r150.f311935a;
        if (r151 == null) goto L129;
        dq8.h r152 = r151.f15937a;
        if (r152 == null) goto L129;
        Integer r153 = r152.getInstructionType();
        if (r153 == null) goto L129;
        String r154 = r153.toString();
    L130:
        com.larus.bmhome.instruction.core.impl.base.c r155 = this.f311921c;
        if (r155 == null) goto L137;
        aq8.d r156 = r155.f311935a;
        if (r156 == null) goto L137;
        dq8.h r157 = r156.f15937a;
        if (r157 == null) goto L137;
        String r158 = r157.a();
    L138:
        com.larus.bmhome.instruction.core.impl.base.c r159 = this.f311921c;
        if (r159 == null) goto L145;
        aq8.d r160 = r159.f311935a;
        if (r160 == null) goto L145;
        dq8.h r161 = r160.f15937a;
        if (r161 == null) goto L145;
        String r210 = r161.b();
    L146:
        com.larus.bmhome.instruction.core.impl.base.c r162 = this.f311921c;
        if (r162 == null) goto L153;
        aq8.d r163 = r162.f311935a;
        if (r163 == null) goto L153;
        dq8.h r164 = r163.f15937a;
        if (r164 == null) goto L153;
        Boolean r211 = r164.isCreationActionBar();
    L154:
        com.larus.bmhome.actionbar.model.u r165 = this.f311920b;
        if (r165 == null) goto L161;
        String r166 = r165.f295476c;
        if (r166 == null) goto L161;
        if ((!StringsKt.isBlank(r166)) == false) goto L161;
        String r212 = r166;
    L162:
        com.larus.bmhome.instruction.core.impl.base.c r167 = this.f311921c;
        if (r167 == null) goto L170;
        aq8.d r168 = r167.f311935a;
        if (r168 == null) goto L170;
        dq8.h r169 = r168.f15937a;
        if (r169 == null) goto L170;
        r125 = r169.c();
    L170:
        return new cq8.w(r121, r122, r123, r127, r129, r132, r136, r137, new z0(r141, r145, r149, r125, r154, r158, r210, r211, r212, 2), this.f311998r);
    L161:
        r212 = null;
    L153:
        r211 = null;
    L145:
        r210 = null;
    L137:
        r158 = null;
    L129:
        r154 = null;
    L119:
        r149 = null;
    L111:
        r145 = null;
    L103:
        r141 = null;
    L95:
        r136 = false;
    L85:
        r132 = false;
        goto L86
    L76:
        r129 = false;
    L72:
        r127 = null;
        goto L73
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.n r100 = this.f311996p;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295323a;
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
        com.larus.bmhome.actionbar.model.n r109 = this.f311996p;
        if (r109 == null) goto L29;
        com.larus.bmhome.actionbar.model.n r110 = com.larus.bmhome.actionbar.model.n.d(r109, r104, this.f311997q);
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.n.Companion.serializer()), r110));     // Catch: Throwable -> L32
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

    public final void q() {
        com.larus.bmhome.actionbar.model.u r100 = this.f311920b;
        boolean r101 = false;
        if (r100 == null) goto L10;
        Integer r102 = r100.f295474a;
        if (r102 == null) goto L10;
        if (r102.intValue() != 1) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.n r104 = this.f311996p;
        if (r104 == null) goto L37;
        List<w> r105 = r104.f295323a;
        if (r105 == null) goto L37;
        List<w> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r107 = r106.iterator();
    L24:
        if (r107.hasNext() == false) goto L34;
        Integer r108 = ((w) r107.next()).f295528s;
        if (r108 != null) goto L29;
    L31:
        boolean r109 = false;
    L32:
        if (r109 == false) goto L24;
        boolean r110 = true;
    L35:
        if (r110 != true) goto L37;
        r101 = true;
        goto L37
    L29:
        if (r108.intValue() != 1) goto L31;
        r109 = true;
    L34:
        r110 = false;
        goto L35
    L20:
        if (r106.isEmpty() == false) goto L22;
    L37:
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(r101));
        return;
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        if ((r101 instanceof Map) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        if (r102 == null) goto L9;
        Object r103 = r102.get(null);
        if (r103 == null) goto L9;
    L13:
        if ((r103 instanceof Map) == false) goto L15;
        Map r104 = (Map) r103;
    L16:
        if (r104 == null) goto L34;
        Object r105 = r104.get("default_select_id");
        if (r105 == null) goto L41;
        c0.f348199b.d("ImageTemplateSelectorWithMoreController", "onReStoreComponentStateByDefaultParams: select:" + r105);
        com.larus.bmhome.actionbar.model.n r106 = this.f311996p;
        if (r106 == null) goto L42;
        List<w> r107 = r106.f295323a;
        if (r107 == null) goto L43;
        Iterator<T> r108 = r107.iterator();
    L25:
        if (r108.hasNext() == false) goto L44;
        w r109 = (w) r108.next();
        Long r110 = r109.f295510a;
        if (r110 == null) goto L29;
        String r111 = r110.toString();
    L31:
        if (Intrinsics.areEqual(r111, r105) == true) goto L32;
        r109.f295528s = 0;
        goto L25
    L32:
        r109.f295528s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        c0.f348199b.d("ImageTemplateSelectorWithMoreController", "hit restore by default params option id:" + ((String) r105) + ", option name:" + r109.f295511b);
        goto L25
    L29:
        r111 = null;
        goto L31
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L34:
        return;
    L15:
        r104 = null;
    L9:
        if (r102 == null) goto L11;
        r103 = r102.get("match_all_id");
        goto L13
    L11:
        r103 = null;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if (Intrinsics.areEqual(r110.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r110 instanceof cq8.q) == false) goto L38;
        cq8.q r100 = (cq8.q) r110;
        com.larus.bmhome.actionbar.model.n r101 = this.f311996p;
        if (r101 == null) goto L36;
        List<w> r102 = r101.f295323a;
        if (r102 == null) goto L36;
        boolean r103 = Intrinsics.areEqual(r101.f295325c, Boolean.TRUE);
        List<w> r104 = r102;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L32;
        w r107 = (w) r106.next();
        Long r108 = r107.f295510a;
        long r111 = r100.f464932c;
        if (r108 != null) goto L19;
    L24:
        Long r109 = r107.f295510a;
        long r112 = r100.f464932c;
        if (r109 != null) goto L28;
    L30:
        int r113 = 0;
    L31:
        r105.add(w.a(r107, null, null, Integer.valueOf(r113), null, null, null, 8126463));
        goto L14
    L28:
        if (r109.longValue() != r112) goto L30;
        r113 = 1;
        goto L31
    L19:
        if (r108.longValue() != r111) goto L24;
        if (r100.f464933d == false) goto L24;
        if (r103 == true) goto L24;
    L32:
        List<w> r114 = CollectionsKt.toMutableList(r105);
        com.larus.bmhome.actionbar.model.n r115 = this.f311996p;
        if (r115 == null) goto L35;
        r115.f295323a = r114;
    L35:
        this.f311998r = -1;
        q();
    L36:
        j();
        return;
    L38:
        if ((r110 instanceof cq8.s) == false) goto L40;
        p(((cq8.s) r110).f464953c);
        j();
        return;
    L40:
        Object r116 = null;
        if ((r110 instanceof v) == false) goto L63;
        TemplateInfo$TemplateInfo r117 = ((v) r110).f464970c;
        this.f311997q = null;
        com.larus.bmhome.actionbar.model.n r118 = this.f311996p;
        if (r118 == null) goto L58;
        List<w> r119 = r118.f295323a;
        if (r119 == null) goto L58;
        Iterator<T> r120 = r119.iterator();
    L48:
        if (r120.hasNext() == false) goto L57;
        Object r121 = r120.next();
        Long r122 = ((w) r121).f295510a;
        if (r122 != null) goto L52;
    L54:
        boolean r123 = false;
    L55:
        if (r123 == false) goto L48;
        r116 = r121;
        goto L57
    L52:
        if (r122.longValue() != r117.f365416a) goto L54;
        r123 = true;
    L57:
        r116 = (w) r116;
    L58:
        if (r116 == null) goto L60;
        p(Long.valueOf(r117.f365416a));
    L61:
        j();
        return;
    L60:
        this.f311997q = r117;
        goto L61
    L63:
        if ((r110 instanceof cq8.u) == false) goto L76;
        com.larus.bmhome.actionbar.model.n r124 = this.f311996p;
        if (r124 == null) goto L74;
        List<w> r125 = r124.f295323a;
        if (r125 == null) goto L74;
        List<w> r126 = r125;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator<T> r128 = r126.iterator();
    L71:
        if (r128.hasNext() == false) goto L73;
        r127.add(w.a((w) r128.next(), null, null, 0, null, null, null, 8126463));
        goto L71
    L73:
        r124.f295323a = CollectionsKt.toMutableList(r127);
        this.f311997q = null;
        this.f311998r = -1;
        q();
    L74:
        j();
        return;
    L76:
        if ((r110 instanceof cq8.t) == false) goto L95;
        cq8.t r129 = (cq8.t) r110;
        com.larus.bmhome.actionbar.model.n r130 = this.f311996p;
        if (r130 == null) goto L80;
        r130.f295323a = CollectionsKt.toMutableList(r129.f464957c);
    L80:
        this.f311998r = -1;
        q();
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.n) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.n.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L24;
        com.larus.bmhome.actionbar.model.n r105 = (com.larus.bmhome.actionbar.model.n) r103;
        this.f311996p = r105;
        if (r105 == null) goto L20;
        TemplateInfo$TemplateInfo r106 = r105.f295327e;
    L21:
        this.f311997q = r106;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        r106 = null;
        goto L21
    L24:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "image list selector is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void p(Long r110) {
        com.larus.bmhome.actionbar.model.n r100 = this.f311996p;
        if (r100 == null) goto L29;
        List<w> r101 = r100.f295323a;
        if (r101 == null) goto L30;
        List<w> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r104.hasNext() == false) goto L21;
        Object r107 = r104.next();
        int r108 = r105 + 1;
        if (r105 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        w r109 = (w) r107;
        Long r111 = r109.f295510a;
        if (r111 == null) goto L16;
        Long r112 = Long.valueOf(r111.longValue());
    L17:
        boolean r113 = Intrinsics.areEqual(r112, r110);
        if (r113 == false) goto L20;
        r106 = r105;
    L20:
        r103.add(w.a(r109, null, null, Integer.valueOf(r113 ? 1 : 0), null, null, null, 8126463));
        r105 = r108;
        goto L9
    L16:
        r112 = null;
        goto L17
    L21:
        List<w> r114 = CollectionsKt.toMutableList(r103);
        com.larus.bmhome.actionbar.model.n r115 = this.f311996p;
        if (r115 == null) goto L24;
        r115.f295323a = r114;
    L24:
        this.f311998r = r106;
        q();
        return;
    L30:
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, "defaultStateTemplate");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.n) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.n.Companion.serializer(), r210));     // Catch: Throwable -> L5
    L7:
        String r102 = null;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        com.larus.bmhome.actionbar.model.n r103 = (com.larus.bmhome.actionbar.model.n) r101;
        if (r103 != null) goto L13;
        return;
    L13:
        List<w> r104 = r103.f295323a;
        if (r104 == null) goto L18;
        w r105 = (w) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L18;
        Long r106 = r105.f295510a;
    L19:
        o(new com.larus.bmhome.instruction.core.impl.base.k.e(r106));
        List<w> r107 = r103.f295323a;
        if (r107 == null) goto L35;
        Iterator<T> r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L35;
        w r109 = (w) r108.next();
        com.larus.bmhome.actionbar.model.n r110 = this.f311996p;
        if (r110 == null) goto L23;
        List<w> r111 = r110.f295323a;
        if (r111 == null) goto L23;
        Iterator<T> r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L23;
        w r113 = (w) r112.next();
        if (Intrinsics.areEqual(r113.f295510a, r109.f295510a) == true) goto L33;
        r113.f295528s = 0;
        goto L30
    L33:
        r113.f295528s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        c0.f348199b.d("ImageTemplateSelectorWithMoreController", "hit restore option id:" + r109.f295510a + ", option name:" + r113.f295511b);
    L35:
        TemplateInfo$TemplateInfo r114 = r103.f295327e;
        if (r114 == null) goto L73;
        long r115 = r114.f365416a;
        TemplateInfo$TemplateImage r116 = r114.f365420e;
        if (r116 == null) goto L40;
        String r117 = r116.f365410a;
    L41:
        long r118 = 0;
        if (r116 == null) goto L44;
        long r119 = r116.f365411b;
    L45:
        if (r116 == null) goto L47;
        long r120 = r116.f365412c;
    L48:
        TemplateInfo$TemplateImage r121 = new TemplateInfo$TemplateImage(r117, r119, r120);
        TemplateInfo$TemplateImage r122 = r114.f365419d;
        if (r122 == null) goto L51;
        r102 = r122.f365410a;
    L51:
        String r123 = r102;
        if (r122 == null) goto L54;
        long r124 = r122.f365411b;
    L55:
        if (r122 == null) goto L57;
        r118 = r122.f365412c;
    L57:
        this.f311997q = new TemplateInfo$TemplateInfo(r115, null, new TemplateInfo$TemplateImage(r123, r124, r118), r121, null, 0, 0, 0, null, 998);
        return;
    L54:
        r124 = 0;
        goto L55
    L47:
        r120 = 0;
        goto L48
    L44:
        r119 = 0;
        goto L45
    L40:
        r117 = null;
        goto L41
    L73:
        return;
    L18:
        r106 = null;
    L5:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
