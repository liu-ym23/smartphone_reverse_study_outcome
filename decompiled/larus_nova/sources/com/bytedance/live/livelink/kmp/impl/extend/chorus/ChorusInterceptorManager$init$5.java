package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lgi6/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lgi6/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class ChorusInterceptorManager$init$5 extends FunctionReferenceImpl implements Function1<gi6.b, Unit> {
    public ChorusInterceptorManager$init$5(b r100) {
        super(1, r100, b.class, "onRtcRoomEventEx", "onRtcRoomEventEx(Lcom/bytedance/live/livelink/kmp/api/base/event/Event;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(gi6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        b r101 = (b) this.receiver;
        r101.getClass();
        String r102 = r100.f481420b.f481422a;
        HashMap<String, Object> r103 = r100.f481421c;
        int r104 = r102.hashCode();
        boolean r105 = false;
        Object r106 = null;
        if (r104 == 907966412) goto L36;
        if (r104 == 1886872389) goto L8;
        return;
    L8:
        if (r102.equals("onUserPublishStream") == false) goto L59;
        Object r107 = r103.get("streamKey");
        if ((r107 instanceof k0) == false) goto L13;
        r106 = r107;
    L13:
        k0 r108 = (k0) r106;
        if (r108 == null) goto L69;
        d r109 = r101.f255578d;
        if (r109.h() == false) goto L60;
        String r110 = r109.g();
        if (r110 != null) goto L21;
    L24:
        boolean r111 = true;
    L25:
        if (r111 == false) goto L27;
        return;
    L27:
        if ((!Intrinsics.areEqual(r108.f571727b, r109.g())) == false) goto L30;
        return;
    L30:
        if (Intrinsics.areEqual(r109.getRole(), zi6.b.a.f572257a) == false) goto L33;
        r109.d(r109.g(), LiveWrappedAudioAlignmentMode.AUDIO_ALIGNMENT_MODE_AUDIOMIXING);
    L33:
        if (Intrinsics.areEqual(r109.getRole(), zi6.b.f.f572261a) == false) goto L62;
        r109.j(r109.g(), false, LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO);
        return;
    L62:
        return;
    L21:
        if (r110.length() == 0) goto L24;
        r111 = false;
        goto L25
    L60:
        return;
    L69:
        return;
    L59:
        return;
    L36:
        if (r102.equals("onUserUnpublishStream") == false) goto L64;
        Object r112 = r103.get("streamKey");
        if ((r112 instanceof k0) == false) goto L41;
        r106 = r112;
    L41:
        k0 r113 = (k0) r106;
        if (r113 == null) goto L71;
        d r114 = r101.f255578d;
        if (r114.h() == false) goto L65;
        String r115 = r114.g();
        if (r115 != null) goto L49;
    L50:
        r105 = true;
    L51:
        if (r105 == false) goto L53;
        return;
    L53:
        if ((!Intrinsics.areEqual(r113.f571727b, r114.g())) == false) goto L56;
        return;
    L56:
        if (Intrinsics.areEqual(r114.getRole(), zi6.b.a.f572257a) == false) goto L67;
        r114.d(r114.g(), LiveWrappedAudioAlignmentMode.AUDIO_ALIGNMENT_MODE_OFF);
        return;
    L67:
        return;
    L49:
        if (r115.length() != 0) goto L51;
    L65:
        return;
    L71:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(gi6.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
