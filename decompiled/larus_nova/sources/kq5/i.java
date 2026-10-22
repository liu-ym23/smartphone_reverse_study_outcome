package kq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T, R> f505596a = null;

    static {
        f505596a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        TreeNode r101 = (TreeNode) r100;
        Intrinsics.checkNotNullParameter(r101, "node");
        String r102 = r101.wiki_token;
        if (r101.has_child == false) goto L5;
    L9:
        boolean r103 = true;
    L11:
        return Boolean.valueOf(r103);
    L5:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(r102) == false) goto L7;
    L8:
        r103 = false;
        goto L11
    L7:
        if (TextUtils.equals("wikiroot%top_wiki_token", r102) == false) goto L9;
        goto L8
    }
}
