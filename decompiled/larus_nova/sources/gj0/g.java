package gj0;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.starwish.StarWishWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements xh0.e {
    public g() {
    }

    @Override // xh0.e
    public final ne0.d a(SceneType r100) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        return null;
    }

    @Override // xh0.e
    public final Widget b(SceneType r100) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        i.a("StarWishPlugin", "createWidget");
        return new StarWishWidget();
    }

    @Override // xh0.e
    public final boolean c(SceneType r100) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        i.a("StarWishPlugin", "isEnable sceneType ：" + r100);
        return true;
    }
}
