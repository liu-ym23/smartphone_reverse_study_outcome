package iq5;

import android.os.Bundle;
import com.bytedance.ee.bear.route.PostCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class z {
    public static final void a(td5.f r100, PostCard r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "postCard");
        Integer r102 = r100.f545516a;
        if (r102 == null) goto L5;
        r101.j("EXTRA_PAGE_MODE", r102.intValue());
    L5:
        Integer r103 = r100.f545517b;
        if (r103 == null) goto L8;
        r101.j("createDocumentType", r103.intValue());
    L8:
        String r104 = r100.f545518c;
        if (r104 == null) goto L11;
        r101.i("trigger_location", r104);
    L11:
        Boolean r105 = r100.f545521f;
        if (r105 == null) goto L14;
        r101.l("extra_is_at_vc", r105.booleanValue());
    L14:
        String r106 = r100.f545519d;
        if (r106 == null) goto L17;
        r101.i("extra_collection_id", r106);
    L17:
        Bundle r107 = r100.f545522g;
        if (r107 == null) goto L20;
        r101.h(r107);
    L20:
        Integer r108 = r100.f545520e;
        if (r108 == null) goto L24;
        r101.k(r108.intValue());
        return;
    }
}
