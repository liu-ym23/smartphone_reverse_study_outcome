package fm2;

import com.bytedance.android.livesdkapi.feed.arch.IComponentsAlign;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f477802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f477803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f477804c;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Object r101 = this.f477802a;
        if ((r101 instanceof IComponentsAlign.ToolbarBehavior) == true) goto L5;
        r101 = null;
    L5:
        IComponentsAlign.ToolbarBehavior r102 = (IComponentsAlign.ToolbarBehavior) r101;
        if (r102 == null) goto L9;
        r100.onSpecificBehaviorLoad(r102.getBehaviorClassName(), r102.isFold(), r102.isFromMsg());
        boolean r103 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477803b + " ====onSpecificBehaviorLoad class=" + r102.getBehaviorClassName() + ", indentCode=" + this.f477804c + ", " + r100.hashCode());
        return;
    }

    public l(Object r100, long r101, Integer r102) {
        this.f477802a = r100;
        this.f477803b = r101;
        this.f477804c = r102;
    }
}
