package uc5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w1 implements Function<DocumentListInfo, Publisher<DocumentListInfo>> {
    public w1() {
    }

    public final Object apply(Object r8) throws Exception {
        final DocumentListInfo r9 = (DocumentListInfo) r8;
        Document r0 = r9.getParent();
        if (r0 != null) goto L5;
    L8:
        tt5.a.h("GetV2FolderPermissionFunction", "shareFolderUserPermission...no need, so return");
        return Flowable.just(r9);
    L5:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r0.L1)) == false) goto L8;
        return ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().f(r0.d, new FolderVersion(r0.L1, r0.T, r0.P1), r0.n).map(new v1(r9));
    }
}
