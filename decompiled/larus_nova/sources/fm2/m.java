package fm2;

import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;

/* JADX INFO: loaded from: classes10.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477805a = 0;

    static {
    }

    public static void a(com.bytedance.android.livesdk.room.util.i r100, long r101, int r102) {
        IExternalFunctionInjector r103 = (IExternalFunctionInjector) jc1.k.f(IExternalFunctionInjector.class);
        if (r103 == null) goto L6;
        r100.call(r103.getLiveRoomController(String.valueOf(r101), r102, ILiveRoomControllerProvider.ProviderSource.PREVIEW));
        return;
    }
}
