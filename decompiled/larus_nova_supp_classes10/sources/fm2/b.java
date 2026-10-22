package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.livesdk.room.util.i {
    public final /* synthetic */ Object a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Integer c;

    public void call(ILiveRoomController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        Object r0 = this.a;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 == null) goto L9;
        r4.onSpecificWidgetLoadFinished(r1);
        boolean r2 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.b + " ====onSpecificWidgetLoadFinished className=" + this.a + ", indentCode=" + this.c + ", " + r4.hashCode());
        return;
    }

    public b(Object r1, long r2, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
