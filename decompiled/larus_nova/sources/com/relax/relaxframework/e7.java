package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e7 extends RxAttributedElementImpl implements f2 {
    public e7() {
        int r100 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        super("swiper", Long.valueOf(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().O()));
        s0(ElementAttribute.Touchable, 1.0d, AttributeNumberValuePattern.BOOLEAN);
    }

    @Override // com.relax.relaxframework.RxAttributedElementImpl
    public final void s0(ElementAttribute r100, double r101, AttributeNumberValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        if (r100 != ElementAttribute.Orientation) goto L13;
        ElementAttribute r103 = ElementAttribute.Vertical;
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        if (r101 != SwiperOrientation.Vertical.getValue()) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        double r106 = 1.0d;
    L11:
        super.s0(r103, r106, AttributeNumberValuePattern.BOOLEAN);
        return;
    L10:
        r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L11
    L7:
        r105 = false;
        goto L8
    L13:
        super.s0(r100, r101, r102);
    }
}
