package com.larus.audio.call.plugins;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g extends com.larus.im.service.audio.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f289465b;

    @Override // com.larus.im.service.audio.z0
    public final String g() {
        return this.f289464a;
    }

    public g(h r100) {
        this.f289465b = r100;
        this.f289464a = "RealtimeCallAudioFrameSender#eventListener";
    }

    @Override // com.larus.im.service.audio.z0
    public final void n(com.larus.im.service.audio.z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof pf9.z) == false) goto L5;
        h r101 = this.f289465b;
        r101.f289476j = -1;
        r101.f289477k = "";
        return;
    L5:
        boolean r102 = true;
        if ((r100 instanceof pf9.e0) == false) goto L9;
        this.f289465b.f289475i.b(true, "ReplyEnd");
        return;
    L9:
        if ((r100 instanceof pf9.d0) == false) goto L12;
        h r103 = this.f289465b;
        r103.f289476j = SystemClock.elapsedRealtime();
        return;
    L12:
        if ((r100 instanceof pf9.f0) == false) goto L20;
        String r104 = pf9.i.k((pf9.f0) r100);
        if (r104.length() > 0) goto L17;
        r102 = false;
    L17:
        if (r102 == false) goto L26;
        this.f289465b.f289477k = r104;
        return;
    L26:
        return;
    L20:
        if ((r100 instanceof pf9.i0) == false) goto L28;
        this.f289465b.f289475i.b(true, "SceneSwitched");
        return;
    }
}
