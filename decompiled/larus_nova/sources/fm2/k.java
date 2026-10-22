package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f477800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f477801b;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        r100.onExitRoom();
        r100.onDestroyView();
        r100.onDestroy();
        boolean r101 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477800a + " ====onExitRoom-> onDestroyView -> onDestroy, indentCode=" + this.f477801b + ", " + r100.hashCode());
    }

    public k(long r100, Integer r101) {
        this.f477800a = r100;
        this.f477801b = r101;
    }
}
