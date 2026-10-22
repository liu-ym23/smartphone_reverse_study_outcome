package yq2;

import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.scope.o;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a, o {
    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yq2.a
    public final void Th(String r100, Map r101) {
        Intrinsics.checkNotNullParameter("live_ad", "event");
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "map");
        ((ILiveDouPlusService) k.n(ILiveDouPlusService.class)).logEvent(true, "live_ad", r100, r101);
    }
}
