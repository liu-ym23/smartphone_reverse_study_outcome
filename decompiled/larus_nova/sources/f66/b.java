package f66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.u;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<String> f475706a;

    @Override // com.bytedance.ies.xbridge.u
    public final boolean hasNextKey() {
        return this.f475706a.hasNext();
    }

    @Override // com.bytedance.ies.xbridge.u
    public final String nextKey() {
        return this.f475706a.next();
    }

    public b(Iterator<String> r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f475706a = r100;
    }
}
