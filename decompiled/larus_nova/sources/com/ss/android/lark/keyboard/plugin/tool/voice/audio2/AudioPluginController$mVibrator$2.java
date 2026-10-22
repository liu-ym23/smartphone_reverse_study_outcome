package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.os.Vibrator;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Vibrator;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioPluginController$mVibrator$2 extends Lambda implements Function0<Vibrator> {
    final /* synthetic */ h this$0;

    public AudioPluginController$mVibrator$2(h r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Vibrator invoke() {
        h r100 = this.this$0;
        int r101 = h.f429940a;
        Object r102 = r100.c().getSystemService("vibrator");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Vibrator invoke() {
        return invoke();
    }
}
