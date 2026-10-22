package kq5;

import android.text.TextUtils;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T, R> f505594a = null;

    static {
        f505594a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r100;
        Intrinsics.checkNotNullParameter(r101, "node");
        if (r101.f241923k == true) goto L10;
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(r101.f241914b) == true) goto L11;
        if (TextUtils.equals("wikiroot%top_wiki_token", r101.f241914b) == false) goto L10;
    L11:
        return Boolean.TRUE;
    L10:
        return Boolean.FALSE;
    }
}
