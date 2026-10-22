package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f477786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f477787b;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        if ((r100 instanceof ILiveMergeRoomController) == true) goto L5;
        ILiveRoomController r101 = null;
    L6:
        ILiveMergeRoomController r102 = (ILiveMergeRoomController) r101;
        if (r102 == null) goto L9;
        r102.onPause();
    L9:
        boolean r103 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477786a + " ====onPause indentCode=" + this.f477787b + ", " + r100.hashCode());
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public e(long r100, Integer r101) {
        this.f477786a = r100;
        this.f477787b = r101;
    }
}
