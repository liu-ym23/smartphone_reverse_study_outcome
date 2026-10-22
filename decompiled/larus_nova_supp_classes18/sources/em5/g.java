package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends a<SearchSpaceInfo> {
    @Override // em5.a
    public final boolean a() {
        if (this.f.size() >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public g(String r3) {
        Intrinsics.checkNotNullParameter("doc/in/folder", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "defaultStr");
        super("doc/in/folder", r3);
    }
}
