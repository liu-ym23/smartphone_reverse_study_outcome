package ak2;

import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements com.bytedance.android.livesdk.livecommerce.room.api.d {
    public final Object a;

    public i(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void b(td.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.a;
        if ((r0 instanceof td.c) == false) goto L6;
        ((td.c) r0).b(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void c(IExternalMessageListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.a;
        if ((r0 instanceof ILiveRoomMessageHandler) == false) goto L6;
        ((ILiveRoomMessageHandler) r0).removeListener(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void d(IExternalMessageListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.a;
        if ((r0 instanceof ILiveRoomMessageHandler) == false) goto L6;
        ((ILiveRoomMessageHandler) r0).addListener(1003, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void a(int r3, td.a r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Object r0 = this.a;
        if ((r0 instanceof td.c) == false) goto L6;
        ((td.c) r0).a(r3, r4);
        return;
    }
}
