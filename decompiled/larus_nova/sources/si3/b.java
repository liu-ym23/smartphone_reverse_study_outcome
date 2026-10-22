package si3;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements bf.c {
    public b() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "goods/store/classification";
    }

    @Override // bf.c
    public final boolean c(Context r100, Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (HybridPageConfigSetting.f185954f == false) goto L5;
        ak3.a.f3998b.b(r100, (vj3.b) HybridPageConfigSetting.f185950b.getValue());
    L5:
        a.a(r100, r101, r102);
        return true;
    }
}
