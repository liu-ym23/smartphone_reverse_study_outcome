package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends a<SearchChatterInfo> {
    public h(String r3) {
        Intrinsics.checkNotNullParameter("doc/owner", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "defaultStr");
        super("doc/owner", r3);
    }
}
