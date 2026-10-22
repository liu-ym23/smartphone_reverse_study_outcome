package com.larus.im.internal.audio.session.v1.sami;

import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.internal.audio.u;
import com.larus.im.service.audio.x0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a extends SAMIMediaSession {
    @Override // id9.d
    public final void r(Map<String, ? extends Object> r100) {
    }

    public a(x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
    }

    @Override // id9.e
    public final void C(SessionReleaseReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        u r101 = u.f347501c;
        u.f347501c.f(this, r100);
    }
}
