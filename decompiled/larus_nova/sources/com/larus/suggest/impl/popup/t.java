package com.larus.suggest.impl.popup;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f369902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z3 f369903b;

    public t(String r100, z3 r101) {
        this.f369902a = r100;
        this.f369903b = r101;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r110, com.larus.video.impl.sdk.a r111) {
        if (Intrinsics.areEqual(this.f369902a, r110) == false) goto L13;
        FLogger r112 = FLogger.f375446a;
        StringBuilder r100 = new StringBuilder("start preload video ");
        Float r101 = null;
        if (r111 == null) goto L7;
        Float r102 = Float.valueOf(r111.b());
    L8:
        r100.append(r102);
        r100.append('-');
        if (r111 == null) goto L11;
        r101 = Float.valueOf(r111.a());
    L11:
        r100.append(r101);
        r112.i("NexPulseDialogManager", r100.toString());
        z3.a.a(this.f369903b, r111, null, 30720000, new s(), 10);
        return;
    L7:
        r102 = null;
        goto L8
    }
}
