package kq5;

import android.text.TextUtils;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T, R> implements Function {
    public static final g<T, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r2;
        Intrinsics.checkNotNullParameter(r3, "node");
        if (r3.k == true) goto L10;
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(r3.b) == true) goto L11;
        if (TextUtils.equals("wikiroot%top_wiki_token", r3.b) == false) goto L10;
    L11:
        return Boolean.TRUE;
    L10:
        return Boolean.FALSE;
    }
}
