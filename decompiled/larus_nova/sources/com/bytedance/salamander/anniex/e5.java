package com.bytedance.salamander.anniex;

import androidx.camera.video.AudioStats;
import com.lynx.tasm.LynxError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e5 implements w2<d5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.salamander.adapter.e f268046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c5 f268047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super d5, Unit> f268048c;

    @Override // com.bytedance.salamander.anniex.w2
    public final void a(d5 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.bytedance.salamander.adapter.e r101 = this.f268046a;
        com.bytedance.salamander.adapter.e r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lock");
        r101 = null;
    L5:
        r101.a();
        c5 r103 = this.f268047b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("diskStorage");
        r103 = null;
    L8:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        int r104 = com.bytedance.salamander.adapter.r.f267796a;
        RedirectRuleStorage$save$1 r105 = new RedirectRuleStorage$save$1(r100);
        com.bytedance.salamander.adapter.i r106 = com.bytedance.salamander.adapter.i.f267785d;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.salamander.adapter.Queue");
        com.bytedance.salamander.adapter.r.a.a(r105, r106, AudioStats.AUDIO_AMPLITUDE_NONE);
        Function1<? super d5, Unit> r107 = this.f268048c;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("updateCache");
        r107 = null;
    L11:
        r107.invoke(r100);
        com.bytedance.salamander.adapter.e r108 = this.f268046a;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("lock");
    L15:
        r102.b();
        return;
    L14:
        r102 = r108;
        goto L15
    }

    @Override // com.bytedance.salamander.anniex.w2
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.anniex.bd.foundation.impl.i r101 = com.bytedance.anniex.bd.foundation.impl.a.f190139a;
        String r102 = r100.getMessage();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.b("AnnieXRedirectTag", "refreshCache failed: ".concat(r102));
    }

    public e5(com.bytedance.salamander.adapter.e r100, c5 r101, Function1<? super d5, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "lock");
        Intrinsics.checkNotNullParameter(r101, "diskStorage");
        Intrinsics.checkNotNullParameter(r102, "updateCache");
        this.f268046a = r100;
        this.f268047b = r101;
        this.f268048c = r102;
    }
}
