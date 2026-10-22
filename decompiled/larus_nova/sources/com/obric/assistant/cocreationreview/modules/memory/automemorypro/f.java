package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.c1;
import hda.e1;
import hda.p0;
import hda.s0;
import hda.t1;
import hda.u;
import hda.u0;
import hda.u1;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends s0<i> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f387412b = null;

    static {
        f387412b = new f();
    }

    public f() {
        super(c.f387410a);
    }

    public static String m(e1 r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100.f484673s));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        JSONObject r103 = (JSONObject) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        String r104 = p0.b(r103, "ruleTitle");
        if (r104 != null) goto L24;
        r104 = p0.b(r103, "rule_title");
        if (r104 != null) goto L24;
        r104 = p0.b(r103, "ruleName");
        if (r104 != null) goto L24;
        r104 = p0.b(r103, com.heytap.mcssdk.constant.b.f276366p);
        if (r104 != null) goto L24;
        r104 = p0.b(r103, "taskName");
        if (r104 != null) goto L24;
        r104 = p0.b(r103, "memoryTaskName");
    L24:
        return c1.a(r104);
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String n(String r100) {
        String r101 = CollectionsKt.joinToString$default(StringsKt.lines(r100), " ", null, null, 0, null, new e(), 30, null);
        return StringsKt.trim(new Regex("\\s+").replace(r101, " ")).toString();
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387424k;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return u0.b(r101.f387423j);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387417d;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final String e(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387421h;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387420g;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final List i(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return CollectionsKt.plus(super.i(r101), CollectionsKt.listOfNotNull(u1.b(r101.f387423j)));
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final int j(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        e1 r102 = r101.f387423j;
        Intrinsics.checkNotNullParameter(r102, "uiModel");
        return RangesKt.coerceIn(u1.a(r102) - 1, 0, 2);
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387418e;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r110, a5 r111) {
        i r112 = (i) r110;
        Intrinsics.checkNotNullParameter(r112, "record");
        Intrinsics.checkNotNullParameter(r111, "feedback");
        int r100 = u.f484757a;
        l5 r101 = c.f387410a;
        String r102 = r112.f387414a;
        String r103 = r112.f387420g;
        String r104 = r112.f387417d;
        e1 r105 = r112.f387423j;
        return u.f(r101, r102, r103, r104, r111, r105, true, t1.a(r105.f484661g, null), new AutoMemoryProRecordPresenter$detailView$1(this), new AutoMemoryProRecordPresenter$detailView$2(this), null, 4224);
    }
}
