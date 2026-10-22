package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.b0;
import com.bytedance.ee.bear.lark.z;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;
import lc5.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements cc5.c {
    public final BitableTabFragmentV2 a;

    public static final class a {
    }

    static {
    }

    @Override // cc5.c
    public final void Bk(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public c(BitableTabFragmentV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "tabFragment");
        this.a = r2;
    }

    public final void t40(TabAppInfo r3, com.ss.android.lark.maintab.export.d r4) {
        Intrinsics.checkNotNullParameter(r3, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r4, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
        z.b().getClass();
        z.a(new String[]{"key_open_finish_recent"});
        ((b0) ApiUtils.getApi(b0.class)).preloadDocSdk(0);
        x.c().h("doc_sdk_init");
        vs4.z r5 = this.a.i;
        r5.a = System.currentTimeMillis();
        BitableTabFragmentV2 r6 = this.a;
        d r0 = new d(r4, this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "controller");
        Intrinsics.checkNotNullParameter(r0, "searchDelegate");
        r6.m = r4;
        r6.n = new j(r0, r6);
    }
}
