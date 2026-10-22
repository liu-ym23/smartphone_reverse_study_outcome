package com.larus.office.plugins.preview;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g0 implements com.larus.bmhome.chat.component.bottom.core.speaker.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f363182a;

    public g0(s r100) {
        this.f363182a = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
    public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        s r101 = this.f363182a;
        if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.f299421a) == false) goto L5;
    L17:
        boolean r102 = true;
    L18:
        r101.f363237o = r102;
        if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L21;
        this.f363182a.f363229g.b(((com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r100).f299423a, true);
    L21:
        this.f363182a.c(false);
        return;
    L5:
        if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == true) goto L17;
        if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L10;
    L16:
        r102 = false;
        goto L18
    L10:
        if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.f299419a) == true) goto L16;
        if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.f299420a) == true) goto L16;
        throw new NoWhenBranchMatchedException();
    }
}
