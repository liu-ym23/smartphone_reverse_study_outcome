package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/live/livelink/kmp/impl/extend/chorus/d;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Lcom/bytedance/live/livelink/kmp/impl/extend/chorus/d;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class ChorusInterceptorManager$onRtcRoomEvent$func$2 extends FunctionReferenceImpl implements Function1<String, d> {
    public ChorusInterceptorManager$onRtcRoomEvent$func$2(b r100) {
        super(1, r100, b.class, "onUserUnpublishStreamAudio", "onUserUnpublishStreamAudio(Ljava/lang/String;)Lcom/bytedance/live/livelink/kmp/impl/extend/chorus/ChorusScope;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        d r101 = ((b) this.receiver).f255578d;
        if (r101.h() == false) goto L21;
        String r102 = r101.g();
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L21;
        if ((!Intrinsics.areEqual(r100, r101.g())) == true) goto L21;
        if (Intrinsics.areEqual(r101.getRole(), zi6.b.a.f572257a) == false) goto L19;
        r101.d(r101.g(), LiveWrappedAudioAlignmentMode.AUDIO_ALIGNMENT_MODE_AUDIOMIXING);
    L19:
        if (Intrinsics.areEqual(r101.getRole(), zi6.b.f.f572261a) == false) goto L21;
        r101.j(r101.g(), false, LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO);
        goto L21
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
    L21:
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d invoke(String r100) {
        return invoke2(r100);
    }
}
