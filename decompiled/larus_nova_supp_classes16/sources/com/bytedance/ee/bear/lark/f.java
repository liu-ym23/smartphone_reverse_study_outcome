package com.bytedance.ee.bear.lark;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.b0;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements cc5.c {
    public final DocTabFragment a;

    public static final class a {
    }

    static {
    }

    @Override // cc5.c
    public final void Bk(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public f(DocTabFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "docTabFragment");
        this.a = r2;
    }

    public final void t40(TabAppInfo r2, com.ss.android.lark.maintab.export.d r3) {
        Intrinsics.checkNotNullParameter(r2, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r3, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
        this.a.V90();
        ((b0) ApiUtils.getApi(b0.class)).preloadDocSdk(0);
        lc5.x.c().h("doc_sdk_init");
        DocTabFragment r4 = this.a;
        g r0 = new g(r3, this);
        r4.h = r3;
        r4.k = new i(r4, r0);
        int r5 = com.ss.android.lark.utils.s.a;
        new String[]{"doc"};
        Observable.just(Boolean.TRUE).subscribe(h.a);
    }
}
