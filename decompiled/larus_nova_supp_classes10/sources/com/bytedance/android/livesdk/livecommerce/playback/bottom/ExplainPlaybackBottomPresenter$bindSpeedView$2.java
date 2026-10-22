package com.bytedance.android.livesdk.livecommerce.playback.bottom;

import com.bytedance.android.livesdk.livecommerce.playback.video.b;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ExplainPlaybackBottomPresenter$bindSpeedView$2 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ExplainPlaybackBottomPresenter$bindSpeedView$2();
    }

    public ExplainPlaybackBottomPresenter$bindSpeedView$2() {
        super(b.class, "speedFloat", "getSpeedFloat()F", 0);
    }

    public Object get(Object r1) {
        return Float.valueOf(((b) r1).c);
    }
}
