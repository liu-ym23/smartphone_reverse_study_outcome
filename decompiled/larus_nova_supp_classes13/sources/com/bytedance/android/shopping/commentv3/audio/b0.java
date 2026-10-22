package com.bytedance.android.shopping.commentv3.audio;

import android.content.Context;
import com.bytedance.android.shopping.api.video.AVScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 implements m {
    public final Context a;
    public final AVScene b;

    public b0(Context r3) {
        AVScene r0 = AVScene.CONTENT_DEFAULT;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "avScene");
        this.a = r3;
        this.b = r0;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.m
    public final TTVideoEngineAudioPlayer a(e r3) {
        Intrinsics.checkNotNullParameter(r3, "audioInfo");
        return new TTVideoEngineAudioPlayer(this.a, this.b);
    }
}
