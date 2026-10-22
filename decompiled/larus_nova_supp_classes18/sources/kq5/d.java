package kq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final Pair<c, WikiRelation> a(c r1, WikiRelation r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "relation");
        return new Pair(r1, r2);
    }
}
