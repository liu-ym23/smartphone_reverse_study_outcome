package k20;

import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f501458a = null;

    static {
        f501458a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = InteractGameLocalStatusUtils.f59295a;
        String r102 = String.valueOf(((XplayScene) r100).getSceneId());
        Intrinsics.checkNotNullParameter(r102, "liveScene");
        InteractGameLocalStatusUtils.c("live_scene", r102);
    }
}
