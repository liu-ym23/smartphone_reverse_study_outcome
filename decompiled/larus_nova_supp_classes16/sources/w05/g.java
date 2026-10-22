package w05;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T1, T2, T3, R> implements Function3 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public g(String r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r11, Object r12, Object r13) {
        DocMetaInfo r1 = (DocMetaInfo) r11;
        DocPermission r2 = (DocPermission) r12;
        DocVersion r3 = (DocVersion) r13;
        Intrinsics.checkNotNullParameter(r1, "meta");
        Intrinsics.checkNotNullParameter(r2, "perm");
        Intrinsics.checkNotNullParameter(r3, "ownerType");
        return new DocumentInfo(r1, r2, r3, this.a, this.b, this.c, null, 64, null);
    }
}
