package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f477791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f477792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f477793c;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Object r101 = this.f477791a;
        if ((r101 instanceof IBaseLiveRoomFunctionHandler) == true) goto L5;
        r101 = null;
    L5:
        IBaseLiveRoomFunctionHandler r102 = (IBaseLiveRoomFunctionHandler) r101;
        if (r102 == null) goto L9;
        r100.onFunctionHandlerAttached(r102);
        boolean r103 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477792b + " ====onFunctionHandlerAttached, indentCode=" + this.f477793c + ", " + r100.hashCode());
        return;
    }

    public g(Object r100, long r101, Integer r102) {
        this.f477791a = r100;
        this.f477792b = r101;
        this.f477793c = r102;
    }
}
