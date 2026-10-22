package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f299418a;

    public f(e r100) {
        this.f299418a = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f299418a.f299403f == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ChatSpeakerPressLifecycle", "[" + this.f299418a.f299401d + "][ChatSpeakerStateListener]: receive new state: " + r100);
        if (Intrinsics.areEqual(r100, g.c.f299421a) == false) goto L9;
        e r101 = this.f299418a;
        r101.f299406i = true;
        r101.c(e.c.C4035e.f299412a);
        return;
    L9:
        if ((r100 instanceof g.d) == false) goto L12;
        g.d r102 = (g.d) r100;
        this.f299418a.f299404g = r102.f299422a.length();
        this.f299418a.c(new e.c.f(r102.f299422a));
        return;
    L12:
        if ((r100 instanceof g.e) == false) goto L15;
        e r103 = this.f299418a;
        g.e r104 = (g.e) r100;
        r103.c(new e.c.g(r104.f299423a, r103.f299404g, r104.f299424b));
        this.f299418a.d("speaker_success");
        return;
    L15:
        if (Intrinsics.areEqual(r100, g.b.f299420a) == false) goto L18;
        this.f299418a.c(e.c.b.f299409a);
        this.f299418a.d("speaker_failed");
        return;
    L18:
        if (Intrinsics.areEqual(r100, g.a.f299419a) == false) goto L22;
        e r105 = this.f299418a;
        r105.getClass();
        r105.c(e.c.a.f299408a);
        r105.d("speaker_canceled");
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
