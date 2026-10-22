package mi5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ShareDocInfo r5 = (ShareDocInfo) r4;
        ShareDocInfo r0 = this.a.b();
        if (r0 == null) goto L5;
        String r2 = this.a.c.getUrl();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.b = r2;
    L5:
        ShareDocInfo r1 = this.a.b();
        if (r1 == null) goto L8;
        String r3 = this.a.c.getToken();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.c = r3;
    L8:
        ShareDocInfo r6 = this.a.b();
        if (r6 == null) goto L11;
        r6.a = this.a.c.getType();
    L11:
        ShareDocInfo r7 = this.a.b();
        if (r7 == null) goto L14;
        DocVersion r8 = r5.d;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.d = r8;
    L14:
        ShareDocInfo r9 = this.a.b();
        if (r9 == null) goto L17;
        DocMetaInfo r10 = r5.e;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.e = r10;
    L17:
        ShareDocInfo r11 = this.a.b();
        if (r11 == null) goto L20;
        IDocUserPermission r12 = r5.f;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.f = r12;
    L20:
        ShareDocInfo r13 = this.a.b();
        if (r13 == null) goto L23;
        r13.i = true;
    L23:
        ShareDocInfo r14 = this.a.b();
        if (r14 == null) goto L26;
        r14.j = false;
    L26:
        a r15 = this.a;
        r15.c(r15.b());
    }
}
