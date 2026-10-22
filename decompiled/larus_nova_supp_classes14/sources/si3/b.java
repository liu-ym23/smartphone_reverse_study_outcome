package si3;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements bf.c {
    public b() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/store/classification";
    }

    public final boolean c(Context r3, Uri r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        if (HybridPageConfigSetting.f == false) goto L5;
        ak3.a.b.b(r3, (vj3.b) HybridPageConfigSetting.b.getValue());
    L5:
        a.a(r3, r4, r5);
        return true;
    }
}
