package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends a<SearchBaseInfo> {
    public f(String r3) {
        Intrinsics.checkNotNullParameter("doc/in/chat", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "defaultStr");
        super("doc/in/chat", r3);
    }
}
