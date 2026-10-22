package ct4;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ct4.a f465351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465352b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        ay4.b.d(DocumentType.BITABLE_NAME, 4).putJSONObject(this.f465352b, this.f465351a);
    }

    public f(com.bytedance.ee.bear.bitable.core.infoarch.f r100) {
        Intrinsics.checkNotNullParameter(r100, "archManager");
        String r101 = "baseBizCache" + r100.b();
        this.f465352b = r101;
        ct4.a r102 = (ct4.a) ay4.b.d(DocumentType.BITABLE_NAME, 4).getJSONObject(r101, ct4.a.class);
        if (r102 != null) goto L5;
        r102 = new ct4.a();
    L5:
        this.f465351a = r102;
    }
}
