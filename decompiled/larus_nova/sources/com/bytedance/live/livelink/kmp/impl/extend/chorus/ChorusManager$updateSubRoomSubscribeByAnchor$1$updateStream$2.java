package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "", "p2", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedStreamIndex;", "Lcom/bytedance/live/livelink/kmp/api/base/rtc/StreamIndex;", "p3", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedMediaStreamType;", "Lcom/bytedance/live/livelink/kmp/api/base/rtc/MediaStreamType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusManager$updateSubRoomSubscribeByAnchor$1$updateStream$2 extends FunctionReferenceImpl implements Function3<String, LiveWrappedStreamIndex, LiveWrappedMediaStreamType, Unit> {
    public ChorusManager$updateSubRoomSubscribeByAnchor$1$updateStream$2(mi6.b r100) {
        super(3, r100, mi6.b.class, "unsubscribeStream", "unsubscribeStream(Ljava/lang/String;Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedStreamIndex;Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedMediaStreamType;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, LiveWrappedStreamIndex r101, LiveWrappedMediaStreamType r102) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        ((mi6.b) this.receiver).w(r100, r101, r102);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r100, LiveWrappedStreamIndex r101, LiveWrappedMediaStreamType r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
