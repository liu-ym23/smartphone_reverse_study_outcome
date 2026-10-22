package fm2;

import com.bytedance.android.livesdkapi.feed.arch.IComponentsAlign;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f477781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f477782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f477783c;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Object r101 = this.f477781a;
        if ((r101 instanceof IComponentsAlign.ToolbarBehavior) == true) goto L5;
        r101 = null;
    L5:
        IComponentsAlign.ToolbarBehavior r102 = (IComponentsAlign.ToolbarBehavior) r101;
        if (r102 == null) goto L9;
        r100.onSpecificBehaviorUnload(r102.getBehaviorClassName(), r102.isFold(), r102.isFromMsg());
        boolean r103 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477782b + " ====onSpecificBehaviorUnload, indentCode=" + this.f477783c + ", " + r100.hashCode());
        return;
    }

    public c(Object r100, long r101, Integer r102) {
        this.f477781a = r100;
        this.f477782b = r101;
        this.f477783c = r102;
    }
}
