package n66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.u;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableMapKeySetIterator f518163a;

    @Override // com.bytedance.ies.xbridge.u
    public final boolean hasNextKey() {
        return this.f518163a.hasNextKey();
    }

    @Override // com.bytedance.ies.xbridge.u
    public final String nextKey() {
        return this.f518163a.nextKey();
    }

    public b(ReadableMapKeySetIterator r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f518163a = r100;
    }
}
