package fm2;

import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.android.livesdk.room.util.i r1, long r2, int r4) {
        IExternalFunctionInjector r0 = jc1.k.f(IExternalFunctionInjector.class);
        if (r0 == null) goto L6;
        r1.call(r0.getLiveRoomController(String.valueOf(r2), r4, ILiveRoomControllerProvider.ProviderSource.PREVIEW));
        return;
    }
}
