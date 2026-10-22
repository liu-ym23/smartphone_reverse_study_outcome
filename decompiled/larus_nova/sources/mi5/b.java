package mi5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f514073a;

    public b(a r100) {
        this.f514073a = r100;
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r110) {
        IDocUserPermission r101 = (IDocUserPermission) r100;
        DocMetaInfo r102 = (DocMetaInfo) r110;
        Intrinsics.checkNotNullParameter(r101, "docUserPermission");
        Intrinsics.checkNotNullParameter(r102, "docMetaInfo");
        return new ShareDocInfo(this.f514073a.f514071c.getType(), this.f514073a.f514071c.getUrl(), this.f514073a.f514071c.getToken(), new DocVersion(5), r102, r101, 960);
    }
}
