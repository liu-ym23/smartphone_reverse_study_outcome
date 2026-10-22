package dq2;

import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityRoomSkinInfo f469636a;

    @Override // dq2.a
    public final Map<Integer, py.k> a() {
        return this.f469636a.getHorizontalImages();
    }

    @Override // dq2.a
    public final Map<Integer, py.k> b() {
        return this.f469636a.getVerticalImages();
    }

    public h(ActivityRoomSkinInfo r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f469636a = r100;
    }
}
