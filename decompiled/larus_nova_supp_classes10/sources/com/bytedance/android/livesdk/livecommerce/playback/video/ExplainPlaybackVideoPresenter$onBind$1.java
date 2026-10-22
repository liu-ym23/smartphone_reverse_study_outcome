package com.bytedance.android.livesdk.livecommerce.playback.video;

import com.bytedance.android.livesdk.livecommerce.playback.main.f;
import dj2.k;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ExplainPlaybackVideoPresenter$onBind$1 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new ExplainPlaybackVideoPresenter$onBind$1();
    }

    public ExplainPlaybackVideoPresenter$onBind$1() {
        super(f.class, "videoInfoEntity", "getVideoInfoEntity()Lcom/bytedance/android/livesdk/livecommerce/playback/model/VideoInfoEntity;", 0);
    }

    public Object get(Object r1) {
        return ((f) r1).c;
    }

    public void set(Object r1, Object r2) {
        k r3 = (k) r2;
        ((f) r1).c = r3;
    }
}
