package com.larus.uaigc.image.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.l;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f373082l;

    @Override // up8.b
    public int getType() {
        return 6;
    }

    @Override // up8.d
    public final boolean a() {
        l r100 = this.f373082l;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295272c, Boolean.TRUE);
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

    @Override // up8.d
    public final String g() {
        l r100 = this.f373082l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295270a;
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
        l r109 = this.f373082l;
        if (r109 == null) goto L29;
        l r110 = new l(r104, r109.f295271b, r109.f295272c);
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(l.Companion.serializer()), r110));     // Catch: Throwable -> L32
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

    public a() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ImageListSelectorWidget(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((l) xt7.d.f565073b.c(l.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L34;
        l r106 = (l) r104;
        if (r106 == null) goto L21;
        List<w> r107 = r106.f295270a;
    L22:
        List<w> r108 = r107;
        if (r108 != null) goto L25;
    L28:
        if (r101 == true) goto L30;
        this.f373082l = r106;
        return new a0(Boolean.TRUE, "");
    L30:
        return new a0(Boolean.FALSE, "imageList is empty");
    L25:
        if (r108.isEmpty() == true) goto L28;
        r101 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L34:
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
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((l) xt7.d.f565073b.c(l.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        l r104 = (l) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<w> r105 = r104.f295270a;
        if (r105 == null) goto L29;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L44;
        w r107 = (w) r106.next();
        l r108 = this.f373082l;
        if (r108 == null) goto L17;
        List<w> r109 = r108.f295270a;
        if (r109 == null) goto L17;
        Iterator<T> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L17;
        w r111 = (w) r110.next();
        if (Intrinsics.areEqual(r111.f295510a, r107.f295510a) == true) goto L27;
        r111.f295528s = 0;
        goto L24
    L27:
        r111.f295528s = 1;
        goto L24
    L44:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
