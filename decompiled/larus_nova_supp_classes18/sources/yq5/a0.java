package yq5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 {
    public static final z a(WikiInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        z r0 = new z();
        r0.b = r2.getWikiToken();
        r0.c = r2.getObjToken();
        r0.d = r2.getObjType();
        r0.e = r2.getInSpace();
        r0.g = r2.log_id;
        return r0;
    }
}
