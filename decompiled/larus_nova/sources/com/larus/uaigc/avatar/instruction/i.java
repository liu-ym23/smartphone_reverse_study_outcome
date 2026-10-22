package com.larus.uaigc.avatar.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import wa8.a0;

/* JADX INFO: loaded from: classes31.dex */
public final class i extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f370323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.f f370324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.e f370325n;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 12;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f370325n != null) goto L5;
        return null;
    L5:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        com.larus.bmhome.actionbar.model.e r102 = this.f370325n;
        boolean r103 = false;
        if (r102 == null) goto L21;
        List<com.larus.bmhome.actionbar.model.f> r104 = r102.f295081c;
        if (r104 == null) goto L21;
        ?? r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L11:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        Integer r108 = ((com.larus.bmhome.actionbar.model.f) r107).f295108h;
        if (r108 != null) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r109 == false) goto L11;
        r105.add(r107);
        goto L11
    L16:
        if (r108.intValue() != 1) goto L18;
        r109 = true;
    L22:
        r101.element = r105;
        if (r105 != 0) goto L25;
    L26:
        r103 = true;
    L27:
        if (r103 == false) goto L32;
        com.larus.bmhome.actionbar.model.f r110 = this.f370324m;
        if (r110 == null) goto L31;
        ?? r111 = new ArrayList();
        r111.add(new com.larus.bmhome.actionbar.model.f(r110.f295101a, r110.f295103c, r110.f295105e, r110.f295106f, null, 1, 74));
        r101.element = r111;
        goto L32
    L31:
        return null;
    L32:
        com.larus.bmhome.actionbar.model.e r112 = this.f370325n;
        if (r112 == null) goto L35;
        com.larus.bmhome.actionbar.model.e r113 = new com.larus.bmhome.actionbar.model.e(r112.f295079a, r112.f295080b, (List) r101.element, r112.f295082d, r112.f295083e);
    L46:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L38
        Object r115 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.e.Companion.serializer()), r113));     // Catch: Throwable -> L38
    L41:
        if (Result.m9455isFailureimpl(r115) == true) goto L45;
        r100 = r115;
    L45:
        return (String) r100;
    L38:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L35:
        r113 = null;
        goto L46
    L25:
        if (r105.isEmpty() == false) goto L27;
    L21:
        r105 = 0;
        goto L22
    }

    public i() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new DigitalAvatarTemplateListSelectorWidget(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.e) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.e.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L28;
        com.larus.bmhome.actionbar.model.e r106 = (com.larus.bmhome.actionbar.model.e) r104;
        List<w> r107 = r106.f295080b;
        if (r107 == null) goto L25;
        w r108 = (w) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L25;
        if (r108.f295519j != true) goto L25;
        r101 = true;
    L25:
        this.f370323l = r101;
        this.f370325n = r106;
        return new a0(Boolean.TRUE, "");
    L28:
        return new a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "defaultStateTemplate");
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L5
        Object r113 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.e) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.e.Companion.serializer(), r110));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r113) == false) goto L10;
        r113 = null;
    L10:
        com.larus.bmhome.actionbar.model.e r114 = (com.larus.bmhome.actionbar.model.e) r113;
        if (r114 != null) goto L13;
        return;
    L13:
        List<com.larus.bmhome.actionbar.model.f> r115 = r114.f295081c;
        if (r115 == null) goto L29;
        Iterator<T> r116 = r115.iterator();
    L17:
        if (r116.hasNext() == false) goto L29;
        com.larus.bmhome.actionbar.model.f r100 = (com.larus.bmhome.actionbar.model.f) r116.next();
        com.larus.bmhome.actionbar.model.e r101 = this.f370325n;
        if (r101 == null) goto L17;
        List<com.larus.bmhome.actionbar.model.f> r102 = r101.f295081c;
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
    L24:
        if (r103.hasNext() == false) goto L17;
        com.larus.bmhome.actionbar.model.f r104 = (com.larus.bmhome.actionbar.model.f) r103.next();
        if (r104.f295101a == r100.f295101a) goto L27;
        r104.f295108h = 0;
        goto L24
    L27:
        r104.f295108h = 1;
    L29:
        com.larus.bmhome.actionbar.model.f r117 = r114.f295083e;
        if (r117 == null) goto L47;
        long r105 = r117.f295101a;
        g1 r106 = r117.f295105e;
        g1 r107 = r117.f295106f;
        this.f370324m = new com.larus.bmhome.actionbar.model.f(r105, r117.f295103c, r106, r107, null, 1, 74);
        return;
    L47:
        return;
    L5:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
