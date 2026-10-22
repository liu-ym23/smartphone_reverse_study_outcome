package com.bytedance.salamander.anniex;

import androidx.camera.video.AudioStats;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e8 extends g5 {
    public e8() {
        super(2);
    }

    @Override // com.bytedance.salamander.anniex.g5
    public final boolean a(b5 r110) {
        Intrinsics.checkNotNullParameter(r110, "redirectRule");
        long r100 = com.bytedance.anniex.bd.foundation.impl.o.l(r110.f267983d, DyPayConstant.KEY_START_TIME, 0);
        long r101 = com.bytedance.anniex.bd.foundation.impl.o.l(r110.f267983d, "endTime", Long.MAX_VALUE);
        int r111 = com.bytedance.rts.foundation.c.f267576a;
        if (r100 != ((long) AudioStats.AUDIO_AMPLITUDE_NONE)) goto L8;
        if (r101 != Long.MAX_VALUE) goto L8;
        return false;
    L8:
        if (r100 < r101) goto L10;
        return false;
    L10:
        int r102 = com.bytedance.rts.foundation.b.f267575a;
        long r103 = System.currentTimeMillis();
        if (r103 >= r100) goto L13;
        return false;
    L13:
        if (r103 >= r101) goto L17;
        return true;
    L17:
        return false;
    }
}
