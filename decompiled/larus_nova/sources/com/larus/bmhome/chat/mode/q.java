package com.larus.bmhome.chat.mode;

import android.os.Looper;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class q implements fx9.a.InterfaceC5960a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ModeSwitchComponent f307431a;

    public /* synthetic */ q(ModeSwitchComponent r100) {
        this.f307431a = r100;
    }

    @Override // fx9.a.InterfaceC5960a
    public final void a(String r100, final int r101, final int r102) {
        final ModeSwitchComponent r103 = this.f307431a;
        String r104 = r103.M;
        if (r104 != null) goto L5;
    L9:
        r103.M = r100;
        r103.N = r102;
        final l0 r105 = r103.f307355u;
        if (r105 == null) goto L21;
        Runnable r106 = new x(r103, r105, r101, r102);
        if (com.larus.platform.exp.o.a() == true) goto L15;
    L17:
        r105.post(r106);
        return;
    L15:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        r106.run();
        return;
    L21:
        return;
    L5:
        if (Intrinsics.areEqual(r100, r104) == true) goto L9;
        if (r102 == 0) goto L8;
        if (r101 <= 0) goto L9;
    L8:
        FLogger.f375446a.i("ModeSwitchComponent", "ignore stale wcb sug height localMessageId=" + r100 + " currentLocalMessageId=" + r103.M);
    }
}
