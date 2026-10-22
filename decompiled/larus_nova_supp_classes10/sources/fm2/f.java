package fm2;

import com.bytedance.android.livesdkapi.feed.arch.IComponentsAlign;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements com.bytedance.android.livesdk.room.util.i {
    public final /* synthetic */ Object a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Integer c;

    public void call(ILiveRoomController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        Object r0 = this.a;
        if ((r0 instanceof IComponentsAlign.BindStartExtra) == true) goto L5;
        r0 = null;
    L5:
        IComponentsAlign.BindStartExtra r1 = (IComponentsAlign.BindStartExtra) r0;
        if (r1 == null) goto L21;
        r4.onCreate();
        r4.onContextAttached(r1.getContext());
        ILiveRoomViewHandler r2 = r1.getHandler();
        if (r2 == null) goto L10;
        r4.onViewHandlerAttached(r2);
    L10:
        IRoomState r3 = r1.getRoomState();
        if (r3 == null) goto L13;
        r4.onRoomStatusChanged(r3);
    L13:
        IRoomEventHub r5 = r1.getEvent();
        if (r5 == null) goto L16;
        r4.onRoomEventHubAttached(r5);
    L16:
        r4.onActivityCreated();
        r4.onEnterRoomPrepared();
        ILiveRoomMessageHandler r6 = r1.getMessageHandler();
        if (r6 == null) goto L19;
        r4.onMessageHandlerAttached(r6);
    L19:
        boolean r7 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.b + " ====onCreate->onContextAttached->onViewHandlerAttached->onRoomStatusChanged->onRoomEventHubAttached->onActivityCreated->onEnterRoomPrepared->onMessageHandlerAttached, indentCode=" + this.c + ", " + r4.hashCode());
        return;
    }

    public f(Object r1, long r2, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
