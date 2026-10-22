package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lgi6/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lgi6/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class ChorusInterceptorManager$init$4 extends FunctionReferenceImpl implements Function1<gi6.b, Unit> {
    public ChorusInterceptorManager$init$4(b r100) {
        super(1, r100, b.class, "onRtcRoomEvent", "onRtcRoomEvent(Lcom/bytedance/live/livelink/kmp/api/base/event/Event;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(gi6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        b r101 = (b) this.receiver;
        r101.getClass();
        String r102 = r100.f481420b.f481422a;
        HashMap<String, Object> r103 = r100.f481421c;
        if (r102.hashCode() == (-1422423151)) goto L6;
        return;
    L6:
        if (r102.equals("onUserPublishStreamAudio") == false) goto L25;
        Object r104 = r103.get("uid");
        Object r105 = null;
        if ((r104 instanceof String) == true) goto L10;
        r104 = null;
    L10:
        String r106 = (String) r104;
        if (r106 == null) goto L28;
        Object r107 = r103.get("isPublish");
        if ((r107 instanceof Boolean) == false) goto L17;
        r105 = r107;
    L17:
        Boolean r108 = (Boolean) r105;
        if (r108 != null) goto L20;
        return;
    L20:
        if (r108.booleanValue() == false) goto L22;
        Function1 r109 = new ChorusInterceptorManager$onRtcRoomEvent$func$1(r101);
    L23:
        r109.invoke(r106);
        return;
    L22:
        r109 = new ChorusInterceptorManager$onRtcRoomEvent$func$2(r101);
        goto L23
    L28:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(gi6.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
