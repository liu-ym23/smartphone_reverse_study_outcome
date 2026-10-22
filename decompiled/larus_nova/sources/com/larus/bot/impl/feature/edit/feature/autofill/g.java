package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.common_ui.dialog.u;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import tx9.c0;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BotAutoFillUIBinder f318446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Job> f318447b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f318446a.f318403c.dispatchUIAction(new a.b(false));
        BotAutoFillUIBinder r100 = this.f318446a;
        dv8.b r101 = r100.f318404d;
        if (r101 == null) goto L5;
        c0.I(r101.f(), r100.f318404d.d(), r100.f318404d.o(), r100.f318404d.c(), "auto_fill_skip", "auto_fill", r100.f318404d.i(), r100.f318404d.h(), r100.f318401a, 513);
    L5:
        Job r102 = this.f318447b.element;
        if (r102 == null) goto L9;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
        return;
    }

    public g(BotAutoFillUIBinder r100, Ref.ObjectRef<Job> r101) {
        this.f318446a = r100;
        this.f318447b = r101;
    }
}
