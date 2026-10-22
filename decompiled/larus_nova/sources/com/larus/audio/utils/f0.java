package com.larus.audio.utils;

import com.larus.utils.logger.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f0 implements m58.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2a.d f290032a;

    public f0(f2a.d r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        this.f290032a = r100;
    }

    @Override // m58.l
    public final b a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "what");
        if (r100 != 3) goto L5;
        f2a.d r102 = this.f290032a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "what");
        f2a.c r103 = new f2a.c(r102.f475231a, LogLevel.DEBUG, r101);
    L16:
        return new b(r103);
    L5:
        if (r100 != 4) goto L7;
        r103 = this.f290032a.b(r101);
        goto L16
    L7:
        if (r100 != 5) goto L9;
        r103 = this.f290032a.c(r101);
        goto L16
    L9:
        if (r100 == 6) goto L11;
        f2a.d r104 = this.f290032a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "what");
        r103 = new f2a.c(r104.f475231a, LogLevel.DEBUG, r101);
        goto L16
    L11:
        r103 = this.f290032a.a(r101);
        goto L16
    }
}
