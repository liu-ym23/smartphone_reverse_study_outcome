package com.bytedance.android.livesdk.ktvimpl.crossplatform.midi;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.base.component.midi.KaraokeMidiScoreInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMidiController implements com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a {
    public KaraokeMidiScoreInfo a;

    public static final class a {
    }

    static {
    }

    public KtvMidiController() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a
    public final float c() {
        KaraokeMidiScoreInfo r0 = this.a;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getSongScore();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a
    public final void a(final KaraokeMidiScoreInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "scoreInfo");
        this.a = r2;
        UtilityKotlinExtentionsKt.b(this, new KtvMidiController$setMidiScoreInfo$1(r2));
    }
}
