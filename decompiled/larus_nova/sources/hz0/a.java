package hz0;

import com.bytedance.android.livesdk.revenue.interactivity.PublicScreenMessageType;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements gz0.b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f487666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.interactivity.a f487667b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a(c r100, com.bytedance.android.livesdk.revenue.service.interactivity.a r101) {
        Intrinsics.checkNotNullParameter(r100, "roomService");
        Intrinsics.checkNotNullParameter(r101, "interactivityRoomService");
        this.f487666a = r100;
        this.f487667b = r101;
    }

    @Override // gz0.b
    public final void t0(PublicScreenMessageType r100, String r110, Integer r111, boolean r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "content");
        this.f487667b.t0(r100, r110, r111, r112, r113, r114);
    }
}
