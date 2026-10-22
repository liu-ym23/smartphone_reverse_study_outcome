package mv0;

import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes47.dex */
public final class p implements l71.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f515825a = null;

    public p() {
    }

    static {
        f515825a = new p();
    }

    @Override // l71.d
    public final Long a(long r100) {
        IRoomModuleService r101 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.room.backend.g r102 = r101.getLiveRoomBackendUtils();
        if (r102 == null) goto L7;
        return Long.valueOf(r102.a(r100));
    L7:
        return null;
    }

    @Override // l71.d
    public final void b(long r110, DataCenter r111, Class r112, Function0 r113, Function3 r210, CompositeDisposable r211, boolean r212, boolean r213) {
        IRoomModuleService r100 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.room.backend.g r101 = r100.getLiveRoomBackendUtils();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r101, r110, MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r111, 0, 2), r112, r113, null, r210, null, null, r211, r212, r213, 2048);
        return;
    L9:
        return;
    }
}
