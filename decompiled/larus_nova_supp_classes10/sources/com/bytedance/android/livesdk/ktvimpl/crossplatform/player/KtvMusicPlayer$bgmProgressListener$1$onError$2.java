package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.live.core.utils.r;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0001\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/core/utils/r;", "com/bytedance/android/livesdk/ktvimpl/crossplatform/player/KtvMusicPlayer$b", "", "invoke", "(Lcom/bytedance/android/live/core/utils/r;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvMusicPlayer$bgmProgressListener$1$onError$2 extends Lambda implements Function1<r<KtvMusicPlayer.b>, Unit> {
    public static final KtvMusicPlayer$bgmProgressListener$1$onError$2 INSTANCE = null;

    static {
        INSTANCE = new KtvMusicPlayer$bgmProgressListener$1$onError$2();
    }

    public KtvMusicPlayer$bgmProgressListener$1$onError$2() {
        super(1);
    }

    public final void invoke(r<KtvMusicPlayer.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        int r4 = ee2.a.a;
        Intrinsics.checkNotNullParameter("realtime_chorus", "businessId");
        ee2.a.c("realtime_chorus", "onMusicPlayFail", new JsonObject());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((r) r1);
        return Unit.INSTANCE;
    }
}
