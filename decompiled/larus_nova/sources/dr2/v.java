package dr2;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v implements h, com.bytedance.android.scope.o {
    public v() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.h
    public final String getHostPackageName() {
        return ((IHostPlugin) jc1.k.n(IHostPlugin.class)).getHostPackageName();
    }

    @Override // dr2.h
    public final boolean checkPluginLoaded(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        return ((IHostPlugin) jc1.k.n(IHostPlugin.class)).checkPluginLoaded(r100);
    }

    @Override // dr2.h
    public final com.bytedance.android.livesdk.revenue.network.g r8(RevHostPluginType r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginType");
        Intrinsics.checkNotNullParameter(r100, "$this$toLiveType");
        int r101 = u.f469745a[r100.ordinal()];
        if (r101 != 1) goto L5;
        PluginType r102 = PluginType.Player;
    L17:
        return new com.bytedance.android.livesdk.revenue.network.g(r102);
    L5:
        if (r101 != 2) goto L7;
        r102 = PluginType.XGPlayer;
        goto L17
    L7:
        if (r101 != 3) goto L9;
        r102 = PluginType.LITE_PLAYER_CONTAINER;
        goto L17
    L9:
        if (r101 != 4) goto L12;
        r102 = PluginType.LivePcdnDouyin;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // dr2.h
    public final Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r110, String r111, ClassLoader r112) {
        return ((IHostPlugin) jc1.k.n(IHostPlugin.class)).loadLibraryV2(r100, r101, r110, r111, r112);
    }
}
