package kj5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.document.a4;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements a4 {
    public final boolean a(int r1) {
        return false;
    }

    public final boolean c(String r1) {
        return false;
    }

    public final String d() {
        return "";
    }

    public final boolean e(int r1) {
        return false;
    }

    public c() {
    }

    public final Flowable<DocMetaInfo> b(String r45, int r46) {
        if (r45 != null) goto L5;
        String r1 = "";
    L7:
        if (r45 != null) goto L9;
        String r30 = "";
    L11:
        return Flowable.just(new DocMetaInfo(r1, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, r30, 0, null, 0, null, null, null, null, 0, -536870914, 63, null));
    L9:
        r30 = r45;
        goto L11
    L5:
        r1 = r45;
        goto L7
    }
}
