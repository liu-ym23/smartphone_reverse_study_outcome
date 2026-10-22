package com.bytedance.livesdk.ktvcommon.midi.view.midihitview;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class KtvMidiHitResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f256148a;

    public KtvMidiHitResourceManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f256148a = r100;
    }

    public final void a(HSImageView r100, String r101, final Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "onLoaded");
        FrescoLoader r103 = FrescoLoader.with(this.f256148a).load(r101).actualScaleType(ImageView.ScaleType.FIT_CENTER);
        int r104 = f.f114457a;
        r103.controllerListener(f.a(null, new KtvMidiHitResourceManager$loadHitImage$2(r102), 3)).into(r100);
    }
}
