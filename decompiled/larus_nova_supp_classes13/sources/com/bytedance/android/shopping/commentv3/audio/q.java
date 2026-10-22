package com.bytedance.android.shopping.commentv3.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements g {

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.g
    public final x a(w r2, StopReason r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "reason");
        return new x(true);
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.g
    public final u b(v r9, w r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        if (r10 == null) goto L5;
        boolean r11 = Intrinsics.areEqual(r10.a, r9.a);
        if (r11 == false) goto L9;
        StopReason r1 = StopReason.REPLAY_SAME_SLICE;
    L10:
        StopReason r4 = r1;
        if (r11 == false) goto L13;
        y r12 = new y(true, true, true);
    L15:
        return new u(true, true, r4, r12, new t(r9.a, r9.b, ExternalAudioInterruptReason.COMMENT_AUDIO_PLAY, ExternalAudioTargetScope.CURRENT_PAGE_AND_FLOATING_AUDIO));
    L13:
        r12 = new y(false, 7);
        goto L15
    L9:
        r1 = StopReason.REPLACED_BY_OTHER;
        goto L10
    L5:
        return new u(true, new t(r9.a, r9.b, ExternalAudioInterruptReason.COMMENT_AUDIO_PLAY, ExternalAudioTargetScope.CURRENT_PAGE_AND_FLOATING_AUDIO), 12);
    }
}
