package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends a<SearchWikiSpaceInfo> {
    public k(String r3) {
        Intrinsics.checkNotNullParameter("doc/in/wiki", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "defaultStr");
        super("doc/in/wiki", r3);
    }
}
