package s36;

import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends e {
    @Override // t36.e
    public final String getName() {
        return "DisableAutoExpose";
    }

    public a() {
    }

    @Override // t36.e
    public final boolean b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        r100.a("disable_auto_expose", new y36.a(Boolean.TRUE), false);
        return true;
    }
}
