package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends a<Integer> {
    @Override // em5.a
    public final int b() {
        return 0;
    }

    public i(String r3) {
        Intrinsics.checkNotNullParameter("doc/type", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "defaultStr");
        super("doc/type", r3);
    }
}
