package m30;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.u;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<String> f511702a;

    @Override // com.bytedance.ies.xbridge.u
    public final boolean hasNextKey() {
        return this.f511702a.hasNext();
    }

    @Override // com.bytedance.ies.xbridge.u
    public final String nextKey() {
        return this.f511702a.next();
    }

    public e(Iterator<String> r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f511702a = r100;
    }
}
