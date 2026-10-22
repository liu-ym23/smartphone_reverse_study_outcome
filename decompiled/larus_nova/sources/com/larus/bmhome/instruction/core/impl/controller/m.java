package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.p1;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.i0;
import cq8.j0;
import cq8.y;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p1 f312003p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f312004q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f312005r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f312006s;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public m() {
        super("MsgInstructionController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new j0(getWidgetId(), this.f311933o, this.f312003p, this.f312004q);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r100 = null;
        if (this.f312003p != null) goto L5;
        return null;
    L5:
        if (this.f312005r == false) goto L7;
    L9:
        this.f312006s = false;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        Object r102 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(p1.Companion.serializer()), this.f312003p));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r102) == true) goto L18;
        r100 = r102;
    L18:
        String r103 = (String) r100;
        c0.f348199b.i("MsgInstructionController", "collectData result is " + r103);
        return r103;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L7:
        if (this.f312006s == true) goto L9;
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L5:
        this.f312004q = r101;
        return;
    L4:
        r101 = 0;
        goto L5
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        p1 r101 = this.f312003p;
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
        c0.f348199b.i("MsgInstructionController", "onRestoreComponentStateByDefaultParams: select:" + r110);
        this.f312006s = Intrinsics.areEqual(r110, r104);
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

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof i0) == false) goto L9;
        this.f312005r = ((i0) r100).f464854c;
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
        Object r103 = Result.m9449constructorimpl((p1) xt7.d.f565073b.c(p1.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f312003p = (p1) r103;
        c0.f348199b.i("MsgInstructionController", "msgInstructionItem is " + this.f312003p);
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "msg instruction is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
