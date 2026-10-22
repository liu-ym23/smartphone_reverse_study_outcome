package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f477796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f477797b;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        r100.onStart();
        if ((r100 instanceof ILiveMergeRoomController) == true) goto L5;
        ILiveRoomController r101 = null;
    L6:
        ILiveMergeRoomController r102 = (ILiveMergeRoomController) r101;
        if (r102 == null) goto L9;
        r102.onResume();
    L9:
        boolean r103 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477796a + " ====onStart->onResume, indentCode=" + this.f477797b + ", " + r100.hashCode());
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public i(long r100, Integer r101) {
        this.f477796a = r100;
        this.f477797b = r101;
    }
}
