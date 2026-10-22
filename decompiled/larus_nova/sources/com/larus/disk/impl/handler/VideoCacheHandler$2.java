package com.larus.disk.impl.handler;

import com.larus.video.api.VideoService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class VideoCacheHandler$2 extends FunctionReferenceImpl implements Function0<Long> {
    public VideoCacheHandler$2(Object r100) {
        super(0, r100, VideoService.class, "getAllCacheSize", "getAllCacheSize()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(((VideoService) this.receiver).d());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
