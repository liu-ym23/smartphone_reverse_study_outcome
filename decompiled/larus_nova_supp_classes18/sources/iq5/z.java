package iq5;

import android.os.Bundle;
import com.bytedance.ee.bear.route.PostCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z {
    public static final void a(td5.f r2, PostCard r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "postCard");
        Integer r0 = r2.a;
        if (r0 == null) goto L5;
        r3.j("EXTRA_PAGE_MODE", r0.intValue());
    L5:
        Integer r1 = r2.b;
        if (r1 == null) goto L8;
        r3.j("createDocumentType", r1.intValue());
    L8:
        String r4 = r2.c;
        if (r4 == null) goto L11;
        r3.i("trigger_location", r4);
    L11:
        Boolean r5 = r2.f;
        if (r5 == null) goto L14;
        r3.l("extra_is_at_vc", r5.booleanValue());
    L14:
        String r6 = r2.d;
        if (r6 == null) goto L17;
        r3.i("extra_collection_id", r6);
    L17:
        Bundle r7 = r2.g;
        if (r7 == null) goto L20;
        r3.h(r7);
    L20:
        Integer r8 = r2.e;
        if (r8 == null) goto L24;
        r3.k(r8.intValue());
        return;
    }
}
