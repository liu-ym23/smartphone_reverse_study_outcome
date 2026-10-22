package com.bytedance.ee.bear.integrator.wiki;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.b0;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.s;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements cc5.c {
    public final WikiMainTabFragment a;

    public static final class a {
    }

    static {
    }

    @Override // cc5.c
    public final void Bk(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public c(WikiMainTabFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "wikiTabFragment");
        this.a = r2;
    }

    public final void t40(TabAppInfo r2, com.ss.android.lark.maintab.export.d r3) {
        Intrinsics.checkNotNullParameter(r2, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r3, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
        ((b0) ApiUtils.getApi(b0.class)).preloadDocSdk(0);
        int r4 = s.a;
        new String[]{"doc"};
        Observable.just(Boolean.TRUE).subscribe(d.a);
        WikiMainTabFragment r5 = this.a;
        r5.l = r3;
        r5.j = new e(r3);
    }
}
