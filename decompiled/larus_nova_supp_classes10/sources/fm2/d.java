package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements com.bytedance.android.livesdk.room.util.i {
    public final /* synthetic */ long a;
    public final /* synthetic */ Integer b;

    public void call(ILiveRoomController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        if ((r4 instanceof ILiveMergeRoomController) == true) goto L5;
        ILiveRoomController r0 = null;
    L6:
        ILiveMergeRoomController r1 = (ILiveMergeRoomController) r0;
        if (r1 == null) goto L9;
        r1.onResume();
    L9:
        boolean r2 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.a + " ====onResume indentCode=" + this.b + ", " + r4.hashCode());
        return;
    L5:
        r0 = r4;
        goto L6
    }

    public d(long r1, Integer r3) {
        this.a = r1;
        this.b = r3;
    }
}
