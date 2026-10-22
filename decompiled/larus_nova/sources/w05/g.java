package w05;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T1, T2, T3, R> implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f557788c;

    public g(String r100, String r101, int r102) {
        this.f557786a = r100;
        this.f557787b = r101;
        this.f557788c = r102;
    }

    @Override // io.reactivex.functions.Function3
    public final Object apply(Object r110, Object r111, Object r112) {
        DocMetaInfo r100 = (DocMetaInfo) r110;
        DocPermission r101 = (DocPermission) r111;
        DocVersion r102 = (DocVersion) r112;
        Intrinsics.checkNotNullParameter(r100, "meta");
        Intrinsics.checkNotNullParameter(r101, "perm");
        Intrinsics.checkNotNullParameter(r102, "ownerType");
        return new DocumentInfo(r100, r101, r102, this.f557786a, this.f557787b, this.f557788c, null, 64, null);
    }
}
