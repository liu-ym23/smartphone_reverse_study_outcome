package com.larus.voicecall.impl.component.bottom;

import com.larus.av_call.util.RealtimeBottomMoreBtn;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class w implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f377270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RealtimeBottomComponent f377271b;

    public /* synthetic */ w(boolean r100, RealtimeBottomComponent r101) {
        this.f377270a = r100;
        this.f377271b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        boolean r101 = this.f377270a;
        RealtimeBottomComponent r102 = this.f377271b;
        RealtimeBottomMoreBtn r103 = (RealtimeBottomMoreBtn) r100;
        int r104 = RealtimeBottomComponent.Q;
        Intrinsics.checkNotNullParameter(r103, "it");
        if (r101 == false) goto L7;
        r102.getClass();
        com.larus.voicecall.impl.component.vlm.a r105 = (com.larus.voicecall.impl.component.vlm.a) s1a.d.a(r102).getAbility(com.larus.voicecall.impl.component.vlm.a.class);
        if (r105 == null) goto L11;
        r105.Yh(true, "click_share_screen");
    L11:
        return Unit.INSTANCE;
    L7:
        com.larus.voicecall.impl.component.window.b r106 = (com.larus.voicecall.impl.component.window.b) r102.f377195z.getValue();
        if (r106 == null) goto L11;
        r106.oB(r103);
        goto L11
    }
}
