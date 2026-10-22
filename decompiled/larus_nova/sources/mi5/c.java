package mi5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f514074a;

    public c(a r100) {
        this.f514074a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ShareDocInfo r101 = (ShareDocInfo) r100;
        ShareDocInfo r102 = this.f514074a.b();
        if (r102 == null) goto L5;
        String r103 = this.f514074a.f514071c.getUrl();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f234243b = r103;
    L5:
        ShareDocInfo r104 = this.f514074a.b();
        if (r104 == null) goto L8;
        String r105 = this.f514074a.f514071c.getToken();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f234244c = r105;
    L8:
        ShareDocInfo r106 = this.f514074a.b();
        if (r106 == null) goto L11;
        r106.f234242a = this.f514074a.f514071c.getType();
    L11:
        ShareDocInfo r107 = this.f514074a.b();
        if (r107 == null) goto L14;
        DocVersion r108 = r101.f234245d;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f234245d = r108;
    L14:
        ShareDocInfo r109 = this.f514074a.b();
        if (r109 == null) goto L17;
        DocMetaInfo r110 = r101.f234246e;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f234246e = r110;
    L17:
        ShareDocInfo r111 = this.f514074a.b();
        if (r111 == null) goto L20;
        IDocUserPermission r112 = r101.f234247f;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r111.f234247f = r112;
    L20:
        ShareDocInfo r113 = this.f514074a.b();
        if (r113 == null) goto L23;
        r113.f234250i = true;
    L23:
        ShareDocInfo r114 = this.f514074a.b();
        if (r114 == null) goto L26;
        r114.f234251j = false;
    L26:
        a r115 = this.f514074a;
        r115.c(r115.b());
    }
}
