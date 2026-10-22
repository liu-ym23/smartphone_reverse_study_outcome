package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.platform.api.k0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes31.dex */
public final class s implements k0 {
    public s() {
    }

    @Override // com.larus.platform.api.k0
    public final void a(yq9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        int r101 = r100.f568867a;
        String r102 = "user_package";
        String r103 = null;
        if (r101 != 2) goto L5;
        FLogger.f375446a.i("NexPulseDialogManager", "preload video success " + r100.f568868b);
        StateFlowImpl r104 = q.f369897b;
        b1 r105 = q.f369898c;
        e r106 = (e) r105.getValue();
        if (r106 == null) goto L24;
        NexPulseCandidate r107 = r106.f369874a;
    L25:
        e r108 = (e) r105.getValue();
        if (r108 == null) goto L28;
        r103 = r108.f369876c;
    L28:
        e r109 = (e) r105.getValue();
        if (r109 == null) goto L34;
        String r110 = r109.f369877d;
        if (r110 == null) goto L34;
        r102 = r110;
    L34:
        r104.setValue(new e(r107, true, r103, r102));
        return;
    L24:
        r107 = null;
        goto L25
    L5:
        if (r101 != 3) goto L37;
        FLogger.f375446a.e("NexPulseDialogManager", "preload video failed, videoCoverLoaded=" + q.f369899d);
        StateFlowImpl r111 = q.f369897b;
        b1 r112 = q.f369898c;
        e r113 = (e) r112.getValue();
        if (r113 == null) goto L10;
        NexPulseCandidate r114 = r113.f369874a;
    L11:
        boolean r115 = q.f369899d;
        e r116 = (e) r112.getValue();
        if (r116 == null) goto L14;
        r103 = r116.f369876c;
    L14:
        e r117 = (e) r112.getValue();
        if (r117 == null) goto L20;
        String r118 = r117.f369877d;
        if (r118 == null) goto L20;
        r102 = r118;
    L20:
        r111.setValue(new e(r114, r115, r103, r102));
        return;
    L10:
        r114 = null;
        goto L11
    }
}
