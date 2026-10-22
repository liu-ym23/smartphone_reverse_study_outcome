package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.e1;
import hda.j0;
import hda.s0;
import hda.u;
import hda.u1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends s0<g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f387442b = null;

    static {
        f387442b = new e();
    }

    public e() {
        super(c.f387440a);
    }

    public static List m(e1 r100) {
        j0[] r101 = new j0[2];
        String r102 = r100.f484661g;
        j0 r103 = null;
        if ((!StringsKt.isBlank(r102)) == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        r103 = new j0("内容时间", r102);
    L8:
        r101[0] = r103;
        if (r100.f484671q > 0) goto L11;
        String r104 = "新增";
    L12:
        r101[1] = new j0("状态", r104);
        return CollectionsKt.listOfNotNull(r101);
    L11:
        r104 = "更新";
        goto L12
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387454k;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r110) {
        g r111 = (g) r110;
        Intrinsics.checkNotNullParameter(r111, "record");
        String r100 = r111.f387449f;
        String r112 = r111.f387450g;
        com.obric.assistant.cocreationreview.c[] r101 = new com.obric.assistant.cocreationreview.c[2];
        com.obric.assistant.cocreationreview.c r102 = null;
        if (r100 != null) goto L5;
    L10:
        com.obric.assistant.cocreationreview.c r113 = null;
    L11:
        r101[0] = r113;
        if (r112 != null) goto L14;
    L19:
        r101[1] = r102;
        return CollectionsKt.listOfNotNull(r101);
    L14:
        if ((!StringsKt.isBlank(r112)) == true) goto L17;
        r112 = null;
    L17:
        if (r112 == null) goto L19;
        r102 = new com.obric.assistant.cocreationreview.c("子类 ".concat(r112), CardTemplateTagTone.NEUTRAL, null, null, null, null, null, 252);
        goto L19
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r113 = new com.obric.assistant.cocreationreview.c("分类 ".concat(r100), CardTemplateTagTone.NEUTRAL, null, null, null, null, null, 252);
        goto L11
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387447d;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387451h;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final List i(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return CollectionsKt.plus(super.i(r101), CollectionsKt.listOfNotNull(u1.b(r101.f387453j)));
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final int j(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        e1 r102 = r101.f387453j;
        Intrinsics.checkNotNullParameter(r102, "uiModel");
        return RangesKt.coerceIn(u1.a(r102) - 1, 0, 2);
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387448e;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r100) {
        Intrinsics.checkNotNullParameter((g) r100, "record");
        return null;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r110, a5 r111) {
        g r112 = (g) r110;
        Intrinsics.checkNotNullParameter(r112, "record");
        Intrinsics.checkNotNullParameter(r111, "feedback");
        int r100 = u.f484757a;
        l5 r101 = c.f387440a;
        String r102 = r112.f387444a;
        String r103 = r112.f387451h;
        String r104 = r112.f387447d;
        e1 r105 = r112.f387453j;
        return u.f(r101, r102, r103, r104, r111, r105, true, m(r105), new PersonalMemoryRecordPresenter$detailView$1(this), null, null, 7168);
    }
}
