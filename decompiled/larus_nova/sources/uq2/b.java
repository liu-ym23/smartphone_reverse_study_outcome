package uq2;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements o, a {
    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // uq2.a
    public final Fragment showLivePromotionListFragment(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "livePromotionListParams");
        IHostCommerceServiceLive r102 = (IHostCommerceServiceLive) k.f(IHostCommerceServiceLive.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.showLivePromotionListFragment(r100, r101);
    }
}
