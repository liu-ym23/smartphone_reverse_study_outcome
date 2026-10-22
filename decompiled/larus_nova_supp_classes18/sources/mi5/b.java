package mi5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T1, T2, R> implements BiFunction {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r9, Object r10) {
        IDocUserPermission r6 = (IDocUserPermission) r9;
        DocMetaInfo r5 = (DocMetaInfo) r10;
        Intrinsics.checkNotNullParameter(r6, "docUserPermission");
        Intrinsics.checkNotNullParameter(r5, "docMetaInfo");
        return new ShareDocInfo(this.a.c.getType(), this.a.c.getUrl(), this.a.c.getToken(), new DocVersion(5), r5, r6, 960);
    }
}
