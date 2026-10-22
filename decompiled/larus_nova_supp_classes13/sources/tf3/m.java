package tf3;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public final Map<String, String> a;

    public m(Bundle r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r3, "eventParams");
        this.a = r3;
    }
}
