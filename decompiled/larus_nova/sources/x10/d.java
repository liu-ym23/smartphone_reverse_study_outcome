package x10;

import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> extends b<ExtraResponse<T, OpenPlatformRespExtra>> {
    public d(PluginContext r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "path");
        super(r100, r101, r102);
    }
}
