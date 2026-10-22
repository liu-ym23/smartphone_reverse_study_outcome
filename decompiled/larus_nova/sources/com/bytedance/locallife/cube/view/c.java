package com.bytedance.locallife.cube.view;

import android.view.View;
import com.bytedance.locallife.biz.base.cube.p;
import com.lynx.tasm.LynxView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f257279a;

    public c(LynxView r100) {
        this.f257279a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LynxView r101 = this.f257279a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.locallife.cube.c.f();     // Catch: Throwable -> L5
        p.f256548a.f(r101);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
