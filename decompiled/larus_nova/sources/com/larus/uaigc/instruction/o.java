package com.larus.uaigc.instruction;

import android.view.ViewTreeObserver;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f373420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AvatarTemplateWidget f373421b;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.uaigc.instruction.l] */
    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
    L16:
        th = move-exception;
        FLogger.f375446a.w("avatar_template_widget", th.getLocalizedMessage());
        return;
    L3:
        if (this.f373420a == false) goto L5;
        return;
    L5:
        final AvatarTemplateWidget r100 = this.f373421b;     // Catch: Throwable -> L16
        final ?? r101 = new l(this, r100);     // Catch: Throwable -> L16
        LarusItemActionBarAvatarInstructionBinding r102 = r100.f373287g;     // Catch: Throwable -> L16
        String r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L16
        r102 = null;
    L8:
        CharSequence r104 = r102.f373158b.getText();     // Catch: Throwable -> L16
        if (r104 == null) goto L12;
        r103 = r104.toString();     // Catch: Throwable -> L16
    L12:
        if (o0.d(r103) == false) goto L14;
        r101.invoke();     // Catch: Throwable -> L16
        return;
    L14:
        this.f373421b.postDelayed(new m(r101), 1000);     // Catch: Throwable -> L16
    }

    public o(AvatarTemplateWidget r100) {
        this.f373421b = r100;
    }
}
