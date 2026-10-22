package fm2;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.livesdk.room.util.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f477778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f477779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f477780c;

    @Override // com.bytedance.android.livesdk.room.util.i
    public void call(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Object r101 = this.f477778a;
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        if (r102 == null) goto L9;
        r100.onSpecificWidgetLoadFinished(r102);
        boolean r103 = com.bytedance.android.livesdk.room.util.j.f157836a;
        com.bytedance.android.livesdk.room.util.j.a("roomId->" + this.f477779b + " ====onSpecificWidgetLoadFinished className=" + this.f477778a + ", indentCode=" + this.f477780c + ", " + r100.hashCode());
        return;
    }

    public b(Object r100, long r101, Integer r102) {
        this.f477778a = r100;
        this.f477779b = r101;
        this.f477780c = r102;
    }
}
