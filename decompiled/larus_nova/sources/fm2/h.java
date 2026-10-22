package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f477794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f477795b;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        r100.onP0WidgetLoadFinished();
        r100.onWidgetLoadFinished();
        boolean r101 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477794a + " ====onP0WidgetLoadFinished->onWidgetLoadFinished, indentCode=" + this.f477795b + ", " + r100.hashCode());
    }

    public h(long r100, Integer r101) {
        this.f477794a = r100;
        this.f477795b = r101;
    }
}
