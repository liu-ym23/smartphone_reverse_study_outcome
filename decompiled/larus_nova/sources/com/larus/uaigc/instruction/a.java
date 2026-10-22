package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public wa8.a f373334l;

    /* JADX INFO: renamed from: com.larus.uaigc.instruction.a$a, reason: collision with other inner class name */
    public static final class C4510a {
    }

    static {
    }

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
        return 8;
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
    }

    @Override // up8.d
    public final String g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(wa8.a.Companion.serializer()), this.f373334l));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        FLogger.f375446a.i("AvatarTemplateController", "collectData is " + r102);
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public a() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new AvatarTemplateWidget(r100);
    }

    @Override // up8.b
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((wa8.a) xt7.d.f565073b.c(wa8.a.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        wa8.a r105 = (wa8.a) r103;
        this.f373334l = r105;
        FLogger.f375446a.i("AvatarTemplateController", "avtarInstructionItem is " + r105);
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "avatar template instruction item is empty");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
