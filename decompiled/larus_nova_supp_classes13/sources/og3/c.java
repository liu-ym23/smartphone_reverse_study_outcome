package og3;

import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Biz a;
    public final String b;
    public final a c;

    public c(Biz r2, String r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "bizCode");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "btmInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
