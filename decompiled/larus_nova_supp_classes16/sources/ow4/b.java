package ow4;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.lark.dependency.k;
import io.reactivex.Flowable;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements a4 {
    public b() {
    }

    @Override // com.bytedance.ee.bear.document.a4
    public final String d() {
        return a.a;
    }

    @Override // com.bytedance.ee.bear.document.a4
    public final boolean a(int r4) {
        boolean r0 = ((k) org.koin.java.a.a(k.class)).d();
        if (r4 != e.i.b) goto L9;
        if (r0 == false) goto L9;
        boolean r5 = c.a.a.i("ccm.spacekit.bitable.enable", true);
    L7:
        return !r5;
    L9:
        if (r4 != e.k.b) goto L11;
        r5 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).x();
        goto L7
    L11:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.a4
    public final boolean c(String r1) {
        return lbb.a.a(r1);
    }

    @Override // com.bytedance.ee.bear.document.a4
    public final boolean e(int r1) {
        return a.b(r1);
    }

    @Override // com.bytedance.ee.bear.document.a4
    public final Flowable<DocMetaInfo> b(String r2, int r3) {
        int r0 = t05.a.a;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return t05.a.a(r2, r3);
    }
}
