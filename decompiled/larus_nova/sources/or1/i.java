package or1;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.Gson;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i, com.bytedance.android.scope.o {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int a() {
        return 20006;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int c() {
        return TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int f() {
        return 20047;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int g() {
        return TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_EXITED_LC;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int h() {
        return TTVideoEngineInterface.ALGO_OPTION_PRELOAD_MP3_SUPPORT;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final Gson d() {
        return GsonHelper.get();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        return (T) com.bytedance.android.live.network.c.b().e(r100);
    }
}
