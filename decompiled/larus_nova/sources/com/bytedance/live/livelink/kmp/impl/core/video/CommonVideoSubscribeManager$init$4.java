package com.bytedance.live.livelink.kmp.impl.core.video;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lgi6/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lgi6/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class CommonVideoSubscribeManager$init$4 extends FunctionReferenceImpl implements Function1<gi6.b, Unit> {
    public CommonVideoSubscribeManager$init$4(g r100) {
        super(1, r100, g.class, "handleRtcRoomEventEx", "handleRtcRoomEventEx(Lcom/bytedance/live/livelink/kmp/api/base/event/Event;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(gi6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        final g r101 = (g) this.receiver;
        int r102 = g.f255457m;
        r101.getClass();
        if (r100.f481419a != EventCategory.RTC_ROOM_EVENT_EX) goto L24;
        String r103 = r100.f481420b.f481422a;
        if (r103.hashCode() == 1886872389) goto L8;
        return;
    L8:
        if (r103.equals("onUserPublishStream") == false) goto L25;
        Object r104 = r100.f481421c.get("streamKey");
        Object r105 = null;
        if ((r104 instanceof k0) == true) goto L12;
        r104 = null;
    L12:
        k0 r106 = (k0) r104;
        Object r107 = r100.f481421c.get("type");
        if ((r107 instanceof LiveWrappedMediaStreamType) == false) goto L16;
        r105 = r107;
    L16:
        LiveWrappedMediaStreamType r108 = (LiveWrappedMediaStreamType) r105;
        Object r109 = r100.f481421c.get("isScreen");
        if (r109 == null) goto L23;
        Boolean r110 = (Boolean) r109;
        Function3<k0, LiveWrappedMediaStreamType, Boolean, Unit> r111 = new CommonVideoSubscribeManager$handleRtcRoomEventEx$1(r101);
        Intrinsics.checkNotNullParameter(r111, "block");
        if (r106 == null) goto L26;
        if (r108 == null) goto L27;
        r111.invoke(r106, r108, r110);
        return;
    L27:
        return;
    L26:
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L25:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(gi6.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
