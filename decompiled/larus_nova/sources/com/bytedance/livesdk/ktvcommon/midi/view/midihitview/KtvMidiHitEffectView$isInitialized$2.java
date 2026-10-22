package com.bytedance.livesdk.ktvcommon.midi.view.midihitview;

import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvMidiHitEffectView$isInitialized$2 extends MutablePropertyReference0Impl {
    public KtvMidiHitEffectView$isInitialized$2(KtvMidiHitEffectView r100) {
        super(r100, KtvMidiHitEffectView.class, "hitTypeImage", "getHitTypeImage()Lcom/bytedance/android/live/core/widget/HSImageView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return KtvMidiHitEffectView.U5((KtvMidiHitEffectView) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        HSImageView r101 = (HSImageView) r100;
        ((KtvMidiHitEffectView) this.receiver).f256135b = r101;
    }
}
