package com.ss.android.ugc.aweme.live.multilink;

import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LivePreviewMultiLinkLoader$liveRealTimeChorusEnterRoomOpt$2 extends Lambda implements Function0<Boolean> {
    public static final LivePreviewMultiLinkLoader$liveRealTimeChorusEnterRoomOpt$2 INSTANCE = null;

    static {
        INSTANCE = new LivePreviewMultiLinkLoader$liveRealTimeChorusEnterRoomOpt$2();
    }

    public LivePreviewMultiLinkLoader$liveRealTimeChorusEnterRoomOpt$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        IMiddlewareLiveService r100 = TTLiveServiceMiddleware.getLiveService();
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.getLiveSettingValue("live_real_time_chorus_enter_room_opt", Boolean.TRUE);
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return true;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }
}
