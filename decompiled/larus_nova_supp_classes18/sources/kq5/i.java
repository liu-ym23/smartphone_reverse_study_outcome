package kq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T, R> implements Function {
    public static final i<T, R> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        TreeNode r3 = (TreeNode) r2;
        Intrinsics.checkNotNullParameter(r3, "node");
        String r0 = r3.wiki_token;
        if (r3.has_child == false) goto L5;
    L9:
        boolean r4 = true;
    L11:
        return Boolean.valueOf(r4);
    L5:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(r0) == false) goto L7;
    L8:
        r4 = false;
        goto L11
    L7:
        if (TextUtils.equals("wikiroot%top_wiki_token", r0) == false) goto L9;
        goto L8
    }
}
