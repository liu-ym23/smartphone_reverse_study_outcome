package com.bytedance.android.livesdk.livecommerce.playback.header;

import com.bytedance.android.livesdk.livecommerce.playback.main.f;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ExplainPlaybackHeaderPresenter$onBind$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ExplainPlaybackHeaderPresenter$onBind$1();
    }

    public ExplainPlaybackHeaderPresenter$onBind$1() {
        super(f.class, "showBackToLive", "getShowBackToLive()Z", 0);
    }

    public Object get(Object r1) {
        return Boolean.valueOf(((f) r1).b);
    }
}
