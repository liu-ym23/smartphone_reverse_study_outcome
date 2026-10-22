package qq2;

import am2.n;
import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostHSFunc;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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

    @Override // qq2.a
    public final String getCreativeID() {
        return n.f().c();
    }

    @Override // qq2.a
    public final void oj(Context r100, long r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("live_gift", "label");
        Intrinsics.checkNotNullParameter(r111, "jsonObject");
        ((IHostHSFunc) k.n(IHostHSFunc.class)).adLog(r100, "live_ad", r110, "live_gift", r111, true);
    }
}
