package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public ShareDocInfo a;
    public final ShareParams b;
    public final Context c;
    public final Function0<Unit> d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.c;
    }

    public f(ShareDocInfo r2, ShareParams r3, Context r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dismissDialog");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
