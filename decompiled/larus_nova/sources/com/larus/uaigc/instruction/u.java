package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p1 f373427l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f373428m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f373429n;

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
        return 4;
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f373427l == null) goto L26;
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f551063c;
        if (r101 == null) goto L7;
        p1 r102 = r101.getChosenMsgInstruction();
    L9:
        if (Intrinsics.areEqual(r102, this.f373427l) == false) goto L11;
    L13:
        this.f373429n = false;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        Object r104 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(p1.Companion.serializer()), this.f373427l));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r104) == true) goto L22;
        r100 = r104;
    L22:
        String r105 = (String) r100;
        FLogger.f375446a.i("MsgInstructionController", "collectData result is " + r105);
        return r105;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L11:
        if (this.f373429n == true) goto L13;
        return null;
    L7:
        r102 = null;
        goto L9
    L26:
        return null;
    }

    public u() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new MsgInstructionWidget(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        p1 r101 = this.f373427l;
        Map r102 = null;
        if (r101 == null) goto L7;
        Integer r103 = r101.f295383a;
        if (r103 == null) goto L7;
        String r104 = r103.toString();
    L8:
        Object r105 = r100.get(String.valueOf(getType()));
        if ((r105 instanceof Map) == false) goto L11;
        Map r106 = (Map) r105;
    L12:
        if (r106 == null) goto L14;
        Object r107 = r106.get(String.valueOf(4));
    L16:
        if ((r107 instanceof Map) == false) goto L18;
        Map r108 = (Map) r107;
    L19:
        if (r108 == null) goto L21;
        Object r109 = r108.get("match_all_id");
    L23:
        if ((r109 instanceof Map) == false) goto L25;
        r102 = (Map) r109;
    L25:
        if (r102 == null) goto L30;
        Object r110 = r102.get("default_select_id");
        if (r110 == null) goto L31;
        FLogger.f375446a.d("MsgInstructionController", "onReStoreComponentStateByDefaultParams: select:" + r110);
        this.f373429n = Intrinsics.areEqual(r110, r104);
        return;
    L31:
        return;
    L30:
        return;
    L21:
        r109 = null;
        goto L23
    L18:
        r108 = null;
        goto L19
    L14:
        r107 = null;
        goto L16
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // up8.b
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((p1) xt7.d.f565073b.c(p1.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f373427l = (p1) r103;
        FLogger.f375446a.i("MsgInstructionController", "msgInstructionItem is " + this.f373427l);
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // up8.b
    public final void q(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L5:
        this.f373428m = r101;
        return;
    L4:
        r101 = 0;
        goto L5
    }
}
