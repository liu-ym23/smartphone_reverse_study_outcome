package fm2;

import com.bytedance.android.livesdkapi.feed.arch.IComponentsAlign;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f477788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f477789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f477790c;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Object r101 = this.f477788a;
        if ((r101 instanceof IComponentsAlign.BindStartExtra) == true) goto L5;
        r101 = null;
    L5:
        IComponentsAlign.BindStartExtra r102 = (IComponentsAlign.BindStartExtra) r101;
        if (r102 == null) goto L21;
        r100.onCreate();
        r100.onContextAttached(r102.getContext());
        ILiveRoomViewHandler r103 = r102.getHandler();
        if (r103 == null) goto L10;
        r100.onViewHandlerAttached(r103);
    L10:
        IRoomState r104 = r102.getRoomState();
        if (r104 == null) goto L13;
        r100.onRoomStatusChanged(r104);
    L13:
        IRoomEventHub r105 = r102.getEvent();
        if (r105 == null) goto L16;
        r100.onRoomEventHubAttached(r105);
    L16:
        r100.onActivityCreated();
        r100.onEnterRoomPrepared();
        ILiveRoomMessageHandler r106 = r102.getMessageHandler();
        if (r106 == null) goto L19;
        r100.onMessageHandlerAttached(r106);
    L19:
        boolean r107 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477789b + " ====onCreate->onContextAttached->onViewHandlerAttached->onRoomStatusChanged->onRoomEventHubAttached->onActivityCreated->onEnterRoomPrepared->onMessageHandlerAttached, indentCode=" + this.f477790c + ", " + r100.hashCode());
        return;
    }

    public f(Object r100, long r101, Integer r102) {
        this.f477788a = r100;
        this.f477789b = r101;
        this.f477790c = r102;
    }
}
