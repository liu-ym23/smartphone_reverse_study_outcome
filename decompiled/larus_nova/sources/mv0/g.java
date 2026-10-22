package mv0;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends qs0.a<IHostCommerceServiceLive> implements qs0.e {
    public g() {
        super(jc1.k.f(IHostCommerceServiceLive.class));
    }

    @Override // qs0.e
    public final JSONObject i() {
        IHostCommerceServiceLive r100 = (IHostCommerceServiceLive) this.f534640a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveShoppingData(20);
    }

    @Override // qs0.e
    public final void tryShowLiveFlashFragment(Context r100, Bundle r101, Function1<? super DialogFragment, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostCommerceServiceLive r103 = (IHostCommerceServiceLive) this.f534640a;
        if (r103 == null) goto L6;
        r103.tryShowLiveFlashFragment(r100, r101, r102);
        return;
    }
}
