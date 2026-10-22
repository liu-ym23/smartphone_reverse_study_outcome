package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends cpc.a {
    public boolean e;

    public final void c() {
        this.e = false;
    }

    public j() {
        Intrinsics.checkNotNullParameter("doc/my_own", ResourceData.KEY_ID);
        super("doc/my_own");
    }

    public final boolean a() {
        return this.e;
    }
}
