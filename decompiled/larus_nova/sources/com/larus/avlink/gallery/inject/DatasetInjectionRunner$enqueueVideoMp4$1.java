package com.larus.avlink.gallery.inject;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.inject.DatasetInjectionRunner", f = "DatasetInjectionRunner.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME}, m = "enqueueVideoMp4", n = {"file", "resolution", MapBundleKey.OfflineMapKey.OFFLINE_RATION, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "encoded", "uniqId", "$this$enqueueVideoMp4_u24lambda_u246", "mappedW", "mappedH", "outW", "outH", "file", "resolution", MapBundleKey.OfflineMapKey.OFFLINE_RATION, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "encoded", "uniqId", "$this$enqueueVideoMp4_u24lambda_u246", "mappedW", "mappedH", "outW", "outH"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"})
final class DatasetInjectionRunner$enqueueVideoMp4$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DatasetInjectionRunner this$0;

    public DatasetInjectionRunner$enqueueVideoMp4$1(DatasetInjectionRunner r100, Continuation<? super DatasetInjectionRunner$enqueueVideoMp4$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DatasetInjectionRunner.c(this.this$0, null, this);
    }
}
