package fm2;

import com.bytedance.android.livesdkapi.feed.arch.IComponentsAlign;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements com.bytedance.android.livesdk.room.util.i {
    public final /* synthetic */ Object a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Integer c;

    public void call(ILiveRoomController r5) {
        Intrinsics.checkNotNullParameter(r5, "controller");
        Object r0 = this.a;
        if ((r0 instanceof IComponentsAlign.ToolbarBehavior) == true) goto L5;
        r0 = null;
    L5:
        IComponentsAlign.ToolbarBehavior r1 = (IComponentsAlign.ToolbarBehavior) r0;
        if (r1 == null) goto L9;
        r5.onSpecificBehaviorLoad(r1.getBehaviorClassName(), r1.isFold(), r1.isFromMsg());
        boolean r2 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.b + " ====onSpecificBehaviorLoad class=" + r1.getBehaviorClassName() + ", indentCode=" + this.c + ", " + r5.hashCode());
        return;
    }

    public l(Object r1, long r2, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
