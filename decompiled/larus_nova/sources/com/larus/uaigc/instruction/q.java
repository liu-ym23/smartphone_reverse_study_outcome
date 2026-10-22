package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.h f373422l;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 8;
    }

    @Override // up8.b
    public final int i() {
        return 6;
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.h r100 = this.f373422l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<com.larus.bmhome.actionbar.model.w> r102 = r100.f295167e;
        boolean r103 = false;
        if (r102 == null) goto L20;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        Integer r107 = ((com.larus.bmhome.actionbar.model.w) r106).f295528s;
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
        goto L17
    L19:
        ArrayList r110 = r104;
    L21:
        if (r110 != null) goto L23;
    L24:
        r103 = true;
    L25:
        if (r103 == false) goto L27;
        return null;
    L27:
        com.larus.bmhome.actionbar.model.h r109 = this.f373422l;
        if (r109 == null) goto L30;
        com.larus.bmhome.actionbar.model.h r111 = com.larus.bmhome.actionbar.model.h.a(r109, null, null, null, r110, null, null, 4079);
    L41:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L33
        Object r113 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r111));     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r113) == true) goto L40;
        r101 = r113;
    L40:
        return (String) r101;
    L33:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L30:
        r111 = null;
        goto L41
    L23:
        if (r110.isEmpty() == false) goto L25;
    L20:
        r110 = null;
        goto L21
    }

    public q() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new DropFeatureSelectorWidget(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        if ((r101 instanceof Map) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        if (r102 == null) goto L8;
        Object r103 = r102.get(String.valueOf(6));
    L10:
        if ((r103 instanceof Map) == false) goto L12;
        Map r104 = (Map) r103;
    L13:
        if (r104 == null) goto L16;
        Object r105 = r104.get(null);
        if (r105 == null) goto L16;
    L20:
        if ((r105 instanceof Map) == false) goto L22;
        Map r106 = (Map) r105;
    L23:
        if (r106 == null) goto L43;
        Object r107 = r106.get("default_select_id");
        if (r107 == null) goto L52;
        com.larus.bmhome.actionbar.model.h r108 = this.f373422l;
        if (r108 == null) goto L53;
        List<com.larus.bmhome.actionbar.model.w> r109 = r108.f295167e;
        if (r109 == null) goto L54;
        Iterator<T> r110 = r109.iterator();
    L32:
        if (r110.hasNext() == false) goto L55;
        com.larus.bmhome.actionbar.model.w r111 = (com.larus.bmhome.actionbar.model.w) r110.next();
        Long r112 = r111.f295510a;
        if (r112 == null) goto L36;
        String r113 = r112.toString();
    L38:
        if (Intrinsics.areEqual(r113, r107) == true) goto L39;
        r111.f295528s = 0;
        goto L32
    L39:
        r111.f295528s = 1;
        com.larus.bmhome.view.actionbar.edit.c r114 = this.f551063c;
        if (r114 == null) goto L32;
        r114.setImageStyleRadioSelected(true);
        goto L32
    L36:
        r113 = null;
        goto L38
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L43:
        return;
    L22:
        r106 = null;
    L16:
        if (r104 == null) goto L18;
        r105 = r104.get("match_all_id");
        goto L20
    L18:
        r105 = null;
        goto L20
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // up8.b
    public final wa8.a0 n(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L34;
        com.larus.bmhome.actionbar.model.h r106 = (com.larus.bmhome.actionbar.model.h) r104;
        if (r106 == null) goto L21;
        List<com.larus.bmhome.actionbar.model.w> r107 = r106.f295167e;
    L22:
        List<com.larus.bmhome.actionbar.model.w> r108 = r107;
        if (r108 != null) goto L25;
    L28:
        if (r101 == true) goto L30;
        this.f373422l = r106;
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r108.isEmpty() == true) goto L28;
        r101 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L34:
        return new wa8.a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "style feature selector box is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r104 = (com.larus.bmhome.actionbar.model.h) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<com.larus.bmhome.actionbar.model.w> r105 = r104.f295167e;
        if (r105 == null) goto L31;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L48;
        com.larus.bmhome.actionbar.model.w r107 = (com.larus.bmhome.actionbar.model.w) r106.next();
        com.larus.bmhome.actionbar.model.h r108 = this.f373422l;
        if (r108 == null) goto L17;
        List<com.larus.bmhome.actionbar.model.w> r109 = r108.f295167e;
        if (r109 == null) goto L17;
        Iterator<T> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L17;
        com.larus.bmhome.actionbar.model.w r111 = (com.larus.bmhome.actionbar.model.w) r110.next();
        if (Intrinsics.areEqual(r111.f295510a, r107.f295510a) == true) goto L27;
        r111.f295528s = 0;
        goto L24
    L27:
        r111.f295528s = 1;
        com.larus.bmhome.view.actionbar.edit.c r112 = this.f551063c;
        if (r112 == null) goto L24;
        r112.setImageStyleRadioSelected(true);
        goto L24
    L48:
        return;
    L31:
        return;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
