package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements com.bytedance.android.livesdk.room.util.i {
    public final /* synthetic */ long a;
    public final /* synthetic */ Integer b;

    public void call(ILiveRoomController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        r4.onP0WidgetLoadFinished();
        r4.onWidgetLoadFinished();
        boolean r0 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.a + " ====onP0WidgetLoadFinished->onWidgetLoadFinished, indentCode=" + this.b + ", " + r4.hashCode());
    }

    public h(long r1, Integer r3) {
        this.a = r1;
        this.b = r3;
    }
}
