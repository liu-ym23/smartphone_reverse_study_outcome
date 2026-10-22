package yq5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 {
    public static final z a(WikiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        z r101 = new z();
        r101.f568852b = r100.getWikiToken();
        r101.f568853c = r100.getObjToken();
        r101.f568854d = r100.getObjType();
        r101.f568855e = r100.getInSpace();
        r101.f568857g = r100.log_id;
        return r101;
    }
}
